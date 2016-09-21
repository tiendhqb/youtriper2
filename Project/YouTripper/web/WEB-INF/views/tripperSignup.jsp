<%-- 
    Document   : providerLogin
    Created on : Oct 16, 2015, 11:38:39 AM
    Author     : Nick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html id="sign-up-page">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=1366">
        <!--        <meta name="viewport" content="width=device-width, initial-scale=1">-->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!--<script src='https://www.google.com/recaptcha/api.js'></script>-->
        <script src="https://www.google.com/recaptcha/api.js?onload=vcRecaptchaApiLoaded&render=explicit" async defer></script>
        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css?999999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css?999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style-login.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/slider-captcha.css"/>" >
        <%@ include file="angular.jsp" %>
        <script src="<c:url value="/Resources/Theme/js/angular.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/angular-recaptcha.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/checklist-model.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/ng-file-upload-shim.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/ng-file-upload.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/paging.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.ui.touch-punch-improved.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/slider-captcha.min.js"/>"></script>
        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >
        <title>YouTripper - Tripper signup page</title>
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
        <div class="pagesearch" ng-app="YouTripper" ng-controller="BeTripperController">
            <%@ include file="header.jsp" %>

            <div class="center_form">  
                <div class="red-title">
                    Tripper Signup
                </div>

                <div class="form-body">
                    <form method="POST" action="
                          <c:choose>
                              <c:when test="${empty param.language}">
                                  <c:url value="/Common/Tripper/Register"/>
                              </c:when>
                              <c:otherwise>
                                  <c:url value="/Common/Tripper/Register?language=${param.language}"/>
                              </c:otherwise>
                          </c:choose>" 
                          class="form-horizontal ytForm" name="signupForm" 
                          ng-submit="validateRegisterForm($event)" novalidate>
                        <div class="form-input">
                            <span class="form-label">First name</span>
                            <input type="text" ng-model="register.firstName" name="firstName" maxlength="10" ng-maxlength="10"
                                   class="blueInput normalFont" id="firstName" placeholder="Your First Name (max length: 10 characters)" required>
                            <p ng-show="showError.all">
                                <span style="color: red" ng-show="signupForm.firstName.$error.required">First name is required!<br/></span>
                                <span style="color: red" ng-show="signupForm.firstName.$error.maxlength">First name length must be less than 10 characters!<br/></span>
                            </p>
                        </div>
                        <div class="form-input">
                            <span class="form-label">Last name</span>
                            <input ng-model="register.lastName" type="text" name="lastName" maxlength="10" ng-maxlength="10"
                                   class="blueInput normalFont" id="lastName" placeholder="Your Last Name (max length: 10 characters)" required>
                            <p ng-show="showError.all">
                                <span style="color: red" ng-show="signupForm.lastName.$error.required">Last name is required!<br/></span>
                                <span style="color: red" ng-show="signupForm.lastName.$error.maxlength">Last name length must be less than 10 characters!<br/></span>
                            </p>
                        </div>
                        <div class="form-input">
                            <span class="form-label">Email</span>
                            <input type="text" ng-model="register.email" name="email" ng-maxlength="100" class="blueInput normalFont" id="email" placeholder="Your Email" required>
                            <span ng-show="(showError.emailValid || showError.all) && !emailLoading">
                                <span ng-show="missing.emailValid && signupForm.email.$valid && missing.emailRegex" style="color: green">Email is valid!</span>
                                <span ng-show="!missing.emailValid && signupForm.email.$valid && missing.emailRegex" style="color: red">Email is exist!</span>
                                <span ng-hide="missing.emailRegex" style="color: red">Email is not correct!</span>
                            </span>
                        </div>
                        <div class="form-input">
                            <span class="form-label">Password</span>
                            <input type="password" ng-model="register.password" name="password" 
                                   ng-model-options="{debounce: 1000}" ng-change="validatePassword()"
                                   class="blueInput normalFont" id="password" placeholder="Please enter a password (8-32 Characters)"  ng-minlength="8" ng-maxlength="32" required>
                            <p style="color: red" 
                               ng-show="showError.all && (signupForm.password.$error.minlength
                                                       || signupForm.password.$error.maxlength)">Password length must be between 8 and 32 characters</p>
                        </div>
                        <div class="form-input">
                            <span class="form-label">Retype Password</span>
                            <input type="password" d ng-model="register.rePassword" name="rePassword"
                                   ng-model-options="{debounce: 1000}" ng-change="validatePassword()"
                                   class="blueInput normalFont" id="rePassword" placeholder="Please retype your password" required>
                            <span ng-show="showError.matchPassword">
                                <span ng-show="missing.matchPassword" style="color: green">Match</span>
                                <span ng-show="!missing.matchPassword" style="color: red">Not Match</span>
                            </span>
                        </div>
                        <div class="form-input">
                            <div id="slider"></div>    
                        </div>
                        <div class="form-input">
                            <div class="submitProvider"><button type="submit" class="btn-width-orange">Sign up</button></div>
                        </div>
                </div>
                </form>
            </div>

        </div>
        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js?99"/>"></script>
        <script>
                                    $(document).ready(function () {
                                        $('#slider').sliderCaptcha({
                                            hintText: 'Swipe to Verify',
                                            hintTextAfterUnlock: 'Verified'
                                        });
                                    })
                                    var checkEmailUrl = '<c:url value="/Common/checkEmail"/>';
                                    var firstName = '${param.firstName}';
                                    var lastName = '${param.lastName}';
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
        <script src="<c:url value="/Resources/Theme/js/youtripper.js?9999999999999999999999999999999999999999999999999999999999"/>"></script>
    </body>
</html>
