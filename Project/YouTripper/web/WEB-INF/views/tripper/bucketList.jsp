<%-- 
    Document   : bucketList
    Created on : Nov 4, 2015, 3:39:04 PM
    Author     : DINH KHANG
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
        <title>Youtripper - Bucket List</title>
    </head>
    <body>

        <div ng-app="YouTripper" ng-controller="BucketList"  class="pagesearch">
            <%@ include file="../header.jsp" %>
            <%@ include file="tripperMenubar.jsp" %>
            <div id="spinner-block" ng-hide="loaded">
                <div class="youtripper-spinner"></div>
            </div>
             <div class="site-container">
                <div class="affix-content">
                <div class="tab-content" ng-cloak ng-show="loaded">
                    <div role="tabpanel" class="tab-pane active" id="step3">
                        <div class="tab-bucket">
                            <h2>Your Bucket List ({{bucketList.length}})</h2>
                            <div class="row">
                                <div class="col-md-6 col-lg-4 col-xs-12 package-box" ng-repeat="package in bucketList" init-boxer>
                                    <div class="provider-edit-tool">
                                        <a href="<c:url value="/Tripper/RemoveFromWishList"/>/{{package.packageID}}" target="_self">
                                            <span></span>
                                            Delete
                                        </a>
                                    </div>
                                    <div class="category-item-block">
                                        <div class="item-image" style="background-image: url('{{package.coverImage}}')" balance-square>
                                            <a class="package-detail-href" ng-href="<c:url value="/Package/"/>{{package.packageID}}" target="_self"> </a>
                                            <div class="option-box">
                                                <span class="item-function">
                                                </span>
                                                <div class="package-option">
                                                    <ul>
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
                                                            <a href="" ng-click="quickComparison(package.packageID)" class="comparison-option">
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
                                                    var bucketList = ${requestScope.BucketList};
                                                    var page = '${requestScope.page}';
                                                    $(document).ready(function () {
                                                        toggleHeader.init({
                                                            toggleControl: false
                                                        });
                                                    });
        </script>
    </body>
</html>
