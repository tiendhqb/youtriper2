<%-- 
    Document   : createdPackageManagement
    Created on : Oct 20, 2015, 4:49:10 PM
    Author     : Nick
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
        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/jquery.fs.boxer.css"/>" rel="stylesheet">


        <%@ include file="../angular.jsp" %>

        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css?999999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css?999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripperResponsive.css"/>" >

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.fs.boxer.js"/>"></script>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >
        <title>Youtripper - Provider TrippDash</title>
    </head>
    <body>
        <div ng-app="YouTripper" ng-controller="TrippDashController" class="pagesearch bg-grey" >
            <%@ include file="../header.jsp" %>
            <%@ include file="providerMenubar.jsp" %>
            <div class="center-informBlock white-backgroud full-screen" ng-hide="loaded">
                <div class="small-spinner" ></div>
            </div>
            <div class="site-container" ng-init="thistoggleUnderConstructionBox()">
                <div class="affix-content">
                    <div ng-cloak ng-show="loaded">
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane active">
                                <div class="tab-bucket tab-bucket-fix">
                                    <div id="dashboard">
                                        <div id="dashboard-container">
                                            <div class="clearfix dashboard-row">
                                                <div class="dashboard-col dashboard-left">
                                                    <div id="date-and-resourceOv"> 
                                                        <div class="date-row clearfix">
                                                            <div class="date-col">
                                                                <div class="resource-box" id="date-box">
                                                                    <div class="resource-box-container">
                                                                        <div class="resource-boxHeader" >
                                                                            <div class="clearfix">
                                                                                <div class="slt-month">
                                                                                    {{getDay()}}
                                                                                </div>

                                                                                <div class="slt-day">
                                                                                    {{getMonth()}}
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="resource-boxBody">
                                                                            <div class="box-number">
                                                                                <div class="tbl-center">
                                                                                    <div class="tbl-cell">
                                                                                        <p>{{getDate()}}</p>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <a class="left-arrow arrow" ng-click="previousDay()">

                                                                            </a>
                                                                            <a class="right-arrow arrow" ng-click="nextDay()">

                                                                            </a>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="date-col">
                                                                <div class="resource-box">
                                                                    <div class="resource-box-container">
                                                                        <div class="resource-boxHeader hasMenu">
                                                                            <a href="" id="bookingSelect" class="header-hover" ng-click="selectBookingType()">
                                                                                {{selectedTotal === 'booking' ? 'Total Bookings':'Total Sales'}}
                                                                                <span class="white-down-arrow"></span>
                                                                            </a>
                                                                            <div id="bookingDropdown"  class="header-menu">
                                                                                <ul>
                                                                                    <li>
                                                                                        <a ng-click="selectedTotal = 'booking'" href="#">Total Bookings</a>
                                                                                    </li>
                                                                                    <li>
                                                                                        <a ng-click="selectedTotal = 'sale'" href="#">Total Sales</a>
                                                                                    </li>
                                                                                </ul>
                                                                            </div>
                                                                        </div>
                                                                        <div class="resource-boxBody">
                                                                            <div class="center-informBlock blur-backgroud" ng-show="loadingResouceWithDate">
                                                                                <div class="small-spinner" ></div>
                                                                            </div>
                                                                            <div class="box-number">
                                                                                <div class="tbl-center">
                                                                                    <div class="tbl-cell">
                                                                                        <p>{{selectedTotal === 'booking' ? tripDash.totalBookingInTripDash.totalBookings: tripDash.totalBookingInTripDash.totalSale}}</p>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="date-row clearfix">
                                                            <div class="date-col">
                                                                <div class="resource-box">
                                                                    <div class="resource-box-container">
                                                                        <div class="resource-boxHeader hasMenu">
                                                                            <a href="" id="resourceSelectType" class="header-hover" ng-click="resourceSelectType()">
                                                                                {{selectResourceOrQuota === 'resource' ? 'Booked Resources':'Filled Quotas'}}
                                                                                <span class="white-down-arrow"></span>
                                                                            </a>
                                                                            <div id="resourceSelect" class="header-menu">
                                                                                <ul>
                                                                                    <li>
                                                                                        <a ng-click="selectResourceOrQuota = 'resource'" href="#">Booked Resources</a>
                                                                                    </li>
                                                                                    <li>
                                                                                        <a ng-click="selectResourceOrQuota = 'quota'" href="#">Filled Quotas</a>
                                                                                    </li>
                                                                                </ul>
                                                                            </div>
                                                                        </div>
                                                                        <div class="resource-boxBody">
                                                                            <div class="center-informBlock blur-backgroud" ng-show="loadingResouceWithDate">
                                                                                <div class="small-spinner" ></div>
                                                                            </div>

                                                                            <div class="box-number">
                                                                                <div class="tbl-center">
                                                                                    <div class="tbl-cell">
                                                                                        <p>{{selectResourceOrQuota === 'resource' ? tripDash.totalBookingInTripDash.noBookedResources : tripDash.totalBookingInTripDash.noFilledQuotas}}</p>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="date-col">
                                                                <div class="resource-box">
                                                                    <div class="resource-box-container">
                                                                        <div class="resource-boxHeader hasMenu">
                                                                            <a href="" id="freeResourceSelectType" class="header-hover" ng-click="freeResourceSelectType()">
                                                                                {{freeResourceOrRemainQuota === 'resource' ? 'Free resources':'Remaining Quotas'}}
                                                                                <span class="white-down-arrow"></span>
                                                                            </a>
                                                                            <div class="header-menu" id="freeResourceSelect">
                                                                                <ul>
                                                                                    <li>
                                                                                        <a ng-click="freeResourceOrRemainQuota = 'resource'" href="#">Free Resources</a>
                                                                                    </li>
                                                                                    <li>
                                                                                        <a ng-click="freeResourceOrRemainQuota = 'quota'" href="#">Remaining Quotas</a>
                                                                                    </li>
                                                                                </ul>
                                                                            </div>
                                                                        </div>
                                                                        <div class="resource-boxBody">
                                                                            <div class="center-informBlock blur-backgroud" ng-show="loadingResouceWithDate">
                                                                                <div class="small-spinner" ></div>
                                                                            </div>
                                                                            <div class="box-number">
                                                                                <div class="tbl-center">
                                                                                    <div class="tbl-cell">
                                                                                        <p>{{freeResourceOrRemainQuota === 'resource' ? freeResource:remainQuotas}}</p>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div id="bookings-overview">
                                                        <div class="overview-container">
                                                            <div class="overview-header">
                                                                <a id="todayBookingSelectType" class="header-hover" href="" ng-click="todayBookingSelectType()">
                                                                    {{todayBookingOrUpcoming === 'today' ? "Today's bookings":"Upcoming bookings"}} <span class="white-down-arrow"></span>
                                                                </a>
                                                                <div id="todayBookingSelect" class='header-menu'>
                                                                    <ul>
                                                                        <li>
                                                                            <a href='' ng-click="todayBookingOrUpcoming = 'today'">Today's bookings</a>
                                                                        </li>
                                                                        <li>
                                                                            <a href='' ng-click="todayBookingOrUpcoming = 'upcoming'">Upcoming bookings</a>
                                                                        </li>
                                                                    </ul>
                                                                </div>
                                                            </div>
                                                            <div class="overview-title">
                                                                <ul class=" clearfix">
                                                                    <li class="dt-col">Details</li>
                                                                    <li class="normal-col">Channel</li>
                                                                    <li class="normal-col">Type</li>
                                                                    <li class="normal-col">Trippers</li>
                                                                </ul>
                                                            </div>
                                                            <div class="overview-content">
                                                                <ul>
                                                                    <li class="single-booking" ng-repeat="x in showBookingData()">
                                                                        <ul class="clearfix">
                                                                            <li class="dt-col">
                                                                                <div class="tbl-cell">
                                                                                    <p>{{x.packageTitle}}</p>
                                                                                    <p>{{x.lastName}}</p>
                                                                                </div>
                                                                            </li>
                                                                            <li class="normal-col">
                                                                                <div class="tbl-cell">
                                                                                    <img ng-if="x.isOffline === false" src="<c:url value="/Resources/Theme/image/yt-channel.svg"/>"/>
                                                                                    <img ng-if="(x.isOffline === true && x.offlineType === 'walking')" src="<c:url value="/Resources/Theme/image/walking-channel.svg"/>"/>
                                                                                    <img ng-if="x.isOffline === true && x.offlineType === 'phone'" src="<c:url value="/Resources/Theme/image/phone-channel.svg"/>"/>
                                                                                </div>
                                                                            </li>
                                                                            <li class="normal-col">
                                                                                <div class="tbl-cell">
                                                                                    <img ng-if="x.packageType === 'Open'" src="<c:url value="/Resources/Theme/image/smallOpenType.svg"/>"/>
                                                                                    <img ng-if="x.packageType === 'Personal'" src="<c:url value="/Resources/Theme/image/smallPersonalType.svg"/>"/>
                                                                                    <img ng-if="x.packageType === 'Group'" src="<c:url value="/Resources/Theme/image/smallGroupType.svg"/>"/>
                                                                                </div>
                                                                            </li>
                                                                            <li class="normal-col noTripper-col">
                                                                                <span>{{x.noTrippers}}</span>
                                                                            </li>
                                                                        </ul>
                                                                    </li>                                                                    
                                                                </ul>

                                                            </div>
                                                            <div id="booking-scrollbar">
                                                                <div class="scrollbar-thumb">

                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="dashboard-col dashboard-right">
                                                    <div id="packages-overview">
                                                        <div class="pkg-overview-row clearfix">
                                                            <div class="pkg-overview-col">
                                                                <div class="pkg-overview-box">
                                                                    <div class="overview-header">
                                                                        <a id="highestPackage" class="header-hover" href="" ng-click="highestPackageSelectType()">
                                                                            {{showHighestPackageType()}} <span class="white-down-arrow"></span>
                                                                        </a>
                                                                        <div id="highestPackageSelect" class="header-menu">
                                                                            <ul>
                                                                                <li>
                                                                                    <a href="" ng-click="highestPackageType = 'grossing'">Highest Grossing Package</a>
                                                                                </li>
                                                                                <li>
                                                                                    <a href="" ng-click="highestPackageType = 'selling'">Highest Selling Package</a>
                                                                                </li>
                                                                                <li>
                                                                                    <a href="" ng-click="highestPackageType = 'converting'">Highest Converting Package/per View</a>
                                                                                </li>
                                                                            </ul>
                                                                        </div>
                                                                    </div>
                                                                    <div class="center-informBlock blur-backgroud" ng-show="loadingHighestPack">
                                                                        <div class="small-spinner" ></div>
                                                                    </div>
                                                                    <div class="overview-cover" ng-style="{
                                                                            'background-image'
                                                                            : 'url(' + tripDash.highestPackageInTripDash.coverImage + ')'}">
                                                                        <span class="overview-price">
                                                                            {{tripDash.highestPackageInTripDash.filterPrice}} THB
                                                                        </span>
                                                                        <div class="overview-duration">
                                                                            <a id="highestPackageDate" href="" ng-click="highestPackageDateSelectType()" class="duration-hover">
                                                                                Last 30 days
                                                                                <span class="white-down-arrow"></span>
                                                                            </a>
                                                                            <div id="highestPackageDateSelect" class="menu">
                                                                                <ul>
                                                                                    <li>
                                                                                        <a href="" ng-click="lastDateOfHighestPackage = todayInMillisecond - 2592000000">Last 30 days</a>
                                                                                    </li>
                                                                                    <li>
                                                                                        <a href="" ng-click="lastDateOfHighestPackage = todayInMillisecond - 604800000">Last 7 days</a>
                                                                                    </li>
                                                                                    <li>
                                                                                        <a href="" ng-click="lastDateOfHighestPackage = todayInMillisecond">Today</a>
                                                                                    </li>
                                                                                </ul>
                                                                            </div>
                                                                        </div>
                                                                    </div>

                                                                    <div class="overview-detail">
                                                                        <div class="overview-title">
                                                                            <p>{{tripDash.highestPackageInTripDash.packageTitle}}</p>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>

                                                            <div class="pkg-overview-col">
                                                                <div class="pkg-overview-box red-overview">
                                                                    <div class="overview-header">
                                                                        <a id="lowestPackage" class="header-hover" href="" ng-click="lowestPackageTypeSelect()">
                                                                            {{showLowestPackageType()}} <span class="white-down-arrow"></span>
                                                                        </a>
                                                                        <div id="lowestPackageSelect" class="header-menu">
                                                                            <ul>
                                                                                <li>
                                                                                    <a href="" ng-click="lowestPackageType = 'grossing'">Lowest Grossing Package</a>
                                                                                </li>
                                                                                <li>
                                                                                    <a href="" ng-click="lowestPackageType = 'selling'">Lowest Selling Package</a>
                                                                                </li>
                                                                                <li>
                                                                                    <a href="" ng-click="lowestPackageType = 'converting'">Lowest Converting Package/per View</a>
                                                                                </li>
                                                                            </ul>
                                                                        </div>
                                                                    </div>
                                                                    <div class="center-informBlock blur-backgroud" ng-show="loadingLowestPack">
                                                                        <div class="small-spinner" ></div>
                                                                    </div>
                                                                    <div class="overview-cover" ng-style="{
                                                                            'background-image'
                                                                            : 'url(' + tripDash.highestPackageInTripDash.coverImage + ')'}">
                                                                        <span class="overview-price">
                                                                            {{tripDash.lowestPackageInTripDash.filterPrice}} THB
                                                                        </span>
                                                                        <div class="overview-duration">
                                                                            <a id="lowestPackageDate" href="" ng-click="lowestPackageDateSelectType()" class="duration-hover">
                                                                                Last 30 days
                                                                                <span class="white-down-arrow"></span>
                                                                            </a>
                                                                            <div id="lowestPackageDateSelect" class="menu">
                                                                                <ul>
                                                                                    <li>
                                                                                        <a href="" ng-click="lastDateOfLowestPackage = todayInMillisecond - 2592000000">Last 30 days</a>
                                                                                    </li>
                                                                                    <li>
                                                                                        <a href="" ng-click="lastDateOfLowestPackage = todayInMillisecond - 604800000">Last 7 days</a>
                                                                                    </li>
                                                                                    <li>
                                                                                        <a href="" ng-click="lastDateOfLowestPackage = todayInMillisecond">Today</a>
                                                                                    </li>
                                                                                </ul>
                                                                            </div>
                                                                        </div>
                                                                    </div>

                                                                    <div class="overview-detail">
                                                                        <div class="overview-title">
                                                                            <p>{{tripDash.lowestPackageInTripDash.packageTitle}}</p>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div id="booking-statistics">
                                                        <div class="statistics-container">
                                                            <div class="booking-header clearfix">
                                                                <h5>Booking Statistics</h5>
                                                                <div class="statistics-ctrls">
                                                                    <ul class="clearfix">
                                                                        <li>
                                                                            <a id="selectPackageType" class="header-hover" href="" ng-click="selectPackageType()">
                                                                                {{selectedPackageNameInStat}} <span class="white-down-arrow"></span>
                                                                            </a>
                                                                            <div class="menu" id="packageTypeSelect">
                                                                                <ul>
                                                                                    <li>
                                                                                        <a href="" ng-click="changePackageInStatistics(-1, 'All packages')">All packages</a>
                                                                                    </li>
                                                                                    <li ng-repeat="x in tripDash.packageList">
                                                                                        <a href="" ng-click="changePackageInStatistics(x.id, x.name)">{{x.name}}</a>
                                                                                    </li>
                                                                                </ul>
                                                                            </div>
                                                                        </li>
                                                                        <li>
                                                                            <a id="selectStatisticType" class="header-hover" href="" ng-click="selectStatisticType()">
                                                                                {{revenueOrBookingInStat === 'revenue' ? 'Revenue':'Bookings'}} <span class="white-down-arrow"></span>
                                                                            </a>
                                                                            <div class="menu" id="statisticTypeSelect">
                                                                                <ul>
                                                                                    <li>
                                                                                        <a href="" ng-click="revenueOrBookingInStat = 'revenue'">Revenue</a>
                                                                                    </li>
                                                                                    <li>
                                                                                        <a href="" ng-click="revenueOrBookingInStat = 'booking'">Bookings</a>
                                                                                    </li>
                                                                                </ul>
                                                                            </div>
                                                                        </li>
                                                                        <li>
                                                                            <a id="selectStatisticDate" class="header-hover" href="" ng-click="selectStatisticDate()">
                                                                                Last {{(todayInMillisecond - lastDateInStat) / 86400000}} days <span class="white-down-arrow"></span>
                                                                            </a>
                                                                            <div class="menu" id="statisticDateSelect">
                                                                                <ul>
                                                                                    <li>
                                                                                        <a href="" ng-click="lastDateInStat = todayInMillisecond - 31536000000">Last 365 days</a>
                                                                                    </li>
                                                                                    <li>
                                                                                        <a href="" ng-click="lastDateInStat = todayInMillisecond - 7776000000">Last 90 days</a>
                                                                                    </li>
                                                                                    <li>
                                                                                        <a href="" ng-click="lastDateInStat = todayInMillisecond - 2592000000">Last 30 days</a>
                                                                                    </li>
                                                                                    <li>
                                                                                        <a href="" ng-click="lastDateInStat = todayInMillisecond - 604800000">Last 7 days</a>
                                                                                    </li>
                                                                                </ul>
                                                                            </div>
                                                                        </li>
                                                                    </ul>
                                                                </div>
                                                            </div>

                                                            <div class="chart-box">
                                                                <div class="center-informBlock blur-backgroud" ng-show="loadedStaticstic">
                                                                    <div class="small-spinner" ></div>
                                                                </div>    
                                                                <canvas id="booking-line-chart">   

                                                                </canvas> 
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
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
        <script src="<c:url value="/Resources/Theme/js/notify.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js?999"/>"></script>
        <script>
            var todayServer = '${requestScope.today}';
            var dateInMillisecond = '${requestScope.currentMillisecond}';
            var tripDash = ${requestScope.tripDash};
            var providerID = ${sessionScope.account.id};
            $(document).ready(function () {
                toggleHeader.init({
                    toggleControl: false
                });
            });
        </script>
    </body>
</html>
