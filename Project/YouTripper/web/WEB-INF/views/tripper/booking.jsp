<%-- 
    Document   : booking
    Created on : Nov 4, 2015, 4:32:37 PM
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
        <title>Youtripper - Booking List</title>
    </head>
    <body>
        <div ng-app="YouTripper" ng-controller="BookingList" class="pagesearch">
            <%@ include file="../header.jsp" %>
            <%@ include file="tripperMenubar.jsp" %>
            <div id="spinner-block" ng-hide="loaded">
                <div class="youtripper-spinner"></div>
            </div>
            <div class="site-container">
                <div class="col-sm-9 col-md-10 affix-content">
                    <div class="tab-content" ng-cloak ng-show="loaded">
                        <div role="tabpanel" class="tab-pane active" id="step6">
                            <div class="tab-booking">
                                <h2>Booking ({{BookingList.length}})</h2>
                                <div class="row" >
                                    <div class="col-md-6 col-lg-4 col-xs-12 package-block" ng-repeat="booking in BookingList| orderBy:sortType">
                                        <div class="category-item-block">
                                            <div class="item-image" style="background-image: url('{{booking.packageImage}}')" balance-square>
                                                <a class="package-detail-href" target="_self" ng-href="<c:url value="/Package/"/>{{booking.packageID}}"> </a>
                                                <!--<div class="option-box" ng-controller="OptionsController">
                                                    <span class="item-function">
                                                    </span>
                                                    <div class="package-option">
                                                        <ul>
                                                <c:if test="${sessionScope.account.role == 1}">
                                                    <li>
                                                        <a href="" ng-click="saveWishlist(booking.packageID)" class="wishlist-option">Save to your list</a>
                                                    </li>
                                                </c:if>
                                                <li>
                                                    <a href="<c:url value="/Common/Package/QuickView"/>/{{booking.packageID}}"
                                                       ng-click="quickView(booking.packageID, $event)" 
                                                       class="quickView-option boxer" data-boxer-height="400" data-boxer-width="800">Quick view</a>
                                                </li>
                                                <li>
                                                    <a href="" ng-click="addToComparisonList(booking.packageID, booking.packageName)" class="comparison-option">Comparison</a>
                                                </li>
                                                <li>
                                                    <a href="<c:url value="/Common/ProviderPage"/>/{{booking.providerID}}" class="other-option">Other trips</a>
                                                </li>
                                                <li>
                                                    <a href="" ng-click="" class="share-option">Share this trip</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div> -->
                                                <span class="item-price">{{booking.ordinaryPriceForAdult| currency}}</span>
                                                <span class="item-ID">ID: {{booking.code}}</span>

                                                <span class="status-package" ng-show="editstatus">This package is not available!</span>
                                                <div id="package-name" class="col-xs-12">
                                                    
                                                        <a target="_self" href='<c:url value="/Package/"/>{{booking.packageID}}'>{{booking.packageName}}</a>
                                                   
                                                </div>

                                            </div>
                                            <div id="booking-item" class="item-detail row">
<!--                                                <div class="col-xs-12">
                                                    <article>
                                                        <a target="_self" href='<c:url value="/Package/"/>{{booking.packageID}}'>{{booking.packageName}}</a>
                                                    </article>
                                                </div>-->
                                                <div class="col-xs-12 col-md-12" style="margin-top:5px">
                                                    <div > Booking date: {{convertTime(booking.bookingDate)}}
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-md-12" style="margin-top:5px">
                                                    <div > Activity date: {{booking.selectedDate}}
                                                    </div>
                                                </div>
                                                
                                                    <div class="col-xs-6 col-md-6" style="margin-top:5px">
                                                        <div > People: {{booking.numberOfAdults}}
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-6 col-md-6" style="margin-top:5px">
                                                        <div > Packages: {{booking.noOfPackages}}
                                                        </div>
                                                    </div>
                                                

                                            </div>
                                            <div class="sub-item-detail">
                                                <div class="package-item-review">
                                                    <div class="row">
                                                        <div >Status: Open</div>
                                                    </div>
                                                </div>
                                                <div class="cancel-btn">
                                                    <a href="" class="btn-width-orange" ng-click="">Cancel</a>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!--                                    <div class="col-md-8 col-sm-6 col-xs-12">
                                                                            <div class="booking-info">
                                                                                <h3>{{booking.packageName}}</h3>
                                                                                <p> Your Booking date: {{booking.bookingDate}}</p>
                                                                                <p>   Paid: {{(booking.numberOfAdults * booking.adultPrice + booking.numberOfChilds * booking.childPrice) | currency}}</p>
                                                                                <p>Location: {{booking.packageCity}} {{booking.packageCountry}}</p>
                                                                            </div>
                                                                        </div>-->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--NEW-->
            <!--            <div class="site-container">
                            <div class="col-sm-9 col-md-10 affix-content">
                                <div class="container"  ng-cloak ng-show="loaded">
                                    <div class="tab-content">
                                        <div role="tabpanel" class="tab-pane active" id="step3">
                                            <div class="tab-bucket tab-bucket-fix">
                                                <div class="tab-content">
                                                    <table class="table" style="width:90%;">
                                                        <thead>
                                                            <tr>
                                                                <th>Package Name</th>
                                                                <th>Package Image</th>
                                                                <th>Date Booked</th>
                                                                <th>Using Date</th>
                                                                <th>Number People</th>
                                                                <th>Price</th>
                                                                <th>Number Packages</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr ng-repeat="booking in BookingList | orderBy:sortType">
                                                                <td><a style="color:#337ab7;" target="_blank" href='<c:url value="/Package/"/>{{booking.packageID}}'>{{booking.packageName}}</a></td>
                                                                <td><a href='<c:url value="/Package/"/>{{booking.packageID}}' target="_blank"><img style="background:url('{{booking.packageImage}}'); background-size:100% 100%" height="50" width="50"></img></a></td>
                                                                
                                                                <td>{{convertTime(booking.bookingDate)}}</td>
                                                                <td>{{booking.selectedDate}}</td>
                                                                <td>{{booking.numberOfAdults}}</td>
                                                                <td>{{booking.ordinaryPriceForAdult| currency}}</td>
                                                                <td>{{booking.noOfPackages}}</td>
            
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                
            
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>-->


        </div>
        <%--<%@ include file="../footer.jsp" %>--%>
        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/notify.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js?999"/>"></script>
        <script>
                                                        var BookingList = ${requestScope.BookingList};
                                                        var page = '${requestScope.page}';
                                                        $(document).ready(function () {
                                                            toggleHeader.init({
                                                                toggleControl: false
                                                            });
                                                        });
        </script>
    </body>
</html>
