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

        <%@ include file="../angular.jsp" %>

        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/jquery-ui.css"/>" >

        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css?999999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css?999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripperResponsive.css"/>" >

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >
        <title>Account Information</title>
    </head>
    <body>
        <div class="pagesearch" ng-app="YouTripper" ng-controller="TripperInfo">
            <%@ include file="../header.jsp" %>
            <%@ include file="tripperMenubar.jsp" %>

            <!--CROPPING BOX-->
            <div class="ytPopup" id="croppingPopup">
                <div class="tbl-cell noClick">
                    <div class="popupContent">
                        <div class="center-informBlock blur-backgroud" ng-show="cropExecuting">
                            <div class="small-spinner" ></div>
                        </div>
                        <span class="box-closing" ng-click="toggleCroppingBox()"></span>
                        <div class="popupScroll">
                            <h4>Upload your avatar</h4>
                            <div class="popupRow">
                                <div class="certificateImages row">
                                    <div class="col-xs-12">
                                        <div id="providerImgBg">
                                            <img id="dragableAvatar" src=""/>
                                            <div id="disabledDragBg">
                                            </div>
                                            <span class="big-center-plus" ngf-select="newAvatar($file, $invalidFiles)"
                                                  accept="image/*" ngf-min-height="300" ngf-min-width="300" 
                                                  ngf-pattern="'image/*'">
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="popupRow">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <div style="padding: 0 10px">
                                            <div id="slider-size"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="popupRow"  ng-if="showMissingImage && !avatarUploaded">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <p class="errorMsg">Please upload your image first!</p>
                                    </div>
                                </div>
                            </div>

                            <div class="popupRow"  ng-if="imageSizeError">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <p class="errorMsg">Image height and width must be greater than 300px!</p>
                                    </div>
                                </div>
                            </div>
                            <div class="popupRow"  ng-if="imageBroken">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <p class="errorMsg">Image is broken,Please select another one!</p>
                                    </div>
                                </div>
                            </div>

                            <div class="popupRow">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <button class="btn-width-orange login_gg" type="file" ng-model="croppingImage"
                                                ngf-select="newAvatar($file)" 
                                                accept="image/*"
                                                ngf-pattern="'image/*'">Browse your image</button>
                                    </div>
                                </div>
                            </div>

                            <div class="popupRow">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <button class="btn-width-orange" ng-click="cropAndSave()">Crop and save</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <script>

            </script>
            <!--END CROPPPING BOX-->

            <div class=" affix-content clearfix">
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="step1">
                        <div class="tab-account">                         
                            <div class="box-account box-account-edit">
                                <h2>Account Information</h2>
                                <div class="upload-avatar group col-md-2">
                                    <!--                                        <img ngf-drop ngf-select ng-model="tripperImage" style="cursor: pointer"
                                                                                 ngf-drag-over-class="dragover" ngf-allow-dir="true"
                                                                                 accept="image/*"
                                                                                 ngf-pattern="'image/*'" alt="" ng-src="/{{accountInfo.image}}?{{currentTime}}" />
                                                                            <p ngf-drop ngf-select ng-model="tripperImage" style="cursor: pointer"
                                                                               ngf-drag-over-class="dragover" ngf-allow-dir="true"
                                                                               accept="image/*"
                                                                               ngf-pattern="'image/*'">Upload Profile Picture</p>-->
                                    <img style="cursor: pointer" ng-click="toggleCroppingBox()"
                                         ng-src="/{{accountInfo.image}}?time={{currentTime}}" />
                                    <p style="cursor: pointer" ng-click="toggleCroppingBox()">Upload Profile Picture</p>
                                </div>
                                <div class="col-md-10">
                                    <form class="form-horizontal profile-edit-box" ng-submit="validateForm($event)" novalidate name="tripperForm" action="<c:url value="/Tripper/UpdateInformation"/>" method="POST">
                                        <div class="form-group provider-edit-form">
                                            <div class="col-md-3 title-property">
                                                First name
                                            </div>
                                            <div class="col-md-9">
                                                <div>
                                                    <input type="text" ng-model="accountInfo.firstName" name="firstName"
                                                           maxlength="15" ng-maxlength="15"
                                                           class="normalFont blueInput small-input" placeholder="Your first name"/>
                                                </div>
                                                <div ng-show="showError">
                                                    <span style="color: red" ng-show="!accountInfo.firstName.length">Please enter your first name</span>
                                                </div>
                                            </div>
                                            <!--<div class="col-md-5">-->
                                            <!--</div>-->
                                        </div>
                                        <div class="form-group provider-edit-form">
                                            <div class="col-md-3 title-property">
                                                Last name
                                            </div>
                                            <div class="col-md-9">
                                                <div>
                                                    <input type="text" ng-model="accountInfo.lastName" name="lastName"
                                                           maxlength="15" ng-maxlength="15"
                                                           class="normalFont blueInput small-input" placeholder="Your last name"/>
                                                </div>
                                                <div ng-show="showError">
                                                    <span style="color: red" ng-show="!accountInfo.lastName.length">Please enter your last name</span>
                                                </div>
                                            </div>
                                            <!--<div class="col-md-5">-->
                                            <!--</div>-->
                                        </div>
                                        <div class="form-group provider-edit-form">
                                            <div class="col-md-3 title-property">
                                                Email
                                            </div>
                                            <div class="col-md-9">
                                                <input type="text" value="{{accountInfo.email}}" class="normalFont blueInput small-input" placeholder="Your email" readonly/>
                                            </div>
                                            <!--                                                <div class="col-md-5">
                                                                                            </div>-->
                                        </div>
                                        <div class="form-group provider-edit-form">
                                            <div class="col-md-3 title-property">
                                                Password
                                            </div>
                                            <div class="col-md-9">
                                                ********* <a target="_self" 
                                                             href="
                                                             <c:choose>
                                                                 <c:when test="${empty param.language }">
                                                                     <c:url value="/Tripper/Password"/>
                                                                 </c:when>
                                                                 <c:otherwise>
                                                                     <c:url value="/Tripper/Password?language=${param.language}"/>
                                                                 </c:otherwise>
                                                             </c:choose>" 
                                                             class="href-orange">Change</a>
                                            </div>
                                            <!--                                                <div class="col-md-5">
                                                                                            </div>-->
                                        </div>
                                        <div class="form-group provider-edit-form">
                                            <div class="col-md-3 title-property">
                                                Phone number
                                            </div>
                                            <div class="col-md-9">
                                                <input type="number" ng-model="accountInfo.phoneNumber" max="9999999999999" id="tripperPhone" name="phoneNumber"

                                                       class="normalFont blueInput small-input" placeholder="Your phone number"/>

                                            </div>
                                            <!--                                                <div class="col-md-5">
                                            
                                                                                            </div>-->
                                        </div>
                                        <div class="form-group provider-edit-form">
                                            <div class="col-md-3 title-property">
                                                Lives in 
                                            </div>
                                            <div class="col-md-9">
                                                <select id="selectTargetCountry" class="normalFont blueInput small-input    " id="countryList" name="singleSelect" ng-model="selected" ng-options="item as item.name for item in items track by item.countryID">
                                                </select>
                                                <!--                                                    <input type="text" value="{{accountInfo.city + ',' + accountInfo.countryName}}"  name="singleSelect"
                                                                                                       class="normalFont input-property small-input" placeholder="Lives in"/>-->

                                                <!--<input type="text" value="{{accountInfo.name}}" class="normalFont input-property small-input" placeholder="Your last name"/>-->
                                            </div>
                                            <!--                                                <div class="col-md-2">
                                                                                            </div>-->
                                        </div>
                                        <div class="form-group provider-edit-form">
                                            <div class="col-md-3 title-property">
                                                Address
                                            </div>
                                            <div class="col-md-9">
                                                <input type="text" value="{{accountInfo.address}}" name="address"
                                                       maxlength="100" ng-maxlength="100"
                                                       class="normalFont blueInput small-input" placeholder="Your address"/>
                                                <!--<input type="text" value="{{accountInfo.address}}" class="normalFont input-property" placeholder="Your address"/>-->
                                            </div>
                                            <!--                                                <div class="col-md-4">
                                                                                            </div>-->
                                        </div>
                                        <div class="form-group provider-edit-form">
                                            <div class="col-md-3 title-property">
                                                About me
                                            </div>
                                            <div class="col-md-9 textarea-property">
                                                <!--<input type="text" value="{{accountInfo.address}}" class="normalFont input-property" placeholder="Your address"/>-->
                                                <textarea style="border-radius: 0px" placeholder="Tell something about you" name="information"
                                                          maxlength="200" ng-maxlength="200"
                                                          class="normalFont blueInput small-input blueTextArea">{{ accountInfo.information}}</textarea>

                                            </div>
                                            <!--                                                <div class="col-md-4">
                                                                                            </div>-->
                                        </div>
                                        <div class="form-group provider-edit-form">
                                            <div class="col-md-3 title-property">
                                                Category interest
                                            </div>
                                            <div class="col-md-9 textarea-property">
                                                <!--<input type="text" value="{{accountInfo.address}}" class="normalFont input-property" placeholder="Your address"/>-->
                                                <textarea style="border-radius: 0px" placeholder="Your hobbies" ng-model="accountInfo.interest" name="interests" 
                                                          maxlength="100" ng-maxlength="100"
                                                          class="normalFont blueInput small-input blueTextArea">{{accountInfo.interest}}</textarea>
                                            </div>
                                            <!--                                                <div class="col-md-4">
                                                                                            </div>-->
                                        </div>
                                        <div class="form-group provider-edit-form">
                                            <div class="col-md-3 title-property">
                                                Language
                                            </div>
                                            <div class="col-md-9">
                                                <!--{{accountInfo.city + ',' + accountInfo.countryName}}-->
                                                <input type="text" value="{{accountInfo.Language}}"  name="language"
                                                       maxlength="50" ng-maxlength="50"
                                                       class="normalFont blueInput small-input" placeholder="Your language"/>
                                            </div>
                                            <!--                                                <div class="col-md-4">
                                                                                            </div>-->
                                        </div>
                                        <div  class="form-group provider-edit-form">
                                            <div class="col-md-3 title-property">
                                                Notification
                                            </div>
                                            <div class="col-md-9 noti-setting">
                                                <div class="tempCheckbox blueInput">
                                                    <input type="radio" name="notification"  ng-value="true" ng-model="accountInfo.notification"/>
                                                    <span></span>
                                                </div>
                                                <p>Yes</p>
                                                <div class="tempCheckbox blueInput">
                                                    <input type="radio" name="notification"  ng-value="false" ng-model="accountInfo.notification"/>
                                                    <span></span>
                                                </div>
                                                <p>No</p>
                                            </div>
                                        </div>
                                        <div class="form-group provider-edit-form">
                                            <div class="col-md-4 title-property">
                                            </div>
                                            <div class="col-md-3">
                                                <button type="submit" class="btn-width-orange">Save</button>
                                            </div>
                                            <!--<div class="col-md-4">-->
                                        </div>
                                    </form>
                                </div>
                            </div>                            
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <%--<%@ include file="../footer.jsp" %>--%>
        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js?999"/>"></script>
        <script>
                                                        var tripperInfo = ${requestScope.AccountInfo};
                                                        var countryList = ${requestScope.countryList};
                                                        var page = '${requestScope.page}';
                                                        var uploadUrl = '<c:url value="/Tripper/UploadImage"/>';
                                                        $(document).ready(function () {
                                                            toggleHeader.init({
                                                                toggleControl: false
                                                            });
//                                                                $('.edit-account').click(function () {
//                                                                    if ($('.box-account-edit').is(":visible")) {
//                                                                    } else {
//                                                                        $('.box-account-edit').show();
//                                                                        $('.box-account-info').hide();
//                                                                    }
//                                                                });
                                                        });
        </script>
    </body>
</html>
