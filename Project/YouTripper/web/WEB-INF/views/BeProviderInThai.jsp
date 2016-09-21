<%-- 
    Document   : BeProviderInThai
    Created on : Jul 27, 2016, 4:10:50 PM
    Author     : Long Nguyen
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

        <style>
            .padding-header p, .padding-header h1, .padding-header h2, .padding-header a {
                font-family: Thai-Font !important;
            }
        </style>
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
                            ร่วมเป็นส่วนหนึ่ง<br/>ในการปฏิวัติวงการการท่องเที่ยว
                            <!--Join the world’s smartest<br> activity booking platform.-->
                        </h1>
                        <p>กับระบบการจัดการการท่องเที่ยวอันชาญฉลาด</p>
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
                           </c:choose>" style="font-size: 20px;"
                           class="btn joinUsBannerButton" target="_self">เข้าร่วมกับเรา</a>
<!--                        <a href="<c:url value="/BeProvider"/>" style="font-size: 20px;"
                           class="btn versionBtn" target="_self">ภาษาอังกฤษ</a>-->

                    </div>

                </div>
                <div class="cate-bea">
                    <div class="beprovider-container">
                        <div class="row joinUs-introduce">
                            <div class="col-md-6" style="top: -110px;padding-right:0;">
                                <img alt="" src="<c:url value="/Resources/Theme/image/joinUsTablet.png"/>"/>
                            </div>
                            <div class="col-md-6 col-md-12 joinUsMessage" >
                                <h2 style="font-size:  30px; width: 500px">ผสมผสานการจองแพคเกจแบบนาทีต่อนาทีด้วยเครื่องมือที่เราเรียกว่า TrippSource™ ฟรี จาก youtripper</h2>
                                <p style=" width: 500px; font-size: 20px">
                                    อันประกอบด้วย TrippBoard และ TrippSource เพื่อสร้างความสะดวกในการทำตลาดออนไลน์ของคุณ 
                                    โดยยังดำเนินธุรกิจของคุณในแบบปกติได้ผ่านการผสมผสานการจองแพคเกจทั้งในแบบออฟไลน์ และออนไลน์
                                    เพื่อหลีกเลี่ยงการจองเกินจำนวนที่คุณจะสามารถให้บริการได้ 
                                </p>
                            </div>
                        </div>
                        <div class="row joinUsIcon">
                            <div class="col-md-3 col-sm-12">
                                <img alt="" src="<c:url value="/Images/Icon/feeIcon.svg"/>"/>
                                <p>ไม่มีค่าธรรมเนียมการสมัครสมาชิก</p>
                            </div>
                            <div class="col-md-3 col-sm-12">
                                <img alt="" src="<c:url value="/Images/Icon/flexibleIcon.svg" />"/>
                                <p>การสร้างแพคเกจที่ยืดหยุ่นได้</p>
                            </div>
                            <div class="col-md-3 col-sm-12">
                                <img alt="" src="<c:url value="/Images/Icon/bookingIcon.svg" />"/>
                                <p>รวมช่องงทางในการจองทั้งหมดไว้ในที่เดียว</p>
                            </div>
                            <div class="col-md-3 col-sm-12">
                                <img alt="" src="<c:url value="/Resources/Theme/image/realtimeIcon.svg" />"/>
                                <p>จัดการทรัพยากรของคุณได้แบบวินาทีต่อวินาที</p>
                            </div>
                        </div>
                    </div>
                    <div class="empower-bussiness joinUs-textCenter">
                        <h2>เพิ่มพลังให้กับธุรกิจของคุณ</h2>
                        <p style="font-size: 20px">
                            ควบคุมธุรกิจออนไลน์ของคุณ และสร้าง จัดการ หรือโพสสิ่งต่างๆ อย่างง่ายดายด้วยปลายนิ้ว
                            ไม่ว่าจะจากที่บ้าน ที่ทำงาน หรือแม้แต่ในร้านกาแฟ สนุกไปกับเว็บไซต์การจองกิจกรรมออนไลน์ที่จะทำให้สินธุรกิจของคุณมีภาพลักษณที่ดี
                            และมีความยืดหยุ่นที่สุดเท่าที่คุณเคยพบ โดยผู้ที่จะตัดสินความสำเร็จของคุณก็คือใครก็ตามที่เข้ามาเป็นลูกค้าของคุณ
                            ทำให้พวกเค้าประทับใจ และมั่นใจ เพื่อจะได้เรตติ้ง 5 ดาวจากพวกเค้า ซึ่งสิ่งที่นี้เองที่จะทำให้ธุรกิจของคุณเป็นต่อในการแข่งขัน 
                        </p>
                        <img alt="" src="<c:url value="/Images/BecomeProvider/createPackageJoinUs.png" />"/>
                    </div>  
                    <div class="joinUs-industry">
                        <h2>คอมมิชชั่น 10%</h2>
                        <p style="font-size: 20px">
                            เราคิดค่าดำเนินการเป็น Commission เพียง 10% สำหรับทุกๆ
                            แพคเกจที่เกิด<br/>
                            การซื้อขาย ซึ่งเป็นราคาที่ถูก และถูกมากๆ! แต่อย่างไรก็ตาม สิ่งที่เราคาดหวังก็คือ <br/>
                            ให้ผู้ประกอบการรับรองว่า ราคาที่ประกาศขายใน youtripper นั้น จะต่ำกว่าราคา Walk in ขั้นต่ำ 8%
                        </p>

                    </div>  
                    <div class="connect-expand joinUs-textCenter">
                        <h2>เราเชื่อม คุณขยาย</h2>
                        <p style="font-size: 20px">
                            เว็บไซต์ของเราเชื่อมต่อระหว่างคุณกับลูกค้าทั่วโลกโดยตรง ให้คุณขายแพคเกจของคุณได้อย่างอิสระ 
                            ในรูปแบบที่คุณต้องการ เราเชื่อในสิ่งที่คุณถนัด ดังนั้นเชื่อใจเราในเรื่องการทำตลาดออนไลน์ และสร้าง 
                            youtripper ให้เป็น activity platform ที่ใหญ่ที่สุดในเอเชีย 
                        </p>
                        <img alt="" src="<c:url value="/Images/BecomeProvider/bookingJoinUs.png" />"/>
                    </div>  
                    <div class="joinUs-footer">
                        <h2>สมัครสมาชิกฟรี แบบง่ายๆ โดยไม่ต้องทำสัญญา</h2>
                        <a style="font-size: 20px" 
                           href="
                           <c:choose>
                               <c:when test="${empty param.language}">
                                   <c:url value="/ProviderSignup"/>
                               </c:when>
                               <c:otherwise>
                                   <c:url value="/ProviderSignup?language=${param.language}"/>
                               </c:otherwise>
                           </c:choose>" 
                           class="btn joinUsFooterBtn" target="_self">เข้าร่วมกับเรา</a>
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
