<%-- 
    Document   : providerMenubar
    Created on : Nov 5, 2015, 6:17:42 PM
    Author     : Nick
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="page-user-profile page-ploicy">
    <div class="tabs-user-profile">
        <!-- Nav tabs -->
        <div class="policy">
            <div class="container">
                <ul>
                    <li class="user_icon1" ng-class="{'active' : (page === 'ToS')}">
                        <a href="<c:url value="/Common/TOS"/>" target="_self">
                            <span></span>Term of Service
                        </a>
                    </li>
                    <li class="user_icon2" ng-class="{'active' : (page === 'Policy')}" >
                        <a href="<c:url value="/Common/Policy"/>" target="_self">
                            <span></span>Privacy Policy
                        </a>
                    </li>
                    <li class="user_icon3" ng-class="{'active' : (page === 'Fee')}">
                        <a href="<c:url value="/Common/FeePolicy"/>" target="_self">
                            <span></span>Fee & Booking Policy
                        </a>
                    </li>

                </ul>
            </div>
        </div>
    </div>
</div>