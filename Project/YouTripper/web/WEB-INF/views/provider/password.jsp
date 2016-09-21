<%-- 
    Document   : accountInfo
    Created on : Nov 2, 2015, 10:19:54 AM
    Author     : DINH KHANG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html id="change-password">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=1366">
        <!--        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1">-->
        <!--<script src='https://www.google.com/recaptcha/api.js'></script>-->

        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">

        <%@ include file="../angular.jsp" %>

        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css?999999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css?999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripperResponsive.css"/>" >

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >
        <title>Change Password</title>
    </head>
    <body>
        <div class="pagesearch" ng-app="YouTripper" ng-controller="ChangeProviderPasswordController">
            <%@ include file="../header.jsp" %>
            <%--<%@ include file="providerMenubar.jsp" %>--%>
            <div class="center_form">  
                <div class="red-title">
                    Change Password
                </div>

                <div class="form-body">
                    <form method="POST" action="
                          <c:choose>
                              <c:when test="${empty param.language}">
                                  <c:url value="/Provider/ChangePassword"/>
                              </c:when>
                              <c:otherwise>
                                  <c:url value="/Provider/ChangePassword?language=${param.language}"/>
                              </c:otherwise>
                          </c:choose>" 
                          class="ytForm"
                          id="ChangePassForm"  name="ChangePassForm" ng-submit="validateChangePassword($event)" novalidate> 

                        <!--<p></p>-->
                        <div class="form-input">
                            <span>Current password</span>
                            <input ng-model="change.currentPassword" class="normalFont blueInput"
                                   name="currentPass" type="password" placeholder="Current password"/>
                            <span ng-show="!change.currentPassword.length && showError.all">
                                <span ng-show="!change.currentPassword.length" style="color: red">Password can not be blank!</span>                  
                            </span>
                            <c:if test="${requestScope.message != null}">
                                <p style="color: red">${requestScope.message}</p>
                            </c:if>
                        </div>
                        <!--<p>New password</p>-->
                        <div class="form-input">
                            <span>New password</span>
                            <input ng-model="change.password" class="normalFont blueInput"
                                   ng-model-options="{debounce: 1000}" ng-change="validatePassword()"
                                   name="newPass" type="password" value="" placeholder="New password"/>
                            <span ng-show="change.password.length < 8 && showError.all" style="color: red">New Password can not be less than 8 characters</span>    
                        </div>
                        <!--<p>Retype password</p>-->
                        <div class="form-input">
                            <span>Retype password</span>
                            <input ng-model="change.rePassword" class="normalFont blueInput"  
                                   ng-model-options="{debounce: 1000}" ng-change="validatePassword()"
                                   name="reNewPass" type="password" value="" placeholder="Retype password"/>     
                            <div ng-show="showError.matchPassword">
                                <p ng-show="missing.matchPassword" style="color: green">Match</p>
                                <p ng-show="!missing.matchPassword" style="color: red">Not Match</p>
                            </div>
                        </div>

                        <div class="form-input">

                            <button type="submit" class="btn-width-orange">Save</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js?999"/>"></script>
        <script>

                                    var page = '${requestScope.page}';
                                    var uploadUrl = '<c:url value="/Provider/UploadImage"/>';
                                    $(document).ready(function () {
                                        toggleHeader.init({
                                            toggleControl: false
                                        });

                                    });
        </script>
    </body>
</html>
