<%-- 
    Document   : manageSalesman
    Created on : May 10, 2016, 4:49:23 PM
    Author     : QuangTran
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
           <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <title>Youtripper - Provider Packages</title>
    </head>
    <body>
        <div ng-app="YouTripper" ng-controller="ManagerSales">
            <%@ include file="../header.jsp" %>
            <%@ include file="salesmanMenubar.jsp" %>
            <div id="spinner-block" ng-hide="loaded">
                <div class="youtripper-spinner"></div>
            </div>
            <div class="site-container">
                <div class="col-sm-9 col-md-10 affix-content">
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="step1">
                            <table>
                                <th>No.</th>
                                <th>Provider's Name</th>
                                <th>Provider's Email</th>
                                <th>Is activate package</th>
                           
                                <tr ng-repeat="provider in providerList">
                                    <td>{{ $index + 1 }}</td>
                                    <td>{{ provider.name}}</td>
                                    <td>{{ provider.email}}</td>
                                    <td>{{activatePackage[provider.activatePackage]}}</td>
                                </tr>
                                <tr>Total : {{providerList.length}}</tr>
                            </table>
                        </div>
                    </div>

                </div>
            </div>

        </div>
        <%--<%@ include file="../footer.jsp" %>--%>
        <style>
            table, th , td {
                border: 1px solid grey;
                border-collapse: collapse;
                padding: 5px;
            }
            table tr:nth-child(odd) {
                background-color: #f1f1f1;
            }
            table tr:nth-child(even) {
                background-color: #ffffff;
            }
        </style>

        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js?999"/>"></script>
        <script>
                                        var providerInfo = ${requestScope.ProviderInfo};
                                        console.log(providerInfo);
                                        var page = '${requestScope.page}';
                                        $(document).ready(function () {
                                            toggleHeader.init({
                                                toggleControl: false
                                            });
                                        });
        </script>
    </body>
</html>