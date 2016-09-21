<%-- 
    Document   : header
    Created on : Nov 5, 2015, 10:10:16 AM
    Author     : Nick
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<c:choose>
    <c:when test="${sessionScope.ComparisonList == null}">
        <input type="hidden" name="" value="${sessionScope.ComparisonList}" id="comparisonList" ng-init="comparisonList = []"/>
    </c:when>
    <c:otherwise>
        <input type="hidden" name="" value="${sessionScope.ComparisonList}" id="comparisonList" ng-init='comparisonList = ${sessionScope.ComparisonList}'/>
    </c:otherwise>
</c:choose>

<div class='fixed-comparison' ng-show='(comparisonList.length > 0)' >
    <div class='comparison-list'>
        <ul>
            <li ng-repeat="package in comparisonList">
                <div class="img" style='background-image: url({{package.coverImage}})'>
                    <span class='remove' ng-click='removeFromComparisonList($index)'>X</span>
                </div>
            </li>
            <li>
                <a href='
                   <c:choose>
                       <c:when test="${empty param.language}">
                           <c:url value="/Common/ComparisonPage"/>
                       </c:when>
                       <c:otherwise>
                           <c:url value="/Common/ComparisonPage?language=${param.language}"/>
                       </c:otherwise>
                   </c:choose>' 
                   class='btn-save btn-compare' target="_self">Compare</a>
            </li>
        </ul>
    </div>
    <div class='comparison-arrow arrow-down'>
    </div>
</div>
<div class='comprison-header active' ng-show='(comparisonList.length > 0)'>
    <a href=''>Comparison</a>
</div>

