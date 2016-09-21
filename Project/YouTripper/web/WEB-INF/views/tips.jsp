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

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>

        <title>YouTripper - Tips For You</title>
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
        <div class="pagesearch" id='tips'>
            <%@ include file="header.jsp" %>
            <!--<img class="img-responsive padding-header" src="./images/header/banner-tips4u.png">-->

            <div class="padding-header">
                <div class="tips-banner">
                    <h1>Tips for you</h1>
                </div>
                <!--Selector-->
                <div class="home-wrapper">
                    <div class='content'>
                        <h3>Lorem ipsum dolor sit amet</h3>
                        <p>
                            Vestibulum congue lectus sed nisl lacinia consequat. Vestibulum fermentum nulla non turpis faucibus porttitor.
                            Maecenas lobortis vel eros eget cursus. Praesent rhoncus enim quam, id aliquet ligula dignissim sit amet.
                            Fusce eu leo vitae elit sagittis efficitur ac vitae lectus.<br/><br/>

                            Curabitur dui tellus, ultrices eget nisl in, convallis lacinia quam. Cras tortor erat, mollis et auctor vitae, varius non erat.
                            Aenean id diam at est ornare fringilla nec suscipit nunc. Morbi id convallis ante, in fringilla felis. Nunc eleifend ex
                            non nunc laoreet convallis.
                        </p>
                        <img class="img-responsive" src="<c:url value="/Resources/Theme/image/tips-for-you-01.png"/>">
                        <p>Lorem ipsum dolor sit amet, Integer malesuada lectus vel velit volutpat auctor sed id justo. Proin porta nunc sed mi finibus, ut consequat ipsum fringilla. Cras sed leo lectus. Nunc at ante eu turpis interdum mollis. Nam ac arcu sollicitudin, accumsan massa et, facilisis metus. Etiam a pharetra velit. Mauris condimentum lorem felis, eu fermentum ligula ultrices eget.</p>
                        <img class="img-responsive" src="<c:url value="/Resources/Theme/image/tips-for-you-02.png"/>">
                        <p>Lorem ipsum dolor sit amet, Integer malesuada lectus vel velit volutpat auctor sed id justo. Proin porta nunc sed mi finibus, ut consequat ipsum fringilla. Cras sed leo lectus. Nunc at ante eu turpis interdum mollis. Nam ac arcu sollicitudin, accumsan massa et, facilisis metus. Etiam a pharetra velit. Mauris condimentum lorem felis, eu fermentum ligula ultrices eget.</p>
                    </div>
                </div>
            </div>
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
