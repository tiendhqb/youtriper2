<%-- 
    Document   : providerPassport
    Created on : May 25, 2016, 5:00:50 PM
    Author     : Tien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="background-provider">
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
        <title>Passport Management</title>
    </head>
    <body>
        <div class="pagesearch" ng-app="YouTripper" ng-controller="ProviderPassport">
            <%@ include file="../header.jsp" %>
            <%@ include file="providerMenubar.jsp" %>
            <div style="width:100%; background-color: #f2f2f4">
                <div class="col-sm-9 col-md-10 affix-content">
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="step1">
                            <div class="tab-account">
                                <div style="text-align: center" class="box-account box-account-edit row">
                                    <h2 id="yourpassport">Your Passport </h2>
                                    <div class="upload-passport group col-md-12 col-sm-12 ">
                                        <img ngf-drop ngf-select ng-model="providerImage" style="cursor: pointer"
                                             ngf-drag-over-class="dragover" ngf-allow-dir="true"
                                             accept="image/*"
                                             ngf-pattern="'image/*'" alt="" ng-src="/{{accountInfo.imagePassport}}?{{currentTime}}" />
                                        <div ng-if="accountInfo.passportStatus" > 
                                            <div class="passportApproved">

                                                <span  class ="centerImageEdit" ></span>
                                                Passport is approved
                                                </br>
                                            </div>

                                        </div>
                                        <div ng-if="!accountInfo.passportStatus" >
                                            <div class="passportnotApproved">

                                                <span  class ="centerImageEdit" ></span>
                                                Passport is not approved
                                                </br>

                                            </div>
                                        </div>
<!--                                        <p ngf-drop ngf-select ng-model="providerImage" style="cursor: pointer"
                                           ngf-drag-over-class="dragover" ngf-allow-dir="true"
                                           accept="image/*"
                                           ngf-pattern="'image/*'">Upload Passport Picture</p>-->
                                        <div id="upload-passport" style="text-align: center">
                                            <a style="width:440px; margin-top: 5px" href="#" class="btn-width-orange login_gg"
                                              ng-model="providerImage" 
                                               ngf-allow-dir="true" accept="image/*" ngf-pattern="'image/*'" ngf-select >Upload Passport Picture</a>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <%--<%@ include file="../footer.jsp" %>--%>
        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js?999"/>"></script>
        <script>
                                                                   var providerInfo = ${requestScope.AccountInfo};
                                                                   var page = '${requestScope.page}';
                                                                   var uploadUrl = '<c:url value="/Provider/UploadPassportImage"/>';
                                                                   $(document).ready(function () {
                                                                       toggleHeader.init({
                                                                           toggleControl: false
                                                                       });
//                                           
                                                                   });
        </script>
    </body>
</html>
