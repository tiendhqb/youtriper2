<%-- 
    Document   : providerPage
    Created on : Nov 16, 2015, 6:25:33 PM
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
        <!--<script src='https://www.google.com/recaptcha/api.js'></script>-->

        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/jquery.fs.boxer.css"/>" rel="stylesheet">

        <%@ include file="angular.jsp" %>

        <link rel="stylesheet"  href="<c:url value="/Resources/Theme/css/lightslider.css"/>" />
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css?999999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css?999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style-login.css"/>" >

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.fs.boxer.js"/>"></script>

        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >
        <title>Provider Page</title>
    </head>
    <body ng-app="YouTripper" ng-controller="ProviderPageController">
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
        <div class="pagesearch active-bg" >
            <%@ include file="header.jsp" %>
            <section class="padding-header cols-provider">
                <div class="container" >

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

                    <div class="row">
                        <div class="col-lg-3 col-md-3">
                            <!--POST PROVIDER LEFT-->
                            <div class="provider-left">
                                <div style="margin-bottom: 20px; margin-top: 20px; text-align: center" class="upload-avatar">
                                    <img alt="" ng-src="/{{ProviderInfo.image}}" />
                                </div>
                                <span id="verifyInfo">Verifications</span>
                                <ul>
                                    <li ng-show="{{ProviderInfo.emailActive}}">
                                        <span class="true">

                                        </span>
                                        <p>Email Address</p>
                                        <em>Verified</em>
                                    </li>
                                    <li ng-hide="{{ProviderInfo.emailActive}}">
                                        <span class="">

                                        </span>
                                        <p>Email Address</p>
                                        <em>Unverified</em>
                                    </li>
                                    <li ng-show="{{ProviderInfo.passportStatus}}">
                                        <span class="true">
                                        </span>
                                        <p>Passport</p>
                                        <em>Verified</em>
                                    </li>
                                    <li ng-hide="{{ProviderInfo.passportStatus}}">
                                        <span class="">
                                        </span>
                                        <p>Passport</p>
                                        <em>Unverified</em>
                                    </li>
                                    <li ng-show="{{ProviderInfo.phoneActive}}">
                                        <span class="true">
                                        </span>
                                        <p>Phone</p>
                                        <em>Verified</em>
                                    </li>
                                    <li ng-hide="{{ProviderInfo.phoneActive}}">
                                        <span class="">
                                        </span>
                                        <p>Phone</p>
                                        <em>Unverified</em>
                                    </li>
                                </ul>

                            </div>

                        </div>
                        <div class="col-lg-9 col-md-9" ng-controller="FixedComparisonController">
                            <!--POST PROVIDER RIGHT-->
                            <div class="provider-right">
                                <div class="intro-provider">
                                    <h1>{{ProviderInfo.name}}</h1>
                                    <p>{{ProviderInfo.city}}, {{ProviderInfo.countryName}}. Member since {{ProviderInfo.activeDate}} </p>
                                    <p><strong>Business Name:</strong> {{ProviderInfo.businessName}}</p>
                                    <p><strong>Business Type:</strong> {{ProviderInfo.businessType}}</p>
                                    <p><strong>About us:</strong> </p>
                                    <!--                                    <p class="report">
                                    <c:if test="${sessionScope.account != null}">
                                        <c:if test="${sessionScope.account.role == 2}">
                                            <a class="href-silver" ng-show="reportYourOwn(${sessionScope.account.id})" data-toggle="modal" data-target="#myModal"><span></span>Report this Provider</a>
                                        </c:if>
                                        <c:if test="${sessionScope.account.role == 1}">
                                    <a class="href-silver" data-toggle="modal" data-target="#myModal"><span></span>Report this Provider</a>
                                        </c:if>
                                    </c:if>
                        </p>-->
                                    <p>
                                        {{ProviderInfo.information}}
                                    </p>
                                </div>
                                <div class="point-review">
                                    <span><strong style="background-color: #fbb03b">{{totalReviews}}</strong>Reviews</span>
                                    <span><strong style="background-color: #fbb03b">{{totalRating}}</strong>Rating</span>
                                    <div class="clearfix"></div>
                                </div>

                                <!-- Certificate Begin-->
                                <div class="title-reviews">
                                    <h3 class="posts-reviews">Certificate ({{certificates.length}})</h3>
                                </div>
                                <div style="text-align: center; margin-bottom: 20px; margin-top: 20px" ng-show="{{certificates.length}} <= 0">
                                    No Certificate.
                                </div>
                                <div id="next-cer-slide" class="slider-provider-outer" ng-controller="OptionsController">
                                    <div  ng-show="{{certificates.length}} > 2">
                                        <a id="goToPrevCerSlide" class="preButton"></a>
                                        <a id="goToNextCerSlide" class="nextButton"></a>
                                    </div>
                                    <ul id="certificateSlide" class="slide-provider">
                                        <li ng-repeat="certificate in certificates" class="slider" init-boxer>
                                            <div class="category-item-block" >
                                                <!--<div class="item-image" style="background-image: url('{{package.coverImage}}')" balance-square>-->
                                                <div class="item-image"  balance-square>
                                                    <a data-toggle="modal" data-target="#myModal2" ng-click="changeName(certificate.name, certificate.certificateID, certificate.image)" target="_self">


                                                        <div class="upload-certificateImageMain" style="padding: 0px"> 
                                                            <!--                                                    <div class="item-image3"    style="border-top-left-radius:5px;border-top-right-radius:5px; background-image: url('{{certificate.image}}')" >
                                                                                                                </div>-->
                                                            <img ng-src="{{certificate.image}}" />
                                                        </div>
                                                    </a>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                                <!-- Certificate End-->
                                
                                <!--Big image POPUP-->
                                    <div id="bigCertificateImage" class="certificateBox">
                                        <div class="certificateContent">
                                            <span class="box-closing" ng-click="activeBigImageBox()"></span>
                                           
                                                <div class="row">
                                                    <div class="col-xs-12">
                                                        <img ngf-pattern="'image/*'" alt="" ng-src="{{certificateImage3}}" />
                                                    </div>
                                                </div>
                                            
                                        </div>
                                        
                                    </div>
                                    <!--END big image POPUP-->

                               

                                <!-- Package Begin-->
                                <div class="title-reviews">
                                    <h3 class="posts-reviews">Packages ({{ProviderInfo.packageList.length}})</h3>
                                </div>
                                <div style="text-align: center; margin-bottom: 20px; margin-top: 20px" ng-show="{{ProviderInfo.packageList.length}} <= 0">
                                    No Package.
                                </div>
                                <div id ="next-slide" class=" slider-provider-outer" ng-controller="OptionsController">
                                    <div ng-show="{{ProviderInfo.packageList.length}} > 2">
                                        <a id="goToPrevSlide" class="preButton"></a>
                                        <a id="goToNextSlide" class="nextButton"></a>
                                    </div>

                                    <ul id="packageSlide" class="slide-provider" >
                                        <li id ="next-slide" ng-repeat="package in ProviderInfo.packageList" class="slider" init-boxer>

                                            <div class="category-item-block">
                                                <div class="item-image" style="background-image: url('{{package.coverImage}}')" balance-square>
                                                    <a class="package-detail-href" ng-href="<c:url value="/Package/"/>{{package.packageID}}" target="_self"> </a>
                                                    <div class="option-box">
                                                        <span class="item-function">
                                                        </span>
                                                        <div class="package-option">
                                                            <ul>
                                                                <c:if test="${sessionScope.account.role == 1}">
                                                                    <li>
                                                                        <a href="" ng-click="saveWishlist(package.packageID)" class="wishlist-option">Save to your list</a>
                                                                    </li>
                                                                </c:if>
                                                                <!--                                                        <li>
                                                                                                                            <a href="<c:url value="/Common/Package/QuickView"/>/{{package.packageID}}"
                                                                                                                               ng-click="quickView(package.packageID, $event)" 
                                                                                                                               class="quickView-option boxer" data-boxer-height="400" data-boxer-width="800"
                                                                                                                               >Quick view</a>
                                                                                                                        </li>-->
                                                                <li>
                                                                    <a href="<c:url value="/Common/Package/QuickView"/>/{{package.packageID}}"
                                                                       ng-click="quickView(package.packageID, $event)" 
                                                                       class="quickView-option boxer" data-boxer-height="470" data-boxer-width="920"
                                                                       >Quick view</a>
                                                                </li>
                                                                <!--                                                    <li>
                                                                                                                        <a href="" ng-click="addToComparisonList(package.packageID, package.packageName)" class="comparison-option">
                                                                                                                            Add To Compare
                                                                                                                        </a>
                                                                                                                    </li>-->
                                                                <li>
                                                                    <a href="<c:url value="/Common/getQuickComparison"/>/{{package.packageID}}" ng-click="" data-lightbox-options='{"top":70}' data-boxer-top="70" data-boxer-height="590" data-boxer-width="1024" class="comparison-option boxer">
                                                                        Quick Comparison
                                                                    </a>
                                                                </li>
                                                                <!--                                                        <li>
                                                                                                                            <a href="<c:url value="/Common/ProviderPage"/>/{{package.providerID}}" class="other-option" target="_self">Other trips</a>
                                                                                                                        </li>
                                                                                                                        <li>
                                                                                                                            <a href="" ng-click="" class="share-option">Share this trip</a>
                                                                                                                        </li>-->
                                                                <li>
                                                                    <a href="" ng-click="toggleDevelopingBox()" class="other-option" target="_self">Other trips</a>
                                                                </li>
                                                                <li>
                                                                    <a href="" ng-click="toggleDevelopingBox()" class="share-option">Share this trip</a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                    <span class="item-price common-btn">{{package.ordinaryPrice| number : 2}} THB</span>
                                                    <!--<img class="img-responsive" src="{{package.coverImage}}" />-->
                                                </div>
                                                <div class="item-detail">
                                                    <div class=" row">
                                                        <div class="col-xs-12 pkg-name">
                                                            <article>
                                                                <a href='<c:url value="/Package/"/>{{package.packageID}}' target="_self">{{package.packageName}}</a>
                                                            </article>
                                                        </div>

                                                    </div>
                                                    <div class="row">
                                                        <div class="col-xs-12">
                                                            <div class="item-brand">
                                                                <div class="brand-img"  style="background: url(/{{package.providerImage}}) no-repeat center; background-size: cover">
                                                                </div>
                                                            </div>
                                                            <div>
                                                                <div class="item-location">
                                                                    <p>
                                                                        <span></span>{{package.location}}
                                                                    </p>
                                                                </div>
                                                                <div class='item-provider-name'>
                                                                    {{package.lastName}}
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="sub-item-detail">
                                                    <div class="package-item-review">
                                                        <div class="row">
                                                            <ul class="col-xs-6 item-rating">
                                                                <li ng-repeat="i in [0, 1, 2, 3, 4]" ng-class="{'active' : (i < package.rate), 'unactive' : (i >= package.rate)}">
                                                                </li>
                                                            </ul>
                                                            <p class="item-rating-text col-xs-6"><span></span>{{package.numberRates}} Reviews</p>
                                                        </div>
                                                    </div>
                                                    <div class="compare-btn">
                                                        <!--                                                <a href="" ng-click="addToComparisonList(package.packageID, package.packageName)" class="comparison-option">
                                                                                                            <span><div ng-class="{'compare-checked': checkComparisonItem(package.packageID)}"></div></span>
                                                                                                            Compare                                                
                                                                                                        </a>-->
                                                        <a href="" ng-click="toggleDevelopingBox()" class="comparison-option">
                                                            <span><div ng-class="{'compare-checked': checkComparisonItem(package.packageID)}"></div></span>
                                                            Compare                                                
                                                        </a>
                                                    </div>
                                                </div>                     
                                            </div>

                                        </li>
                                    </ul>
                                    <div id="ComparisonPopUp" style="display: none">

                                        <div ng-show="loadingComparison" class="loadingComparison"></div>
                                        <div ng-click="closeComparison()" id="closeComparison" >&#10006;</div>
                                        <div class="row comparison-container">
                                            <h2>Comparison</h2>
                                            <div class="package-box col-sm-6 col-xs-12"  ng-repeat="package in QuickComparisonList" init-boxer>
                                                <div class="category-item-block">
                                                    <div class="item-image" style="background-image: url('{{package.coverImage}}')" balance-square>
                                                        <a class="package-detail-href" ng-href="<c:url value="/Package/"/>{{package.packageID}}" target="_self"> </a>
                                                        <div class="option-box">
                                                            <span class="item-function">
                                                            </span>
                                                            <div class="package-option">
                                                                <ul>
                                                                    <c:if test="${sessionScope.account.role == 1}">
                                                                        <li>
                                                                            <a href="" ng-click="saveWishlist(package.packageID)" class="wishlist-option">Save to your list</a>
                                                                        </li>
                                                                    </c:if>
                                                                    <li>
                                                                        <a href="<c:url value="/Common/Package/QuickView"/>/{{package.packageID}}"
                                                                           ng-click="quickView(package.packageID, $event)" 
                                                                           class="quickView-option boxer" data-boxer-height="470" data-boxer-width="920"
                                                                           >Quick view</a>
                                                                    </li>
                                                                    <!--                                                    <li>
                                                                                                                            <a href="" ng-click="addToComparisonList(package.packageID, package.packageName)" class="comparison-option">
                                                                                                                                Add To Compare
                                                                                                                            </a>
                                                                                                                        </li>-->
                                                                    <li>
                                                                        <a href="<c:url value="/Common/getQuickComparison"/>/{{package.packageID}}" ng-click="" data-boxer-height="550" data-boxer-width="1370" class="comparison-option boxer">
                                                                            Quick Comparison
                                                                        </a>
                                                                    </li>
                                                                    <li>
                                                                        <a href="<c:url value="/Common/ProviderPage"/>/{{package.providerID}}" class="other-option" target="_self">Other trips</a>
                                                                    </li>
                                                                    <li>
                                                                        <a href="" ng-click="" class="share-option">Share this trip</a>
                                                                    </li>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                        <span class="item-price common-btn">{{package.ordinaryPriceForAdult| currency}}</span>
                                                        <!--<img class="img-responsive" src="{{package.coverImage}}" />-->
                                                    </div>
                                                    <div class="item-detail">
                                                        <div class=" row">
                                                            <div class="col-xs-12 pkg-name">
                                                                <article>
                                                                    <a href='<c:url value="/Package/"/>{{package.packageID}}' target="_self">{{package.packageName}}</a>
                                                                </article>
                                                            </div>

                                                        </div>
                                                        <div class="row">
                                                            <div class="col-xs-12">
                                                                <div class="item-brand">
                                                                    <div class="brand-img"  style="background: url(/{{package.providerImage}}) no-repeat center; background-size: cover">
                                                                    </div>
                                                                </div>
                                                                <div>
                                                                    <div class="item-location">
                                                                        <p>
                                                                            <span></span>{{package.city}}
                                                                        </p>
                                                                    </div>
                                                                    <div class='item-provider-name'>
                                                                        {{package.providerName}}
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="sub-item-detail">
                                                        <div class="package-item-review">
                                                            <div class="row">
                                                                <ul class="col-xs-6 item-rating">
                                                                    <li ng-repeat="i in [0, 1, 2, 3, 4]" ng-class="{'active' : (i < package.rate), 'unactive' : (i >= package.rate)}">
                                                                    </li>
                                                                </ul>
                                                                <p class="item-rating-text col-xs-6"><span></span>{{package.noOfReviews}} Reviews</p>
                                                            </div>
                                                        </div>
                                                        <div class="compare-btn">
                                                            <a href="" ng-click="addToComparisonList(package.packageID, package.packageName)" class="comparison-option">
                                                                <span><div ng-class="{'compare-checked': checkComparisonItem(package.packageID)}"></div></span>
                                                                Compare
                                                            </a>
                                                        </div>
                                                    </div>                     
                                                </div>
                                                <div class="rightInfoComparison">
                                                    <div class="item-rating red-rating col-xs-5 col-md-5 col-sm-5">
                                                        <ul>
                                                            <li ng-repeat="i in [0, 1, 2, 3, 4]" ng-class="{'active' : (i < package.rate), 'unactive' : (i >= package.rate)}">
                                                            </li>
                                                        </ul>   

                                                    </div><br>
                                                    Location: {{package.city}} <br>
                                                    Category: {{package.categoryName}} <br>
                                                    Included: {{package.included}} <br>
                                                    Excluded: {{package.excluded}} <br>
                                                    Group size: {{package.minTripper}} - {{package.maxTripper}} <br>
                                                    Duration: {{package.duration}} <span ng-show="{{package.durationType === 1}}">Day</span> <span ng-show="{{package.durationType === 0}}">Hours</span><br>
                                                    Suitable for: <br>
                                                    Best Provider: No

                                                    <!--<p ng-hide="total > 0" class="notify-paragraph" ng-cloak ng-hide="loading || loadingFilter">No results found</p>-->
                                                </div>
                                            </div>

                                            <!--<p ng-hide="total > 0" class="notify-paragraph" ng-cloak ng-hide="loading || loadingFilter">No results found</p>-->
                                        </div>
                                    </div>
                                </div>
                                <!--package end-->


                                <section id="reviews">
                                    <div class="row content-normal">
                                        <div class="col-md-12">
                                            <div class="title-reviews">
                                                <h3 class="posts-reviews" ng-show="reviewList.length > 0">{{totalReviews}} Reviews</h3>
                                                <h3 class="posts-reviews" ng-hide="reviewList.length > 0">0 Reviews</h3>
                                            </div>
                                            <div class="posts-comment">
                                                <div ng-repeat="review in ProviderInfo.reviewList" class="posts-user-comment clearfix">
                                                    <div class="comment-avatar">
                                                        <img class="img-responsive" src="<c:url value="/"/>{{review.tripperImage}}" />
                                                    </div>
                                                    <div class="comment">
                                                        <span>
                                                            <a class='href-orange' href="<c:url value='/Common/TripperPage/'/>{{review.tripperID}}">
                                                                {{review.tripperName}}</a>
                                                        </span>
                                                        <div class="col-xs-12 col-sm-12 col-md-12">
                                                            <span>{{review.date}}</span> 
                                                            <div class="item-rating red-rating">
                                                                <ul>
                                                                    <li ng-repeat="i in [0, 1, 2, 3, 4]" ng-class="{
                                                                            'active'
                                                                            : (i < review.rate), 'unactive' : (i >= review.rate)}">
                                                                    </li>
                                                                </ul> 
                                                            </div>
                                                        </div>
                                                        <p>{{review.review}}</p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="comment-spinner" ng-show="loading"></div>
                                            <a href="" class="btn-width-orange" ng-click="getMoreReview()" ng-hide="loading">View others review</a>
                                        </div>
                                    </div>
                                </section>
                            </div>

                            <%@ include file="comparisonList.jsp" %>                              
                        </div>
                    </div>
                </div>
            </section>
            <!--             Modal 
                        <div class="modal fade" id="myModal" role="dialog">
                            <div class="modal-dialog">
                                 Modal content
                                <div class="report-box">
                                    <form method="POST" action="<c:url value="/Common/ReportProvider"/>">
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
                                            <input style="display: none" type="text" ng-value="{{ProviderInfo.providerID}}" name="providerID">
                                            <input style="display: none" type="text" value="{{reason}}" name="ReasonDetail">
                                            <input style="display: none" type="text" value="{{otherReason}}" name="otherReasonDetail">
                                            <textarea ng-model="otherReason" ng-disabled="DisableValue" value=""></textarea>                                  
                                            <input type="submit" value="Report" class="report-btn" />
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>-->
        </div>

            <%@ include file="footer.jsp" %>
            <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/notify.js"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/lightslider.js"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/main.js?999"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/jquery.tabslet.js"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/jquery.matchHeight.js"/>"></script>
            <script>
                                                        var providerInfo = ${requestScope.ProviderInfo};
                                                        var certificates = ${requestScope.certificates};
                                                        var reportType = ${requestScope.ReportType};
                                                        var addComparisonUrl = '<c:url value="/Common/AddToComparisonList"/>';
                                                        var getReviewUrl = '<c:url value="/Common/getReviewOfProvider"/>';
                                                        $(document).ready(function () {
                                                            toggleHeader.init({
                                                                toggleControl: false
                                                            });
                                                            var slider1 = $('#packageSlide').lightSlider({
                                                                item: 2,
                                                                loop: false,
                                                                slideMove: 1,
                                                                easing: 'cubic-bezier(0.25, 0, 0.25, 1)',
                                                                speed: 600
                                                            });
                                                            $('#goToPrevSlide').click(function () {

                                                                slider1.goToPrevSlide();

                                                            });
                                                            $('#goToNextSlide').click(function () {
                                                                slider1.goToNextSlide();
                                                            });
                                                            var slider2 = $('#certificateSlide').lightSlider({
                                                                item: 2,
                                                                loop: false,
                                                                slideMove: 1,
                                                                easing: 'cubic-bezier(0.25, 0, 0.25, 1)',
                                                                speed: 600
                                                            });
                                                            $('#goToPrevCerSlide').click(function () {

                                                                slider2.goToPrevSlide();

                                                            });
                                                            $('#goToNextCerSlide').click(function () {
                                                                slider2.goToNextSlide();
                                                            });

                                                        });
            </script>
    </body>
</html>
