/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interceptor;

import Interface.Service.CommonService;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author DINH KHANG
 */
public class IndentityInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    CommonService commonService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String refererURI = "";
        String time = String.valueOf(System.currentTimeMillis());
        HttpSession session = request.getSession(true);
        if(session.getAttribute("accessTime") ==null && session.getAttribute("accessIP") == null){
            session.setAttribute("accessTime", time);
        session.setAttribute("accessIP", request.getRemoteAddr());
        }
        
        if (request.getHeader("referer") == null || request.getHeader("referer").contains("localhost") || request.getHeader("referer").contains("youtripper.com")) {
            refererURI = "blank";
        } else {
            refererURI = (request.getHeader("referer"));
        }

        commonService.logNewVisitor(0, refererURI, request.getRemoteAddr(), request.getHeader("User-Agent"), time, request.getRequestURI());
        return true;
    }

}
