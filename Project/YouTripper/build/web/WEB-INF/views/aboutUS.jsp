<%-- 
    Document   : beProvider
    Created on : Oct 21, 2015, 2:25:38 PM
    Author     : Nick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
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

        <title>YouTripper - Booking Successful Page</title>
    </head>
    <body>
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
        <div class="pagesearch" ng-app="YouTripper" ng-controller="FixedComparisonController">
            <%@ include file="header.jsp" %>
            <div class="container section-content padding-header padding-footer">
                <!--Selector-->
                <div id="who-team" class="content-small" style="line-height:1.4em">
                    <br>
                    <br>
                    <h3>Who we are</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur et quam enim. Curabitur tellus erat, pretium euismod diam at, pharetra pretium metus. Nam vel congue est, quis efficitur lorem. Nam dictum ligula nec est tempor hendrerit. Etiam felis orci, eleifend ut mattis id, pulvinar at elit. Duis et neque dapibus, laoreet ante sed, molestie libero. Morbi facilisis viverra justo eu semper.<br><br>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Praesent bibendum tempor suscipit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec laoreet, lacus eget laoreet lobortis, risus enim tincidunt neque, sed scelerisque nisl tellus eget purus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla quis ornare urna. Sed euismod eget dolor sit amet suscipit.<br><br>Aenean fringilla, elit feugiat imperdiet interdum, metus justo hendrerit neque, quis luctus ligula purus in enim. Pellentesque pretium felis luctus interdum ornare. Pellentesque elementum ultricies urna id mollis. Vestibulum ac neque posuere arcu placerat sollicitudin. In eget tellus tincidunt, condimentum orci sit amet, luctus nunc. Curabitur diam nisl, condimentum quis justo at, bibendum mattis tellus. Nulla interdum sagittis ipsum, a congue justo convallis in. Vestibulum metus sem, posuere sit amet ullamcorper eget, rutrum at nulla. Integer tempus nec metus eget placerat.</p>
                    <br>
                    <h3>Team</h3>
                    <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Praesent bibendum tempor suscipit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec laoreet, lacus eget laoreet lobortis, risus enim tincidunt neque, sed scelerisque nisl tellus eget purus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla quis ornare urna. Sed euismod eget dolor sit amet suscipit.</p>
                    <br>
                </div>
                <div id="about-list">
                    <ul>
                        <li><img class="img-responsive" src="<c:url value="/Resources/Theme/image/people1.jpg"/>" /></li>
                        <li><img class="img-responsive" src="<c:url value="/Resources/Theme/image/people2.jpg"/>" /></li>
                        <li><img class="img-responsive" src="<c:url value="/Resources/Theme/image/people3.jpg"/>" /></li>
                        <li><img class="img-responsive" src="<c:url value="/Resources/Theme/image/people4.jpg"/>" /></li>
                        <li><img class="img-responsive" src="<c:url value="/Resources/Theme/image/people5.jpg"/>" /></li>
                        <li><img class="img-responsive" src="<c:url value="/Resources/Theme/image/people6.jpg"/>" /></li>
                    </ul>
                </div>
            </div>
            <%@ include file="comparisonList.jsp" %>
            <!-- FOOTER -->
            <%@ include file="footer.jsp" %>
            <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
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

        </div>
    </body>
</html>
