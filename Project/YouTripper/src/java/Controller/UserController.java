/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.AccountSession;
import DTO.BookingDTO;
import DTO.CountryDTO;
import DTO.PackageDTO;
import DTO.PackagesViewDTO;
import DTO.TripperDTO;
import DTO.TripperNotification;
import DTO.TripperNotificationSetting;
import Interface.Service.CommonService;
import Interface.Service.ErrorService;
import Interface.Service.MessageService;
import Interface.Service.PackageService;
import Interface.Service.ProviderService;
import Interface.Service.TripperService;
import JavaClass.FileMeta;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.paypal.api.payments.Item;
import com.paypal.base.rest.PayPalRESTException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
@RequestMapping("/Tripper")
public class UserController {

    @Autowired
    SimpMessagingTemplate template;

    @Autowired
    CommonService commonService;

    @Autowired
    TripperService tripperService;

    @Autowired
    PackageService packageService;

    @Autowired
    MessageService messageService;

    @Autowired
    ProviderService providerService;

    @Autowired
    ErrorService errorService;

    @RequestMapping(value = "/Book")
    public String book(HttpServletRequest request) {
        boolean errorFlag = false;
        boolean loginFlag = false;

        if (request.getAttribute("message") != null) {
            errorFlag = true;
        }
        if (request.getAttribute("login") != null) {
            loginFlag = true;
        }
        HttpSession session = request.getSession();
        String url = "redirect:/Common";
        if (request.getParameter("language") != null) {
            url = "redirect:/Common" + "?language=" + request.getParameter("language");
        }
        String selectedDate = "";
        SimpleDateFormat fortmatMMddyyyy = new SimpleDateFormat("MM/dd/yyyy");
        try {
            if (errorFlag || loginFlag) {
                selectedDate = (request.getAttribute("selectedDate").toString());
            } else {
                selectedDate = request.getParameter("selectedDate");
            }
            Date chosenDate = fortmatMMddyyyy.parse(selectedDate);
            Date toDay = new Date();
            if (chosenDate.before(toDay)) {
                selectedDate = fortmatMMddyyyy.format(toDay);
            }
            int numberOfAdults, numberOfChilds, packageID;
            try {
                if (errorFlag || loginFlag) {
                    numberOfAdults = Integer.parseInt(request.getAttribute("numberOfAdults").toString());
                } else {
                    numberOfAdults = Integer.parseInt(request.getParameter("numberOfAdults"));
                }
            } catch (NumberFormatException e) {
                numberOfAdults = 1;
            }
            try {
                if (errorFlag || loginFlag) {
                    numberOfChilds = Integer.parseInt(request.getAttribute("numberOfChilds").toString());
                } else {
                    numberOfChilds = Integer.parseInt(request.getParameter("numberOfChilds"));
                }
            } catch (NumberFormatException e) {
                numberOfChilds = 1;
            }
            try {
                if (errorFlag || loginFlag) {
                    packageID = Integer.parseInt(request.getAttribute("packageID").toString());
                } else {
                    packageID = Integer.parseInt(request.getParameter("packageID"));
                }
            } catch (NumberFormatException e) {
                packageID = 0;
            }
            if (packageID > 0 && numberOfAdults > 0) {
                PackageDTO packgeDTO = tripperService.getPackageForPayment(packageID);
                List<Double> prices = tripperService.getPriceOfSelectedDate(selectedDate, packgeDTO);
                if (prices.get(0) > 0) {
                    if (prices.get(1) <= 0 || (prices.get(1) > 0 && numberOfChilds > 0)) {
                        request.setAttribute("selectedDate", selectedDate);
                        request.setAttribute("numberOfAdults", numberOfAdults);
                        request.setAttribute("numberOfChilds", numberOfChilds);
                        request.setAttribute("priceForAdult", prices.get(0));
                        request.setAttribute("priceForChild", prices.get(1));
                        request.setAttribute("packageDTO", packgeDTO);
                        if (request.getAttribute("message") != null) {
                            request.setAttribute("message", request.getAttribute("message"));
                        }
                        url = "/tripper/payment";
                    }
                }
            }
            return url;
        } catch (Exception e) {

            String content = "Function: UserController - book\n"
                    + "***Input***\n"
                    + "message: " + request.getParameter("message") + " || " + request.getAttribute("message") + "\n"
                    + "selectedDate: " + request.getParameter("selectedDate") + " || " + request.getAttribute("selectedDate") + "\n"
                    + "numberOfAdults: " + request.getParameter("numberOfAdults") + " || " + request.getAttribute("numberOfAdults") + "\n"
                    + "numberOfChilds: " + request.getParameter("numberOfChilds") + " || " + request.getAttribute("numberOfChilds") + "\n"
                    + "packageID: " + request.getParameter("packageID") + " || " + request.getAttribute("packageID") + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Booking")
    public String booking(HttpServletRequest request, HttpSession session) {
        try {
            String finalUrl = "redirect:/";
            if (request.getParameter("language") != null) {
                finalUrl = "redirect:/" + "?language=" + request.getParameter("language");
            }

            // no adults
            String noAdultsStr = request.getParameter("numberOfAdults");
            String[] noChildsStrs = request.getParameterValues("numberOfChilds");
            String packageIDStr = request.getParameter("packageID");
            String tripDate = request.getParameter("selectedDate");
            String tripTime = request.getParameter("selectedTime");
            if (tripperService.tripperBooking(noAdultsStr, noChildsStrs, packageIDStr, tripDate, tripTime)) {
                finalUrl = "redirect:/Package/" + packageIDStr;
            }
            return finalUrl;
        } catch (Exception e) {
            String content = "Function: UserController - book\n"
                    + "***Input***\n"
                    + "numberOfAdults: " + request.getParameter("numberOfAdults") + "\n"
                    + "numberOfChilds: " + request.getParameterValues("numberOfChilds") + "\n"
                    + "packageIDStr: " + request.getParameter("packageID") + "\n"
                    + "tripDate: " + request.getParameter("selectedDate") + "\n"
                    + "selectedTime: " + request.getParameter("selectedTime") + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Payment", method = RequestMethod.POST)
    public String payment(HttpServletRequest request) {
        try {
            boolean validate = false;
            boolean makePayment = false;
            AccountSession account = (AccountSession) request.getSession().getAttribute("account");
            String selectedDate = request.getParameter("selectedDate");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            int numberOfAdults, numberOfChilds, packageID;
            int cvv = 0;
            String paymentType = request.getParameter("paymentMethod");
            PackageDTO packgeDTO = null;
            List<Double> prices = new ArrayList<Double>();
            Double total = (Double) 0.0;
            try {
                numberOfAdults = Integer.parseInt(request.getParameter("numberOfAdults"));
            } catch (NumberFormatException e) {
                numberOfAdults = 0;
            }
            try {
                numberOfChilds = Integer.parseInt(request.getParameter("numberOfChilds"));
            } catch (NumberFormatException e) {
                numberOfChilds = 0;
            }
            try {
                packageID = Integer.parseInt(request.getParameter("packageID"));
            } catch (NumberFormatException e) {
                packageID = 0;
            }

            if (packageID > 0 && numberOfAdults > 0) {
                packgeDTO = tripperService.getPackageForPayment(packageID);
                prices = tripperService.getPriceOfSelectedDate(selectedDate, packgeDTO);
                if (prices.get(0) > 0) {
                    if (prices.get(1) <= 0 || (prices.get(1) > 0 && numberOfChilds > 0)) {
                        if (!packgeDTO.isIsPrivateTour()) {
                            total = ((prices.get(0) * numberOfAdults + numberOfChilds * prices.get(1)) * (100 - packgeDTO.getYoutripperPercentage()) / 100);
                        } else {
                            int noOfPackages = (int) Math.round(Math.ceil((float) (numberOfAdults + numberOfChilds) / packgeDTO.getMinTripper()));
                            total = (noOfPackages * prices.get(0) * (100 - packgeDTO.getYoutripperPercentage()) / 100);
                        }

                        validate = true;
                    }
                }
            }
            //Make credit Card payment
            if (validate) {
                if (paymentType.equals("creditCard")) {
                    String cardType = request.getParameter("cardType");
                    String cardNumber = request.getParameter("cardNumber");
                    int expireMonth = Integer.parseInt(request.getParameter("expireMonth"));
                    int expireYear = Integer.parseInt(request.getParameter("expireYear"));
                    try {
                        cvv = Integer.parseInt(request.getParameter("cvv"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    makePayment = tripperService.paywithCreditCard(cardType, cardNumber, expireMonth, expireYear, cvv, firstName, lastName, "USD", String.format(Locale.US, "%.2f", total), "Booking Trip:" + packageID);
                } else if (paymentType.equals("paypal")) {
                    request.setAttribute("packageID", packageID);
                    request.setAttribute("selectedDate", selectedDate);
                    request.setAttribute("numberOfChilds", numberOfChilds);
                    request.setAttribute("numberOfAdults", numberOfAdults);
                    request.setAttribute("prices", prices);
                    request.setAttribute("totalPrice", String.format(Locale.US, "%.2f", total));
                    return "forward:/Tripper/PaywithPaypal";
                }
                if (makePayment) {
                    String code = tripperService.getBookingCode();
                    tripperService.insertBooking(code, packageID, selectedDate, numberOfChilds, numberOfAdults, account.getId());
                    int providerID = packgeDTO.getProviderID();
                    int tripperID = account.getId();
                    boolean notifyForProvider = providerService.insertNewProviderSystemNotification("{\"URL\":\"Noti/ProviderViewBooking/" + code + "\",\"Message\":\"You have a new booking\"}", false, providerID);
                    boolean notifyForTripper = tripperService.insertNewTripperSystemNotification("{\"URL\":\"Noti/TripperViewBooking/" + code + "\",\"Message\":\"You had booked a trip!\"}", false, tripperID);
                    String providerNoti = providerService.getProviderNewNotification(providerID);
                    template.convertAndSend("/topic/Notifications/Provider/" + providerID, providerNoti);
                    String tripperNoti = tripperService.getTripperNewNotification(tripperID);
                    template.convertAndSend("/topic/Notifications/Tripper/" + tripperID, tripperNoti);
                    return "/tripper/paymentSuccess";
                } else {
                    request.setAttribute("message", "Your credit card is declined");
                    request.setAttribute("selectedDate", selectedDate);
                    request.setAttribute("numberOfAdults", numberOfAdults);
                    request.setAttribute("numberOfChilds", numberOfChilds);
                    request.setAttribute("packageID", packageID);
                    return "forward:/Tripper/Book";
                }
            }
            if (request.getParameter("language") != null) {
                return "redirect:/Common" + "?language=" + request.getParameter("language");
            } else {
                return "redirect:/Common";
            }

        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: UserController - payment\n"
                    + "***Input***\n"
                    + "selectedDate: " + request.getParameter("selectedDate") + "\n"
                    + "firstName: " + request.getParameter("firstName") + "\n"
                    + "lastName: " + request.getParameter("lastName") + "\n"
                    + "paymentMethod: " + request.getParameter("paymentMethod") + "\n"
                    + "numberOfAdults: " + request.getParameter("numberOfAdults") + "\n"
                    + "numberOfChilds: " + request.getParameter("numberOfChilds") + "\n"
                    + "packageID: " + request.getParameter("packageID") + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/PaywithPaypal")
    String payWithPaypal(HttpServletRequest request) {
        try {
            String redirectURL;
            HttpSession session = request.getSession(true);
            AccountSession account = (AccountSession) session.getAttribute("account");
            int packageID = Integer.parseInt(request.getParameter("packageID"));
            PackageDTO packgeDTO = tripperService.getPackageForPayment(packageID);
            int numberOfChilds = 0;
            int numberOfAdults = 0;
            String selectedDate = request.getParameter("selectedDate");
            List<Double> price = (List<Double>) request.getAttribute("prices");
            try {
                numberOfChilds = Integer.parseInt(request.getAttribute("numberOfChilds").toString());
                numberOfAdults = Integer.parseInt(request.getAttribute("numberOfAdults").toString());
            } catch (Exception e) {
            }

            String total = request.getAttribute("totalPrice").toString();
            List<Item> itemList = new ArrayList<Item>();
            int noOfPackages = 0;
            if (packgeDTO.isIsPrivateTour()) {
                noOfPackages = (int) Math.round(Math.ceil((float) (numberOfAdults + numberOfChilds) / packgeDTO.getMinTripper()));
                Item item = new Item(String.valueOf(noOfPackages), String.valueOf(noOfPackages) + "Packages", String.format(Locale.US, "%.2f", (price.get(0) * (100 - packgeDTO.getYoutripperPercentage())) / 100), "USD");
                itemList.add(item);
            } else {
                Item item = new Item(String.valueOf(numberOfAdults), "Number of Adults", String.format(Locale.US, "%.2f", (price.get(0) * (100 - packgeDTO.getYoutripperPercentage())) / 100), "USD");
                itemList.add(item);
                if (price.get(1) > 0) {
                    Item item2 = new Item(String.valueOf(numberOfChilds), "Number of Childs", String.format(Locale.US, "%.2f", (price.get(1) * (100 - packgeDTO.getYoutripperPercentage())) / 100), "USD");
                    itemList.add(item2);
                }
            }

            redirectURL = tripperService.paywithPaypal(account, packageID, numberOfChilds, numberOfAdults, selectedDate, request, "USD", total, "Paying with Paypal", itemList);
            return "redirect:" + redirectURL;
        } catch (PayPalRESTException e) {
            HttpSession session = request.getSession(true);
            String content = "Function: UserController - payWithPaypal\n"
                    + "***Input***\n"
                    + "packageID: " + request.getParameter("packageID") + "\n"
                    + "selectedDate: " + request.getParameter("selectedDate") + "\n"
                    + "prices: " + request.getAttribute("prices") + "\n"
                    + "numberOfChilds: " + request.getAttribute("numberOfChilds") + "\n"
                    + "numberOfAdults: " + request.getAttribute("numberOfAdults") + "\n"
                    + "totalPrice: " + request.getParameter("totalPrice") + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";

        }

    }

    @RequestMapping(value = "/payPaypalSuccess")
    String payPaypalSuccess(HttpServletRequest request) {
        try {
            String paymentID = request.getParameter("paymentId");
            String payerID = request.getParameter("PayerID");
            int packageID = Integer.parseInt(request.getParameter("packageID"));
            String selectedDate = request.getParameter("selDate");
            int numberOfChilds = Integer.parseInt(request.getParameter("numChild"));
            int numberOfAdults = Integer.parseInt(request.getParameter("numAdult"));
            int accountID = Integer.parseInt(request.getParameter("accountID"));
            boolean verifiyPayment = tripperService.verifyPayment(paymentID, payerID);
            if (verifiyPayment) {
                String code = tripperService.getBookingCode();
                if (tripperService.insertBooking(code, packageID, selectedDate, numberOfChilds, numberOfAdults, accountID)) {
                    PackageDTO packgeDTO = tripperService.getPackageForPayment(packageID);
                    int providerID = packgeDTO.getProviderID();
                    boolean notifyForProvider = providerService.insertNewProviderSystemNotification("{\"URL\":\"Noti/ProviderViewBooking/" + code + "\",\"Message\":\"You have a new booking\"}", false, providerID);
                    boolean notifyForTripper = tripperService.insertNewTripperSystemNotification("{\"URL\":\"Noti/TripperViewBooking/" + code + "\",\"Message\":\"You had booked a trip!\"}", false, accountID);
                    String providerNoti = providerService.getProviderNewNotification(providerID);
                    template.convertAndSend("/topic/Notifications/Provider/" + providerID, providerNoti);
                    String tripperNoti = tripperService.getTripperNewNotification(accountID);
                    template.convertAndSend("/topic/Notifications/Tripper/" + accountID, tripperNoti);
                    return "/tripper/paymentSuccess";
                }
            }
            return "forward:/Common/Error";
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: UserController - payPaypalSuccess\n"
                    + "***Input***\n"
                    + "paymentId: " + request.getParameter("paymentId") + "\n"
                    + "PayerID: " + request.getParameter("PayerID") + "\n"
                    + "packageID: " + request.getAttribute("packageID") + "\n"
                    + "selDate: " + request.getAttribute("selDate") + "\n"
                    + "numChild: " + request.getAttribute("numChild") + "\n"
                    + "numAdult: " + request.getParameter("numAdult") + "\n"
                    + "accountID: " + request.getParameter("accountID") + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }

    }

    @RequestMapping(value = "/payPaypalFail")
    String payPaypalFail(HttpServletRequest request) {
        try {
            int packageID = Integer.parseInt(request.getParameter("packageID"));
            String selectedDate = request.getParameter("selDate");
            int numberOfChilds = Integer.parseInt(request.getParameter("numChild"));
            int numberOfAdults = Integer.parseInt(request.getParameter("numAdult"));

            request.setAttribute("message", "Payment with paypal was cancelled!");
            request.setAttribute("selectedDate", selectedDate);
            request.setAttribute("numberOfAdults", numberOfAdults);
            request.setAttribute("numberOfChilds", numberOfChilds);
            request.setAttribute("packageID", packageID);
            return "forward:/Tripper/Book";
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: UserController - payPaypalFail\n"
                    + "***Input***\n"
                    + "packageID: " + request.getAttribute("packageID") + "\n"
                    + "selDate: " + request.getAttribute("selDate") + "\n"
                    + "numChild: " + request.getAttribute("numChild") + "\n"
                    + "numAdult: " + request.getParameter("numAdult") + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Notification")
    String getNotification(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession(true);
            AccountSession account = (AccountSession) session.getAttribute("account");
            List<TripperNotification> providerNoti = tripperService.getTripperNotification();
            Gson gson = new Gson();
            List<TripperNotificationSetting> providerSetting = tripperService.getTripperNotificationSetting(account.getId());
            List<Integer> providerSettingList = new ArrayList<Integer>();
            for (int i = 0; i < providerSetting.size(); i++) {
                providerSettingList.add(providerSetting.get(i).getTripperNotificationID());
            }
            request.setAttribute("tripperSetting", gson.toJson(providerSettingList));
            request.setAttribute("tripperNotification", gson.toJson(providerNoti));
            request.setAttribute("page", "tripperNotification");
            return "tripper/notification";
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: UserController - getNotification\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/SaveSetting", method = RequestMethod.POST)
    public String saveSetting(HttpServletRequest request) {
        try {
            int tripperID;
            try {
                tripperID = Integer.parseInt(request.getParameter("tripperID"));
            } catch (NumberFormatException e) {
                tripperID = 0;
            }
            tripperService.saveSetting(tripperID, request.getParameter("settingJson"));
            if (request.getParameter("language") != null) {
                return "redirect:/Tripper/Notification" + "?language=" + request.getParameter("language");
            } else {
                return "redirect:/Tripper/Notification";
            }

        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: UserController - saveSetting\n"
                    + "***Input***\n"
                    + "tripperID: " + request.getAttribute("tripperID") + "\n"
                    + "settingJson: " + request.getAttribute("settingJson") + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }

    }

    @RequestMapping(value = "/AccountInfo")
    public String getAccountInfo(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession(true);
            AccountSession account = (AccountSession) session.getAttribute("account");
            TripperDTO tripper = tripperService.getTripperAccount(account.getId());
            Gson gson = new Gson();
            List<CountryDTO> countryList = commonService.getAllCountry();
            request.setAttribute("countryList", gson.toJson(countryList));
            request.setAttribute("AccountInfo", gson.toJson(tripper));
            request.setAttribute("page", "Info");
            return "tripper/accountInfo";
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: UserController - getAccountInfo\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/UploadImage", method = RequestMethod.POST)
    public @ResponseBody
    String uploadProviderImage(@RequestParam("providerImage") MultipartFile providerImage, @RequestParam("providerID") int providerID, HttpSession session) {
        try {
            String path = System.getProperty("catalina.base");
            File folderPackage = new File(path + "/webapps/Images/Tripper/" + providerID);
            if (!folderPackage.exists()) {
                folderPackage.mkdirs();
            }
            String extension = FilenameUtils.getExtension(providerImage.getOriginalFilename());
            String name = "tripper." + extension;
            String name2 = "avatar." + extension;

            // get Bytes and crop
            byte[] imageInByte = providerImage.getBytes();
            InputStream in = new ByteArrayInputStream(imageInByte);
            BufferedImage bImageFromConvert = ImageIO.read(in);
            // create a cropped image from the original image
            BufferedImage croppedImage = bImageFromConvert.getSubimage(0, 0, 100, 100);

//            // then convert BufferedImage to byte array to save
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            ImageIO.write(croppedImage, extension, baos);
//            baos.flush();
//            imageInByte = baos.toByteArray();
//            baos.close();
            ImageIO.write(croppedImage, extension, new File(folderPackage, name2));

            FileCopyUtils.copy(providerImage.getBytes(), new FileOutputStream(new File(folderPackage, name)));
            String image = "Images/Tripper/" + providerID + "/" + name;
            AccountSession account = (AccountSession) session.getAttribute("account");
            account.setImage(image);
            session.setAttribute("account", account);
            tripperService.updateTripperImage(providerID, image);
            return image;
        } catch (Exception e) {
            String content = "Function: ProviderController - uploadProviderImage\n"
                    + "***Input***\n"
                    + "providerID: " + providerID + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/BucketList")
    public String getBucketList(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession(true);
            AccountSession account = (AccountSession) session.getAttribute("account");
            List<PackagesViewDTO> bucketList = packageService.getBucketList(account.getId());
            Gson gson = new Gson();
            request.setAttribute("BucketList", gson.toJson(bucketList));
            request.setAttribute("page", "bucketPackages");
            return "tripper/bucketList";
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: UserController - getBucketList\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/BookingList")
    public String getBookingList(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession(true);
            AccountSession account = (AccountSession) session.getAttribute("account");
            List<BookingDTO> booking = tripperService.getBookingListForTripper(account.getId());
            Gson gson = new Gson();
            request.setAttribute("BookingList", gson.toJson(booking));
            request.setAttribute("page", "tripperBookings");
            return "tripper/booking";
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: UserController - getBookingList\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }

    }

    @RequestMapping(value = "/SaveWishList", method = RequestMethod.POST)
    public @ResponseBody
    String saveToWishList(@RequestBody final String data, HttpSession session) {
        try {
            tripperService.saveWishList(data, session);
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            String content = "Function: UserController - uploadProviderImage\n"
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

    @RequestMapping(value = "/RemoveFromWishList/{packageID}", method = RequestMethod.GET)
    public String removeFromWishlist(@PathVariable int packageID, HttpSession session, ModelMap map, HttpServletRequest request) {
        try {
            tripperService.removeWishlist(packageID, session);
            if (request.getParameter("language") != null) {
                return "redirect:/Tripper/BucketList" + "?language=" + request.getParameter("language");
            } else {
                return "redirect:/Tripper/BucketList";
            }

        } catch (Exception e) {
            String content = "Function: UserController - removeFromWishlist\n"
                    + "***Input***\n"
                    + "packageID: " + packageID + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";

        }

    }

    @RequestMapping(value = "/Chat", method = RequestMethod.GET)
    public String gotoChat(HttpServletRequest request) {
        try {
            request.setAttribute("page", "tripperMessage");
            String conversationList = "";
            HttpSession session = request.getSession(true);
            AccountSession account = (AccountSession) session.getAttribute("account");
            conversationList = messageService.getListConversationbyTripperID(account.getId());
            request.setAttribute("conversationList", conversationList);
//            tripperService.seenMessage(account.getId());
            return "tripper/chat";
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: UserController - gotoChat\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/ChatWithProvider/{userID}/{conversationID}")
    public String chatwithProvider(HttpServletRequest request, @PathVariable int userID, @PathVariable int conversationID) {
        try {
            String conversationList = "";
            HttpSession session = request.getSession(true);
            request.setAttribute("page", "tripperMessage");
            AccountSession account = (AccountSession) session.getAttribute("account");
            String result = "";
            request.setAttribute("conversationID", messageService.getConversationID(userID, account.getId(), conversationID));
            conversationList = messageService.getListConversationbyTripperID(account.getId());
            request.setAttribute("conversationList", conversationList);

            return "tripper/chat";
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: UserController - chatwithProvider\n"
                    + "***Input***\n"
                    + "userID: " + userID + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/UpdateInformation", method = RequestMethod.POST)
    public String updateInformation(HttpServletRequest request, HttpSession session) {
        try {
            AccountSession account = tripperService.updateTripperInformation(request, session);
            session.setAttribute("account", account);
            if (request.getParameter("language") != null) {
                return "redirect:/Tripper/AccountInfo" + "?language=" + request.getParameter("language");
            } else {
                return "redirect:/Tripper/AccountInfo";
            }

        } catch (Exception e) {
            String content = "Function: UserController - updateInformation\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }

    }

    @RequestMapping(value = "/Password", method = RequestMethod.GET)
    public String ProviderPassword(HttpServletRequest request) {
        request.setAttribute("page", "tripperPassword");
        return "tripper/password";
//        }
    }

    @RequestMapping(value = "/ChangePassword", method = RequestMethod.POST)
    public String changePassword(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession(true);
            String oldPassword = request.getParameter("currentPass");
            String newPassword = (String) request.getParameter("newPass");
            AccountSession account = (AccountSession) session.getAttribute("account");
            boolean result = tripperService.changeTripperPassword(account.getId(), oldPassword, newPassword);
            if (result) {
                if (request.getParameter("language") != null) {
                    return "redirect:/Tripper/AccountInfo" + "?language=" + request.getParameter("language");
                } else {
                    return "redirect:/Tripper/AccountInfo";
                }

            } else {
                request.setAttribute("message", "Your current password not correct!");
            }
            return "tripper/password";
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: UserController - changePassword\n"
                    + "***Input***\n"
                    + "currentPass: " + request.getParameter("currentPass") + "\n"
                    + "newPass: " + request.getParameter("newPass") + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/ReviewPackage/{PackageID}/{bookingID}")
    public String makeReviewPackage(HttpServletRequest request, HttpSession session, @PathVariable int PackageID, @PathVariable String bookingID) {
        try {

            AccountSession account = (AccountSession) session.getAttribute("account");
            if (commonService.checkReviewExist(account.getId(), bookingID)) {
                request.setAttribute("packageID", PackageID);
                request.setAttribute("bookingID", bookingID);
                return "tripper/reviewPackage";
            }
            if (request.getParameter("language") != null) {
                return "redirect:/Common" +"?language=" + request.getParameter("language");
            } else {
                return "redirect:/Common";
            }
            
        } catch (Exception e) {
            String content = "Function: UserController - makeReviewPackage\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/MakeReview", method = RequestMethod.POST)
    public String makeReview(HttpServletRequest request, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int packageID = Integer.valueOf(request.getParameter("packageID"));
            String bookingID = String.valueOf(request.getParameter("bookingID"));
            String reviewDetail = request.getParameter("reviewDetail");
            double score = Double.valueOf(request.getParameter("rateScore"));
            int Professionlism = Integer.valueOf(request.getParameter("Professionlism"));
            int StaffAttitude = Integer.valueOf(request.getParameter("StaffAttitude"));
            int Convenient = Integer.valueOf(request.getParameter("Convenient"));
            int Satisfaction = Integer.valueOf(request.getParameter("Satisfaction"));
            int AmenityQuality = Integer.valueOf(request.getParameter("AmenityQuality"));
            int Cleanliness = Integer.valueOf(request.getParameter("Cleanliness"));
            boolean result = tripperService.makeReview(account.getId(), bookingID, packageID, reviewDetail, score, Professionlism, StaffAttitude, Convenient, Satisfaction, AmenityQuality, Cleanliness);

            return "tripper/reviewSuccess";
        } catch (Exception e) {
            String content = "Function: UserController - makeReview\n"
                    + "***Input***\n"
                    + "packageID: " + request.getParameter("packageID") + "\n"
                    + "reviewDetail: " + request.getParameter("reviewDetail") + "\n"
                    + "score: " + request.getParameter("score") + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/UploadAvatar", method = RequestMethod.POST)
    public @ResponseBody
    String saveAvatarToCrop(@RequestParam("providerImage") MultipartFile providerImage, HttpSession session) {
        try {
            // get data from image
            String fileName = providerImage.getOriginalFilename();
            String fileType = providerImage.getContentType();
            String fileSize = providerImage.getSize() / 1024 + " Kb";
            byte[] imageInByte = providerImage.getBytes();

            FileMeta metaFile = new FileMeta(fileName, fileSize, fileType, imageInByte);
            // save temporary Image to session
            session.setAttribute("avatarImage", metaFile);

            // get width and height of image
            InputStream in = new ByteArrayInputStream(imageInByte);
            BufferedImage bImageFromConvert = ImageIO.read(in);
            String data = "{\"width\": " + bImageFromConvert.getWidth() + ", \"height\": " + bImageFromConvert.getHeight() + "}";

            return "{\"result\": " + data + "}";
        } catch (IIOException ie) {

            return "{\"result\": \"image broken\"}";
        } catch (Exception e) {
            String content = "Function: ProviderController - saveAvatarToCrop\n"
                    + "***Input***\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/TemporaryAvatar", method = RequestMethod.GET)
    public void getTemporaryAvatar(HttpSession session, HttpServletResponse response) {
        try {
            // get temporary avatar in session
            FileMeta getFile = (FileMeta) session.getAttribute("avatarImage");
            if (getFile != null) { // if exist return image
                response.setContentType(getFile.getFileType());
                response.setHeader("Content-disposition", "attachment; filename=\"" + getFile.getFileName() + "\"");
                FileCopyUtils.copy(getFile.getBytes(), response.getOutputStream());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/Avatar/CropAndSave", method = RequestMethod.POST)
    public @ResponseBody
    String cropAndSaveAvatar(@RequestBody final String data, HttpSession session) {
        try {
            FileMeta metaFile = (FileMeta) session.getAttribute("avatarImage");

            if (metaFile != null) {

                AccountSession account = (AccountSession) session.getAttribute("account");
                int providerID = account.getId();
                String image = tripperService.cropAndSaveProviderImage(data, providerID, metaFile);
                account.setImage(image);
                session.setAttribute("account", account);
                return "{\"result\":\"" + image + "\"}";
            }

            return "{\"result\":\"error\"}";
        } catch (Exception e) {
            String content = "Function: ProviderController - cropAndSaveAvatar\n"
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

    @RequestMapping(value = "/SendMessageViaChatbox", method = RequestMethod.POST)
    public @ResponseBody
    String SendMessageViaChatbox(@RequestBody final String data, HttpSession session) {
        try {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
            int conversationID = jsonObject.get("packageID").getAsInt();
            int tripperID = jsonObject.get("tripperID").getAsInt();
            int providerID = jsonObject.get("providerID").getAsInt();
            String message = jsonObject.get("message").getAsString();
            messageService.getConversationID(providerID, tripperID, conversationID);
            messageService.sendConversationMessage("{\"content\":\"" + message + "\",\"type\":\"text\"}", "tripper", tripperID, conversationID, tripperID);
            //Get package Name
            PackageDTO packageResult = packageService.getPackageName(conversationID);
            //Send Notification message                 
            boolean notifyForProvider = providerService.insertNewProviderSystemNotification("{\"URL\":\"Provider/Chat\",\"Message\":\"You have a new message in Package " + packageResult.getName() + " \"}", false, providerID);
            String providerNoti = providerService.getProviderNewNotification(providerID);
            template.convertAndSend("/topic/Notifications/Provider/" + providerID, providerNoti);
            return "success";
        } catch (Exception e) {
            String content = "Function: UserController - SendMessageViaChatbox\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "error";
        }
    }

    @RequestMapping(value = "/SignupFacebook", method = RequestMethod.POST)
    public @ResponseBody
    String SignupFacebook(@RequestBody final String data, HttpSession session) {
        try {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
            String nameFacebook = jsonObject.get("nameFacebook").getAsString();
            String emailFacebook = jsonObject.get("emailFacebook").getAsString();
            tripperService.getFacebookInfo(nameFacebook, emailFacebook);
            return "/Common/Tripper/SignupFacebook";
        } catch (Exception e) {
            String content = "Function: UserController - SendMessageViaChatbox\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "error";
        }
    }

    @RequestMapping(value = "/PaymentSuccess", method = RequestMethod.GET)
    public String verifyPayment(@RequestBody final String data, HttpSession session,HttpServletRequest request) {
        try {
            System.out.println("Payment success");
            if (request.getParameter("language") != null) {
                return "redirect:/" +"?language=" + request.getParameter("language");
            } else {
                return "redirect:/";
            }
            
        } catch (Exception e) {
            String content = "Function: UserController - verifyPayment\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "error";
        }
    }
}
