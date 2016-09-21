<%-- 
    Document   : Booking
    Created on : Nov 2, 2015, 12:26:49 PM
    Author     : DINH KHANG
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
        <title>Youtripper - Provider Bookings</title>
        <style>

        </style>
    </head>
    <body ng-app="YouTripper" ng-controller="BookingManagementController" id="BookingCtr" >
        <div style="position: fixed; top: 0; bottom: 0; left: 0; right: 0; background: #fff; z-index: 99999" ng-show="loading">
            <div class="youtripper-spinner" ></div>
        </div>
        <div class="pagesearch">
            <%@ include file="../header.jsp" %>
            <%@ include file="providerMenubar.jsp" %>
            <div class="site-container">
             <div class="col-sm-9 col-md-10 affix-content">
                   <div class="container"  ng-cloak ng-show="loaded">
                <div class="bookings-content">
                    <div class="calendar-content">
                        <div class="package-selection">
                            <select name="singleSelect" ng-model="selectedPackage" class="dropdownGray" convert-to-number>
                                <option value="0">All Packages</option>
                                <option ng-repeat="package in packages" value="{{package.id}}">{{package.name}}</option>
                            </select>
                        </div>
                        <div class="calendar-explain">
                            <ul class="row">
                                <li class="noBook-explain">Number of booking</li>
                                <li class="bookDay-explain">Booking Day</li>
                                <li class="noTripper-explain">Number of tripper</li>
                            </ul>
                        </div>
                        <div id="bookingManagementCalendar">
                        </div>
                        <div class="total-overall">
                            <p ng-show="specificDateBooking === undefined">0 bookings, 0 trippers</p>
                            <p ng-show="specificDateBooking !== undefined">{{specificDateBooking.noBookings}} bookings, {{specificDateBooking.noTrippers}} trippers</p>
                        </div>
                    </div>
                    <div class="detail-content">
                        <!--                        <div class="calendar-explain">
                                                    <ul class="row">
                                                        <li class="col-xs-3 noBook-explain">Number of tripper</li>
                                                        <li class="col-xs-3 bookDay-explain">Booking Day</li>
                                                    </ul>
                                                </div>-->
                        <div class="center-informBlock" ng-hide="detailLoaded">
                            <div class="small-spinner" ></div>
                        </div>
                        <div class="center-informBlock" ng-if="sizeOfHashMap(trippers.packages) <= 0 && detailLoaded">
                            No bookings on this day.
                        </div>
                        <ul class="detail-list" ng-if="sizeOfHashMap(trippers.packages) > 0 && detailLoaded">
                            <li class="detail-package-name" ng-click="selectPackageToDetail(key)" ng-repeat="(key, value) in trippers.packages" ng-if="key === selectedDetail">
                                <a href="" ng-click="selectPackageToDetail(key)" class="packageName">{{value}}</a>
                                <ul class="detail-table active">
                                    <li class="detail-header">
                                        <ul class="row">
                                            <li class="col-xs-5">    
                                                User
                                            </li>
                                            <li class="col-xs-2">
                                                No. Tripper
                                            </li>
                                            <li class="col-xs-2">
                                                Booking Code
                                            </li>
                                            <li class="col-xs-3">    
                                                Booking Day
                                            </li>
                                        </ul>
                                    </li>
                                    <li class="detail-user" ng-repeat="detail in trippers.details| filter: {packageID : key}">
                                        <ul class="row">
                                            <li class="col-xs-5 user-detailName">
                                                <a href="{{contextPath}}/Common/TripperPage/{{detail.tripperID}}" target="_self"><span style="background-image: url(/{{detail.tripperImage}})"></span></a>
                                                <!--<span style="background-image: url(/Images/Provider/8/provider.png)"></span>-->
                                                <a href="{{contextPath}}/Common/TripperPage/{{detail.tripperID}}" target="_self">{{detail.tripperLastName}} {{detail.tripperFirstName}}</a>
                                            </li>
                                            <li class="col-xs-2 user-noTripper">
                                                {{detail.noTripper}}
                                            </li>
                                            <li class="col-xs-2 booking-code">
                                                <a href="" ng-click="loadBookingCode(detail.bookingCode)" target="_self">{{detail.bookingCode| limitTo: 7}}</a>
                                            </li>
                                            <li class="col-xs-3 booking-day">    
                                                {{detail.bookingDate| limitTo: 10}}
                                            </li>
                                        </ul>

                                    </li>
                                </ul>
                                <div class="bookingDetail">
                                    <div class="center-inform" ng-hide="bookingCodeloaded">
                                        <div class="small-spinner" ></div>
                                    </div>
                                    <div class="tripperInfo">
                                        <a href="{{contextPath}}/Common/TripperPage/{{bookingDetail.tripperID}}" target="_selft"> 
                                            <span style="background-image: url(/{{bookingDetail.tripperImage}})"></span>
                                        </a>
                                      
                                        <a href="{{contextPath}}/Common/TripperPage/{{bookingDetail.tripperID}}" target="_selft">{{bookingDetail.tripperLastName}} {{bookingDetail.tripperFirstName}}</a>
                                    </div>
                                    <div class="bookingInfo">
                                        <h5>Booking detail</h5>
                                        <ul>
                                            <li>Arrival date: {{bookingDetail.selectedDate}}</li>
                                            <li>Location: {{bookingDetail.packageCity}} {{bookingDetail.packageState}} {{bookingDetail.packageCountry}}</li>
                                            <li>Booking code: {{bookingDetail.code}}</li>
                                            <li>Trip start: {{bookingDetail.packageDepartureTime}}</li>
                                            <li>No. Tripper: {{bookingDetail.numberOfAdults + bookingDetail.numberOfChilds}}</li>
                                        </ul>
                                    </div>
                                </div>
                            </li>

                            <li class="detail-package-name" ng-click="selectPackageToDetail(key)" ng-repeat="(key, value) in trippers.packages" ng-if="key !== selectedDetail">
                                <a href="" ng-click="selectPackageToDetail(key)" class="packageName">{{value}}</a>
                            </li>
                        </ul>

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
                                            var bookingOverview = ${requestScope.bookingsOverview};
                                            var packages = ${requestScope.packages};
                                            $(document).ready(function () {
                                                toggleHeader.init({
                                                    toggleControl: false
                                                });
                                            });
        </script>
    </body>
</html>
