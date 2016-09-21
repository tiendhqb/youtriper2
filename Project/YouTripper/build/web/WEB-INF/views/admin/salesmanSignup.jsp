<%-- 
    Document   : providerLogin
    Created on : Oct 16, 2015, 11:38:39 AM
    Author     : Nick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="background-provider" id="createSalesman">
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
        <%@ include file="../angular.jsp" %>
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
        <title>YouTripper - Salesman register page</title>
    </head>
    <body class="background-provider">
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
        <div class="pagesearch" ng-app="YouTripper" ng-controller="CreateSalesController">
            <%@ include file="../header.jsp" %>
            <%@ include file="adminMenubar.jsp" %>

            <div class="affix-content">

                <div class="form-bea">
                    <div id="signup" style="width:540px;margin: 0 auto;">
                        <form method="POST" action="<c:url value="/Admin/SalesmanRegister"/>" class="form-horizontal" name="signupForm" 
                              ng-submit="validateRegisterForm($event)" novalidate>
                            <div class="login-form-input">
                                <input type="text" ng-model="register.firstName" name="firstName" maxlength="10" ng-maxlength="10"
                                       class="normalFont blueInput" id="firstName" placeholder="First name (Length: 1 ~ 10)">

                            </div>
                            <div class="login-form-input">
                                <input ng-model="register.lastName" type="text" name="lastName" maxlength="10" ng-maxlength="10"
                                       class="normalFont blueInput" id="lastName" placeholder="Last name (Length: 1 ~ 10)">

                            </div>
                            <div class="login-form-input">                                            
                                <input type="text" ng-model="register.phoneNumber" name="phoneNumber" class="normalFont blueInput" ng-maxlength="15" maxlength="15"
                                       ng-pattern="onlyNumbers" id="phoneNumber" placeholder="Mobile phone (Code)" required>                                            
                                <span ng-show="(showError.phoneNumber || showError.all) && !phoneNumberLoading">
                                    <span style="color: red" ng-show="showError.all && !signupForm.phoneNumber.$valid">Phone number is required!<br/></span>
                                    <span ng-show="!missing.phoneNumber && signupForm.phoneNumber.$valid" style="color: green">Phone number is valid!</span>
                                    <span ng-show="missing.phoneNumber && signupForm.phoneNumber.$valid" style="color: red">Phone number is exist!</span>
                                </span>
                            </div>
                            <div class="login-form-input">
                                <input type="text" ng-model="register.email" name="email" ng-maxlength="100" class="normalFont blueInput" id="email" placeholder="Email address">

                            </div>
                            <div class="login-form-input" style="margin-top:30px;">
                                <input type="submit" name="login" value="Create Salesman" class="btn-width-orange" />
                            </div>
                        </form>
                    </div>
                </div>
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
                                    });
                                    var checkMobileNumber = '<c:url value="/Admin/checkMobileNumber"/>';
                                    var firstName = '${param.firstName}';
                                    var lastName = '${param.lastName}';
                                    var email = '${param.email}';
                                    $(document).ready(function () {
                                        SpinnerText.init('ul[data-spinner]');

                                        new toggleHeader.init({
                                            toggleControl: false
                                        });
                                    });

                                    var page = "CreateSalesman"

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
