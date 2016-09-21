<%-- 
    Document   : beProvider
    Created on : Oct 21, 2015, 2:25:38 PM
    Author     : Nick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="LanguagePack.lang" var="lang"/>
<!DOCTYPE html>

<html id="loginPage">
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
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css?999999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css?999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style-login.css"/>" >

        <%@ include file="angular.jsp" %>
        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>

        <title>YouTripper - Signup Success Page</title>
    </head>
    <body ng-app="YouTripper">
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
       
           
            <div class="pagesearch" style="background-color:#fff;padding-top:0;">
                 <%@ include file="header.jsp" %>
                <!--Selector-->
                 <div id="signup-success">
                        <img alt="" src="<c:url value="/Images/Icon/mail.gif"/>" />
                        <h1 style="color:#ff514e;">Thank you!</h1>
                        <p><fmt:message key="provider.register.thankYou" bundle="${lang}"/>

                        </p>

                        <p style="font-size:20px;"><fmt:message key="provider.register.msgResend" bundle="${lang}"/>                         
                        </p>
                        <form method="POST" action="
                              <c:choose>
                                  <c:when test="${empty param.language}">
                                      <c:url value="/Common/ResendActiveEmail"/>
                                  </c:when>
                                  <c:otherwise>
                                      <c:url value="/Common/ResendActiveEmail?language=${param.language}"/>
                                  </c:otherwise>
                              </c:choose>" 
                              class="form-horizontal" name="signupForm" 
                              autocomplete="off">
                            <button style="width:200px;" type="submit" class="btn-width-orange joinUsBannerButton"><fmt:message key="provider.register.resend" bundle="${lang}"/></button>   
                        </form>
                    </div>
            </div>
            <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/script.min.js"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/main.js?99"/>"></script>
            <script>
            $(document).ready(function () {
                SpinnerText.init('ul[data-spinner]');

                new toggleHeader.init({
                    toggleControl: false
//                                            toggleTheme: true
                });
            });
            </script>
       
    </body>
</html>
