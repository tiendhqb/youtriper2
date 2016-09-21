<%-- 
    Document   : providerLogin
    Created on : Oct 16, 2015, 11:38:39 AM
    Author     : Nick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${param.language}" />
<fmt:setBundle basename="LanguagePack.lang" var="lang"/>
<!DOCTYPE html>
<html id="providerSignup">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=1366,initial-scale=1">
        <!--        <meta name="viewport" content="width=device-width, initial-scale=1">-->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!--<script src='https://www.google.com/recaptcha/api.js'></script>-->
        <script src="https://www.google.com/recaptcha/api.js?onload=vcRecaptchaApiLoaded&render=explicit" async defer></script>
        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/clockpicker.css"/>">
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style-login.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/slider-captcha.css"/>" >

        <%@ include file="angular.jsp" %>

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.ui.touch-punch-improved.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/slider-captcha.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.inputmask.bundle.min.js"/>"></script>
        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >
        <title>YouTripper - Provider signup page</title>
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
        <div ng-app="YouTripper" ng-controller="BeProviderController" class="background">
            <div style="position: fixed; top: 0; bottom: 0; left: 0; right: 0; background: #fff; z-index: 99999" ng-show="loading">
                <div class="youtripper-spinner" ></div>
            </div>
            <div ng-cloak ng-hide="loading" class="pagesearch">
                <%@ include file="header.jsp" %>
                <div class="padding-header">
                    <div id="provider-signup-bg">
                        <div class="container">
                            <div class="row">
                                <div class="col-xs-6">
                                    <div class="signup-box">
                                        <h4><fmt:message key="provider.register.title" bundle="${lang}"/></h4>
                                        <div class="signup-form">
                                            <form method="POST" 
                                                  action="
                                                  <c:choose>
                                                      <c:when test="${empty param.language }">
                                                          <c:url value="/Common/Provider/Register"/>
                                                      </c:when>
                                                      <c:otherwise>
                                                          <c:url value="/Common/Provider/Register?language=${param.language}"/>
                                                      </c:otherwise>
                                                  </c:choose>" 
                                                  class="form-horizontal" name="signupForm" 
                                                  ng-submit="validateRegisterForm($event)" novalidate autocomplete="off">
                                                <input type="hidden" name="ref" value="${param.ref}"/>
                                                <div class="rr-bea">
                                                    <input type ="hidden" name="businessType" ng-model="register.businessType" value="{{businessType.businessTypeID}}"/>
                                                    <div class="businessTypeSelect" ng-click="showDDlBusinessType()">
                                                        <fmt:message key="provider.register.providerType" bundle="${lang}"/>
                                                    </div>
                                                    <p style="color: red" ng-show="showError.all && !missing.businessType"><fmt:message key="provider.register.e.accountType" bundle="${lang}"/></p>
                                                    <div class="businessTypeDdlMenu">
                                                        <ul>
                                                            <li ng-repeat="businessType in form.businesses" ng-click="chooseBusinessType(businessType.businessTypeID)" >
                                                                {{businessType.type}}
                                                            </li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <div class="rr-bea">
                                                    <input ng-model="register.businessName" name="businessName" type="text" maxlength="200" ng-maxlength="200"
                                                           class="blueInput normalFont" id="businessName" placeholder="<fmt:message key="provider.register.businessName" bundle="${lang}"/>" required>

                                                    <span ng-show="(showError.businessName || showError.all) && !businessNameLoading">
                                                        <!--<span ng-show="missing.businessName && signupForm.businessName.$valid" style="color: green">Business Name is valid!</span>-->
                                                        <span ng-show="missing.businessName && signupForm.businessName.$valid" class="validIcon"></span>
                                                        <span ng-show="!missing.businessName && signupForm.businessName.$valid" style="color: red"><fmt:message key="provider.register.e.businessName" bundle="${lang}"/></span>
                                                        <span style="color: red" ng-show="signupForm.businessName.$error.required"><fmt:message key="provider.register.e.missingBusinessName" bundle="${lang}"/><br/></span>
                                                        <span style="color: red" ng-show="signupForm.businessName.$error.maxlength">Business Name length must be less than 20 characters!<br/></span>

                                                    </span>
                                                </div>
                                                <div class="rr-bea">
                                                    <div class="row">
                                                        <div class="col-xs-6" style="padding-right: 5px;">
                                                            <input type ="hidden" name="country" ng-model="register.country" value="{{country.countryId}}"/>
                                                            <div class="countrySelect" ng-click="showDDlCountry()">
                                                                <fmt:message key="provider.register.country" bundle="${lang}"/>
                                                            </div>
                                                            <div class="countryDdlMenu">
                                                                <ul>
                                                                    <li ng-repeat="country in form.countries" ng-click="chooseCountry(country.countryID)" >
                                                                        {{country.name}}
                                                                    </li>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                        <div class="col-xs-6" style="padding-left: 2px">                                                           
                                                            <input type ="hidden" name="city" ng-model="register.city" value="{{city.name}}"/>
                                                            <div class="citySelect" ng-click="showDDlCity()">
                                                                <fmt:message key="provider.register.city" bundle="${lang}"/>
                                                            </div>
                                                            <div class="cityDdlMenu">
                                                                <ul>
                                                                    <li ng-repeat="city in listCityFiltered()" ng-click="chooseCity(city.cityID)" >
                                                                        {{city.name}}
                                                                    </li>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <p style="color: red" ng-show="showError.all && !choosenCountry"><fmt:message key="provider.register.e.country" bundle="${lang}"/></p>
                                                    <p ng-show="showError.all">
                                                        <span style="color: red" ng-show="signupForm.city.$error.required"><fmt:message key="provider.register.e.city" bundle="${lang}"/><br/></span>
                                                        <span style="color: red" ng-show="signupForm.city.$error.maxlength">City length must be less than 30 characters!<br/></span>
                                                    </p>

                                                </div>
                                                <div class="rr-bea">
                                                    <input type="text" ng-model="register.address" name="address" maxlength="200" ng-maxlength="200"
                                                           class="blueInput normalFont" id="address" placeholder="<fmt:message key="provider.register.address" bundle="${lang}"/>" required>
                                                    <p ng-show="showError.all">
                                                        <span style="color: red" ng-show="signupForm.address.$error.required"><fmt:message key="provider.register.e.address" bundle="${lang}"/><br/></span>
                                                        <span style="color: red" ng-show="signupForm.address.$error.maxlength"><fmt:message key="provider.register.e.addressLength" bundle="${lang}"/><br/></span>
                                                    </p>
                                                </div>
                                                <div class="rr-bea ">
                                                    <div class="row">
                                                        <div class="col-xs-6" style="padding-right: 2px">
                                                            <input ng-click="openTimeClock('openTime')"  readonly type="text" ng-model= "register.openTime" name="openTime" maxlength="15" ng-maxlength="15"
                                                                   class="blueInput normalFont clock-input" id="openTime" placeholder="<fmt:message key="provider.register.openingTime" bundle="${lang}"/>" required>
                                                        </div>
                                                        <div class="col-xs-6" style="padding-left: 2px">
                                                            <input ng-click="openTimeClock('closeTime')" readonly ng-model="register.closeTime" type="text" name="closeTime" maxlength="15" ng-maxlength="15"
                                                                   class="blueInput normalFont clock-input" id="closeTime" placeholder="<fmt:message key="provider.register.closingTime" bundle="${lang}"/>" required>
                                                            <!--<span ng-show="!isValidDate" style="right:30px" class="inValidIcon"></span>-->

                                                        </div>
                                                        <span style="color: red" ng-show="showError.all && !validateTimes"><fmt:message key="provider.register.e.time" bundle="${lang}"/><br/></span>
                                                        <div class="popover clockpicker-popover bottom clockpicker-align-right" id="provider-signup-clock">
                                                            <div class="clearfix">
                                                                <div class="provider-clock-input">
                                                                    <p><fmt:message key="provider.register.hour" bundle="${lang}"/></p>

                                                                </div>
                                                                <div class="provider-clock-input-separate">
                                                                    &nbsp;
                                                                </div>
                                                                <div class="provider-clock-input">
                                                                    <p><fmt:message key="provider.register.minute" bundle="${lang}"/></p>

                                                                </div>
                                                            </div>
                                                            <div class="clearfix">
                                                                <div class="provider-clock-input">
                                                                    <select ng-model="providerPickHour" class="blueInput normalFont" ng-change="choosenHour()">
                                                                        <option disabled value="" selected>HH</option>
                                                                        <option value="{{hour}}" ng-repeat="hour in hourArray" >
                                                                            {{hour}}
                                                                        </option>
                                                                    </select>
                                                                </div>
                                                                <div class="provider-clock-input-separate">
                                                                    <p>:</p>
                                                                </div>
                                                                <div class="provider-clock-input">

                                                                    <select ng-model="providerPickMinute" id="minute-provider-signup" class="blueInput normalFont" ng-change="choosenMinute()">
                                                                        <option disabled value="" selected>mm</option>
                                                                        <option value="{{minute}}" ng-repeat="minute in minuteArray" ng-selected="providerPickMinute === minute">
                                                                            {{minute}}
                                                                        </option>
                                                                    </select>

                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <p ng-show="showError.all">
                                                        <span style="color: red" ng-show="signupForm.openTime.$error.required || invalidStartTime"><fmt:message key="provider.register.e.openTime" bundle="${lang}"/><br/></span>
                                                    </p>
                                                    <p ng-show="showError.all">
                                                        <span style="color: red" ng-show="signupForm.closeTime.$error.required || invalidCloseTime"><fmt:message key="provider.register.e.closeTime" bundle="${lang}"/><br/></span>
                                                    </p>
                                                </div>


                                                <div class="rr-bea">                                            
                                                    <input type="text" ng-model="register.phone" name="phone" class="blueInput normalFont" ng-maxlength="15" maxlength="15"
                                                           id="phone" placeholder="<fmt:message key="provider.register.mobileNumber" bundle="${lang}"/>" required numbers-only>                                            
                                                    <p style="color: red" ng-show="showError.all && !signupForm.phone.$valid"><fmt:message key="provider.register.e.phoneNumber" bundle="${lang}"/></p>
                                                </div>
                                                <div class="rr-bea ">
                                                    <div class="row">
                                                        <div class="col-xs-6" style="padding-right: 2px">
                                                            <input type="text" ng-model="register.firstName" name="firstName" maxlength="15" ng-maxlength="15"
                                                                   class="blueInput normalFont" id="firstName" placeholder="<fmt:message key="provider.register.firstName" bundle="${lang}"/>" required>
                                                        </div>
                                                        <div class="col-xs-6" style="padding-left: 2px">
                                                            <input ng-model="register.lastName" type="text" name="lastName" maxlength="15" ng-maxlength="15"
                                                                   class="blueInput normalFont" id="lastName" placeholder="<fmt:message key="provider.register.lastName" bundle="${lang}"/>" required>
                                                        </div>
                                                    </div>
                                                    <p ng-show="showError.all">
                                                        <span style="color: red" ng-show="signupForm.firstName.$error.required"><fmt:message key="provider.register.e.firstName" bundle="${lang}"/><br/></span>
                                                        <span style="color: red" ng-show="signupForm.firstName.$error.maxlength"><fmt:message key="provider.register.e.firstNameLength" bundle="${lang}"/><br/></span>
                                                    </p>
                                                    <p ng-show="showError.all">
                                                        <span style="color: red" ng-show="signupForm.lastName.$error.required"><fmt:message key="provider.register.e.lastName" bundle="${lang}"/><br/></span>
                                                        <span style="color: red" ng-show="signupForm.lastName.$error.maxlength"><fmt:message key="provider.register.e.lastNameLength" bundle="${lang}"/><br/></span>
                                                    </p>
                                                </div>
                                                <div class="rr-bea">
                                                    <input type="text" name="displayName" ng-model="register.displayName" maxlength="20" ng-maxlength="20"
                                                           class="blueInput normalFont" id="displayName" placeholder="<fmt:message key="provider.register.displayName" bundle="${lang}"/>" required>
                                                    <p ng-show="showError.all">
                                                        <span style="color: red" ng-show="signupForm.displayName.$error.required"><fmt:message key="provider.register.e.displayName" bundle="${lang}"/><br/></span>
                                                        <span style="color: red" ng-show="signupForm.displayName.$error.maxlength"><fmt:message key="provider.register.e.displayNameLength" bundle="${lang}"/><br/></span>
                                                    </p>
                                                </div>
                                                <div class="rr-bea">
                                                    <input type="text" name="jobTitle" ng-model="register.jobTitle" maxlength="20" ng-maxlength="20"
                                                           class="blueInput normalFont" id="jobTitle" placeholder="<fmt:message key="provider.register.jobTitle" bundle="${lang}"/>" required>
                                                    <p ng-show="showError.all">
                                                        <span style="color: red" ng-show="signupForm.jobTitle.$error.required"><fmt:message key="provider.register.e.job" bundle="${lang}"/><br/></span>
                                                        <span style="color: red" ng-show="signupForm.jobTitle.$error.maxlength"><fmt:message key="provider.register.e.jobLength" bundle="${lang}"/><br/></span>
                                                    </p>
                                                </div>
                                                <div class="rr-bea">
                                                    <input type="text" ng-model="register.email" name="email" maxlength="100" ng-maxlength="100"
                                                           ng-change="validateEmail()"
                                                           class="blueInput normalFont" id="email" placeholder="<fmt:message key="provider.register.emailAddress" bundle="${lang}"/>" required>

                                                    <span ng-show="(showError.emailValid || showError.all) && !emailLoading">
                                                        <span ng-show="!missing.emailValid && signupForm.email.$valid && missing.emailRegex" style="color: red"><fmt:message key="provider.register.e.email" bundle="${lang}"/></span>
                                                        <span ng-show="missing.emailValid && signupForm.email.$valid && missing.emailRegex" class="validIcon"></span>
                                                        <span ng-hide="missing.emailRegex" class="inValidIcon"></span>
                                                    </span>
                                                </div>
                                                <div class="rr-bea">
                                                    <input type="text" ng-model="register.reEmail" name="reEmail" 
                                                           ng-model-options="{debounce: 1000}" ng-change="validateEmail()"
                                                           class="blueInput normalFont" id="reEmail" placeholder="<fmt:message key="provider.register.reEmailAddress" bundle="${lang}"/>" required>
                                                    <span ng-show="showError.matchEmail && missing.emailValid && signupForm.email.$valid && missing.emailRegex">
                                                        <span ng-show="missing.matchEmail" class="validIcon"></span>
                                                        <span ng-show="!missing.matchEmail" class="inValidIcon"></span>
                                                    </span>
                                                </div>

                                                <div class="rr-bea">
                                                    <%--fake autofill email input--%>
                                                    <input type="text" style="position: absolute; left: -999em; ">
                                                    <input type="password" ng-model="register.password" name="password"  maxlength="32" ng-minlength="8" ng-maxlength="32"
                                                           class="blueInput normalFont" id="password" 
                                                           ng-model-options="{debounce: 1000}" ng-change="validatePassword()"
                                                           placeholder="<fmt:message key="provider.register.password" bundle="${lang}"/>" required>
                                                    <p style="color: red" ng-show="showError.all && (signupForm.password.$error.minlength
                                                                            || signupForm.password.$error.maxlength)">
                                                        <fmt:message key="provider.register.e.password" bundle="${lang}"/>
                                                    </p>
                                                </div>
                                                <div class="rr-bea">
                                                    <input type="password" ng-model="register.rePassword" name="rePassword" 
                                                           ng-model-options="{debounce: 1000}" ng-change="validatePassword()"
                                                           class="blueInput normalFont" id="rePassword" placeholder="<fmt:message key="provider.register.retypePassword" bundle="${lang}"/>" required>
                                                    <span ng-show="showError.matchPassword">
                                                        <span ng-show="missing.matchPassword" class="validIcon"></span>
                                                        <span ng-show="!missing.matchPassword" class="inValidIcon"></span>
                                                    </span>
                                                </div>



                                                <div class="rr-bea">
                                                    <div class="youtripper-captcha" >
                                                        <div id="slider"></div>    
                                                    </div>
                                                </div>

                                                <div class="rr-bea">
                                                    <div class="submitProvider" > 
                                                        <button type="submit" class="btn-width-orange"><fmt:message key="provider.register.submit" bundle="${lang}"/></button>   
                                                    </div> 
                                                </div>

                                                <div>
                                                    <p class="policyContent">
                                                        <fmt:message key="provider.register.agreeCondition" bundle="${lang}"/> 
                                                    </p>
                                                </div>
                                                <div  ng-hide="isShowSalesman" style="margin-bottom:5px;">
                                                    <p class="salesmanReg">
                                                        <fmt:message key="provider.register.clickSalesman" bundle="${lang}"/> 
                                                    </p>
                                                </div>
                                                <div class="rr-bea" ng-show="isShowSalesman">
                                                    <input type="text" ng-model="register.referralCode" name="referralCode"
                                                           class="blueInput normalFont" placeholder="<fmt:message key="provider.register.inputSalesman" bundle="${lang}"/> ">
                                                    <span ng-show="showError.salesCode && missing.salesCode">
                                                        <span style="color: red"><fmt:message key="provider.register.e.salesID" bundle="${lang}"/></span>
                                                    </span>
                                                </div>
                                            </form>
                                        </div> 
                                    </div>
                                </div>
                                <div class="col-xs-6" style="left:10%;">
                                    <div class="signup-content">
                                        <h1><fmt:message key="provider.register.descriptionTitle" bundle="${lang}"/></h1>

                                        <p style="line-height: 19px;
                                           font-size: 16px;
                                           margin-bottom: 10px;
                                           ">
                                            <fmt:message key="provider.register.descriptionPart1" bundle="${lang}"/>
                                            <br><br>
                                            <fmt:message key="provider.register.descriptionPart2" bundle="${lang}"/>
                                            <br><br>
                                            <fmt:message key="provider.register.descriptionPart3" bundle="${lang}"/>
                                            <br><br>
                                            <fmt:message key="provider.register.descriptionPart4" bundle="${lang}"/>
                                        </p>
                                        <div class="rr-bea" style="font-size:16px;">
                                            <fmt:message key="provider.register.supportFacebook" bundle="${lang}"/> &nbsp;  

                                        </div>
                                        <div class="rr-bea" style="margin-bottom:20px;">
                                            <div class="fb-like" data-href="https://www.facebook.com/Youtripper-466412116883772/?fref=ts" data-layout="box_count" data-action="like" data-size="small" data-show-faces="true" data-share="false"></div>

                                        </div>

                                        <div style="display: none" class="signup-icon">
                                            <img src="<c:url value="/Resources/Theme/image/trust.svg"/>"/>
                                            <p>Trust & Safety</p>
                                        </div>
                                        <div style="display: none" class="signup-icon">
                                            <img src="<c:url value="/Resources/Theme/image/secure.svg"/>"/>
                                            <p>Secure payment</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--            <div class="wrapper">
                            <h1>Provider Page</h1>
                            <div id="signup">
                                <form method="POST" action="<c:url value="/Common/Provider/Register"/>" class="form-horizontal" name="signupForm" 
                                      ng-submit="validateRegisterForm($event)" novalidate>
                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <button type="submit" class="btn btn-default">Sign up</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>-->
        </div>
        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js?99"/>"></script>
        <script>
                                                        function validate(evt) {
                                                            var theEvent = evt || window.event;
                                                            var key = theEvent.keyCode || theEvent.which;
                                                            key = String.fromCharCode(key);
                                                            var regex = /[0-9]|\./;
                                                            if (!regex.test(key)) {
                                                                theEvent.returnValue = false;
                                                                if (theEvent.preventDefault)
                                                                    theEvent.preventDefault();
                                                            }
                                                        }

                                                        $(document).ready(function () {
                                                            $('#slider').sliderCaptcha({
                                                                hintText: '<fmt:message key="provider.register.swipeToVerify" bundle="${lang}"/>',
                                                                hintTextAfterUnlock: '<fmt:message key="provider.register.verified" bundle="${lang}"/>'
                                                            });
                                                        });

                                                        var form = ${requestScope.form};
                                                        form.businesses[0].type = '<fmt:message key="provider.register.businessType1" bundle="${lang}"/>';
                                                        form.businesses[1].type = '<fmt:message key="provider.register.businessType2" bundle="${lang}"/>';
                                                        form.businesses[2].type = '<fmt:message key="provider.register.businessType3" bundle="${lang}"/>';
                                                        form.businesses[3].type = '<fmt:message key="provider.register.businessType4" bundle="${lang}"/>';
                                                        var checkEmailUrl = '<c:url value="/Common/checkEmail"/>';
                                                        var checkBusinessName = '<c:url value="/Common/checkBusinessName"/>';
                                                        var checkUsernameURL = '<c:url value="/Common/checkUsernameURL"/>';
                                                        var checkSalesCode = '<c:url value="/Common/checkSalesCode"/>';
                                                        var businessType = '${param.businessType}';
                                                        var businessName = '${param.businessName}';
                                                        // var usernameURL = '${param.usernameURL}';
                                                        var country = '${param.country}';
                                                        var city = '${param.city}';
                                                        var address = '${param.address}';
                                                        var phone = '${param.phone}';
                                                        var phoneCode = '${param.phoneCode}';
                                                        var firstName = '${param.firstName}';
                                                        var lastName = '${param.lastName}';
                                                        var jobTitle = '${param.jobTitle}';
                                                        var email = '${param.email}';
                                                        $(document).ready(function () {
                                                            SpinnerText.init('ul[data-spinner]');

                                                            new toggleHeader.init({
                                                                toggleControl: false
                                                            });
                                                        });

                                                        //Check browser support texthint/placeholder or not
                                                        //This code for fixed placeholder not support on IE9
                                                        if (!ElementSupportAttribute('input', 'placeholder')) {
                                                            $("input[placeholder]").each(function () {
                                                                var $input = $(this);
                                                                $input.after('<input id="' + $input.attr('id') + '-faux" style="display:none;" type="text" value="' + $input.attr('placeholder') + '" />');
                                                                var $faux = $('#' + $input.attr('id') + '-faux');

                                                                $faux.show().attr('class', $input.attr('class')).attr('style', $input.attr('style'));
                                                                $input.hide();

                                                                $faux.focus(function () {
                                                                    $faux.hide();
                                                                    $input.show().focus();
                                                                });

                                                                $input.blur(function () {
                                                                    if ($input.val() === '') {
                                                                        $input.hide();
                                                                        $faux.show();
                                                                    }
                                                                });
                                                            });
                                                        }

                                                        function ElementSupportAttribute(elm, attr) {
                                                            var test = document.createElement(elm);
                                                            return attr in test;
                                                        }
        </script>
        <script src="<c:url value="/Resources/Theme/js/youtripper.js"/>"></script>

        <div id="fb-root"></div>
        <script>(function (d, s, id) {
                                                            var js, fjs = d.getElementsByTagName(s)[0];
                                                            if (d.getElementById(id))
                                                                return;
                                                            js = d.createElement(s);
                                                            js.id = id;
                                                            js.src = "//connect.facebook.net/en_GB/sdk.js#xfbml=1&version=v2.7&appId=295105870823227";
                                                            fjs.parentNode.insertBefore(js, fjs);
                                                        }(document, 'script', 'facebook-jssdk'));</script>
    </body>
</html>
