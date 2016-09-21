<%-- 
    Document   : adminLogin
    Created on : Oct 20, 2015, 3:39:11 PM
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
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style-addon.css?999999999999"/>" >

        <script src="<c:url value="/Resources/Theme/js/angular.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/angular-recaptcha.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/checklist-model.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/ng-file-upload-shim.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/ng-file-upload.min.js"/>"></script>

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>

        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>

        <title>YouTripper - Salesman Login Page</title>

    </head>
    <body>
        <div ng-app="BeAdmin" ng-controller="BeSalesController" class="pagesearch">
            <%@ include file="../header.jsp" %>
            <div class="container section-content padding-no-header ">
                <div class="row">
                    <div class="col-md-10 member-form-content">
                        <div class="signin_form">
                            <form method="POST" action="<c:url value="/Common/SalesmanLogin"/>" class="form-horizontal"
                                  name=signin_form id="signin_form" style="margin: 0px;">
                                <div>
                                    <input name="username" type="text"  class="normalFont" id="email" placeholder="Username">
                                </div>
                                <div>
                                    <input name="password" type="password"  class="normalFont" id="password" placeholder="Password">
                                </div>
                                 <div>
                                     <input type="submit" name="login" value="Login" class="button" />
                                 </div>
                            </form>
                        </div>
                        <div align="center" style="padding: 10px;"></div>
                    </div>
                    <div class="col-md-2 member-form-sidemenu"></div>
                </div>
            </div>
        </div>
        <%@ include file="../footer.jsp" %>
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
