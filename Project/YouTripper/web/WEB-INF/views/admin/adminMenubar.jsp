<%-- 
    Document   : providerMenubar
    Created on : Nov 5, 2015, 6:17:42 PM
    Author     : Nick
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="affix-sidebar" ng-app="YouTripper" ng-controller="AdminMenubar">
    <!--DEVELOPING POPUP-->
    <div class="ytPopup" id="developingBox"  >
        <div class="tbl-cell" ng-controller="DevelopingControler">
            <div class="popupContent" >
                <div class="center-informBlock blur-backgroud" ng-show="!sendInfo">
                        <div class="small-spinner" ></div>
                </div>
                <span class="box-closing" ng-click="toggleDevelopingBox()"></span>
                <div class="popupScroll">
                    <div style="text-align: center">
                        <p style="font-size: 20px">
                            Join My Newsletter 
                        </p>
                        <p style="margin-top: 10px">
                            Thank you for visiting the youtripper website. Unfortunately the feature you are interested in is currently under construction. 
                        </p>
                        <p style="margin-top: 10px">    
                            Please support changing the travel industry us and follow our facebook or sign up to our email newsletter to find out about the latest developments. 
                        </p>
                        <p style="margin-top: 10px">
                            Stay tuned and thank you for your support. 
                        </p>
                    </div>
                    <div class="row">
                        <div class="col-xs-12" style="margin-top: 15px;  text-align: center">
                            <a target="_blank" href="https://www.facebook.com/Youtripper-466412116883772">
                                <button style="width: 250px;" class="btn-width-orange login_fb button">Go to Facebook fanpage</button>
                            </a>
                        </div>
                    </div>
                    <div ng-show="!sendDone" class="row" style="margin-top: 15px;">
                        <div class="col-xs-8">
                            <input type="text" ng-model="email" maxlength="100" ng-maxlength="100"
                                   class="blueInput normalFont" placeholder="Enter Your Email">
                        </div>
                        <div class="col-xs-4" style="height:40px; line-height: 35px">
                            <a href="" ng-click="submitEmail()" class="btn-width-orange">Submit</a>
                        </div>
                    </div>
                    <span ng-show="(showError.emailValid || showError.all) && !emailLoading && !sendDone">
                        <span ng-show="missing.emailValid && missing.emailRegex" style="color: green">Email is valid!</span>
                        <span ng-show="!missing.emailValid && missing.emailRegex" style="color: red">Email is exist!</span>
                        <span ng-hide="missing.emailRegex" style="color: red">Email is not correct!</span>
                    </span>
                    <div class="row">
                        <div class="col-xs-12" style="margin-top: 15px; text-align: center">
                            <span  ng-show="sendDone" style="color: green">Join My Newsletter Successfully </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!--END DEVELOPING POPUP-->
    <div class="page-user-profile page-provider-profile">
        <div class="tabs-user-profile">
            <!-- Nav tabs -->
            <div class="user-profile-caption">
                <div id="providerBar">
                    <ul>
                        <!--                    <li class="user_icon3" ng-class="{'active' : (page === 'createdPackages')}" >
                                                <a href="<c:url value="/Admin/CreatedPackage"/>" aria-controls="step3" role="tab" data-toggle="tab">
                                                    <span></span>Packages
                                                </a>
                                            </li>-->
                        <li class="user_icon3" ng-class=""  >
                            <a  aria-controls="step3" role="tab" data-toggle="tab" ng-click="toggleDevelopingBox()">
                                <span></span>Packages
                            </a>
                        </li>
                        <!--                    <li class="user_icon4" ng-class="{'active' : (page === 'PaymentPage')}">
                                                <a href="<c:url value="/Admin/PaymentManagement"/>" aria-controls="step4" role="tab" data-toggle="tab"><span></span>Payment</a>
                                            </li>-->
                        <li class="user_icon4" ng-class="" >
                            <a  aria-controls="step4" role="tab" data-toggle="tab" ng-click="toggleDevelopingBox()"><span></span>Payment</a>
                        </li>
                        <!--                    <li class="user_icon4" ng-class="{'active' : (page === 'editingPackages')}">
                                                <a href="<c:url value="/Admin/EditingPackages"/>" aria-controls="step4" role="tab" data-toggle="tab">
                                                    <span></span>Editing
                                                </a>
                                            </li>-->
                        <li class="user_icon4" ng-class="">
                            <a ng-click="toggleDevelopingBox()" aria-controls="step4" role="tab" data-toggle="tab">
                                <span></span>Editing
                            </a>
                        </li>
                        <li class="user_icon4" ng-class="{'active' : (page === 'CreateSalesman')}">
                            <a href="<c:url value="/Admin/SalesmanSignupPage"/>" aria-controls="step4" role="tab" data-toggle="tab"><span></span>Salesman Registration</a>
                        </li>     
                        <li class="user_icon4" ng-class="{'active' : (page === 'SalesmanManagement')}">
                            <a href="<c:url value="/Admin/SalesmanManagement"/>" aria-controls="step4" role="tab" data-toggle="tab"><span></span>Salesman Management</a>
                        </li>    
                        <li class="user_icon4" ng-class="{'active' : (page === 'Certificate')}">
                            <a href="<c:url value="/Admin/ManageCertificate"/>" aria-controls="step4" role="tab" data-toggle="tab"><span></span>Certificates</a>
                        </li> 
                        <!--                    <li class="user_icon4" ng-class="">
                                                <a ng-click="toggleDevelopingBox()" aria-controls="step4" role="tab" data-toggle="tab"><span></span>Certificates</a>
                                            </li> -->
                        <li class="user_icon4" ng-class="{'active' : (page === 'createdPassports')}" >
                            <a href="<c:url value="/Admin/CreatedPassport"/>" aria-controls="step4" role="tab" data-toggle="tab">
                                <span></span>Passports
                            </a>
                        </li>
                        <!--                     <li class="user_icon4" ng-class="" >
                                                <a ng-click="toggleDevelopingBox()" aria-controls="step4" role="tab" data-toggle="tab">
                                                    <span></span>Passports
                                                </a>
                                            </li>-->
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
