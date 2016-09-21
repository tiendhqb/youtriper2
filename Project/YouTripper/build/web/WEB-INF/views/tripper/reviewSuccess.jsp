<%-- 
    Document   : beProvider
    Created on : Oct 21, 2015, 2:25:38 PM
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
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style-login.css"/>" >
        <%@ include file="../angular.jsp" %>
        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>

        <title>YouTripper - Review Successful Page</title>
    </head>
    <body>
        <div class="pagesearch">
            <%@ include file="../header.jsp" %>
            <div class="padding-header">
                <!--Selector-->
                <div class="container">
                    <div class="inbox-bea payment-bea">
                        <img alt="" src="<c:url value="/Images/Icon/booking-successful.png"/>" />
                        <p class="main-content">Review successful. Thank you for feedback.</p>
                        <p class="sub-content">Lorem ipsum dolor sit amet, consectetur email adipiscing elit. Nulla ultricies aliquam nisi non aliquet.<br/>
                            Curabitur congue elit non nibh pulvinar euismod.</p>
                    </div>
                </div>
            </div>
            <%@ include file="../footer.jsp" %>
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
