<%-- 
    Document   : previewPage
    Created on : Oct 14, 2015, 4:30:20 PM
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

        <%@ include file="angular.jsp" %>

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>

        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

        <title>YouTripper - Package Page</title>
    </head>
    <body>
        <div ng-app="YouTripper" ng-controller="QuickViewController">
            <!--<div class="youtripper-spinner" ng-hide="loaded"></div>-->

            <div class="wrapper quick-view-wrapper" ng-show="loaded" ng-cloak>
                <div>
                     <div class="row package-property quick-view-row">
                        <div class="col-sm-2 package-property-name">
                            <strong>Description</strong>
                        </div>
                        <div class="col-sm-9">
                           
                            {{package.othersLanguageDescription[0].googleDescription}}
                        
                        </div>
                    </div>

                    <div>

                        <div class="" id="pkg-content-bd">
                            <div class="single-detail-section quick-view-seperateline">
                                
                                <div class="single-content-bd clearfix">
                                    <div class="content-bd-name quick-view-header">
                                        Type
                                    </div>
                                    <div class="content-bd-content">

                                        <div class="content-bd-row">
                                            <div class="row">
                                                <div class="col-xs-3">
                                                    <div class="content-bd-title">
                                                        <span class="title-icon">
                                                            <img ng-src="{{package.categoryIcon}}"/>
                                                        </span>
                                                        <span class="title-name">Category</span>
                                                    </div>
                                                </div>
                                                <div class="col-xs-9">
                                                    <div class="content-bd-detail">
                                                        {{package.categoryName}}
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="content-bd-row">
                                            <div class="row">
                                                <div class="col-xs-3">
                                                    <div class="content-bd-title">
                                                        <span class="title-icon bg-image" ng-class="{'openType' : package.packageType === 'Open',
                                                                'privateType' : package.packageType === 'Private',
                                                                'groupType' : package.packageType === 'Group'}">
                                                        </span>
                                                        <span class="title-name">Serving Type</span>
                                                    </div>
                                                </div>
                                                <div class="col-xs-3">
                                                    <div class="content-bd-detail">
                                                        {{package.packageType}}
                                                    </div>
                                                </div>
                                                <div class="col-xs-3">
                                                    <div class="content-bd-title">
                                                        One booking serves
                                                    </div>
                                                </div>
                                                <div class="col-xs-3">
                                                    <div class="content-bd-detail">
                                                        <span ng-if="package.packageType === 'Open'">01 person only</span>
                                                        <span ng-if="package.packageType !== 'Open'">
                                                            {{package.minTripper}} - {{package.maxTripper}} person only
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="content-bd-row">
                                            <div class="row">
                                                <div class="col-xs-3">
                                                    <div class="content-bd-title">
                                                        <span class="title-name">Suitability</span>
                                                    </div>
                                                </div>
                                                <div class="col-xs-9">
                                                    <div class="content-bd-detail">
                                                        <span ng-repeat="suitability in package.suitabilities">
                                                            {{suitability.suitabilityName}}<span ng-if="!$last">, </span>
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                           

                            <div class="single-detail-section quick-view-seperateline">
                                <div class="content-bd-name quick-view-header">
                                    Schedule
                                </div>

                                <div class="content-bd-content">

                                    <div class="content-bd-row">
                                        <div class="row">
                                            <div class="col-xs-3">
                                                <div class="content-bd-title">
                                                    <span class="title-icon bg-image" >
                                                    </span>
                                                    <span class="title-name">Duration</span>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="content-bd-detail">
                                                    {{package.duration}} {{package.durationType}}

                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="content-bd-title">
                                                    Booking Hours
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="content-bd-detail">
                                                    {{package.startOperationTime}} - {{package.endOperationTime}}
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="content-bd-row">
                                        <div class="row">
                                            <div class="col-xs-3">
                                                <div class="content-bd-title">
                                                    <span class="title-icon bg-image" >
                                                    </span>
                                                    <span class="title-name">Frequency</span>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="content-bd-detail">
                                                    <span ng-if="package.sequentialOperation === 0">Operates everyday</span>
                                                    <span ng-if="package.sequentialOperation === 2">Operates second day</span>
                                                    <span ng-if="package.sequentialOperation === 3">Operates third day</span>
                                                    <span ng-if="package.sequentialOperation === 4">Operates fourth day</span>
                                                    <span ng-if="package.sequentialOperation === 5">Operates fifth day</span>
                                                    <span ng-if="package.sequentialOperation === 6">Operates sixth day</span>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="content-bd-title">
                                                    Closed days
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="content-bd-detail">                                                
                                                    <span ng-if="package.unavailableDays.length > 0">
                                                        <span ng-repeat="x in package.unavailableDays">
                                                            <span ng-if="x === 0" >Sunday</span>
                                                            <span ng-if="x === 1" >Monday</span>
                                                            <span ng-if="x === 2" >Tuesday</span>
                                                            <span ng-if="x === 3" >Wednesday</span>
                                                            <span ng-if="x === 4" >Thursday</span>
                                                            <span ng-if="x === 5" >Friday</span>
                                                            <span ng-if="x === 6" >Saturday</span>
                                                        </span>
                                                    </span>
                                                    <span ng-if="package.unavailableDays.length === 0">None</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="content-bd-row">
                                        <div class="row">
                                            <div class="col-xs-3">
                                                <div class="content-bd-title">
                                                    <span class="title-icon bg-image" >
                                                    </span>
                                                    <span class="title-name">Conditions</span>
                                                </div>
                                            </div>
                                            <div class="col-xs-9">
                                                <div class="content-bd-detail">
                                                    <p ng-if="package.readyBookingDuration > 0">
                                                        Package must be booked <span style="margin: 0 12px;">{{package.readyBookingDuration}}</span> {{package.readyBookingDurationType}} in advance.
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>

                          

                            <div class="single-detail-section quick-view-seperateline">
                                <div class="single-content-bd clearfix">
                                    <div class="content-bd-name quick-view-header">
                                        Price
                                    </div>
                                    <div class="content-bd-content">

                                        <div class="content-bd-row">
                                            <div class="row">
                                                <div class="col-xs-3">
                                                    <div class="content-bd-title">
                                                        <span class="title-name">Standard Price</span>
                                                    </div>
                                                </div>
                                                <div class="col-xs-3">
                                                    <div class="content-bd-detail">
                                                        {{package.ordinaryPriceForAdult| number : 2}} THB
                                                    </div>
                                                </div>
                                                <div class="col-xs-3">
                                                    <div class="content-bd-title">
                                                        Youtripper Price
                                                    </div>
                                                </div>
                                                <div class="col-xs-3">
                                                    <div class="content-bd-detail">
                                                        {{(package.ordinaryPriceForAdult * (100 - package.youtripperPercentage)) / 100 | number : 2}} THB
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="content-bd-row" ng-repeat="childrenDiscount in package.childrenDiscounts
                                                | filter:{isFree: false}">
                                            <div class="row">
                                                <div class="col-xs-3">
                                                    <div class="content-bd-title" ng-if="$first">
                                                        <span class="title-name">Child Discount</span>  
                                                    </div>
                                                </div>
                                                <div class="col-xs-3">
                                                    <div class="content-bd-detail">
                                                        {{(package.ordinaryPriceForAdult * (100 - package.youtripperPercentage) / 100
                                                                * (100 - childrenDiscount.discountPercent) / 100) | number : 2}} THB
                                                    </div>
                                                </div>
                                                <div class="col-xs-6">
                                                    <div class="content-bd-detail">
                                                        {{childrenDiscount.condition}}
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="content-bd-row" ng-repeat="childrenDiscount in package.childrenDiscounts
                                                | filter:{isFree: true}">
                                            <div class="row">
                                                <div class="col-xs-3">
                                                    <div class="content-bd-title">
                                                    </div>
                                                </div>
                                                <div class="col-xs-3">
                                                    <div class="content-bd-detail">
                                                        Free
                                                    </div>
                                                </div>
                                                <div class="col-xs-6">
                                                    <div class="content-bd-detail">
                                                        Under {{childrenDiscount.age}} {{childrenDiscount.ageType}}
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="content-bd-row" ng-repeat="disabledDiscount in package.disabledDiscounts">
                                            <div class="row">
                                                <div class="col-xs-3">
                                                    <div class="content-bd-title" ng-if="$first">
                                                        <span class="title-name">Disabled Discount</span>  
                                                    </div>
                                                </div>
                                                <div class="col-xs-3">
                                                    <div class="content-bd-detail">
                                                        {{(package.ordinaryPriceForAdult * (100 - package.youtripperPercentage) / 100
                                                                * (100 - disabledDiscount.discountPercent) / 100) | number : 2}} THB
                                                    </div>
                                                </div>
                                                <div class="col-xs-6">
                                                    <div class="content-bd-detail">
                                                        {{disabledDiscount.condition}}
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="content-bd-row" ng-repeat="cancellationCondition in package.cancellationConditions">
                                            <div class="row">
                                                <div class="col-xs-3">
                                                    <div class="content-bd-title"  ng-if="$first">
                                                        <span class="title-name">Cancellation</span>
                                                    </div>
                                                </div>
                                                <div class="col-xs-3">
                                                    <div class="content-bd-detail" ng-if="$first">
                                                        <span  ng-if="!package.cancellationConditions">No Cancellation</span>
                                                        <span  ng-if="!!package.cancellationConditions">Flexible</span>
                                                    </div>
                                                </div>
                                                <div class="col-xs-6">
                                                    <div class="content-bd-detail">
                                                        {{cancellationCondition.duration}} days prior to booking <span style="margin: 0 12px">{{cancellationCondition.percent}}%</span> Refund
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>


                        </div>

                    </div>
                    <div class="row package-property">
                        <div class="col-sm-2 package-property-name">
                            <strong>TrippMenities™</strong>
                        </div>
                        <div class="col-sm-9">
                           <div class="single-detail-section">
                            <div id="amenities-selection">
                                <ul class="clearfix">
                                    <li class="active-amenities amenities-item" ng-repeat="amenities in package.amenitiesClassifiers"                                       
                                        <a ng-style="{'background-image' : 'url(' + amenities.amenitiesIcon + ')'}"></a>    
                                        <div class="amenities-name-quickview">{{amenities.amenitiesName}}</div>
                                    </li>
                                    
                                </ul>
                            </div>
                        </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.plugin.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/wow.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js"/>"></script>
        <script>
                                                        var specificPackage = ${requestScope.packageDTO};
        </script>
    </body>
</html>
