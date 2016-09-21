<%-- 
    Document   : notification
    Created on : Nov 3, 2015, 6:03:18 PM
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
        <title>Youtripper - Provider Notifications</title>
    </head>
    <body>
        <div class="pagesearch" ng-app="YouTripper" ng-controller="NotificationController">
            <%@ include file="../header.jsp" %>
            <%--<%@ include file="providerMenubar.jsp" %>--%>
            <div id="spinner-block" ng-hide="loaded">
                <div class="youtripper-spinner"></div>
            </div>
            <div class="container"  ng-cloak ng-show="loaded" style="margin-top: 60px;">
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="step4">
                        <h2>Notifications (Email me when)</h2>
                        <form action="
                              <c:choose>
                                  <c:when test="${empty param.language}">
                                      <c:url value="/Provider/SaveSetting"/>
                                  </c:when>
                                  <c:otherwise>
                                      <c:url value="/Provider/SaveSetting?language=${param.language}"/>
                                  </c:otherwise>
                              </c:choose>" method="POST">
                            <div class="tab-notifications">
                                <ul>
                                    <li ng-repeat="noti in Notifications">
                                        <div class="tempCheckbox">
                                            <input type="checkbox" checklist-model="providerSetting"
                                                   checklist-value="noti.providerNotificationID">
                                            <span></span>
                                        </div>
                                        <p>{{noti.name}}</p>
                                    </li>
                                </ul>
                                <input name="settingJson" type="hidden" value="{{providerSetting}}">
                                <input name="providerID" type="hidden" value="${sessionScope.account.id}">
                                <button type="submit" class="btn btn-change-password">Save seting</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <%@ include file="../footer.jsp" %>
            <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/main.js?999"/>"></script>
            <script>
                                            var notifications = ${requestScope.providerNotification};
                                            var providerSetting = ${requestScope.providerSetting};
                                            var page = '${requestScope.page}';
                                            $(document).ready(function () {
                                                toggleHeader.init({
                                                    toggleControl: false
                                                });
                                            });
            </script>
    </body>
</html>
