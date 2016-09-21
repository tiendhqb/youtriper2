<%-- 
    Document   : previewPage
    Created on : Oct 14, 2015, 4:30:20 PM
    Author     : Nick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html id="htmlID" ng-app="YouTripper" ng-controller="PreviewPackageController">
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
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripperResponsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style-login.css"/>" >
        <link href="<c:url value="/Resources/Theme/css/jquery.fs.boxer.css"/>" rel="stylesheet">

        <%@ include file="../angular.jsp" %>

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <!--<script src="<c:url value="/Resources/Theme/js/jquery-ui.multidatespicker.js"/>"></script>-->
        <script src="<c:url value="/Resources/Theme/js/lightgallery.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/lg-thumbnail.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.fs.boxer.js"/>"></script>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

        <title>YouTripper - {{package.languageDescriptionList[0].packageName}}</title>
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
                    };

                    function callFixedBooking() {
                        if (!$(".form-fixed-booking").hasClass("active")) {
                            $(".form-fixed-booking").addClass("active");
                        } else {
                            $(".form-fixed-booking").removeClass("active");
                        }
//                        callBooking();
                    };
        </script>
    </head>
    <body>
        <div class="pagesearch packagePage">
            <%@ include file="../header.jsp" %>
            <div id="spinner-block" ng-hide="loaded">
                <div class="youtripper-spinner"></div>
            </div>
            <div style="position: fixed; top: 0; bottom: 0; left: 0; right: 0; background: #fff; z-index: 99999" ng-hide="loaded">
                <div class="youtripper-spinner" ></div>
            </div>
            <div class="form-fixed-booking" style="position: fixed; top: 0; bottom: 0; left: 0; right: 0; background: #fff; z-index: 2000;overflow-y: auto">
                <h3 class="form-header-title">{{package.ordinaryPriceForAdult| currency}} / trip<span class="btn-close-booking">
                        <a href="javascript:callBooking()"><img src="<c:url value="/Images/Icon/close.svg"/>" /></a>
                    </span>
                </h3>
                <form action="<c:url value="/Tripper/Book"/>" method="POST" name="bookForm"
                      ng-submit="validateBookForm($event)" novalidate>
                    <div class="form-group">
                        <span class="col-md-12" style="width: 100%;float: left;text-align:left;">Date</span>
                        <input id="bookingFixedCalendar"   ng-model="selectedDate" type="text" readonly="readonly"
                               name="selectedDate" placeholder="Select date" class="form-control text-input-custom normalFont" required/>
                    </div>
                    <div class="form-group">
                        <span class="col-md-12" style="width: 100%;float: left;text-align:left;">Number of adults</span>
                        <input  type="number" ng-model="numberOfAdults" 
                                name="numberOfAdults" placeholder="Select number of adults" class="form-control text-input-custom normalFont" required/>
                    </div>
                    <div ng-show="childPrice > 0" class="form-group">
                        <span class="col-md-12" style="width: 100%;float: left;text-align:left;">Number of childs</span>
                        <input type="number" class="form-control text-input-custom normalFont"
                               ng-model="numberOfChilds" name="numberOfChilds" placeholder="Select number of childs"/>
                    </div>
                    <div class="form-group">
                        <p style="color: red" ng-show="showError && !bookForm.selectedDate.$valid">Please select date!</p>
                        <p style="color: red" ng-show="showError && error.numberOfPeople">
                            This package contains only {{maxTripper}} people left.
                        </p>
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
            <!-- A BACKUP AT THE END OF THIS FILE -->
            <div id="nav-header" class="padding-header" ng-cloak ng-show="loaded">
                <div class="banner" style="background-image: url({{package.coverImage + '?' + currentTime}})">
                    <div class="header-title-box">
                        <div><span>{{package.languageDescriptionList[0].packageName}}</span></div>
                    </div>
                </div>
                <!--POST HEADER-->
                <div class="posts-header">
                    <div class="wrapper" >
                        <div class="row">
                            <div class="posts-avatar">
                                <img class="img-responsive" src="/{{package.providerImage}}" />
                            </div>
                            <div>
                                <h4 class="posts-name">{{package.languageDescriptionList[0].packageName}}</h4>
                                <div>
                                    <span class="posts-location">{{package.providerName}}</span>
                                    <div class="item-rating yellow-rating">
                                        <ul>
                                            <li ng-repeat="i in [0, 1, 2, 3, 4]" ng-class="{'active' : (i < 0), 'unactive' : (i >= 0)}">

                                            </li>
                                        </ul> 
                                        <span class="number"> (0 Reviews)</span>
                                    </div>
                                </div>
                            </div>
                            <!--<a href="javascript:callBooking()" class="bookButton">Book Now</a>-->
                            <!--BOOKING FORM-->
                            <div id="booking">
                                <div class="form-booking" data-wow-duration="1s">
                                    <h3 class="form-header-title">{{package.ordinaryPriceForAdult| currency}} / trip<span class="btn-close-booking">
                                            <a href="javascript:callBooking()"><img src="<c:url value="/Images/Icon/close.svg"/>" /></a>
                                        </span>
                                    </h3>
                                    <form action="
                                          <c:choose>
                                              <c:when test="${empty param.language}">
                                                  <c:url value="/Tripper/Book"/>
                                              </c:when>
                                              <c:otherwise>
                                                  <c:url value="/Tripper/Book?language=${param.language}"/>
                                              </c:otherwise>
                                          </c:choose>" 
                                          method="POST" name="bookForm"
                                          ng-submit="validateBookForm($event)" novalidate>
                                        <div class="form-group">
                                            <span class="col-md-12" style="width: 100%;float: left;text-align:left;">Date</span>
                                            <input id="bookingCalendar"   ng-model="selectedDate" type="text" readonly="readonly"
                                                   name="selectedDate" placeholder="Select date" class="form-control text-input-custom normalFont" required/>
                                        </div>
                                        <div class="form-group">
                                            <span class="col-md-12" style="width: 100%;float: left;text-align:left;">Number of adults</span>
                                            <input id="numberOfAdults" type="number" ng-model="numberOfAdults" 
                                                   name="numberOfAdults" placeholder="Select number of adults" class="form-control text-input-custom normalFont" required/>
                                        </div>
                                        <div ng-show="childPrice > 0" class="form-group">
                                            <span class="col-md-12" style="width: 100%;float: left;text-align:left;">Number of childs</span>
                                            <input  id="numberOfChilds"  type="number" class="form-control text-input-custom normalFont"
                                                    ng-model="numberOfChilds" name="numberOfChilds" placeholder="Select number of childs"/>
                                        </div>
                                        <div class="form-group">
                                            <p style="color: red" ng-show="showError && !bookForm.selectedDate.$valid">Please select date!</p>
                                            <p style="color: red" ng-show="showError && error.numberOfPeople">
                                                This package contains only {{maxTripper}} left.
                                            </p>
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
            <div class="wrapper">
                <!-- OPTIONS -->
                <c:if test="${requestScope.isFinished}">
                    <div id="options" class='preview-controls'>
                        <ul class='options-name twoOptions'>
                            <li>
                                <a href='
                                   <c:choose>
                                       <c:when test="${empty param.language}">
                                           <c:url value="/Provider/Package/Registration"/>
                                       </c:when>
                                       <c:otherwise>
                                           <c:url value="/Provider/Package/Registration?language=${param.language}"/>
                                       </c:otherwise>
                                   </c:choose>' 
                                   target="_self">Edit this package</a>
                            </li>
                            <li>
                                <a href='<c:url value="/Provider/Package/Apply"/>/{{package.id}}'  target="_self">Apply for previewing</a>
                            </li>
                        </ul>
                    </div>
                </c:if>

                <!--ABOUT PROVIDER-->
                <section id="provider">
                    <div class="section-content posts-content" style="padding-bottom:0px">
                        <div class="content-small content-small-icon-about" style="margin-bottom:0px">
                            <h4 class="provider-icon">About this Provider</h4>
                            <p>
                                {{package.providerInformation}} 
                            </p>
                            <a href="<c:url value="/Common/ProviderPage/"/>{{package.providerID}}" class="orange-link">View this provider's profile</a>
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
                        <div class="col-md-3 col-sm-3 col-xs-3 package-property-name">
                            <strong>Location</strong>
                        </div>
                        <div class="col-md-9 col-sm-9 col-xs-9">
                            <font color="#ed683c">{{package.country}} {{package.city}} {{package.state}}</font> <a class="orange-link" style="color:silver ;cursor: pointer;" ng-click="movetoMap()">See Map</a>
                        </div>
                    </div>
                    <div class="row package-property">
                        <div class="col-md-3 col-sm-3 col-xs-3  package-property-name">
                            <strong>Duration</strong>
                        </div>
                        <div class="col-md-9 col-sm-9 col-xs-9">
                            {{package.duration}} {{package.durationType}}
                        </div>
                    </div>
                    <div class="row package-property">
                        <div class="col-md-3 col-sm-3 col-xs-3  package-property-name">
                            <strong>Price</strong>
                        </div>
                        <div class="col-md-9 col-sm-9 col-xs-9">
                            <strong>{{package.ordinaryPriceForAdult}} THB</strong>
                        </div>
                    </div>
                    <div class="row package-property">
                        <div class="col-md-3 col-sm-3 col-xs-3  package-property-name">
                            <strong>Amenities</strong>
                        </div>
                        <div class="col-md-9 col-sm-9 col-xs-9">
                            <div class="row">
                                <div class="col-xs-4 amens" ng-repeat="amenities in package.listAmenities">
                                    <div class='amenities-image' style='background-image: url({{amenities.image}})'></div> 
                                    <div style="margin-left: 45px">{{amenities.amenitiesType}}</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row package-property">
                        <div class="col-md-3 col-sm-3 col-xs-3  package-property-name">
                            <strong>Language</strong>
                        </div>
                        <div class="col-md-9 col-sm-9 col-xs-9">
                            <span>{{package.languageDescriptionList[0].language[0].text}}</span>
                            <span ng-repeat="language in package.languageDescriptionList[0].language" ng-if="$index !== 0">, {{language.text}}</span>
                        </div>
                    </div>
                    <div class="row package-property">
                        <div class="col-md-3 col-sm-3 col-xs-3 package-property-name">
                            <strong>Category</strong>
                        </div>
                        <div class="col-md-9 col-sm-9 col-xs-9">
                            <div class="row">
                                <div class="col-xs-6 cats">
                                    <div class='category-image' style='background-image: url({{package.categoryIcon}})'></div> 
                                    <div style="margin-left: 40px">{{package.categoryName}}</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row package-gallery package-property" style="border-bottom: 0px">
                        <div class="col-md-6 col-sm-6" ng-repeat="image in package.additionImages| limitTo : 2" style="height: 385px; padding: 1.5px">
                            <a ng-click="initGallery()" href style="background-image: url({{image.image}});"></a>
                        </div>
                        <div class="col-md-4 col-sm-4" ng-repeat="image in package.additionImages| limitTo : 3 : 3" style="height: 200px; padding: 1.5px">
                            <a ng-click="initGallery()" style="background-image: url({{image.image}});"></a>
                        </div>
                    </div>
                    <div id="gallery"></div>

                </div>
            </div>

            <!--MAP / LOCATION-->
            <div id="map"></div>
        </div>

        <%@ include file="../footer.jsp" %>
        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/notify.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.plugin.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/wow.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js"/>"></script>
        <script>
                                        var page = '${requestScope.page}';
                                        var reportType = ${requestScope.ReportType};
                                        var specificPackage = ${requestScope.temporaryPackage};
                                        var reviewsUrl = '<c:url value="/Common/getReviewByTime"/>';
        </script>
        <script type='text/javascript' src="https://maps.googleapis.com/maps/api/js?&sensor=false&extension=.js&key=AIzaSyAQ81rwgbghs-BhJploUzu9da49vAdjrx8"></script>
    </body>
</html>
