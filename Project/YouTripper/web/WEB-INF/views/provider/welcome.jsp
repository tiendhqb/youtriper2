<%-- 
    Document   : welcome
    Created on : Sep 28, 2015, 10:24:43 AM
    Author     : Nick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=1366">
<!--        <meta name="viewport" content="width=device-width, initial-scale=1">-->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!--<script src='https://www.google.com/recaptcha/api.js'></script>-->
        <script src="https://www.google.com/recaptcha/api.js?onload=vcRecaptchaApiLoaded&render=explicit" async defer></script>
        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">

        <script src="<c:url value="/Resources/Theme/js/angular.js"/>"></script>

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <title>Provider Page</title>

        <script>
            angular.module('Home', []).controller('HomeController', function ($scope, $http) {
            <c:choose>
                <c:when test="${sessionScope.account != null}">
                $scope.account = {id: ${sessionScope.account.id}, name: "${sessionScope.account.name}", role: ${sessionScope.account.role}};
                </c:when>
                <c:otherwise>
                    <c:redirect url="/LoginPage"/>
                </c:otherwise>
            </c:choose>
            });
        </script>

        <style>
            .wrapper {
                width: 724px;
                margin: 0 auto;
            }
        </style>
    </head>
    <body>
        <div ng-app="Home" ng-controller="HomeController">
            <div class="wrapper">
                Welcome, {{account.name}}! <a href="<c:url value="/Common/Logout"/>">Logout</a>
                <br/>
                <!--<a href="<c:url value="/Package/Creation"/>">Create A Package</a>-->
                <a href="<c:url value="/Provider/Package"/>">Your Packages</a>
                <a href="<c:url value="/Provider/AccountInfo"/>">Account Info</a>
                <a href="<c:url value="/Common/Chat"/>">Message</a>
                <a href="<c:url value="/Provider/Verify"/>">Verify PhoneNumber</a>
                <a href="<c:url value="/Provider/Booking"/>">Booking</a>
                <a href="<c:url value="/Provider/Sales"/>">Sales</a>
                <a href="<c:url value="/Provider/Notification"/>">Notification</a>
                
            </div>
        </dviv>
</body>
</html>
