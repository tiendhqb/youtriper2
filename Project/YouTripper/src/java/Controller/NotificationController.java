/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Interface.Service.ErrorService;
import Interface.Service.ProviderService;
import Interface.Service.TripperService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author DINH KHANG
 */
@Controller
@RequestMapping(value = "/Noti")
public class NotificationController {

    @Autowired
    SimpMessagingTemplate template;

    @Autowired
    ProviderService providerService;

    @Autowired
    TripperService tripperService;

    @Autowired
    ErrorService errorService;

    @MessageMapping(value = "/hello/Notifications/Provider/{providerID}")
    @SendTo("/topic/Notificaitons/Provider/{providerID}")
    public void getNotificationProvider(@DestinationVariable int providerID) {
        try {
            String result = providerService.getProviderNewNotification(providerID);
            template.convertAndSend("/topic/Notifications/Provider/" + providerID, result);
        } catch (Exception e) {
            String content = "Function: NotificationController - getNotificationProvider\n"
                    + "***Input***\n"
                    + "providerID: " + providerID + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content,null,e);
        }
    }

    @MessageMapping(value = "/hello/Notifications/Tripper/{tripperID}")
    @SendTo("/topic/Notificaitons/Tripper/{tripperID}")
    public void getNotificationTripper(@DestinationVariable int tripperID) {
        try {
            String result = tripperService.getTripperNewNotification(tripperID);
            template.convertAndSend("/topic/Notifications/Tripper/" + tripperID, result);
        } catch (Exception e) {
            String content = "Function: NotificationController - getNotificationTripper\n"
                    + "***Input***\n"
                    + "tripperID: " + tripperID + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, null,e);
        }
    }

    @RequestMapping(value = "/ProviderSeenNoti", method = RequestMethod.POST)
    public @ResponseBody
    String seenNoti(@RequestParam("NotificationID") int notificationID, HttpSession session) {
        try {
            providerService.seenNotification(notificationID);
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            String content = "Function: NotificationController - seenNoti\n"
                    + "***Input***\n"
                    + "notificationID: " + notificationID + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session,e);
            return "{\"result\": \"error\"}";
        }

    }

    @RequestMapping(value = "/TripperSeenNoti", method = RequestMethod.POST)
    public @ResponseBody
    String tripperSeenNoti(@RequestParam("NotificationID") int notificationID, HttpSession session) {
        try {
            tripperService.seenNotification(notificationID);
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            String content = "Function: NotificationController - tripperSeenNoti\n"
                    + "***Input***\n"
                    + "notificationID: " + notificationID + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session,e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/ProviderViewBooking/{bookingID}", method = RequestMethod.GET)
    public String providerViewBooking(HttpServletRequest request, @PathVariable String bookingID) {
        try {
            request.setAttribute("BookingID", bookingID);
            request.setAttribute("page", "providerMessage");
            request.setAttribute("conversationList", "null");
            return "provider/chat";
        } catch (Exception e) {
            HttpSession session = request.getSession();
            String content = "Function: NotificationController - providerViewBooking\n"
                    + "***Input***\n"
                    + "bookingID: " + bookingID + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session,e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/TripperViewBooking/{bookingID}", method = RequestMethod.GET)
    public String tripperViewBooking(HttpServletRequest request, @PathVariable String bookingID) {
        try {
            request.setAttribute("BookingID", bookingID);
            request.setAttribute("page", "tripperMessage");
            request.setAttribute("conversationList", "null");
            return "tripper/chat";
        } catch (Exception e) {
            HttpSession session = request.getSession();
            String content = "Function: NotificationController - tripperViewBooking\n"
                    + "***Input***\n"
                    + "bookingID: " + bookingID + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session,e));
            return "forward:/Common/Error";
        }
    }

}
