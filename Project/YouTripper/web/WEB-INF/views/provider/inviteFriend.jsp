<%-- 
    Document   : accountInfo
    Created on : Nov 2, 2015, 10:19:54 AM
    Author     : DINH KHANG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${param.language}" />
<fmt:setBundle basename="LanguagePack.lang" var="lang"/>
<!DOCTYPE html>
<html id="referral-program" class="background-provider" lang="${language}">
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
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/bootstrap-tagsinput.css"/>">
        
        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap-tagsinput.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.inputmask.bundle.min.js"/>"></script>
        <script src="//js.live.net/v5.0/wl.js"></script>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >
        <title>Referral Provider</title>
    </head>
    <body>
        <div class="pagesearch" ng-app="YouTripper" ng-controller="RefferalProgram">

            <%@ include file="../header.jsp" %>
            <%@ include file="providerMenubar.jsp" %>
            <div class="affix-content clearfix">
                <!--Stop Popup  -->
                <div class="ytPopup" id="contactPopup" class="contactPopup">
                    <div class="tbl-cell">
                        <div class="popupContent">
                            <div class="center-informBlock blur-backgroud" ng-show="sendingEmailPopup">
                                <div class="small-spinner" ></div>
                            </div>
                            <span class="box-closing" ng-click="toggleContactBox()"></span>
                            <div class="popupRow">
                                <div class="row">

                                    <div class="col-xs-4">
                                        <div class="row-header">
                                            Name 
                                        </div>
                                    </div>
                                    <div class="col-xs-6">
                                        <div class="row-header">
                                            Email Address
                                        </div>
                                    </div>
                                    <div class="col-xs-2">
                                    </div>
                                </div>
                            </div>

                            <div class="popupScroll">
                                <div class="popupRow">

                                    <ul>

                                        <li ng-repeat="contact in socialContactArray">
                                            <div class="row">

                                                <div class="col-xs-4">
                                                    <div class="row-header-left">
                                                        <div>{{contact.name}}</div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-6">
                                                    <div class="row-header-right">
                                                        <div>{{contact.email}}</div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-2">
                                                    <div class="row-header-left">
                                                        <input type="checkbox" checklist-model="pickedEmail" checklist-value="contact.email" >
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>

                            </div>
                            <div class="popupRow">
                                <div class="row">
                                    <div class="col-xs-6">
                                        <a class="btn btn-width-orange next-btn" ng-click="sendInvitationPopup()">Send Invitation</a>
                                    </div>
                                    <div class="col-xs-6">
                                        <a class="btn btn-width-blue next-btn" ng-click="addToEmailList()">Add to email list</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div id="provider-referral">
                    
                    <div id="referral-history">
                        <div class="header">
                            <h2><fmt:message key="invite.referral" bundle="${lang}"/></h2>
                            <div class="header-content">
                                <div class="number-referral-block">
                                    <span><fmt:message key="invite.successful" bundle="${lang}"/> </span>
                                    <span class="number-referral">{{activeReferralCount}}</span>
                                </div>
                                <div class="number-referral-block2">
                                    <span><fmt:message key="invite.pending" bundle="${lang}"/> </span>
                                    <span class="number-referral">{{listReferral.length - activeReferralCount}}</span>
                                </div>
                                <div class="number-referral-block3">
                                    <span><fmt:message key="invite.total" bundle="${lang}"/> </span>
                                    <span class="number-referral">{{listReferral.length}}</span>
                                </div>
                            </div>
                        </div>
                        <div class="content">
                            <table>
                                <tr class="table-header">
                                    <th id="history-email"><fmt:message key="invite.email" bundle="${lang}"/></th>
                                    <th class="text-center down-arrow"><fmt:message key="invite.status" bundle="${lang}"/></th>
                                    <th class="text-center"><fmt:message key="invite.follow" bundle="${lang}"/></th>
                                </tr>

                                <tr ng-repeat="referral in listReferral">
                                    <td class="email-width">{{referral.email}} </td>
                                    <td class="text-center">{{referral.status}}</td>
                                    <td class="text-center"><span ng-if="referral.status === 'Pending'"></span></td>
                                </tr>

                            </table>
                        </div>
                    </div>
                    <div id="referral-content">
                        <div class="header">
                            <h2><fmt:message key="invite.recommend" bundle="${lang}"/></h2>
                        </div>
                        <div class="description">
                            <div class="description-row">
                                <p><fmt:message key="invite.hi" bundle="${lang}"/> ${sessionScope.account.name}</p>
                                <br>
                                <p><fmt:message key="invite.content1" bundle="${lang}"/></p>
                                <br>
                                <p><fmt:message key="invite.content2" bundle="${lang}"/></p>
                                <br>
                                <p><fmt:message key="invite.content3" bundle="${lang}"/></p>

                            </div>
                            <div class="description-row" style="position:relative;">
                                <div class="center-informBlock blur-backgroud" ng-show="isProcessing">
                                    <div class="small-spinner" ></div>
                                </div>
                                <input class="blueInput normalFont email-addresses"type="text" placeholder="<fmt:message key="invite.enterEmail" bundle="${lang}"/>"/>

                                <button class="btn-width-orange next-btn" ng-click="inviteEmails()"><fmt:message key="invite.inviteButton" bundle="${lang}"/></button>
                            </div>
                            <div ng-if="inviteSuccess" class="description-row" style="color:green;">
                                <p><fmt:message key="invite.sendok" bundle="${lang}"/></p>
                            </div>
                            <div ng-if="emailArray.length > 0 && !isSendEmail" class="description-row">
                                <ul class="clearfix">
                                    <li  ng-repeat="email in emailArray" >
                                        <div class="email-picked">
                                            {{email}}
                                            <a class="remove-button" ng-click="removeEmail($index)">×</a>
                                        </div>
                                    </li>
                                </ul>
                            </div>


                            <div class="description-row clearfix">
                                <div class="social-contact-content"><fmt:message key="invite.importContact" bundle="${lang}"/></div>
                                <div class="social-contact google-contact" ng-click="importGoogle()"><span></span> <div>Gmail</div></div>
                                <div class="social-contact outlook-contact" ng-click="importOutlook()"><span></span> <div>Outlook Mail</div></div>
                            </div>
                            <div class="description-row">
                                <textarea disabled class="blueTextArea normalFont email-content"><fmt:message key="invite.hi" bundle="${lang}"/>,

<fmt:message key="invite.mailContent1" bundle="${lang}"/>

<fmt:message key="invite.mailContent2" bundle="${lang}"/> 

<fmt:message key="invite.mailContent3" bundle="${lang}"/>

<fmt:message key="invite.mailContent4" bundle="${lang}"/>
https://www.youtripper.com/ProviderSignup?ref=${requestScope.officialID}

<fmt:message key="invite.cheer" bundle="${lang}"/>, </textarea>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%--<%@ include file="../footer.jsp" %>--%>
        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js?999"/>"></script>

    </body>
</html>
<script>
                                    var referralList = ${requestScope.referralList};
                                    var officialID = '${requestScope.officialID}';
</script>
<script type="text/javascript">
    WL.init({
        client_id: '19beffbd-21a9-4ae1-818d-40566bb2c7ad',
        redirect_uri: 'https://localhost:8084',
        scope: ["wl.basic", "wl.contacts_emails"],
        response_type: "token"
    });
</script>