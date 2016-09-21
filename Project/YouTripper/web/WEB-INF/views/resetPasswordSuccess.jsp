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

        <title>YouTripper - Reset Password Success</title>
    </head>
    <body>
        <div class="pagesearch">

            <%@ include file="header.jsp" %>
            <div class="signin_form container section-content padding-header">

                <div class="error-title">
                    Reset Password Success
                </div>
                <!-- InstanceBeginEditable name="content" -->

                <div class="login-body">
                    <div><p id ="forgotPasswordContent">Your password was reset, now you can login again!</p></div>

                    <div class="login-form-input">
                        <input onclick="location.href = '
                               <c:choose>
                                   <c:when test="${empty param.language}">
                                       <c:url value="/LoginPage"/>
                                   </c:when>
                                   <c:otherwise>
                                       <c:url value="/LoginPage?language=${param.language}"/>
                                   </c:otherwise>
                               </c:choose>';" 
                               type="submit" name="submit" value="Login" class="btn-width-orange">
                    </div>
                    <input name="site" type="hidden" id="site" value="/">


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
