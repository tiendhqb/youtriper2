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
        <div ng-app="YouTripper" ng-controller="ManagePackageController">
            <%@ include file="../header.jsp" %>
            <%@ include file="adminMenubar.jsp" %>
            <div id="spinner-block" ng-hide="loaded">
                <div class="youtripper-spinner"></div>
            </div>
            <div class="site-container">
                <div class="col-sm-9 col-md-10 affix-content">
                    <div class=""  ng-cloak ng-show="loaded">
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane active" id="step3">
                                <div class="tab-bucket tab-bucket-fix">
                                    <h2>Your Package ({{packages.length}})</h2>
                                    <div class="row">
                                        <div class="col-sm-4 col-sm-6 col-xs-12 package-block" ng-repeat="package in packages">
                                            <div class="category-item-block">
                                                <div class="item-image" style="background-image: url('{{package.coverImage}}')">
                                                    <span class="item-function">
                                                    </span>
                                                    <span class="item-price">{{package.ordinaryPriceForAdult| currency}}</span>
                                                    <!--<img class="img-responsive" src="{{package.coverImage}}" />-->
                                                </div>
                                                <div class="item-detail row">
                                                    <div class="col-xs-12">
                                                        <article>
                                                            <a href='<c:url value="/Admin/CreatedPackage/"/>{{package.id}}'>{{package.name}}</a>
                                                        </article>
                                                    </div>
                                                    <div class="col-xs-12 col-md-7" style="margin-top:5px">
                                                        <div class="item-brand">
                                                            <img src="<c:url value="/Images/Icon/User-Default.jpg"/>" />
                                                        </div>
                                                        <div class='item-provider-name'>
                                                            {{package.providerName}}
                                                        </div>
                                                    </div>
                                                    <div class="item-rating red-rating col-xs-12 col-md-5">
                                                        <ul>
                                                            <li ng-repeat="i in [0, 1, 2, 3, 4]" ng-class="{'active' : (i < package.rate), 'unactive' : (i >= package.rate)}">
                                                            </li>
                                                        </ul>
                                                        <span class="item-rating-text">{{package.numberOfRates}} Reviews</span>
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
                                                    var packages = ${requestScope.editingPackages};
                                                    var page = 'editingPackages';
                                                    $(document).ready(function () {
                                                        toggleHeader.init({
                                                            toggleControl: false
                                                        });
                                                    });
        </script>
    </body>
</html>
