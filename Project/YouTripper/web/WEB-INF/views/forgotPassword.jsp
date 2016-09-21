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

        <title>YouTripper - Forgot Password</title>
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
        <div class="pagesearch" ng-app="YouTripper" ng-controller="ForgotPasswordController">

            <%@ include file="header.jsp" %>

            <c:if test="${sessionScope.account == null}">
                <div class="center_form">
                    <div class="red-title">
                        Reset Password
                    </div>
                    <div class="form-body">

                        <form class="ytForm" 
                              action="
                              <c:choose>
                                  <c:when test="${empty param.language}">
                                      <c:url value="/Common/RequestResetPassword"/>
                                  </c:when>
                                  <c:otherwise>
                                      <c:url value="/Common/RequestResetPassword?language=${param.language}"/>
                                  </c:otherwise>
                              </c:choose>" 
                              method="POST" name="forgetform" id="forgetform" ng-submit="validateForgotPasswordForm($event)">
                            <div class="form-input"><p >Enter the email address associated with your account, and we'll email you a link to reset your password.</p></div>
                            <div class="form-input">
                                <input class="normalFont blueInput" type="text" ng-model="register.email" name="email" id="email" placeholder="Your registered email" required>
                            </div>
                            <div class="form-input" ng-show="showError.emailValid || showError.all">
                                <span  >
                                    <span class="form-input" ng-show="!missing.emailValid && forgetform.email.$valid" style="color: green">Email is valid!</span>
                                    <span class="form-input" ng-show="missing.emailValid && forgetform.email.$valid" style="color: red">Email not valid!</span>

                                </span>
                            </div>
                            <div class="form-input">
                                <input  type="submit" name="submit" value="Send Reset Link" class="btn-width-orange">
                            </div>
                            <input name="site" type="hidden" id="site" value="/">

                        </form>
                    </div>
                </div>
            </c:if>  

            <c:if test="${sessionScope.account != null}">
                <div style="text-align: center;">
                    <h4>Please navigate to Password tab in Profile page to change password!</h4>   
                </div>
            </c:if>
            <%--<%@ include file="footer.jsp" %>--%>
            <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/main.js?99"/>"></script>
            <script>
                                                var checkEmailUrl = '<c:url value="/Common/checkEmail"/>';
                                                var email = '${param.email}';
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
