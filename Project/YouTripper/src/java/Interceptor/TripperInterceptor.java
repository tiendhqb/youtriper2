/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interceptor;

import DTO.AccountSession;
import DTO.PackageDTO;
import Interface.Service.ErrorService;
import Interface.Service.TripperService;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author Nick
 */
public class TripperInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    TripperService tripperService;

    @Autowired
    ErrorService errorService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                Object obj = session.getAttribute("account");
                if (obj instanceof AccountSession) {
                    AccountSession account = (AccountSession) obj;
                    if (tripperService.isUser(account)) {
                        return true;
                    }
                }

            }
//            if (request.getParameter("selectedDate") != null) {
//                request.setAttribute("selectedDate", request.getParameter("selectedDate"));
//                request.setAttribute("numberOfAdults", request.getParameter("numberOfAdults"));
//                request.setAttribute("numberOfChilds", request.getParameter("numberOfChilds"));
//                request.setAttribute("packageID", request.getParameter("packageID"));
//
//            }
            RequestDispatcher rd = request.getRequestDispatcher("/LoginPage");
            rd.forward(request, response);
        } catch (Exception e) {
            String sessionID = request.getSession(true).getId();
            String content = "Function: TripperInterceptor\n"
                    + "****Error****\n"
                    + e.getMessage();
            request.setAttribute("errorID", sessionID);
            request.setAttribute("errorTime", errorService.logBug(content, sessionID));
            request.getRequestDispatcher(request.getContextPath() + "/Common/Error").forward(request, response);
        }
        return false;
    }

}
