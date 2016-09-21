<%-- 
    Document   : adminLogin
    Created on : Oct 20, 2015, 3:39:11 PM
    Author     : Nick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html id="change-password">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=1366">
        <!--        <meta name="viewport" content="width=device-width, initial-scale=1">-->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="">
        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >

        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">
        <%@ include file="angular.jsp" %>
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css?999999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css?999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css?9999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css?9999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style-login.css?9999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style-addon.css?999999999999"/>" >

        <script src="<c:url value="/Resources/Theme/js/angular.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/angular-recaptcha.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/checklist-model.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/ng-file-upload-shim.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/ng-file-upload.min.js"/>"></script>

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>

        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>

        <title>YouTripper - Add new password</title>

    </head>
    <body>
        <div ng-app="YouTripper" ng-controller="InsertNewPassword" class="pagesearch">
            <%@ include file="header.jsp" %>
            <!--            <div class="tab-content">
                            <form method="POST" action="<c:url value="/Common/AddNewPassword"/>" id="ChangePassForm"  name="ChangePassForm" ng-submit="validateAddPassword($event)">
                                <input type="hidden" value="${requestScope.token}" name="token" />
                                <input ng-model="change.password" name="newPass" type="password" value="" placeholder="New password" class="normalFont blueInput" ng-minlength="10" ng-maxlength="32" required/>
            
                                <span ng-show="showError.all && ChangePassForm.newPass.$error.minlength" style="color: red">  New Password can not less than 10 characters</span>    
                                <span ng-show="showError.all && ChangePassForm.newPass.$error.maxlength" style="color: red">  New Password can not more than 32 characters</span>    
            
                                <input ng-model="change.rePassword" name="reNewPass" type="password" placeholder="Retype password" class="normalFont blueInput" value="" />     
                                <span style="float:left" ng-show="showError.matchPassword">
                                    <span ng-show="missing.matchPassword" style="color: green">  Match</span>
                                    <span ng-show="!missing.matchPassword" style="color: red">  Not Match</span>
                                </span>
                                <button type="submit" class="btn-width-orange">Save</button>
                            </form>
                        </div>-->
            <div class="center_form">  
                <div class="red-title">
                    Add Your Password
                </div>

                <div class="form-body">
                    <form method="POST" 
                          action="
                          <c:choose>
                              <c:when test="${empty param.language}">
                                  <c:url value="/Common/AddNewPassword"/>
                              </c:when>
                              <c:otherwise>
                                  <c:url value="/Common/AddNewPassword?language=${param.language}"/>
                              </c:otherwise>
                          </c:choose>" 
                          class="ytForm"
                          id="ChangePassForm"  name="ChangePassForm" ng-submit="validateAddPassword($event)" novalidate> 
                        <input type="hidden" value="${requestScope.token}" name="token" />
                        <!--<p>New password</p>-->
                        <div class="form-input">
                            <span>New password</span>
                            <input ng-model="change.password" class="normalFont blueInput"

                                   name="newPass" type="password" value="" placeholder="New password"/>
                            <span ng-show="change.password.length < 8 && showError.all" style="color: red">New Password can not be less than 8 characters</span>    
                        </div>
                        <!--<p>Retype password</p>-->
                        <div class="form-input">
                            <span>Retype password</span>
                            <input ng-model="change.rePassword" class="normalFont blueInput"  

                                   name="reNewPass" type="password" value="" placeholder="Retype password"/>     
                            <div ng-show="showError.matchPassword">
                                <p ng-show="missing.matchPassword" style="color: green">Match</p>
                                <p ng-show="!missing.matchPassword" style="color: red">Not Match</p>
                            </div>
                        </div>

                        <div class="form-input">

                            <button type="submit" class="btn-width-orange">Save</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js?99"/>"></script>
        <script>

                                    var page = '${requestScope.page}';

                                    $(document).ready(function () {
                                        toggleHeader.init({
                                            toggleControl: false
                                        });

                                    });
                                    $(document).ready(function () {
                                        new toggleHeader.init({
                                            toggleControl: false
//                                            toggleTheme: true
                                        });
                                    });
        </script>
    </body>
</html>
