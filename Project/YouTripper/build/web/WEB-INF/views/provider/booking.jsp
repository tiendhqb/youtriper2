<%-- 
    Document   : Booking
    Created on : Nov 2, 2015, 12:26:49 PM
    Author     : DINH KHANG
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
        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">

        <%@ include file="../angular.jsp" %>

        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css?999999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css?999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripperResponsive.css"/>" >

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >
        <title>Youtripper - Provider Bookings</title>
    </head>
    <body ng-app="YouTripper" ng-controller="BookingController" id="BookingCtr" >
        <div class="pagesearch">
            <%@ include file="../header.jsp" %>
            <%@ include file="providerMenubar.jsp" %>
            <div id="spinner-block" ng-hide="loaded">
                <div class="youtripper-spinner"></div>
            </div>
            <div class="container"  ng-cloak ng-show="loaded">
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="step6">
                        <div class="tab-booking">
                            <div class="accodion">
                                <div ng-repeat="package in packageList" ng-attr-id="{{'package' + package.id}}" >
                                    <div class="accodion-caption" ng-click="viewDetail(package.id)">
                                        <h2>
                                            {{package.name}}
                                        </h2>
                                    </div>
                                    <div class="accodion-content">
                                        <div class="tabble">
                                            <div class="tabble-caption">
                                                <div class="caption-right">
                                                    <span>Calendar</span>
                                                    <a ng-click="ExportBooking(package.id)" href="#">Export</a>
                                                </div>
                                                <div class="clear"></div>
                                            </div>
                                            <div class="table-responsive">
                                                <table class="table">
                                                    <thead>
                                                        <tr>
                                                            <th>Trip Start</th>
                                                            <th>Number of Bookings</th>
                                                            <th>Number of Trippers</th>
                                                            <th>Max quota  / Day</th>
                                                            <th>Pending</th>
                                                            <th>Completed</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr ng-show="!loadingBooking" ng-repeat="(date, detail) in detailList | pagingFilter : currentPage : pageSize" >
                                                            <!--<tr ng-repeat="i in [0,1,2,3,4,5] | limitTo : 2">-->
                                                            <!--<td colspan="6">{{date}}</td>-->
                                                            <td>{{date}}</td>
                                                            <td>{{detail.numberOfBooking}}</td>
                                                            <td>{{detail.numberOfTripper}}</td>
                                                            <td>{{detail.maxQuota}}</td>
                                                            <td>{{detail.pending}}</td>
                                                            <td>{{detail.completed}}</td>
                                                        </tr>
                                                        <tr  ng-hide="total > 0">
                                                            <td colspan="6" ng-show="!loadingBooking">No results found</td>
                                                            <td colspan="6" ng-show="loadingBooking">Loading ...</td>
                                                        </tr>
                                                    </tbody>
                                                </table>

                                                <div class="pagging bookingsPaging">
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
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@ include file="../footer.jsp" %>
        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js?999"/>"></script>
        <script>
                                                                    var packages = ${requestScope.listPackage};
            <c:choose>
                <c:when test="${empty param.language}">
                    var bookingUrl = '<c:url value="/Provider/Booking"/>';
                </c:when>
                <c:otherwise>
                    var bookingUrl = '<c:url value="/Provider/Booking?language=${param.language}"/>';
                </c:otherwise>
            </c:choose>

            <c:choose>
                <c:when test="${empty param.language}">
                    var ExportPackageStatictis = '<c:url value="/Provider/ExportPackage"/>';
                </c:when>
                <c:otherwise>
                    var ExportPackageStatictis = '<c:url value="/Provider/ExportPackage?language=${param.language}"/>';
                </c:otherwise>
            </c:choose>
                                                                    
                                                                    var page = '${requestScope.page}';
                                                                    $(document).ready(function () {
                                                                        toggleHeader.init({
                                                                            toggleControl: false
                                                                        });
                                                                        if (packages.length > 0) {
                                                                            angular.element(document.getElementById('BookingCtr')).scope().viewDetail(packages[0].id);
                                                                        }
//                                                                $(".accodion-caption").first().addClass("accodion-caption-active");
//                                                                $(".accodion-content").first().addClass("accodion-content-active");
                                                                    });
        </script>
    </body>
</html>
