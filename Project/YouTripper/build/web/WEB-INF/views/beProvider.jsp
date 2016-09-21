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
        <!--<meta name="viewport" content="width=1366">-->
        <meta name="viewport" content="width=1366">
        <!--        <meta name="viewport" content="width=device-width, initial-scale=1">-->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="">
        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >

        <%@ include file="angular.jsp" %>
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

        <title>YouTripper - Be a provider</title>
    </head>
    <body ng-app="YouTripper" ng-controller="FixedComparisonController">
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
        <div class="pagesearch">
            <%@ include file="header.jsp" %>
            <div class="padding-header">
                <!--Selector-->
                <div class="banner-bea">
                    <div class="container">
                        <h1>
                            Join the world’s smartest<br> activity booking platform.
                        </h1>
                        <p>Be part of a revolution</p>
                        <style>
                            a.btn.versionBtn {
                                background-color: #3FC1C9;
                                margin-left: 10px;
                                color: #fff;
                            }
                        </style>
                        <a href="
                           <c:choose>
                               <c:when test="${empty param.language}">
                                   <c:url value="/ProviderSignup"/>
                               </c:when>
                               <c:otherwise>
                                   <c:url value="/ProviderSignup?language=${param.language}"/>
                               </c:otherwise>
                           </c:choose>" 
                           class="btn joinUsBannerButton" target="_self">JOIN US TODAY</a>

                    </div>

                </div>
                <div class="cate-bea">
                    <div class="beprovider-container">
                        <div class="row joinUs-introduce">
                            <div class="col-md-6" style="top: -110px;padding-right:0;">
                                <img alt="" src="Images/BecomeProvider/joinUsTablet.png"/>
                            </div>
                            <div class="col-md-6 col-md-12 joinUsMessage" >
                                <h2>Synchronize bookings in <br> real time with TrippSource™</h2>
                                <p>Beneﬁt from Youtripper’s free TrippBoard and TrippSource booking engine<br>
                                    to power your online sales. Continue business as usual without interference <br>
                                    while taking advantage of seamlessly synchronizing both online and offline <br>
                                    bookings to avoid overbooking or ineffective quotas and instead promote <br>
                                    packages with unfulﬁlled resources in real time.
                                </p>
                            </div>
                        </div>
                        <div class="row joinUsIcon">
                            <div class="col-md-3 col-sm-12">
                                <img alt="" src="<c:url value="/Images/Icon/feeIcon.svg"/>"/>
                                <p>No Membership Fees</p>
                            </div>
                            <div class="col-md-3 col-sm-12">
                                <img alt="" src="<c:url value="/Images/Icon/flexibleIcon.svg" />"/>
                                <p>Flexible Package Creation</p>
                            </div>
                            <div class="col-md-3 col-sm-12">
                                <img alt="" src="<c:url value="/Images/Icon/bookingIcon.svg" />"/>
                                <p>All your bookings <br> in once place</p>
                            </div>
                            <div class="col-md-3 col-sm-12">
                                <img alt="" src="<c:url value="/Resources/Theme/image/realtimeIcon.svg" />"/>
                                <p>Real-time Resource Management</p>
                            </div>
                        </div>
                    </div>
                    <div class="empower-bussiness joinUs-textCenter">
                        <h2>Empower your business</h2>
                        <p>
                            Take control of your online business and create, manage or post content from the convenience of your home, ofﬁce or coffee
                            shop!  Enjoy the most flexible activity registration platform out there that’s built to make you look good no matter if big or small. 
                            Only be judged by those who matter, your customers. Work to make them happy and satisﬁed and be awarded a prestigious
                            five star rating that will set your business apart from the competition.
                        </p>
                        <img alt="" src="<c:url value="/Images/BecomeProvider/createPackageJoinUs.png" />"/>
                    </div>  
                    <div class="joinUs-industry">
                        <h2>Industry low 10% commission</h2>
                        <p>
                            Youtripper charges an industry low commission of just 10% for every<br>
                            package sold. That’s really, really low but we also expect providers to <br>
                            guarantee us a lowest price match against other channels and agents  <br>
                            by making every package at least 8% cheaper than the standard<br>
                            walk-in price.
                        </p>

                    </div>  
                    <div class="connect-expand joinUs-textCenter">
                        <h2>We connect, you expand</h2>
                        <p>
                            Our site connects you directly with a world of buyers and lets you sell your  packages the way you <br>
                            think is right. We trust you with what you do best,  so trust us with marketing your content <br>
                            online and building Asia’s largest  activity platform. 
                        </p>
                        <img alt="" src="<c:url value="/Images/BecomeProvider/bookingJoinUs.png" />"/>
                    </div>  
                    <div class="joinUs-footer">
                        <h2>Free Membership, No Contracts, Easy Setup</h2>
                        <a href="
                           <c:choose>
                               <c:when test="${empty param.language}">
                                   <c:url value="/ProviderSignup"/>
                               </c:when>
                               <c:otherwise>
                                   <c:url value="/ProviderSignup?language=${param.language}"/>
                               </c:otherwise>
                           </c:choose>" 
                           class="btn joinUsFooterBtn" target="_self">JOIN US TODAY</a>
                    </div>
                </div>

            </div>
            <%--<%@ include file="footer.jsp" %>--%>
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
        <%@ include file="comparisonList.jsp" %>
    </body>
</html>
