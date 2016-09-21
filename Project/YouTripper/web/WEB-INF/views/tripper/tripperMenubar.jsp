<%-- 
    Document   : providerMenubar
    Created on : Nov 5, 2015, 6:17:42 PM
    Author     : Nick
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="affix-sidebar" ng-app="YouTripper" ng-controller="TripperMenubar">
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
            <div class="user-profile-caption  ">
                <div id="providerBar" >
                    <ul>
                        <li class="user_icon1" ng-class="{'active' : (page === 'Info')}">
                            <a href="
                               <c:choose>
                                   <c:when test="${empty param.language}">
                                       <c:url value="/Tripper/AccountInfo"/>
                                   </c:when>
                                   <c:otherwise>
                                       <c:url value="/Tripper/AccountInfo?language=${param.language}"/>
                                   </c:otherwise>
                               </c:choose>" 
                               aria-controls="step1" role="tab" data-toggle="tab">
                                Account
                            </a>
                        </li>
                        <!--                        <li class="user_icon2" ng-class="">
                                                    <a aria-controls="step2" role="tab" href="" data-toggle="tab" ng-click="toggleDevelopingBox()">
                                                        Account
                                                    </a>
                                                </li>-->

                        <!--                        <li class="user_icon2" ng-class="{'active' : (page === 'tripperMessage')}">
                                                    <a href="<c:url value="/Tripper/Chat"/>" aria-controls="step2" role="tab" data-toggle="tab">
                                                        <span></span>Message
                                                    </a>
                                                </li>-->
                        <li class="user_icon2" ng-class="">
                            <a aria-controls="step2" role="tab" data-toggle="tab"  href="" ng-click="toggleDevelopingBox()">
                                Message
                            </a>
                        </li>
                        <li class="user_icon3" ng-class="{'active' : (page === 'bucketPackages')}" >
                            <a href="
                               <c:choose>
                                   <c:when test="${param.language eq 'th'}">
                                       <c:url value="/Tripper/BucketList?language=th"/>
                                   </c:when>
                                   <c:otherwise>
                                       <c:url value="/Tripper/BucketList?language=en"/>
                                   </c:otherwise>
                               </c:choose>" 
                               aria-controls="step3" role="tab" data-toggle="tab">
                                Bucket List
                            </a>
                        </li>
                        <!--                                                <li class="user_icon6" ng-class="{'active' : (page === 'tripperBookings')}" >
                                                                            <a  aria-controls="step6" href="<c:url value="/Tripper/BookingList"/>"
                                                                                role="tab" data-toggle="tab">Your Bookings</a>
                                                                        </li>-->
                        <li class="user_icon6" ng-class="" >
                            <a  aria-controls="step6" ng-click="toggleDevelopingBox()"
                                role="tab" data-toggle="tab">Your Bookings</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>