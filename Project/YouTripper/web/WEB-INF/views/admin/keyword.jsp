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
        <title>Youtripper - Payment Management</title>
    </head>
    <body>
        <div ng-app="YouTripper" ng-controller="ManageKeywordController">
            <%@ include file="../header.jsp" %>
            <%@ include file="adminMenubar.jsp" %>

            <div class="container">
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active " id="step2">
                        <div class="tab-message">
                            <h2>Keyword List ({{keywordNum}})</h2>
                            <h4 style="color: red">{{message}}</h4>
                            <br />
                            <div class="row">                                
                                <div class="col-md-8" style="overflow: scroll; height: 520px;">
                                    <table class="table">
                                        <tr>
                                            <td>Keyword</td>
                                            <td>Times</td>
                                            <td>Add to System Keyword</td>
                                            <td>Delete From Keyword List</td>
                                        </tr>
                                        <tr ng-repeat="x in keywordList">
                                            <td>  {{x.keyword}} </td>
                                            <td>  {{x.times}} </td>
                                            <td>  <input name="submit" value="Add" ng-click="addKeyword(x.keyword, x.times)" class="btn btn-provider" type="submit"> </td>
                                            <td>  <input name="submit" value="Delete" ng-click="deleteKeyword(x.keyword)" class="btn btn-provider" type="submit"> </td>
                                        </tr>   
                                    </table>

                                </div>
                                <form action="<c:url value="/Admin/ProcessAllKeyword"/>" method="POST">
                                    <div style="float:right">
                                        <input name="submit" value="Add All Keyword" class="btn btn-provider" type="submit">
                                        <input name="submit" value="Delete All Keyword" class="btn btn-provider" type="submit">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@ include file="../footer.jsp" %>
        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js?999"/>"></script>
        <script>
                                                var keywordList = ${requestScope.keywordList};
                                                var page = '${requestScope.page}';
                                                var message = null;
                                                <c:if test="${requestScope.message != null}">
                                                   message = '${requestScope.message}';
                                                </c:if>
                                                var deleteKeywordURL = '<c:url value="/Admin/DeleteKeyword/"/>';
                                                var addeKeywordURL = '<c:url value="/Admin/AddKeyword/"/>';

                                                $(document).ready(function () {
                                                    toggleHeader.init({
                                                        toggleControl: false
                                                    });
                                                });
        </script>
    </body>
</html>
