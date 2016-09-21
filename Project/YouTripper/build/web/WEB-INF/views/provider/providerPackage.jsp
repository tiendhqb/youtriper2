<%-- 
    Document   : createdPackageManagement
    Created on : Oct 20, 2015, 4:49:10 PM
    Author     : Nick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="background-provider">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=1366">
        <!--        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1">-->
        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/jquery.fs.boxer.css"/>" rel="stylesheet">


        <%@ include file="../angular.jsp" %>

        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css?999999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css?999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripperResponsive.css"/>" >

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.fs.boxer.js"/>"></script>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >
        <title>Youtripper - Provider Packages</title>
    </head>
    <body>
        <div ng-app="YouTripper" ng-controller="ProviderPackages" class="pagesearch bg-grey" >
            <%@ include file="../header.jsp" %>
            <%@ include file="providerMenubar.jsp" %>

            <!--DEVELOPING POPUP-->
            <div class="ytPopup" id="developingBox"  >
                <div class="tbl-cell" ng-controller="DevelopingControler">
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
            <!--Stop Popup  -->
            <div class="ytPopup" id="stopPopup" class="stopPopup">
                <div class="tbl-cell">
                    <div class="popupContent">
                        <div class="center-informBlock blur-backgroud" ng-show="stopProcessing">
                            <div class="small-spinner" ></div>
                        </div>
                        <span class="box-closing" ng-click="toggleStopBox()"></span>
                        <div class="popupScroll">
                            <div class="popupRow">
                                <div class="row">
                                    <div class="col-xs-12 stop-package-popup">
                                        <p>Turning off this package will make it unavailable for bookings and <br> remove it from any listings, results and ranking on the youtripper site. 
                                            <br>
                                            <br>
                                            However, you are still required to honor your commitment to all <br> upcoming bookings after turning off this package. 
                                            <br> You can read more about package management <a href="" style="color:#3FBDC5">here.</a></p>
                                        <br>
                                        <p style="color:#000">Are you sure you want to turn this package off? </p>
                                    </div>
                                </div>
                            </div>
                            <div class="popupRow">
                                <div class="row">
                                    <div class="col-xs-6">
                                        <a class="btn-width-orange next-btn" ng-click="stopPackage()">Turn it off</a>
                                    </div>
                                    <div class="col-xs-6">
                                        <a class="btn btn-width-blue next-btn" ng-click="toggleStopBox()">Keep it running</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Clone Package popup-->
            <div class="ytPopup" id="clonePackPopup" class="">
                <div class="tbl-cell">
                    <div class="popupContent" style="width:460px;">
                        <div class="center-informBlock blur-backgroud" ng-show="stopProcessing">
                            <div class="small-spinner" ></div>
                        </div>
                        <!--<span class="box-closing" ng-click="toggleStopDeleteBox()"></span>-->

                        <div class="popupRow">
                            <div class="row">
                                <div class="col-xs-12">
                                    <p style="color:#FF514E; text-align: center;">Please choose which package details you would like to clone.</p>
                                </div>
                            </div>
                        </div>
                        <div class="popupRow" style="padding:0px 25px;">

                            <div class="row">
                                <div class="col-xs-6">
                                    <div class="tempCheckbox squareInput">
                                        <input type="checkbox" class="" ng-model="clonePart.all"
                                               ng-click="validateCloneAll()" ng-true-value="true" ng-false-value="false" />
                                        <span></span>
                                    </div>
                                    All Details
                                </div>
                                <div class="col-xs-6">
                                    <div class="tempCheckbox squareInput">
                                        <input type="checkbox" class="" ng-model="clonePart.category"
                                               ng-click="validateClone()" ng-true-value="true" ng-false-value="false" />
                                        <span></span>
                                    </div>
                                    Category
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-6">
                                    <div class="tempCheckbox squareInput">
                                        <input type="checkbox" class="" ng-model="clonePart.description"
                                               ng-click="validateClone()" ng-true-value="true" ng-false-value="false" />
                                        <span></span>
                                    </div>
                                    Description
                                </div>
                                <div class="col-xs-6">
                                    <div class="tempCheckbox squareInput">
                                        <input type="checkbox" class="" ng-model="clonePart.photos"
                                               ng-click="validateClone()" ng-true-value="true" ng-false-value="false" />
                                        <span></span>
                                    </div>
                                    Photos
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-6">
                                    <div class="tempCheckbox squareInput">
                                        <input type="checkbox" class="" ng-model="clonePart.booking"
                                               ng-click="validateClone()" ng-true-value="true" ng-false-value="false" />
                                        <span></span>
                                    </div>
                                    Booking Setup
                                </div>
                                <div class="col-xs-6">
                                    <div class="tempCheckbox squareInput">
                                        <input type="checkbox" class="" ng-model="clonePart.pricing"
                                               ng-click="validateClone()" ng-true-value="true" ng-false-value="false" />
                                        <span></span>
                                    </div>
                                    Pricing
                                </div>
                            </div>

                        </div>
                        <div class="popupRow">
                            <div class="row">
                                <div class="col-xs-6">
                                    <a ng-click="closeClonePackagePopup()"  target="_self" class="btn-width-orange next-btn">Cancel</a>
                                </div>
                                <div class="col-xs-6">
                                    <a ng-show="!penddingStatus" class="btn btn-width-blue next-btn" ng-click="checkClonePackage(clonePackageID, 'approved')">Clone</a>
                                    <a ng-show="penddingStatus" class="btn btn-width-blue next-btn" ng-click="checkClonePackage(clonePackageID, 'pending')">Clone</a>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
            <!-- Get info popup-->
            <div class="ytPopup" id="getInfoPopup" class="">
                <div class="tbl-cell">
                    <div class="popupContent" style="width:460px;">
                        <div class="center-informBlock blur-backgroud" ng-show="stopProcessing">
                            <div class="small-spinner" ></div>
                        </div>
                        <!--<span class="box-closing" ng-click="toggleStopDeleteBox()"></span>-->
                        <div class="popupScroll">
                            <div class="popupRow">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <p style="color:#FF514E; text-align: center;">Package Information</p>
                                    </div>
                                </div>
                            </div>
                            <div class="popupRow" style="padding:0px 25px;">

                                <div class="row">
                                    <div class="col-xs-6">Date of Creation:</div>
                                    <div class="col-xs-6">19 - Jun - 2015</div>
                                </div>
                                <div class="row">
                                    <div class="col-xs-6">Total Package Views:</div>
                                    <div class="col-xs-6">123</div>
                                </div>
                                <div class="row">
                                    <div class="col-xs-6">Total Package Gross:</div>
                                    <div class="col-xs-6">$456</div>
                                </div>
                                <div class="row">
                                    <div class="col-xs-6">Total Package Reviews:</div>
                                    <div class="col-xs-6">78</div>
                                </div>
                                <div class="row">
                                    <div class="col-xs-6">Avg. Conversion Rate:</div>
                                    <div class="col-xs-6">4.87%</div>
                                </div>
                                <div class="row">
                                    <div class="col-xs-6">Registered Walk-In Price:</div>
                                    <div class="col-xs-6">$110.00</div>
                                </div>
                            </div>
                            <div class="popupRow">
                                <div class="row">
                                    <div class="col-xs-6">
                                        <a href="<c:url value="/Provider/Package/Editing"/>/{{packageInfoID}}" target="_self" class="btn-width-orange next-btn">Go to Edit</a>
                                    </div>
                                    <div class="col-xs-6">
                                        <a class="btn btn-width-blue next-btn" ng-click="toggleGetInfoBox()">Close</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!--Stop Popup  When click delete -->
            <div class="ytPopup" id="stopPopupWhenDelete" class="stopPopup">
                <div class="tbl-cell">
                    <div class="popupContent">
                        <div class="center-informBlock blur-backgroud" ng-show="stopProcessing">
                            <div class="small-spinner" ></div>
                        </div>
                        <span class="box-closing" ng-click="toggleStopDeleteBox()"></span>
                        <div class="popupScroll">
                            <div class="popupRow">
                                <div class="row">
                                    <div class="col-xs-12 stop-package-popup">
                                        <p>You may delete an approved package by request only.  <br>
                                            If you would like to delete this package you must first turn it off and <br> wait for a 30 day clearance period. <br>
                                            <br>
                                            Kindly be reminded that you are still obliged to operate all upcoming <br> bookings after stopping this package. You can read more about package management <a href="" style="color:#3FBDC5">here.</a></p>
                                        <br>
                                        <p style="color:#000">Continue with deleting this package? </p>
                                    </div>
                                </div>
                            </div>
                            <div class="popupRow">
                                <div class="row">
                                    <div class="col-xs-6">
                                        <a class="btn-width-orange next-btn" ng-click="stopPackage()">Turn it off</a>
                                    </div>
                                    <div class="col-xs-6">
                                        <a class="btn btn-width-blue next-btn" ng-click="toggleStopDeleteBox()">Keep it running</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--Delete Popup  -->
            <div class="ytPopup" id="deletePopup">
                <div class="tbl-cell">
                    <div class="popupContent">
                        <div class="center-informBlock blur-backgroud" ng-show="deleteProcessing">
                            <div class="small-spinner" ></div>
                        </div>
                        <span class="box-closing" ng-click="toggleDeleteBox()"></span>
                        <div class="popupScroll">
                            <div class="popupRow">
                                <div class="row">
                                    <div class="col-xs-12 stop-package-popup">
                                        <p>Please tell us your reasons for deleting this package</p>  

                                    </div>
                                </div>
                            </div>
                            <div class="popupRow">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <select ng-options="reason.deleteContent for reason in packages.listDeleteReason" ng-model="reasonDelete" style="border: solid 2px #64c7d0;" class="blueInput" ng-change="changeReasonDelete()">
                                            <option value="" disabled>Choose reason</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div ng-show="showOtherReasonTextField" class="popupRow">
                                <div class="row">
                                    <div class="col-xs-12 ">
                                        <textarea type="text" placeholder="Please write a short justification (max. 200 Characters)" class="normalFont blueTextArea ng-pristine ng-untouched ng-valid" ng-model="deleteReason" ng-class="{'missing':(!deleteReasonValidate && (deleteReason === '' || !angular.isString(deleteReason)))}"></textarea>

                                    </div>
                                </div>
                            </div>

                            <div class="popupRow">
                                <div class="row">

                                    <div class="col-xs-6">
                                        <a class="btn-width-orange next-btn" ng-click="deletePackage()">Delete Package</a>
                                    </div>
                                    <div class="col-xs-6">
                                        <a class="btn btn-width-blue next-btn" ng-click="toggleDeleteBox()">I changed my mind</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!--Cannot Delete Popup  -->

            <div class="ytPopup" id="cannotDeletePopup">
                <div class="tbl-cell">
                    <div class="popupContent">
                        <span class="box-closing" ng-click="toggleCannotDeleteBox()"></span>
                        <div class="popupScroll">

                            <div class="popupRow">
                                <div class="row">
                                    <div class="col-xs-12 stop-package-popup">
                                        <p style="font-family:Sailec-bold;">Upcomming bookings found!</p>
                                        <br>
                                        <p>
                                            The system shows that you still have upcoming bookings in your <br>
                                            calendar. Please honor these commitments first or issue a provider <br>
                                            cancellation and refund the package to your customers.</p>
                                        <br>
                                    </div>
                                </div>
                            </div>
                            <div class="popupRow">
                                <div class="row">
                                    <div class="col-xs-6">
                                        <a class="btn-width-orange next-btn" ng-click="toggleCannotDeleteBox()">Resolve Later</a>
                                    </div>
                                    <div class="col-xs-6">
                                        <a class="btn btn-width-blue next-btn" href="<c:url value="/Provider/BookingEngine"/>">Go to Bookings</a>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <!--Delete temporary package popup -->
            <div class="ytPopup" id="deleteTempPackage">
                <div class="tbl-cell">
                    <div class="popupContent" style="width:450px;">
                        <div class="center-informBlock blur-backgroud" ng-show="deleteTempProcessing">
                            <div class="small-spinner" ></div>
                        </div>
                        <span class="box-closing" ng-click="toggleDeleteTempBox()"></span>
                        <div class="popupScroll">
                            <div class="popupRow">
                                <div class="row">
                                    <div class="col-xs-12 stop-package-popup">
                                        <p style="color:#000">Continue with deleting this package? </p>
                                    </div>
                                </div>
                            </div>
                            <div class="popupRow">
                                <div class="row">
                                    <div class="col-xs-6">
                                        <a class="btn-width-orange next-btn" ng-click="deleteTemporaryPackage()">Delete</a>
                                    </div>
                                    <div class="col-xs-6">
                                        <a class="btn btn-width-blue next-btn" ng-click="toggleDeleteTempBox()">Keep it</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End popup -->

            <div id="spinner-block" ng-hide="loaded">
                <div class="youtripper-spinner"></div>
            </div>
            <div class="site-container">
                <div class="affix-content">
                    <div class=""  ng-cloak ng-show="loaded">
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane active" id="step3">
                                <div class="tab-bucket tab-bucket-fix">
                                    <!--                                    <h2>Your Package ({{packages.listPackage.length + packages.listTemporaryPackage.length}})</h2>
                                    
                                                                        <a class="btn-width-orange" id="createButton" href="<c:url value="/Provider/Package/Registration"/>" target="_self">Create New Package</a>
                                                                                                           <a ng-click="toggleDevelopingBox()" class='btn btn-default creation-button' href="" target="_self">Create New Package</a>
                                                                        <div>${requestScope.message}</div>-->

                                    <div class="row package">
                                        <div class="col-md-6 col-lg-4 col-xs-12 package-box" ng-repeat="package in packages.listPackage| orderBy:keySort:reverse | filter:packages.searchPackageValue"  ng-init="balanceSquare()" ng-show="packages.filterPackageValue === 'all' || packages.filterPackageValue === package.packageStatus" init-boxer >
                                            <div class="package-item-block">
                                                <div class="package-item-status" style="height:30px;" ng-style="{'background-color':package.color}">
                                                    {{package.packageStatus}}
                                                    <div class="package-action-menu">
                                                        <span></span>
                                                        <div id="package-menu-item" class="menu-package-click">
                                                            <ul>
                                                                <li class="edit-package" ng-if="package.isTemporary === false || package.packageStatus === 'Creation in Process'" ng-click=""><a href="<c:url value="/Provider/Package/Editing"/>/{{package.packageID}}" target="_self"><span></span>Edit</a></li>                                                               
                                                                <li class="clone-package" ng-click=""><a href="" ng-click="openClonePackagePopup(package.packageID, package.isTemporary)" target="_self"><span></span>Clone</a></li>
                                                                <li class="get-info-package" ng-click=""><a href="" ng-click="getInfoPackage(package.packageID)" target="_self"><span></span>Get Info</a></li>
                                                                <li class="turn-on-off-package" ng-if="package.isStopped === true && package.isTemporary === false" ng-click=""><a href="" ng-click="startPackage(package.packageID, package)"><span></span>Turn on</a></li>
                                                                <li class="turn-on-off-package" ng-if="package.isStopped === false && package.isTemporary === false" ng-click=""><a href="" ng-click="openStopPackageBox(package.packageID, package)"><span></span>Turn off (30 Days)</a></li>
                                                                <li class="delete-package"  ng-if="package.isStopped === false && package.isPending === false && package.isTemporary === false" ng-click=""><a href="" ng-click="openStopPackageBoxTypeDelete(package.packageID, package)"><span></span>Delete (Request)</a></li>
                                                                <li class="delete-package"  ng-if="package.isStopped === true && package.isPending === false" ng-click=""><a href=""ng-click="openDeleteBox(package.packageID, package)"><span></span>Delete</a></li>
                                                                <li class="delete-package"  ng-if="package.isTemporary === true"><a href=""ng-click="openDeleteTemporaryBox(package.packageID, package)"><span></span>Delete</a></li>
                                                            </ul>
                                                        </div>
                                                    </div>


                                                </div>
                                                <div class="package-item-image" >
                                                    <div class="package-background" style="background-image: url('{{package.coverImage}}' ">
                                                        <div class="package-item-content">
                                                            <span class="package-item-cms">8%</span>
                                                            <span class="package-item-price">$ {{package.ordinaryPrice}}</span>
                                                        </div>
                                                    </div>

                                                </div>
                                                <div class="package-item-description">
                                                    <div class="package-item-row">

                                                        <div class="package-item-title">
                                                            {{package.packageName}}  
                                                        </div>

                                                    </div>

                                                    <div class="package-item-row">

                                                        <div class="package-item-address">
                                                            <p>
                                                                <span></span>{{package.location}}
                                                            </p>
                                                        </div>

                                                    </div>

                                                    <div class="package-item-row">
                                                        <div class="package-item-review-rating">
                                                            <ul class="clearfix">
                                                                <li>
                                                                    <p class="package-sold-detail"><span></span>0 Sold</p>
                                                                </li>
                                                                <li>
                                                                    <p class="package-rating-detail"><span></span>{{package.numberRates}} Reviews</p>
                                                                </li>
                                                                <li>
                                                                    <div class="package-rating-star">
                                                                        <ul class="item-rating clearfix">
                                                                            <li ng-repeat="i in [0, 1, 2, 3, 4]" ng-class="{
                                                                    'active' : (i < package.rate), 'unactive' : (i >= package.rate)}">
                                                                            </li>
                                                                        </ul>
                                                                    </div>   
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                        <!--                                        <div class="col-md-6 col-lg-4 col-xs-12 package-box" ng-repeat="package in packages.listTemporaryPackage" ng-init="balanceSquare()" init-boxer>
                                                                                    <div class="package-item-block">
                                                                                        <div class="package-item-status" style="height:30px;" ng-style="{'background-color':package.color} ">
                                                                                            {{package.packageStatus}}
                                                                                            <div class="package-action-menu">
                                                                                                <span></span>
                                                                                                <div id="package-menu-item" class="menu-package-click">
                                                                                                    <ul>
                                                                                                        <li class="clone-package" ng-click=""><a href="" ng-click="checkClonePackage(package.id, 'approved')" target="_self"><span></span>Clone</a></li>
                                                                                                        <li class="get-info-package" ng-click=""><a href="" ng-click="getInfoPackage(package.id)" target="_self"><span></span>Get Info</a></li>
                                                                                                        <li class="delete-package"  ng-click=""><a href=""ng-click="openDeleteTemporaryBox(package.id, $index)"><span></span>Delete</a></li>
                                                                                                    </ul>
                                                                                                </div>
                                                                                            </div>
                                        
                                        
                                                                                        </div>
                                                                                        <div class="package-item-image" >
                                                                                            <div  class="package-background" style="background-image: url('{{package.coverImage}}' ">
                                                                                                <div class="package-item-content">
                                                                                                    <span class="package-item-cms">8%</span>
                                                                                                    <span class="package-item-price">$ {{package.ordinaryPrice}}</span>
                                                                                                </div>
                                                                                            </div>
                                        
                                                                                        </div>
                                                                                        <div class="package-item-description">
                                                                                            <div class="row">
                                                                                                <div class="package-item-title package-margin col-xs-12">
                                                                                                    {{package.name}}  
                                                                                                </div>
                                                                                            </div>
                                        
                                                                                            <div class="row">
                                                                                                <div class="package-item-address package-margin col-xs-12">
                                                                                                    <p>
                                                                                                        <span></span>{{package.city}}
                                                                                                    </p>
                                                                                                </div>
                                                                                            </div>
                                                                                            <div class="package-item-review-rating row">
                                                                                                <div class="package-margin col-xs-12">
                                                                                                    <p class="package-sold-detail col-xs-4"><span></span>20 Sold</p>
                                                                                                    <p style="padding:0"  class=" package-rating-detail col-xs-4"><span></span>{{package.numberRates}} Reviews</p>
                                                                                                    <div class="package-rating-star col-xs-4 ">
                                                                                                        <ul class="item-rating" style="float:right; margin-right:10px;">
                                                                                                            <li ng-repeat="i in [0, 1, 2, 3, 4]" ng-class="{
                                                                                                            'active' : (i < package.rate), 'unactive' : (i >= package.rate)}">
                                                                                                            </li>
                                                                                                        </ul>
                                                                                                    </div>
                                        
                                                                                                </div>
                                                                                            </div>
                                                                                        </div>
                                                                                    </div>
                                        
                                                                                </div>-->
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%@ include file="../comparisonList.jsp" %>
                    </div>
                </div>
                <!--Confirm popup -->
                <div class="certificateBox" id="ConfirmBox">
                    <div class="confim-clone-package">
                        <div class="center-informBlock blur-backgroud" ng-show="newPackageProcessing">
                            <div class="small-spinner" ></div>
                        </div>                            
                        <h4>Clone this package will override your creating package?</h4>
                        <div class="row confirm-clone-btn">                                                               
                            <div class="col-xs-4">
                                <div style="text-align: center" >
                                    <a href="" ng-click="submitCloneForm()" class="btn-width-orange btnNextStep">Continue</a>
                                </div>
                            </div>
                            <div class="col-xs-4">
                                <div style="text-align: center" >
                                    <a href="" class="btn-width-orange login_gg btnNextStep" ng-click="closeClonePackage()">Cancel</a>
                                </div>
                            </div>


                        </div>

                    </div>
                </div>
                <form style="display:none !important; " id="clonePackageForm" method="POST" 
                      action="
                      <c:choose>
                          <c:when test="${empty param.language}">
                              <c:url value="/Provider/Package/Clone"/>
                          </c:when>
                          <c:otherwise>
                              <c:url value="/Provider/Package/Clone?language=${param.language}"/>
                          </c:otherwise>
                      </c:choose>" 
                      class="form-horizontal" name="clonePackageForm" 
                      autocomplete="off">
                    <input type="hidden" name="packageID" value="{{clonePackageID}}">
                    <input type="hidden" name="status" value="{{clonePackageStatus}}">
                    <input type="hidden" name="cloneAll" value="{{clonePart.all}}">
                    <input type="hidden" name="cloneCategory" value="{{clonePart.category}}">
                    <input type="hidden" name="cloneDescription" value="{{clonePart.description}}">
                    <input type="hidden" name="clonePhoto" value="{{clonePart.photos}}">
                    <input type="hidden" name="cloneBooking" value="{{clonePart.booking}}">
                    <input type="hidden" name="clonePricing" value="{{clonePart.pricing}}">
                    <button type="submit" style="display: hidden" class="">Submit</button>   
                </form>
            </div>
        </div>
        <%--<%@ include file="../footer.jsp" %>--%>
        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/notify.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js?999"/>"></script>
        <script>
                        var packages = ${requestScope.packages};
                        console.log(packages);
                        var page = '${requestScope.page}';
                        $(document).ready(function () {
                            toggleHeader.init({
                                toggleControl: false
                            });
                        });
        </script>
    </body>
</html>
