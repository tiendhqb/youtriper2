<%-- 
    Document   : smartSearch
    Created on : Feb 2, 2016, 6:01:29 PM
    Author     : Nick
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >

        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style-login.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripperResponsive.css"/>" >


        <%@ include file="angular.jsp" %>

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.raty.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/page_init.js"/>" ></script> 
        <script src="<c:url value="/Resources/Theme/js/main.js"/>"></script>

        <title>YouTripper</title>
        <style>
            #routeDiv {
                min-height: 1000px;
            }
        </style>
    </head>
    <body>
        <div style='background-color: #E7E7E9' id="routeDiv">
            <%@ include file="header.jsp" %>
            <div ng-controller="SmartSearchController">

                <div class="container section-content padding-header searchPageContainer">


                    <div class="">
                        <div class="search-content search-content">
                            <!--                <div ng-hide="packages.length > 0 || !packagesLoaded" style="padding-top: 90px">
                                                No packages found with your keywords.
                                            </div>-->
                            <div id="recommend" class="full-page">                       
                                <div class="search-left full-page" class="full-page">
                                    <div class="search-step1 full-page">
                                        <div class="fillter-bottom">
                                            <div class="row">
                                                <div class="col-xs-6">
                                                    <a href="" class="common-btn  more-fillter">
                                                        FILTER
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="search-nav row youtripperScrollbar">
                                            <li class="col-sm-4 col-md-12">
                                                <h3>Popular Keywords</h3>
                                                <ul>
                                                    <li ng-repeat="subKeyword in filterOptions.keywords track by $index" >
                                                        <a href="" ng-click="changeInputTop(subKeyword)"/> {{subKeyword}} </a>
                                                    </li>
                                                    <li>
                                                        <a class="loadMore" href="" ng-click="loadMoreKeyword()">Load more +</a>
                                                    </li>
                                                </ul>

                                            </li>
                                            <li class="col-sm-4 col-md-12">
                                                <h3>Popular Packages</h3>
                                                <ul>
                                                    <li ng-repeat="popularPackage in filterOptions.popularPackages">
                                                        <a ng-href="<c:url value="/Package/"/>{{popularPackage.packageID}}"  target="_self"/>{{popularPackage.name}} </a>
                                                    </li>
                                                    <li>
                                                        <a class="loadMore" href="" ng-click="loadMorePackage()">Load more +</a>
                                                    </li>
                                                </ul>
                                            </li>
                                            <li class="col-sm-4 col-md-12">
                                                <h3>Locations</h3>
                                                <ul>
                                                    <li ng-repeat="location in filterOptions.locations">
                                                        <a ng-click="changeInputTop(location.City)" href=""/> {{location.City}}  </a>
                                                        <a  href="" ng-click="changeInputTop(location.Country)"/> {{location.Country}} </a>
                                                        <!--<a ng-href="<c:url value="/Common/Search?search="/>{{location.State}}"/> {{location.State}} </a>-->
                                                    </li>
                                                    <li>
                                                        <a class="loadMore" href="" ng-click="loadMoreLocation()">Load more +</a>
                                                    </li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="fillter fillter-hide full-page">
                                        <div class="fillter-bottom">
                                            <div class="row">
                                                <div class="col-xs-6">
                                                    <a href="" class="whiteCommon-btn" id="filter-cancel">
                                                        Back
                                                    </a>
                                                </div>
                                                <div class="col-xs-6">
                                                    <a href="" class="common-btn" ng-click="initParam()">
                                                        Reset
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="fillter-content full-page youtripperScrollbar" ng-hide="loadingFilter">
                                            <h3>Date</h3>
                                            <div class="suitability-row row group" style="margin-bottom: 0">
                                                <div class="col-xs-6 suitability-col">
                                                    <input type="text" readonly="readonly" id="calendarFilter" class="blueInput normalFont" ng-model="selectedDate" placeholder="Date"/>
                                                </div>
                                                <div class="col-xs-6 suitability-col">
                                                    <select class="blueInput" ng-model="$parent.numberTripper" convert-to-number>
                                                        <option value="0">Tripper</option>
                                                        <option value="1">1</option>
                                                        <option value="2">2</option>
                                                        <option value="3">3</option>
                                                        <option value="4">4</option>
                                                        <option value="5">5</option>
                                                        <option value="6">6</option>
                                                        <option value="7">7</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div>
                                                <!--                                    <h3><input type="checkbox" ng-model="$parent.placeNearMeFlag" value="" ng-true-value="true" ng-false-value="false"/>Place near me
                                                                                    </h3>-->
                                                <h3>Sort by</h3>
                                                <div class="filter-row row">
                                                    <div class="col-xs-4 radio-col">
                                                        <input type="radio" name="sortType" ng-model="$parent.sortType" value="1"/>
                                                        <a href="" ng-click="">Top selling</a> 
                                                    </div>
                                                    <div class="col-xs-4 radio-col">
                                                        <input type="radio" name="sortType" ng-model="$parent.sortType" value="2"/>
                                                        <a href="" ng-click="">Rating</a> 
                                                    </div>
                                                    <div class="col-xs-4 radio-col">
                                                        <input type="radio" name="sortType" ng-model="$parent.sortType" value="3"/>
                                                        <a href="" ng-click="" >Best match</a> 
                                                    </div>
                                                </div>
                                            </div>
                                            <h3>Suitability</h3>
                                            <div class="suitability-row row">
                                                <div class="col-xs-6 suitability-col">
                                                    <div class="iconCheckbox">
                                                        <input type="checkbox" checklist-model="$parent.tripTypeIDs"
                                                               checklist-value="1"/>
                                                        <a href="" ng-click="">
                                                            <span style="background-image: url(<c:url value="/Images/Icon/couple.svg"/>)"></span>
                                                            <div>Couples</div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col-xs-6 suitability-col">
                                                    <div class="iconCheckbox">
                                                        <input type="checkbox" checklist-model="$parent.tripTypeIDs"
                                                               checklist-value="2"/>
                                                        <a href="" ng-click="">
                                                            <span style="background-image: url(<c:url value="/Images/Icon/elderly.svg"/>)"></span>
                                                            <div>Elderly & Senior</div>
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="suitability-row row" style="margin-bottom: 0">
                                                <div class="col-xs-6 suitability-col">
                                                    <div class="iconCheckbox">
                                                        <input type="checkbox" checklist-model="$parent.tripTypeIDs"
                                                               checklist-value="3"/>
                                                        <a href="" ng-click="">
                                                            <span style="background-image: url(<c:url value="/Images/Icon/family.svg"/>)"></span>
                                                            <div>Family & Children</div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col-xs-6 suitability-col">
                                                    <div class="iconCheckbox">
                                                        <input type="checkbox" checklist-model="$parent.tripTypeIDs"
                                                               checklist-value="4"/>
                                                        <a href="" ng-click="">
                                                            <span style="background-image: url(<c:url value="/Resources/Theme/image/single.svg"/>)"></span>
                                                            <div>Singles</div>
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                            <div>
                                                <h3>Serving Type</h3>
                                                <div class="filter-row row">
                                                    <div class="col-xs-6 radio-col">
                                                        <input type="checkbox" name="servingType" checklist-model="$parent.servingType" checklist-value="0"/>
                                                        <a href="" ng-click="">Open tour</a> 
                                                    </div>
                                                    <div class="col-xs-6 radio-col">
                                                        <input type="checkbox" name="servingType" checklist-model="$parent.servingType" checklist-value="1"/>
                                                        <a href="" ng-click="">Private group</a> 
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-12 col-sm-6 filter-kind">
                                                    <h3>Price Range</h3>
                                                    <div class="group row price-row">
                                                        <div id="priceRange" ></div>
                                                    </div>
                                                </div>
                                                <!--                                    <div class="col-md-12 col-sm-6 filter-kind">
                                                                                        <h3>Rate</h3>
                                                                                        <div class="group row">
                                                                                            <div id="rateFilter" class="col-md-12"></div>
                                                                                        </div>
                                                                                    </div>-->
                                            </div>
                                            <h3 style="margin-top: 35px">Package Time</h3> 
                                            <div class="group row">
                                                <div class="col-xs-12">
                                                    <select class="blueInput" ng-model="$parent.groupTypeIDs">
                                                        <option value="">Any</option>
                                                        <!--<option value="1">Hourly</option>-->
                                                        <option value="2">Day time</option>
                                                        <option value="3">Night time</option>
                                                        <!--<option value="4">Full day</option>-->
                                                    </select>
                                                </div>
                                            </div>
                                            <div>
                                                <h3>Duration</h3>
                                                <div class="filter-row row">
                                                    <div class="col-xs-6 radio-col">
                                                        <input type="checkbox" name="minDuration" checklist-model="$parent.duration" checklist-value="{'minDuration':2,'maxDuration':3,'durationType':0}"/>
                                                        <a href="" ng-click="">
                                                            2-3 hours
                                                        </a> 
                                                    </div>
                                                    <div class="col-xs-6 radio-col">
                                                        <input type="checkbox" name="minDuration" checklist-model="$parent.duration" checklist-value="{'minDuration':4,'maxDuration':6,'durationType':0}"/>
                                                        <a href="" ng-click="">
                                                            4-6 hours
                                                        </a> 
                                                    </div>
                                                </div>
                                                <div class="filter-row row">
                                                    <div class="col-xs-6 radio-col">
                                                        <input type="checkbox" name="minDuration" checklist-model="$parent.duration" checklist-value="{'minDuration':7,'maxDuration':9,'durationType':0}"/>
                                                        <a href="" ng-click="">
                                                            7-9 hours
                                                        </a> 
                                                    </div>
                                                    <div class="col-xs-6 radio-col">
                                                        <input type="checkbox" name="minDuration" checklist-model="$parent.duration" checklist-value="{'minDuration':10,'maxDuration':0,'durationType':0}"/>
                                                        <a href="" ng-click="">
                                                            10+ hours
                                                        </a> 
                                                    </div>
                                                </div>
                                            </div>
                                            <div>
                                                <h3>Trust</h3>
                                                <div class="filter-row row">
                                                    <div class="col-xs-6 radio-col">
                                                        <input type="checkbox" name="trustType" checklist-model="$parent.trustType" checklist-value="0"/>
                                                        <a href="" ng-click="" class="hasLogo">
                                                            <span style="background-image: url(<c:url value="/Images/Icon/medal.svg"/>)"></span>
                                                            Provider medal
                                                        </a> 
                                                    </div>
                                                    <div class="col-xs-6 radio-col">
                                                        <input type="checkbox" name="trustType" checklist-model="$parent.trustType" checklist-value="1"/>
                                                        <a href="" ng-click="" class="hasLogo">
                                                            <span style="background-image: url(<c:url value="/Images/Icon/certified.svg"/>)"></span>
                                                            Certified logo
                                                        </a> 
                                                    </div>
                                                </div>
                                            </div>
                                            <h3>Trip Language</h3> 
                                            <div class="group row">
                                                <div class="col-xs-12">
                                                    <select class="blueInput" ng-model="$parent.language">
                                                        <option value="">Any</option>
                                                        <option value="English">English</option>
                                                        <option value="Thai">Thai</option>
                                                        <option value="Vietnam">Vietnam</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="foundPackages" ng-controller="OptionsController" class="">
                                <div class="center-inform" ng-hide="packagesLoaded">
                                    <div class="small-spinner" ></div>
                                </div>
                                <div class="search-right" ng-show="packagesLoaded">
                                    <div class="center-informBlock" ng-show="packages.length <= 0 && sizeOfHashMap(suggestion) <= 0 && packagesLoaded">
                                        No packages.
                                    </div>
                                    <div class="row" ng-hide="(packages.length <= 0 || sizeOfHashMap(suggestion) > 0) && packagesLoaded">
                                        <div class="package-box col-lg-4 col-md-6 col-xs-12"  ng-repeat="package in packages" init-boxer>
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
                                                                       class="quickView-option boxer" data-boxer-height="450" data-boxer-width="900"
                                                                       >Quick view</a>
                                                                </li>
                                                                <!--                                                        <li>
                                                                                                                            <a href=""
                                                                                                                               ng-click="toggleDevelopingBox()" 
                                                                                                                               >Quick view</a>
                                                                                                                        </li>-->
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
                                        </div>
                                        <!--<p ng-hide="total > 0" class="notify-paragraph" ng-cloak ng-hide="loading || loadingFilter">No results found</p>-->
                                    </div>
                                    <div class="row" ng-show="sizeOfHashMap(suggestion) > 0 && packagesLoaded">
                                        <p class="col-xs-12">Did you mean?</p>
                                        <div class="package-box col-lg-4 col-sm-6 col-md-4 col-xs-12" ng-repeat="(suggestionKeyword, package) in suggestion" init-boxer>
                                            <p>Keyword: <a href="" ng-click="changeInputTop(suggestionKeyword)" class="href-orange">{{suggestionKeyword}}</a></p>
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
                                                                       class="quickView-option boxer" data-boxer-height="400" data-boxer-width="800"
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
                                                                <li>
                                                                    <a href="<c:url value="/Common/ProviderPage"/>/{{package.providerID}}" class="other-option" target="_self">Other trips</a>
                                                                </li>
                                                                <li>
                                                                    <a href="" ng-click="" class="share-option">Share this trip</a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                    <span class="item-price common-btn">{{package.ordinaryPrice| currency}}</span>
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
                                                        <a href="" ng-click="addToComparisonList(package.packageID, package.packageName)" class="comparison-option">
                                                            <span></span>
                                                            Compare
                                                        </a>
                                                    </div>
                                                </div>                     
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="comment-spinner" ng-show="loadingScroll"></div>
                                    </div>

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
                                                                           class="quickView-option boxer" data-boxer-height="400" data-boxer-width="800"
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
                            </div>
                        </div>
                    </div>
                    <%@ include file="comparisonList.jsp" %>
                </div>
            </div>
        </div>
    </body>
</html>