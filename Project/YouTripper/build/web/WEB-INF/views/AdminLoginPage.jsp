<%-- 
    Document   : adminLogin
    Created on : Oct 20, 2015, 3:39:11 PM
    Author     : Nick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html id="loginPage">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--        <meta name="viewport" content="width=device-width, initial-scale=1">-->
        <meta name="viewport" content="width=1366">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="">
        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >

        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">

        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css?999999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css?999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css?9999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css?9999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style-login.css?9999"/>" >

        <script src="<c:url value="/Resources/Theme/js/angular.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/angular-recaptcha.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/checklist-model.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/ng-file-upload-shim.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/ng-file-upload.min.js"/>"></script>

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>

        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <%@ include file="angular.jsp" %>
        <title>YouTripper - Admin Login Page</title>

    </head>
    <body>
        <div ng-app="YouTripper" ng-controller="BeAdminController" class="pagesearch">
            <%--<%@ include file="header.jsp" %>--%>
            <div class="signin_form">
                <div class="login-body">
                    <p style="color:red;">${requestScope.errorAdminLogin}</p>
                    <form method="POST" action="<c:url value="/Common/AdminLogin"/>" name="signin_form" id="signin_form" style="margin: 0px;">

                        <div class="login-form-input">

                            <input name="username" type="text" id="emailLogin" class="normalFont blueInput"
                                   placeholder="Email Address" />
                        </div>
                        <div class="login-form-input">
                            <input name="password" type="password" class="normalFont blueInput"
                                   id="passwd" placeholder="Password" />
                        </div>
                        <div class="login-form-input">
                            <input type="submit" name="login" value="Login" class="btn-width-orange" />
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <%--<%@ include file="footer.jsp" %>--%>
        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js?99"/>"></script>
        <script>
            $(document).ready(function () {
                new toggleHeader.init({
                    toggleControl: false
//                                            toggleTheme: true
                });
            });
        </script>
    </body>
</html>
