<%-- 
    Document   : beProvider
    Created on : Oct 21, 2015, 2:25:38 PM
    Author     : Nick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html id="loginPage">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=1366">
        <!--        <meta name="viewport" content="width=device-width, initial-scale=1">-->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="">
        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >

        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css?999999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css?999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style-login.css"/>" >
        <%@ include file="angular.jsp" %>
        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>

        <title>YouTripper - Change Password</title>
    </head>
    <body>
        <!-- Google Tag Manager -->
        <noscript><iframe src="//www.googletagmanager.com/ns.html?id=GTM-MZRL8C"
                          height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
        <script>(function (w, d, s, l, i) {
                w[l] = w[l] || [];
                w[l].push({'gtm.start':
                            new Date().getTime(), event: 'gtm.js'});
                var f = d.getElementsByTagName(s)[0],
                        j = d.createElement(s), dl = l != 'dataLayer' ? '&l=' + l : '';
                j.async = true;
                j.src =
                        '//www.googletagmanager.com/gtm.js?id=' + i + dl;
                f.parentNode.insertBefore(j, f);
            })(window, document, 'script', 'dataLayer', 'GTM-MZRL8C');</script>
        <!-- End Google Tag Manager -->
        <div class="pagesearch" ng-app="YouTripper" ng-controller="GuestChangePasswordController">

            <%@ include file="header.jsp" %>
            <div class="signin_form container section-content padding-header">
                <!-- InstanceBeginEditable name="content" -->

                <div class="error-title">
                    Reset Password
                </div>
                <div class="login-body">
                    <div style="color: red">${requestScope.error} </div>
                    <div><p id ="forgotPasswordContent">Enter your new password below</p></div>
                    <form action="
                          <c:choose>
                              <c:when test="${empty param.language}">
                                  <c:url value="/Common/SubmitChangePassword"/>
                              </c:when>
                              <c:otherwise>
                                  <c:url value="/Common/SubmitChangePassword?language=${param.language}"/>
                              </c:otherwise>
                          </c:choose>" 
                          method="POST" id="ChangePassForm" name="ChangePassForm" ng-click="validateChangPassword($event)">
                        <div class="login-form-input">
                            <input style="display:none" name="token" type="text" id="regMail" value="${requestScope.ResetToken}">
                        </div>
                        <div class="login-form-input">
                            <input class="normalFont blueInput" ng-model="change.password" name="password" type="password" placeholder="Your new password">
                        </div>
                        <div class="login-form-input">
                            <input class="normalFont blueInput" ng-model="change.rePassword" name="rePassword" type="password" placeholder="Re-enter new password">
                        </div>
                        <div class="login-form-input">
                            <input class="btn-width-orange" type="submit" name="submit" value="Reset" class="btn-width-orange">
                        </div>
                        <input name="site" type="hidden" id="site" value="/">


                        <span ng-show="showError.matchPassword">
                            <span ng-show="missing.matchPassword" style="color: green">Password Match</span>
                            <span ng-show="!missing.matchPassword" style="color: red">Password Not Match</span>
                        </span>

                    </form>

                </div>
                <!-- InstanceEndEditable -->
            </div>
            <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/main.js?99"/>"></script>
            <script>
                                        $(document).ready(function () {
                                            SpinnerText.init('ul[data-spinner]');

                                            new toggleHeader.init({
                                                toggleControl: false
//                                            toggleTheme: true
                                            });
                                        });
            </script>
        </div>
    </body>
</html>
