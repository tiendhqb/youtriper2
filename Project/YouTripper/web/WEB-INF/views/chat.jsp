<%-- 
    Document   : chat
    Created on : Oct 26, 2015, 10:11:43 PM
    Author     : DINH KHANG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html ng-app="YouTripper" ng-controller="ChatController">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=1366">
<!--        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1">-->
        <!--<script src='https://www.google.com/recaptcha/api.js'></script>-->

        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">

        <%@ include file="./angular.jsp" %>

        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css?999999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css?999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >

        <script src="<c:url value="/Resources/Theme/js/angular-sanitize.min.js"/>"></script>   
        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/sockjs-0.3.4.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/stomp.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/ng-file-upload-shim.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/ng-file-upload.min.js"/>"></script>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >
    </head>
    <body data-ng-init="disconnect()">
        <noscript><h2 style="color: #ff0000">Seems your browser doesn't support Javascript! Websocket relies on Javascript being enabled. Please enable
            Javascript and reload this page!</h2></noscript>

        <div> 
            <div id="conversationDiv">
                <div ngf-drop ngf-select  ng-model="uploadImage" class="drop-box" id="uploadImage"
                     ngf-drag-over-class="dragover" ngf-allow-dir="true"
                     accept="image/*">
                    <button id="clickhere">Image</button>
                </div>
                <div ngf-drop ngf-select  ng-model="uploadFile" class="drop-box" id="uploadFile"
                     ngf-drag-over-class="dragover" ngf-allow-dir="true"
                     accept="*">
                    <button id="clickhere">File</button>
                </div>                
                <label>Type your message:</label><input type="text" id="name" />
                <button id="sendName" ng-click="sendName();">Send</button><br>

                <span ng-repeat="x in messageList">
                    <span ng-if="x.userType === 'provider'">
                        <span ng-if="x.message.type === 'image'">{{chatname.providerName+":"}}<img ng-src="{{x.message.content}}"/><br></span>
                        <p ng-if="x.message.type === 'text'">{{chatname.providerName+":"+x.message.content}}<br></p>
                        <span ng-if="x.message.type === 'file'">{{chatname.providerName+":"}}<a ng-href="{{x.message.content}}">{{x.message.filename}}</a><br></span>

                    </span>
                    <span ng-if="x.userType === 'tripper'">
                        <span ng-if="x.message.type === 'image'">{{chatname.tripperName+":"}}<img ng-src="{{x.message.content}}"/><br></span>
                        <p ng-if="x.message.type === 'text'">{{chatname.tripperName+":"+x.message.content}}<br></p>
                        <span ng-if="x.message.type === 'file'">{{chatname.tripperName+":"}}<a ng-href="{{x.message.content}}">{{x.message.filename}}</a><br></span>
                    </span>
                </span>
                <p id="response"></p>

            </div>

            <ul>
                <li ng-click="viewBooking()">Booking List</li>
                <li ng-repeat="x in names">
                    <c:choose>
                        <c:when test="${sessionScope.account.role == 2}">
                            <a href="#" ng-class="x.code" ng-click="viewDetail(x.code, x.tripperName, x.providerName)">{{ x.tripperName}}</a> 
                        </c:when>
                        <c:otherwise>
                            <a href="#" ng-class="x.code" ng-click="viewDetail(x.code, x.tripperName, x.providerName)">{{ x.providerName}}</a> 
                        </c:otherwise>
                    </c:choose>
                </li>
                <li ng-click="viewConversationList()" >Conversation List</li>
                <li  ng-repeat="x in conversationList">
                    <c:choose>
                        <c:when test="${sessionScope.account.role == 2}">
                            <a href="#" ng-click="viewConversationDetail(x.conversationID, x.tripperName, x.providerName)">{{ x.tripperName}}</a> 
                        </c:when>
                        <c:otherwise>
                            <a href="#" ng-click="viewConversationDetail(x.conversationID, x.tripperName, x.providerName)">{{ x.providerName}}</a> 
                        </c:otherwise>
                    </c:choose>
                </li>
            </ul>



        </div> 
        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js?999"/>"></script>
         <script src="<c:url value="/Resources/Theme/js/youtripper.js?999"/>"></script>
        <script>
                    var userType = '${sessionScope.account.role}';
                    var userID = '${sessionScope.account.id}';
                    var userName = '${sessionScope.account.name}';
                    var conversationList1 = ${requestScope.conversationList};
                    var fileuploaderBooking = '<c:url value="/Message/File/Booking/upload"/>';
                    var fileUploaderConversation = '<c:url value="/Message/File/Conversation/upload"/>';
                    var ImageUploaderBooking = '<c:url value="/Message/Image/Booking/upload"/>';
                    var ImageUploaderConversation = '<c:url value="/Message/Image/Conversation/upload"/>';
                    var viewBooking = '<c:url value="/Message/getBookingList/"/>${sessionScope.account.id}';
                    var viewConversation = '<c:url value="/Message/getConversationList/"/>${sessionScope.account.id}';
                    var websocketURL = '<c:url value="/hello/"/>';
                    var getBookingMessURL = '<c:url value="/Message/getBookingMessage/"/>';
                    var getConMessURL = '<c:url value="/Message/getConversationMessage/"/>';

        </script>
        

    </body>
</html>