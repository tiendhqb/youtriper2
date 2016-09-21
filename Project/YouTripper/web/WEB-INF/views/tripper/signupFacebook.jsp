<%-- 
    Document   : signupFacebook
    Created on : May 12, 2016, 10:19:54 AM
    Author     : Tien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
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
        <title>YouTripper - Tripper signup facebook page</title>
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
            <div style="position: fixed; top: 0; bottom: 0; left: 0; right: 0; background: #fff; z-index: 99999" ng-show="loading">
                <div class="youtripper-spinner" ></div>
            </div>
            <div ng-cloak ng-hide="loading" class="">
                <%@ include file="../header.jsp" %>
                <div class="padding-header">
                    <div class="container" style="width:930px">
                        <div class="form-bea">
                            <div id="signup">
                                <form method="POST" 
                                      action="
                                      <c:choose>
                                          <c:when test="${empty param.language}">
                                              <c:url value="/Common/Tripper/Register"/>
                                          </c:when>
                                          <c:otherwise>
                                              <c:url value="/Common/Tripper/Register?language=${param.language}"/>
                                          </c:otherwise>
                                      </c:choose>" 
                                      class="form-horizontal" name="signupForm" 
                                      ng-submit="validateRegisterForm($event)" novalidate>
                                    <div class="rr-bea">
                                        <input type="text" ng-model="register.firstName" name="firstName" maxlength="10" ng-maxlength="10"
                                               class="form-control normalFont" id="firstName" placeholder="First name (Length: 1 ~ 10)" required>

                                    </div>

                                    <div class="rr-bea">
                                        <input type="text" ng-model="register.email" name="email" ng-maxlength="100" class="form-control normalFont" id="email" placeholder="Your email" required>

                                    </div>
                                    <div class="rr-bea">
                                        <input type="password" ng-model="register.password" name="password" 
                                               class="form-control normalFont" id="password" placeholder="Password (Length: 10 ~ 32)"  ng-minlength="10" ng-maxlength="32" required>
                                        <p style="color: red" ng-show=" signupForm.password.$error.minlength || signupForm.password.$error.maxlength">Password length must be between 10 and 32 characters</p>
                                    </div>
                                    <div class="rr-bea">
                                        <input type="password" d ng-model="register.rePassword" name="rePassword"
                                               class="form-control normalFont" id="rePassword" placeholder="Retype your password" required>
                                        <span ng-show="showError.matchPassword">
                                            <span ng-show="missing.matchPassword" style="color: green">Match</span>
                                            <span ng-show="!missing.matchPassword" style="color: red">Not Match</span>
                                        </span>
                                    </div>

                                    <button type="submit" class="btn btn-apply">Sign up</button>
                                </form>
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
            <%@ include file="../footer.jsp" %>
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


        </script>
        <script src="<c:url value="/Resources/Theme/js/youtripper.js?9999999999999999999999999999999999999999999999999999999999"/>"></script>
    </body>
</html>
