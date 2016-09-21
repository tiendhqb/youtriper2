<%-- 
    Document   : managementSales
    Created on : May 24, 2016, 4:02:26 PM
    Author     : QuangTran
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

        <%@ include file="../angular.jsp" %>
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css?999999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css?999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style-login.css"/>" >

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>

        <title>YouTripper - Salesman Management</title>
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
            <div ng-app="YouTripper" ng-controller="ManageSalesmanController">
                <%@ include file="../header.jsp" %>
                <%@ include file="adminMenubar.jsp" %>
                <div id="spinner-block" ng-hide="loaded">
                    <div class="youtripper-spinner"></div>
                </div>
                <div class="padding-header">
                    <!--Selector-->
                    <div class="site-container">
                        <div class="affix-content">
                            <div  ng-cloak ng-show="loaded">
                                <ul class="nav nav-tabs salesman">
                                    <li ng-class="{'active':(salesman.salesmanId === currentId)}" ng-repeat="salesman in salesmans"><a  ng-click="changeCurrentSalesman(salesman.salesmanId)">{{salesman.phone}}<br>{{salesman.lastName}}</a>
                                      
                                        </li>
                                </ul>

                                <div class="tab-content">
                                    <table class="table table-striped table-hover" style="width:90%;">
                                        <thead>
                                            <tr>
                                                <th>Provider ID</th>
                                                <th>Name</th>
                                                <th>Reg Date</th>
                                                <th>P. Pending,</th>
                                                <th>P. Approved</th>
                                                <th>Email</th>
                                                <th>Telephone</th>
                                                <th>Address</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr ng-repeat="provider in providers">
                                                <td>{{provider.providerOfficialId}}</td>
                                                <td>{{provider.name}}</td>
                                                <td>{{provider.activeDate}}</td>
                                                <td>{{provider.pendingPackage}}</td>
                                                <td>{{provider.activatePackage}}</td>
                                                <td>{{provider.email}}</td>
                                                <td>{{provider.phoneNumber}}</td>
                                                <td>{{provider.address}}</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>

                        </div>
                    </div>

                </div>
            </div>

            <%--<%@ include file="../footer.jsp" %>--%>
            <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/main.js?99"/>"></script>
            <script>
                                                    var loadProviderList = '<c:url value="/Admin/LoadProviderWithSalesman"/>';
                                                    var salesmans = ${requestScope.Salesman};
                                                  
                                                    var page = '${requestScope.page}';
                                                    $(document).ready(function () {
                                                        SpinnerText.init('ul[data-spinner]');

                                                        new toggleHeader.init({
                                                            toggleControl: false
//                                            toggleTheme: true
                                                        });
                                                    });
            </script>
        </div>
    </body>
</html>
