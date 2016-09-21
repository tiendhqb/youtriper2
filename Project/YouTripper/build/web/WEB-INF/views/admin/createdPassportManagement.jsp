<%-- 
    Document   : createdPassportManagement
    Created on : May 26, 2016, 10:23:53 AM
    Author     : Tien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=1366">
        <!--        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1">-->
        <!--<script src='https://www.google.com/recaptcha/api.js'></script>-->
        <script src="https://www.google.com/recaptcha/api.js?onload=vcRecaptchaApiLoaded&render=explicit" async defer></script>
        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">

        <%@ include file="../angular.jsp" %>
        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css?999999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css?999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >

        <script src="<c:url value="/Resources/Theme/js/sorttable.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <title>Youtripper - Provider Passport</title>
    </head>
    <body>
        <div class="pagesearch" ng-app="YouTripper" ng-controller="ManagePassportController">
            <%@ include file="../header.jsp" %>
            <%@ include file="adminMenubar.jsp" %>
            <div id="spinner-block" ng-hide="loaded">
                <div class="youtripper-spinner"></div>
            </div>
            <div class="site-container">
                <div class="col-sm-9 col-md-10 affix-content">
                    <div class="container"  ng-cloak ng-show="loaded">
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane active" id="step3">
                                <div class="tab-bucket tab-bucket-fix">
                                    <div class="tab-content">
                                        <table class="table" style="width:90%;">
                                            <thead>
                                                <tr>
                                                    <th>Provider ID</th>
                                                    <th>Name</th>
                                                    <th>Business Name</th>
                                                    <th>Email</th>
                                                    <th>Passport</th>
                                                    <th>Time</th>
                                                    <!--                                                    <th>Approved</th>-->
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr ng-repeat="passport in passports | orderBy:sortType">
                                                    <td>{{passport.providerID}}</td>
                                                    <td>  <a href="<c:url value="/Common/ProviderPage/"/>{{passport.providerID}}" target="_self">
                                                            <span style="color:#337ab7"> {{passport.firstName}}</span></td>
                                                    <td>{{passport.businessName}}</td>
                                                    <td>{{passport.email}}</td>
                                                    <td><a href='/{{passport.imagePassport}}' target="_blank"><img style="background:url('/{{passport.imagePassport}}'); background-size:100% 100%" height="50" width="50"></img></a></td>
<!--                                                    <td> <a id="linkPassport" href='/{{passport.imagePassport}}' target="_blank">Image Link </a></td>-->
                                                    <!--                                                    <td>{{passport.passportStatus}}</td>-->
                                                    <td>{{convertTime(passport.passportUploadTime)}}</td>
                                                    <td><input class="checkApprove" type="checkbox" name="action" value="{{passport.providerID}}"></td>

                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="">
                                        <a  ng-click="ApprovingPassport()" class="boxer btn btn-provider btnRed-provider">Approve</a>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js?999"/>"></script>
        <script>
                                            var passports = ${requestScope.createdPassports};
                                            var page = '${requestScope.page}';
                                            $(document).ready(function () {
                                                toggleHeader.init({
                                                    toggleControl: false
                                                });
                                            });
        </script>
    </body>
</html>
