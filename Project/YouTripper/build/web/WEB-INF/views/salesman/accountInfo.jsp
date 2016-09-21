<%-- 
    Document   : accountInfo
    Created on : Nov 2, 2015, 10:19:54 AM
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
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >
        <title>Account Information</title>
    </head>
    <body>
        <div class="pagesearch" ng-app="YouTripper" ng-controller="AccountInfo">
            <%@ include file="../header.jsp" %>
            <%@ include file="salesmanMenubar.jsp" %>
            <div style="width:100%; background-color: #f2f2f4">
                <div class="col-sm-9 col-md-10 affix-content">
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="step1">
                            <div class="tab-account">
                                <div class="box-account box-account-edit row">
                                    <h2>Account Information</h2>
                                    <div class="upload-avatar group col-md-2">
                                        <img ngf-drop ngf-select ng-model="providerImage" style="cursor: pointer"
                                             ngf-drag-over-class="dragover" ngf-allow-dir="true"
                                             accept="image/*"
                                             ngf-pattern="'image/*'" alt="" ng-src="/{{accountInfo.image}}?{{currentTime}}" />
                                        <p ngf-drop ngf-select ng-model="providerImage" style="cursor: pointer"
                                           ngf-drag-over-class="dragover" ngf-allow-dir="true"
                                           accept="image/*"
                                           ngf-pattern="'image/*'">Upload Profile Picture</p>
                                    </div>
                                    <div class="col-md-10">
                                        <form class="form-horizontal profile-edit-box" ng-submit="validateForm($event)" name="providerForm" action="<c:url value="/Provider/UpdateInformation"/>" method="POST">
                                            <div class="form-group provider-edit-form ">
                                                <div class="col-md-3 title-property">
                                                    First name
                                                </div>
                                                <div class="col-md-9">
                                                    <input type="text" ng-model="accountInfo.firstName"  name="firstName"
                                                           class="normalFont input-property small-input" placeholder="Your first name"/>
                                                    <span style="color: red" ng-show="!accountInfo.firstName.length">Please enter your first name</span>
                                                </div>
                                                <!--<div class="col-md-4">-->
                                                </div>
                                            <!--</div>-->
                                            <div class="form-group provider-edit-form">
                                                <div class="col-md-3 title-property">
                                                    Last name
                                                </div>
                                                <div class="col-md-9">
                                                    <input type="text" ng-model="accountInfo.name"  name="lastName"
                                                           class="normalFont input-property small-input" placeholder="Your last name"/>
                                                    <span style="color: red" ng-show="!accountInfo.name.length">Please enter your last name</span>
                                                </div>
                                                <!--<div class="col-md-4">-->
                                                </div>
                                            <!--</div>-->
                                            <div class="form-group provider-edit-form">
                                                <div class="col-md-3 title-property">
                                                    Email
                                                </div>
                                                <div class="col-md-9">
                                                    <input type="text" ng-model="accountInfo.email"  name="email"
                                                           class="normalFont input-property small-input" placeholder="Your Email"/>

                                                    <!--<input type="text" value="{{accountInfo.email}}" class="normalFont input-property" placeholder="Your email"/>-->
                                                </div>
                                                <!--<div class="col-md-4">-->
                                                </div>
                                            <!--</div>-->
                                            <div class="form-group provider-edit-form">
                                                <div class="col-md-3 title-property">
                                                    Password
                                                </div>
                                                <div class="col-md-9">
                                                    ********* <a target="_self" href="<c:url value="/Provider/Password"/>" class="href-orange">Change</a>
                                                </div>
                                                <!--<div class="col-md-4">--> 
                                                </div>
                                            <!--</div>-->
                                            <div class="form-group provider-edit-form">
                                                <div class="col-md-3 title-property">
                                                    Phone number
                                                </div>
                                                <div class="col-md-9">
                                                    <input type="text" ng-model="accountInfo.phoneCode + ' - ' + accountInfo.phoneNumber"  name="phone"
                                                           class="normalFont input-property small-input" placeholder="Your Phone Number"/>
                                                    <!--{{accountInfo.phoneCode + ' - ' + accountInfo.phoneNumber}}-->
                                                    <!--                                            <input type="text" value="{{accountInfo.name}}" class="normalFont input-property" placeholder="Your last name"/>-->
                                                </div>
                                                <!--<div class="col-md-4">-->

                                                </div>
                                            <!--</div>-->
                                            <div class="form-group provider-edit-form">
                                                <div class="col-md-3 title-property">
                                                    Lives in 
                                                </div>
                                                <div class="col-md-9">
                                                    <input type="text" ng-model="accountInfo.city + ',' + accountInfo.countryName"  name="live"
                                                           class="normalFont input-property small-input" placeholder="Lives in"/>
                                                    <!--{{accountInfo.city + ',' + accountInfo.countryName}}-->
                                                    <!--<input type="text" value="{{accountInfo.name}}" class="normalFont input-property small-input" placeholder="Your last name"/>-->
                                                </div>
                                                <!--<div class="col-md-4">-->
                                                </div>
                                            <!--</div>-->
                                            <div class="form-group provider-edit-form">
                                                <div class="col-md-3 title-property">
                                                    Address
                                                </div>
                                                <div class="col-md-9">
                                                    <input type="text" ng-model="accountInfo.address"  name="address"
                                                           class="normalFont input-property small-input" placeholder="Lives in"/>
                                                    <!--{{accountInfo.address}}-->
                                                    <!--<input type="text" value="{{accountInfo.address}}" class="normalFont input-property" placeholder="Your address"/>-->
                                                </div>
                                                <!--<div class="col-md-4">-->
                                                </div>
                                            <!--</div>-->
                                            <div class="form-group provider-edit-form">
                                                <div class="col-md-3 title-property">
                                                    About me
                                                </div>
                                                <div class="col-md-9 textarea-property">
                                                    <!--<input type="text" value="{{accountInfo.address}}" class="normalFont input-property" placeholder="Your address"/>-->
                                                    <textarea placeholder="Tell something about you" name="information"
                                                              class="normalFont">{{ accountInfo.information}}</textarea>

                                                </div>

                                            </div>
                                            <div class="form-group provider-edit-form">
                                                <div class="col-md-3 title-property" style="line-height: 22px;">
                                                    Category interest
                                                </div>
                                                <div class="col-md-9 textarea-property">
                                                    <!--<input type="text" value="{{accountInfo.address}}" class="normalFont input-property" placeholder="Your address"/>-->
                                                    <textarea placeholder="Your hobbies" name="interests" 
                                                              class="normalFont">{{accountInfo.interests}}</textarea>
                                                </div>

                                            </div>
                                            <div class="form-group provider-edit-form">
                                                <div class="col-md-3 title-property">
                                                    Tax number
                                                </div>
                                                <div class="col-md-9 textarea-property">
                                                    <!--{{accountInfo.city + ',' + accountInfo.countryName}}-->
                                                    <input type="text" value="{{accountInfo.taxnumber}}"  name="taxnumber"
                                                           class="normalFont input-property small-input" placeholder="Your tax number"/>
                                                </div>
                                            </div>
                                            <div class="form-group provider-edit-form">
                                                <div class="col-md-3 title-property">
                                                    Language
                                                </div>
                                                <div class="col-md-9 textarea-property">
                                                    <!--{{accountInfo.city + ',' + accountInfo.countryName}}-->
                                                    <input type="text" value="{{accountInfo.language}}"  name="language"
                                                           class="normalFont input-property small-input" placeholder="Your language"/>
                                                </div>
                                            </div>
                                            <div  class="form-group provider-edit-form">
                                                <div class="col-md-3 title-property">
                                                    Notification
                                                </div>
                                                <div class="col-md-9 noti-setting">
                                                    <div class="tempCheckbox">
                                                        <input type="radio" name="notification"  ng-value="true" ng-model="accountInfo.notification"/>
                                                        <span></span>
                                                    </div>
                                                    <p>Yes</p>
                                                    
                                                    <div class="tempCheckbox">
                                                        <input type="radio" name="notification"  ng-value="false" ng-model="accountInfo.notification"/>
                                                        <span></span>
                                                    </div>
                                                    <p>No</p>
                                                </div>
                                            </div>
                                            <br/>
                                            <div class="form-group provider-edit-form">
                                                <div class="col-md-4 title-property">
                                                </div>
                                                <div class="col-md-6">
                                                    <button type="submit" class="btn btn-save">Save</button>
                                                </div>
                                                <!--<div class="col-md-4">-->
                                                </div>
                                            <!--</div>-->
                                        </form>
                                    </div>
                                </div>
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
        <script>
                                                            var providerInfo = ${requestScope.AccountInfo};
                                                            var page = '${requestScope.page}';
                                                            var uploadUrl = '<c:url value="/Provider/UploadImage"/>';
                                                            $(document).ready(function () {
                                                                toggleHeader.init({
                                                                    toggleControl: false
                                                                });
//                                            $('.edit-account').click(function () {
//                                                if ($('.box-account-edit').is(":visible")) {
//                                                    $('.box-account-edit').hide();
//                                                    $('.box-account-info').show();
//                                                    $(this).text("Edit");
//                                                }
//                                                else {
//                                                    $(this).text("Cancel");
//                                                    $('.box-account-edit').show();
//                                                    $('.box-account-info').hide();
//                                                }
//                                            });
                                                            });
        </script>
    </body>
</html>
