/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interceptor;

import DTO.AdminSession;
import DTO.SalemanSession;
import Interface.Service.ErrorService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author QuangTran
 */
public class SalesmanInterceptor extends HandlerInterceptorAdapter{
    @Autowired
    ErrorService errorService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                Object obj = session.getAttribute("account");
                if (obj != null && obj instanceof SalemanSession) {
                    SalemanSession account = (SalemanSession) obj;
                    if (account.getRole() == 4) {
                        return true;
                    }
                }
            }
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/LoginPage"));
        } catch (Exception e) {
            String sessionID = request.getSession(true).getId();
            String content = "Function: SalesmanInterceptor\n"
                    + "****Error****\n"
                    + e.getMessage();
            request.setAttribute("errorID", sessionID);
            request.setAttribute("errorTime", errorService.logBug(content, sessionID));
            request.getRequestDispatcher(request.getContextPath() + "/Common/Error").forward(request, response);
        }
        return false;
    }
}
