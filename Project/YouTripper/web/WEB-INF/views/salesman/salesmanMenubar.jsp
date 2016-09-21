<%-- 
    Document   : providerMenubar
    Created on : Nov 5, 2015, 6:17:42 PM
    Author     : Nick
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="affix-sidebar">
     <div class="page-user-profile page-provider-profile">
        <div class="tabs-user-profile">
            <!-- Nav tabs -->
            <div class="user-profile-caption  ">
                <div id="providerBar" class="container">
                <ul>
                    <li class="user_icon3" ng-class="{'active' : (page === 'Manager')}" >
                        <a href="<c:url value="/Salesman/ManageSales"/>" aria-controls="step3" role="tab" data-toggle="tab">
                            <span></span>Sales Management
                        </a>
                    </li>
<!--                    <li class="user_icon4" ng-class="{'active' : (page === 'PaymentPage')}">
                        <a href="<c:url value="/Admin/PaymentManagement"/>" aria-controls="step4" role="tab" data-toggle="tab"><span></span>Payment</a>
                    </li>
                    <li class="user_icon4" ng-class="{'active' : (page === 'editingPackages')}">
                        <a href="<c:url value="/Admin/EditingPackages"/>" aria-controls="step4" role="tab" data-toggle="tab">
                            <span></span>Editing
                        </a>
                    </li>
                     <li class="user_icon4" ng-class="{'active' : (page === 'SalesmanSignupPage')}">
                        <a href="<c:url value="/Admin/SalesmanSignupPage"/>" aria-controls="step4" role="tab" data-toggle="tab"><span></span>Salesman Register</a>
                    </li>                 -->
                </ul>
            </div>
        </div>
    </div>
</div>
</div>
