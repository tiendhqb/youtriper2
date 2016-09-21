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
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripperResponsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style-login.css"/>" >

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.fs.boxer.js"/>"></script>


        <script src="<c:url value="/Resources/Theme/js/page_init.js"/>" ></script>        
        <title>YouTripper - Search Page</title>
        <!--        You can use Open Graph tags to customize link previews.
         Learn more: https://developers.facebook.com/docs/sharing/webmasters 
               <meta property="og:url"           content="http://www.your-domain.com/your-page.html" />
               <meta property="og:type"          content="website" />
               <meta property="og:title"         content="Your Website Title" />
               <meta property="og:description"   content="Your description" />
               <meta property="og:image"         content="http://www.your-domain.com/path/image.jpg" />-->
    </head>
    <body ng-app="YouTripper" ng-controller="SubCategoryController">
        <!-- Google Tag Manager -->
<noscript><iframe src="//www.googletagmanager.com/ns.html?id=GTM-MZRL8C"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'//www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-MZRL8C');</script>
<!-- End Google Tag Manager -->
        <div style="position: fixed; top: 0; bottom: 0; left: 0; right: 0; background: #fff; z-index: 99999" ng-show="loading">
            <div class="youtripper-spinner" ></div>
        </div>
        <div  class="pagesearch" id="searchPage" ng-controller="FixedComparisonController">
            <%@ include file="header.jsp" %>
            <!--CONTENT-->
            <div class="container section-content padding-header" ng-cloak ng-hide="loading">
                <!--Selector-->
                <div class="page-search">
                    <div class="row" ng-show="advancedSearch.packages.length > 0">
                        <div class="col-lg-4 col-md-4 col-sm-12" id="recommend">
                            <div class="search-left">
                                <div class="search-step1 row">
                                    <ul class="search-nav">
                                        <li class="col-sm-4 col-md-12">
                                            <h3><span></span>Popular Keywords</h3>
                                            <ul>
                                                <li ng-repeat="subKeyword in advancedSearch.keywords track by $index">
                                                    <a ng-href="<c:url value="/Common/Search?search="/>{{subKeyword}}"/> {{subKeyword}} </a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li class="col-sm-4 col-md-12">
                                            <h3><span></span>Popular Packages</h3>
                                            <ul>
                                                <li ng-repeat="popularPackage in advancedSearch.popularPackages">
                                                    <a ng-href="<c:url value="/Package/"/>{{popularPackage.packageID}}"/>{{popularPackage.name}} </a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li class="col-sm-4 col-md-12">
                                            <h3><span></span>Locations</h3>
                                            <ul>
                                                <li ng-repeat="location in advancedSearch.locations">
                                                    <a ng-href="<c:url value="/Common/Search?search="/>{{location.City}} "/> {{location.City}}  </a>
                                                    <a ng-href="<c:url value="/Common/Search?search="/>{{location.Country}}"/> {{location.Country}} </a>
                                                    <!--<a ng-href="<c:url value="/Common/Search?search="/>{{location.State}}"/> {{location.State}} </a>-->
                                                </li>
                                            </ul>
                                        </li>
                                    </ul>
                                    <div class="center">
                                        <span class="more-fillter">
                                            More Filter 
                                        </span>
                                    </div>
                                </div>
                                <div class="fillter fillter-hide">
                                    <div class="fillter-content">
                                        <h3>Trip Type</h3>
                                        <div class="group row">
                                            <div class="col-checkbox col-sm-4" ng-repeat="tripType in filterOptions.tripTypes">
                                                <div class="tempCheckbox">
                                                    <input type="checkbox" checklist-model="tripTypeIDs"
                                                           checklist-value="tripType.tripTypeID"/>
                                                    <span></span>
                                                </div>
                                                <p>{{tripType.name}}</p>
                                            </div>
                                        </div>
                                        <h3>Group Type</h3> 
                                        <div class="group row">
                                            <div class="col-checkbox col-sm-4" ng-repeat="groupType in filterOptions.groupTypes">
                                                <div class="tempCheckbox">
                                                    <input type="checkbox" checklist-model="groupTypeIDs"
                                                           checklist-value="groupType.groupTypeID"/>
                                                    <span></span>
                                                </div>
                                                <p>{{groupType.name}}</p>
                                            </div>
                                        </div>
                                        <h3>Amenities</h3>
                                        <div class="group row">
                                            <div class="col-checkbox col-sm-4" ng-repeat="amenities in filterOptions.listAmenities">
                                                <div class="tempCheckbox">
                                                    <input type="checkbox" checklist-model="amenitiesIDs" 
                                                           checklist-value="amenities.amenitiesID"/>
                                                    <span></span>
                                                </div>
                                                <p>{{amenities.amenitiesType}}</p>
                                            </div>
                                        </div>
                                        <div class="row" style="margin-left: -15px; margin-right: -15px;">
                                            <div class="col-md-12 col-sm-6 filter-kind">
                                                <h3>Price Range</h3>
                                                <div class="group row price-row">
                                                    <div id="priceRange" ></div>
                                                </div>
                                            </div>
                                            <div class="col-md-12 col-sm-6 filter-kind">
                                                <h3>Rate</h3>
                                                <div class="group row">
                                                    <div id="rateFilter" class="col-md-12"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="fillter-bottom">
                                        <a href="" id="filter-cancel">
                                            Cancel
                                        </a>
                                        <a href="" class="apply" ng-click="filterPackage()">
                                            Apply
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-8 col-md-8 col-sm-12" id="foundPackages">
                            <div style="min-height: 300px" ng-show="filterLoading">
                                <div class="youtripper-spinner"  ></div>
                            </div>
                            <div class="search-right">
                                <div class="row" ng-controller="OptionsController">
                                    <div class="package-box col-lg-6 col-sm-6 col-xs-12" ng-repeat="package in advancedSearch.packages" ng-hide="filterLoading">
                                        <div class="category-item-block">
                                            <div class="item-image" style="background-image: url('{{package.coverImage}}')" >
                                                <a class="package-detail-href" ng-href="<c:url value="/Package/"/>{{package.packageID}}"> </a>
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
                                                            <li>
                                                                <a href="" ng-click="addToComparisonList(package.packageID, package.packageName)" class="comparison-option">
                                                                    Add To Compare
                                                                </a>
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
                                                <div class="col-xs-7 col-md-7 col-sm-7" style="margin-top:5px">
                                                    <div class="item-brand" style="background: url(/{{package.providerImage}}) no-repeat center; background-size: cover">
                                                        <!--<img src="/{{package.providerImage}}" />-->
                                                    </div>
                                                    <div class='item-provider-name'>
                                                        {{package.lastName}}
                                                    </div>
                                                </div>
                                                <div class="item-rating red-rating col-xs-5 col-md-5 col-sm-5">
                                                    <ul>
                                                        <li ng-repeat="i in [0, 1, 2, 3, 4]" ng-class="{'active' : (i < package.rate), 'unactive' : (i >= package.rate)}">
                                                        </li>
                                                    </ul>
                                                    <span class="item-rating-text">{{package.numberRates}} Reviews</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <p ng-hide="total > 0" class="notify-paragraph" ng-cloak ng-hide="loading || loadingFilter">No results found</p>
                                </div>
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
                    </div>
                    <div class="filters-btn fixed" ng-show="advancedSearch.packages.length > 0">
                        <a href="" class="btn-primary btn-orange" ng-click="openFilters()">Filters</a>
                    </div>

                    <div class="row" ng-show="sizeOfHashMap(advancedSearch.suggestion) > 0" ng-controller="OptionsController">
                        <p class="col-xs-12">Did you mean?</p>
                        <div class="package-box col-lg-4 col-sm-6 col-md-4 col-xs-12" ng-repeat="(suggestionKeyword, package) in advancedSearch.suggestion" ng-hide="filterLoading">
                            <p>Keyword: <a href="" class="href-orange">{{suggestionKeyword}}</a></p>
                            <div class="category-item-block">
                                <div class="item-image" style="background-image: url('{{package.coverImage}}')" >
                                    <a class="package-detail-href" ng-href="<c:url value="/Package/"/>{{package.packageID}}"> </a>
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
                                                <li>
                                                    <a href="" ng-click="addToComparisonList(package.packageID, package.packageName)" class="comparison-option">
                                                        Add To Compare
                                                    </a>
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
                                    <div class="col-xs-7 col-md-7 col-sm-7" style="margin-top:5px">
                                        <div class="item-brand" style="background: url(/{{package.providerImage}}) no-repeat center; background-size: cover">
                                            <!--<img src="/{{package.providerImage}}" />-->
                                        </div>
                                        <div class='item-provider-name'>
                                            {{package.lastName}}
                                        </div>
                                    </div>
                                    <div class="item-rating red-rating col-xs-5 col-md-5 col-sm-5">
                                        <ul>
                                            <li ng-repeat="i in [0, 1, 2, 3, 4]" ng-class="{'active' : (i < package.rate), 'unactive' : (i >= package.rate)}">
                                            </li>
                                        </ul>
                                        <span class="item-rating-text">{{package.numberRates}} Reviews</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%@ include file="comparisonList.jsp" %>
        </div>
        <%@ include file="footer.jsp" %>
        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/notify.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.raty.js"/>"></script>
        <%@ include file="angular.jsp" %>
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js?999"/>"></script>
        <script>
                                                    var search = '${param.search}';
                                                    var advancedSearch = ${requestScope.advancedSearch};
                                                    var pageSize = ${requestScope.pageSize};
                                                    var searchByPageNumberUrl = '<c:url value="/Common/Search/PageNumber"/>';
                                                    var searchWithFilterUrl = '<c:url value="/Common/Search/Filter"/>';
                                                    var getFilterUrl = '<c:url value="/Common/Search/GettingFilter"/>';
                                                    var addComparisonUrl = '<c:url value="/Common/AddToComparisonList"/>';
                                                    $('.more-fillter').click(function () {
                                                        if (!$('.fillter-hide').is(":visible")) {
                                                            $('.more-fillter').hide();
                                                            $('.search-step1').hide();
                                                            $('.fillter-hide').show();
                                                        }
                                                    });
                                                    $(document).ready(function () {
                                                        SpinnerText.init('ul[data-spinner]');
                                                        new toggleHeader.init({
                                                            toggleControl: false
                                                        });
                                                        $('#filter-cancel').click(function () {
                                                            if ($(".page-search").hasClass("filters-open")) {
                                                                $(".page-search").removeClass("filters-open");
                                                            }
                                                            if ($('.fillter-hide').is(":visible")) {
                                                                $('.more-fillter').show();
                                                                $('.search-step1').show();
                                                                $('.fillter-hide').hide();
                                                            }
                                                        });
                                                    });
        </script>

    </body>
</html>
