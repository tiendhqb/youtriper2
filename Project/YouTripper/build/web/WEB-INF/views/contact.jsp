<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
    <head>
        <meta name="description" content="">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=1366">
<!--        <meta name="viewport" content="width=device-width, initial-scale=1">-->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >

        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/jquery.mThumbnailScroller.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/lightgallery.css"/>" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style-login.css"/>" >

        <%@ include file="angular.jsp" %>

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >
        <title>Youtripper - Contact</title>
    </head>
    <body class="pagesearch" ng-app="YouTripper" ng-controller="FixedComparisonController">
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
        <%@ include file="header.jsp" %>
        <!--CONTENT-->
        <img class="img-responsive padding-header" src="<c:url value="/Images/ContactPage/contact.png"/>">
        <div class="container section-content padding-header">
            <!--Selector-->
            <div class="content-small">
                <h3>Drop us a line</h3>
                <p>Lorem ipsum dolor sit amet, <a style="color:#E76B4A" href="mailto:contact@youtripper.com">contact@youtripper.com</a>. Integer malesuada lectus vel velit volutpat auctor sed id justo.</p>
                <p>Proin porta nunc sed mi finibus, ut consequat ipsum fringilla. Cras sed leo lectus. Nunc at ante eu turpis interdum mollis. Nam ac arcu sollicitudin, accumsan massa et, facilisis metus. Etiam a pharetra velit. Mauris condimentum lorem felis, eu fermentum ligula ultrices eget.</p>
            </div>
        </div>
        <!-- FOOTER -->
        <%@ include file="footer.jsp" %>
        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js?999"/>"></script>
        <script>
            $(document).ready(function () {
                toggleHeader.init({
                    toggleControl: false
                });
            });
        </script>
         <%@ include file="comparisonList.jsp" %>
    </body>
</html>