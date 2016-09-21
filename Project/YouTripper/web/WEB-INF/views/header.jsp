<%-- 
    Document   : header
    Created on : Nov 5, 2015, 10:10:16 AM
    Author     : Nick
--%>

<script type="text/javascript">
    (function () {
        var po = document.createElement('script');
        po.type = 'text/javascript';
        po.async = true;
        po.src = 'https://apis.google.com/js/client.js?onload=onLoadCallback';
        var s = document.getElementsByTagName('script')[0];
        s.parentNode.insertBefore(po, s);
    })();
</script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${param.language}" />
<fmt:setBundle basename="LanguagePack.lang" var="lang"/>
<!DOCTYPE html>
<c:if test="${sessionScope.account == null}">
    <div id="loginModal" class="cd-user-modal" ng-controller="LoginController">

        <div class="tbl-cell">
            <!-- this is the entire modal form, including the background -->
            <div class="cd-user-modal-container">
                <!-- this is the container wrapper -->
                <ul class="cd-switcher">
                    <li><a href="">Log In</a></li>
                    <li><a href="">Sign Up</a></li>
                </ul>
                <div id="cd-login">
                    <!-- log in form -->
                    <form class="cd-form" method="POST" 
                          action="
                          <c:choose>
                              <c:when test="${empty param.language}">
                                  <c:url value="/Login"/>
                              </c:when>
                              <c:otherwise>
                                  <c:url value="/Login?language=${param.language}"/>
                              </c:otherwise>
                          </c:choose>">
                        <div class="fieldset">
                            <input class="blueInput normalFont" id="signin-email" name="email" type="email" placeholder="E-mail Address">
                            <span class="cd-error-message">Error message here!</span>
                        </div>
                        <div class="fieldset">
                            <input class="blueInput normalFont" id="signin-password" name="password" type="password" placeholder="Password">
                            <!--<a href="" class="hide-password">Show</a>-->
                            <!--<span class="cd-error-message">Error message here!</span>-->
                        </div>
                        <div class="fieldset clearfix" >

                            <div class="tempCheckbox blueInput">
                                <input type="checkbox" name="rememberMe" id="remember-me">
                                <span></span>
                            </div>
                            <p>Remember me</p>

                        </div>
                        <div class="fieldset">
                            <div style="text-align: center">
                                <a href="
                                   <c:choose>
                                       <c:when test="${empty param.language}">
                                           <c:url value="/Common/ForgotPassword"/>
                                       </c:when>
                                       <c:otherwise>
                                           <c:url value="/Common/ForgotPassword?language=${param.language}"/>
                                       </c:otherwise>
                                   </c:choose>" 
                                   style="color: #E76B4A">Forgot password?</a>
                            </div>
                        </div>
                        <div class="fieldset"><input class="btn-width-orange" type="submit" value="Log In"></div>
                        <!--                    <p style="text-align:center">Or</p>
                                            <p class="fieldset"><input class="full-width fb" type="submit" value="Log in with Facebook"></p>
                                            <p class="fieldset"><input class="full-width gplus" type="submit" value="Log in with Google +"></p>-->
                        <div class="fieldset">
                            <div class="cd-form-bottom-message">Don't have an account? <a class="cd-switcher" href="">Sign Up</a></div>
                        </div>
                    </form>
                    <!-- <a href="#0" class="cd-close-form">Close</a> -->
                </div> <!-- cd-login -->
                <div id="cd-signup-1">
                    <form class="cd-form">
                        <div class="fieldset" >
                            <input class="btn-width-orange login_fb button" ng-click="fblogin()" type="submit" value="Sign up with Facebook"></p>
                        </div>
                        <div class="fieldset" >
                            <input ng-click="googlelogin()" class="btn-width-orange login_gg button" type="submit" value="Sign up with Google +">
                        </div>
                        <div class="fieldset" >
                            <p style="text-align:center">Or</p>
                        </div>
                        <div class="fieldset" >
                            <!--<input class="full-width login" type="submit" value="Sign up with Email">-->
                            <a class="btn-width-orange" 
                               href="
                               <c:choose>
                                   <c:when test="${empty param.language}">
                                       <c:url value="/Common/Tripper/SignupPage"/>
                                   </c:when>
                                   <c:otherwise>
                                       <c:url value="/Common/Tripper/SignupPage?language=${param.language}"/>
                                   </c:otherwise>
                               </c:choose>">Sign up with Email</a>
                        </div>
                        <div class="fieldset" >
                            <p class="cd-form-bottom-message">Already have an account?  <a class="cd-switcher" href="" >Log In</a></p>
                        </div>
                    </form>
                </div>
                <div id="cd-signup-2">
                    <!-- sign up 2 form -->
                    <form class="cd-form">
                        <p class="cd-form-top-message">Already have an account? <a href="">Log In</a></p>
                        <p class="fieldset">
                            <label class="image-replace cd-username" for="signup-username">First name</label>
                            <input class="full-width has-padding has-border" id="signup-username" type="text" placeholder="First name">
                            <span class="cd-error-message">Error message here!</span>
                        </p>
                        <p class="fieldset">
                            <label class="image-replace cd-username" for="signup-username">Last name</label>
                            <input class="full-width has-padding has-border" id="signup-username" type="text" placeholder="Last name">
                            <span class="cd-error-message">Error message here!</span>
                        </p>
                        <p class="fieldset">
                            <label class="image-replace cd-username" for="signup-username">User name</label>
                            <input class="full-width has-padding has-border" id="signup-username" type="text" placeholder="User name">
                            <span class="cd-error-message">Error message here!</span>
                        </p>
                        <p class="fieldset">
                            <label class="image-replace cd-email" for="signup-email">E-mail Address</label>
                            <input class="full-width has-padding has-border" id="signup-email" type="email" placeholder="E-mail Address">
                            <span class="cd-error-message">Error message here!</span>
                        </p>
                        <p class="fieldset">
                            <label class="image-replace cd-password" for="signup-password">Password</label>
                            <input class="full-width has-padding has-border" id="signup-password" type="password" placeholder="Password">
                            <!--<a href="" class="hide-password">Show</a>-->
                            <span class="cd-error-message">Error message here!</span>
                        </p>
                        <p>Your birthday?</p>
                        <p class="fieldset">
                            <select name="birthmonth" id="birthmonth" style="color:#9c9b9b"><option value="">Month</option></select>
                            <select name="birthday" id="birthday" style="color:#9c9b9b"><option value="">Day</option></select>
                            <select name="birthyear" id="birthyear" style="color:#9c9b9b"><option value="">Year</option></select>
                        </p>
                        <p class="fieldset">
                            <input type="checkbox" id="accept-terms">
                            <label for="accept-terms">I agree to the <a href="">Terms & Conditions</a></label>
                        </p>
                        <p class="fieldset"><input class="full-width login" type="submit" value="Sign up"></p>
                        <p class="bottom-message">Sign up with your <a href="">Facebook</a> or <a href="">Google +</a></p>
                    </form>
                    <!-- <a href="#0" class="cd-close-form">Close</a> -->
                </div> <!-- cd-signup -->
                <div id="cd-reset-password">
                    <!-- reset password form -->
                    <h2 style="margin:30px 0 -10px 31px;font-size:24px;font-weight:500">Reset Password</h2>
                    <p class="cd-form-message" style="text-align:left;margin-left:5px">Enter the email address associated with your account, and we'll email you a link to reset your password.</p>
                    <form class="cd-form">
                        <p class="fieldset">
                            <label class="image-replace cd-email" for="reset-email">E-mail Address</label>
                            <input class="full-width has-padding has-border" id="reset-email" type="email" placeholder="E-mail">
                            <span class="cd-error-message">Error message here!</span>
                        </p>
                        <p class="fieldset"><input class="full-width login" type="submit" value="Send Reset Link"></p>
                    </form>
                </div> <!-- cd-reset-password -->
                <a href="#0" class="cd-close-form">Close</a>
            </div> <!-- cd-user-modal-container -->
        </div>
    </div> <!-- cd-user-modal -->
</c:if>
<!--HEADER-->
<header ng-controller="HeaderController" check-out-side ng-cloak ng-hide="headerLoading">
    <!-- NAVBAR -->
    <nav class="navbar navbar-light navbar-fixed-top" role="navigation">
        <div class="navbar-header">
            <!--LOGO-->
            <div class="navbar-brand">  
                <a href="
                   <c:choose>
                       <c:when test="${empty param.language}">
                           <c:url value="/"/>
                       </c:when>
                       <c:otherwise>
                           <c:url value="/?language=${param.language}"/>
                       </c:otherwise>
                   </c:choose>" 
                   class="logo-dark" target="_self">
                    <img src="/Images/Icon/youtripper-logo.svg" />
                </a>
                <a href="
                   <c:choose>
                       <c:when test="${empty param.language}">
                           <c:url value="/"/>
                       </c:when>
                       <c:otherwise>
                           <c:url value="/?language=${param.language}"/>
                       </c:otherwise>
                   </c:choose>" 
                   class="logo-light" target="_self">
                    <img src="/Images/Icon/youtripper-logo.svg" />
                </a>
            </div>
            <div class="navbar-brand-mini">
                <a href="<c:url value="/Home"/>">
                    <img src="<c:url value="/Images/Icon/logo.png"/>" target="_self">/>
                </a>
            </div>
            <!--Search Input (TOP)-->

            <button id="btn-search-mini"><img src="<c:url value="/Resources/Theme/image/searchtop.svg"/>" /></button>
            <div class="miniSearchInput">
                <!--<form action="<c:url value="/SmartSearch"/>" style="margin-right: 60px;">-->
                <input class="txtBoxSearch form-control normalFont" type="text"
                       placeholder="Where do you want to go?"  autocomplete="off">                    
                <!--</form>-->
                <div class="overview">
                    <div class="overview-icon">
                        <a href="" ng-click="">Menu</a>
                    </div>
                </div>
            </div>


            <!--<button id="btn-menu-mini" class="active">Menu</button>-->
            <c:if test="${sessionScope.account != null && sessionScope.account.role != 2}">
                <div class="input-group search-input col-md-3">

                    <input id="header-search-top" type="text" class="form-control" name="search" autofocus ng-model="liveSearchTop" ng-model-options="{
                                            debounce: 500
                                        }" style="font-size:14px" placeholder="Where do you want to go?" autocomplete="off">                    


                    <span class="input-group-addon" id="search-input-top">
                        <img src="<c:url value="/Resources/Theme/image/searchtop.svg"/>">
                    </span>
                    <div class="overview">
                        <!--                    <div class="overview-icon">
                                                <a href="" ng-click="activeMenu()">Menu</a>
                                            </div>-->
                        <div class="overview-menu">
                            <span class="triangle"></span>
                            <div class="menu-header">
                                <a href="" ng-click="getCurrentCity()">
                                    <span class="near-icon"></span>
                                    Place near me
                                </a>
                            </div>
                            <div class="menu-content">
                                <div class="menu-cat col-xs-6">
                                    <ul>
                                        <li ng-repeat="category in nearMeTable.categories" >
                                            <a href="<c:url value="/Categories/All"/>/{{category.categoryID}}" target="_self">
                                                {{category.categoryName}}
                                                <span>{{category.totalPackages}}</span>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="menu-country col-xs-6">
                                    <ul>
                                        <li ng-repeat="location in nearMeTable.locations">
                                            <a href="<c:url value="/Categories"/>/{{location.location}}/0"  target="_self">
                                                {{location.location}}
                                                <span>{{location.totalPackages}}</span>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
            <c:if test="${sessionScope.account == null || sessionScope.admin == null}">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </c:if>
            <c:choose>
                <c:when test="${sessionScope.account == null}">
                    <div class="navbar-user-control main-nav">
                        <ul>
                            <li><a class="cd-signup-1" href="#" target="_self">Sign Up</a></li>
                            <li><a class="cd-login" href="#" target="_self">Login</a></li>
<!--                            <li><a href="<c:url value="/Common/Help"/>">Help</a></li>-->
                            <!--<li><a ng-click="toggleCategoriesBox()">Help</a></li>-->
                            <li>
                                <a href="
                                   <c:choose>
                                       <c:when test="${empty param.language}">
                                           <c:url value="/BeProvider"/>
                                       </c:when>
                                       <c:otherwise>
                                           <c:url value="/BeProvider?language=${param.language}"/>
                                       </c:otherwise>
                                   </c:choose>" 
                                   class="btn newProviderBtn" target="_self">Become a Provider</a>
                            </li>
                            <li id="flags">
                                <a href="" ng-click="">
                                    <c:choose>
                                        <c:when test="${param.language eq 'th'}">
                                            <img width="20" src="<c:url value="/Resources/Theme/image/thaiflag.png"/>"/>
                                        </c:when>
                                        <c:otherwise>
                                            <img width="20" src="<c:url value="/Images/Icon/engflag.png"/>"/>
                                        </c:otherwise>
                                    </c:choose>
                                </a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a href="<c:url value="/Common/LanguageSetting"/>">                                  
                                            <span> <img width="20" src="<c:url value="/Images/Icon/engflag.png"/>"/></span>
                                            English
                                        </a>
                                    </li>
                                    <li>
                                        <a href="<c:url value="/Common/LanguageSetting?language=th"/>" >
                                            <span> <img width="20" src="<c:url value="/Resources/Theme/image/thaiflag.png"/>"/></span>
                                            Thai
                                        </a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </c:when>
                <c:when test="${sessionScope.account.role == 2}">
                    <div ng-init="connect()" class="navbar-user-control-provider">
                        <div id="create-btn">
                            <div class="tbl-center">
                                <div class="tbl-cell">
                                    <a href="
                                       <c:choose>
                                           <c:when test="${empty param.language }">
                                               <c:url value="/Provider/Package/Registration"/>
                                           </c:when>
                                           <c:otherwise>
                                               <c:url value="/Provider/Package/Registration?language=${param.language}"/>
                                           </c:otherwise>
                                       </c:choose>">Create package</a>
                                </div>
                            </div>
                        </div>
                        <div class="dropdown drop-email header-dropdown">
                            <a class="tbl-center" href="
                               <c:choose>
                                   <c:when test="${empty param.language }">
                                       <c:url value="/Provider/Dashboard"/>
                                   </c:when>
                                   <c:otherwise>
                                       <c:url value="/Provider/Dashboard?language=${param.language}"/>
                                   </c:otherwise>
                               </c:choose>" 
                               ng-click="">
                                <div class="tbl-cell">
                                    TrippDash™
                                </div>
                            </a>
                        </div>
                        <div id="userAvatar" class="dropdown drop-user  header-dropdown" detect-hover>
                            <a class="tbl-center" href="" ng-click="">
                                <div class="tbl-cell">
                                    <img id="avatarImage" alt="" src="/${sessionScope.account.image}?{{currentTimestamp}}" />
                                    <span>${sessionScope.account.name}</span>
                                </div>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="
                                       <c:choose>
                                           <c:when test="${empty param.language}">
                                               <c:url value="/Provider/AccountInfo"/>
                                           </c:when>
                                           <c:otherwise>
                                               <c:url value="/Provider/AccountInfo?language=${param.language}"/>
                                           </c:otherwise>
                                       </c:choose>" 
                                       target="_self">My Profile</a></li>
<!--                                <li><a href="<c:url value="/Provider/Package"/>" target="_self">Your Packages</a></li>-->
<!--                                <li><a href="<c:url value="/Provider/CertificateManagement"/>" target="_self">Your Certificate</a></li>
                                <li><a href="<c:url value="/Provider/PassportManagement"/>" target="_self">Your Passport</a></li>-->
<!--                                <li><a href="<c:url value="/Provider/Package/Registration"/>" target="_self">Create Your Package</a></li>-->
                                <!--                                <li><a ng-click="toggleCategoriesBox()" href="" target="_self">Create Your Package</a></li>-->
                                <!--                                <li><a href="<c:url value="/Provider/BookingEngine"/>" target="_self">Booking Engine</a></li>-->
                                <!--                                <li><a href="<c:url value="/Provider/ResourceManagement"/>">TrippSource Management</a></li>-->
                                <!--                                <li><a href="<c:url value="/Provider/InviteFriend"/>" target="_self">Invite Your Friends</a></li>-->
                                <li><a href="
                                       <c:choose>
                                           <c:when test="${empty param.language}">
                                               <c:url value="/Common/Logout"/>
                                           </c:when>
                                           <c:otherwise>
                                               <c:url value="/Common/Logout?language=${param.language}"/>
                                           </c:otherwise>
                                       </c:choose>" 
                                       target="_self">Logout</a></li>
                            </ul>
                        </div>
                        <div class="dropdown drop-email  header-dropdown" detect-hover>
                            <a class="header-item-center tbl-center" ng-click="" href="">
                                <div class="tbl-cell">
                                    <span class="email-inbox">
                                        <em style="display: none" id="ProviderNumOfNoti" ng-model="providerNoti"></em>
                                    </span>
                                </div>
                                <!--Message-->
                                <!--<span class="caret"></span>-->
                            </a>
                            <ul class="dropdown-menu">
                                <li ng-show="notificationList.length <= 0">No messages!</li>
                                <li ng-click="decreaseNumForProvider(x.notificationID, '<c:url value="/"/>' + x.content.URL)" 
                                    ng-repeat="x in notificationList">
                                    <a ng-href="">{{x.content.Message}}
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <div class="dropdown drop-email header-dropdown"  detect-hover>
                            <a class="tbl-center" 
                               href="" 
                               ng-click="">
                                <div class="tbl-cell">
                                    <c:choose>
                                        <c:when test="${param.language eq 'th'}">
                                            <img width="30" src="<c:url value="/Resources/Theme/image/thaiflag.png"/>"/>
                                        </c:when>
                                        <c:otherwise>
                                            <img width="30" src="<c:url value="/Images/Icon/engflag.png"/>"/>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="<c:url value="/Common/LanguageSetting"/>">                                  
                                        <span> <img width="20" src="<c:url value="/Images/Icon/engflag.png"/>"/></span>
                                        English
                                    </a>
                                </li>
                                <li>
                                    <a href="<c:url value="/Common/LanguageSetting?language=th"/>">
                                        <span> <img width="20" src="<c:url value="/Resources/Theme/image/thaiflag.png"/>"/></span>
                                        Thai
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <!--                        <div class="dropdown drop-email  header-dropdown" detect-hover>
                                                    <a ng-click="toggleCategoriesBox()" class="header-item-center tbl-center" id="dLabel">
                                                        <div class="tbl-cell">
                                                            Help
                                                        </div>
                                                    </a>
                                                </div>-->
                    </div>
                </c:when>
                <c:when test="${sessionScope.account.role == 1}">
                    <div ng-init="connect()" class="navbar-user-control-provider" >
                        <div class="dropdown drop-user header-dropdown"  detect-hover>
                            <a class="tbl-center" href="" ng-click="">
                                <div class="tbl-cell">
                                    <img id="avatarImage" alt="" src="/${sessionScope.account.image}?{{currentTimestamp}}" />
                                    ${sessionScope.account.name}
                                </div>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="
                                       <c:choose>
                                           <c:when test="${empty param.language }">
                                               <c:url value="/Tripper/AccountInfo"/>
                                           </c:when>
                                           <c:otherwise>
                                               <c:url value="/Tripper/AccountInfo?language=${param.language}"/>
                                           </c:otherwise>
                                       </c:choose>" 
                                       target="_self">Your Profile</a></li>
                                <li><a href="
                                       <c:choose>
                                           <c:when test="${empty param.language}">
                                               <c:url value="/Tripper/BucketList"/>
                                           </c:when>
                                           <c:otherwise>
                                               <c:url value="/Tripper/BucketList?language=${param.language}"/>
                                           </c:otherwise>
                                       </c:choose>" 
                                       target="_self">Your Bucket List</a></li>
<!--                                <li><a href="<c:url value="/Tripper/BookingList"/>" target="_self">Your Bookings</a></li>
                                <li><a href="#" target="_self">Invite Your Friends</a></li>-->
                                <li><a href="<c:url value="/Common/Logout"/>" target="_self">Logout</a></li>
                            </ul>
                        </div>
                        <div class="dropdown drop-email header-dropdown" detect-hover>
                            <a class="tbl-center" ng-click="" href="" >
                                <div class="tbl-cell">
                                    <span class="email-inbox">
                                        <em style="display: none" id="TripperNumOfNoti" ng-model="tripperNoti"></em>
                                    </span>
                                </div>
                                <!--Message-->
                                <!--<span class="caret"></span>-->
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="dLabel">
                                <li ng-show="notificationList.length <= 0">No messages!</li>
                                <li ng-click="decreaseNumForTripper(x.notificationID, '<c:url value="/"/>' + x.content.URL)" 
                                    ng-repeat="x in notificationList">
                                    <a ng-href="">{{x.content.Message}}
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <!--                        <div class="dropdown drop-email  header-dropdown" detect-hover>
                                                    <a id="dLabel" class="tbl-center">
                                                        <div class="tbl-cell">
                                                            Help
                                                        </div>
                                                    </a>
                                                </div>-->
                    </div>
                </c:when>
                <c:when test="${sessionScope.account.role == 3 || sessionScope.account.role == 4}">
                    <div class="navbar-user-control-provider" style="margin:20px 40px 0px 0px;">
                        <a href="<c:url value="/Admin/Logout"/>" target="_self">Logout</a>
                        <span>|</span>
                        <a href="<c:url value="/Admin"/>" target="_self">Dashboard</a>
                    </div>
                </c:when>
                <c:otherwise>

                </c:otherwise>
            </c:choose>
        </div>
        <c:if test="${sessionScope.account == null}">
            <!--Nav Collapse-->
            <div id="hamburgerContainer" class="">
                <ul>
                    <li><a class="href-white" 
                           href="
                           <c:choose>
                               <c:when test="${empty param.language}">
                                   <c:url value="/Common/Tripper/SignupPage"/>
                               </c:when>
                               <c:otherwise>
                                   <c:url value="/Common/Tripper/SignupPage?language=${param.language}"/>
                               </c:otherwise>
                           </c:choose>" 
                           target="_self">Sign Up</a></li>                    
                    <li><a class="href-white" href="" target="_self">Login</a></li>
                    <!--<li><a class="href-white" href="<c:url value="/Common/Help"/>">Help</a></li>-->
                    <li><a class="href-white" 
                           href="
                           <c:choose>
                               <c:when test="${empty param.language}">
                                   <c:url value="/BeProvider"/>
                               </c:when>
                               <c:otherwise>
                                   <c:url value="/BeProvider?language=${param.language}"/>
                               </c:otherwise>
                           </c:choose>" 
                           target="_self">Be a Provider</a></li>                    
                </ul>
            </div>            
        </c:if>
        <c:if test="${sessionScope.account.role == 1}">
            <!--Nav Collapse-->
            <div id="hamburgerContainer" class="tbl-center">
                <div class="tbl-cell">
                    <img style="height: 40px" alt="" src="/${sessionScope.account.image}" /><br>
                    <div style="color: white">${sessionScope.account.name} </div>
                </div>
                <ul>
                    <li ng-class="{
                            'active'
                                    : (page === 'Info')}"><a class="href-white" 
                         href="
                         <c:choose>
                             <c:when test="${empty param.language }">
                                 <c:url value="/Tripper/AccountInfo"/>
                             </c:when>
                             <c:otherwise>
                                 <c:url value="/Tripper/AccountInfo?language=${param.language}"/>
                             </c:otherwise>
                         </c:choose>">Account</a></li>
                    <li ng-class="{
                            'active'
                                    : (page === 'tripperMessage')}">
                        <a class="href-white" id="dLabel1" 
                           href="
                           <c:choose>
                               <c:when test="${empty param.language }">
                                   <c:url value="/Tripper/Chat"/>
                               </c:when>
                               <c:otherwise>
                                   <c:url value="/Tripper/Chat?language=${param.language}"/>
                               </c:otherwise>
                           </c:choose>">
                            <span>
                                <em style="display: none" id="TripperNumOfNoti2" ng-model="tripperNoti"></em>
                            </span>
                            Message                           
                        </a>
                    </li>
                    <li ng-class="{
                            'active'
                                    : (page === 'bucketPackages')}"><a class="href-white" 
                         href="
                         <c:choose>
                             <c:when test="${empty param.language}">
                                 <c:url value="/Tripper/BucketList"/>
                             </c:when>
                             <c:otherwise>
                                 <c:url value="/Tripper/BucketList?language=${param.language}"/>
                             </c:otherwise>
                         </c:choose>">Your Bucket List</a></li>
                    <li ng-class="{
                            'active'
                                    : (page === 'tripperNotification')}"><a class="href-white" 
                         href="
                         <c:choose>
                             <c:when test="${empty param.language}">
                                 <c:url value="/Tripper/Notification"/>
                             </c:when>
                             <c:otherwise>
                                 <c:url value="/Tripper/Notification?language=${param.language}"/>
                             </c:otherwise>
                         </c:choose>">Notification</a></li>
                    <li ng-class="{
                            'active'
                                    : (page === 'tripperPassword')}"><a class="href-white" 
                         href="
                         <c:choose>
                             <c:when test="${empty param.language}">
                                 <c:url value="/Tripper/Password"/>
                             </c:when>
                             <c:otherwise>
                                 <c:url value="/Tripper/Password?language=${param.language}"/>
                             </c:otherwise>
                         </c:choose>">Password</a></li>
                    <li ng-class="{
                            'active'
                                    : (page === 'tripperBookings')}"><a class="href-white" 
                         href="
                         <c:choose>
                             <c:when test="${empty param.language}">
                                 <c:url value="/Tripper/Booking"/>
                             </c:when>
                             <c:otherwise>
                                 <c:url value="/Tripper/Booking?language=${param.language}"/>
                             </c:otherwise>
                         </c:choose>">Your Bookings</a></li>                    
                    <li><a class="href-white" href="<c:url value="/Common/Logout"/>">Logout</a></li>
                </ul>
            </div>            
        </c:if>
        <c:if test="${sessionScope.account.role == 2}">
            <!--Nav Collapse-->
            <div id="hamburgerContainer" class="">
                <img style="height: 40px" alt="" src="/${sessionScope.account.image}" /><br>
                <div style="color: white">${sessionScope.account.name} </div>
                <ul>
                    <li ng-class="{
                            'active'
                                    : (page === 'Info')}"><a class="href-white" 
                         href="
                         <c:choose>
                             <c:when test="${empty param.language}">
                                 <c:url value="/Provider/AccountInfo"/>
                             </c:when>
                             <c:otherwise>
                                 <c:url value="/Provider/AccountInfo?language=${param.language}"/>
                             </c:otherwise>
                         </c:choose>">Account</a></li>
                    <li ng-class="{
                            'active'
                                    : (page === 'providerMessage')}">
                        <a class="href-white" id="dLabel1" 
                           href="
                           <c:choose>
                               <c:when test="${empty param.language }">
                                   <c:url value="/Provider/Chat"/>
                               </c:when>
                               <c:otherwise>
                                   <c:url value="/Provider/Chat?language=${param.language}"/>
                               </c:otherwise>
                           </c:choose>">
                            <span>
                                <em style="display: none" id="ProviderNumOfNoti2" ng-model="providerNoti"></em>

                            </span>
                            Message                           
                        </a>
                    </li>
                    <li ng-class="{
                            'active'
                                    : (page === 'providerPackage')}"><a class="href-white" 
                         href="
                         <c:choose>
                             <c:when test="${empty param.language}">
                                 <c:url value="/Provider/Package"/>
                             </c:when>
                             <c:otherwise>
                                 <c:url value="/Provider/Package?language=${param.language}"/>
                             </c:otherwise>
                         </c:choose>">Your Package</a></li>
                    <li ng-class="{
                            'active'
                                    : (page === 'providerNotification')}"><a class="href-white" 
                         href="
                         <c:choose>
                             <c:when test="${empty param.language }">
                                 <c:url value="/Provider/Notification"/>
                             </c:when>
                             <c:otherwise>
                                 <c:url value="/Provider/Notification?language=${param.language}"/>
                             </c:otherwise>
                         </c:choose>">Notification</a></li>
                    <li ng-class="{
                            'active'
                                    :(page === 'providerPassword')}"><a class="href-white" 
                         href="
                         <c:choose>
                             <c:when test="${empty param.language }">
                                 <c:url value="/Provider/Password"/>
                             </c:when>
                             <c:otherwise>
                                 <c:url value="/Provider/Password?language=${param.language}"/>
                             </c:otherwise>
                         </c:choose>">Password</a></li>
                    <li ng-class="{
                            'active'
                                    :(page === 'providerBookings')}"><a class="href-white" 
                         href="
                         <c:choose>
                             <c:when test="${empty param.language }">
                                 <c:url value="/Provider/Booking"/>
                             </c:when>
                             <c:otherwise>
                                 <c:url value="/Provider/Booking?language=${param.language}"/>
                             </c:otherwise>
                         </c:choose>">Bookings</a></li>
                    <li ng-class="{
                            'active'
                                    : (page === 'providerSale')}"><a class="href-white" 
                         href="
                         <c:choose>
                             <c:when test="${empty param.language }">
                                 <c:url value="/Provider/Sales"/>
                             </c:when>
                             <c:otherwise>
                                 <c:url value="/Provider/Sales?language=${param.language}"/>
                             </c:otherwise>
                         </c:choose>">Sales</a></li>
                    <li ng-class="{
                            'active'
                                    : (page === 'payment')}"><a class="href-white" href="#">Payment</a></li>   
                    <li><a  class="href-white" href="<c:url value="/Common/Logout"/>">Logout</a></li>
                </ul>
            </div>
        </c:if>

    </nav><!--navbar end-->
    <!-- A BACKUP AT THE END OF THIS FILE -->
    <c:if test="${requestScope.page == 'Homepage'}">
        <div id="nav-header" ng-show="fromHomePage">
            <div class="bannerNew" style='overflow: initial; position: relative;'>

                <div class="bannerBackground active" style='background-image: url(Images/HomeCover/home1.jpg);'>

                </div>
                <div class="bannerBackground" style='background-image: url(Images/HomeCover/home2.jpg);'>

                </div>
                <div class="bannerBackground" style='background-image: url(Images/HomeCover/home3.jpg);'>

                </div>
                <div class="bannerBackground" style='background-image: url(Images/HomeCover/home4.jpg);'>

                </div>
                <div class="bannerBackground" style='background-image: url(Images/HomeCover/home5.jpg);'>

                </div>
                <div class="bannerBackground" style='background-image: url(Images/HomeCover/home6.jpg);'>

                </div>
                <div class="bannerBackground" style='background-image: url(Images/HomeCover/home7.jpg);'>

                </div>
                <div class="bannerBackground" style='background-image: url(Images/HomeCover/home8.jpg);'>

                </div>
                <div class="bannerBackground" style='background-image: url(Images/HomeCover/home9.jpg);'>

                </div>
                <div class="bannerBackground" style='background-image: url(Images/HomeCover/home10.jpg);'>

                </div>
                <div class="banner-bg-op">

                </div>

                <div id="how-it-work">
                    <!--<a class="close-button"></a>-->
                    <span class="close-button" ng-click="toggleHowToWork()"></span>
                    <div class="container">
                        <div class="tbl-center">
                            <div class="tbl-cell">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <h3 class="header">
                                            <fmt:message key="howitwork.text" bundle="${lang}"/>
                                        </h3>
                                    </div>
                                    <div class="col-xs-4">
                                        <div class="single-inst">
                                            <img src="Images/Icon/howtowork1.svg"/>
                                            <h5> 
                                                <fmt:message key="howitwork.col1.header" bundle="${lang}"/>
                                            </h5>
                                            <p>
                                                <fmt:message key="howitwork.col1.content" bundle="${lang}"/>
                                            </p>
                                        </div>
                                    </div>
                                    <div class="col-xs-4">
                                        <div class="single-inst">
                                            <img src="Images/Icon/howtowork2.svg"/>
                                            <h5>
                                                <fmt:message key="howitwork.col2.header" bundle="${lang}"/>
                                            </h5>
                                            <p>
                                                <fmt:message key="howitwork.col2.content" bundle="${lang}"/>
                                            </p>
                                        </div>
                                    </div>
                                    <div class="col-xs-4">
                                        <div class="single-inst">
                                            <img src="Images/Icon/howtowork3.svg"/>
                                            <h5>
                                                <fmt:message key="howitwork.col3.header" bundle="${lang}"/>
                                            </h5>
                                            <p>
                                                <fmt:message key="howitwork.col3.content" bundle="${lang}"/>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="header-title-box">
                    <div>
                        <span>Live Life Outside™<br><span id="discoverText">Discover</span></span>

                        <ul data-spinner>
                            <li class="slideText shorttext">Adventure</li>
                            <li class="slideText shorttext">Challenge</li>
                            <li class="slideText shorttext">Friendship</li>
                            <li class="slideText shorttext">Happiness</li>
                            <li class="slideText">Healthiness</li>
                            <li class="slideText shorttext">Knowledge</li>
                            <li class="slideText">Peacefulness</li>
                            <li class="slideText shorttext">Romance</li>
                            <li class="slideText">Sophistication</li>
                            <li class="slideText shorttext">Unexpected</li>
                        </ul>
                    </div>
                    <a href="" class="btn-width-orange btn-filter-black" ng-click="toggleHowToWork()">How it works</a>
                </div>

                <!--Search Input--> 
                <div id="home-search-input">
                    <div class="yt-container">
                        <div class="clearfix">
                            <form 
                                action="
                                <c:choose>
                                    <c:when test="${empty param.language}">
                                        <c:url value="/citySearch"/>
                                    </c:when>
                                    <c:otherwise>
                                        <c:url value="/citySearch?language=${param.language}"/>
                                    </c:otherwise>
                                </c:choose>" 
                                method="POST">
                                <div class="input-box ">
                                    <div class="dropdown">
                                        <div ng-init="citys = [{name:'Bangkok'}, {name:'Pattaya'}, {name:'Sukhothai'}, {name:'Kanchanaburi'}, {name:'Chiangmai'}, {name:'Phuket'}]"></div>
                                        <input name="cityName" ng-model="searchValue" ng-click="searchFunction()" type="text" placeholder="Where do you want to go?" class="normalFont dropbtn"/>
                                        <div id="searchDropdown" class="dropdown-content" >
                                            <ul>
                                                <li ng-repeat="city in citys| filter:searchValue">
                                                    <p ng-click="getCity(city.name)">{{city.name}}</p>
                                                </li>
                                            </ul>
                                        </div>

                                    </div>
                                    <!--tam thoi bo date-->
                                    <!--<input type="button" value="Date" />-->
                                </div>
                                <div class="btn-box">
                                    <button type="submit" class="btn-width-orange" value="Search">Search</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!--END SEARCH INPUT-->

                <!--CATEGORIES-->
                <div id="header-categories">
                    <!--DEVELOPING POPUP-->
                    <div class="ytPopup" id="categoriesBox">
                        <div class="tbl-cell noClick" ng-controller="DevelopingControler">
                            <div class="popupContent" >
                                <div class="center-informBlock blur-backgroud" ng-show="!sendInfo">
                                    <div class="small-spinner" ></div>
                                </div>
                                <span class="box-closing" ng-click="toggleCategoriesBox()"></span>
                                <div class="popupScroll">
                                    <div style="text-align: center; color: #000">
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
                    <ul class="clearfix">
                        <li class="big-section">
                            <div class="horizontal-section">
                                <ul class="clearfix">
                                    <li>
                                        <div class="vertical-section">
                                            <ul class="clearfix">
                                                <li class="single-category">
                                                    <div class="tbl-center">
                                                        <div class="tbl-cell">
                                                            <div class="category-content clearfix">
                                                                <img src="<c:url value="/Images/CategoriesHome/extreme.svg"/>"/>
                                                                <h3>EXTREME SPORTS</h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <a href="" ng-click="toggleCategoriesBox()"><span>EXTREME SPORTS</span></a>
                                                </li>
                                                <li class="single-category">
                                                    <div class="tbl-center">
                                                        <div class="tbl-cell">
                                                            <div class="category-content clearfix">
                                                                <img src="<c:url value="/Images/CategoriesHome/edu.svg"/>"/>
                                                                <h3>EDUCATION</h3>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <a href="" ng-click="toggleCategoriesBox()"><span>EDUCATION</span></a>
                                                </li>
                                            </ul>
                                        </div>
                                    </li>
                                    <li class="single-category">
                                        <div class="tbl-center">
                                            <div class="tbl-cell">
                                                <div class="category-content clearfix">
                                                    <img src="<c:url value="/Images/CategoriesHome/beauty.svg"/>"/>
                                                    <h3>BEAUTY & SPA</h3>
                                                </div>
                                            </div>
                                        </div>
                                        <a href="" ng-click="toggleCategoriesBox()"><span>BEAUTY & SPA</span></a>
                                    </li>
                                </ul>
                            </div>  
                        </li>

                        <li class="big-section">
                            <div class="vertical-section">
                                <ul class="clearfix">
                                    <li class="single-category">
                                        <div class="tbl-center">
                                            <div class="tbl-cell">
                                                <div class="category-content clearfix">
                                                    <img src="<c:url value="/Images/CategoriesHome/outdoors.svg"/>"/>
                                                    <h3>OUTDOORS</h3>
                                                </div>
                                            </div>
                                        </div>
                                        <a href="" ng-click="toggleCategoriesBox()"><span>OUTDOORS</span></a>
                                    </li>
                                    <li class="horizontal-section">
                                        <ul>
                                            <li class="single-category">
                                                <div class="tbl-center">
                                                    <div class="tbl-cell">
                                                        <div class="category-content clearfix">
                                                            <img src="<c:url value="/Images/CategoriesHome/health.svg"/>"/>
                                                            <h3>MEDICAL HEALTHCARE</h3>
                                                        </div>
                                                    </div>
                                                </div>
                                                <a href="" ng-click="toggleCategoriesBox()"><span>MEDICAL HEALTHCARE</span></a>
                                            </li>
                                            <li class="single-category">
                                                <div class="tbl-center">
                                                    <div class="tbl-cell">
                                                        <div class="category-content clearfix">
                                                            <img src="<c:url value="/Images/CategoriesHome/motor.svg"/>"/>
                                                            <h3>MOTOR SPORTS</h3>
                                                        </div>
                                                    </div>
                                                </div>
                                                <a href="" ng-click="toggleCategoriesBox()"><span>MOTOR SPORTS</span></a>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </li>

                        <li class="big-section">
                            <div class="horizontal-section">
                                <ul class="clearfix">
                                    <li  class="single-category">
                                        <div class="tbl-center">
                                            <div class="tbl-cell">
                                                <div class="category-content clearfix">
                                                    <img src="<c:url value="/Images/CategoriesHome/water.svg"/>"/>
                                                    <h3>WATER SPORTS</h3>
                                                </div>
                                            </div>
                                        </div>
                                        <a href="" ng-click="toggleCategoriesBox()"><span>WATER SPORTS</span></a>
                                    </li>
                                    <li class="vertical-section">
                                        <ul>
                                            <li  class="single-category">
                                                <div class="tbl-center">
                                                    <div class="tbl-cell">
                                                        <div class="category-content clearfix">
                                                            <img src="<c:url value="/Images/CategoriesHome/indoor.svg"/>"/>
                                                            <h3>INDOORS</h3>
                                                        </div>
                                                    </div>
                                                </div>
                                                <a href="" ng-click="toggleCategoriesBox()"><span>INDOORS</span></a>
                                            </li>
                                            <li  class="single-category">
                                                <div class="tbl-center">
                                                    <div class="tbl-cell">
                                                        <div class="category-content clearfix">
                                                            <img src="<c:url value="/Images/CategoriesHome/culture.svg"/>"/>
                                                            <h3>ARTS & CULTURE</h3>
                                                        </div>
                                                    </div>
                                                </div>
                                                <a href="" ng-click="toggleCategoriesBox()"><span>ARTS & CULTURE</span></a>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </li>
                    </ul>

                </div>
            </div>
        </div>
    </c:if>

    <script>
                            var search = '${param.search}';
                            var userID = '';
                            var userRole = 0;
        <c:choose>
            <c:when test="${requestScope.nearMeTable != null}">
                            var tableHeader = ${requestScope.nearMeTable};

            </c:when>
            <c:otherwise>
                            var tableHeader = {};

            </c:otherwise>
        </c:choose>

        <c:if test="${sessionScope.account != null && sessionScope.account.role != 3 && sessionScope.account.role != 4}">
                            userID = ${sessionScope.account.id};
                            userRole = ${sessionScope.account.role};
        </c:if>
                            jQuery.fn.putCursorAtEnd = function () {

                                return this.each(function () {

                                    $(this).focus()

                                    // If this function exists...
                                    if (this.setSelectionRange) {
                                        // ... then use it (Doesn't work in IE)

                                        // Double the length because Opera is inconsistent about whether a carriage return is one character or two. Sigh.
                                        var len = $(this).val().length * 2;

                                        this.setSelectionRange(len, len);

                                    } else {
                                        // ... otherwise replace the contents with itself
                                        // (Doesn't work in Google Chrome)

                                        $(this).val($(this).val());

                                    }

                                    // Scroll to the bottom, in case we're in a tall textarea
                                    // (Necessary for Firefox and Google Chrome)
                                    this.scrollTop = 999999;

                                });

                            };

                            $("#header-search-top").putCursorAtEnd();


                            //facebook sdk config
                            window.fbAsyncInit = function () {
                                FB.init({
                                    appId: '295105870823227',
                                    cookie: true, // enable cookies to allow the server to access 
                                    // the session
                                    xfbml: true, // parse social plugins on this page
                                    version: 'v2.6' // use graph api version 2.5

                                });
                            };
                            // Load the SDK asynchronously
                            (function (d, s, id) {
                                var js, fjs = d.getElementsByTagName(s)[0];
                                if (d.getElementById(id))
                                    return;
                                js = d.createElement(s);
                                js.id = id;
                                js.src = "//connect.facebook.net/en_US/sdk.js";
                                fjs.parentNode.insertBefore(js, fjs);
                            }(document, 'script', 'facebook-jssdk'));
                            //Google login


// Close the dropdown if the user clicks outside of it

                            window.onclick = function (event) {
                                if (!event.target.matches('.dropbtn')) {

                                    var dropdowns = document.getElementsByClassName("dropdown-content");
                                    var i;
                                    for (i = 0; i < dropdowns.length; i++) {
                                        var openDropdown = dropdowns[i];
                                        if (openDropdown.classList.contains('show')) {
                                            openDropdown.classList.remove('show');
                                        }
                                    }
                                }
                            }

    </script>
</header>   
