<%-- 
    Document   : home
    Created on : Oct 21, 2015, 10:15:53 AM
    Author     : Nick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
    <head>
        <meta name="description" content="">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=1366">
<!--        <meta name="viewport" content="width=device-width, initial-scale=1">-->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >

        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/jquery.fs.boxer.css"/>" rel="stylesheet">

        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css?999999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css?999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style-login.css"/>" >

        <%@ include file="angular.jsp" %>

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.fs.boxer.js"/>"></script>

        <title>YouTripper</title>
        <script src="<c:url value="/Resources/Theme/js/page_init.js"/>" ></script>        
        <script language="javascript">
//            <!--
//        var scr_domain = './home.html';
//            //  -->
        </script>
    </head>
    <body>
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
        <div ng-app="YouTripper" ng-controller="AdvancedPackagesController" class="pagesearch">
            <%@ include file="header.jsp" %>
            <div class="home-wrapper section-content padding-header">
                <div class="row">
                    <h2 class="wow fadeIn head-section" data-wow-duration="1s" style="margin: 40px 0 20px">All Packages</h2>
                    <div class="select-input-custom input-aside-right">
                        <select name="ddlocation" class="form-control" style="font-size:14px" ng-model="selectedLocation">
                            <option value="all">All Locations</option>
                            <option value="thailand">Thailand</option>
                            <option value="vietnam">Vietnam</option>
                        </select>
                    </div>
                </div>
                <div class="row" ng-show="loading">
                    <div class="youtripper-spinner"></div>
                </div>
                <div class="row" ng-hide="loading" ng-cloak>
                    <ul>
                        <li class="col-md-4 col-sm-4 col-xs-12 col-lg-4" ng-repeat="package in result.packages">
                            <div class="category-item-block ">
                                <div class="item-image" style="background-image: url('{{package.coverImage}}')">
                                    <a class="package-detail-href" ng-href="<c:url value="/Package/"/>{{package.packageID}}"> </a>
                                    <div class="option-box" ng-controller="OptionsController">
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
                                                <li>
                                                    <a href="" ng-click="addToComparisonList(package.packageID, package.packageName)" class="comparison-option">Comparison</a>
                                                </li>
                                                <li>
                                                    <a href="<c:url value="/Common/ProviderPage"/>/{{package.providerID}}" class="other-option">Other trips</a>
                                                </li>
                                                <li>
                                                    <a href="" ng-click="" class="share-option">Share this trip</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    <span class="item-price">{{package.ordinaryPrice| currency}}</span>
                                    <!--<img class="img-responsive" src="{{package.coverImage}}" />-->
                                </div>
                                <div class="item-detail row">
                                    <div class="col-xs-12">
                                        <article>
                                            <a href='<c:url value="/Package/"/>{{package.packageID}}'>{{package.packageName}}</a>
                                        </article>
                                    </div>
                                    <div class="col-xs-12 col-md-7" style="margin-top:5px">
                                        <div class="item-brand">
                                            <img src="<c:url value="/Images/Icon/User-Default.jpg"/>" />
                                        </div>
                                        <div class='item-provider-name'>
                                            {{package.lastName}}
                                        </div>
                                    </div>
                                    <div class="item-rating red-rating col-xs-12 col-md-5">
                                        <ul>
                                            <li ng-repeat="i in [0, 1, 2, 3, 4]" ng-class="{'active' : (i < package.rate), 'unactive' : (i >= package.rate)}">
                                            </li>
                                        </ul>
                                        <span class="item-rating-text">{{package.numberRates}} Reviews</span>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
                <span class="view-other">{{(currentPage - 1) * pageSize + 1}} - {{(currentPage - 1) * pageSize + result.packages.length}} of {{total}} Activities</span>
                <div class="row paginition-row">
                    <paging
                        class="small"
                        page="currentPage" 
                        page-size="pageSize" 
                        total="total"
                        adjacent="{{adjacent}}"
                        hide-if-empty="{{hideIfEmpty}}"
                        ul-class="{{ulClass}}"
                        active-class="{{activeClass}}"
                        disabled-class="{{disabledClass}}"
                        show-prev-next="{{showPrevNext}}"
                        paging-action="DoCtrlPagingAct('Paging Clicked', page, pageSize, total)">
                    </paging>   
                </div>
            </div>
        </div>
        <%@ include file="footer.jsp" %>
        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/notify.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/wow.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js?99"/>"></script>
        <script>
                            var resultJson = ${requestScope.result};
                            var pageSize = ${requestScope.pageSize};
                            var locationScope = "${requestScope.location}";
                            var advancedUrl = "<c:url value="/Common/Packages/CoAndAct/PageNumber"/>";
                            var addComparisonUrl = '<c:url value="/Common/AddToComparisonList"/>';
                            $(document).ready(function () {
                                new toggleHeader.init({
                                    toggleControl: false,
                                    toggleTheme: true
                                });
                            });
        </script>
    </body>
</html>
