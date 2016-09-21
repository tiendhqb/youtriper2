<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
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
        <link href="<c:url value="/Resources/Theme/css/jquery.mThumbnailScroller.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/lightgallery.css"/>" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style-login.css"/>" >
        <link rel="stylesheet"  href="<c:url value="/Resources/Theme/css/lightslider.css"/>" />

        <%@ include file="angular.jsp" %>

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.diyslider.js"/>"></script>
        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >
        <title>Youtripper - Categories</title>
    </head>
    <body class="pagesearch" ng-app="YouTripper" ng-controller="AllCategoryController">
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
        <%@ include file="header.jsp" %>
        <!--CONTENT-->
        <!--Selector-->
        <div id="spinner-block" ng-show="loading">
            <div class="youtripper-spinner"></div>
        </div>
        <div class="padding-header" ng-hide="loading" ng-cloak>

            <div class="container" id="categoryContainer" >    
                <div class="categoryFilterRow">
                    <div class="categoryFilter">
                        <select name="categorySelect" class="roundBlueSelectInput" ng-model="selectedCateID" convert-to-number>
                            <option value="0">All Categories</option>
                            <option  ng-repeat="x in allCate" value="x.id">{{x.name}}</option>

                        </select>
                        <!--                        <a href="" class="orangeLeft" ng-click="movePreviousCate()"></a>-->
                        <!--                        <ul>
                                                    <li ng-show="selectedCateID === -1">
                                                        All categories
                                                    </li>
                                                    <li ng-repeat="x in allCate" ng-show="allCate[selectedCateID].id === x.id">
                                                        {{x.name}}
                                                    </li>
                                                </ul>-->
                        <!--                        <a href="" class="orangeRight" ng-click="moveNextCate()"></a>-->
                    </div>
                    <div class="select-location-for-category">
                        <select name="ddlocation" class="roundBlueSelectInput normalFont"  ng-model="selectedLocation">
                            <option value="All">All Locations</option>
                            <option value="Bangkok">Bangkok</option>
                            <option value="Pattaya">Pattaya</option>
                            <option value="Phuket">Phuket</option>
                        </select>
                    </div>
                </div>
                <div class="SubCategoriesContainer">
                    <div class="center-inform" ng-show="subCategoryLoading">
                        <div class="small-spinner" ></div>
                    </div>
                    <div class="row">
                        <div class="col-xs-4" ng-repeat="y in selectedSubCategories" ng-hide="subCategoryLoading">
                            <div style="margin-bottom: 30px">
                                <a class="href-orange SubcateText" style="position: absolute" href="" ng-click="viewPackage(y.name)">{{y.name}}</a>
                                <img style="width: 100%" src="<c:url value="/Resources/Theme/image/Canoeing.jpg"/>">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- FOOTER -->
            <style>
                .lSSlideWrapper {
                    height: 300px;
                }
            </style>
            <%@ include file="footer.jsp" %>
        </div>

        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js?999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/lightslider.js"/>"></script>
        <script>
                                            var categories = ${requestScope.allCate};
                                            var subCategories = ${requestScope.allSubCate};
                                            var selectedLocation = '${requestScope.selectedLocation}';
            <c:choose>
                <c:when test='${requestScope.selectedCate == "All"}'>
                                            var selectedCate = 0;
                </c:when>
                <c:otherwise>
                                            var selectedCate = ${requestScope.selectedCate};
                </c:otherwise>
            </c:choose>

                                            $(document).ready(function () {
                                                toggleHeader.init({
                                                    toggleControl: false
                                                });
                                            });


        </script>
    </body>
</html>