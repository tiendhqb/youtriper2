<%-- 
    Document   : accountInfo
    Created on : Nov 2, 2015, 10:19:54 AM
    Author     : DINH KHANG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html ng-app="YouTripper" ng-controller="TripperMessageController">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=1366">
<!--        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1">-->
        <!--<script src='https://www.google.com/recaptcha/api.js'></script>-->

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
        <title>Message</title>
    </head>
    <body>
        <div style="position: fixed; top: 0; bottom: 0; left: 0; right: 0; background: #fff; z-index: 99999" ng-show="loading">
            <div class="youtripper-spinner" ></div>
        </div>
        <div class="pagesearch selected-messages" id="chatPage" ng-cloak ng-hide="loading">
            <%@ include file="../header.jsp" %>
            <%@ include file="tripperMenubar.jsp" %>
            <div class="site-container">
                <div class="col-sm-9 col-md-10 affix-content">
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="step2">
                            <div class="tab-message">
                                <h2>Messages</h2>
                                <br />
                                <div class="row">
                                    <div class="col-md-4 col-sm-5" id="messagesBox">
                                        <div class="tasleft">
                                            <ul class="tasleft-caption">
                                                <li><a ng-click="viewConversationList()" href="#Messages">Messages</a></li>
                                                <li><a id="BookingLI" ng-click="viewBooking()" href="#Booking">Bookings</a></li>
                                                <li><a id="YoutripperTab" ng-click="" href="#Booking">YouTripper</a></li>
                                            </ul>
                                            <div id="Messages">
                                                <div class="message-left">
                                                    <div class="search-message">
                                                        <div class="search-message-inner">
                                                            <input type="text" placeholder="Search" class="normalFont" ng-model="messageSearch.providerName"/>
                                                            <button></button>
                                                        </div>
                                                    </div>
                                                    <ul class="list-resulft">
                                                        <li ng-repeat="x in conversationList|filter: messageSearch| orderBy: 'latestTime' : true" class="group" 
                                                            ng-class="{'active' : selectOrNot(x.conversationID),'unreadConv' : x.numOfUnreadMessage >= 1}"
                                                            ng-click="SelectedConversationChange(x.conversationID);
                                                                        x.numOfUnreadMessage = 0">
                                                            <div class="avatar" style="background-image: {{x.packageImage}}">
                                                            </div>
                                                            <h3 >{{x.packageName}} <span>{{x.time}}</span></h3>
                                                            <div class="message-preview">
                                                                <div class="unreadMess" ng-class="{'hidden' : x.numOfUnreadMessage < 1}"> ({{x.numOfUnreadMessage}} new)</div>
                                                                <div ng-show="checkFile(x.latestMessage)">{{ x.latestMessage.filename}}</div>
                                                                <div ng-show="checkText(x.latestMessage)">{{ x.latestMessage.content}}</div>   
                                                            </div>
                                                        </li>                                                    
                                                    </ul>
                                                </div>
                                            </div>
                                            <div id="Booking">
                                                <div class="message-left">
                                                    <div class="search-message">
                                                        <div class="search-message-inner">
                                                            <input type="text" placeholder="Search" class="normalFont" ng-model="bookingSearch.packageName"/>
                                                            <button></button>
                                                        </div>
                                                    </div>
                                                    <ul class="list-resulft">
                                                        <li ng-repeat="x in names|filter: bookingSearch |orderBy: 'latestTime' : true" class="group" 
                                                            ng-class="{'active' : selectedBookingOrNot(x.code),'unreadConv' : x.numOfUnreadMessage >= 1}"
                                                            ng-click="SelectedBookingChange(x.code);
                                                                        x.numOfUnreadMessage = 0">
                                                            <div class="avatar" style="background-image: {{x.avatar}}">
                                                            </div>
                                                            <h3>{{ x.packageName}}<span>{{ x.bookingDate}}</span></h3>                                                     
                                                            <div class="message-preview">
                                                                <div>{{ x.tripperName}} <p class="unreadMess" ng-class="{'hidden' : x.numOfUnreadMessage < 1}"> ({{x.numOfUnreadMessage}} new)</p></div>
                                                            </div>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-8 col-sm-7" id="chatBox">
                                        <div class="messConversation" ng-model="messConversation" id="messConversation" ng-hide="loadingConvDatail">
                                            <div class="row-message" ng-show="loadingScroll" style="text-align: center">
                                                Loading More ...
                                            </div>
                                            <div ng-repeat="x in messageList| orderBy:'+messageID'" class="row-message"
                                                 ng-class="{'tripper-message' : x.userType === 'tripper', 'provider-message' : x.userType !== 'tripper'}">
                                                <div class="avatar" style="background-image: {{x.avatar}}">
                                                </div>
                                                <h3><strong>{{x.name}}</strong> <span>{{x.time}}</span></h3>
                                                <!--                                            <div ng-if="x.message.type === 'image'" class="message-image" style="background-image: url({{x.message.content}})"></div>-->
                                                <a ng-if="x.message.type === 'image'" href="{{x.message.content}}" class="image-msg">
                                                    <div class="message-image" style="background-image: url({{x.message.content}})"></div>
                                                </a>
                                                <p ng-if="x.message.type === 'text'">{{x.message.content}}<br></p>
                                                <span ng-if="x.message.type === 'file'"><a class="href-orange" ng-href="{{x.message.content}}">{{x.message.filename}}</a><br></span>
                                                <div class="line-message"></div>
                                            </div>
                                            <!--                                        <div class="row-message" ng-show="sending">
                                                                                        Sending ...
                                                                                    </div>-->
                                        </div>
                                        <div class="messConversation" id="messConversation" ng-show="loadingConvDatail">
                                            <div class="chat-spinner">

                                            </div>
                                        </div>
                                        <div>
                                            <div class="box-message">
                                                <textarea id="textReply" placeholder="Type message here..." class="normalFont"></textarea>
                                                <div class="box-message-bar group">
                                                    <a ngf-drop ngf-select  ng-model="uploadFile" id="uploadFile" ngf-drag-over-class="dragover" ngf-allow-dir="true"
                                                       accept="*" href="#" class="attack-photo">Add File</a>
                                                    <a ngf-drop ngf-select  ng-model="uploadImage" class="attack-file" id="uploadImage"
                                                       ngf-drag-over-class="dragover" ngf-allow-dir="true"
                                                       accept="image/*" href="#" >Add Photo </a>

                                                    <!--<a href="#" class="press"></a>-->
                                                    <a  id="sendName" ng-click="sendName();" href="#" class="reply">Reply</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="filters-btn fixed back-btn">
                            <a href="" class="btn-primary btn-orange" ng-click="backToMessages()">Back</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="image-overlay"></div>
            <div class="image-boxer">
                <span class="image-boxer-close">
                </span>
                <img src="http://27.254.77.180/Images/17/17-1.jpg" title=""/>
            </div>
            <%--<%@ include file="../footer.jsp" %>--%>
            <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/main.js?999"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/jquery.tabslet.js"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/jquery.matchHeight.js"/>"></script>
            <script>
                                    var page = '${requestScope.page}';
                                    var userType = '${sessionScope.account.role}';
                                    var providerID = '${sessionScope.account.id}';
                                    var userName = '${sessionScope.account.name}';
                                    var userImage = '${sessionScope.account.image}';
                                    var conversationList = ${requestScope.conversationList};
                <c:if test="${requestScope.conversationID != null}">
                                    conversationID = ${requestScope.conversationID};
                </c:if>
                <c:if test="${requestScope.BookingID != null}">
                                    bookingID = '${requestScope.BookingID}';
                </c:if>
                                    console.log(conversationID);
                                    $('.tasleft').tabslet();
                                    $(document).ready(function () {
                                        toggleHeader.init({
                                            toggleControl: false
                                        });

                                        $(document).on('click', '.image-msg', function () {
                                            openImage($(this).attr("href"));
                                            return false;
                                        });

                                        $(document).on('click', '.image-boxer-close', function () {
                                            openImage(null);
                                        });
                                    });
            </script>
    </body>
</html>
