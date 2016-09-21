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
        <style>
            h3 {
                font-size: 21px;
            }
        </style>
    </head>
    <body ng-controller="FixedComparisonController">
        <!-- Google Tag Manager -->
        <noscript><iframe src="//www.googletagmanager.com/ns.html?id=GTM-MZRL8C"
                          height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
        <script>(function (w, d, s, l, i) {
            w[l] = w[l] || [];
            w[l].push({'gtm.start':
                    new Date().getTime(), event: 'gtm.js'});
            var f = d.getElementsByTagName(s)[0],
                    j = d.createElement(s), dl = l != 'dataLayer' ? '&l=' + l : '';
            j.async = true;
            j.src =
                    '//www.googletagmanager.com/gtm.js?id=' + i + dl;
            f.parentNode.insertBefore(j, f);
            })(window, document, 'script', 'dataLayer', 'GTM-MZRL8C');</script>
        <!-- End Google Tag Manager -->
        <div class="pagesearch " id="packagePage">
            <%@ include file="../header.jsp" %>

            <!--DEVELOPING POPUP-->
            <div class="ytPopup" id="developingBox"  >
                <div class="tbl-cell" ng-controller="DevelopingControler">
                    <div class="popupContent" >
                        <div class="center-informBlock blur-backgroud" ng-show="!sendInfo">
                            <div class="small-spinner" ></div>
                        </div>
                        <span class="box-closing" ng-click="toggleDevelopingBox()"></span>
                        <div class="popupScroll">
                            <div style="text-align: center">
                                <p style="font-size: 20px">
                                    Join My Newsletter 
                                </p>
                                <p style="margin-top: 10px">
                                    Thank you for visiting the youtripper website. Unfortunately the feature you are interested in is currently under construction. 
                                </p>
                                <p style="margin-top: 10px">    
                                    Please support changing the travel industry us and follow our facebook or sign up to our email newsletter to find out about the latest developments. 
                                </p>
                                <p style="margin-top: 10px">
                                    Stay tuned and thank you for your support. 
                                </p>
                            </div>
                            <div class="row">
                                <div class="col-xs-12" style="margin-top: 15px;  text-align: center">
                                    <a target="_blank" href="https://www.facebook.com/Youtripper-466412116883772">
                                        <button style="width: 250px;" class="btn-width-orange login_fb button">Go to Facebook fanpage</button>
                                    </a>
                                </div>
                            </div>
                            <div ng-show="!sendDone" class="row" style="margin-top: 15px;">
                                <div class="col-xs-8">
                                    <input type="text" ng-model="email" maxlength="100" ng-maxlength="100"
                                           class="blueInput normalFont" placeholder="Enter Your Email">
                                </div>
                                <div class="col-xs-4" style="height:40px; line-height: 35px">
                                    <a href="" ng-click="submitEmail()" class="btn-width-orange">Submit</a>
                                </div>
                            </div>
                            <span ng-show="(showError.emailValid || showError.all) && !emailLoading && !sendDone">
                                <span ng-show="missing.emailValid && missing.emailRegex" style="color: green">Email is valid!</span>
                                <span ng-show="!missing.emailValid && missing.emailRegex" style="color: red">Email is exist!</span>
                                <span ng-hide="missing.emailRegex" style="color: red">Email is not correct!</span>
                            </span>
                            <div class="row">
                                <div class="col-xs-12" style="margin-top: 15px; text-align: center">
                                    <span  ng-show="sendDone" style="color: green">Join My Newsletter Successfully </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!--END DEVELOPING POPUP-->
            <div id="spinner-block" ng-hide="loaded">
                <div class="youtripper-spinner"></div>
            </div>
            <div style="position: fixed; top: 0; bottom: 0; left: 0; right: 0; background: #fff; z-index: 99999" ng-hide="loaded">
                <div class="youtripper-spinner" ></div>
            </div>
            <!-- A BACKUP AT THE END OF THIS FILE -->
            <div id="nav-header" class="padding-header" ng-cloak ng-show="loaded">
                <div class="banner" ng-style="{'background-image' : 'url(' + package.coverImage + '?' + currentTime + ')'}">
                </div>
                <!--POST HEADER-->
                <div class="posts-header">
                    <div class="wrapper" >
                        <div class="row">
                            <div class="posts-avatar">
                                <img class="img-responsive" ng-src="/{{package.providerImage}}" />
                            </div>
                            <div>
                                <h4 class="posts-name">{{package.languageDescriptionList[0].packageName}}</h4>
<!--                                <div>
                                    <span class="posts-businessName">{{package.providerName}}</span>
                                                                        <div class="item-rating yellow-rating">
                                                                            <ul>
                                                                                <li ng-repeat="i in [0, 1, 2, 3, 4]" ng-class="{'active' : (i < package.rate), 'unactive' : (i >= package.rate)}">
                                    
                                                                                </li>
                                                                            </ul> 
                                                                            <span class="number"> ({{package.numberOfRates}} Reviews)</span>
                                                                        </div>
                                </div>-->
                                <div class="post-alts">
                                    <ul class="clearfix">
                                        <li class="provider-name">{{package.providerName}}</li>
                                        <li class="duration" ng-if="package.durationDay > 0">
                                            {{package.durationDay}} Days
                                        </li>
                                        <li class="duration" ng-if="package.durationDay === 0 && (package.durationHour > 0 || package.durationMinute > 0)">
                                            {{package.durationHour}} Hours, {{package.durationMinute}} Minutes
                                        </li>
                                        <li ng-class="{'openType' : package.packageType === 'Open',
                                                    'privateType' : package.packageType === 'Personal',
                                                    'groupType' : package.packageType === 'Group'}">
                                            {{package.packageType}}
                                        </li>
                                        <li class="location">
                                            {{package.city}}, {{package.country}}
                                        </li>
                                    </ul>
                                </div>
                            </div>

                            <div class="pkg-price-box">
                                <div class="pkg-price clearfix">
                                    <div class="trip-price">
                                        {{(package.ordinaryPriceForAdult * (100 - package.youtripperPercentage)) / 100 | number : 2}} THB
                                    </div>
                                    <div class="org-price">
                                        {{package.ordinaryPriceForAdult| number : 2}}
                                    </div>
                                </div>
                                <div class="pkg-preview-controls clearfix">
                                    <div class="control pgk-edit-btn">
                                        <a href="
                                           <c:choose>
                                               <c:when test="${empty param.language }">
                                                   <c:url value="/Provider/Package/Registration"/>
                                               </c:when>
                                               <c:otherwise>
                                                   <c:url value="/Provider/Package/Registration?language=${param.language}"/>
                                               </c:otherwise>
                                           </c:choose>" 
                                           class="btn-width-orange btn login_gg">Edit</a>
                                    </div>
                                    <div class="control pgk-book-btn">
                                        <form action="
                                              <c:choose>
                                                  <c:when test="${empty param.language}">
                                                      <c:url value="/Provider/Package/Apply"/>
                                                  </c:when>
                                                  <c:otherwise>
                                                      <c:url value="/Provider/Package/Apply?language=${param.language}"/>
                                                  </c:otherwise>
                                              </c:choose>" 
                                              method="POST">
                                            <input type="hidden" name="packageID" value="{{package.id}}" />
                                            <input type="submit" value="Submit Package" class="btn-width-orange btn" ng-if="validPackage"/>
                                        </form>                                    
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

            <!-- OPTIONS -->
            <div id="options" ng-controller="OptionsController">
                <div class="wrapper">
                    <div class="optionsContainer">
                        <ul class='options-name'>
                            <li class="liCompare">
                                <a href="" ng-click="toggleDevelopingBox()" class='comparison'>Add to TrippMatch</a>
                            </li>
                            <c:if test="${sessionScope.account.role == 1}">

                                <li id="liBucket">
                                    <a href="" ng-click="toggleDevelopingBox()" class='save'>Add To Bucket List</a>
                                </li>
                                <li id="liChat">
                                    <a href=''ng-click="toggleDevelopingBox()" class='chat'>Chat with provider</a>
                                </li>
                                <!--                            <li id="liEmail">
                                                                <a href='' data-toggle="modal" data-target="#myModal" class=''>Email</a>
                                                            </li>-->
                            </c:if>
                            <c:if test="${sessionScope.account == null}">
                                <li id="liBucket">
                                    <a href="" ng-click="toggleDevelopingBox()" class='cd-login save'>Add To Bucket List</a>
                                </li>
                                <li id="liChat">
                                    <a href='' ng-click="toggleDevelopingBox()" class='cd-login chat'>Chat with provider</a>
                                </li>
                            </c:if>
                            <c:if test="${sessionScope.account.role == 2}">
                                <li id="liBucket">
                                    <a href="" ng-click="toggleDevelopingBox()" class='save'>Add To Bucket List</a>
                                </li>
                                <li id="liChat">
                                    <a href='' ng-click="toggleDevelopingBox()" class='chat'>Chat with provider</a>
                                </li>
                            </c:if>
                            <c:if test="${sessionScope.account.role == 3}">
                                <li id="liBucket">
                                    <a href="" data-toggle="modal" ng-click="toggleDevelopingBox()" data-target="" class='cd-login save'>Add To Bucket List</a>
                                </li>
                                <li id="liChat">
                                    <a href='' data-toggle="modal" ng-click="toggleDevelopingBox()" data-target="" class='cd-login chat'>Chat with provider</a>
                                </li>
                            </c:if>
                            <li class="hasChild">
                                <a href='' ng-click="toggleDevelopingBox()" class='more'>Share this package</a>

                            </li>
                            <li class="hasChild">
                                <a href='' class="language-selection">{{selectedLanguageDescription.languageName}} Description</a>
                                <div class='more-options'>
                                    <ul>
                                        <li ng-repeat="language in package.languageDescriptionList" ng-click="setSelectedLanguage($index)">
                                            {{language.languageName}} Description
                                        </li>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                        <div class="fixedBookBtn">
                            <a href="javascript:callBooking()" style="border-bottom: none;" class="btn bookButtonFloating btn-provider">Book Now</a>
                        </div>
                        <!--BOOKING FORM-->
                        <div id="booking">
                            <div class="form-booking" data-wow-duration="1s">
                                <h3 class="form-header-title">{{package.ordinaryPriceForAdult}} THB / PAX<span class="btn-close-booking">
                                        <a href="javascript:callBooking()"><img src="<c:url value="/Images/Icon/close.svg"/>" /></a>
                                    </span>
                                </h3>
                                <form action="<c:url value="/Tripper/Booking"/>" method="POST"
                                      ng-submit="validateBookForm($event)" novalidate>
                                    <div class="form-group" style='position: relative'> 
                                        <input id="bookingBtn" ng-model="$parent.$parent.selectedDate" type="text" readonly="readonly" ng-click="toggleCalendar()"
                                               name="selectedDate" placeholder="Select date" class="text-input-custom normalFont blueInput" required/>
                                        <div id='bookingCalendar'>
                                            <div class="smallCalendar">
                                                <div class="calendarYearMonth">
                                                    <a href="" class="backCalendar" ng-click="backAvailableMonth()"></a>
                                                    <h4 class="ng-binding">{{MONTHS_OF_YEAR[calendarTime.getMonth()]}} {{calendarTime.getFullYear()}}</h4>
                                                    <a href="" class="nextCalendar" ng-click="nextAvailableMonth()"></a>
                                                </div>
                                                <div class="weekDays">
                                                    <ul class="clearfix">
                                                        <li>SUN</li>
                                                        <li>MON</li>
                                                        <li>TUE</li>
                                                        <li>WED</li>
                                                        <li>THU</li>
                                                        <li>FRI</li>
                                                        <li>SAT</li>
                                                    </ul>
                                                </div>
                                                <div class="calendarDate">

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group" ng-show="package.durationType !== 'days'">
                                        <select name="" ng-model="$parent.$parent.selectedTime" ng-change="selectedTimeChange()"
                                                name="selectedTime" class="text-input-custom normalFont blueInput">
                                            <option value="">Select time</option>
                                            <option ng-repeat="time in listFreeTimes" ng-value="time">{{time}}</option>
                                        </select>
                                    </div>
                                    <div class="form-group">                                            
                                        <input id="numberOfAdults" type="number" ng-model="$parent.$parent.numberOfAdults"  min="1"
                                               name="numberOfAdults" placeholder="Select number of adults" class="text-input-custom normalFont blueInput" 
                                               ng-change="checkInputPeople()"/>
                                    </div>
                                    <!--                                    <div class="form-group">
                                                                            <input  id="numberOfChilds"  type="number" class="text-input-custom normalFont blueInput" min="0"
                                                                                    ng-model="$parent.$parent.numberOfChilds" name="numberOfChilds" placeholder="Select number of childs"
                                                                                    ng-change="checkInputPeople()"/>
                                                                        </div>-->
                                    <div class="form-group" ng-repeat="child in package.childrenDiscountPreview">
                                        <input type="number" class="text-input-custom normalFont blueInput" min="0" ng-if="!child.isFree"
                                               ng-model="noChilds[$index]" name="numberOfChilds" placeholder="Children {{child.condition}}"
                                               ng-change="checkInputPeople()"/>
                                        <input type="number" class="text-input-custom normalFont blueInput" min="0" ng-if="child.isFree"
                                               ng-model="noChilds[$index]" name="numberOfChilds" placeholder="Children under {{child.age}} {{child.ageType}}"
                                               ng-change="checkInputPeople()"/>
                                    </div>
                                    <style>
                                        .bookingError {
                                            display: none;
                                        }

                                        .bookingError.active {
                                            display: inherit;
                                        }
                                    </style>
                                    <div class="form-group" ng-show="!isAvailable && isCheckAvailability">
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <p class="errorMsg">Your package sold out.</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group bookingError" id="adultsError" ng-show="bookingErrorMsg">
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <p class="errorMsg">Please enter your number of adults.</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group bookingError" id="miniMumError"  ng-show="bookingErrorMsg">
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <p class="errorMsg">Minimum people for this package is {{package.minTripper}}.</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group bookingError" id="maximumError"  ng-show="bookingErrorMsg">
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <p class="errorMsg">Maximum people for this package is {{package.maxTripper}}.</p>
                                            </div>
                                        </div>
                                    </div>                             
                                    <!--                                    <div class="form-group">
                                                                            <div class="row">
                                                                                <span class="col-xs-6" style="text-align:left; color:#6d6e71">Price</span>
                                                                                <span  class="col-xs-6" style="text-align:right; color: #ed683c">
                                                                                    {{package.ordinaryPriceForAdult| currency :"$": 2}}
                                                                                </span>
                                                                            </div>
                                                                        </div> -->
                                    <input type="hidden" name="packageID" value="{{package.id}}" />
                                    <div class="booking-btn-row">
                                        <button type="submit" class="btn btn-custom-default btn-pink common-btn">Request to book</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--END OPTION-->


            <div class="detail-section">
                <div class="wrapper">
                    <div class="detail-section-content">
                        <div class="single-detail-section bigSectionTitle">
                            <h4>What is inside this package</h4>
                        </div>
                        <div class="single-detail-section" ng-repeat="singleDescription in selectedLanguageDescription.description">
                            <div class="multil-single">
                                <h5>{{singleDescription.header}}</h5>
                            </div>
                            <div class="multil-single">
                                <p>{{singleDescription.description}}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="detail-section blue-bg">
                <div class="wrapper">
                    <div class="detail-section-content" id="pkg-content-bd">
                        <div class="single-detail-section">
                            <div class="single-content-bd clearfix">
<!--                                <div class="content-bd-name">
                                    Type
                                </div>-->
                                <div class="content-bd-content">

                                    <div class="content-bd-row">
                                        <div class="row">
                                            <div class="col-xs-3">
                                                <div class="content-bd-title">
                                                    <span class="title-icon">
                                                        <img src="/Images/Icon/package-page-categoryIcon.svg"/>
                                                    </span>
                                                    <span class="title-name">CATEGORY</span>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="content-bd-detail">
                                                    {{package.categoryName}}
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="content-bd-title">
                                                    <span class="title-icon">
                                                        <img src="/Images/Icon/package-page-frequencyIcon.svg"/>
                                                    </span>
                                                    <span class="title-name">FREQUENCY</span>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="content-bd-detail">
                                                    Operates everyday
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="content-bd-row">
                                        <div class="row">
                                            <div class="col-xs-3">
                                                <div class="content-bd-title">
                                                    <span class="title-icon">
                                                        <img src="/Images/Icon/package-page-servingIcon.svg"/>
                                                    </span>
                                                    <span class="title-name">SERVING TYPE</span>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="content-bd-detail">
                                                    {{package.packageType}}
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="content-bd-title">
                                                    <span class="title-icon">
                                                        <img src="/Images/Icon/package-page-hourIcon.svg"/>
                                                    </span>
                                                    <span class="title-name">BOOKING HOURS</span>
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
                                                    <span class="title-icon">
                                                        <img src="/Images/Icon/package-page-suiabilityIcon.svg"/>
                                                    </span>
                                                    <span class="title-name">SUITABILITY</span>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="content-bd-detail">
                                                    <span ng-repeat="suitability in package.suitabilities">
                                                        {{suitability.suitabilityName}}<span ng-if="!$last">, </span>
                                                    </span>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="content-bd-title">
                                                    <span class="title-icon">
                                                        <img src="/Images/Icon/package-page-closedDayIcon.svg"/>
                                                    </span>
                                                    <span class="title-name">CLOSED DAYS</span>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
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

                        
                    </div>
                </div>
            </div>


            

            

            <div class="detail-section white-bg">
                <div class="wrapper">
                    <div class="detail-section-content" id="package-add-images">
                        <div class="package-gallery">
                            <div class="row">
                                <div class="col-md-6 col-sm-6" ng-repeat="image in package.additionImages| limitTo : 2">
                                    <div class="rect-img">
                                        <a ng-click="initGallery()" href='' 
                                           ng-style="{'background-image': 'url(' + image.image + ')'}"></a>
                                    </div>
                                </div>                           
                            </div>
                            <div class="row">
                                <div class="col-md-4 col-sm-4" ng-repeat="image in package.additionImages| limitTo : 3 : 2">
                                    <div class="square-img">
                                        <a ng-click="initGallery()" href='' 
                                           ng-style="{'background-image': 'url(' + image.image + ')'}"></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div id="gallery"></div>
                    </div>
                </div>
            </div>

            <div class="detail-section">
                <div class="wrapper">
                    <div class="detail-section-content">
                        <div class="single-detail-section bigSectionTitle">
                            <h4>Location and Destinations</h4>
                            <p class="section-alt">Follow your journey on the map below</p>
                        </div>

                        <div class="single-detail-section">
                            <div id="map">

                            </div>
                        </div>

                        <div class="single-detail-section">
                            <div class="row" id="location-ctrs">
                                <div class="col-xs-3">
                                    <div class="location-ctr type-all" ng-class="{'active' : selectedLocation === ''}">
                                        <a href="" ng-click="setSelectedLocation('')">Show all locations</a>
                                    </div>
                                </div>
                                <div class="col-xs-3">
                                    <div  class="location-ctr type-action" ng-class="{'active' : selectedLocation === 'action'}">
                                        <a href="" ng-click="setSelectedLocation('action')">Only package locations</a>
                                    </div>
                                </div>
                                <div class="col-xs-3" >
                                    <div class="location-ctr type-departure" ng-class="{'active' : selectedLocation === 'departure'}">
                                        <a href="" ng-click="setSelectedLocation('departure')">Only departure locations</a>
                                    </div>
                                </div>
                                <div class="col-xs-3" >
                                    <div class="location-ctr type-pickup" ng-class="{'active' : selectedLocation === 'pickup'}">
                                        <a href="" ng-click="setSelectedLocation('pickup')">Only pickup locations</a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="single-detail-section" id="pkg-detail-location">

                            <div class="single-location type-action" ng-if="selectedLocation === '' || selectedLocation === 'action'"
                                 ng-repeat="actionLocation in selectedLanguageDescription.advancedAddress['action']">
                                <div class="location-name">
                                    <h5>                               
                                        {{actionLocation.content}}
                                    </h5>
                                </div>
                                <div class="location-addr-time">
                                    <div class="location-addr">
                                        <p>{{actionLocation.addr}}</p>
                                    </div>
                                    <div class="location-time">
                                        <span ng-show="package.languageDescriptionList[0].advancedAddress['action'][$index].startTime.length">Start Time: {{package.languageDescriptionList[0].advancedAddress['action'][$index].startTime}}</span>
                                        <span ng-show="package.languageDescriptionList[0].advancedAddress['action'][$index].endTime.length">End Time: {{package.languageDescriptionList[0].advancedAddress['action'][$index].endTime}}</span>
                                    </div>
                                </div>
                                <div class="location-dsc">
                                    <p>
                                        {{actionLocation.accessDescription}}
                                    </p>
                                </div>
                            </div>

                            <div class="single-location type-departure" ng-if="selectedLocation === '' || selectedLocation === 'departure'"
                                 ng-repeat="actionLocation in selectedLanguageDescription.advancedAddress['departure']">
                                <div class="location-name">
                                    <h5>                               
                                        {{actionLocation.content}}
                                    </h5>
                                </div>
                                <div class="location-addr-time">
                                    <div class="location-addr">
                                        <p>{{actionLocation.addr}}</p>
                                    </div>
                                    <div class="location-time">
                                        <span ng-show="package.languageDescriptionList[0].advancedAddress['departure'][$index].startTime.length">Start Time: {{package.languageDescriptionList[0].advancedAddress['departure'][$index].startTime}}</span>
                                        <span ng-show="package.languageDescriptionList[0].advancedAddress['departure'][$index].endTime.length">End Time: {{package.languageDescriptionList[0].advancedAddress['departure'][$index].endTime}}</span>
                                    </div>
                                </div>
                                <div class="location-dsc">
                                    <p>
                                        {{actionLocation.accessDescription}}
                                    </p>
                                </div>
                            </div>
                            <div class="single-location  type-pickup" ng-if="selectedLocation === '' || selectedLocation === 'pickup'"
                                 ng-repeat="actionLocation in selectedLanguageDescription.advancedAddress['pickup']">
                                <div class="location-name">
                                    <h5>                               
                                        {{actionLocation.content}}
                                    </h5>
                                </div>
                                <div class="location-addr-time">
                                    <div class="location-addr">
                                        <p>{{actionLocation.addr}}</p>
                                    </div>
                                    <div class="location-time">
                                        <span ng-show="package.languageDescriptionList[0].advancedAddress['pickup'][$index].startTime.length">Start Time: {{package.languageDescriptionList[0].advancedAddress['pickup'][$index].startTime}}</span>
                                        <span ng-show="package.languageDescriptionList[0].advancedAddress['pickup'][$index].endTime.length">End Time: {{package.languageDescriptionList[0].advancedAddress['pickup'][$index].endTime}}</span>
                                    </div>
                                </div>
                                <div class="location-dsc">
                                    <p>
                                        {{actionLocation.accessDescription}}
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="detail-section white-bg">
                <div class="wrapper">
                    <div class="detail-section-content" id="package-comment">
                        <div class="single-detail-section bigSectionTitle">
                            <h4>Reviews and Ratings</h4>
                            <p class="section-alt">Find out what the youtripper community thought about this package</p>
                        </div>
                        <div class="comment-block row">
                            <div class="avatar col-xs-1">
                                <img src="/Images/Icon/User-Default.jpg"/>           
                            </div>
                            <div class="detail col-xs-11">
                                <div class="name">
                                    duong khang
                                </div>
                                <div class="time-rate">
                                    Nov.26th.2015
                                </div>
                                <div class="message">
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eget suscipit nulla. Morbi sed massa mi. Quisque at neque
                                    Duis finibus lobortis nisl, sit amet consectetur nisi. Nunc eu lacus porttitor, porta nisl quis, pulvinar lectus. Curabitur dapibus
                                    fermentum neque. Cras porta lectus risus, sed sodales erat hendrerit ut.
                                </div>
                            </div>
                        </div>
                        <div class="comment-block row">
                            <div class="avatar col-xs-1">
                                <img src="/Images/Icon/User-Default.jpg"/>           
                            </div>
                            <div class="detail col-xs-11">
                                <div class="name">
                                    duong khang
                                </div>
                                <div class="time-rate">
                                    Nov.26th.2015
                                </div>
                                <div class="message">
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eget suscipit nulla. Morbi sed massa mi. Quisque at neque
                                    Duis finibus lobortis nisl, sit amet consectetur nisi. Nunc eu lacus porttitor, porta nisl quis, pulvinar lectus. Curabitur dapibus
                                    fermentum neque. Cras porta lectus risus, sed sodales erat hendrerit ut.
                                </div>
                            </div>
                        </div>
                        <div class="comment-block row">
                            <div class="avatar col-xs-1">
                                <img src="/Images/Icon/User-Default.jpg"/>           
                            </div>
                            <div class="detail col-xs-11">
                                <div class="name">
                                    duong khang
                                </div>
                                <div class="time-rate">
                                    Nov.26th.2015
                                </div>
                                <div class="message">
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eget suscipit nulla. Morbi sed massa mi. Quisque at neque
                                    Duis finibus lobortis nisl, sit amet consectetur nisi. Nunc eu lacus porttitor, porta nisl quis, pulvinar lectus. Curabitur dapibus
                                    fermentum neque. Cras porta lectus risus, sed sodales erat hendrerit ut.
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            
        </div>

        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="report-box">
                    <form id="EmailForm" action="<c:url value="/Tripper/TestTag"/>">
                        <div class="report-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Share this trip</h4>
                        </div>
                        <div class="modal-body">
                            <div class=title>Send To</div>
                            <div id="wrapper">
                                <p><input name="EmailList" ng-model="emailValue" id="tag2" value="" placeholder="Emails" />
                                </p>
                            </div>
                            <div class=title>Message</div>
                            <textarea id="message" class="normalFont" placeholder="Check out this cool package on YouTripper"></textarea>
                            <input id="SendMail" type="submit" value="Send Email" class="report-btn" />
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="modal fade" id="embedLink" role="dialog">
            <div class="embedlink-modal">
                <!-- Modal content-->
                <!--                        <div class="report-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title">Embed this listing</h4>
                                        </div>-->
                <div class="embedlink-body-left" id="copyDivContent" style="background-color:#f5f5f5; width: 570px;
                     position:relative;
                     display:inline-block;
                     float:left;
                     }">
                    <div class="embedlink-show"  style="margin: 35px;
                         background-color:#fff;">
                        <div class="embedlink-image" style="padding:20px;">
                            <img ng-src="{{package.coverImage + '?' + currentTime}}" style="max-width: 100%;"/>
                        </div>
                        <div class="embedlink-title" style="padding:0px 20px;"> <a style="color:inherit;" href="<c:url value="/Package/"/>{{package.id}}"> <span style="font-size:large;">{{package.name}}</span></a></div>
                        <div class="embedlink-location" style="padding:0px 20px;"><span>{{package.city}}</span></div>
                        <br/>
                        <div class="embedlink-description" style="padding:0px 20px;"><span style="overflow:hidden; display:inline-block;max-height:100px;">The Unesco World Heritage site of Ayutthaya is 53 miles (85 kilometers) north of Bangkok. Many of its temples are still intact, such as Wat Phra Sanphet, Wat Mongkhon Bophit, Wat Panangcherng and Wat Chai Mongkol...</span></div>
                    </div>
                </div>
                <div class="embedlink-body-right">
                    <div class="" style="text-align:center;vertical-align: middle;top:200px;position: relative;">
                        <span>Copy and paste the following HTML into your website.</span>
                        <br/>

                        <textarea id="copyContent" readonly="" rows="3" style="max-width:350px;
                                  height: 200px;width:100%;border:15px solid white;outline:1px solid grey;"></textarea>
                        <br/>
                        <input id="buttonCopy" type="submit" value="Copy html" class="report-btn" />
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="ProviderModal" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="report-box">
                    <form id="EmailForm" action="<c:url value="/Tripper/TestTag"/>">
                        <div class="report-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">This option not available for you!</h4>
                        </div>                            
                    </form>
                </div>
            </div>
        </div>
        <div class="filters-btn fixed">
            <a href="javascript:callFixedBooking()" class="btn-primary btn-orange">Book this package</a>
        </div>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="ReportmyModal" role="dialog">
        <div class="modal-dialog">
            <!-- Modal content-->
            <div class="report-box">
                <form method="POST" action="<c:url value="/Common/ReportProvider"/>" ng-submit="validateReportForm($event)">
                    <div class="report-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Do you want anonymously report this provider?</h4>
                    </div>
                    <div class="modal-body">
                        <div class="title">Please choose the reason you want to report:</div>
                        <ul>
                            <li ng-repeat="x in ReportType">
                                <div class="tempCheckbox">
                                    <input type="radio" ng-click="CheckReason(x.name)" name="reportValue" ng-value="x.reportTypeID">
                                    <span></span>
                                </div>
                                <p>{{x.name}}</p>
                            </li>
                            <li>
                                <div class="tempCheckbox">
                                    <input type="radio" name="reportValue" ng-click="CheckOther()" value="0">
                                    <span></span>
                                </div>
                                <p>Or write other reason:</p>
                            </li>
                        </ul>
                        <input style="display: none" type="text" ng-value="{{package.id}}" name="packageID">
                        <input style="display: none" type="text" ng-value="{{package.providerID}}" name="providerID">
                        <input style="display: none" type="text" value="{{reason}}" name="ReasonDetail">
                        <input style="display: none" type="text" value="{{otherReason}}" name="otherReasonDetail">
                        <div ng-show="errorFlag" style="color: red">Please select 1 option </div>
                        <textarea ng-model="otherReason" ng-disabled="DisableValue" value=""></textarea>                                  
                        <input type="submit" value="Report" class="report-btn" />
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div id="chatBoxContainer" style="display: none;">
        <div id="chatHeader">
            <div id="headerSub1">
                <img style="padding-right: 10px" src="<c:url value="/Images/Icon/chatIcon.svg"/>">  Live Chat Support
                <img id="closeChatButton"  src="<c:url value="/Images/Icon/close.svg"/>">
            </div>
            <div id="headerSub2">
                You are now connected with {{package.providerName}}'s tour
            </div>
        </div>
        <div id="chatBody">
            {{blankMessage}}
            <textarea ng-model="messageContain" id="textMessage"></textarea>
            <button ng-click="sendMessageViaChatbox()" id="sendMessage">Send</button>
        </div>
    </div>
    <%@ include file="../footer.jsp" %>
    <!--<script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>-->
    <script src="<c:url value="/Resources/Theme/js/script.min.js"/>"></script>
    <script src="<c:url value="/Resources/Theme/js/notify.js"/>"></script>
    <script src="<c:url value="/Resources/Theme/js/jquery.plugin.js"/>"></script>
    <script src="<c:url value="/Resources/Theme/js/wow.min.js"/>"></script>
    <script src="<c:url value="/Resources/Theme/js/main.js"/>"></script>
    <script>
                var specificPackage = ${requestScope.packageDTO};
                var toDate = "${requestScope.toDate}";
                var getReviewUrl = '<c:url value="/Common/getReviewByTime"/>';
                var SendEmailURL = '<c:url value="/Common/SharePackageViaEMail"/>';
                var EmailList = "";
                var reportType = ${requestScope.ReportType};
                var senderName = '${sessionScope.account.name}';
                var userID = '${sessionScope.account.id}';
                function login() {
                var $form_modal = $('.cd-user-modal'),
                        $form_login = $form_modal.find('#cd-login'),
                        $form_signup_1 = $form_modal.find('#cd-signup-1'),
                        $form_signup_2 = $form_modal.find('#cd-signup-2'),
                        $form_forgot_password = $form_modal.find('#cd-reset-password'),
                        $form_modal_tab = $('.cd-switcher'),
                        $tab_login = $form_modal_tab.children('li').eq(0).children('a'),
                        $tab_signup = $form_modal_tab.children('li').eq(1).children('a');
                $('.cd-user-modal').toggleClass('is-visible');
                $form_login.addClass('is-selected');
                $form_signup_1.removeClass('is-selected');
                $form_signup_2.removeClass('is-selected');
                $form_forgot_password.removeClass('is-selected');
                $tab_login.addClass('selected');
                $tab_signup.removeClass('selected');
                }
                ;
                $("#options ul.options-name li.hasChild").hover(
                        function () {
                        $(this).find(".more-options").addClass("active");
                        }, function () {
                $(this).find(".more-options").removeClass("active");
                }
                );
                $("#EmailForm").submit(function (event) {
                EmailList = $('#tag2').val();
                event.preventDefault();
                angular.element(document.getElementById('htmlID')).scope().sendEmail();
                });
                //disable mouse drag select start
//
//                                    document.onselectstart = new Function('return false');
//                                    function dMDown(e) {
//                                        return false;
//                                    }
//                                    function dOClick() {
//                                        return true;
//                                    }
//                                    document.onmousedown = dMDown;
//                                    document.onclick = dOClick;
//                                    $("#document").attr("unselectable", "on");
////disable mouse drag select end
////disable right click - context menu
//                                    document.oncontextmenu = new Function("return false");
////disable CTRL+A/CTRL+C through key board start
////use this function
//                                    function disableSelectCopy(e) {
//
//// current pressed key
//
//                                        var pressedKey = String.fromCharCode(e.keyCode).toLowerCase();
//                                        if (e.ctrlKey && (pressedKey == "c" || pressedKey == "x" || pressedKey == "v" || pressedKey == "a")) {
//                                            return false;
//                                        }
//                                    }
//                                    document.onkeydown = disableSelectCopy;
////or use this function
//                                    $(function () {
//                                        $(document).keydown(function (objEvent) {
//                                            if (objEvent.ctrlKey || objEvent.metaKey) {
//                                                if (objEvent.keyCode == 65 || objEvent.keyCode == 97) {
//                                                    return false;
//                                                }
//                                                //}
//                                            }
//                                        });
//                                    });
//
////////////F12 disable code////////////////////////
//                                    document.onkeypress = function (event) {
//                                        event = (event || window.event);
//                                        if (event.keyCode == 123) {
//                                            //alert('No F-12');
//                                            return false;
//                                        }
//                                    }
//                                    document.onmousedown = function (event) {
//                                        event = (event || window.event);
//                                        if (event.keyCode == 123) {
//                                            //alert('No F-keys');
//                                            return false;
//                                        }
//                                    }
//                                    document.onkeydown = function (event) {
//                                        event = (event || window.event);
//                                        if (event.keyCode == 123) {
//                                            //alert('No F-keys');
//                                            return false;
//                                        }
//                                    }
///////////////////////end///////////////////////




    </script>
    <script>
        var text = $('#copyDivContent')[0].outerHTML;
        var walk_the_DOM = function walk(node, func) {
        func(node);
        node = node.firstChild;
        while (node) {
        walk(node, func);
        node = node.nextSibling;
        }
        };
        var wrapper = document.createElement('div');
        wrapper.innerHTML = text;
        walk_the_DOM(wrapper, function (el) {
        if (el.removeAttribute) {
        el.removeAttribute('id');
        el.removeAttribute('class');
        }
        });
        result = wrapper.innerHTML;
        $('#copyContent').text(result);
        $.fn.copyme = function () {
        $('span[id^="success-alert"]').remove();
        this.select();
        $(this).focus();
        document.execCommand("copy");
        document.getSelection().removeAllRanges();
        $(this).after('<span id="success-alert"><br>Copied to clipboard</span>');
        $('#success-alert').css("color", "green");
        };
        $(document).ready(function () {
        $('#buttonCopy').click(function () {

        $('#copyContent').copyme();
        });
        });
    </script>
    <script type='text/javascript' src="https://maps.googleapis.com/maps/api/js?&sensor=false&extension=.js&key=AIzaSyBxd2qXURVG6IsmGwrti3CzGwCpGNXFFuw">
    </script>
    <%@ include file="../comparisonList.jsp" %>
</body>
</html>
