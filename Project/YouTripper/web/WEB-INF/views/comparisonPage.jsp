<%-- 
    Document   : accountInfo
    Created on : Nov 2, 2015, 10:19:54 AM
    Author     : DINH KHANG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=1366">
<!--        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1">-->
        <!--<script src='https://www.google.com/recaptcha/api.js'></script>-->

        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">

        <%@ include file="angular.jsp" %>

        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css?999999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css?999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style-login.css"/>" >

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>

        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >
        <title>Comparison List</title>
    </head>
    <body ng-app='YouTripper' ng-controller="ComparisonPageController">
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
            <div class="container section-content padding-header">
                <h1>Comparison</h1>
                <div class="comparison-table">
                    <ul class="item-headers">
                        <li>
                            <ul class="small-items">
                                <li style='    line-height: 180px;
                                    text-align: center;
                                    background-color: #dcdcdc;'>
                                    Data Added
                                </li>
                                <li ng-repeat="package in comparisonPakages">
                                    <h5 ng-class="{'first-package' : ($index === 0)}">{{package.name}}</h5>
                                    <div class="com-image" style="background-image: url({{package.coverImage}})">
                                        <a href='<c:url value="/Package"/>/{{package.id}}'></a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="items">
                        <li>
                            <ul class="small-items">
                                <li>Professionalism</li>
                                <li ng-repeat='package in comparisonPakages'>{{package.professionlism}}</li>
                            </ul>
                        </li>
                        <li>
                            <ul class="small-items">
                                <li>Staff Attitude</li>
                                <li ng-repeat='package in comparisonPakages'>{{package.staffAttitude}}</li>
                            </ul>
                        </li>
                        <li>
                            <ul class="small-items">
                                <li>Cleanliness</li>
                                <li ng-repeat='package in comparisonPakages'>{{package.cleanliness}}</li>
                            </ul>
                        </li>
                        <li>
                            <ul class="small-items">
                                <li>Convenient Access</li>
                                <li ng-repeat='package in comparisonPakages'>{{package.convenient}}</li>
                            </ul>
                        </li>
                        <li>
                            <ul class="small-items">
                                <li>Amenity Quality</li>
                                <li ng-repeat='package in comparisonPakages'>{{package.amenityQuality}}</li>
                            </ul>
                        </li>
                        <li>
                            <ul class="small-items">
                                <li>Satisfaction</li>
                                <li ng-repeat='package in comparisonPakages'>{{package.satisfaction}}</li>
                            </ul>
                        </li>
                        <li class='noClick'>
                            <ul class="small-items">
                                <li>Popularity</li>
                                <li ng-repeat='package in comparisonPakages'>3</li>
                            </ul>
                        </li>
                        <li class='noClick'>
                            <ul class="small-items">
                                <li>Average Score</li>
                                <li ng-repeat='package in comparisonPakages'>
                                    {{((package.professionlism + package.staffAttitude + package.cleanliness 
                                                + package.convenient + package.amenityQuality + package.satisfaction) / 6 ) | number:0}}
                                </li>
                            </ul>
                        </li>
                        <li class='noClick'>
                            <ul class="small-items">
                                <li>Price</li>
                                <li ng-repeat='package in comparisonPakages'>{{package.ordinaryPriceForAdult}}$</li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
            <%@ include file="footer.jsp" %>
            <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/main.js?999"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/jquery.tabslet.js"/>"></script>
            <script src="<c:url value="/Resources/Theme/js/jquery.matchHeight.js"/>"></script>

            <script>
                            var comparisonPakages = ${requestScope.ComparisonPackages};                                         $(document).ready(function () {
                        toggleHeader.init({
                        toggleControl: false
                                            });

                            function sortByValue(a, b) {
                            var valueA = a.value;
                            var valueB = b.value;
                        return ((valueA > valueB) ? -1 : ((valueA < valueB) ? 1 : 0));
                                            }

                            $(".items > li:not(.noClick)").click(function () {
                            $(this).css("transform", "translate3d(0, 0%, 0)");
                                    var current = $(this);
                                    setTimeout(
                                        function ()
                                                        {
                                        $(current).insertBefore($(".items > li:nth-child(1)"));
                            $(current).removeAttr("style");
                            }, 200);
                                                var listValue = [];
                                    current.find(".small-items li").each(function (index, value) {
                                                    if (index > 0) {
                                    var objectValue = {"position": index + 1, "value": $(this).html()};
                            listValue.push(objectValue);
                            }
                                                });
                            listValue.sort(sortByValue);
                                                var percent = 100;
                            $(".item-headers h5").removeClass("first-package");
                                for (var i = 0; i < listValue.length; i++) {
                                var position = listValue[i].position;
                                    if ($(".small-items > li:nth-child(" + position + ")").length) {
                                $(".small-items > li:nth-child(" + position + ")").css("transform", "translate3d(" + percent + "%, 0, 0)");
                            }
                            percent += 100;
                                                }
                                                $(".item-headers .small-items > li:nth-child(" + listValue[0].position + ") h5").addClass("first-package");
//                        $(".items").prepend($(this));
//                        $(this).remove();
//                        alert("aa");
                            //                        var current = $(this);
//                        while (current.prev().length) {
                            //                            current = current.prev();
                        //                         
//                
                    //                        }
                                });

                                        });
            </script>
    </body>
</html>
