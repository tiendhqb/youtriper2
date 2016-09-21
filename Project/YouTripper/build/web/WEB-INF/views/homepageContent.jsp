<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<div>
    <div ng-app="YouTripper" ng-controller="FixedComparisonController" id="homepage">
        <!--DEVELOPING POPUP-->
        <div class="ytPopup" id="developingBox"  >
            <div class="tbl-cell noClick" ng-controller="DevelopingControler">
                <div class="popupContent" >
                    <div class="center-informBlock blur-backgroud" ng-show="!sendInfo">
                        <div class="small-spinner" ></div>
                    </div>
                    <span class="box-closing" ng-click="toggleDevelopingBox()"></span>
                    <div class="popupScroll">
                        <div style="text-align: center">
                            <p style="font-size: 20px">
                                Join My Newsletter 
                            </p>
                            <p style="margin-top: 10px">
                                Thank you for visiting the youtripper website. Unfortunately the feature you are interested in is currently under construction. 
                            </p>
                            <p style="margin-top: 10px">    
                                Please support changing the travel industry us and follow our facebook or sign up to our email newsletter to find out about the latest developments. 
                            </p>
                            <p style="margin-top: 10px">
                                Stay tuned and thank you for your support. 
                            </p>
                        </div>
                        <div class="row">
                            <div class="col-xs-12" style="margin-top: 15px;  text-align: center">
                                <a target="_blank" href="https://www.facebook.com/Youtripper-466412116883772">
                                    <button style="width: 250px;" class="btn-width-orange login_fb button">Go to Facebook fanpage</button>
                                </a>
                            </div>
                        </div>
                        <div ng-show="!sendDone" class="row" style="margin-top: 15px;">
                            <div class="col-xs-8">
                                <input type="text" ng-model="email" maxlength="100" ng-maxlength="100"
                                       class="blueInput normalFont" placeholder="Enter Your Email">
                            </div>
                            <div class="col-xs-4" style="height:40px; line-height: 35px">
                                <a href="" ng-click="submitEmail()" class="btn-width-orange">Submit</a>
                            </div>
                        </div>
                        <span ng-show="(showError.emailValid || showError.all) && !emailLoading && !sendDone">
                            <span ng-show="missing.emailValid && missing.emailRegex" style="color: green">Email is valid!</span>
                            <span ng-show="!missing.emailValid && missing.emailRegex" style="color: red">Email is exist!</span>
                            <span ng-hide="missing.emailRegex" style="color: red">Email is not correct!</span>
                        </span>
                        <div class="row">
                            <div class="col-xs-12" style="margin-top: 15px; text-align: center">
                                <span  ng-show="sendDone" style="color: green">Join My Newsletter Successfully </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--END DEVELOPING POPUP-->

        <%@ include file="comparisonList.jsp" %>

        <!--RECOMMENDED-->
        <div class="home-section">
            <div class="home-section-container">
                <div class="section-title">
                    <h4>Recommended Packages</h4>
                    <h5>Our top Picks This Month</h5>
                </div>
                <div class="section-content">
                    <div class="home-packages">
                        <span class="ctrl left-ctrl"></span>
                        <span class="ctrl right-ctrl"></span>
                        <ul class="clearfix">
                            <li>
                                <div class="single-package" style="background-image: url(<c:url value="/Resources/Theme/image/trekking.png"/>)">
                                    <a href="" class="bg" ng-click="toggleDevelopingBox()">
                                        <img src="<c:url value="/Resources/Theme/image/trekking.png"/>"/>
                                    </a>
                                    <div class="package-title">
                                        <h4><a href="">A package Title</a></h4>
                                        <div class="address">
                                            <span class="icon"></span>
                                            <p>Bangkok, Thailand</p>
                                        </div>
                                    </div>

                                    <span class="package-price">
                                        $200.00
                                    </span>
                                </div>
                            </li>

                            <li>
                                <div class="single-package" style="background-image: url(<c:url value="/Resources/Theme/image/trekking.png"/>)">
                                    <a href="" class="bg" ng-click="toggleDevelopingBox()">
                                        <img src="<c:url value="/Resources/Theme/image/trekking.png"/>"/>
                                    </a>
                                    <div class="package-title">
                                        <h4><a href="">A package Title</a></h4>
                                        <div class="address">
                                            <span class="icon"></span>
                                            <p>Bangkok, Thailand</p>
                                        </div>
                                    </div>

                                    <span class="package-price">
                                        $200.00
                                    </span>
                                </div>
                            </li>

                            <li>
                                <div class="single-package" style="background-image: url(<c:url value="/Resources/Theme/image/trekking.png"/>)">
                                    <a href="" class="bg" ng-click="toggleDevelopingBox()">
                                        <img src="<c:url value="/Resources/Theme/image/trekking.png"/>"/>
                                    </a>
                                    <div class="package-title">
                                        <h4><a href="">A package Title</a></h4>
                                        <div class="address">
                                            <span class="icon"></span>
                                            <p>Bangkok, Thailand</p>
                                        </div>
                                    </div>

                                    <span class="package-price">
                                        $200.00
                                    </span>
                                </div>
                            </li>

                            <li>
                                <div class="single-package" style="background-image: url(<c:url value="/Resources/Theme/image/trekking.png"/>)">
                                    <a href="" class="bg" ng-click="toggleDevelopingBox()">
                                        <img src="<c:url value="/Resources/Theme/image/trekking.png"/>"/>
                                    </a>
                                    <div class="package-title">
                                        <h4><a href="">A package Title</a></h4>
                                        <div class="address">
                                            <span class="icon"></span>
                                            <p>Bangkok, Thailand</p>
                                        </div>
                                    </div>

                                    <span class="package-price">
                                        $200.00
                                    </span>
                                </div>
                            </li>

                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!--END RECOMMENDED-->

        <!--ACTIVITES-->
        <div class="home-section lightBg">
            <div class="home-section-container">
                <div class="section-title">
                    <h4>Activities in <span>Bangkok</span></h4>
                    <h5>Discover new inspiring things to do</h5>
                </div>
                <div class="section-content">
                    <div class="home-packages">
                        <ul class="clearfix">
                            <li>
                                <div class="single-package" style="background-image: url(<c:url value="/Resources/Theme/image/trekking.png"/>)">
                                    <a href="" class="bg" ng-click="toggleDevelopingBox()">
                                        <img src="<c:url value="/Resources/Theme/image/trekking.png"/>"/>
                                    </a>
                                    <div class="package-title">
                                        <h4><a href="">A package Title</a></h4>
                                        <div class="address">
                                            <span class="icon"></span>
                                            <p>Bangkok, Thailand</p>
                                        </div>
                                    </div>

                                    <span class="package-price">
                                        $200.00
                                    </span>
                                </div>
                            </li>

                            <li>
                                <div class="single-package" style="background-image: url(<c:url value="/Resources/Theme/image/trekking.png"/>)">
                                    <a href="" class="bg" ng-click="toggleDevelopingBox()">
                                        <img src="<c:url value="/Resources/Theme/image/trekking.png"/>"/>
                                    </a>
                                    <div class="package-title">
                                        <h4><a href="">A package Title</a></h4>
                                        <div class="address">
                                            <span class="icon"></span>
                                            <p>Bangkok, Thailand</p>
                                        </div>
                                    </div>

                                    <span class="package-price">
                                        $200.00
                                    </span>
                                </div>
                            </li>

                            <li>
                                <div class="single-package" style="background-image: url(<c:url value="/Resources/Theme/image/trekking.png"/>)">
                                    <a href="" class="bg" ng-click="toggleDevelopingBox()">
                                        <img src="<c:url value="/Resources/Theme/image/trekking.png"/>"/>
                                    </a>
                                    <div class="package-title">
                                        <h4><a href="">A package Title</a></h4>
                                        <div class="address">
                                            <span class="icon"></span>
                                            <p>Bangkok, Thailand</p>
                                        </div>
                                    </div>

                                    <span class="package-price">
                                        $200.00
                                    </span>
                                </div>
                            </li>

                            <li>
                                <div class="single-package" style="background-image: url(<c:url value="/Resources/Theme/image/trekking.png"/>)">
                                    <a href="" class="bg" ng-click="toggleDevelopingBox()">
                                        <img src="<c:url value="/Resources/Theme/image/trekking.png"/>"/>
                                    </a>
                                    <div class="package-title">
                                        <h4><a href="">A package Title</a></h4>
                                        <div class="address">
                                            <span class="icon"></span>
                                            <p>Bangkok, Thailand</p>
                                        </div>
                                    </div>

                                    <span class="package-price">
                                        $200.00
                                    </span>
                                </div>
                            </li>

                            <li>
                                <div class="single-package" style="background-image: url(<c:url value="/Resources/Theme/image/trekking.png"/>)">
                                    <a href="" class="bg" ng-click="toggleDevelopingBox()">
                                        <img src="<c:url value="/Resources/Theme/image/trekking.png"/>"/>
                                    </a>
                                    <div class="package-title">
                                        <h4><a href="">A package Title</a></h4>
                                        <div class="address">
                                            <span class="icon"></span>
                                            <p>Bangkok, Thailand</p>
                                        </div>
                                    </div>

                                    <span class="package-price">
                                        $200.00
                                    </span>
                                </div>
                            </li>

                            <li>
                                <div class="single-package" style="background-image: url(<c:url value="/Resources/Theme/image/trekking.png"/>)">
                                    <a href="" class="bg" ng-click="toggleDevelopingBox()">
                                        <img src="<c:url value="/Resources/Theme/image/trekking.png"/>"/>
                                    </a>
                                    <div class="package-title">
                                        <h4><a href="">A package Title</a></h4>
                                        <div class="address">
                                            <span class="icon"></span>
                                            <p>Bangkok, Thailand</p>
                                        </div>
                                    </div>

                                    <span class="package-price">
                                        $200.00
                                    </span>
                                </div>
                            </li>

                            <li>
                                <div class="single-package" style="background-image: url(<c:url value="/Resources/Theme/image/trekking.png"/>)">
                                    <a href="" class="bg" ng-click="toggleDevelopingBox()">
                                        <img src="<c:url value="/Resources/Theme/image/trekking.png"/>"/>
                                    </a>
                                    <div class="package-title">
                                        <h4><a href="">A package Title</a></h4>
                                        <div class="address">
                                            <span class="icon"></span>
                                            <p>Bangkok, Thailand</p>
                                        </div>
                                    </div>

                                    <span class="package-price">
                                        $200.00
                                    </span>
                                </div>
                            </li>

                            <li>
                                <div class="single-package" style="background-image: url(<c:url value="/Resources/Theme/image/trekking.png"/>)">
                                    <a href="" class="bg" ng-click="toggleDevelopingBox()">
                                        <img src="<c:url value="/Resources/Theme/image/trekking.png"/>"/>
                                    </a>
                                    <div class="package-title">
                                        <h4><a href="">A package Title</a></h4>
                                        <div class="address">
                                            <span class="icon"></span>
                                            <p>Bangkok, Thailand</p>
                                        </div>
                                    </div>

                                    <span class="package-price">
                                        $200.00
                                    </span>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>

                <div class="section-btn">
                    <a href="">Show more</a>
                </div>
            </div>
        </div>
        <!--END ACTIVITIES-->


        <!--LOCATIONS-->
        <div class="home-section whiteBg same-content full-section">
            <div class="home-section-container">
                <div class="section-title" style="background-color: #F2F2F4;">
                    <h4>Most Popular Destinations</h4>
                    <h5>Discover new inspiring things to do</h5>
                </div>

                <div class="section-content">
                    <div class="home-activites">
                        <ul class="clearfix">
                            <li>
                                <div class="single-activity" style="background-image: url(<c:url value="/Resources/Theme/image/pic9.jpg"/>)">
                                    <div class="tbl-center">
                                        <div class="tbl-cell">
                                            <h3>BANGKOK</h3>
                                        </div>
                                    </div>
                                    <a href="" ng-click="toggleDevelopingBox()">
                                        <img src="<c:url value="/Resources/Theme/image/pic9.jpg"/>"/>
                                    </a>
                                </div>
                            </li>

                            <li>
                                <div class="single-activity" style="background-image: url(<c:url value="/Resources/Theme/image/pic11.jpg"/>)">
                                    <div class="tbl-center">
                                        <div class="tbl-cell">
                                            <h3>PHUKET</h3>
                                        </div>
                                    </div>
                                    <a href="" ng-click="toggleDevelopingBox()">
                                        <img src="<c:url value="/Resources/Theme/image/pic11.jpg"/>"/>
                                    </a>
                                </div>
                            </li>

                            <li>
                                <div class="single-activity" style="background-image: url(<c:url value="/Resources/Theme/image/pic3.jpg"/>)">
                                    <div class="tbl-center">
                                        <div class="tbl-cell">
                                            <h3>CHIANGMAI</h3>
                                        </div>
                                    </div>
                                    <a href="" ng-click="toggleDevelopingBox()">
                                        <img src="<c:url value="/Resources/Theme/image/pic3.jpg"/>"/>
                                    </a>
                                </div>
                            </li>

                            <li>
                                <div class="single-activity" style="background-image: url(<c:url value="/Resources/Theme/image/pic13.jpg"/>)">
                                    <div class="tbl-center">
                                        <div class="tbl-cell">
                                            <h3>PATTAYA</h3>
                                        </div>
                                    </div>
                                    <a href="" ng-click="toggleDevelopingBox()">
                                        <img src="<c:url value="/Resources/Theme/image/pic13.jpg"/>"/>
                                    </a>
                                </div>
                            </li>

                            <li>
                                <div class="single-activity" style="background-image: url(<c:url value="/Resources/Theme/image/pic12.jpg"/>)">
                                    <div class="tbl-center">
                                        <div class="tbl-cell">
                                            <h3>SUKHOTHAI</h3>
                                        </div>
                                    </div>
                                    <a href="" ng-click="toggleDevelopingBox()">
                                        <img src="<c:url value="/Resources/Theme/image/pic12.jpg"/>"/>
                                    </a>
                                </div>
                            </li>

                            <li>
                                <div class="single-activity" style="background-image: url(<c:url value="/Resources/Theme/image/pic16.jpg"/>)">
                                    <div class="tbl-center">
                                        <div class="tbl-cell">
                                            <h3>KANCHANABURI</h3>
                                        </div>
                                    </div>
                                    <a href="" ng-click="toggleDevelopingBox()">
                                        <img src="<c:url value="/Resources/Theme/image/pic16.jpg"/>"/>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!--END LOCATIONS-->

        <!--LATEST PACKAGES-->
        <div class="home-section whiteBg same-content" id="latest-packages">
            <div class="home-section-container">
                <div class="section-title">
                    <h4>Our Latest Packages</h4>
                    <h5>New Arrivals This Month</h5>
                </div>

                <div class="section-content">
                    <div class="home-packages">
                        <span class="ctrl left-ctrl"></span>
                        <span class="ctrl right-ctrl"></span>
                        <ul class="clearfix">
                            <li>
                                <div class="single-package" style="background-image: url(<c:url value="/Resources/Theme/image/trekking.png"/>)">
                                    <a href="" class="bg" ng-click="toggleDevelopingBox()">
                                        <img src="<c:url value="/Resources/Theme/image/trekking.png"/>"/>
                                    </a>
                                    <div class="package-title">
                                        <h4><a href="">A package Title</a></h4>
                                        <div class="address">
                                            <span class="icon"></span>
                                            <p>Bangkok, Thailand</p>
                                        </div>
                                    </div>

                                    <span class="package-price">
                                        $200.00
                                    </span>
                                </div>
                            </li>

                            <li>
                                <div class="single-package" style="background-image: url(<c:url value="/Resources/Theme/image/trekking.png"/>)">
                                    <a href="" class="bg" ng-click="toggleDevelopingBox()">
                                        <img src="<c:url value="/Resources/Theme/image/trekking.png"/>"/>
                                    </a>
                                    <div class="package-title">
                                        <h4><a href="">A package Title</a></h4>
                                        <div class="address">
                                            <span class="icon"></span>
                                            <p>Bangkok, Thailand</p>
                                        </div>
                                    </div>

                                    <span class="package-price">
                                        $200.00
                                    </span>
                                </div>
                            </li>

                            <li>
                                <div class="single-package" style="background-image: url(<c:url value="/Resources/Theme/image/trekking.png"/>)">
                                    <a href="" class="bg" ng-click="toggleDevelopingBox()">
                                        <img src="<c:url value="/Resources/Theme/image/trekking.png"/>"/>
                                    </a>
                                    <div class="package-title">
                                        <h4><a href="">A package Title</a></h4>
                                        <div class="address">
                                            <span class="icon"></span>
                                            <p>Bangkok, Thailand</p>
                                        </div>
                                    </div>

                                    <span class="package-price">
                                        $200.00
                                    </span>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!--END LATEST PACKAGES-->

        <!--BACKGROUND-->
        <div class="home-section whiteBg full-section same-content">
            <div class="home-section-container">
                <div id="end-bg">
                    <div id="end-bg-provider">
                        <h4>Join Asia's smartest activity selling platform.</h4>

                        <c:choose>
                            <c:when test="${empty param.language}">
                                <a href="<c:url value="/BeProvider"/>" class="btn-width-orange">Become Provider</a>
                            </c:when>
                            <c:otherwise>
                                <a href="<c:url value="/BeProvider?language=${param.language}"/>" class="btn-width-orange">Become Provider</a>
                            </c:otherwise>
                        </c:choose>

                    </div>
                </div>
            </div>
        </div>
        <!--END BACKGROUND-->

    </div>
</div>                                          
