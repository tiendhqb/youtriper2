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
        <title>Youtripper - Helps</title>
    </head>
    <body class="pagesearch" ng-app="YouTripper" ng-controller="PolicyController">
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
        <%@ include file="policyMenubar.jsp" %>
        <!--CONTENT-->
        <div class="container section-content padding-header" ng-controller="FixedComparisonController">
            <!--Selector-->
            <div class="content-small">
                <img class="float-icon" src="<c:url value="/Images/Icon/float.png"/>">
                <h3>Term Of Service</h3>
                <a class="href-orange" href="#1">Can I change a reservation that already been confirmed ?</a><br>
                <a class="href-orange" href="#2">How does Youtripper process payments ?</a><br>
                <a class="href-orange" href="#3">How much do i pay for a reservation ?</a><br>
                <a class="href-orange" href="#4">How does Youtripper handle security deposits ?</a><br>
                <a class="href-orange" href="#5">What is cancellation policy?</a><br>
                <div class="help-item">                    
                </div>
                <div id="1" class="help-item">
                    <h4>Can I change a reservation that already been confirmed ?</h4>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam eget mi fermentum, euismod ex vel, pretium tortor. Quisque tempor neque lorem, eget convallis mauris sagittis sit amet. Nam venenatis viverra arcu vitae tempor. Vestibulum congue lectus sed nisl lacinia consequat. Vestibulum fermentum nulla non turpis faucibus porttitor. Maecenas lobortis vel eros eget cursus. Praesent rhoncus enim quam, id aliquet ligula dignissim sit amet.</p>
                </div>
                <div id="2" class="help-item">
                    <h4>How does Youtripper process payments ?</h4>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam eget mi fermentum, euismod ex vel, pretium tortor. Quisque tempor neque lorem, eget convallis mauris sagittis sit amet. Nam venenatis viverra arcu vitae tempor. Vestibulum congue lectus sed nisl lacinia consequat. Vestibulum fermentum nulla non turpis faucibus porttitor. Maecenas lobortis vel eros eget cursus. Praesent rhoncus enim quam, id aliquet ligula dignissim sit amet.</p>
                </div>
                <div id="3" class="help-item">
                    <h4 >How much do i pay for a reservation ?</h4>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam eget mi fermentum, euismod ex vel, pretium tortor. Quisque tempor neque lorem, eget convallis mauris sagittis sit amet. Nam venenatis viverra arcu vitae tempor. Vestibulum congue lectus sed nisl lacinia consequat. Vestibulum fermentum nulla non turpis faucibus porttitor. Maecenas lobortis vel eros eget cursus. Praesent rhoncus enim quam, id aliquet ligula dignissim sit amet.</p>
                </div>
                <div id="4" class="help-item">
                    <h4>How does Youtripper handle security deposits ?</h4>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam eget mi fermentum, euismod ex vel, pretium tortor. Quisque tempor neque lorem, eget convallis mauris sagittis sit amet. Nam venenatis viverra arcu vitae tempor. Vestibulum congue lectus sed nisl lacinia consequat. Vestibulum fermentum nulla non turpis faucibus porttitor. Maecenas lobortis vel eros eget cursus. Praesent rhoncus enim quam, id aliquet ligula dignissim sit amet.</p>
                </div>
                <div id="5" class="help-item">
                    <h4>What is cancellation policy?</h4>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam eget mi fermentum, euismod ex vel, pretium tortor. Quisque tempor neque lorem, eget convallis mauris sagittis sit amet. Nam venenatis viverra arcu vitae tempor. Vestibulum congue lectus sed nisl lacinia consequat. Vestibulum fermentum nulla non turpis faucibus porttitor. Maecenas lobortis vel eros eget cursus. Praesent rhoncus enim quam, id aliquet ligula dignissim sit amet.</p>
                </div>

            </div>
                <%@ include file="comparisonList.jsp" %>
        </div>
        <!-- FOOTER -->
        <%@ include file="footer.jsp" %>
        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js?999"/>"></script>
        <script>
            var page = '${requestScope.page}';
            $(document).ready(function () {
                toggleHeader.init({
                    toggleControl: false
                });
            });
        </script>
    </body>
</html>