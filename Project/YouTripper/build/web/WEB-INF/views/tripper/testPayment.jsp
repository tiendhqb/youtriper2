<%-- 
    Document   : testPayment
    Created on : Jul 5, 2016, 4:53:56 PM
    Author     : DINH KHANG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
                <form name="sendform" method="POST" action="https://rt05.kasikornbank.com/pgpayment/payment.aspx">
                    <input type="hidden" id="MERCHANT2" name="MERCHANT2" value="401003230785001">
                    <input type="hidden" id="TERM2" name="TERM2" value="74422516">
                    <input type="hidden" id="AMOUNT2" name="AMOUNT2" value="000000000100">
                    <input type="hidden" id="URL2" name="URL2" value="https://youtripper.com/Tripper/PaymentComplete">
                    <input type="hidden" id="RESPURL" name="RESPURL" value="https://youtripper.com/Tripper/PaymentSuccess">
                    <input type="hidden" id="IPCUST2" name="IPCUST2" value="1.3.1.23">
                    <input type="hidden" id="DETAIL2" name="DETAIL2" value="MyBooking">
                    <input type="hidden" id="INVMERCHANT" name="INVMERCHANT" value="11123">
                    <input type="hidden" id="CHECKSUM" name="CHECKSUM" value="fd290c9efde84ead1d1189e2cdf503cb">
                    <button type="submit" value="Submit">Submit</button>
                </form>
<!--        <form name="sendform" method="POST" action="/Tripper/Payment">
            <input type="hidden" id="selectedDate" name="selectedDate" value="08/11/2016">
            <input type="hidden" id="firstName" name="firstName" value="duong">
            <input type="hidden" id="lastName" name="lastName" value="khang">
            <input type="hidden" id="paymentMethod" name="paymentMethod" value="paypal">
            <input type="hidden" id="numberOfAdults" name="numberOfAdults" value="2">
            <input type="hidden" id="numberOfChilds" name="numberOfChilds" value="5">
            <input type="hidden" id="packageID" name="packageID" value="98">          
            <button type="submit" value="Submit">Submit</button>
        </form>-->
    </body>
</html>
