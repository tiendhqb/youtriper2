<%-- 
    Document   : accountInfo
    Created on : Nov 2, 2015, 10:19:54 AM
    Author     : DINH KHANG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html ng-app="YouTripper" ng-controller="ComparisonController">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=1366">
<!--        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1">-->
        <!--<script src='https://www.google.com/recaptcha/api.js'></script>-->

        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">

        <%@ include file="angular.jsp" %>

        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css?999999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css?999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style-login.css"/>" >

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/sockjs-0.3.4.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/stomp.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/ng-file-upload-shim.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/ng-file-upload.min.js"/>"></script>

        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >
        <title>Comparison List</title>
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
        <div class="pagesearch">
            <%@ include file="header.jsp" %>           
            <div class="container section-content padding-header">
                <h1>Comparison</h1>
                
                <table ng-show="checkComparisonList()" class="table">
                    <tbody>
                        <tr>
                            <th>Picture</th>
                            <td ng-repeat="x in ComparisonList">{{x.coverImage}}</td>

                        </tr>
                        <tr>
                            <th>Name</th>
                            <td ng-repeat="x in ComparisonList">{{x.name}}</td>
                        </tr>
                        <tr>
                            <th>Rating</th>
                            <td ng-repeat="x in ComparisonList">{{x.rate}}</td>
                        </tr>
                        <tr>
                            <th>Location</th>
                            <td ng-repeat="x in ComparisonList">{{x.location}}</td>
                        </tr>
                        <tr>
                            <th>Category</th>
                            <td ng-repeat="x in ComparisonList">
                                <span ng-repeat="i in x.categories">{{i.name}}</span>
                                
                            </td>
                        </tr>
                        <tr>
                            <th>Included</th>
                            <td ng-repeat="x in ComparisonList">{{x.included}}</td>
                        </tr>
                        <tr>
                            <th>Excluded</th>
                            <td ng-repeat="x in ComparisonList">{{x.excluded}}</td>
                        </tr>
                        <tr>
                            <th>Group Size</th>
                            <td ng-repeat="x in ComparisonList">{{x.minTripper}}-{{x.maxTripper}}</td>
                        </tr>
                        <tr>
                            <th>Duration</th>
                            <td ng-repeat="x in ComparisonList"></td>
                        </tr>
                        <tr>
                            <th>Suitable for</th>
                            <td ng-repeat="x in ComparisonList"></td>
                        </tr>
                        <tr>
                            <th>Best provider</th>
                            <td ng-repeat="x in ComparisonList"></td>
                        </tr>
                        <tr>
                            <th></th>
                            <td ng-repeat="x in ComparisonList"><a class="href-orange" ng-href="<c:url value="/Common/removeFromComparison/"/>{{x.id}}">Remove</a></td>
                        </tr>
                    </tbody>
                </table>
                <div style="text-align: center" ng-hide="checkComparisonList()">No Package in Comparison List!</div>
            </div>
            <%@ include file="footer.jsp" %>
            <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/main.js?999"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/jquery.tabslet.js"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/jquery.matchHeight.js"/>"></script>

            <script>
                            var comparisonList = null;
                <c:if test="${requestScope.ComparisonList != null}">
                            comparisonList = ${requestScope.ComparisonList};
                </c:if>

                            $(document).ready(function () {
                                toggleHeader.init({
                                    toggleControl: false
                                });

                            });
            </script>
    </body>
</html>
