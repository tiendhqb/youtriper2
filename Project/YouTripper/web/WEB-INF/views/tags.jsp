<%-- 
    Document   : tags
    Created on : Feb 9, 2016, 2:43:30 PM
    Author     : Nick
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=1366">
        <link rel="stylesheet" href="http://mbenford.github.io/ngTagsInput/css/ng-tags-input.min.css" />
          <%@ include file="angular.jsp" %>
        
        <title>JSP Page</title>
    </head>
    <body ng-app="YouTripper" ng-controller="MainCtrl"  >
    <tags-input ng-model="tags"></tags-input>
    <p>Model: ${requestScope.locationTable}</p>
</body>
</html>
