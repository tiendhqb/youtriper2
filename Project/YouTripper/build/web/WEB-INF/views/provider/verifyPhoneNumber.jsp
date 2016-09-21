<%-- 
    Document   : verifyPhoneNumber
    Created on : Oct 29, 2015, 5:48:11 PM
    Author     : DINH KHANG
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
        <link href="<c:url value="/Resources/Theme/css/pepper-ginder-custom.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/lightgallery.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/lg-transitions.css"/>" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css?999999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css?999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style-login.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripperResponsive.css"/>" >

        <script src="<c:url value="/Resources/Theme/js/angular.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/angular-recaptcha.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/checklist-model.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/ng-file-upload-shim.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/ng-file-upload.min.js"/>"></script>
        <%@ include file="../angular.jsp" %>
        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>

        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <!--<script src="<c:url value="/Resources/Theme/js/jquery-ui.multidatespicker.js"/>"></script>-->
        <script src="<c:url value="/Resources/Theme/js/lightgallery.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/lg-thumbnail.js"/>"></script>
        <title>Verify PhoneNumber</title>

    </head>
    <body>
        <div ng-app="YouTripper" ng-controller="VerifyPhoneCtrl" class="pagesearch">
            <%@ include file="../header.jsp" %>
            <div class="container section-content padding-no-header ">
                <div id="PhoneContainer" class="row">
                    <div class="col-md-10 member-form-content">

                        <div id="phoneForm" class="signin_form">
                            <span class="phone-step1">                                

                                <div id="errormess" style="color: #E95D48">   ${requestScope.error} </div>
                                Phone Number :<select class="select-country" id="countryList" name="singleSelect" ng-model="selected" ng-options="item as item.name for item in items track by item.code">
                                </select>
                                <input id="phoneNum" class="input-phoneNumber" type="text" ng-model="phoneNumber" placeholder="">                
                                <button class="sendSMS" ng-click="sendSMS()" >Next</button>                            
                            </span>
                            <span class="phone-step2" style="display: none">
                                <label id="exceeded" style="color: #E95D48;font-size: 14px">{{messexceeded}}</label>
                                <label style="color: #E95D48;font-size: 14px;padding-left: 100px">{{messResult}}</label><br>
                                SMS Code:<input class="input-phoneNumber" type="text" ng-model="SMSCode" placeholder="Enter your code"> <button class="sendSMS" ng-click="verifySMS()" >Verify</button>
                                <br>
                                <a class="href-orange" style="padding-left: 110px" href="#" ng-click="resendSMS()">Resend the code</a>
                            </span>

                        </div>
                        <div align="center" style="padding: 10px;"></div>
                    </div>
                    <div class="col-md-2 member-form-sidemenu"></div>
                </div>
                <!--<div class="clearfooter"></div>-->
            </div>

        </div>
        <%@ include file="../footer.jsp" %>
        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.plugin.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/wow.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js"/>"></script>
        <script>
                                    var countryList = ${requestScope.countryList};
                                    var phoneObject = ${requestScope.phoneNumber};
                                    var sendSMSUrl = '<c:url value="/Provider/SendSMS/"/>${sessionScope.account.id}';
                                    var verifySMSUrl = '<c:url value="/Provider/VerifySMS/"/>${sessionScope.account.id}';
                                    var profilePage = '<c:url value="/Provider/AccountInfo"/>';
                                    $(document).ready(function () {
                                        toggleHeader.init({
                                            toggleControl: false
                                        });
                                    });
        </script>
        <script src="<c:url value="/Resources/Theme/js/youtripper.js?9999999999999999999999999999999999999999999999999999999999"/>"></script>
        <script type='text/javascript' src="https://maps.googleapis.com/maps/api/js?&sensor=false&extension=.js"></script>
    </body>
</html>
