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
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css?999999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css?999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style-login.css"/>" >

        <%@ include file="angular.jsp" %>

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <title>YouTripper - Activities</title>
        <script src="<c:url value="/Resources/Theme/js/page_init.js"/>" ></script>        
        <script language="javascript">
//            <!--
//        var scr_domain = './home.html';
//            //  -->
        </script>
    </head>
    <body ng-app="YouTripper" ng-controller="AllActivitiesController">
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
        <div style="position: fixed; top: 0; bottom: 0; left: 0; right: 0; background: #fff; z-index: 99999" ng-show="loading">
            <div class="youtripper-spinner" ></div>
        </div>
        <div class="pagesearch" ng-hide="loading">
            <%@ include file="header.jsp" %>
            <div class="home-wrapper section-content padding-header">
                <div class="row">
                    <h2 class="wow fadeIn head-section" data-wow-duration="1s" style="margin: 40px 0 20px">All Activities</h2>
                    <div class="select-input-custom input-aside-right">
                        <select name="ddlocation" class="form-control" style="font-size:14px" ng-model="selectedLocation">
                            <option value="all">All Locations</option>
                            <option value="thailand">Thailand</option>
                            <option value="vietnam">Vietnam</option>
                        </select>
                    </div>
                </div>
                <div class="row" ng-show="pageLoading" style="height: 300px;">
                    <div class="youtripper-spinner"></div>
                </div>
                <div class="row" ng-hide="pageLoading">
                    <ul>
                        <li class="activity-item-block" ng-repeat="activity in activities">
                            <div class="item-image">
                                <img class="img-responsive" src="<c:url value="/Resources/Theme/image/act1.jpg"/>" />
                                <a class="item-name" ng-href="<c:url value="/Common/Packages"/>/{{selectedLocation}}/{{activity.activityID}}/">
                                    {{activity.name}}
                                </a>
                            </div>
                        </li>
                    </ul>
                </div>
                <span ng-hide="pageLoading" class="view-other">{{(currentPage - 1) * pageSize + 1}} - {{(currentPage - 1) * pageSize + activities.length}} of {{total}} Activities</span>
                <div class="row paginition-row" ng-hide="pageLoading">
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
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/wow.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js?99"/>"></script>
        <script>
                                    var activitiesScope = ${requestScope.activities};
                                    var pageSize = ${requestScope.pageSize};
            <c:choose>
                <c:when test="${requestScope.selectedLocation != null}">
                                    var loc = "${requestScope.selectedLocation}";
                </c:when>
                <c:otherwise>
                                    var loc = "all";
                </c:otherwise>
            </c:choose>
                                    var activitiesByPageNumberUrl = "<c:url value="/Common/AllActivities/PageNumber"/>";
                                    $(document).ready(function () {
                                        new toggleHeader.init({
                                            toggleControl: false,
                                            toggleTheme: true
                                        });
                                    });
        </script>
    </body>
</html>
