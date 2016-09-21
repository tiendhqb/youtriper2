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
    <body style="background-color: #f2f2f4">
        <div  ng-app="YouTripper" ng-controller="QuickComparisonController">
            <!--<div class="youtripper-spinner" ng-hide="loaded"></div>-->
            <h4>Quick Comparison</h4>
            <div ng-show="loading" class="youtripper-spinner" style="top: 200px"></div>
            <div ng-hide="loading" class="container-fluid"  ng-cloak>
                <div class="row">
                    <div class="col-sm-3">                        
                        <div class="location-box">
                            <a href="" ng-click="selectSameLocation()" class="same-location-option">
                                <span><div ng-class="{'location-checked': checkLocation}"></div></span>
                                Same Location                                                
                            </a>
                        </div>
                        <div ng-repeat="package in comparisonList">
                            <div ng-show="package.id === currentPackageID" class="category-item-block">
                                <div class="item-image" style="background-image: url('{{package.coverImage}}')" >
                                    <a class="package-detail-href" ng-href="<c:url value="/Package/"/>{{package.id}}" target="_self"> </a>
                                    <div class="option-box">
                                        <span class="item-function">
                                        </span>
                                        <div class="package-option">
                                            <ul>
                                                <c:if test="${sessionScope.account.role == 1}">
                                                    <li>
                                                        <a href="" ng-click="saveWishlist(package.id)" class="wishlist-option">Save to your list</a>
                                                    </li>
                                                </c:if>
                                                <li>
                                                    <a href="<c:url value="/Common/Package/QuickView"/>/{{package.id}}"
                                                       ng-click="quickView(package.packageID, $event)" 
                                                       class="quickView-option boxer" data-boxer-height="400" data-boxer-width="800"
                                                       >Quick view</a>
                                                </li>                                                
                                                <li>
                                                    <a href="<c:url value="/Common/getQuickComparison"/>/{{package.id}}" ng-click="" data-boxer-height="500" data-boxer-width="1200" class="comparison-option boxer">
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
                                                <a href='<c:url value="/Package/"/>{{package.id}}' target="_self">{{package.name}}</a>
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
                                            <p class="item-rating-text col-xs-6"><span></span>{{package.numberRates}} Reviews</p>
                                        </div>
                                    </div>
                                    <div class="compare-btn">
                                        <a href="" ng-click="addToComparisonList(package.id, package.name)" class="comparison-option">
                                            <span><div ng-class="{'compare-checked': checkComparisonItem(package.id)}"></div></span>
                                            Compare                                                
                                        </a>
                                    </div>
                                </div>                     
                            </div>
                        </div>
                    </div>                      
                    <div class="col-sm-3" id="toprated">
                        <h5>Top rated</h5>
                        <div class="arrow-up-compare top-rated disabled-prev-comparison" ng-click="prevTopRated()"></div>
                        <div class="close-compare-box top-rated" ng-click="closeTopRated()">Close</div>
                        <div ng-class="{'first current-top-rated':($index === 0),'last-top-rated':($index === topRatedList.length - 1)}" class="hide-comparison-item" elementPosition="{{$index}}" ng-repeat="package in topRatedList | orderBy:'-rate'">
                            <div  class="category-item-block">
                                <div class="item-image" style="background-image: url('{{package.coverImage}}')" >
                                    <a class="package-detail-href" ng-href="<c:url value="/Package/"/>{{package.id}}" target="_self"> </a>
                                    <div class="option-box">
                                        <span class="item-function">
                                        </span>
                                        <div class="package-option">
                                            <ul>
                                                <c:if test="${sessionScope.account.role == 1}">
                                                    <li>
                                                        <a href="" ng-click="saveWishlist(package.id)" class="wishlist-option">Save to your list</a>
                                                    </li>
                                                </c:if>
                                                <li>
                                                    <a href="<c:url value="/Common/Package/QuickView"/>/{{package.id}}"
                                                       ng-click="quickView(package.packageID, $event)" 
                                                       class="quickView-option boxer" data-boxer-height="400" data-boxer-width="800"
                                                       >Quick view</a>
                                                </li>                                                
                                                <li>
                                                    <a href="<c:url value="/Common/getQuickComparison"/>/{{package.id}}" ng-click="" data-boxer-height="500" data-boxer-width="1200" class="comparison-option boxer">
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
                                                <a href='<c:url value="/Package/"/>{{package.id}}' target="_self">{{package.name}}</a>
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
                                            <p class="item-rating-text col-xs-6"><span></span>{{package.numberRates}} Reviews</p>
                                        </div>
                                    </div>
                                    <div class="compare-btn">
                                        <a href="" ng-click="addToComparisonList(package.id, package.name)" class="comparison-option">
                                            <span><div ng-class="{'compare-checked': checkComparisonItem(package.id)}"></div></span>
                                            Compare                                                
                                        </a>
                                    </div>
                                </div>                     
                            </div>
                        </div>
                        <div class="arrow-down-compare top-rated" ng-class="{'disabled-next-comparison':(topRatedList.length === 1) }" ng-click="nextTopRated()"></div>
                    </div>
                    <div class="col-sm-3" id="mostPopular">
                        <h5>Most Popular</h5>
                        <div class="arrow-up-compare most-popular disabled-prev-comparison" ng-click="prevMostPopular()"></div>
                        <div class="close-compare-box most-popular" ng-click="closeMostPopular()">Close</div>
                        <div ng-class="{'first current-most-popular':($index === 0),'last-most-popular':($index === mostPopularList.length - 1)}" class="hide-comparison-item" elementPosition="{{$index}}" ng-repeat="package in mostPopularList | orderBy:'-noOfClicks'">
                            <div class="category-item-block">
                                <div class="item-image" style="background-image: url('{{package.coverImage}}')" >
                                    <a class="package-detail-href" ng-href="<c:url value="/Package/"/>{{package.id}}" target="_self"> </a>
                                    <div class="option-box">
                                        <span class="item-function">
                                        </span>
                                        <div class="package-option">
                                            <ul>
                                                <c:if test="${sessionScope.account.role == 1}">
                                                    <li>
                                                        <a href="" ng-click="saveWishlist(package.id)" class="wishlist-option">Save to your list</a>
                                                    </li>
                                                </c:if>
                                                <li>
                                                    <a href="<c:url value="/Common/Package/QuickView"/>/{{package.id}}"
                                                       ng-click="quickView(package.packageID, $event)" 
                                                       class="quickView-option boxer" data-boxer-height="400" data-boxer-width="800"
                                                       >Quick view</a>
                                                </li>                                                
                                                <li>
                                                    <a href="<c:url value="/Common/getQuickComparison"/>/{{package.id}}" ng-click="" data-boxer-height="500" data-boxer-width="1200" class="comparison-option boxer">
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
                                                <a href='<c:url value="/Package/"/>{{package.id}}' target="_self">{{package.name}}</a>
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
                                            <p class="item-rating-text col-xs-6"><span></span>{{package.numberRates}} Reviews</p>
                                        </div>
                                    </div>
                                    <div class="compare-btn">
                                        <a href="" ng-click="addToComparisonList(package.id, package.name)" class="comparison-option">
                                            <span><div ng-class="{'compare-checked': checkComparisonItem(package.id)}"></div></span>
                                            Compare                                                
                                        </a>
                                    </div>
                                </div>                     
                            </div>
                        </div>
                        <div class="arrow-down-compare most-popular" ng-class="{'disabled-next-comparison':(mostPopularList.length === 1) }" ng-click="nextMostPopular()"></div>
                    </div>
                    <div class="col-sm-3" id="cheapest">
                        <h5>Cheapest</h5>
                        <div class="arrow-up-compare cheapest disabled-prev-comparison" ng-click="prevCheapest()"></div>
                        <div class="close-compare-box cheapest" ng-click="closeCheapest()">Close</div>
                        <div ng-class="{'first current-cheapest':($index === 0),'last-cheapest':($index === cheapestList.length - 1)}" class="hide-comparison-item" elementPosition="{{$index}}" ng-repeat="package in cheapestList | orderBy:'ordinaryPriceForAdult'">
                            <div class="category-item-block">
                                <div class="item-image" style="background-image: url('{{package.coverImage}}')" >
                                    <a class="package-detail-href" ng-href="<c:url value="/Package/"/>{{package.id}}" target="_self"> </a>
                                    <div class="option-box">
                                        <span class="item-function">
                                        </span>
                                        <div class="package-option">
                                            <ul>
                                                <c:if test="${sessionScope.account.role == 1}">
                                                    <li>
                                                        <a href="" ng-click="saveWishlist(package.id)" class="wishlist-option">Save to your list</a>
                                                    </li>
                                                </c:if>
                                                <li>
                                                    <a href="<c:url value="/Common/Package/QuickView"/>/{{package.id}}"
                                                       ng-click="quickView(package.packageID, $event)" 
                                                       class="quickView-option boxer" data-boxer-height="400" data-boxer-width="800"
                                                       >Quick view</a>
                                                </li>                                                
                                                <li>
                                                    <a href="<c:url value="/Common/getQuickComparison"/>/{{package.id}}" ng-click="" data-boxer-height="500" data-boxer-width="1200" class="comparison-option boxer">
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
                                                <a href='<c:url value="/Package/"/>{{package.id}}' target="_self">{{package.name}}</a>
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
                                            <p class="item-rating-text col-xs-6"><span></span>{{package.numberRates}} Reviews</p>
                                        </div>
                                    </div>
                                    <div class="compare-btn">
                                        <a href="" ng-click="addToComparisonList(package.id, package.name)" class="comparison-option">
                                            <span><div ng-class="{'compare-checked': checkComparisonItem(package.id)}"></div></span>
                                            Compare                                                
                                        </a>
                                    </div>
                                </div>                     
                            </div>
                        </div>
                        <div class="arrow-down-compare cheapest" ng-class="{'disabled-next-comparison':(cheapestList.length === 1) }" ng-click="nextCheapest()"></div>
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
                            var comparisonList = ${requestScope.packageDTO};
                            var packageID = ${requestScope.packageID};
        </script>
    </body>
</html>
