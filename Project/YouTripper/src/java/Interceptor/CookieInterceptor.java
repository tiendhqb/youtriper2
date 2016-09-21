/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interceptor;

import DTO.AccountSession;
import Interface.Service.CommonService;
import Interface.Service.ErrorService;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author DINH KHANG
 */
public class CookieInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    CommonService commonService;

    @Autowired
    ErrorService errorService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        try {
            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute("account") == null) {
                Cookie[] cookie = request.getCookies();
                boolean flag = true;
                if (cookie != null) {
                    for (Cookie obj : cookie) {
                        if (obj.getName().equals("rememberMe") && flag) {
                            for (Cookie obj2 : cookie) {
                                if (obj2.getName().equals("loginToken")) {
                                    String token = obj2.getValue();
                                    AccountSession account = commonService.checkCookie(token);
                                    if (account.getId() != 0) {
                                        session = request.getSession();
                                        session.setAttribute("account", account);
                                    }
                                }
                                flag = false;
                            }
                        }
                    }
                }
            }
            
            return true;
        } catch (Exception e) {
            String sessionID = request.getSession(true).getId();
            String content = "Function: CookieInterceptor\n"
                    + "****Error****\n"
                    + e.getMessage();
            request.setAttribute("errorID", sessionID);
            request.setAttribute("errorTime", errorService.logBug(content, sessionID));
            request.getRequestDispatcher(request.getContextPath() + "/Common/Error").forward(request, response);
        }
        return false;
    }

//    void postHandle(HttpServletRequest request,
//            HttpServletResponse response,
//            Object handler,
//            ModelAndView modelAndView)
//            throws Exception {
//        HttpSession session = request.getSession(false);
//        if (session != null) {
//            Object obj = session.getAttribute("account");
//            if (obj instanceof AccountSession) {
//                AccountSession account = (AccountSession) obj;
//                session.setAttribute("account", commonService.updateImage(account));
//            }
//        }
//    }
}
