/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.AccountSession;
import DTO.Greeting;
import DTO.MessageDTO;
import DTO.PackageDTO;
import Interface.Service.CommonService;
import Interface.Service.ErrorService;
import Interface.Service.MessageService;
import Interface.Service.PackageService;
import Interface.Service.ProviderService;
import Interface.Service.TripperService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.FileOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Nick
 */
@Controller
@RequestMapping("/Message")
public class MessageController {

    @Autowired
    SimpMessagingTemplate template;

    @Autowired
    MessageService messageService;

    @Autowired
    ProviderService providerService;

    @Autowired
    TripperService tripperService;

    @Autowired
    CommonService commonService;

    @Autowired
    ErrorService errorService;

    @Autowired
    PackageService packageService;

    @RequestMapping("/index.htm")
    public String goToIndexPage() {
        return "index";
    }

    @RequestMapping(value = "/Chat")
    public String goToChatPage(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();
            String conversationList = "";
            if (request.getAttribute("conversationID") != null || !request.getAttribute("conversationID").equals("")) {
                String conID = (String) request.getAttribute("conversationID");
                request.setAttribute("conversationID", conID);
            }
            if (session != null) {
                AccountSession account = (AccountSession) session.getAttribute("account");
                if (providerService.isProvider(account)) {
                    conversationList = messageService.getListConversationbyProviderID(account.getId());
                } else if (tripperService.isUser(account)) {
                    conversationList = messageService.getListConversationbyTripperID(account.getId());

                }
                request.setAttribute("conversationList", conversationList);
            }
            return "chat";
        } catch (Exception e) {
            HttpSession session = request.getSession();
            String content = "Function: MessageController - goToChatPage\n"
                    + "***Input***\n"
                    + "conversationID: " + (String) request.getAttribute("conversationID") + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @MessageMapping("/hello/package/{id}")
    @SendTo("/topic/package/{id}")
    public void greeting(MessageDTO message, @DestinationVariable String id) {
        try {
            boolean flag = false;
            if (message.getContent().equals("SeenMessage")) {
                if (message.getUserType() == 1) {
                    messageService.tripperReadBooking(message.getName());
                } else {
                    messageService.providerReadBooking(message.getName());
                }
                flag = true;
            } else if (message.getUserType() == 2) {
                messageService.sendBookingMessage("{\"content\":\"" + message.getContent() + "\",\"type\":\"text\"}", "provider", message.getUserID(), id);
                int tripperID = 0;
                try {
                    tripperID = messageService.getTripperIDByBookingCode(id);
                } catch (Exception e) {
                    tripperID = 0;
                }
                template.convertAndSend("/topic/getUnReadBookingForTripper/" + tripperID, new Greeting("{\"Type\":\"conversation\",\"conversationID\":\"" + id + "\"}"));
                //Get package Name
                PackageDTO packageResult = packageService.getPackageName(id);
                //Send Notification message                    
                boolean notifyForTripper = tripperService.insertNewTripperSystemNotification("{\"URL\":\"Tripper/ChatWithProvider/" + tripperID + "/" + id + "\",\"Message\":\"You have a new message in Booking: " + packageResult.getName() + " \"}", false, tripperID);
                String tripperNoti = tripperService.getTripperNewNotification(tripperID);
                template.convertAndSend("/topic/Notifications/Tripper/" + tripperID, tripperNoti);
                flag = true;
            } else if (message.getUserType() == 1) {
                messageService.sendBookingMessage("{\"content\":\"" + message.getContent() + "\",\"type\":\"text\"}", "tripper", message.getUserID(), id);
                int providerID = 0;
                try {
                    providerID = messageService.getProviderIDByBookingCode(id);
                } catch (Exception e) {
                    providerID = 0;
                }
                template.convertAndSend("/topic/getUnReadBookingForProvider/" + providerID, new Greeting("{\"Type\":\"conversation\",\"conversationID\":\"" + id + "\"}"));
                //Get package Name
                PackageDTO packageResult = packageService.getPackageName(id);
                //Send Notification message                 
                boolean notifyForProvider = providerService.insertNewProviderSystemNotification("{\"URL\":\"Provider/Chat\",\"Message\":\"You have a new message in Booking: " + packageResult.getName() + " \"}", false, providerID);
                String providerNoti = providerService.getProviderNewNotification(providerID);
                template.convertAndSend("/topic/Notifications/Provider/" + providerID, providerNoti);
                flag = true;
            }
            if (flag) {
                template.convertAndSend("/topic/package/" + id, new Greeting("{\"Type\":\"booking\",\"conversationID\":\"" + id + "\"}"));
            }

        } catch (Exception e) {

            String content = "Function: MessageController - greeting\n"
                    + "***Input***\n"
                    + "id: " + id + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, null, e);
        }
    }

    @MessageMapping("/hello/chatting/{id}")
    @SendTo("/topic/chatting/{id}")
    public void chatting(MessageDTO message, @DestinationVariable int id) {
        try {
            boolean flag = false;
            int currenttripperID = 0;

            if (message.getContent().equals("SeenMessage")) {
                if (message.getUserType() == 1) {
                    messageService.tripperReadConv(Integer.valueOf(message.getName()), message.getUserID());
                } else {
                    messageService.providerReadConv(Integer.valueOf(message.getName()));
                }
                flag = true;
                if (flag) {
                    template.convertAndSend("/topic/chatting/" + id, new Greeting("{\"Type\":\"conversation\",\"conversationID\":\"" + id + "\",\"replyToTripperID\":\"" + 0 + "\"}"));
                }
            } else {
                if (message.getUserType() == 2) {
                    messageService.sendConversationMessage("{\"content\":\"" + message.getContent() + "\",\"type\":\"text\"}", "provider", message.getUserID(), id);
                    int tripperID = 0;
                    try {
                        tripperID = messageService.getTripperIDByConversationID(id);
                    } catch (Exception e) {
                        tripperID = 0;
                    }
                    //Update for tripper
                    template.convertAndSend("/topic/getUnReadConvForTripper/" + tripperID, new Greeting("{\"Type\":\"conversation\",\"conversationID\":\"" + id + "\"}"));
                    //Get package Name
                    PackageDTO packageResult = packageService.getPackageName(id);
                    //Send Notification message                    
                    boolean notifyForTripper = tripperService.insertNewTripperSystemNotification("{\"URL\":\"Tripper/ChatWithProvider/" + tripperID + "/" + id + "\",\"Message\":\"You have a new message in trip " + packageResult.getName() + " \"}", false, tripperID);
                    String tripperNoti = tripperService.getTripperNewNotification(tripperID);
                    template.convertAndSend("/topic/Notifications/Tripper/" + tripperID, tripperNoti);
                    flag = true;
                } else if (message.getUserType() == 1) {
                    currenttripperID = message.getUserID();
                    messageService.sendConversationMessage("{\"content\":\"" + message.getContent() + "\",\"type\":\"text\"}", "tripper", message.getUserID(), id);
                    int providerID = 0;
                    try {
                        providerID = messageService.getProviderIDByConversationID(id);
                    } catch (Exception e) {
                        providerID = 0;
                    }
                    template.convertAndSend("/topic/getUnReadConvForProvider/" + providerID, new Greeting("{\"Type\":\"conversation\",\"conversationID\":\"" + id + "\"}"));
                    //Get package Name
                    PackageDTO packageResult = packageService.getPackageName(id);
                    //Send Notification message                 
                    boolean notifyForProvider = providerService.insertNewProviderSystemNotification("{\"URL\":\"Provider/Chat\",\"Message\":\"You have a new message in Package " + packageResult.getName() + " \"}", false, providerID);
                    String providerNoti = providerService.getProviderNewNotification(providerID);
                    template.convertAndSend("/topic/Notifications/Provider/" + providerID, providerNoti);
                    flag = true;
                }
                if (flag) {

                    template.convertAndSend("/topic/chatting/" + id, new Greeting("{\"Type\":\"conversation\",\"conversationID\":\"" + id + "\",\"replyToTripperID\":\"" + currenttripperID + "\"}"));
                }
            }

        } catch (Exception e) {
            String content = "Function: MessageController - chatting\n"
                    + "***Input***\n"
                    + "id: " + id + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, null, e);
        }
    }

    /**
     *
     * @param session
     * @param userid
     * @return
     */
    @RequestMapping(value = "/getBookingList/{userid}", method = RequestMethod.GET)
    public @ResponseBody
    String getBookingList(HttpSession session, @PathVariable int userid) {
        try {
            Gson gson = new Gson();
            AccountSession account = (AccountSession) session.getAttribute("account");
            if (providerService.isProvider(account)) {
                return gson.toJson(messageService.getBookingListByProviderID(userid));
            }
            return gson.toJson(messageService.getBookingListByTripperID(userid));
        } catch (Exception e) {
            String content = "Function: MessageController - getBookingList\n"
                    + "***Input***\n"
                    + "userid: " + userid + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/getConversationList/{userid}", method = RequestMethod.GET)
    public @ResponseBody
    String getConversationList(HttpSession session, @PathVariable int userid) {
        try {
            Gson gson = new Gson();
            AccountSession account = (AccountSession) session.getAttribute("account");
            if (providerService.isProvider(account)) {
                return messageService.getListConversationbyProviderID(userid);
            }
            return messageService.getListConversationbyTripperID(userid);
        } catch (Exception e) {
            String content = "Function: MessageController - getConversationList\n"
                    + "***Input***\n"
                    + "userid: " + userid + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/getBookingMessage/{numberOfRecord}/{bookingID}", method = RequestMethod.GET)
    public @ResponseBody
    String getBookingMessage(HttpSession session, @PathVariable String bookingID, @PathVariable int numberOfRecord) {
        try {
            Gson gson = new Gson();
            return gson.toJson(messageService.getBookingMessageByBookingID(bookingID, numberOfRecord));
        } catch (Exception e) {
            String content = "Function: MessageController - getBookingMessage\n"
                    + "***Input***\n"
                    + "bookingID: " + bookingID + "\n"
                    + "numberOfRecord: " + numberOfRecord + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }
//New load conversation messenger
    @RequestMapping(value = "/getConversationMessage", method = RequestMethod.POST)
    public @ResponseBody
    String getConversationMessage(HttpSession session, @RequestBody final String data) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
            int conversationID = jsonObject.get("conversationID").getAsInt();
            int numberOfRecord = jsonObject.get("NumberOfRecords").getAsInt();
            String time = jsonObject.get("time").getAsString();
            String userType = "";
            if(providerService.isProvider(account)){
                userType = "provider";
            }else if(tripperService.isUser(account)){
                userType = "tripper";
            }
            return messageService.getConvMessage(conversationID,userType, numberOfRecord,time);
        } catch (Exception e) {
            String content = "Function: MessageController - getConversationMessage\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Image/Booking/upload", method = RequestMethod.POST)
    public @ResponseBody
    String uploadImageForBooking(@RequestParam("uploadImage") MultipartFile uploadImage, HttpSession session, @RequestParam("bookingID") String bookingID) {
        try {
            String path = System.getProperty("catalina.base");
            File folderPackage = new File(path + "/webapps/Chat/Upload/" + bookingID);
            if (!folderPackage.exists()) {
                folderPackage.mkdirs();
            }
            String name = uploadImage.getOriginalFilename();
            FileCopyUtils.copy(uploadImage.getBytes(), new FileOutputStream(new File(folderPackage, name)));
            Gson gson = new Gson();
            if (session != null) {

                AccountSession account = (AccountSession) session.getAttribute("account");
                if (providerService.isProvider(account)) {
                    gson.toJson(messageService.sendBookingMessage("{\"content\":\"" + "/Chat/Upload/" + bookingID + "/" + name + "\",\"type\":\"image\"}", "provider", account.getId(), bookingID));
                    int tripperID;
                    try {
                        tripperID = messageService.getTripperIDByBookingCode(bookingID);
                    } catch (Exception e) {
                        tripperID = 0;
                    }
                    template.convertAndSend("/topic/getUnReadBookingForTripper/" + tripperID, new Greeting("{\"Type\":\"conversation\",\"conversationID\":\"" + bookingID + "\"}"));
                } else if (tripperService.isUser(account)) {
                    gson.toJson(messageService.sendBookingMessage("{\"content\":\"" + "/Chat/Upload/" + bookingID + "/" + name + "\",\"type\":\"image\"}", "tripper", account.getId(), bookingID));
                    int providerID;
                    try {
                        providerID = messageService.getProviderIDByBookingCode(bookingID);
                    } catch (Exception e) {
                        providerID = 0;
                    }
                    template.convertAndSend("/topic/getUnReadBookingForProvider/" + providerID, new Greeting("{\"Type\":\"conversation\",\"conversationID\":\"" + bookingID + "\"}"));
                }
                template.convertAndSend("/topic/package/" + bookingID, new Greeting("{\"Type\":\"booking\",\"conversationID\":\"" + bookingID + "\"}"));
            }
            return "/Chat/Upload/" + bookingID + "/" + name;
        } catch (Exception e) {
            String content = "Function: MessageController - uploadImageForBooking\n"
                    + "***Input***\n"
                    + "bookingID: " + bookingID + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Image/Conversation/upload", method = RequestMethod.POST)
    public @ResponseBody
    String uploadImageForConversation(@RequestParam("uploadImage") MultipartFile uploadImage, HttpSession session, @RequestParam("conversationID") String bookingID, @RequestParam("replyToTripperID") int replyToTripperID) {
        try {
            String path = System.getProperty("catalina.base");
            File folderPackage = new File(path + "/webapps/Conversation/Upload/" + bookingID);
            if (!folderPackage.exists()) {
                folderPackage.mkdirs();
            }
            String name = uploadImage.getOriginalFilename();
            FileCopyUtils.copy(uploadImage.getBytes(), new FileOutputStream(new File(folderPackage, name)));
            Gson gson = new Gson();
            if (session != null) {

                AccountSession account = (AccountSession) session.getAttribute("account");
                if (providerService.isProvider(account)) {
                    gson.toJson(messageService.sendConversationMessage("{\"content\":\"" + "/Conversation/Upload/" + bookingID + "/" + name + "\",\"type\":\"image\",\"filename\":\"" + name + "\"}", "provider", account.getId(), Integer.valueOf(bookingID), replyToTripperID));
                    int tripperID;
                    try {
                        tripperID = messageService.getTripperIDByConversationID(Integer.valueOf(bookingID));
                    } catch (Exception e) {
                        tripperID = 0;
                    }
                    template.convertAndSend("/topic/getUnReadConvForTripper/" + tripperID, new Greeting("{\"Type\":\"conversation\",\"conversationID\":\"" + bookingID + "\"}"));
                } else if (tripperService.isUser(account)) {
                    gson.toJson(messageService.sendConversationMessage("{\"content\":\"" + "/Conversation/Upload/" + bookingID + "/" + name + "\",\"type\":\"image\",\"filename\":\"" + name + "\"}", "tripper", account.getId(), Integer.valueOf(bookingID), replyToTripperID));
                    int providerID;
                    try {
                        providerID = messageService.getProviderIDByConversationID(Integer.valueOf(bookingID));
                    } catch (Exception e) {
                        providerID = 0;
                    }
                    template.convertAndSend("/topic/getUnReadConvForProvider/" + providerID, new Greeting("{\"Type\":\"conversation\",\"conversationID\":\"" + bookingID + "\"}"));
                }
                template.convertAndSend("/topic/chatting/" + bookingID, new Greeting("{\"Type\":\"conversation\",\"conversationID\":\"" + bookingID + "\"}"));
            }
            return "/Conversation/Upload/" + bookingID + "/" + name;
        } catch (Exception e) {
            String content = "Function: MessageController - uploadImageForConversation\n"
                    + "***Input***\n"
                    + "bookingID: " + bookingID + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/File/Booking/upload", method = RequestMethod.POST)
    public @ResponseBody
    String uploadFileForBooking(@RequestParam("uploadFile") MultipartFile uploadFile, HttpSession session, @RequestParam("bookingID") String bookingID) {
        try {
            String path = System.getProperty("catalina.base");
            File folderPackage = new File(path + "/webapps/Chat/Upload/" + bookingID);
            if (!folderPackage.exists()) {
                folderPackage.mkdirs();
            }
            String name = uploadFile.getOriginalFilename();
            FileCopyUtils.copy(uploadFile.getBytes(), new FileOutputStream(new File(folderPackage, name)));
            Gson gson = new Gson();
            if (session != null) {
                if (FilenameUtils.getExtension(uploadFile.getOriginalFilename()).equals("png") || FilenameUtils.getExtension(uploadFile.getOriginalFilename()).equals("jpg") || FilenameUtils.getExtension(uploadFile.getOriginalFilename()).equals("gif")) {
                    AccountSession account = (AccountSession) session.getAttribute("account");
                    if (providerService.isProvider(account)) {
                        gson.toJson(messageService.sendBookingMessage("{\"content\":\"" + "/Chat/Upload/" + bookingID + "/" + name + "\",\"type\":\"image\",\"filename\":\"" + name + "\"}", "provider", account.getId(), bookingID));
                        int tripperID;
                        try {
                            tripperID = messageService.getTripperIDByBookingCode(bookingID);
                        } catch (Exception e) {
                            tripperID = 0;
                        }
                        template.convertAndSend("/topic/getUnReadBookingForTripper/" + tripperID, new Greeting("{\"Type\":\"conversation\",\"conversationID\":\"" + bookingID + "\"}"));
                    } else if (tripperService.isUser(account)) {
                        gson.toJson(messageService.sendBookingMessage("{\"content\":\"" + "/Chat/Upload/" + bookingID + "/" + name + "\",\"type\":\"image\",\"filename\":\"" + name + "\"}", "tripper", account.getId(), bookingID));
                        int providerID;
                        try {
                            providerID = messageService.getProviderIDByBookingCode(bookingID);
                        } catch (Exception e) {
                            providerID = 0;
                        }
                        template.convertAndSend("/topic/getUnReadBookingForProvider/" + providerID, new Greeting("{\"Type\":\"conversation\",\"conversationID\":\"" + bookingID + "\"}"));
                    }
                    template.convertAndSend("/topic/package/" + bookingID, new Greeting("{\"Type\":\"booking\",\"conversationID\":\"" + bookingID + "\"}"));
                } else {
                    AccountSession account = (AccountSession) session.getAttribute("account");
                    if (providerService.isProvider(account)) {
                        gson.toJson(messageService.sendBookingMessage("{\"content\":\"" + "/Chat/Upload/" + bookingID + "/" + name + "\",\"type\":\"file\",\"filename\":\"" + name + "\"}", "provider", account.getId(), bookingID));
                        int tripperID;
                        try {
                            tripperID = messageService.getTripperIDByBookingCode(bookingID);
                        } catch (Exception e) {
                            tripperID = 0;
                        }
                        template.convertAndSend("/topic/getUnReadBookingForTripper/" + tripperID, new Greeting("{\"Type\":\"conversation\",\"conversationID\":\"" + bookingID + "\"}"));
                    } else if (tripperService.isUser(account)) {
                        gson.toJson(messageService.sendBookingMessage("{\"content\":\"" + "/Chat/Upload/" + bookingID + "/" + name + "\",\"type\":\"file\",\"filename\":\"" + name + "\"}", "tripper", account.getId(), bookingID));
                        int providerID;
                        try {
                            providerID = messageService.getProviderIDByBookingCode(bookingID);
                        } catch (Exception e) {
                            providerID = 0;
                        }
                        template.convertAndSend("/topic/getUnReadBookingForProvider/" + providerID, new Greeting("{\"Type\":\"conversation\",\"conversationID\":\"" + bookingID + "\"}"));
                    }
                    template.convertAndSend("/topic/package/" + bookingID, new Greeting("{\"Type\":\"booking\",\"conversationID\":\"" + bookingID + "\"}"));
                }
            }
            return "/Chat/Upload/" + bookingID + "/" + name;
        } catch (Exception e) {
            String content = "Function: MessageController - uploadFileForBooking\n"
                    + "***Input***\n"
                    + "bookingID: " + bookingID + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/File/Conversation/upload", method = RequestMethod.POST)
    public @ResponseBody
    String uploadFileForConversation(@RequestParam("uploadFile") MultipartFile uploadFile, HttpSession session, @RequestParam("conversationID") String bookingID, @RequestParam("replyToTripperID") int replyToTripperID) {
        try {
            String path = System.getProperty("catalina.base");
            File folderPackage = new File(path + "/webapps/Conversation/Upload/" + bookingID);
            if (!folderPackage.exists()) {
                folderPackage.mkdirs();
            }
            String name = uploadFile.getOriginalFilename();
            FileCopyUtils.copy(uploadFile.getBytes(), new FileOutputStream(new File(folderPackage, name)));
            Gson gson = new Gson();
            if (session != null) {
                if (FilenameUtils.getExtension(uploadFile.getOriginalFilename()).equals("png") || FilenameUtils.getExtension(uploadFile.getOriginalFilename()).equals("jpg") || FilenameUtils.getExtension(uploadFile.getOriginalFilename()).equals("gif")) {
                    AccountSession account = (AccountSession) session.getAttribute("account");
                    if (providerService.isProvider(account)) {
                        gson.toJson(messageService.sendConversationMessage("{\"content\":\"" + "/Conversation/Upload/" + bookingID + "/" + name + "\",\"type\":\"image\",\"filename\":\"" + name + "\"}", "provider", account.getId(), Integer.valueOf(bookingID), replyToTripperID));
                        int tripperID;
                        try {
                            tripperID = messageService.getTripperIDByConversationID(Integer.valueOf(bookingID));
                        } catch (Exception e) {
                            tripperID = 0;
                        }
                        template.convertAndSend("/topic/getUnReadConvForTripper/" + tripperID, new Greeting("{\"Type\":\"conversation\",\"conversationID\":\"" + bookingID + "\"}"));
                    } else if (tripperService.isUser(account)) {
                        gson.toJson(messageService.sendConversationMessage("{\"content\":\"" + "/Conversation/Upload/" + bookingID + "/" + name + "\",\"type\":\"image\",\"filename\":\"" + name + "\"}", "tripper", account.getId(), Integer.valueOf(bookingID), replyToTripperID));
                        int providerID;
                        try {
                            providerID = messageService.getProviderIDByConversationID(Integer.valueOf(bookingID));
                        } catch (Exception e) {
                            providerID = 0;
                        }
                        template.convertAndSend("/topic/getUnReadConvForProvider/" + providerID, new Greeting("{\"Type\":\"conversation\",\"conversationID\":\"" + bookingID + "\"}"));
                    }
                    template.convertAndSend("/topic/chatting/" + bookingID, new Greeting("{\"Type\":\"conversation\",\"conversationID\":\"" + bookingID + "\"}"));
                } else {
                    AccountSession account = (AccountSession) session.getAttribute("account");
                    if (providerService.isProvider(account)) {
                        gson.toJson(messageService.sendConversationMessage("{\"content\":\"" + "/Conversation/Upload/" + bookingID + "/" + name + "\",\"type\":\"file\",\"filename\":\"" + name + "\"}", "provider", account.getId(), Integer.valueOf(bookingID), replyToTripperID));
                        int tripperID;
                        try {
                            tripperID = messageService.getTripperIDByConversationID(Integer.valueOf(bookingID));
                        } catch (Exception e) {
                            tripperID = 0;
                        }
                        template.convertAndSend("/topic/getUnReadConvForTripper/" + tripperID, new Greeting("{\"Type\":\"conversation\",\"conversationID\":\"" + bookingID + "\"}"));
                    } else if (tripperService.isUser(account)) {
                        gson.toJson(messageService.sendConversationMessage("{\"content\":\"" + "/Conversation/Upload/" + bookingID + "/" + name + "\",\"type\":\"file\",\"filename\":\"" + name + "\"}", "tripper", account.getId(), Integer.valueOf(bookingID), replyToTripperID));
                        int providerID;
                        try {
                            providerID = messageService.getProviderIDByConversationID(Integer.valueOf(bookingID));
                        } catch (Exception e) {
                            providerID = 0;
                        }
                        template.convertAndSend("/topic/getUnReadConvForProvider/" + providerID, new Greeting("{\"Type\":\"conversation\",\"conversationID\":\"" + bookingID + "\"}"));

                    }
                    template.convertAndSend("/topic/chatting/" + bookingID, new Greeting("{\"Type\":\"conversation\",\"conversationID\":\"" + bookingID + "\"}"));
                }
            }
            return "/Conversation/Upload/" + bookingID + "/" + name;
        } catch (Exception e) {
            String content = "Function: MessageController - uploadFileForConversation\n"
                    + "***Input***\n"
                    + "bookingID: " + bookingID + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @MessageMapping("/hello/getUnReadConvForTripper/{id}")
    @SendTo("/topic/getUnReadConvForTripper/{id}")
    public void getUnReadConvForTripper(MessageDTO message, @DestinationVariable String id) {
        try {

            template.convertAndSend("/topic/getUnReadConvForTripper/" + id, new Greeting("{\"Type\":\"booking\",\"conversationID\":\"" + id + "\"}"));

        } catch (Exception e) {

            String content = "Function: MessageController - getUnReadConvForTripper\n"
                    + "***Input***\n"
                    + "id: " + id + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, null, e);
        }
    }

    @MessageMapping("/hello/getUnReadBookingForTripper/{id}")
    @SendTo("/topic/getUnReadBookingForTripper/{id}")
    public void getUnReadBookingForTripper(MessageDTO message, @DestinationVariable String id) {
        try {
            template.convertAndSend("/topic/getUnReadBookingForTripper/" + id, new Greeting("{\"Type\":\"booking\",\"conversationID\":\"" + id + "\"}"));

        } catch (Exception e) {

            String content = "Function: MessageController - getUnReadBookingForTripper\n"
                    + "***Input***\n"
                    + "id: " + id + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, null, e);
        }
    }

    @MessageMapping("/hello/getUnReadConvForProvider/{id}")
    @SendTo("/topic/getUnReadConvForProvider/{id}")
    public void getUnReadConvForProvider(MessageDTO message, @DestinationVariable String id) {
        try {

            template.convertAndSend("/topic/getUnReadConvForProvider/" + id, new Greeting("{\"Type\":\"booking\",\"conversationID\":\"" + id + "\"}"));

        } catch (Exception e) {

            String content = "Function: MessageController - getUnReadConvForProvider\n"
                    + "***Input***\n"
                    + "id: " + id + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, null, e);
        }
    }

    @MessageMapping("/hello/getUnReadBookingForProvider/{id}")
    @SendTo("/topic/getUnReadBookingForProvider/{id}")
    public void getUnReadBookingForProvider(MessageDTO message, @DestinationVariable String id) {
        try {

            template.convertAndSend("/topic/getUnReadBookingForProvider/" + id, new Greeting("{\"Type\":\"booking\",\"conversationID\":\"" + id + "\"}"));

        } catch (Exception e) {

            String content = "Function: MessageController - getUnReadBookingForProvider\n"
                    + "***Input***\n"
                    + "id: " + id + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, null, e);
        }
    }

    @RequestMapping(value = "/ReadConv")
    public @ResponseBody
    String ReadConv(@RequestBody final String data, HttpServletRequest request) {
        try {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
            int conversationID = jsonObject.get("conversationID").getAsInt();
            int userType = jsonObject.get("userType").getAsInt();
            if (userType == 2) {
                messageService.providerReadConv(conversationID);
            } else {
//                messageService.tripperReadConv(conversationID);
            }

            return "zzz";
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: MessageController - ReadConv\n"
                    + "***Input***\n"
                    + "search: " + request.getParameter("search") + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/ReadBooking")
    public @ResponseBody
    String ReadBooking(@RequestBody final String data, HttpServletRequest request) {
        try {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
            String bookingID = jsonObject.get("bookingID").getAsString();
            int userType = jsonObject.get("userType").getAsInt();
            if (userType == 2) {
                messageService.providerReadBooking(bookingID);
            } else {
                messageService.tripperReadBooking(bookingID);
            }

            return "zzz";
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: MessageController - ReadBooking\n"
                    + "***Input***\n"
                    + "search: " + request.getParameter("search") + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/loadMoreConvMessage", method = RequestMethod.POST)
    public @ResponseBody
    String loadMoreConvMessage(HttpSession session, @RequestBody final String data) {
        int conversationID = 0;
        int numberOfRecord = 0;
        int tripperID = 0;
        try {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
            conversationID = jsonObject.get("conversationID").getAsInt();
            tripperID = jsonObject.get("replyToTripperID").getAsInt();
            numberOfRecord = jsonObject.get("numberOfRecord").getAsInt();
            String result = messageService.loadMoreMessage(conversationID, tripperID, numberOfRecord);
            return result;
        } catch (Exception e) {
            String content = "Function: MessageController - loadMoreConvMessage\n"
                    + "***Input***\n"
                    + "conversationID: " + conversationID + "\n"
                    + "tripperID: " + tripperID + "\n"
                    + "numberOfRecord: " + numberOfRecord + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    /*New Chat Functions*/
    @MessageMapping("/hello/sendChatMessage/{id}")
    @SendTo("/topic/sendChatMessage/{id}")
    public void sendChatMessage(MessageDTO message, @DestinationVariable int id) {
        try {
            //Insert Message into database
            String insertedMessage = messageService.sendConversationMessage(message.getContent(), "provider", message.getUserID(), id);
            //Send back to receiver
            template.convertAndSend("/topic/sendChatMessage/" + id, insertedMessage);
            //Update list of conversation

            template.convertAndSend("/topic/providerCheckListConversation/" + message.getUserID(), new Greeting("{\"Type\":\"conversation\",\"conversationID\":\"" + id + "\"}"));

        } catch (Exception e) {
            String content = "Function: MessageController - sendChatMessage\n"
                    + "***Input***\n"
                    + "id: " + id + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, null, e);
        }
    }

}
