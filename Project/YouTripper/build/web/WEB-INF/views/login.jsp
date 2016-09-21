<%-- 
    Document   : login
    Created on : Oct 21, 2015, 10:09:46 AM
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

        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style-login.css"/>" >

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>

        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>

        <%@ include file="angular.jsp" %>


        <title>YouTripper - Login Page</title>
        <style>

        </style>

    </head>
    <body>
        <div ng-app="YouTripper" class="pagesearch" ng-controller="LoginController">
            <%@ include file="header.jsp" %>

            <div class="center_form" id="signin_form">
                <c:if test="${requestScope.loginfail != null}">
                    <div class="red-title">
                        Your username or password is incorrect!
                    </div>
                </c:if>
                <div class="form-body">
                    <form method="POST" action="<c:url value="/Login"/>" name="signin_form" id="signin_form" class="ytForm" style="margin: 0px;">
                        <input style="display:none" name="review" type="text" class="normalFont"
                               value="${requestScope.review}" placeholder="" />
                        <input style="display:none" name="selectedDate" type="text" class="normalFont"
                               value="${requestScope.selectedDate}" placeholder="" />
                        <input style="display:none" name="numberOfAdults" type="text" class="normalFont"
                               value="${requestScope.numberOfAdults}" placeholder="" />
                        <input style="display:none" name="numberOfChilds" type="text" class="normalFont"
                               value="${requestScope.numberOfChilds}" placeholder="" />
                        <input style="display:none" name="packageID" type="text" class="normalFont"
                               value="${requestScope.packageID}" placeholder="" />

                        <div class="form-input">
                            <input name="email" type="text" id="emailLogin" class="normalFont blueInput"
                                   value="${requestScope.loginfail}" placeholder="Email Address" />
                        </div>
                        <div class="form-input">
                            <input name="password" type="password" class="normalFont blueInput"
                                   id="passwd" placeholder="Password" />
                        </div>
                        <div class="form-input">
                            <div class="tempCheckbox blueInput">
                                <input type="checkbox" name="rememberMe" id="remember-me">
                                <span></span>
                            </div>
                            <p>Remember me</p>
                        </div>

                        <div class="form-input" style="text-align:center">
                            <a href="<c:url value="/Common/ForgotPassword"/>" style="color: #E76B4A">
                                <input name="site" type="hidden" id="site" value="/">Forgot Password?
                            </a>
                        </div>

                        <div class="form-input">
                            <input type="submit" name="login" value="Login" class="btn-width-orange" />
                        </div>
                        <div class="form-input" style="text-align:center;">
                            Or
                        </div>
                        <div class="form-input">
                            <a ng-click="fblogin()" class="btn-width-orange login_fb button">
                                Log in with Facebook</a>
                        </div>
                        <div class="form-input">
                            <a ng-click="googlelogin()" class="btn-width-orange login_gg button">
                                Log in with Google
                            </a>
                        </div>
                        <div align="center" style="padding: 20px 0px;color:#9c9b9b">Don't have an account? <a href="<c:url value="/Common/Tripper/SignupPage"/>" style="color: #E76B4A">Sign up</a></div>
                    </form>
                </div>
            </div>

        </div>
    </body>
    <script src="<c:url value="/Resources/Theme/js/script.min.js"/>"></script>
    <script src="<c:url value="/Resources/Theme/js/main.js"/>"></script>
    <script>
                                $(document).ready(function () {
                                    new toggleHeader.init({
                                        toggleControl: false
//                                            toggleTheme: true
                                    });
                                });
                                //facebook sdk config
                                window.fbAsyncInit = function () {
                                    FB.init({
                                        appId: '295105870823227',
                                        cookie: true, // enable cookies to allow the server to access 
                                        // the session
                                        xfbml: true, // parse social plugins on this page
                                        version: 'v2.6' // use graph api version 2.6

                                    });
                                };
                                // Load the SDK asynchronously
                                (function (d, s, id) {
                                    var js, fjs = d.getElementsByTagName(s)[0];
                                    if (d.getElementById(id))
                                        return;
                                    js = d.createElement(s);
                                    js.id = id;
                                    js.src = "//connect.facebook.net/en_US/sdk.js";
                                    fjs.parentNode.insertBefore(js, fjs);
                                }(document, 'script', 'facebook-jssdk'));
                                //Google login
    </script>
</html>
