<%-- 
    Document   : welcome
    Created on : Oct 27, 2015, 5:28:36 PM
    Author     : DINH KHANG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=1366">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <a href="<c:url value="/Common/Chat"/>">Chat</a>
        <a href="<c:url value="/Tripper/Notification"/>">Notification</a>
        <a href="<c:url value="/Tripper/Account"/>">Account Information</a>
        <a href="<c:url value="/Tripper/BucketList"/>">Bucket List</a>
        <a href="<c:url value="/Tripper/BookingList"/>">Booking</a>
    </body>
</html>
