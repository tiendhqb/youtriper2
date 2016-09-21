<%-- 
    Document   : createdPackageManagement
    Created on : Oct 20, 2015, 4:49:10 PM
    Author     : Nick
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
        <script src="https://www.google.com/recaptcha/api.js?onload=vcRecaptchaApiLoaded&render=explicit" async defer></script>
        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">

        <%@ include file="../angular.jsp" %>

        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css?999999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css?999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <title>Youtripper - Provider Packages</title>
    </head>
    <body>
        <div class="pagesearch" ng-app="YouTripper" ng-controller="ManagePackageController">
            <%@ include file="../header.jsp" %>
            <%@ include file="adminMenubar.jsp" %>
            <div id="spinner-block" ng-hide="loaded">
                <div class="youtripper-spinner"></div>
            </div>
              <div class="site-container">
                  <div class="col-sm-9 col-md-10 affix-content">
                        <div class="container"  ng-cloak ng-show="loaded">
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="step3">
                        <div class="tab-bucket tab-bucket-fix">
                            <h2>Your Package ({{packages.length}})</h2>
                            <div class="row">
                                <div class="col-sm-4 col-sm-6 col-xs-12 package-block" ng-repeat="package in packages">
                                    <div class="category-item-block">
                                        <div class="item-image" style="background-image: url('{{package.coverImage}}')" balance-square>
                                            <a class="package-detail-href" ng-href="<c:url value="/Admin/CreatedPackage/"/>{{package.packageID}}" target="_self"> </a>
                                            <div class="option-box">
                                                <span class="item-function">
                                                </span>
                                            </div>
                                            <span class="item-price common-btn">{{package.ordinaryPriceForAdult| currency}}</span>
                                            <!--<img class="img-responsive" src="{{package.coverImage}}" />-->
                                        </div>
                                        <div class="item-detail">
                                            <div class=" row">
                                                <div class="col-xs-12 pkg-name">
                                                    <article>
                                                        <a href='<c:url value="/Admin/CreatedPackage"/>/{{package.id}}' target="_self">{{package.name}}</a>
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
                                                        <li ng-repeat="i in [0, 1, 2, 3, 4]" ng-class="{'active' : (i
                                                                                    < packag
                                                                                    e.rate), 'unactive' : (i >= package.rate)}">
                                                        </li>
                                                    </ul>
                                                    <p class="item-rating-text col-xs-6"><span></span>{{package.noOfReviews}} Reviews</p>
                                                </div>
                                            </div>
                                            <div class="compare-btn">
                                                <a href="" ng-click="" class="comparison-option">
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
          
        </div>
        <%--<%@ include file="../footer.jsp" %>--%>
        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js?999"/>"></script>
        <script>
                                                        var packages = ${requestScope.createdPackages};
                                                        var page = '${requestScope.page}';
                                                        $(document).ready(function () {
                                                            toggleHeader.init({
                                                                toggleControl: false
                                                            });
                                                        });
        </script>
    </body>
</html>
