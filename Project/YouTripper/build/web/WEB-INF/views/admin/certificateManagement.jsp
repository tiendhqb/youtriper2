<%-- 
    Document   : createdPackageManagement
    Created on : Oct 20, 2015, 4:49:10 PM
    Author     : Nick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="background-provider">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=1366">
        <!--<script src='https://www.google.com/recaptcha/api.js'></script>-->
        <script src="https://www.google.com/recaptcha/api.js?onload=vcRecaptchaApiLoaded&render=explicit" async defer></script>
        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">

        <link href="<c:url value="/Resources/Theme/css/jquery.fs.boxer.css"/>" rel="stylesheet">
        <%@ include file="../angular.jsp" %>
        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css?999999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css?999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >
        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.fs.boxer.js"/>"></script>
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <title>Youtripper - Provider Packages</title>
    </head>
    <body>
        <div ng-app="YouTripper" ng-controller="ManageCertificateController">
            <%@ include file="../header.jsp" %>
            <%@ include file="adminMenubar.jsp" %>
            <div id="spinner-block" ng-hide="loaded">
                <div class="youtripper-spinner"></div>
            </div>
            <div class="affix-content">
                <div ng-cloak ng-show="loaded">

                </div>
                <div class="certificate-content">
                    <div style="padding:20px 0px 60px 0px">
                        <span class="col-md-1" style="font-weight:bold">Search</span>
                        <span class="col-md-3">
                            <input type="text" class="form-control ng-valid ng-dirty" ng-model="searchKeyword">
                        </span>
                    </div>
                    <form method="POST" action="<c:url value="/Admin/ApproveCertificate"/>" class="form-horizontal" name="signupForm" >
                        <table class="table table-hover">
                            <thead>
                                <tr>

                                    <th>Provider Name</th>
                                    <th>Certificate Name</th>
                                    <th>Certificate Image</th>
                                    <th>Action</th>
                                </tr>
                            </thead>

                            <tbody ng-repeat="group in certificatesGroup| filter: searchKeyword">

                                <tr ng-repeat="certificate in group.certificate">

                                    <td ng-hide="$index > 0" rowspan="{{group.certificate.length}}">  <a href="<c:url value="/Common/ProviderPage/"/>{{certificate.providerID}}" target="_self">
                                            <span style="color:#337ab7"> {{certificate.providerName}}</span></td>
                                    <td>{{certificate.name}}</td>
                                    <td><a href="<c:url value=""/>{{certificate.image}}" target="_blank"><img src=" {{certificate.image}}" height="50" width="50"><img></a></td>
                                    <td><input type="checkbox" name ="certificatesChecked" value="{{certificate.certificateID}}"/></td>
                                </tr>
                            </tbody>


                        </table> 
                        <br>
                        <button style="float:right;" type="submit" class="btn btn-provider btnRed-provider">Approve certificates</button>
                    </form>
                </div>
            </div>
            <%--<%@ include file="../footer.jsp" %>--%>
            <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/main.js?999"/>"></script>
            <script>
                                                var certificates = ${requestScope.Certificate};
                                                var page = '${requestScope.page}';
                                                $(document).ready(function () {
                                                    toggleHeader.init({
                                                        toggleControl: false
                                                    });
                                                });
            </script>
    </body>
</html>
