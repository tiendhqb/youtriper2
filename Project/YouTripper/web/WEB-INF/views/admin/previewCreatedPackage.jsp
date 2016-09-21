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
        <link href="<c:url value="/Resources/Theme/css/pepper-ginder-custom.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/lightgallery.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/lg-transitions.css"/>" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css?999999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css?999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style-login.css"/>" >

    <%@ include file="../angular.jsp" %>

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>

        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <!--<script src="<c:url value="/Resources/Theme/js/jquery-ui.multidatespicker.js"/>"></script>-->
        <script src="<c:url value="/Resources/Theme/js/lightgallery.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/lg-thumbnail.js"/>"></script>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

        <title>Package Page</title>
        <script>
            $(document).ready(function () {
                toggleHeader.init({
                    toggleControl: false
                });
                isMobiDevice() ? $('#Inputdate').attr("type", "date") : $('#Inputdate').datepicker();
            });
            function callBooking() {
                var _form = $('.form-booking');
                _form.hasClass('active') ? _form.removeClass('active') : _form.addClass('active');
                if (_form.hasClass('active')) {
                    $('html, body').animate({
                        scrollTop: $(".bookButton").offset().top
                    }, 500);
                }
            }
        </script>
    </head>
    <body>
        <div ng-app="YouTripper" ng-controller="SpecificPackageController">
            <%@ include file="../header.jsp" %>
            <div id="spinner-block" ng-hide="loaded">
                <div class="youtripper-spinner"></div>
            </div>
            <!-- A BACKUP AT THE END OF THIS FILE -->
            <div id="nav-header" class="padding-header" ng-cloak ng-show="loaded">
                <div class="banner">
                    <div class="header-title-box">
                        <div><span>{{package.name}}</span></div>
                    </div>

                    <img class="img-responsive" src="{{package.coverImage + '?' + currentTime}}" />
                </div>
                <!--POST HEADER-->
                <div class="posts-header">
                    <div class="wrapper" >
                        <div class="row">
                            <div class="posts-avatar">
                                <img class="img-responsive" src="<c:url value="/Images/Icon/User-Default.jpg"/>" />
                            </div>
                            <div>
                                <h4 class="posts-name">{{package.name}}</h4>
                                <div>
                                    <span class="posts-location">{{package.providerName}}</span>
                                    <div class="item-rating yellow-rating">
                                        <ul>
                                            <li ng-repeat="i in [0, 1, 2, 3, 4]" ng-class="{'active' : (i < package.rate), 'unactive' : (i >= package.rate)}">

                                            </li>
                                        </ul> 
                                        <span class="number"> ({{package.numberOfRates}} Reviews)</span>
                                    </div>
                                </div>
                            </div>
                            <a href="javascript:callBooking()" class="bookButton">Book Now</a>
                            <!--BOOKING FORM-->
                            <div id="booking">
                                <div class="form-booking" data-wow-duration="1s">
                                    <h3 class="form-header-title">{{package.ordinaryPriceForAdult| currency}} / trip<span class="btn-close-booking">
                                            <a href="javascript:callBooking()"><img src="<c:url value="/Images/Icon/close.svg"/>" /></a>
                                        </span>
                                    </h3>
                                    <form>
                                        <div class="form-group">
                                            <span class="col-md-12" style="width: 100%;float: left;text-align:left;">Date</span>
                                            <input id="bookingCalendar" ng-model="selectedDate" type="text" 
                                                   name="selectedDate" placeholder="Select date" class="form-control text-input-custom normalFont"/>
                                        </div>
                                        <div class="form-group">
                                            <span class="col-md-12" style="width: 100%;float: left;text-align:left;">Number of adults</span>
                                            <input id="numberOfAdults" min="1" type="number" ng-model="numberOfAdults" 
                                                   name="numberOfAdults" placeholder="Select number of adults" class="form-control text-input-custom normalFont"/>
                                        </div>
                                        <div ng-show="childPrice > 0" class="form-group">
                                            <span class="col-md-12" style="width: 100%;float: left;text-align:left;">Number of childs</span>
                                            <input  id="numberOfChilds" min="1" type="number" class="form-control text-input-custom normalFont"
                                                    ng-model="numberOfChilds" name="numberOfChilds" placeholder="Select number of childs" />
                                        </div>
                                        <div class="form-group">
                                            <span class="col-xs-6" style="text-align:left">TOTAL</span>
                                            <span class="col-xs-6" style="text-align:right; color: #ed683c">
                                                {{(numberOfAdults * adultPrice + numberOfChilds * childPrice) | currency}}
                                            </span>
                                        </div> 
                                        <input type="hidden" name="packageID" value="{{package.id}}" />
                                        <button type="submit" class="btn btn-custom-default btn-pink">Request to book</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="wrapper" ng-cloak ng-show="loaded">
                <!-- OPTIONS -->
                <div id="options" class='preview-controls'>
                    <ul class='options-name twoOptions'>
                        <li>
                            <a href='<c:url value="/Admin/Package/Edition"/>/{{package.id}}' target="_self">Edit this package</a>
                        </li>
                        <li>
                            <a href='<c:url value="/Admin/CreatedPackage/Approve"/>/{{package.id}}' target="_self">Approve this package</a>
                        </li>
                    </ul>
                </div>
                <!--ABOUT PROVIDER-->
                <section id="provider">
                    <div class="section-content posts-content" style="padding-bottom:0px">
                        <div class="content-small content-small-icon-about" style="margin-bottom:0px">
                            <h4 class="provider-icon">About this Provider</h4>
                            <p>
                                {{package.providerInformation}}
                            </p>
                            <a href="#" class="orange-link">View this provider's profile</a>
                            <h4>Description</h4>
                            <p>
                                {{package.mainDescription}}
                            </p>
                            <hr />
                        </div>
                    </div>
                </section>
                <div>
                    <div class="row package-property">
                        <div class="col-md-3 package-property-name">
                            <strong>Location</strong>
                        </div>
                        <div class="col-md-9">
                            <font color="#ed683c">{{package.country}} {{package.city}} {{package.state}}</font>
                        </div>
                    </div>
                    <div class="row package-property">
                        <div class="col-md-3 package-property-name">
                            <strong>Duration</strong>
                        </div>
                        <div class="col-md-9">
                            {{package.duration}} <span ng-show="package.durationType === 0">Hours</span><span ng-show="package.durationType === 1">Days</span>
                        </div>
                    </div>
                    <div class="row package-property">
                        <div class="col-md-3 package-property-name">
                            <strong>Departure Location</strong>
                        </div>
                        <div class="col-md-9">
                            {{package.departureLocation}}
                        </div>
                    </div>
                    <div class="row package-property">
                        <div class="col-md-3 package-property-name">
                            <strong>Departure Time</strong>
                        </div>
                        <div class="col-md-9">
                            {{package.departureTime}}
                        </div>
                    </div>
                    <div class="row package-property">
                        <div class="col-md-3 package-property-name">
                            <strong>Price</strong>
                        </div>
                        <div class="col-md-9">
                            <strong>{{package.ordinaryPriceForAdult| currency}}</strong>
                        </div>
                    </div>
                    <div class="row package-property">
                        <div class="col-md-3 package-property-name">
                            <strong>Amenities</strong>
                        </div>
                        <div class="col-md-9">
                            <div class="row">
                                <div class="col-xs-4" ng-repeat="amenities in package.listAmenities">
                                    <div class='amenities-image' style='background-image: url({{amenities.image}})'></div> {{amenities.amenitiesType}}
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row package-property">
                        <div class="col-md-3 package-property-name">
                            <strong>Language</strong>
                        </div>
                        <div class="col-md-9">
                            {{package.language}}
                        </div>
                    </div>
                    <div class="row package-property">
                        <div class="col-md-3 package-property-name">
                            <strong>Includes</strong>
                        </div>
                        <div class="col-md-9">
                            <p class="youtripper-paragraph">{{package.included}}</p>
                        </div>
                    </div>
                    <div class="row package-property">
                        <div class="col-md-3 package-property-name">
                            <strong>Excludes</strong>
                        </div>
                        <div class="col-md-9 youtripper-paragraph">
                            <p class="youtripper-paragraph">{{package.excluded}}</p>
                        </div>
                    </div>
                    <div class="row package-property">
                        <div class="col-md-3 package-property-name">
                            <strong>Group Size</strong>
                        </div>
                        <div class="col-md-9">
                            {{package.minTripper}} - {{package.maxTripper}} People
                        </div>
                    </div>
                    <div class="row package-property">
                        <div class="col-md-3 package-property-name">
                            <strong>Categories</strong>
                        </div>
                        <div class="col-md-9">
                            <div class="row">
                                <div class="col-xs-6" ng-repeat="category in package.categories">
                                    <div class='category-image' style='background-image: url({{category.image}})'></div> {{category.name}}
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row package-property" style="border-bottom: 0px">
                        <div class="col-md-3 package-property-name">
                            <strong>Transportation</strong>
                        </div>
                        <div class="col-md-9">
                            <div class="row">
                                <div ng-repeat="transporation in package.transporations" ng-class="{'col-xs-4' : !$last, 'col-xs-12' : $last}">
                                    <div ng-hide="$last" class="trans-image" style="background-image: url({{transporation.image}})">
                                        <!--<img ng-src="{{transporation.image}}"/>-->
                                    </div>
                                    <div ng-show="$last">
                                        {{transporation.name}} <span ng-show="transporation.content">: {{transporation.content}}</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row package-gallery package-property" style="border-bottom: 0px">
                        <div class="col-md-6" ng-repeat="image in package.images.images| limitTo : 2" style="height: 385px; padding: 1.5px">
                            <a ng-click="initGallery()" href style="background-image: url({{image}}); background-size: cover; background-position: 50% 50%; display: block;height: 100%"></a>
                        </div>
                        <div class="col-md-4" ng-repeat="image in package.images.images| limitTo : 3 : 3" style="height: 200px; padding: 1.5px">
                            <a ng-click="initGallery()" style="background-image: url({{image}}); background-size: cover; background-position: 50% 50%; display: block;height: 100%"></a>
                        </div>
                    </div>
                    <div id="gallery"></div>
                    <!--REVIEWS-->
                    <section id="reviews">
                        <div class="row content-normal">
                            <div class="col-md-12">
                                <div class="title-reviews">
                                    <h3 class="posts-reviews">{{totalReviews}} Reviews</h3>
                                </div>
                                <div class="posts-comment">
                                    <div ng-repeat="review in package.reviews" class="posts-user-comment clearfix">
                                        <div class="comment-avatar">
                                            <img class="img-responsive" src="<c:url value="/Images/Icon/User-Default.jpg"/>" />
                                        </div>
                                        <div class="comment">
                                            <span>{{review.tripperName}}</span>
                                            <div class="col-xs-12 col-sm-12 col-md-12">
                                                <span>{{review.date}}</span> 
                                                <div class="item-rating red-rating">
                                                    <ul>
                                                        <li ng-repeat="i in [0, 1, 2, 3, 4]" ng-class="{'active' : (i < review.rate), 'unactive' : (i >= review.rate)}">

                                                        </li>
                                                    </ul> 
                                                    <!--<span class="number"> ({{package.numberOfRates}} Reviews)</span>-->
                                                </div>
                                            </div>
                                            <p>{{review.review}}</p>
                                        </div>
                                    </div>
                                    <!--                                    <span class="view-other">View other reviews</span>
                                                                        <nav role="navigation">
                                                                            <ul class="cd-pagination">
                                                                                <li><a class="current" href="detailed-package-page.html#0">1</a></li>
                                                                                <li><a href="detailed-package-page.html#0">2</a></li>
                                                                                <li><a href="detailed-package-page.html#0">3</a></li>
                                                                                <li><span>...</span></li>
                                                                                <li><a href="detailed-package-page.html#0">15</a></li>
                                                                                <li class="button"><a href="detailed-package-page.html#0">next</a></li>
                                                                            </ul>
                                                                        </nav>-->
                                </div>
                                <div class="comment-spinner" ng-show="loading"></div>
                                <a href="" class="otherReview" ng-click="getMoreReview()" ng-hide="loading">View others review</a>
                            </div>
                        </div>
                    </section>
                </div>

            </div>
            <!--MAP / LOCATION-->
            <div id="map"></div>
        </div>
        <%@ include file="../footer.jsp" %>
        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.plugin.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/wow.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js"/>"></script>
        <script>
                                    var page = '${requestScope.page}';
                                    var specificPackage = ${requestScope.temporaryPackage};
                                    var reviewsUrl = '<c:url value="/Common/getReviewByTime"/>';
                                    $(document).ready(function () {
                                        toggleHeader.init({
                                            toggleControl: false
                                        });
                                    });
        </script>
    </body>
    <script type='text/javascript' src="https://maps.googleapis.com/maps/api/js?key=&sensor=false&extension=.js"></script>
    
</html>
