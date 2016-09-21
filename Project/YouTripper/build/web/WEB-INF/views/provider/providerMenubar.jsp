<%-- 
    Document   : providerMenubar
    Created on : Nov 5, 2015, 6:17:42 PM
    Author     : Nick
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${param.language}" />
<fmt:setBundle basename="LanguagePack.lang" var="lang"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="affix-sidebar" ng-app="YouTripper" ng-controller="ProviderMenubar">
    <!--DEVELOPING POPUP-->
     <div class="ytPopup" id="uconstruction">
        <div class="tbl-cell noClick">
            <div class="popupContent uconstruction-box">
                <span class="box-closing-blue" ng-click="toggleUnderConstructionBox()"></span>      
                <img class="uconstrc-icon-big" src="<c:url value="/Images/Icon/UConstr.svg"/>">
                    <h4 class="header"><fmt:message key="provider.underConstruction.text1" bundle="${lang}"/></h4>
                    
                    <div class="popupRow">
                        <div class="row">
                            <div class="col-xs-12">
                                <p>
                                    <fmt:message key="provider.underConstruction.text2" bundle="${lang}"/>
                                </p>
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
                <div id="providerBar">
                    <ul>
                        <li ng-class="{'active' : (page === 'providerPackage')}" >
                            <a href="
                               <c:choose>
                                   <c:when test="${empty param.language}">
                                       <c:url value="/Provider/Package"/>
                                   </c:when>
                                   <c:otherwise>
                                       <c:url value="/Provider/Package?language=${param.language}"/>
                                   </c:otherwise>
                               </c:choose>">
                                My Packages 
                            </a>
                            <div class="number-package" ng-class="{'active' : (page === 'providerPackage')}">
                                {{numberOfPackage}}</div>
                        </li>
                        <li>
                            <a href="#" ng-click="toggleUnderConstructionBox()">
                                Booking Engine
                                <img class="uconstrc-icon" src="<c:url value="/Images/Icon/UConstr.svg"/>">
                            </a>

                        </li>
                        <li>
                            <a href="#" ng-click="toggleUnderConstructionBox()">
                                Resource Manager
                                <img class="uconstrc-icon" src="<c:url value="/Images/Icon/UConstr.svg"/>">
                            </a>
                        </li>

                        <li ng-class="">
                            <a href="#"   ng-click="toggleUnderConstructionBox()" >
                                Chat Room
                                <img class="uconstrc-icon" src="<c:url value="/Images/Icon/UConstr.svg"/>">
                            </a>
                        </li>

                        <li ng-class="">
                            <a href="#"   ng-click="toggleUnderConstructionBox()" >
                                Sales Overview
                                <img class="uconstrc-icon" src="<c:url value="/Images/Icon/UConstr.svg"/>">
                            </a>
                        </li>

                        <li ng-class="">
                            <a href="#"   ng-click="toggleUnderConstructionBox()" >
                                Promotion Planner
                                <img class="uconstrc-icon" src="<c:url value="/Images/Icon/UConstr.svg"/>">
                            </a>
                        </li>


                        <li  ng-class="{'active' : (page === 'providerCertificate')}" >
                            <a href="
                               <c:choose>
                                   <c:when test="${empty param.language}">
                                       <c:url value="/Provider/CertificateManagement"/>
                                   </c:when>
                                   <c:otherwise>
                                       <c:url value="/Provider/CertificateManagement?language=${param.language}"/>
                                   </c:otherwise>
                               </c:choose>">Certificate Gallery</a>
                        </li>

                        <!--                        <li  ng-class="" >
                                                    <a href="#"  ng-click="toggleDevelopingBox()" >ID verification</a>
                                                </li>-->

                        <li ng-class="{'active' : ('${requestScope.page}' === 'Referral')}" > 
                            <a href="
                               <c:choose>
                                   <c:when test="${empty param.language}">
                                       <c:url value="/Provider/InviteFriend"/>
                                   </c:when>
                                   <c:otherwise>
                                       <c:url value="/Provider/InviteFriend?language=${param.language}"/>
                                   </c:otherwise>
                               </c:choose>">Referral Program</a>
                        </li>
                        <!--                    <li>
                                                <a href="#step8" aria-controls="step8" role="tab" data-toggle="tab">Payment</a>
                                            </li>-->
                        <br>
                        <li ng-if="page === 'providerPackage'" > 
                            <!--<a href="<c:url value="/Provider/InviteFriend"/>">Referral Program</a>-->
                            <input style="color:#fff " type="text" ng-model="packages.searchPackageValue" class="greyInput normalFont input-provider-bar" placeholder="Search for package">

                        </li>
                        <li ng-if="page === 'providerPackage'" > 
                           <!--<a href="<c:url value="/Provider/InviteFriend"/>">Referral Program</a>-->
                            <select style="color:#3FBDC5 " type="text" ng-model="packages.sortPackageValue" ng-change="sortPackage()" class="greyInput normalFont select-provider-bar" placeholder="Search for package">
                                <option value="abc">Sort alphabetically</option>
                                <option value="oldest"  >Sort by oldest package first</option>
                                <option value="youngest"  >Sort by youngest package first</option>
                                <option value="expensive"  >Sort by highest price first</option>
                                <option value="cheap"  >Sort by lowest price first</option>
                            </select>
                        </li>
                        <li ng-if="page === 'providerPackage'" > 
                           <!--<a href="<c:url value="/Provider/InviteFriend"/>">Referral Program</a>-->
                            <select style="color:#3FBDC5 " type="text" ng-model="packages.filterPackageValue"  class="greyInput normalFont select-provider-bar" placeholder="Search for package">
                                <option value="all">All packages</option>
                                <option value="Approved">Approved only</option>
                                <option value="Creation in Process">Creation in Process only</option>
                                <option value="Incomplete Submission">Incomplete Submission only</option>
                                <option value="Pending Approval">Pending Approval only</option>
                                <option value="Not Operating">Not Operating only</option>
                            </select>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    var numberReferral = '${sessionScope.ReferralNumber}';
</script>
