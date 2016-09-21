<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <head>
        <meta name="description" content="">
        <meta name="viewport" content="width=1366">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--        <meta name="viewport" content="width=device-width, initial-scale=1">-->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >

        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">
        
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
        <title>Youtripper - How does it work</title>
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
        <div class="padding-header" id="howItWork">
            <!--Selector-->
            <div class="home-wrapper">
                <div class="row image-row">
                    <div  class="col-sm-4 image-div" style="background: url(<c:url value="/Resources/Theme/image/work1.png"/>) no-repeat center bottom;">
                        <!--<img alt="" src="<c:url value="/Resources/Theme/image/work1.png"/>" />-->
                    </div>
                    <div  class="col-sm-4 image-div" style="background: url(<c:url value="/Resources/Theme/image/work2.png"/>) no-repeat center bottom;">
                        <!--<img alt="" src="<c:url value="/Resources/Theme/image/work2.png"/>" />-->
                    </div>
                    <div class="col-sm-4 image-div" style="background: url(<c:url value="/Resources/Theme/image/work3.png"/>) no-repeat center bottom;">
                        <!--<img alt="" src="<c:url value="/Resources/Theme/image/work3.png"/>" />-->
                    </div>
                </div>
                <div class='row content-row'>
                    <div class='col-sm-4'>
                        <h4>Discover Amazing Activities</h4>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin porta nunc sed mi finib ut consequat ipsum fringilla.</p>
                    </div>
                    <div class='col-sm-4'>
                        <h4>Book a Trip</h4>
                        <p>Lorem ipsum dolor sit amet.<br/>
                            Integer malesuada lectus vel velit volutpat <br/>
                            Proin porta nunc sed mi.</p>
                    </div>
                    <div class='col-sm-4'>
                        <h4>Travel</h4>
                        <p>Lorem ipsum dolor sit amet, consectetur.<br/>
                            Integer malesuada lectus vel velit volutpat <br/>
                            Proin porta nunc sed mi finibus.</p>
                    </div>
                </div>
                <div class='row more-content-row'>
                    <p><span style='color: #ff6633'>Learn more</span> about hosting on Youtripper Lorem ipsum dolor sit amet, consectetur adipiscing elit nunc elementum consectetur.</p>
                </div>
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