<%-- 
    Document   : homepage
    Created on : Feb 2, 2016, 5:40:07 PM
    Author     : Nick
--%>

<%@page import="Interface.Service.ErrorService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html>
    <head>
        <meta name="description" content="">
        <meta name="viewport" content="width=1366">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >

        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">

        <link href="<c:url value="/Resources/Theme/css/pepper-ginder-custom.css"/>" rel="stylesheet">

        <link href="<c:url value="/Resources/Theme/css/jquery.fs.boxer.css"/>" rel="stylesheet">

        <link href="<c:url value="/Resources/Theme/css/jquery.mThumbnailScroller.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/lightgallery.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/lightslider.css"/>" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style-login.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripperResponsive.css"/>" >


        <%@ include file="angular.jsp" %>

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.fs.boxer.js"/>"></script>
        <title>YouTripper</title>
        <script src="<c:url value="/Resources/Theme/js/page_init.js"/>" ></script> 
        <script src="<c:url value="/Resources/Theme/js/jquery.diyslider.min.js"/>" ></script> 
    </head>
    <body ng-app="YouTripper" ng-controller="RouteController">
        <!--<a href="<c:url value="/Home/SmartSearch"/>" class="href-orange">Go</a>-->
        <!--<input type="text" name="" value="" ng-model="txtTest"/>-->
        <div style='background-color: #E7E7E9' id="routeDiv">
            <%@ include file="header.jsp" %>
            <div ng-app="YouTripper" ng-controller="FixedComparisonController" id="homepage">
                <!--DEVELOPING POPUP-->
                <div class="ytPopup" id="developingBox"  >
                    <div class="tbl-cell noClick" ng-controller="DevelopingControler">
                        <div class="popupContent" >
                            <div class="center-informBlock blur-backgroud" ng-show="!send.header - search - box > divInfo">
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

                <%@ include file="comparisonList.jsp" %>

                <!--RECOMMENDED-->
                <div class="home-section">
                    <div class="home-section-container">
                        <div class="section-title">
                            <h4>Recommended Packages</h4>
                            <h5>Our top Picks This Month</h5>
                        </div>
                        <div class="section-content">
                            <div class="home-packages">
                                <span class="ctrl left-ctrl"
                                      ng-mouseover="stopRecommendSlider()"
                                      ng-mouseleave="runRecommendSlider()"
                                      ng-click="clickToBackRecommendSlider()"></span>
                                <span class="ctrl right-ctrl"
                                      ng-mouseover="stopRecommendSlider()"
                                      ng-mouseleave="runRecommendSlider()"
                                      ng-click="clickToNextRecommendSlider()"></span>
                                <div class="slider" id="recommendSlider">
                                    <ul class="clearfix slider-data" 
                                        ng-mouseover="stopRecommendSlider()"
                                        ng-mouseleave="runRecommendSlider()">
                                        <li>
                                            <div class="single-package" style="background-image: url(<c:url value="/Resources/Theme/image/trekking.png"/>)">
                                                <a href="" class="bg" ng-click="toggleDevelopingBox()">
                                                    <img src="<c:url value="/Resources/Theme/image/trekking.png"/>"/>
                                                </a>
                                                <div class="package-title">
                                                    <h4><a href="">A package Title 1</a></h4>
                                                    <div class="address">
                                                        <span class="icon"></span>
                                                        <p>Bangkok, Thailand</p>
                                                    </div>
                                                </div>

                                                <span class="package-price">
                                                    $200.00
                                                </span>
                                            </div>
                                        </li><li>
                                            <div class="single-package" style="background-image: url(<c:url value="/Resources/Theme/image/trekking.png"/>)">
                                                <a href="" class="bg" ng-click="toggleDevelopingBox()">
                                                    <img src="<c:url value="/Resources/Theme/image/trekking.png"/>"/>
                                                </a>
                                                <div class="package-title">
                                                    <h4><a href="">A package Title 2</a></h4>
                                                    <div class="address">
                                                        <span class="icon"></span>
                                                        <p>Bangkok, Thailand</p>
                                                    </div>
                                                </div>

                                                <span class="package-price">
                                                    $200.00
                                                </span>
                                            </div>
                                        </li><li>
                                            <div class="single-package" style="background-image: url(<c:url value="/Resources/Theme/image/trekking.png"/>)">
                                                <a href="" class="bg" ng-click="toggleDevelopingBox()">
                                                    <img src="<c:url value="/Resources/Theme/image/trekking.png"/>"/>
                                                </a>
                                                <div class="package-title">
                                                    <h4><a href="">A package Title 3</a></h4>
                                                    <div class="address">
                                                        <span class="icon"></span>
                                                        <p>Bangkok, Thailand</p>
                                                    </div>
                                                </div>

                                                <span class="package-price">
                                                    $200.00
                                                </span>
                                            </div>
                                        </li><li>
                                            <div class="single-package" style="background-image: url(<c:url value="/Resources/Theme/image/trekking.png"/>)">
                                                <a href="" class="bg" ng-click="toggleDevelopingBox()">
                                                    <img src="<c:url value="/Resources/Theme/image/trekking.png"/>"/>
                                                </a>
                                                <div class="package-title">
                                                    <h4><a href="">A package Title 4</a></h4>
                                                    <div class="address">
                                                        <span class="icon"></span>
                                                        <p>Bangkok, Thailand</p>
                                                    </div>
                                                </div>

                                                <span class="package-price">
                                                    $200.00
                                                </span>
                                            </div>
                                        </li><li>
                                            <div class="single-package" style="background-image: url(<c:url value="/Resources/Theme/image/trekking.png"/>)">
                                                <a href="" class="bg" ng-click="toggleDevelopingBox()">
                                                    <img src="<c:url value="/Resources/Theme/image/trekking.png"/>"/>
                                                </a>
                                                <div class="package-title">
                                                    <h4><a href="">A package Title 5</a></h4>
                                                    <div class="address">
                                                        <span class="icon"></span>
                                                        <p>Bangkok, Thailand</p>
                                                    </div>
                                                </div>

                                                <span class="package-price">
                                                    $200.00
                                                </span>
                                            </div>
                                        </li><li>
                                            <div class="single-package" style="background-image: url(<c:url value="/Resources/Theme/image/trekking.png"/>)">
                                                <a href="" class="bg" ng-click="toggleDevelopingBox()">
                                                    <img src="<c:url value="/Resources/Theme/image/trekking.png"/>"/>
                                                </a>
                                                <div class="package-title">
                                                    <h4><a href="">A package Title 6</a></h4>
                                                    <div class="address">
                                                        <span class="icon"></span>
                                                        <p>Bangkok, Thailand</p>
                                                    </div>
                                                </div>

                                                <span class="package-price">
                                                    $200.00
                                                </span>
                                            </div>
                                        </li><li>
                                            <div class="single-package" style="background-image: url(<c:url value="/Resources/Theme/image/trekking.png"/>)">
                                                <a href="" class="bg" ng-click="toggleDevelopingBox()">
                                                    <img src="<c:url value="/Resources/Theme/image/trekking.png"/>"/>
                                                </a>
                                                <div class="package-title">
                                                    <h4><a href="">A package Title 7</a></h4>
                                                    <div class="address">
                                                        <span class="icon"></span>
                                                        <p>Bangkok, Thailand</p>
                                                    </div>
                                                </div>

                                                <span class="package-price">
                                                    $200.00
                                                </span>
                                            </div>
                                        </li><li>
                                            <div class="single-package" style="background-image: url(<c:url value="/Resources/Theme/image/trekking.png"/>)">
                                                <a href="" class="bg" ng-click="toggleDevelopingBox()">
                                                    <img src="<c:url value="/Resources/Theme/image/trekking.png"/>"/>
                                                </a>
                                                <div class="package-title">
                                                    <h4><a href="">A package Title 8</a></h4>
                                                    <div class="address">
                                                        <span class="icon"></span>
                                                        <p>Bangkok, Thailand</p>
                                                    </div>
                                                </div>

                                                <span class="package-price">
                                                    $200.00
                                                </span>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--END RECOMMENDED-->

                <!--ACTIVITES-->
                <div class="home-section lightBg">
                    <div class="home-section-container">
                        <div class="section-title">
                            <h4>Activities in <span>Bangkok</span> <span class="location-arrow"></span></h4>
                            <h5>Discover new inspiring things to do</h5>
                        </div>
                        <div class="section-content">
                            <div class="home-packages">
                                <ul class="clearfix">
                                    <c:forEach var="x" items="${requestScope.packageInBangkok}">
                                        <li>                                        
                                            <div class="single-package" style="background-image: url(${x.coverImage})">
                                                <a href="" class="bg" ng-click="toggleDevelopingBox()">
                                                    <img src="${x.coverImage}"/>
                                                </a>
                                                <div class="package-title">
                                                    <h4><a href="">${x.name}</a></h4>
                                                    <div class="address">
                                                        <span class="icon"></span>
                                                        <p>${x.city}, ${x.country}</p>
                                                    </div>
                                                </div>
                                                <c:choose>
                                                    <c:when test="${x.priceCurrency != 'THB'}">
                                                        <span class="package-price">
                                                            $<fmt:formatNumber 
                                                                value="${x.youtripperPrice}"
                                                                groupingUsed="false"  minFractionDigits="2" />     
                                                        </span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <span class="package-price">
                                                            <fmt:formatNumber 
                                                                value="${x.youtripperPrice}"
                                                                groupingUsed="false"  minFractionDigits="2" />   
                                                            THB
                                                        </span>
                                                    </c:otherwise>
                                                </c:choose>

                                            </div>
                                        </li>                  
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>

                        <div class="section-btn">
                            <a href="">Show more</a>
                        </div>
                    </div>
                </div>
                <!--END ACTIVITIES-->


                <!--LOCATIONS-->
                <div class="home-section whiteBg same-content full-section">
                    <div class="home-section-container">
                        <div class="section-title" style="background-color: #F2F2F4;">
                            <h4>Most Popular Destinations</h4>
                            <h5>Discover new inspiring things to do</h5>
                        </div>

                        <div class="section-content">
                            <div class="home-activites">
                                <ul class="clearfix">
                                    <li>
                                        <div class="single-activity" style="background-image: url(/Images/HomeCover/bangkok.jpg)">
                                            <div class="tbl-center">
                                                <div class="tbl-cell">
                                                    <h3>BANGKOK</h3>
                                                </div>
                                            </div>
                                            <a href="" ng-click="toggleDevelopingBox()">
                                                <img src="/Images/HomeCover/bangkok.jpg"/>
                                            </a>
                                        </div>
                                    </li>

                                    <li>
                                        <div class="single-activity" style="background-image: url(/Images/HomeCover/phuket.jpg)">
                                            <div class="tbl-center">
                                                <div class="tbl-cell">
                                                    <h3>PHUKET</h3>
                                                </div>
                                            </div>
                                            <a href="" ng-click="toggleDevelopingBox()">
                                                <img src="/Images/HomeCover/phuket.jpg"/>
                                            </a>
                                        </div>
                                    </li>

                                    <li>
                                        <div class="single-activity" style="background-image: url(/Images/HomeCover/chiangmai.jpg)">
                                            <div class="tbl-center">
                                                <div class="tbl-cell">
                                                    <h3>CHIANGMAI</h3>
                                                </div>
                                            </div>
                                            <a href="" ng-click="toggleDevelopingBox()">
                                                <img src="/Images/HomeCover/chiangmai.jpg"/>
                                            </a>
                                        </div>
                                    </li>

                                    <li>
                                        <div class="single-activity" style="background-image: url(/Images/HomeCover/pattaya.jpg)">
                                            <div class="tbl-center">
                                                <div class="tbl-cell">
                                                    <h3>PATTAYA</h3>
                                                </div>
                                            </div>
                                            <a href="" ng-click="toggleDevelopingBox()">
                                                <img src="/Images/HomeCover/pattaya.jpg"/>
                                            </a>
                                        </div>
                                    </li>

                                    <li>
                                        <div class="single-activity" style="background-image: url(/Images/HomeCover/sukhothai.jpg)">
                                            <div class="tbl-center">
                                                <div class="tbl-cell">
                                                    <h3>SUKHOTHAI</h3>
                                                </div>
                                            </div>
                                            <a href="" ng-click="toggleDevelopingBox()">
                                                <img src="/Images/HomeCover/sukhothai.jpg"/>
                                            </a>
                                        </div>
                                    </li>

                                    <li>
                                        <div class="single-activity" style="background-image: url(/Images/HomeCover/kanchanaburi.jpg)">
                                            <div class="tbl-center">
                                                <div class="tbl-cell">
                                                    <h3>KANCHANABURI</h3>
                                                </div>
                                            </div>
                                            <a href="" ng-click="toggleDevelopingBox()">
                                                <img src="/Images/HomeCover/kanchanaburi.jpg"/>
                                            </a>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <!--END LOCATIONS-->

                <!--LATEST PACKAGES-->
                <div class="home-section same-content" id="latest-packages">
                    <div class="home-section-container">
                        <div class="section-title">
                            <h4>Our Latest Packages</h4>
                            <h5>New Arrivals This Month</h5>
                        </div>

                        <div class="section-content">
                            <div class="home-packages">
                                <span class="ctrl left-ctrl"
                                      ng-mouseover="stopNewestSlider()"
                                      ng-mouseleave="ruNewestSlider()"
                                      ng-click="clickToBackNewestSlider()"></span>
                                <span class="ctrl right-ctrl"
                                      ng-mouseover="stopNewestSlider()"
                                      ng-mouseleave="ruNewestSlider()"
                                      ng-click="clickToNextNewestSlider()"></span>
                                <div class="slider">
                                    <ul class="clearfix slider-data"
                                        ng-mouseover="stopNewestSlider()"
                                        ng-mouseleave="ruNewestSlider()">
                                        <li>
                                            <div class="single-package" style="background-image: url(<c:url value="/Resources/Theme/image/trekking.png"/>)">
                                                <a href="" class="bg" ng-click="toggleDevelopingBox()">
                                                    <img src="<c:url value="/Resources/Theme/image/trekking.png"/>"/>
                                                </a>
                                                <div class="package-title">
                                                    <h4><a href="">A package Title 1</a></h4>
                                                    <div class="address">
                                                        <span class="icon"></span>
                                                        <p>Bangkok, Thailand</p>
                                                    </div>
                                                </div>

                                                <span class="package-price">
                                                    $200.00
                                                </span>
                                            </div>
                                        </li><li>
                                            <div class="single-package" style="background-image: url(<c:url value="/Resources/Theme/image/trekking.png"/>)">
                                                <a href="" class="bg" ng-click="toggleDevelopingBox()">
                                                    <img src="<c:url value="/Resources/Theme/image/trekking.png"/>"/>
                                                </a>
                                                <div class="package-title">
                                                    <h4><a href="">A package Title 2</a></h4>
                                                    <div class="address">
                                                        <span class="icon"></span>
                                                        <p>Bangkok, Thailand</p>
                                                    </div>
                                                </div>

                                                <span class="package-price">
                                                    $200.00
                                                </span>
                                            </div>
                                        </li><li>
                                            <div class="single-package" style="background-image: url(<c:url value="/Resources/Theme/image/trekking.png"/>)">
                                                <a href="" class="bg" ng-click="toggleDevelopingBox()">
                                                    <img src="<c:url value="/Resources/Theme/image/trekking.png"/>"/>
                                                </a>
                                                <div class="package-title">
                                                    <h4><a href="">A package Title 3</a></h4>
                                                    <div class="address">
                                                        <span class="icon"></span>
                                                        <p>Bangkok, Thailand</p>
                                                    </div>
                                                </div>

                                                <span class="package-price">
                                                    $200.00
                                                </span>
                                            </div>
                                        </li><li>
                                            <div class="single-package" style="background-image: url(<c:url value="/Resources/Theme/image/trekking.png"/>)">
                                                <a href="" class="bg" ng-click="toggleDevelopingBox()">
                                                    <img src="<c:url value="/Resources/Theme/image/trekking.png"/>"/>
                                                </a>
                                                <div class="package-title">
                                                    <h4><a href="">A package Title 4</a></h4>
                                                    <div class="address">
                                                        <span class="icon"></span>
                                                        <p>Bangkok, Thailand</p>
                                                    </div>
                                                </div>

                                                <span class="package-price">
                                                    $200.00
                                                </span>
                                            </div>
                                        </li><li>
                                            <div class="single-package" style="background-image: url(<c:url value="/Resources/Theme/image/trekking.png"/>)">
                                                <a href="" class="bg" ng-click="toggleDevelopingBox()">
                                                    <img src="<c:url value="/Resources/Theme/image/trekking.png"/>"/>
                                                </a>
                                                <div class="package-title">
                                                    <h4><a href="">A package Title 5</a></h4>
                                                    <div class="address">
                                                        <span class="icon"></span>
                                                        <p>Bangkok, Thailand</p>
                                                    </div>
                                                </div>

                                                <span class="package-price">
                                                    $200.00
                                                </span>
                                            </div>
                                        </li><li>
                                            <div class="single-package" style="background-image: url(<c:url value="/Resources/Theme/image/trekking.png"/>)">
                                                <a href="" class="bg" ng-click="toggleDevelopingBox()">
                                                    <img src="<c:url value="/Resources/Theme/image/trekking.png"/>"/>
                                                </a>
                                                <div class="package-title">
                                                    <h4><a href="">A package Title 6</a></h4>
                                                    <div class="address">
                                                        <span class="icon"></span>
                                                        <p>Bangkok, Thailand</p>
                                                    </div>
                                                </div>

                                                <span class="package-price">
                                                    $200.00
                                                </span>
                                            </div>
                                        </li>
                                    </ul>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
                <!--END LATEST PACKAGES-->

                <!--BACKGROUND-->
                <div class="home-section full-section same-content">
                    <div class="home-section-container">
                        <div id="end-bg">
                            <div id="end-bg-provider">
                                <h4>Join Asia's smartest activity selling platform.</h4>

                                <c:choose>
                                    <c:when test="${empty sessionScope.language}">
                                        <a href="<c:url value="/BeProvider"/>" class="btn-width-orange">Become Provider</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="<c:url value="/BeProvider?language=${sessionScope.language}"/>" class="btn-width-orange">Become Provider</a>
                                    </c:otherwise>
                                </c:choose>

                            </div>
                        </div>
                    </div>
                </div>
                <!--END BACKGROUND-->



            </div>
        </div>
        <!--PAYMENT-->
        <div id="payment-homepage" class="clearfix">
                <div class="payment-method">
                    <p>Payment Methods</p>
                    <div class="row">
                        <div class="col-xs-3 payment-icon"> <img src="/Images/Icon/visa.svg"/></div>
                        <div class="col-xs-3 payment-icon"> <img src="/Images/Icon/masterCard.svg"/></div>
                        <div class="col-xs-3 payment-icon"> <img src="/Images/Icon/paypal.svg"/></div>
                        <div class="col-xs-3 payment-icon"> <img src="/Images/Icon/linePay.svg"/></div>

                    </div>
                </div>
                <div class="verify-method">
                    <p>Verified By</p>
                    <div class="row">
                        <div class="col-xs-6 payment-icon"> <img src="/Images/Icon/DBD.svg"/></div>
                        <div class="col-xs-6 payment-icon"> <img src="/Images/Icon/ssl.svg"/></div>
                    </div>
                </div>
        </div>
        <!--END PAYMENT-->

        <%@ include file="footer.jsp" %>
        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.mThumbnailScroller.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/lightGallery.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/lightslider.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/js-image-slider.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jssor.slider.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.raty.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/notify.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.plugin.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js"/>"></script>




        <script>
                                                            var fromHomePage = '${requestScope.fromHomePage}';

                                                            $(document).ready(function () {
                                                                SpinnerText.init('ul[data-spinner]');

                                                                toggleHeader.init({
                                                                    toggleControl: true,
                                                                    toggleTheme: true
                                                                });

                                                            });
        </script>
    </body>
</html>
