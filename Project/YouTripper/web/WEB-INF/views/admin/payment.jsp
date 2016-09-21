<%-- 
    Document   : createdPackageManagement
    Created on : Oct 20, 2015, 4:49:10 PM
    Author     : Nick
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

        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css?999999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css?999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <title>Youtripper - Payment Management</title>
    </head>
    <body>
        <div ng-app="YouTripper" ng-controller="ManagePaymentController">
            <%@ include file="../header.jsp" %>
            <%@ include file="adminMenubar.jsp" %>
            <div class="site-container">
                <div class="col-sm-9 col-md-10 affix-content">
                    <div class="">
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane active " id="step2">
                                <div class="tab-message">
                                    <h2>Payment List ({{paymentSize}})</h2>
                                    <br />
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="tasleft">
                                                <ul class="tasleft-caption" style="text-align: center; color: white;">
                                                    Payment List
                                                </ul>
                                                <div id="Messages">
                                                    <div class="message-left" style="overflow: scroll;">
                                                        <div class="search-message">
                                                            <div class="search-message-inner">
                                                                <input type="text" value="Search" />
                                                                <button></button>
                                                            </div>
                                                        </div>
                                                        <ul class="list-resulft">
                                                            <li ng-click="Selectprovider(x.providerID)" ng-class="{ 'active':selectOrNot(x.providerID) }" ng-repeat="x in paymentList" class="group">
                                                                <div class="avatar">
                                                                </div>
                                                                <h3>{{x.lastName}}<span>$ {{x.total}}</span></h3>
                                                                <h3>&nbsp; <span>View Detail</span></h3>
                                                            </li>                                                    
                                                        </ul>
                                                    </div>
                                                </div>                                       
                                            </div>



                                        </div>
                                        <div class="col-md-8" style="overflow: scroll; height: 520px;">
                                            <div class="" id="BookingDetail" ng-hide="loadingDetail">
                                                <div ng-repeat="x in bookingDetailList" class="row-message">
                                                    <div class="avatar">
                                                    </div>
                                                    <h3><strong>{{x.code}}</strong> <span>{{x.bookingDate}}</span></h3>
                                                    <p>Number Of Adults : {{x.numberOfAdults}}<br>Number Of Childs : {{x.numberOfChilds}} <br>Total : {{(x.numberOfAdults * x.adultPrice + x.numberOfChilds * x.childPrice) * (100 - x.youTripperPercentage) / 100}}
                                                    </p>
                                                    <div class="line-message"></div>
                                                </div>                                           
                                            </div>
                                            <div class="" id="BookingDetail" ng-show="loadingDetail">
                                                <div class="chat-spinner">
                                                </div>
                                            </div>
                                        </div>
                                        <form action="<c:url value="/Admin/Payout"/>" method="POST">
                                            <div style="float:right">
                                                <input name="submit" value="Export" class="btn btn-provider" type="submit">
                                                <input name="submit" value="Payout" class="btn btn-provider" type="submit">
                                            </div>
                                        </form>
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
                                        var paymentList = ${requestScope.paymentList};
                                        var page = '${requestScope.page}';
                                        var viewBookingDetailURL = '<c:url value="/Admin/ViewBookingDetail"/>';
                                        $(document).ready(function () {
                                            toggleHeader.init({
                                                toggleControl: false
                                            });
                                        });
        </script>
    </body>
</html>
