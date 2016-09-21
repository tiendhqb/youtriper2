<%-- 
    Document   : PackageRegistration
    Created on : May 9, 2016, 5:23:34 PM
    Author     : Nick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${param.language}" />
<fmt:setBundle basename="LanguagePack.lang" var="lang"/>
<!DOCTYPE html>
<html id="package-creation" lang="${language}">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=1366">
        <!--        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1">-->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>YouTripper - Package Editing</title>
        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>">
        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">

        <link href="<c:url value="/Resources/Theme/css/jquery.fs.boxer.css"/>" rel="stylesheet">

        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/clockpicker.css"/>">
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/ng-tags-input.min.css" />"/>

        <link href="<c:url value="/Resources/Theme/css/pepper-ginder-custom.css"/>" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style-login.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/font-awesome.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripperResponsive.css"/>">
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/palette-color-picker.css"/>">
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/jquery.scrollbar.css"/>">


        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <%@ include file="../angular.jsp" %>

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>

        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>

        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-scrollto.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/palette-color-picker.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.inputmask.bundle.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.scrollbar.js"/>"></script>
        <style>
            html, body {
                height: 100%;
            }
        </style>
    </head>
    <body class="pagesearch"  ng-app="YouTripper" ng-controller="PackageEdittingController" >
        <%@ include file="../header.jsp" %>

        <!--LANGUAGE POPUP-->
        <div class="certificateBox" id="languagePopup">
            <div class="certificateContent">
                <span class="box-closing" ng-click="toggleLanguageBox()"></span>
                <div class="popupScroll">
                    <h4>Choose your language</h4>
                    <div class="row removeArrowLanguage">
                        <div class="col-xs-12">
                            <div class="popupRow">
                                <select name="" class="blueInput"
                                        ng-model="selectedLanguageID" convert-to-number>
                                    <option value="0" class="selet">Language</option>
                                    <option ng-repeat="(languageID, language) in languages" value="{{languageID}}">{{language.languageName}}</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-xs-12">
                            <div class="popupRow">
                                <div style="text-align: center">
                                    <a href="" ng-click="addNewLanguage()" class="btn btn-provider">Add Language</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--END LANGUAGE POPUP-->

        <!--CERTICATE BOX-->
        <div class="ytPopup" id="certificatePopup">
            <div class="tbl-cell noClick">
                <div class="popupContent">
                    <div class="center-informBlock blur-backgroud" ng-show="certificateUploading">
                        <div class="small-spinner" ></div>
                    </div>
                    <span class="box-closing" ng-click="toggleCertificateBox()"></span>
                    <div class="popupScroll">
                        <h4>Choose your certificates</h4>
                        <div class="certificateImages row">
                            <div class="certificateImage col-xs-4">
                                <div class="image addCtr"  ng-model="certificateImageFile" ng-change="uploadCertificateImage()"
                                     ngf-allow-dir="true" accept="image/*" ngf-pattern="'image/*'" ngf-select>
                                    <div>
                                        <div>
                                            <span></span>
                                        </div>
                                        <p>Upload new certificate</p>
                                    </div>
                                </div>
                            </div>
                            <div class="certificateImage col-xs-4" ng-repeat="(certificateID, certificate) in providerCertificates">
                                <div class="image" style="background-image: url({{certificate.image}})">
                                    <input class="certificateSelection" type="checkbox" checklist-model="$parent.listSelectedCertificateIDs" checklist-value="certificate.certificateID"/>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <button class="btn-width-orange next-btn" ng-click="chooseCertficates()">Choose these images</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--END CERTIFICATE BOX-->

        <div id="packageRegistratinContainer">
            <div id="spinner-block" ng-hide="loaded">
                <div class="youtripper-spinner"></div>
            </div>
            <div id="succesPercent" ng-cloak ng-show="loaded">
                <span ng-if="noSuccessStep === 0">
                    <fmt:message key="navBar.step0.description" bundle="${lang}"/>
                </span>
                <span ng-if="noSuccessStep === 1">
                    <fmt:message key="navBar.step1.description" bundle="${lang}"/>
                </span>
                <span ng-if="noSuccessStep === 2">
                    <fmt:message key="navBar.step2.description" bundle="${lang}"/>
                </span>
                <span ng-if="noSuccessStep === 3">
                    <fmt:message key="navBar.step3.description" bundle="${lang}"/>
                </span>
                <span ng-if="noSuccessStep === 4">
                    <fmt:message key="navBar.step4.description" bundle="${lang}"/>
                </span>
                <span ng-if="noSuccessStep === 5">
                    <fmt:message key="navBar.step5.description" bundle="${lang}"/>
                </span>

            </div>
            <!--CONTENT-->
            <div id="wizard" ng-cloak ng-show="loaded">

                <!--LEFT CONTENT-->
                <div class="bar-wizard content">
                    <div class="container container-package">
                        <div class="registrationContentContainer">
                            <ul class="menu-steps clearfix">
                                <li>
                                    <a href="" ng-click="openConfirmBox('category')"
                                       ng-class="{'done': (wizards.category && selectedWizard !== 'category'), 'selected': (selectedWizard === 'category')}">
                                        <fmt:message key="navBar.step1" bundle="${lang}"/><br/>
                                    </a>
                                </li>
                                <li>
                                    <a href="" ng-click="openConfirmBox('description')"
                                       ng-class="{'done': (wizards.description && selectedWizard !== 'description'), 'selected': (selectedWizard === 'description')}">
                                        <fmt:message key="navBar.step2" bundle="${lang}"/><br/>
                                    </a>
                                </li>
                                <li>
                                    <a href="" ng-click="openConfirmBox('photos')"
                                       ng-class="{'done':(wizards.photos && selectedWizard !== 'photos'), 'selected': (selectedWizard === 'photos')}">
                                        <fmt:message key="navBar.step3" bundle="${lang}"/><br/>
                                    </a>
                                </li>
                                <li>
                                    <a href=""  ng-click="openConfirmBox('booking')"
                                       ng-class="{'done': (wizards.booking && selectedWizard !== 'booking'), 'selected': (selectedWizard === 'booking')}">
                                       <fmt:message key="navBar.step4" bundle="${lang}"/><br/>
                                    </a>
                                </li>
                                <li>
                                    <a href="" ng-click="openConfirmBox('price')"
                                       ng-class="{'done': (wizards.price && selectedWizard !== 'price'), 'selected': (selectedWizard === 'price')}">
                                        <fmt:message key="navBar.step5" bundle="${lang}"/><br/>
                                    </a>
                                </li>
                                <li>
                                    <form method="POST" action="<c:url value="/Provider/PreViewEditing"/>">
                                        <input type="hidden" value="{{package.id}}" name="packageID"/>
                                        <input type="submit" value="<fmt:message key="navBar.preview" bundle="${lang}"/>" id="preview" class="active"/>
                                    </form>
                                    <!--                                    <a href="" 
                                                                           ng-click="goToPreviewPage()" 
                                                                           >Package Preview</a>-->
                                    <!--                                    <a href="" id="preview"
                                                                           ng-click="goToPreviewPage()"
                                                                           ng-class="{'active' : allStepDones}">Package Preview</a>-->
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!--END LEFT CONTENT-->

                <!--RIGHT CONTENT-->
                <div id="package-section-content" class="container-package"  ng-switch on="selectedWizard">
                    <div class="center-inform blur-backgroud" ng-show="saving">
                        <div class="small-spinner" ></div>
                    </div>

                    <!--CATEGORY SECTION-->
                    <div id="Category" class="content" ng-switch-when="category" ng-init="initCategory(); initScrollBar()">
                        <form name="$parent.activityForm" novalidate>
                            <div class='single-section-content'>
                                <div class="single-section-container clearfix">
                                    <div class='single-section-left'>
                                        
                                        <div class="single-input">
                                            <h5 class="mandotory">
                                                <fmt:message key="step1.category.description" bundle="${lang}"/>
                                                <span>*</span></h5>

                                            <div style="position: initial" class="row category-box single-input">
                                                <div class="new-category-item" style="background-image: url({{categoryData.categoryICon}})" ng-repeat="(categoryID, categoryData)
                                                    in packageForm.categoryRelation" ng-click="selectNewCategory(categoryData.categoryID)">
                                                    <div class="category-active-container" ng-if="selectedCategoryID === categoryData.categoryID">
                                                        <div class="category-name-top">
                                                            <div>{{categoryData.categoryName}}</div>
                                                        </div>
                                                        <select class="blueInput subcateDropdown category-input" ng-model="selectedSubCategoryID" name="subCategoryID" convert-to-number
                                                                ng-change="selectSubCategoryActivity(categoryData.categoryID, selectedSubCategoryID)">     
                                                            <option value="0" selected>
                                                                Choose a subcategory
                                                            </option> 
                                                            <option ng-selected="{{subCategoryData.subCategoryID === selectedSubCategoryID}}" ng-repeat="(subCategoryID, subCategoryData) in categoryData.subCategories"
                                                                    value="{{subCategoryData.subCategoryID}}">
                                                                {{subCategoryData.name}}
                                                            </option>
                                                        </select>
                                                        <div ng-show="selectNotListedSubID > 0 && categoryData.categoryID === selectedCategoryID">
                                                            <input text="" class="normalFont blueInput category-input" placeholder="Content (1 ~ 25)" maxlength="25" ng-maxlength="25"
                                                                   ng-model="$parent.notListedContent.value"/>
                                                        </div>
                                                    </div>
                                                    <div class="category-name-bottom" ng-if="selectedCategoryID !== categoryData.categoryID">
                                                        <div>{{categoryData.categoryName}}</div>
                                                    </div>
                                                </div>                                                
                                            </div>
                                        </div>
                                                                        
                                                                
                                    </div>
                                    <div class='single-section-instructions hasHeader'>
                                        <p>
                                            <fmt:message key="step1.category.howto" bundle="${lang}"/>
                                        </p>
                                    </div>
                                </div>
                            </div>
                            <div class='single-section-content darkgray-section-content'>
                                <div class="single-section-container clearfix">
                                    <div class='single-section-left'>
                                        <div class="single-input">
                                            <h5 class="mandotory"><fmt:message key="step1.suiability.description" bundle="${lang}"/><span>*</span></h5>
                                            <div class="filter-row row creation-row" ng-class="{'missing':(!showMissingData && !checkSuitabilty())}">
                                                <div class="col-xs-3 radio-col suitabilityItem" ng-repeat="classifier in package.suitabilityClassifiers">
                                                    <input type="checkbox" ng-model="classifier.selected"
                                                           ng-true-value="true" ng-false-value="false" ng-click="selectSuitabilityUniversal(classifier.suitabilityName)"/>
                                                    <a href="" >{{classifier.suitabilityName}}</a>
                                                </div>
                                            </div>
                                        </div>                                                                     
                                        <div class="single-input">                                       
                                            <h5 class="mandotory"><fmt:message key="step1.targetCountry.description" bundle="${lang}"/><span>*</span></h5>  
                                            <div class="removeArrowCategory">                                         
                                                <select class="blueInput " ng-model="package.targetCountryID" ng-class="{'missing':(!showMissingData && package.targetCountryID === 0)}" name="targetCountry" ng-options="x.targetCountryID as x.name for x in packageForm.targetCountry">                                                                                        
                                                </select>
                                            </div>
                                        </div>                                       
                                    </div>
                                    <div class='single-section-instructions hasHeader'>
                                        <p>
                                            <fmt:message key="step1.suiability.howto" bundle="${lang}"/>
                                        </p>
                                    </div>
                                </div>
                            </div>
                            <div class='single-section-content darkgray-section-content same-content'>
                                <div class="single-section-container clearfix">
                                    <div class='single-section-left'>
                                        <div class="single-input">
                                            <h5 class="mandotory"><fmt:message key="step1.colorCode.description" bundle="${lang}"/>
                                                <span>*</span></h5>
                                            <div>
                                                <div class="PackageColorSelect" ng-click="showColorPalette()" ng-class="{'missing':(!showMissingData && package.colorID === 0)}">
                                                    <span class="colorDot selected" ng-style="{'background-color': 'rgb(' + getColorCode(package.colorID) + ')'}"></span>
                                                </div>                                    
                                                <div class="PackageColorMenu">                                                
                                                    <div class="col-xs-2 colorItem" ng-repeat="color in packageForm.packageColor">
                                                        <a href="" ng-click="changeSelectedColor(color.colorID)">
                                                            <span class="colorDot" ng-style="{'background-color': 'rgb(' + color.colorCode + ')'}"></span>
                                                        </a>
                                                    </div>

                                                </div>
                                            </div>                                            
                                        </div>    

                                        <div class="single-input">
                                            <button class="btn-width-orange next-btn" ng-click="openConfirmBox('finish')"><fmt:message key="saveBtn" bundle="${lang}"/></button>
                                        </div>
                                    </div>
                                    <div class='single-section-instructions'>
                                        <p>
                                            <fmt:message key="step1.color.howto" bundle="${lang}"/>
                                        </p>
                                    </div>
                                </div>
                            </div>
                            <!--                            <div class='single-section-content'>
                                                            <div class="single-section-container clearfix">
                                                                <div class='single-section-left'>
                                                                    <div>                                        
                                                                        <h5>What can buyers expect from this package ?</h5>     
                                                                        <div class="FeelingTable">                                         
                                                                            <div class="FeelingHeader">
                                                                                <div class="col-xs-3">
                                                                                    <div class="headerFeeling">                                                            
                                                                                    </div>
                                                                                </div>  
                                                                                <div class="col-xs-9 feelingValue">
                                                                                    <div id="FeelingHeader1">
                                                                                        Not so much
                                                                                    </div>
                                                                                    <div id="FeelingHeader2">
                                                                                        Yes, definitely
                                                                                    </div>
                                                                                </div>  
                                                                            </div>
                                                                            <div class="row FeelingBody">
                                                                                <div class="col-xs-3 feelingTitle">
                                                                                    Adventure
                                                                                </div>
                                                                                <div class="col-xs-9 feelingValue">
                                                                                    <div class="adventureSlider"></div>
                                                                                    <div class="dummySlider">
                                                                                        <div></div>
                                                                                        <div></div>
                                                                                        <div></div>
                                                                                        <div></div>
                                                                                        <div></div>                                                                
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="row FeelingBody">
                                                                                <div class="col-xs-3 feelingTitle">
                                                                                    Challenge
                                                                                </div>
                                                                                <div class="col-xs-9 feelingValue">
                                                                                    <div class="challengeSlider"></div>
                                                                                    <div class="dummySlider">
                                                                                        <div></div>
                                                                                        <div></div>
                                                                                        <div></div>
                                                                                        <div></div>
                                                                                        <div></div>                                                                
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="row FeelingBody">
                                                                                <div class="col-xs-3 feelingTitle">
                                                                                    Friendship
                                                                                </div>
                                                                                <div class="col-xs-9 feelingValue">
                                                                                    <div class="friendshipSlider"></div>
                                                                                    <div class="dummySlider">
                                                                                        <div></div>
                                                                                        <div></div>
                                                                                        <div></div>
                                                                                        <div></div>
                                                                                        <div></div>                                                                
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="row FeelingBody">
                                                                                <div class="col-xs-3 feelingTitle">
                                                                                    Happiness
                                                                                </div>
                                                                                <div class="col-xs-9 feelingValue">
                                                                                    <div class="happinessSlider"></div>
                                                                                    <div class="dummySlider">
                                                                                        <div></div>
                                                                                        <div></div>
                                                                                        <div></div>
                                                                                        <div></div>
                                                                                        <div></div>                                                                
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="row FeelingBody">
                                                                                <div class="col-xs-3 feelingTitle">
                                                                                    Healthiness
                                                                                </div>
                                                                                <div class="col-xs-9 feelingValue">
                                                                                    <div class="heathinessSlider"></div>
                                                                                    <div class="dummySlider">
                                                                                        <div></div>
                                                                                        <div></div>
                                                                                        <div></div>
                                                                                        <div></div>
                                                                                        <div></div>                                                                
                                                                                    </div>
                                                                                </div>                                            
                                                                            </div>                                            
                                                                            <div class="row FeelingBody">
                                                                                <div class="col-xs-3 feelingTitle">
                                                                                    Knowledge
                                                                                </div>
                                                                                <div class="col-xs-9 feelingValue">
                                                                                    <div class="knowledgeSlider"></div>
                                                                                    <div class="dummySlider">
                                                                                        <div></div>
                                                                                        <div></div>
                                                                                        <div></div>
                                                                                        <div></div>
                                                                                        <div></div>                                                                
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="row FeelingBody">
                                                                                <div class="col-xs-3 feelingTitle">
                                                                                    Peacefulness
                                                                                </div>
                                                                                <div class="col-xs-9 feelingValue">
                                                                                    <div class="peacefulnessSlider"></div>
                                                                                    <div class="dummySlider">
                                                                                        <div></div>
                                                                                        <div></div>
                                                                                        <div></div>
                                                                                        <div></div>
                                                                                        <div></div>                                                                
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="row FeelingBody">
                                                                                <div class="col-xs-3 feelingTitle">
                                                                                    Romance
                                                                                </div>
                                                                                <div class="col-xs-9 feelingValue">
                                                                                    <div class="romanceSlider"></div>
                                                                                    <div class="dummySlider">
                                                                                        <div></div>
                                                                                        <div></div>
                                                                                        <div></div>
                                                                                        <div></div>
                                                                                        <div></div>                                                                
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="row FeelingBody">
                                                                                <div class="col-xs-3 feelingTitle">
                                                                                    Sophistication
                                                                                </div>
                                                                                <div class="col-xs-9 feelingValue">
                                                                                    <div class="sophisticationSlider"></div>
                                                                                    <div class="dummySlider">
                                                                                        <div></div>
                                                                                        <div></div>
                                                                                        <div></div>
                                                                                        <div></div>
                                                                                        <div></div>                                                                
                                                                                    </div>    
                                                                                </div>
                                                                            </div>
                                                                            <div class="row FeelingBody">
                                                                                <div class="col-xs-3 feelingTitle">
                                                                                    Unexpected
                                                                                </div>
                                                                                <div class="col-xs-9 feelingValue">
                                                                                    <div class="unexpectedSlider"></div>
                                                                                    <div class="dummySlider">
                                                                                        <div></div>
                                                                                        <div></div>
                                                                                        <div></div>
                                                                                        <div></div>
                                                                                        <div></div>                                                                
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                            
                                                                        </div>
                                                                    </div>
                                                                    <button class="btn-width-orange" ng-click="openConfirmBox('finish')">Save and go to the next step</button>
                                                                                                            <button href="" ng-if="allStepDones"  ng-click="finishToPreview()"
                                                                                                                    class="btn-width-orange next-btn">All done! Let's launch this package!</button>
                                                                </div>
                                                                <div class='single-section-instructions hasHeader'>
                                                                    <p>Youtripper allows users to find activities based on their feelings.<br><br> Our TripMood™ engine
                                                                        compares their requests against your personal judgements for this package.<br><br> You don’t have 
                                                                        to complete this part of the registration but it will give you a better chance of conversion
                                                                        and growth from users who aren’t looking for a particular activity.<br><br> Please be honest about your 
                                                                        judgement since guests will get a chance to review and adjust your decision after they’ve consumed this package.</p>
                                                                </div>
                                                            </div>
                                                        </div>-->
                        </form>
                    </div>
                    <!--END CATEGORY SECTION-->

                    <!--DESCRIPTION SECTION-->
                    <div id="Description" class="content" ng-switch-when="description" data-ng-init="getGeolocation()">
                        <!--DESCRIPTIONS AND AMENITIES-->
                        <div class="tab-headers">
                            <ul class="clearfix">
                                <li ng-repeat="languageDescription in package.languageDescriptionList" 
                                    ng-class="{'active' : languageDescription.languageID === selectedLanguageDescription.languageID,
                                                'hideBorder' : package.languageDescriptionList[$index + 1].languageID === selectedLanguageDescription.languageID}">
                                    <span class="deleteLanguage" ng-class="{'active' :(languageDescription.languageID === selectedLanguageDescription.languageID
                                                && selectedLanguageDescription.languageID !== 40)}" ng-click="removeLanguage(selectedLanguageDescription.languageID)" ></span>
                                    <a href="" ng-click="showLanguageDescription(languageDescription.languageID)">
                                        {{languages[languageDescription.languageID].languageName}}
                                    </a>
                                </li>
                                <li class="plusLanguage">
                                    <span class="minusBtn"></span>
                                    <a href="" ng-click="toggleLanguageBox()">
                                        Add more languages
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <div class="tab-content">


                            <!--MULTIPLE DESCRIPITON-->
                            <div class='single-section-content'>
                                <div class="single-section-container clearfix">
                                    <div class='single-section-left'>
                                        <div class="single-input">
                                            <span ng-show="errorList[selectedLanguageDescription.languageID].packageName === '1' && isShowError" style="color: red">  <br/> Package name is required</span>  
                                            <span ng-show="errorList[selectedLanguageDescription.languageID].packageName === '2' && isShowError" style="color: red">  <br/> Package name can not more than 50 characters</span>  
                                            <input id="packageNameInput" type="text" maxlength="50" class="blueInput normalFont" value="" placeholder="<fmt:message key="step2.packageName" bundle="${lang}"/>" 
                                                   ng-model="selectedLanguageDescription.packageName" ng-class="{'missing':((!showMissingData && (checkisUndefined(selectedLanguageDescription.packageName))) 
                                                       || (!showMissingData && (checkMinName(selectedLanguageDescription.packageName, 10))))}" />
                                        </div>
                                        <div class="single-input">
                                            <fmt:message key="step2.packDescription.description" bundle="${lang}"/>
                                            <span ng-show="errorList[selectedLanguageDescription.languageID].packageDesc.header === '1' && isShowError" style="color: red">  <br/> Package description header is required</span>  
                                            <span ng-show="errorList[selectedLanguageDescription.languageID].packageDesc.header === '2' && isShowError" style="color: red">  <br/> Package description header can not more than 50 characters</span>  

                                            <div ng-repeat="singleDescription in selectedLanguageDescription.description" class="multi-childInput advancedInput">
                                                <input type="text" maxlength="50" placeholder="<fmt:message key="step2.packDescription.title.placeholder" bundle="${lang}"/>" class="blueInput normalFont" 
                                                       ng-model="singleDescription.header" ng-class="{'headerMissing':(!showMissingData && (angular.isUndefined(singleDescription.header) ||
                                                                   singleDescription.header.length < 10))}"/>
                                                <span ng-show="errorList[selectedLanguageDescription.languageID].packageDesc.desc === '1' && isShowError" style="color: red">  <br/> Package description is required</span>  
                                                <span ng-show="errorList[selectedLanguageDescription.languageID].packageDesc.desc === '2' && isShowError" style="color: red">  <br/> Package description can not more than
                                                    1000 characters</span>  

                                                <textarea class="normalFont blueTextArea" type="text"  maxlength="1000"
                                                          placeholder="<fmt:message key="step2.packDescription.body.placehoder" bundle="${lang}"/>" 
                                                          ng-model="singleDescription.description" ng-class="{'descriptionMissing':(!showMissingData && (angular.isUndefined(singleDescription.description) || singleDescription.description.length < 200))}"></textarea>
                                                <ul class="clearfix" ng-if="selectedLanguageDescription.description.length > 1">
                                                    <li class="deleteBtn">
                                                        <a href="" ng-click="deleteAdvancedDescription($index)">Delete</a>
                                                    </li>
                                                    <li class="upArrow moveBtn" ng-class="{'disableBtn' : ($first)}">
                                                        <a href="" ng-click="moveDescriptionUp($index)">
                                                            <span></span>
                                                        </a>
                                                    </li>
                                                    <li class="downArrow moveBtn" ng-class="{'disableBtn' : ($last)}">
                                                        <a href="" ng-click="moveDescriptionDown($index)">
                                                            <span></span>
                                                        </a>
                                                    </li>
                                                </ul>
                                            </div>

                                            <div class="multi-childInput">
                                                <button class="btn btn-width-blue next-btn" ng-click="addNewAdvancedDescription()">
                                                     <fmt:message key="step2.packDescription.addNewBtn" bundle="${lang}"/>
                                                </button>
                                            </div>
                                        </div>

                                    </div>
                                    <div class='single-section-instructions'>
                                        <p>
                                            <fmt:message key="step2.description.howto" bundle="${lang}"/>
                                        </p>
                                    </div>
                                </div>
                            </div>
                            <!--END MULTIPLE DESCRIPTION-->

                            <!--AMENITIES-->
<!--                            <div class='single-section-content white-section-content'>
                                <div class="single-section-container clearfix">
                                    <div class='single-section-left'>

                                        AMENITIES ICONS
                                        <div class="single-input">
                                            <h5><fmt:message key="step2.amenities.description" bundle="${lang}"/></h5>
                                            <div class="row  choose-category" id="choose-amenities">
                                                <div class="col-md-2 col-sm-4 col-xs-6 single-amenities" ng-repeat="amenities in packageForm.listAmenities">
                                                    <div class="round">
                                                        <div class="circle-icon">
                                                            <input type="checkbox"  ng-click="validateListAmenities(amenities)"
                                                                   checklist-model="selectedListAmenities" checklist-value="amenities" ng-change="amenitiesListChange()"/>
                                                            <span style="background-image: url({{amenities.icon}})"></span>
                                                        </div>
                                                        <p>{{amenities.amenitiesType}}</p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        END AMENITIES ICONS

                                        AMENITIES DESCRIPTION
                                        <div class="single-input">
                                            <div class="multi-childInput" ng-repeat="amenitiesClassifier in package.amenitiesClassifiers|
                                                        orderBy:'amenitiesID' | filter:{languageID: selectedLanguageDescription.languageID}"
                                                 ng-class="{'certificateInput' : (amenitiesClassifier.amenitiesName === 'Safety')}">
                                                <textarea class="normalFont blueTextArea" type="text"  maxlength="500"
                                                          placeholder=" <fmt:message key="step2.amenities.placeholder1" bundle="${lang}"/> {{amenitiesClassifier.amenitiesName}} <fmt:message key="step2.amenities.placeholder2" bundle="${lang}"/>" 
                                                          ng-model="amenitiesClassifier.description" ng-class="{'missing':(((!showMissingData && (checkisUndefined(amenitiesClassifier.description)))) || (!showMissingData && (checkMinName(amenitiesClassifier.description,100)) ))}"></textarea>
                                                <div class="certificatePictures clearfix" ng-if="(amenitiesClassifier.amenitiesName === 'Safety')">
                                                    <div class="certificateImage" ng-repeat="certificateImage in package.certificates">
                                                        <div class="image" style="background-image: url({{certificateImage.imageLink}})">

                                                        </div>
                                                    </div>
                                                    <div class="certificateImage">
                                                        <div class="image addCtr" ng-click="toggleCertificateBox()">
                                                            <div>
                                                                <div>
                                                                    <span></span>
                                                                </div>
                                                                <p>Choose pictures of certificate</p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        END AMENITIES DESCRIPTION

                                    </div>
                                    <div class='single-section-instructions hasIcon'>
                                        <p>
                                            The offering of amenities creates healthy competition between providers of similar activities, allowing you to differentiate yourself on various service points.
                                            <br/><br/>
                                            We suggest following a strategy that focusses on standing out on a single or few amenities of your choice. Click on your  amenity icon to enter a description in the appearing field below.
                                            <br/><br/>
                                            You may be tempted to offer all amenities at once but be advised that customers have the chance to judge you on their quality in reference to what you described or advertised. 
                                        </p>
                                    </div>
                                </div>
                            </div>-->
                            <!--END AMENITIES-->
                        </div>
                        <!--END DESCRIPTION AND AMENITIES-->

                        <div class="instruction-alt">
                            <div class="single-section-content">
                                <div class="single-section-container">
                                    <div class="instruction-alt-padding">
                                        <fmt:message key="step2.location.description" bundle="${lang}"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--NEW LOCATION -->
                        <div class="ytPopup" id="location-popup">
                            <div class="tbl-cell noClick">
                                <div class="popupContent">
                                    <span class="box-closing" ng-click="toggleLocationBox()"></span>
                                    <div class="popupScroll">
                                        <div class="popupRow">

                                            <div id="mapBackground">
                                                <input id="additionalAutocompletePopUp" type="text" class="normalFont blueInput" placeholder="Type in the location where the {{selectedLocationType}} takes place"/>

                                                <div id="map-pop-up"></div>
                                            </div>
                                        </div>
                                        <div class="popupRow" style="padding-left:10px;">
                                            <div class="multi-childInput location-detail">

                                                <div class="location-search">                                                   
                                                    <input type="text" class="normalFont blueInput" placeholder="What happens at this location? (max. 50 characters)"
                                                           ng-class="{'missing':(showMissingDataPopUpLocation && addressDetailTemp.content === '')}" ng-model="addressDetailTemp.content" />
                                                    <div class="detail-alt clearfix">
                                                        <textarea type="text" ng-class="{'missing':(showMissingDataPopUpLocation && addressDetailTemp.addr === '')}" class="normalFont blueTextArea" id="popup-map-address" placeholder="Google Map Address"
                                                                  ng-model="addressDetailTemp.addr"></textarea>
                                                        <input type="text" class="normalFont blueInput timeMaskInput" placeholder="Start or Meeting Time" maxlength="5"
                                                               ng-model="addressDetailTemp.startTime"/>
                                                        <input  type="text" class="normalFont blueInput timeMaskInput" placeholder="End or Finish Time" maxlength="5"
                                                                ng-model="addressDetailTemp.endTime"/>

                                                    </div>
                                                    <div class="location-access clearfix">
                                                        <textarea type="text" class="normalFont blueTextArea" ng-if="addressDetailTemp.accessDescription !== undefined"
                                                                  placeholder="Describe to your customers the best and most cost-effective options to get to this location. Bear in mind that they may have never been to your country before.(max. 800 Characters)"
                                                                  ng-model="addressDetailTemp.accessDescription"></textarea>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="popupRow">
                                            <button class="btn-width-orange" ng-click="saveLocationTemp()">Save this location</button>

                                        </div>


                                    </div>

                                </div>
                            </div>
                        </div>

                        <div id="pop-up-location" ng-show="showPopUpAddLocation">
                            <button ng-click="closeLocationPopUp()">Close</button>

                        </div>

                        <!--LOCATION-->
                        <div class="tab-content">
                            <div class='single-section-content'>
                                <div class="single-section-container clearfix">
                                    <div class='single-section-left' ng-class="{'pickupSelection' : selectedLocationType === 'pickup',
                                                'departureSelection' : selectedLocationType === 'departure'}">

                                        <div class="single-input">
                                            <div id="mapBackground">
                                                <div class="selectedMarkerBox removeArrowLocation">
                                                </div>
                                                <div id="map"></div>
                                            </div>
                                        </div>


                                    </div>
                                    <div class='single-section-instructions'>
                                        <p>
                                            <fmt:message key="step2.location.howto" bundle="${lang}"/>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--END LOCATION-->
                        <div class="instruction-alt white-bg">
                            <div class="single-section-content">
                                <div class="single-section-container">
                                    <div class="instruction-alt-padding" style="color: #3FC1C9">
                                        <fmt:message key="step2.location.activity.description" bundle="${lang}"/>*
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class='single-section-content same-content'>
                            <div class="single-section-container clearfix">
                                <div class='single-section-left'>
                                    <div class="single-input">

                                        <div class="multi-childInput" ng-repeat="advancedAddress in selectedLanguageDescription.advancedAddress['action']">
                                            <div class="location-content row">
                                                <div class="location-infor col-xs-10">
                                                    <div class="location-name">
                                                        <h5>                               
                                                            {{advancedAddress.content}}
                                                        </h5>
                                                        <h5 style="color:red;" ng-if="advancedAddress.content === '' || advancedAddress.content === 'undefined'">                               
                                                            Click Edit to change what happens at this location. 
                                                        </h5>
                                                    </div>
                                                    <div class="location-addr-time">
                                                        <div class="location-addr">
                                                            <h6>{{advancedAddress.addr}}</h6>
                                                        </div>
                                                        <div class="location-time">
                                                            <span ng-show="advancedAddress.startTime.length" style="margin-right:20px;">Start time: {{advancedAddress.startTime}}</span>
                                                            <span ng-show="advancedAddress.endTime.length">End time: {{advancedAddress.endTime}}</span>
                                                        </div>

                                                    </div>
                                                    <div class="location-dsc">
                                                        <p class="location-description">
                                                            {{advancedAddress.accessDescription}}
                                                        </p>
                                                    </div>
                                                </div>
                                                <div class="col-xs-2">
                                                    <button style="margin-bottom:10px;" class="btn btn-width-blue" ng-click="editLocation($index, locationType.locationType)">Edit</button>
                                                    <button class="btn-width-orange" ng-click="deleteLocation($index, locationType.locationType)">Delete</button>
                                                </div>

                                            </div>
                                        </div>

                                        <div class="multi-childInput">
                                            <div class="action-btn">
                                                <a href="" class="" ng-click="addLocation('action')"><fmt:message key="step2.location.activity.addNew" bundle="${lang}"/></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="instruction-alt white-bg">
                            <div class="single-section-content">
                                <div class="single-section-container">
                                    <div class="instruction-alt-padding" style="color: #FF514E">
                                        <fmt:message key="step2.location.departure.description" bundle="${lang}"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class='single-section-content same-content'>
                            <div class="single-section-container clearfix">
                                <div class='single-section-left'>
                                    <div class="single-input departureTypeLocation">

                                        <div class="multi-childInput" ng-repeat="advancedAddress in selectedLanguageDescription.advancedAddress['departure']">
                                            <div class="location-content row">
                                                <div class="location-infor col-xs-10">
                                                    <div class="location-name">
                                                        <h5>                               
                                                            {{advancedAddress.content}}
                                                        </h5>
                                                        <h5 style="color:red;" ng-if="advancedAddress.content === '' || advancedAddress.content === 'undefined'">                               
                                                            Click Edit to change what happens at this location. 
                                                        </h5>
                                                    </div>
                                                    <div class="location-addr-time">
                                                        <div class="location-addr">
                                                            <h6>{{advancedAddress.addr}}</h6>
                                                        </div>
                                                        <div class="location-time">
                                                            <span ng-show="advancedAddress.startTime.length" style="margin-right:20px;">Start time: {{advancedAddress.startTime}}</span>
                                                            <span ng-show="advancedAddress.endTime.length">End time: {{advancedAddress.endTime}}</span>
                                                        </div>

                                                    </div>
                                                    <div class="location-dsc">
                                                        <p class="location-description">
                                                            {{advancedAddress.accessDescription}}
                                                        </p>
                                                    </div>
                                                </div>
                                                <div class="col-xs-2">
                                                    <button style="margin-bottom:10px;" class="btn btn-width-blue" ng-click="editLocation($index, locationType.locationType)">Edit</button>
                                                    <button class="btn-width-orange" ng-click="deleteLocation($index, locationType.locationType)">Delete</button>
                                                </div>

                                            </div>
                                        </div>

                                        <div class="multi-childInput">
                                            <div class="action-btn departure-btn">
                                                <a href="" class="" ng-click="addLocation('departure')"><fmt:message key="step2.location.departure.addNew" bundle="${lang}"/></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="instruction-alt white-bg">
                            <div class="single-section-content">
                                <div class="single-section-container">
                                    <div class="instruction-alt-padding" style="color: #FBB03B">
                                        <fmt:message key="step2.location.pickUp.description" bundle="${lang}"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class='single-section-content same-content'>
                            <div class="single-section-container clearfix">
                                <div class='single-section-left'>
                                    <div class="single-input pickupTypeLocation">
                                        <div class="multi-childInput" ng-repeat="advancedAddress in selectedLanguageDescription.advancedAddress['pickup']">
                                            <div class="location-content row">
                                                <div class="location-infor col-xs-10">
                                                    <div class="location-name">
                                                        <h5>                               
                                                            {{advancedAddress.content}}
                                                        </h5>
                                                        <h5 style="color:red;" ng-if="advancedAddress.content === '' || advancedAddress.content === 'undefined'">                               
                                                            Click Edit to change what happens at this location. 
                                                        </h5>
                                                    </div>
                                                    <div class="location-addr-time">
                                                        <div class="location-addr">
                                                            <h6>{{advancedAddress.addr}}</h6>
                                                        </div>
                                                        <div class="location-time">
                                                            <span ng-show="advancedAddress.startTime.length" style="margin-right:20px;">Start time: {{advancedAddress.startTime}}</span>
                                                            <span ng-show="advancedAddress.endTime.length">End time: {{advancedAddress.endTime}}</span>
                                                        </div>

                                                    </div>
                                                    <div class="location-dsc">
                                                        <p class="location-description">
                                                            {{advancedAddress.accessDescription}}
                                                        </p>
                                                    </div>
                                                </div>
                                                <div class="col-xs-2">
                                                    <button style="margin-bottom:10px;" class="btn btn-width-blue" ng-click="editLocation($index, locationType.locationType)">Edit</button>
                                                    <button class="btn-width-orange" ng-click="deleteLocation($index, locationType.locationType)">Delete</button>
                                                </div>

                                            </div>
                                        </div>

                                        <div class="multi-childInput">
                                            <div class="action-btn pickup-btn">
                                                <a href="" class="" ng-click="addLocation('pickup')"><fmt:message key="step2.location.pickUp.addNew" bundle="${lang}"/></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!--TAGS AND LANGUAGE-->
                        <div class='single-section-content darkgray-section-content'>
                            <div class="single-section-container clearfix">
                                <div class='single-section-left'>
                                    <div class="single-input">
                                        <fmt:message key="step2.tag.description" bundle="${lang}"/>
                                        <tags-input id="tagList" ng-model="selectedLanguageDescription.keywords" max-length="20" max-tags="9"
                                                    placeholder="<fmt:message key="step2.tag.placeholder" bundle="${lang}"/>">
                                        </tags-input>
                                    </div>
                                    <div class="single-input">
                                        <h5 class="mandotory"><fmt:message key="step2.summary.description" bundle="${lang}"/><span>*</span></h5>
                                        <span ng-show="errorList[selectedLanguageDescription.languageID].packageIntro === '1' && isShowError" style="color: red">  <br/> Package introduce is required</span>  
                                        <span ng-show="errorList[selectedLanguageDescription.languageID].packageIntro === '2' && isShowError" style="color: red">  <br/> Package introduce can not more than 200 characters</span>  

                                        <textarea id="packageDescriptionTextarea" class="normalFont blueTextArea" type="text"  maxlength="200"
                                                  placeholder="<fmt:message key="step2.summary.placeholder" bundle="${lang}"/>" 
                                                  ng-model="selectedLanguageDescription.googleDescription" value="" ng-class="{'missing':((!showMissingData && (checkisUndefined(selectedLanguageDescription.googleDescription)))
                                          || (!showMissingData && (checkMinName(selectedLanguageDescription.googleDescription, 40))))}" ></textarea>
                                    </div>
                                    <div class="single-input">
                                        <h5 class="mandotory"><fmt:message key="step2.language.description" bundle="${lang}"/><span>*</span></h5>
                                        <tags-input id="tagList" ng-model="selectedLanguageDescription.language" max-length="20" max-tags="9"
                                                    placeholder="<fmt:message key="step2.language.placeholder" bundle="${lang}"/>">
                                        </tags-input>
                                    </div>

                                    <div class="single-input">
                                        <button class="btn-width-orange next-btn" ng-click="openConfirmBox('finish')"><fmt:message key="saveBtn" bundle="${lang}"/></button>
                                        <!--                                        <button href="" ng-if="allStepDones"  ng-click="finishToPreview()"
                                                                                        class="btn-width-orange next-btn">All done! Let's launch this package!</button>-->
                                    </div>
                                </div>
                                <div class='single-section-instructions hasHeader'>
                                    <p>
                                        <fmt:message key="step2.tag&lang.howto" bundle="${lang}"/>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <!--END TAGS AND LANGUAGE-->
                    </div>
                    <!--END DESCRIPTION SECTION-->

                    <!--PHOTO SECTION-->
                    <div id="Photos" class="content" ng-switch-when="photos" data-ng-init="initiatePhotoForm()">
                        <div class='single-section-content'>
                            <div class="single-section-container clearfix">
                                <div class='single-section-left'>

                                    <div class="single-input">
                                        <form  name="$parent.photosForm" novalidate>

                                            <div  class="upload-large" id="coverImage" ng-class="{'missing':(!showMissingData && !angular.isDefined($scope.package.coverImage))}">
                                                <img src="{{package.coverImage}}" class="packageCoverImage" ng-show="package.coverImage !== null
                                                            && package.coverImage !== undefine && package.coverImage !== '' && $parent.coverImageSuccess"
                                                     ng-class="{'cursorDrag' : $parent.isEditing}" />
                                                <!--<div id="coverShowing">Drop cover image here or click to upload</div>-->
                                                <a href="#" class="btn-upload"
                                                   ng-hide="$parent.isEditing || checkImageUploaded()" ng-model="$parent.coverImage" 
                                                   ngf-allow-dir="true" accept="image/*" ngf-pattern="'image/*'" ngf-select>
                                                    <fmt:message key="step3.photo.uploadBtn" bundle="${lang}"/>
                                                </a>
                                                <a href="" ng-click="turnOnDrag()" ng-hide="$parent.isEditing || !checkImageUploaded()" class="btnEdit" ng-hide="$parent.isEditing">{{showEditImageText()}}</a>
                                                <a href="" ng-model="$parent.coverImage" ngf-allow-dir="true" accept="image/*" ngf-pattern="'image/*'" ngf-select class="btnChangeImage" ng-hide="$parent.isEditing || !checkImageUploaded()">Change</a>
                                                <a href="" ng-click="disableDrag()" class="btnEdit" ng-show="$parent.isEditing">Save</a>

                                                <!--<a href="" ng-click="testing()">Test</a>-->
                                            </div>
                                        </form>

                                    </div>

                                    <div class="single-input">
                                        <form  name="$parent.photosForm" novalidate>
                                            <h5 class="mandotory">
                                                <fmt:message key="step3.photo.description" bundle="${lang}"/>
                                                <span>*</span></h5>
                                            <div class="progress" ng-show="$parent.uploading">
                                                <div class="progress-bar progress-bar-striped active" role="progressbar"
                                                     aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width:{{uploadValue}}%">
                                                    {{uploadValue| number:0 }}%
                                                </div>
                                            </div>                                   
                                            <div id="addtionalImages">
                                                <div class="row">
                                                    <div class="col-xs-6 single-packageImage" ng-repeat="image in package.images">
                                                        <div class="addtionalImage" 
                                                             style="background: #ffffff url({{image.image + '?' + currentTime}}) no-repeat center" >
                                                            <a href="" ng-click="deleteAdditionalImage(image, $index)"></a>                                        
                                                        </div>
                                                        <div class="imageCaption">
                                                            <textarea ng-model="image.caption" placeholder="Write something for this photo ..." class="normalFont"></textarea>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-6">
                                                        <div  ng-hide="$parent.uploading" ngf-drop ngf-select ng-model="$parent.addingImage" id="addingImage" class="addtionalImage"
                                                              ngf-drag-over-class="dragover" ngf-allow-dir="true"
                                                              accept="image/*" ngf-multiple="true"
                                                              ngf-pattern="'image/*,application/pdf'" style="position: relative">
                                                            <span class="morePhotoLink"><fmt:message key="step3.photo.addPicture" bundle="${lang}"/></span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div
                                        </form>

                                    </div>

                                    <div class="single-input">
                                        <button class="btn-width-orange next-btn" ng-click="openConfirmBox('finish')"><fmt:message key="saveBtn" bundle="${lang}"/></button>
                                        <!--                                        <button href="" ng-if="allStepDones"  ng-click="finishToPreview()"
                                                                                        class="btn-width-orange next-btn">All done! Let's launch this package!</button>-->
                                    </div>
                                </div>
                                <div class='single-section-instructions'>
                                    <p>
                                        <fmt:message key="step3.photo.howto" bundle="${lang}"/>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--END PHOTO SECTION-->

                    <!--BOOKING SECTION-->
                    <div id="Booking" class="content" ng-switch-when="booking" data-ng-init="initCalendar()" ng-class="{'hasPopup' : popupServingShowing || popupServingShowingEdit || popupTripSourceShowing}">
                        <div class='single-section-content dark-section-content'>
                            <div class="single-section-container clearfix">
                                <div class='single-section-left'>
                                    <div class="single-input">
                                        <h5 class="mandotory"><fmt:message key="step4.packageTypeSelect" bundle="${lang}"/><span>*</span></h5>      
                                    </div>
                                </div>
                                <div class='single-section-instructions'>
                                    <p>
                                        <fmt:message key="step4.packageType.howto" bundle="${lang}"/>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="tab-headers"  style="margin-top: -45px;">
                            <ul class="clearfix">
                                <li class="openType" ng-class="{'active': package.packageType === 'Open',
                                            'hideBorder' : package.packageType === 'Personal'}">
                                    <a href="" ng-click="changePackageType('Open')">
                                        <fmt:message key="step4.packageType1" bundle="${lang}"/>
                                    </a>
                                    <div class="booking-icons" ng-click="changePackageType('Open')">
                                    </div>
                                </li>                         
                                <li class="privateType"  ng-class="{'active': package.packageType === 'Personal',
                                            'hideBorder' : package.packageType === 'Group'}">
                                    <a href=""  ng-click="changePackageType('Personal')">
                                        <fmt:message key="step4.packageType2" bundle="${lang}"/>
                                    </a>
                                    <div class="booking-icons"  ng-click="changePackageType('Personal')">
                                    </div>
                                </li>                         
                                <li class="groupType"  ng-class="{'active': package.packageType === 'Group'}">
                                    <a href="" ng-click="changePackageType('Group')">
                                        <fmt:message key="step4.packageType3" bundle="${lang}"/>
                                    </a>
                                    <div class="booking-icons"  ng-click="changePackageType('Group')">
                                    </div>
                                </li>                         
                            </ul>
                        </div>
                        <div class="tab-content">
                            <!--OPEN CONTENT-->
                            <div id="openTab-content" ng-if="package.packageType === 'Open'">

                                <!--MIN TRIPPER AND MAX TRIPPER-->
                                <div class='single-section-content'>
                                    <div class="single-section-container clearfix">
                                        <div class='single-section-left'>
                                            <div class="single-input">
                                                <p>
                                                <fmt:message key="step4.packageType1.description" bundle="${lang}"/>
                                                </p>         
                                            </div>
                                            <div class="single-input">
                                                <div class="row">
                                                    <div class="col-xs-6">
                                                        <span class="blueLabel">
                                                            <fmt:message key="step4.packageType1.selectQuantity" bundle="${lang}"/>
                                                        </span>
                                                    </div>
                                                    <div class="col-xs-6">
                                                        <div class="noPeopleInputs clearfix">
                                                            <div class="noPeopleInput">
                                                                <div class="inputAutoNumber">
                                                                    <a href="" ng-class="{'add-minus-normal' :(package.minTripper > 1)}" class="minusBtn" ng-click="descrease('package.minTripper')" ></a>
                                                                    <input id="maxTripperInput" type="text" class="blueInput normalFont" ng-class="{'missing':(!showMissingData && package.packageType
                                                                                === 'Open' && package.minTripper === null)}" placeholder="Number" ng-model="package.minTripper" numbers-only/>
                                                                    <a href="" class="plusBtn" ng-click="increase('package.minTripper')"/></a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--END MIN TRIPPER AND MAX TRIPPER-->

                            </div>
                            <!--END OPEN CONTENT-->

                            <!--PRIVATE CONTENT-->
                            <div id="privateTab-content" ng-if="package.packageType === 'Personal'">

                                <!--MIN TRIPPER AND MAX TRIPPER-->
                                <div class='single-section-content'>
                                    <div class="single-section-container clearfix">
                                        <div class='single-section-left'>
                                            <div class="single-input">
                                                <p>
                                                <fmt:message key="step4.packageType2.description" bundle="${lang}"/>
                                                </p>         
                                            </div>
                                            <div class="single-input">
                                                <div class="row">
                                                    <div class="col-xs-6">
                                                        <span class="blueLabel">
                                                            <fmt:message key="step4.packageType2.selectQuantity" bundle="${lang}"/>
                                                        </span>
                                                    </div>
                                                    <div class="col-xs-6">
                                                        <div class="noPeopleInputs clearfix">
                                                            <div class="noPeopleInput">
                                                                <div class="inputAutoNumber">
                                                                    <a href="" class="minusBtn" ng-class="{'add-minus-normal' :(package.minTripper > 1)}" ng-click="descrease('package.minTripper')"></a>
                                                                    <input type="text" class="blueInput normalFont"  ng-model="package.minTripper"
                                                                           placeholder="Minimum is 1" numbers-only range-min="1"/>
                                                                    <a href="" class="plusBtn" ng-click="increase('package.minTripper')"/></a>
                                                                </div>
                                                            </div>
                                                            <div class="noPeopleInput">
                                                                <div class="inputAutoNumber">
                                                                    <a href="" class="minusBtn" ng-class="{'add-minus-normal' :(package.maxTripper > 1)}" ng-click="descrease('package.maxTripper')"></a>
                                                                    <input id="maxTripperInput" type="text"  class="blueInput normalFont" ng-class="{'missing':(!showMissingData && package.packageType === 'Personal' && package.maxTripper === null)}" ng-model="package.maxTripper"
                                                                           placeholder="Max number" numbers-only range-max="5"/>
                                                                    <a href="" class="plusBtn" ng-class="{'add-plus-disable': (package.maxTripper > 4)}" ng-click="increase('package.maxTripper')"/></a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--END MIN TRIPPER AND MAX TRIPPER-->

                            </div>
                            <!--END PRIVATE CONTENT-->

                            <!--GROUP CONTENT-->
                            <div id="groupTab-content" ng-if="package.packageType === 'Group'">

                                <!--MIN TRIPPER AND MAX TRIPPER-->
                                <div class='single-section-content'>
                                    <div class="single-section-container clearfix">
                                        <div class='single-section-left'>
                                            <div class="single-input">
                                                <p>
                                                <fmt:message key="step4.packageType3.description" bundle="${lang}"/>
                                                </p>         
                                            </div>
                                            <div class="single-input">
                                                <div class="row">
                                                    <div class="col-xs-6">
                                                        <span class="blueLabel">
                                                            <fmt:message key="step4.packageType3.selectQuantity" bundle="${lang}"/>
                                                        </span>
                                                    </div>
                                                    <div class="col-xs-6">
                                                        <div class="noPeopleInputs clearfix">
                                                            <div class="noPeopleInput">
                                                                <div class="inputAutoNumber">
                                                                    <a href="" class="minusBtn" ng-class="{'add-minus-normal' :(package.minTripper > 5)}" ng-click="descreaseGroup('package.minTripper')"></a>
                                                                    <input type="text" class="blueInput normalFont"  ng-model="package.minTripper"
                                                                           placeholder="Minimum is 5" numbers-only range-min="5"/>
                                                                    <a href="" class="plusBtn" ng-click="increaseGroup('package.minTripper')"/></a>
                                                                </div>
                                                            </div>
                                                            <div class="noPeopleInput">
                                                                <div class="inputAutoNumber">
                                                                    <a href="" class="minusBtn" ng-class="{'add-minus-normal' :(package.maxTripper > 5)}" ng-click="descreaseGroup('package.maxTripper')"></a>
                                                                    <input id="maxTripperInput" type="text" class="blueInput normalFont" ng-model="package.maxTripper" ng-class="{'missing':(!showMissingData && package.packageType === 'Group' && package.maxTripper === null)}"
                                                                           placeholder="Max number" numbers-only range-min="5"/>
                                                                    <a href="" class="plusBtn" ng-click="increaseGroup('package.maxTripper')"/></a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--END MIN TRIPPER AND MAX TRIPPER-->

                            </div>
                            <!--END GROUP CONTENT-->


                            <div class="instruction-alt hasAltLink">
                                <div class="single-section-content">
                                    <div class="single-section-container">
                                        <!--                                        <div class="instruction-alt-padding">
                                                                                    Discover the power of your TripSource™
                                                                                </div>-->
                                        <div class="instruction-alt-padding">
                                            <fmt:message key="step4.packageTime.description" bundle="${lang}"/>
                                        </div>
                                        <!--                                        <a href="" ng-click="toogleResourceInstruction()">
                                                                                    Find out more
                                                                                </a>-->
                                    </div>
                                </div>
                            </div>

                            <!--RESOURCE INSTRUCTION-->
                            <div id="resourceInstruction">
                                <div class='single-section-content blue-section-content'>
                                    <div class="single-section-container clearfix">
                                        <div class="padding-single-section">
                                            <div class="single-input">
                                                <p>
                                                    Youtripper created TrippSource Management because we believe that our
                                                    providers should not have to pay expensive membership fees to gain access 
                                                    to a reliable booking engine that powers their online sales. Continue business 
                                                    as usual without interference while taking advantage of seamlessly synchronizing 
                                                    both online and offline bookings to avoid overbooking or ineffective quotas and instead 
                                                    promote packages with unfulfilled resources in real time.
                                                </p>
                                            </div>
                                            <div class="single-input">
                                                <h5 class="question">How does it work?</h5>
                                            </div>
                                            <div class="single-input">
                                                <p>TrippSource is a system that manages real time use of your business’s resources in order to serve your customers and achieve the maximum serving capacity per day. 
                                                    It continuously recalculates your total capacity by automatically deducting and adding TrippSource units from bookings and after completed package durations.</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class='single-section-content blue-section-content'>
                                    <div class="single-section-container clearfix">
                                        <div class="padding-single-section">
                                            <div class="single-input">
                                                <h5 class="question">How should I register a TrippSource?</h5>
                                            </div>
                                            <div class="single-input">
                                                <p>
                                                    When registering a package for the first time you will need to set up a new TrippSource from the menu below.<br/>
                                                    <br/>
                                                    1. &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Click on the “Create a new TrippSource” button underneath the selection bar. The TrippSource registration box will pop up with three required entries.<br/>
                                                    <br/>
                                                    2. &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Enter your TrippSource name such as Thai Massage Therapist Group, Instructors, Guides, Bungee Rope or River Boat.<br/>
                                                    <br/>
                                                    3. &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Enter this TrippSource’s maximum capacity as in 10 Therapists, 5 Guides or 20 Seats.<br/>
                                                    <br/>
                                                    4. &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Leave a note in case you need to remember something specific about this TrippSource.<br/>
                                                    <br/>
                                                    5. &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Click on the “Save this new TrippSource” button.<br/>
                                                    <br/>
                                                    6. &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;The new TrippSource is automatically assigned to serve this package.<br/>
                                                    <br/>
                                                    Each TrippSource must define the maximum number of units that limits its serving capacity.
                                                    Once a booking is made online, the system will automatically deduct the required units from this TrippSource. <br/>
                                                    <br/>
                                                    In order to work correctly you have to register the number of units this package will consume in a specific period of time.
                                                    This period consists of the package duration and the time the unit may need for recovery. <br/>
                                                    <br/>
                                                    By doing so a TrippSource could be depleted on a single day in which case the package will not 
                                                    be available for booking anymore unless the unit’s package duration passes and it becomes available again.
                                                    Once registered, a TrippSource can be assigned to multiple packages if needed.
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class='single-section-content blue-section-content'>
                                    <div class="single-section-container clearfix">
                                        <div class="padding-single-section">
                                            <div class="single-input">
                                                <h5 class="question">Can you show me an example of how a TrippSource could be set up?</h5>
                                            </div>
                                            <div class="single-input">
                                                <p>
                                                    The TrippSource system was designed to be very flexible and cater to your needs.
                                                    It’s simply a matter of how you choose to apply it and what you will assign to be the TrippSource and the units within them.<br/>
                                                    <br/>
                                                    A TrippSource could be assigned to a group of Thai Massage Therapists.
                                                    The provider employs 10 therapists so the maximum capacity is 10 units.
                                                    Now if an online booking comes in for a Thai Massage Package lasting two hours, 
                                                    the TrippSource engine will automatically deduct 1 therapist reducing the overall capacity to 9 for the next 
                                                    two hours after which the capacity will return back to 10 unless a new booking was made.<br/>
                                                    <br/>
                                                    In another example a TrippSource could also be set up as a River Boat with 20 seats or a maximum capacity of 20 units.
                                                    However, for a River Boat business serving the maximum capacity should be set up on a sequential schedule 
                                                    that allows for each time slot to serve the maximum instead of a daily free booking schedule,
                                                    which leads us to the next point, the serving time.<br/>
                                                    <br/>
                                                    What’s the relationship between TrippSource and time slot?<br/>
                                                    <br/>
                                                    Any package and its TrippSource must be connected to a serving time,
                                                    such as the standard opening time of a business or a specific time period during the day.
                                                    As a provider you need to carefully think about how to set up your TrippSource,
                                                    serving time and booking preferences in order to sell your packages most effectively.
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <a href="" class="closeArrow"  ng-click="toogleResourceInstruction()">

                                </a>
                            </div>
                            <!--END RESOURCE INSTRUCTION-->

                            <!--RESOURCE-->
                            <div class="section-with-popup">
                                <div class="single-section-content darkgray-section-content">
                                    <div class="single-section-container clearfix">
                                        <div class='single-section-left'>

                                            <div class="single-input">
                                                <div class="clearfix resourceForm">
                                                    <h5 class="mandotory">
                                                        <fmt:message key="step4.duration.description" bundle="${lang}"/>
                                                        <span>*</span></h5>
                                                    <div class="formLabel clearfix">
                                                        <div class="input removeArrowDuration">
                                                            <select name="" class="blueInput normalFont new-duration-type " ng-model="$parent.tempDurationType" 
                                                                    ng-change="changeTempDurationType($parent.tempDurationType)">                                                                    
                                                                <option value="hours&minutes"><fmt:message key="step4.duration.hour&minute" bundle="${lang}"/></option> 
                                                                <option value="days"><fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="month"><fmt:message key="step4.duration.month" bundle="${lang}"/></option> 
                                                                <option value="years"><fmt:message key="step4.duration.year" bundle="${lang}"/></option> 
                                                            </select>
                                                        </div>
                                                        <div class="input" ng-show ="tempDurationType === 'days'" >
                                                            <select name="" class="blueInput normalFont new-duration-days" ng-model="package.durationDay" convert-to-number 
                                                                    ng-class="{'missing':(!showMissingData && (package.durationDay === null || package.durationDay === 0))}">
                                                                <option value="0" disabled><fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="1">1 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="2">2 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="3">3 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="4">4 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="5">5 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="6">6 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="7">7 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                            </select>
                                                        </div> 

                                                        <div class="input" ng-show ="tempDurationType === 'month'" >
                                                            <select name="" class="blueInput normalFont new-duration-days" ng-model="package.durationMonth"
                                                                    convert-to-number ng-class="{'missing':(!showMissingData &&
                                                                                (package.durationMonth === null || package.durationMonth === 0))}">
                                                                <option value="0" disabled><fmt:message key="step4.duration.month" bundle="${lang}"/></option>
                                                                <option value="1">1 <fmt:message key="step4.duration.month" bundle="${lang}"/></option>
                                                                <option value="2">2 <fmt:message key="step4.duration.month" bundle="${lang}"/></option>
                                                                <option value="3">3 <fmt:message key="step4.duration.month" bundle="${lang}"/></option>
                                                                <option value="4">4 <fmt:message key="step4.duration.month" bundle="${lang}"/></option>
                                                                <option value="5">5 <fmt:message key="step4.duration.month" bundle="${lang}"/></option>
                                                                <option value="6">6 <fmt:message key="step4.duration.month" bundle="${lang}"/></option>
                                                                <option value="7">7 <fmt:message key="step4.duration.month" bundle="${lang}"/></option>
                                                                <option value="8">8 <fmt:message key="step4.duration.month" bundle="${lang}"/></option>
                                                                <option value="9">9 <fmt:message key="step4.duration.month" bundle="${lang}"/></option>
                                                                <option value="10">10 <fmt:message key="step4.duration.month" bundle="${lang}"/></option>
                                                                <option value="11">11 <fmt:message key="step4.duration.month" bundle="${lang}"/></option>
                                                                <option value="12">12 <fmt:message key="step4.duration.month" bundle="${lang}"/></option>
                                                            </select>
                                                        </div>

                                                        <div class="input" ng-show ="tempDurationType === 'years'" >
                                                            <select name="" class="blueInput normalFont new-duration-days" ng-model="package.durationYear" convert-to-number
                                                                    ng-class="{'missing':(!showMissingData &&
                                                                                (package.durationYear === null || package.durationYear === 0))}">
                                                                <option value="0" disabled><fmt:message key="step4.duration.year" bundle="${lang}"/></option>
                                                                <option value="1">1 <fmt:message key="step4.duration.year" bundle="${lang}"/></option>
                                                                <option value="2">2 <fmt:message key="step4.duration.year" bundle="${lang}"/></option>
                                                                <option value="3">3 <fmt:message key="step4.duration.year" bundle="${lang}"/></option>
                                                                <option value="4">4 <fmt:message key="step4.duration.year" bundle="${lang}"/></option>
                                                                <option value="5">5 <fmt:message key="step4.duration.year" bundle="${lang}"/></option>
                                                                <option value="6">6 <fmt:message key="step4.duration.year" bundle="${lang}"/></option>
                                                                <option value="7">7 <fmt:message key="step4.duration.year" bundle="${lang}"/></option>
                                                                <option value="8">8 <fmt:message key="step4.duration.year" bundle="${lang}"/></option>
                                                                <option value="9">9 <fmt:message key="step4.duration.year" bundle="${lang}"/></option>
                                                                <option value="10">10 <fmt:message key="step4.duration.year" bundle="${lang}"/></option>
                                                                <option value="11">11 <fmt:message key="step4.duration.year" bundle="${lang}"/></option>
                                                                <option value="12">12 <fmt:message key="step4.duration.year" bundle="${lang}"/></option>
                                                            </select>
                                                        </div>

                                                        <div class="input removeArrowDuration" ng-show ="tempDurationType === 'hours&minutes'" >
                                                            <select name="" class="blueInput normalFont new-duration-hour-minute" ng-model="package.durationHour" convert-to-number
                                                                    ng-class="{'missing':(!showMissingData && (package.durationMinute === null || package.durationMinute === 0)
                                                                                && (package.durationHour === null || package.durationHour === 0))}">
                                                                <option value="0">0 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="1">1 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="2">2 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="3">3 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="4">4 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="5">5 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="6">6 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="7">7 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="8">8 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="9">9 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="10">10 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="11">11 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="12">12 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="13">13 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="14">14 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="15">15 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="16">16 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="17">17 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="18">18 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="19">19 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="20">20 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="21">21 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="22">22 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="23">23 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                            </select>
                                                        </div> 
                                                        <div class="input" ng-show ="tempDurationType === 'hours&minutes'" >
                                                            <select name="" class="blueInput normalFont new-duration-hour-minute" ng-model="package.durationMinute" convert-to-number ng-class="{'missing':(!showMissingData && (package.durationMinute === null || package.durationMinute === 0) && (package.durationHour === null || package.durationHour === 0))}">
                                                                <option value="0">0 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="5">5 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="10">10 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="15">15 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="20">20 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="25">25 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="30">30 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="35">35 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="40">40 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="45">45 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="50">50 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="55">55 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                            </select>
                                                        </div>

                                                    </div>
                                                </div>
                                            </div>

                                            <div class="single-input">
                                                <div class="clearfix resourceForm">
                                                    <h5 class="mandotory">
                                                        <fmt:message key="step4.resting.description" bundle="${lang}"/>
                                                        <span>*</span></h5>
                                                    <div class="formLabel clearfix">

                                                        <div class="input" ng-show ="tempDurationType === 'days' || tempDurationType === 'month' || tempDurationType === 'years'" >
                                                            <select name="" class="blueInput normalFont new-duration-days" ng-model="package.restingtimeDay" convert-to-number>
                                                                <option value="0" default>0 <fmt:message key="step4.resting.day" bundle="${lang}"/></option>
                                                                <option value="1">1 <fmt:message key="step4.resting.day" bundle="${lang}"/></option>
                                                                <option value="2">2 <fmt:message key="step4.resting.day" bundle="${lang}"/></option>
                                                                <option value="3">3 <fmt:message key="step4.resting.day" bundle="${lang}"/></option>
                                                                <option value="4">4 <fmt:message key="step4.resting.day" bundle="${lang}"/></option>
                                                                <option value="5">5 <fmt:message key="step4.resting.day" bundle="${lang}"/></option>
                                                                <option value="6">6 <fmt:message key="step4.resting.day" bundle="${lang}"/></option>
                                                                <option value="7">7 <fmt:message key="step4.resting.day" bundle="${lang}"/></option>
                                                                <option value="8">8 <fmt:message key="step4.resting.day" bundle="${lang}"/></option>
                                                                <option value="9">9 <fmt:message key="step4.resting.day" bundle="${lang}"/></option>
                                                                <option value="10">10 <fmt:message key="step4.resting.day" bundle="${lang}"/></option>
                                                                <option value="11">11 <fmt:message key="step4.resting.day" bundle="${lang}"/></option>
                                                                <option value="12">12 <fmt:message key="step4.resting.day" bundle="${lang}"/></option>
                                                                <option value="13">13 <fmt:message key="step4.resting.day" bundle="${lang}"/></option>
                                                                <option value="14">14 <fmt:message key="step4.resting.day" bundle="${lang}"/></option>
                                                                <option value="15">15 <fmt:message key="step4.resting.day" bundle="${lang}"/></option>
                                                                <option value="16">16 <fmt:message key="step4.resting.day" bundle="${lang}"/></option>
                                                                <option value="17">17 <fmt:message key="step4.resting.day" bundle="${lang}"/></option>
                                                                <option value="18">18 <fmt:message key="step4.resting.day" bundle="${lang}"/></option>
                                                                <option value="19">19 <fmt:message key="step4.resting.day" bundle="${lang}"/></option>
                                                                <option value="20">20 <fmt:message key="step4.resting.day" bundle="${lang}"/></option>
                                                                <option value="21">21 <fmt:message key="step4.resting.day" bundle="${lang}"/></option>
                                                                <option value="22">22 <fmt:message key="step4.resting.day" bundle="${lang}"/></option>
                                                                <option value="23">23 <fmt:message key="step4.resting.day" bundle="${lang}"/></option>
                                                                <option value="24">24 <fmt:message key="step4.resting.day" bundle="${lang}"/></option>
                                                                <option value="25">25 <fmt:message key="step4.resting.day" bundle="${lang}"/></option>
                                                                <option value="26">26 <fmt:message key="step4.resting.day" bundle="${lang}"/></option>
                                                                <option value="27">27 <fmt:message key="step4.resting.day" bundle="${lang}"/></option>
                                                                <option value="28">28 <fmt:message key="step4.resting.day" bundle="${lang}"/></option>
                                                                <option value="29">29 <fmt:message key="step4.resting.day" bundle="${lang}"/></option>
                                                            </select>
                                                        </div> 

                                                        <div class="input removeArrowDuration" ng-show ="tempDurationType === 'hours&minutes'" >
                                                            <select name="" class="blueInput normalFont new-duration-hour-minute" ng-model="package.restingtimeHour" convert-to-number>
                                                                <option value="0" default>0 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="1">1 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="2">2 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="3">3 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="4">4 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="5">5 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="6">6 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="7">7 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="8">8 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="9">9 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="10">10 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="11">11 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="12">12 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="13">13 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="14">14 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="15">15 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="16">16 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="17">17 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="18">18 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="19">19 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="20">20 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="21">21 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="22">22 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="23">23 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                            </select>
                                                        </div> 
                                                        <div class="input" ng-show ="tempDurationType === 'hours&minutes'" >
                                                            <select name="" class="blueInput normalFont new-duration-hour-minute" ng-model="package.restingtimeMinute" convert-to-number >
                                                                <option value="0" default>0 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="5">5 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="10">10 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="15">15 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="20">20 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="25">25 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="30">30 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="35">35 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="40">40 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="45">45 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="50">50 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="55">55 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="single-input">
                                                <div class="clearfix resourceForm">
                                                    <h5 class="mandotory">
                                                        <fmt:message key="step4.minimumTime.description" bundle="${lang}"/>
                                                        <span>*</span></h5> 
                                                    <div class="formLabel clearfix">    
                                                        <div class="input removeArrowDuration">
                                                            <select ng-show="$parent.tempDurationType === 'hours&minutes'" name="" ng-change="changeReadyBookingDurationType()" class="blueInput normalFont new-duration-type" ng-model="package.readyBookingDurationType" >
                                                                <option value="days"><fmt:message key="step4.minimumTime.day" bundle="${lang}"/></option>
                                                                <option value="mins"><fmt:message key="step4.minimumTime.hour&minute" bundle="${lang}"/></option>                                                                  
                                                            </select>
                                                        </div>
                                                        <div class="input" ng-show ="package.readyBookingDurationType === 'days'" >
                                                            <select name="" class="blueInput normalFont new-duration-days" ng-model="package.readyBookingDuration" convert-to-number >
                                                                <option value="0" default>0 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="1">1 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="2">2 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="3">3 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="4">4 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="5">5 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="6">6 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="7">7 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="8">8 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="9">9 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="10">10 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="11">11 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="12">12 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="13">13 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="14">14 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="15">15 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="16">16 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="17">17 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="18">18 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="19">19 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="20">20 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="21">21 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="22">22 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="23">23 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="24">24 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="25">25 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="26">26 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="27">27 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="28">28 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="29">29 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                            </select>
                                                        </div> 
                                                        <div class="input removeArrowDuration" ng-show ="package.readyBookingDurationType === 'mins'
                                                                    && $parent.tempDurationType !== 'days' && $parent.tempDurationType !== 'month' && $parent.tempDurationType !== 'years'" >
                                                            <select name="" class="blueInput normalFont new-duration-hour-minute" ng-model="package.readyBookingDurationHour" convert-to-number >
                                                                <option value="0" default>0 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="1">1 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="2">2 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="3">3 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="4">4 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="5">5 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="6">6 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="7">7 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="8">8 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="9">9 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="10">10 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="11">11 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="12">12 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="13">13 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="14">14 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="15">15 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="16">16 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="17">17 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="18">18 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="19">19 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="20">20 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="21">21 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="22">22 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                                <option value="23">23 <fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
                                                            </select>
                                                        </div> 
                                                        <div class="input" ng-show ="package.readyBookingDurationType === 'mins' && $parent.tempDurationType !== 'days'
                                                                    && $parent.tempDurationType !== 'month' && $parent.tempDurationType !== 'years'" >
                                                            <select name="" class="blueInput normalFont new-duration-hour-minute" ng-model="package.readyBookingDurationMinutes" convert-to-number>
                                                                <option value="0" default>0 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="5">5 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="10">10 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="15">15 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="20">20 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="25">25 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="30">30 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="35">35 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="40">40 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="45">45 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="50">50 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
                                                                <option value="55">55 <fmt:message key="step4.duration.minute" bundle="${lang}"/></option>

                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="single-input"  ng-if="tempDurationType === 'hours&minutes'">
                                                <div class="multi-childInput">
                                                    <h5 class="mandotory">
                                                        <fmt:message key="step4.frequency.description" bundle="${lang}"/>
                                                        <span>*</span></h5>
                                                    <div class="row availableBookingTimeRow">
                                                        <div class="col-xs-6">
                                                            <a href="" class="linkBtn hrefCheckBox" ng-click="setIsFreeBooking(true)"
                                                               ng-class="{'active': package.isFreeBooking}"><fmt:message key="step4.frequency.option1" bundle="${lang}"/></a>
                                                        </div>
                                                        <div class="col-xs-6" ng-if="package.isFreeBooking">
                                                            <div class="filter-row row">
                                                                <div class="col-xs-4 radio-col">
                                                                    <input type="radio" name="" value="10" ng-model="package.freeInterval"/>
                                                                    <a href="" ng-click=""><fmt:message key="step4.frequency.10min" bundle="${lang}"/></a>
                                                                </div>
                                                                <div class="col-xs-4 radio-col">
                                                                    <input type="radio" name="" value="15"  ng-model="package.freeInterval"/>
                                                                    <a href="" ng-click=""><fmt:message key="step4.frequency.15min" bundle="${lang}"/></a>
                                                                </div>
                                                                <div class="col-xs-4 radio-col">
                                                                    <input type="radio" name="" value="30"  ng-model="package.freeInterval"/>
                                                                    <a href="" ng-click=""><fmt:message key="step4.frequency.30min" bundle="${lang}"/></a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="multi-childInput">
                                                    <div class="row availableBookingTimeRow">
                                                        <div class="col-xs-6" style="text-align: center">
                                                            <fmt:message key="step4.frequency.or" bundle="${lang}"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="multi-childInput">
                                                    <div class="row availableBookingTimeRow">
                                                        <div class="col-xs-8">
                                                            <a href="" class="linkBtn hrefCheckBox" ng-click="setIsFreeBooking(false)"
                                                               ng-class="{'active': !package.isFreeBooking}">
                                                                <fmt:message key="step4.frequency.option2" bundle="${lang}"/>
                                                            </a>
                                                        </div>
                                                        <div class="col-xs-4" ng-if="!package.isFreeBooking" style="text-align: center;
                                                             font-family: Sailec-Bold; color: #939598; font-size: 20px;">
                                                            <span style="line-height: 40px;">
                                                                {{package.durationHour + package.restingtimeHour}} Hour<span ng-show="(package.durationHour + package.restingtimeHour) > 1">s</span>
                                                                {{package.durationMinute + package.restingtimeMinute}} Minute<span ng-show="(package.durationMinute + package.restingtimeMinute) > 1">s</span>
                                                            </span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class='single-section-instructions'>
                                            <p>
                                                <fmt:message key="step4.packageTime.howto" bundle="${lang}"/>
                                            </p>
                                            <p  ng-if="tempDurationType === 'hours&minutes'">
                                                <span class="title"><fmt:message key="step4.chooseslot.title.howto" bundle="${lang}"/></span><br/>
                                                <fmt:message key="step4.chooseslot.howto" bundle="${lang}"/>
                                                <br/><br/>
                                                <span class="title"><fmt:message key="step4.packageDuration.title.howto" bundle="${lang}"/></span><br/>
                                                <fmt:message key="step4.packageDuration.howto" bundle="${lang}"/>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                                <div id="blurBg" ng-if="popupTripSourceShowing || popupServingShowing || popupServingShowingEdit || popupPolicyShowing || popupEditPolicyShowing"></div>
                                <div class="single-section-content popupSection darkgray-section-content" id="resourcePopup" ng-if="popupTripSourceShowing">
                                    <div class="popupSectionContent">
                                        <div class="center-informBlock blur-backgroud" ng-show="addingProcessing">
                                            <div class="small-spinner" ></div>
                                        </div>
                                        <div class="single-section-container clearfix">
                                            <div class='single-section-left'>

                                                <div class="single-input">
                                                    <div class="newResoureInput">
                                                        <input type="text" class="blueInput normalFont borderDarkBlueInput" ng-model="newResource.name"
                                                               placeholder="Name your TripSource™ to help you identify it later (max. 50 Characters)"/>
                                                        <div class="inputWithLabel clearfix">
                                                            <div class="label">
                                                                What is the maximum capacity of your TripSource™? 
                                                            </div>
                                                            <div class="input">
                                                                <input type="number" class="blueInput normalFont borderDarkBlueInput" 
                                                                       ng-model="newResource.capacity"  placeholder="Enter your number here"/>
                                                            </div>
                                                        </div>
                                                        <textarea type="text" class="blueTextArea normalFont borderDarkBlueInput" 
                                                                  ng-model="newResource.note" placeholder="Anything to note about this TripSource™  (max. 200 Characters)"/></textarea>
                                                        <div class="popupCtrs clearfix">
                                                            <a href="" class="closeBtn" ng-click="closeResourcePopup()">X</a>
                                                            <a href="" class="saveBtn" ng-click="insertNewTripSource()">Save this new TripSource™</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class='single-section-instructions'>
                                                <p>
                                                    Name and define your TrippSource for example Thai Massage Therapists or Speedboat and set up its maximum capacity.  
                                                    <br><br>
                                                    You can also enter a note to help you manage this TrippSource such as names of your therapists for example.

                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--END RESOURCE-->

                            <div class="instruction-alt hasAltLink">
                                <div class="single-section-content">
                                    <div class="single-section-container">
                                        <div class="instruction-alt-padding">
                                            <fmt:message key="step4.bookingEngine.description" bundle="${lang}"/>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!--RESOURCE-->

                            <div class="single-section-content">
                                <div class="single-section-container clearfix">
                                    <div class='single-section-left'>
                                        <div class="single-input">
                                            <div class="multi-childInput">
                                                <div class="row">
                                                    <div class="col-xs-8">
                                                        <a href="" ng-click="setUsingMaxQuota(false)" class="linkBtn hrefCheckBox"
                                                           ng-class="{'active' : !package.isUsingMaxQuota}">
                                                            <fmt:message key="step4.bookingEngine.option1" bundle="${lang}"/>
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="multi-childInput">
                                                <div class="row">
                                                    <div class="col-xs-8" style="text-align: center">
                                                        <fmt:message key="step4.bookingEngine.or" bundle="${lang}"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="multi-childInput">
                                                <div class="row">
                                                    <div class="col-xs-8">
                                                        <a href="" ng-click="setUsingMaxQuota(true)" class="linkBtn hrefCheckBox"
                                                           ng-class="{'active' : package.isUsingMaxQuota}">
                                                            <fmt:message key="step4.bookingEngine.option2" bundle="${lang}"/>
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="multi-childInput" ng-if="package.isUsingMaxQuota">
                                                <h5><fmt:message key="step4.maximumPack.description" bundle="${lang}"/></h5>
                                                <div class="number-type-input">
                                                    <ul class="clearfix">
                                                        <li>
                                                            <input class="blueInput normalFont" placeholder="<fmt:message key="step4.maximumPack.number" bundle="${lang}"/>"
                                                                   ng-model="package.maxQuota"  ng-class="{'hasError' : (!showMissingData && (isNaN(package.maxQuota) || package.maxQuota <= 0))}"
                                                                   numbers-only/>
                                                        </li>
                                                        <li>
                                                            <select class="blueInput" ng-model="package.quotaType">
                                                                <option value="hours"><fmt:message key="step4.maximumPack.hour" bundle="${lang}"/></option>
                                                                <option value="days"><fmt:message key="step4.maximumPack.day" bundle="${lang}"/></option>
                                                            </select>
                                                        </li>
                                                    </ul>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                    <div class='single-section-instructions'  ng-if="!popupTripSourceShowing">
                                        <p>
                                            <span class="title"><fmt:message key="step4.resourceManagement.title.howto" bundle="${lang}"/></span><br/>
                                            <fmt:message key="step4.resourceManagement.howto" bundle="${lang}"/>
                                            <br/><br/>
                                            <span class="title"><fmt:message key="step4.quota.title.howto" bundle="${lang}"/></span><br/>
                                            <fmt:message key="step4.quota.howto" bundle="${lang}"/>
                                        </p>
                                    </div>
                                </div>
                            </div>
                            <!--END RESOURCE-->

                            <div class="instruction-alt hasAltLink">
                                <div class="single-section-content">
                                    <div class="single-section-container">
                                        <div class="instruction-alt-padding">
                                            <fmt:message key="step4.operationSchedule.description" bundle="${lang}"/>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!--CALENDAR-->
                            <div class='single-section-content'>
                                <div class="single-section-container clearfix">
                                    <div class='single-section-left'>
                                        <div class="single-input">
                                            <div class="single-input">
<!--                                                <div class="multi-childInput">
                                                    <div class="row">
                                                        <div class="col-xs-8">
                                                            <a href="" ng-click="setIsSpecificLaunchDate(false)" class="linkBtn hrefCheckBox"
                                                               ng-class="{'active' : !package.isSpecificLaunchDate}">
                                                                <fmt:message key="step4.operationSchedule.option1" bundle="${lang}"/>
                                                            </a>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="multi-childInput">
                                                    <div class="row">
                                                        <div class="col-xs-8" style="text-align: center">
                                                            <fmt:message key="step4.operationSchedule.or" bundle="${lang}"/>
                                                        </div>
                                                    </div>
                                                </div>-->
                                                <div class="multi-childInput">
                                                    <div class="row">
                                                        <div class="col-xs-8">
                                                            <a href="" ng-click="setIsSpecificLaunchDate(true)" class="linkBtn hrefCheckBox"
                                                               ng-class="{'active' : package.isSpecificLaunchDate}">
                                                                <fmt:message key="step4.operationSchedule.option2" bundle="${lang}"/>
                                                            </a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class='single-section-instructions'>
                                        <p>
                                            <fmt:message key="step4.operationSchedule.howto" bundle="${lang}"/>
                                        </p>
                                    </div>
                                </div>
                            </div>
                            <div class='single-section-content same-content'>
                                <div class="single-section-container clearfix">
                                    <div class="single-section-middle">
                                        <div class="single-input">
                                            <h5 class="mandotory" ng-show="package.isSpecificLaunchDate"><fmt:message key="step4.selectDate.description" bundle="${lang}"/><span>*</span></h5>
                                            <div class="packageCalendarContainer clearfix">
                                                <div class="operationCalendar">
                                                    <div id="calendar" class="clearfix" ng-class="{'active' : package.isSpecificLaunchDate}">
                                                        <div class="left-calendar">
                                                            <div class="calendarYearMonth">
                                                                <a href="" class="backCalendar" ng-click="previousMonth()"></a>
                                                                <h2></h2>
                                                            </div>
                                                            <div class="weekDays">
                                                                <ul class="clearfix">
                                                                    <li><fmt:message key="step4.calendar.sun" bundle="${lang}"/></li>
                                                                    <li><fmt:message key="step4.calendar.mon" bundle="${lang}"/></li>
                                                                    <li><fmt:message key="step4.calendar.tue" bundle="${lang}"/></li>
                                                                    <li><fmt:message key="step4.calendar.wed" bundle="${lang}"/></li>
                                                                    <li><fmt:message key="step4.calendar.thu" bundle="${lang}"/></li>
                                                                    <li><fmt:message key="step4.calendar.fri" bundle="${lang}"/></li>
                                                                    <li><fmt:message key="step4.calendar.sat" bundle="${lang}"/></li>
                                                                </uL>
                                                            </div>
                                                            <div class="calendarDate">

                                                            </div>
                                                        </div>

                                                        <div class="right-calendar">
                                                            <div class="calendarYearMonth">
                                                                <h2></h2>
                                                                <a href="" class="nextCalndar" ng-click="nextMonth()"></a>
                                                            </div>
                                                            <div class="weekDays">
                                                                <ul class="clearfix">
                                                                    <li><fmt:message key="step4.calendar.sun" bundle="${lang}"/></li>
                                                                    <li><fmt:message key="step4.calendar.mon" bundle="${lang}"/></li>
                                                                    <li><fmt:message key="step4.calendar.tue" bundle="${lang}"/></li>
                                                                    <li><fmt:message key="step4.calendar.wed" bundle="${lang}"/></li>
                                                                    <li><fmt:message key="step4.calendar.thu" bundle="${lang}"/></li>
                                                                    <li><fmt:message key="step4.calendar.fri" bundle="${lang}"/></li>
                                                                    <li><fmt:message key="step4.calendar.sat" bundle="${lang}"/></li>
                                                                </uL>
                                                            </div>
                                                            <div class="calendarDate">

                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="operationCalendarCtrs">
                                                    <div class="ctrlGroup" ng-if="package.operationsCycles.length >= 2"  ng-show="!package.isRunning">
                                                        <div class="singleCtrl">
                                                            <a href="" ng-click="removeCycle()" class="linkBtn">Remove cycle</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class='single-section-content same-content' ng-if="tempDurationType === 'hours&minutes'">
                                <div class="single-section-container clearfix">
                                    <div class='single-section-left' ng-class="{'hasPopup' : popupServingShowing || popupServingShowingEdit}">
                                        <div class="single-input">
                                            <div class="multi-childInput removeArrowPeriod">
                                                <h5 class="mandotory"><fmt:message key="step4.serviceTime.description" bundle="${lang}"/><span>*</span></h5>    
                                                <select id="servingPeriodIDInput" name="" class="blueInput normalFont" ng-model="package.servingPeriodID" ng-class="{'missing':(!showMissingData && package.servingPeriodID === null)}"
                                                        ng-options="period.id as period.name for (periodID, period) in providerServingPeriods">
                                                    <!--<option value="" disabled><fmt:message key="step4.serviceTime.option1" bundle="${lang}"/></option>-->
                                                    <!--                                                    <option ng-repeat="(periodID, period) in providerServingPeriods" value="{{periodID}}">
                                                                                                            {{period.name}}
                                                                                                        </option>-->
                                                </select>
                                            </div>
                                            <div class="multi-childInput"  ng-show="!popupServingShowing && !popupServingShowingEdit && package.servingPeriodID > 0">
                                                <div class="servingEdition clearfix">
                                                    <div class="servingPopupInput clearfix">
                                                        <div class="servingNameInput">
                                                            <p class="blueLabel multi-label">Operating name</p>
                                                            <p>{{providerServingPeriods[package.servingPeriodID].name}}</p>
                                                        </div>
                                                        <div class="servingTimeInput clearfix">
                                                            <div class="time">
                                                                <p class="blueLabel multi-label">Start time</p>
                                                                <p>{{providerServingPeriods[package.servingPeriodID].startOperationTime}}</p>
                                                            </div>
                                                            <div class="time">
                                                                <p class="blueLabel multi-label">End time</p>
                                                                <p>{{providerServingPeriods[package.servingPeriodID].endOperationTime}}</p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="servingEditBtn">
                                                        <a href="" class="linkBtn " ng-click="editSelectedResource()">
                                                            Edit*
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="multi-childInput" ng-if="!popupServingShowing && !popupServingShowingEdit">
                                                <button class="btn-width-orange newBtn" ng-click="openServingPopup()" id="newTimeSlotBtn"><fmt:message key="step4.serviceTime.option2" bundle="${lang}"/></button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class='single-section-instructions hasHeader' ng-if="!popupServingShowing && !popupServingShowingEdit">
                                        <p>
                                            <fmt:message key="step4.serviceTime1.howto" bundle="${lang}"/>
                                        </p>
                                    </div>
                                </div>
                            </div>

                            <div class="single-section-content popupSection darkgray-section-content" id="servingPopup" ng-show="popupServingShowing || popupServingShowingEdit">
                                <div class="popupSectionContent">
                                    <div class="center-informBlock blur-backgroud" ng-show="addingProcessing">
                                        <div class="small-spinner" ></div>
                                    </div>
                                    <div class="single-section-container clearfix">
                                        <div class='single-section-left'>

                                            <div class="single-input" ng-show="popupServingShowing">
                                                <div class="servingPopupInput clearfix">

                                                    <div class="servingNameInput">
                                                        <input type="text" class="blueInput normalFont borderDarkBlueInput" ng-model="newServing.name" ng-class="{'missing':(showMissingServingPeriod && (newServing.name === undefined || newServing.name === ''))}"
                                                               placeholder="Give your serving period a name (max. 50 Characters)"/>
                                                    </div>
                                                    <div class="servingTimeInput">
                                                        <input type="text" readonly ng-click="openTimeClock('openTime')" class="clock-input blueInput normalFont borderDarkBlueInput smallInput timeMaskInput"
                                                               ng-class="{'missing':(wrongTimeServingPeriod)}"   placeholder="Start time" ng-model="newServing.startTime"/>

                                                        <div class="popover clockpicker-popover bottom clockpicker-align-right" 
                                                             style="top: 40px; left: initial; right: 0px;">
                                                            <div class="arrow"></div>
                                                            <div class="popover-title">
                                                                <span class="clockpicker-span-hours text-primary">{{hourSlot}}</span>
                                                                : <span class="clockpicker-span-minutes" id="open-hour">{{minuteSlot}}</span>
                                                                <span class="clockpicker-span-am-pm"></span>
                                                            </div>
                                                            <div class="popover-content">
                                                                <div class="clockpicker-plate">
                                                                    <div class="clockpicker-dial clockpicker-hours active">
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('00')" style="left: 87px; top: 7px;">00</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('01')" style="left: 114px; top: 40.2346px; font-size: 120%;">1</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('02')" style="left: 133.765px; top: 60px; font-size: 120%;">2</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('03')" style="left: 141px; top: 87px; font-size: 120%;">3</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('04')" style="left: 133.765px; top: 114px; font-size: 120%;">4</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('05')" style="left: 114px; top: 133.765px; font-size: 120%;">5</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('06')" style="left: 87px; top: 141px; font-size: 120%;">6</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('07')" style="left: 60px; top: 133.765px; font-size: 120%;">7</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('08')" style="left: 40.2346px; top: 114px; font-size: 120%;">8</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('09')" style="left: 33px; top: 87px; font-size: 120%;">9</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('10')" style="left: 40.2346px; top: 60px; font-size: 120%;">10</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('11')" style="left: 60px; top: 40.2346px; font-size: 120%;">11</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('12')" style="left: 87px; top: 33px; font-size: 120%;">12</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('13')" style="left: 127px; top: 17.718px;">13</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('14')" style="left: 156.282px; top: 47px;">14</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('15')" style="left: 167px; top: 87px;">15</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('16')" style="left: 156.282px; top: 127px;">16</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('17')" style="left: 127px; top: 156.282px;">17</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('18')" style="left: 87px; top: 167px;">18</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('19')" style="left: 47px; top: 156.282px;">19</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('20')" style="left: 17.718px; top: 127px;">20</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('21')" style="left: 7px; top: 87px;">21</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('22')" style="left: 17.718px; top: 47px;">22</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('23')" style="left: 47px; top: 17.718px;">23</div>
                                                                    </div>
                                                                    <div class="clockpicker-dial clockpicker-minutes">
                                                                        <div class="clockpicker-tick" ng-click='setMinuteSlot("00")' style="left: 87px; top: 7px; font-size: 120%;">00</div>
                                                                        <div class="clockpicker-tick" ng-click='setMinuteSlot("05")' style="left: 127px; top: 17.718px; font-size: 120%;">05</div>
                                                                        <div class="clockpicker-tick" ng-click='setMinuteSlot("10")' style="left: 156.282px; top: 47px; font-size: 120%;">10</div>
                                                                        <div class="clockpicker-tick" ng-click='setMinuteSlot("15")' style="left: 167px; top: 87px; font-size: 120%;">15</div>
                                                                        <div class="clockpicker-tick" ng-click='setMinuteSlot("20")' style="left: 156.282px; top: 127px; font-size: 120%;">20</div>
                                                                        <div class="clockpicker-tick" ng-click='setMinuteSlot("25")' style="left: 127px; top: 156.282px; font-size: 120%;">25</div>
                                                                        <div class="clockpicker-tick" ng-click='setMinuteSlot("30")' style="left: 87px; top: 167px; font-size: 120%;">30</div>
                                                                        <div class="clockpicker-tick" ng-click='setMinuteSlot("35")' style="left: 47px; top: 156.282px; font-size: 120%;">35</div>
                                                                        <div class="clockpicker-tick" ng-click='setMinuteSlot("40")' style="left: 17.718px; top: 127px; font-size: 120%;">40</div>
                                                                        <div class="clockpicker-tick" ng-click='setMinuteSlot("45")' style="left: 7px; top: 87px; font-size: 120%;">45</div>
                                                                        <div class="clockpicker-tick" ng-click='setMinuteSlot("50")' style="left: 17.718px; top: 47px; font-size: 120%;">50</div>
                                                                        <div class="clockpicker-tick" ng-click='setMinuteSlot("55")' style="left: 47px; top: 17.718px; font-size: 120%;">55</div>
                                                                    </div>
                                                                </div><span class="clockpicker-am-pm-block"></span></div>
                                                        </div>
                                                        <input type="text" ng-click="openTimeClock('closeTime')" readonly class="clock-input blueInput normalFont borderDarkBlueInput smallInput timeMaskInput"
                                                               ng-class="{'missing':(wrongTimeServingPeriod)}"  placeholder="Closing time" ng-model="newServing.endTime"/>
                                                    </div>
                                                </div>
                                                <div class="popupCtrs clearfix">
                                                    <a href="" class="closeBtn" ng-click="closeServingPopup()">X</a>
                                                    <a href="" class="saveBtn" ng-click="insertNewServing()">Save this new TripSource™</a>
                                                </div>
                                            </div>
                                            <div class="single-input" ng-show="popupServingShowingEdit">
                                                <div class="servingPopupInput clearfix">

                                                    <div class="servingNameInput">
                                                        <input type="text" class="blueInput normalFont borderDarkBlueInput" ng-model="editResource.name"  ng-class="{'missing':(showMissingServingPeriod && (editSelectedResourceTimeTempName === undefined || editSelectedResourceTimeTempName === ''))}"
                                                               placeholder="Give your serving period a name (max. 50 Characters)"/>
                                                    </div>
                                                    <div class="servingTimeInput">
                                                        <input type="text" readonly ng-click="openTimeClock('openTime')" class="clock-input blueInput normalFont borderDarkBlueInput smallInput timeMaskInput"
                                                               ng-class="{'missing':(wrongTimeServingPeriod)}" placeholder="Start time" ng-model="editResource.startTime"/>

                                                        <div class="popover clockpicker-popover bottom clockpicker-align-right" 
                                                             style="top: 40px; left: initial; right: 0px;">
                                                            <div class="arrow"></div>
                                                            <div class="popover-title">
                                                                <span class="clockpicker-span-hours text-primary">{{hourSlot}}</span>
                                                                : <span class="clockpicker-span-minutes">{{minuteSlot}}</span>
                                                                <span class="clockpicker-span-am-pm"></span>
                                                            </div>
                                                            <div class="popover-content">
                                                                <div class="clockpicker-plate">
                                                                    <div class="clockpicker-dial clockpicker-hours active">
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('00')" style="left: 87px; top: 7px;">00</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('01')" style="left: 114px; top: 40.2346px; font-size: 120%;">1</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('02')" style="left: 133.765px; top: 60px; font-size: 120%;">2</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('03')" style="left: 141px; top: 87px; font-size: 120%;">3</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('04')" style="left: 133.765px; top: 114px; font-size: 120%;">4</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('05')" style="left: 114px; top: 133.765px; font-size: 120%;">5</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('06')" style="left: 87px; top: 141px; font-size: 120%;">6</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('07')" style="left: 60px; top: 133.765px; font-size: 120%;">7</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('08')" style="left: 40.2346px; top: 114px; font-size: 120%;">8</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('09')" style="left: 33px; top: 87px; font-size: 120%;">9</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('10')" style="left: 40.2346px; top: 60px; font-size: 120%;">10</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('11')" style="left: 60px; top: 40.2346px; font-size: 120%;">11</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('12')" style="left: 87px; top: 33px; font-size: 120%;">12</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('13')" style="left: 127px; top: 17.718px;">13</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('14')" style="left: 156.282px; top: 47px;">14</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('15')" style="left: 167px; top: 87px;">15</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('16')" style="left: 156.282px; top: 127px;">16</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('17')" style="left: 127px; top: 156.282px;">17</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('18')" style="left: 87px; top: 167px;">18</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('19')" style="left: 47px; top: 156.282px;">19</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('20')" style="left: 17.718px; top: 127px;">20</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('21')" style="left: 7px; top: 87px;">21</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('22')" style="left: 17.718px; top: 47px;">22</div>
                                                                        <div class="clockpicker-tick" ng-click="setHourSlot('23')" style="left: 47px; top: 17.718px;">23</div>
                                                                    </div>
                                                                    <div class="clockpicker-dial clockpicker-minutes">
                                                                        <div class="clockpicker-tick" ng-click='setMinuteSlot("00")' style="left: 87px; top: 7px; font-size: 120%;">00</div>
                                                                        <div class="clockpicker-tick" ng-click='setMinuteSlot("05")' style="left: 127px; top: 17.718px; font-size: 120%;">05</div>
                                                                        <div class="clockpicker-tick" ng-click='setMinuteSlot("10")' style="left: 156.282px; top: 47px; font-size: 120%;">10</div>
                                                                        <div class="clockpicker-tick" ng-click='setMinuteSlot("15")' style="left: 167px; top: 87px; font-size: 120%;">15</div>
                                                                        <div class="clockpicker-tick" ng-click='setMinuteSlot("20")' style="left: 156.282px; top: 127px; font-size: 120%;">20</div>
                                                                        <div class="clockpicker-tick" ng-click='setMinuteSlot("25")' style="left: 127px; top: 156.282px; font-size: 120%;">25</div>
                                                                        <div class="clockpicker-tick" ng-click='setMinuteSlot("30")' style="left: 87px; top: 167px; font-size: 120%;">30</div>
                                                                        <div class="clockpicker-tick" ng-click='setMinuteSlot("35")' style="left: 47px; top: 156.282px; font-size: 120%;">35</div>
                                                                        <div class="clockpicker-tick" ng-click='setMinuteSlot("40")' style="left: 17.718px; top: 127px; font-size: 120%;">40</div>
                                                                        <div class="clockpicker-tick" ng-click='setMinuteSlot("45")' style="left: 7px; top: 87px; font-size: 120%;">45</div>
                                                                        <div class="clockpicker-tick" ng-click='setMinuteSlot("50")' style="left: 17.718px; top: 47px; font-size: 120%;">50</div>
                                                                        <div class="clockpicker-tick" ng-click='setMinuteSlot("55")' style="left: 47px; top: 17.718px; font-size: 120%;">55</div>
                                                                    </div>
                                                                </div><span class="clockpicker-am-pm-block"></span></div>
                                                        </div>
                                                        <input type="text" ng-click="openTimeClock('closeTime')" readonly class="clock-input blueInput normalFont borderDarkBlueInput smallInput timeMaskInput"
                                                               ng-class="{'missing':(wrongTimeServingPeriod)}"  placeholder="Closing time" ng-model="editResource.endTime"/>
                                                    </div>
                                                </div>
                                                <div class="popupCtrs clearfix">
                                                    <a href="" class="closeBtn" ng-click="closeServingPopup()">X</a>
                                                    <a href="" class="saveBtn" ng-click="updateServing()">Save this new TripSource™</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class='single-section-instructions'>
                                            <p>
                                                If this serving time is created just for this package make sure to name it with a reference to this package to help you separate it from general serving times later.
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class='single-section-content same-content'>
                                <div class="single-section-container clearfix">
                                    <div class='single-section-left' ng-class="{'hasPopup' : popupServingShowing || popupServingShowingEdit}">
                                        <div class="single-input" ng-if="package.isSpecificLaunchDate">
                                            <h5 class="mandotory"><fmt:message key="step4.weeklyOperation.description" bundle="${lang}"/><span>*</span></h5>
                                            <div class="filter-row row">
                                                <div class="col-xs-2 radio-col">
                                                    <input ng-model="package.sequentialOperation" type="radio" name="sequential" value="0" />
                                                    <a href="" ng-click=""><fmt:message key="step4.weeklyOperation.everyday" bundle="${lang}"/></a>
                                                </div>
                                                <div class="col-xs-2 radio-col">
                                                    <input ng-model="package.sequentialOperation" type="radio" name="sequential" value="2" />
                                                    <a href="" ng-click=""><fmt:message key="step4.weeklyOperation.2days" bundle="${lang}"/></a>
                                                </div>
                                                <div class="col-xs-2 radio-col">
                                                    <input ng-model="package.sequentialOperation" type="radio" name="sequential" value="3" />
                                                    <a href="" ng-click=""><fmt:message key="step4.weeklyOperation.3days" bundle="${lang}"/></a>
                                                </div>
                                                <div class="col-xs-2 radio-col">
                                                    <input ng-model="package.sequentialOperation" type="radio" name="sequential" value="4" />
                                                    <a href="" ng-click=""><fmt:message key="step4.weeklyOperation.4days" bundle="${lang}"/></a>
                                                </div>
                                                <div class="col-xs-2 radio-col">
                                                    <input ng-model="package.sequentialOperation" type="radio" name="sequential" value="5" />
                                                    <a href="" ng-click=""><fmt:message key="step4.weeklyOperation.5days" bundle="${lang}"/></a>
                                                </div>
                                                <div class="col-xs-2 radio-col">
                                                    <input ng-model="package.sequentialOperation" type="radio" name="sequential" value="6" />
                                                    <a href="" ng-click=""><fmt:message key="step4.weeklyOperation.6days" bundle="${lang}"/></a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="single-input">
                                            <h5>Except on these days</h5>
                                            <div class="filter-row row dayExceptionRow">
                                                <div class="col-xs-2 radio-col">
                                                    <input type="checkbox" name="unavailableDays" checklist-model="package.unavailableDays" checklist-value="0"/>
                                                    <a href="" ng-click=""><fmt:message key="step4.except.sunday" bundle="${lang}"/></a>
                                                </div>
                                                <div class="col-xs-2 radio-col">
                                                    <input type="checkbox" name="unavailableDays" checklist-model="package.unavailableDays" checklist-value="1" />
                                                    <a href="" ng-click=""><fmt:message key="step4.except.mon" bundle="${lang}"/></a>
                                                </div>
                                                <div class="col-xs-2 radio-col">
                                                    <input type="checkbox" name="unavailableDays" checklist-model="package.unavailableDays" checklist-value="2" />
                                                    <a href="" ng-click=""><fmt:message key="step4.except.tue" bundle="${lang}"/></a>
                                                </div>
                                                <div class="col-xs-2 radio-col">
                                                    <input type="checkbox" name="unavailableDays" checklist-model="package.unavailableDays" checklist-value="3"/>
                                                    <a href="" ng-click=""><fmt:message key="step4.except.wed" bundle="${lang}"/></a>
                                                </div>
                                                <div class="col-xs-2 radio-col">
                                                    <input type="checkbox" name="unavailableDays" checklist-model="package.unavailableDays" checklist-value="4" />
                                                    <a href="" ng-click=""><fmt:message key="step4.except.thu" bundle="${lang}"/></a>
                                                </div>
                                                <div class="col-xs-2 radio-col">
                                                    <input type="checkbox" name="unavailableDays" checklist-model="package.unavailableDays" checklist-value="5" />
                                                    <a href="" ng-click=""><fmt:message key="step4.except.fri" bundle="${lang}"/></a>
                                                </div>
                                                <div class="col-xs-2 radio-col">
                                                    <input type="checkbox" name="unavailableDays" checklist-model="package.unavailableDays" checklist-value="6" />
                                                    <a href="" ng-click=""><fmt:message key="step4.except.sat" bundle="${lang}"/></a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="single-input">
                                            <button class="btn-width-orange next-btn" ng-click="openConfirmBox('finish')"><fmt:message key="saveBtn" bundle="${lang}"/></button>
                                            <!--                                            <button href="" ng-if="allStepDones"  ng-click="finishToPreview()"
                                                                                                class="btn-width-orange next-btn">All done! Let's launch this package!</button>-->
                                        </div>
                                    </div>
                                    <div class='single-section-instructions'>
                                        <p>
                                            <fmt:message key="step4.serviceTime2.howto" bundle="${lang}"/>
                                        </p>
                                    </div>
                                </div>
                            </div>  
                            <!--END CALENDAR-->
                        </div>
                        <div id="availableCalendar">
                            <div class="smallCalendar">
                                <div class="calendarYearMonth">
                                    <a href="" class="backCalendar" ng-click="backAvailableMonth()"></a>
                                    <h4>{{MONTHS_OF_YEAR[inputDate.getMonth()]}} {{inputDate.getFullYear()}}</h4>
                                    <a href="" class="nextCalendar" ng-click="nextAvailableMonth()"></a>
                                </div>
                                <div class="weekDays">
                                    <ul class="clearfix">
                                        <li>SUN</li>
                                        <li>MON</li>
                                        <li>TUE</li>
                                        <li>WED</li>
                                        <li>THU</li>
                                        <li>FRI</li>
                                        <li>SAT</li>
                                    </ul>
                                </div>
                                <div class="calendarDate">

                                </div>
                            </div>
                        </div>
                    </div>
                    <!--END BOOKING SECTION-->

                    <!--PRICE SECTION-->
                    <div class="content" ng-switch-when="price">

                        <!--Cancellation policy-->
                        <div class='single-section-content'>
                            <div class="single-section-container clearfix">
                                <div class='single-section-left'>
                                    <div class="single-input">
                                        <div class="multi-childInput">
                                            <h5 class="mandotory"><fmt:message key="step5.cancellation.description" bundle="${lang}"/><span>*</span></h5>  
                                            <div class="row">
                                                <div class="col-xs-6">
                                                    <a href="" class="linkBtn hrefCheckBox" 
                                                       ng-class="{'active':(!isHaveCancellation)}"  ng-click="offerPolicy(false)">
                                                        <fmt:message key="step5.cancellation.option1" bundle="${lang}"/>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="multi-childInput">
                                            <div class="row">
                                                <div class="col-xs-6" style="text-align: center">
                                                    <fmt:message key="step4.operationSchedule.or" bundle="${lang}"/>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="multi-childInput">  
                                            <div class="row">
                                                <div class="col-xs-6">
                                                    <a href="" class="linkBtn hrefCheckBox" 
                                                       ng-class="{'active':(isHaveCancellation)}"  ng-click="offerPolicy(true)">
                                                        <fmt:message key="step5.cancellation.option2" bundle="${lang}"/>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="multi-childInput" ng-if="isHaveCancellation"
                                             ng-repeat="x in package.cancellationPolicyJson track by $index">
                                            <h5 class="mandotory" ng-show="$first"><fmt:message key="step5.cancellation.condition.description" bundle="${lang}"/><span>*</span></h5>
                                            <div class="PolicyRow clearfix">
                                                <div class=" priceStandardHeader containTextBox policy-condition">
                                                    <fmt:message key="step5.cancellation.condition.detail1" bundle="${lang}"/>
                                                    <input type="text" class="normalFont blueInput age-text-box" placeholder="Enter days"
                                                           ng-model="x.duration" ng-class="{'missing':!showMissingData
                                                                                       && (x.duration === null || x.duration === '')}" numbers-only/> <fmt:message key="step5.cancellation.condition.detail2" bundle="${lang}"/>
                                                </div>
                                                <div class="priceStandardHeader containTextBox policy-condition">

                                                    <div class="priceStandardHeader">
                                                        <select style="width: 115px;" class="blueInput" name="" ng-model="x.percent" convert-to-number>
                                                            <option value="5">5%</option>
                                                            <option value="10">10%</option>
                                                            <option value="15">15%</option>
                                                            <option value="20">20%</option>
                                                            <option value="25">25%</option>
                                                            <option value="30">30%</option>
                                                            <option value="35">35%</option>
                                                            <option value="40">40%</option>
                                                            <option value="45">45%</option>
                                                            <option value="50">50%</option>
                                                            <option value="55">55%</option>
                                                            <option value="60">60%</option>
                                                            <option value="65">65%</option>
                                                            <option value="70">70%</option>
                                                            <option value="75">75%</option>
                                                            <option value="80">80%</option>
                                                            <option value="85">85%</option>
                                                            <option value="90">90%</option>
                                                            <option value="95">95%</option>
                                                        </select>
                                                        <fmt:message key="step5.cancellation.condition.detail3" bundle="${lang}"/>
                                                        <div class="plusBox">
                                                            <div class="deleteSign" ng-show="!$first" ng-click="removeCancellationPolicy($index)"></div>
                                                        </div>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>

                                        <div class="multi-childInput" ng-if="isHaveCancellation">
                                            <div class="newPolicy" ng-click="addNewPolicy()"
                                                 ng-class="{'disable-addnew-btn':package.cancellationPolicyJson.length >= 5}"><fmt:message key="step5.cancellation.condition.addNew" bundle="${lang}"/></div>
                                        </div>
                                    </div>

                                </div>
                                <div class='single-section-instructions'>
                                    <p>
                                        In this section you can set up a cancellation policy or continue with the default setting of not offering one. 
                                        <br><br>
                                        Cancellation policies are not mandatory and often not available due to cheaper pricing of online channels. However, to be fair to providers who do offer it, we have included it here.
                                        <br><br>
                                        To set up a cancellation policy click on the “Add a new policy” button and fill in the required fields.

                                    </p>
                                </div>
                            </div>

                        </div>


                        <!--Standard Tab-->
                        <div class="instruction-alt">
                            <div class="single-section-content">
                                <div class="single-section-container">
                                    <div class="instruction-alt-padding">
                                        <fmt:message key="step5.discount&price.description" bundle="${lang}"/>
                                    </div>
                                </div>
                            </div>
                        </div>  

                        <div class='single-section-content darkgray-section-content'>
                            <div class="single-section-container clearfix">
                                <div class='single-section-left'>
                                    <div class="single-input">


                                        <div class="multi-childInput">                                          
                                            <div class="row">
                                                <div class="col-xs-9 priceStandardHeader">

                                                    <h5 class="inside-h5" style="float: left">
                                                        <fmt:message key="step5.discount&price.currency" bundle="${lang}"/><sup class="sup-icon">†</sup><span> *</span>
                                                        <div style="float: right" id="" class="contentCirceTop contentStandard" ng-click="" >
                                                            ?
                                                        <span class="tooltiptext">
                                                            <fmt:message key="step5.priceDescription.currency" bundle="${lang}"/>
                                                        </span>
                                                        </div>
                                                    </h5>
                                                       



                                                </div>
                                                <div class="col-xs-3 priceStandardValue">
                                                    <div class="col-xs-9 smallLeftPriceYoutripper">

                                                        <select ng-model="package.priceCurrency" class="blueInput currency">
                                                            <option value="THB">THB</option>
                                                            <option value="USD">USD</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="multi-childInput" ng-hide="true">                                          
                                            <div class="row">
                                                <div class="col-xs-9 priceStandardHeader">
                                                    <h5 class="inside-h5" style="float: left">
                                                        <fmt:message key="step5.discount&price.walkin" bundle="${lang}"/><sup class="sup-icon">†</sup><span> *</span>
                                                        <div style="float: right" id="" class="contentCirceTop contentStandard" ng-click="" >
                                                            ?
                                                            <!--cai nay tam thoi bo-->
                                                        </div>
                                                    </h5>
                                                </div>
                                                <div class="col-xs-3 priceStandardValue">
                                                    <div class="col-xs-9 smallLeftPriceYoutripper">
                                                        <input id="packagePriceInput" ng-class="{'missing':(!showMissingData && (package.ordinaryPriceForAdult === '' || package.ordinaryPriceForAdult === 0))}" type="text" class="normalFont blueInput PriceTextBox" placeholder="00.00"
                                                               ng-model="package.ordinaryPriceForAdult" numbers-only />
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <div class="blueLabel marginleft">{{package.priceCurrency}}</div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="multi-childInput">                                          
                                            <div class="row">
                                                <div class="col-xs-9 priceStandardHeader">
                                                    <h5 class="inside-h5" style="float: left"><fmt:message key="step5.discount&price.youtripperPrice" bundle="${lang}"/><sup class="sup-icon">†</sup><span> *</span>
                                                        <div style="float: right" id="" class="contentCirceTop contentStandard" ng-click="" >
                                                            ?
                                                        <span class="tooltiptext">
                                                            <fmt:message key="step5.priceDescription.onlinePrice" bundle="${lang}"/>
                                                        </span>
                                                        </div>
                                                    </h5>
                                                </div>
                                                <div class="col-xs-3 priceStandardValue">
                                                    <div class="col-xs-9 smallLeftPriceYoutripper">
                                                        <input id="packagePriceInput" ng-class="{'missing':(!showMissingData && (package.youtripperPrice === '' || package.youtripperPrice === 0))}" type="text" class="normalFont blueInput PriceTextBox" placeholder="00.00"
                                                               ng-model="package.youtripperPrice" numbers-only />
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <div class="blueLabel marginleft">{{package.priceCurrency}}</div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="multi-childInput" ng-hide="true">
                                            <div class="row">
                                                <div class="col-xs-7 priceStandardHeader">
                                                    <h5 class="inside-h5" style="float: left">
                                                        <fmt:message key="step5.discount&price.online1" bundle="${lang}"/><sup class="sup-icon">††</sup><fmt:message key="step5.discount&price.online2" bundle="${lang}"/><span>*</span>
                                                        <div style="float: right" id="" class="contentCirce contentStandard" ng-click="" >
                                                            ?
                                                           
                                                        </div>
                                                    </h5>
                                                </div>
                                                <div class="col-xs-5 priceStandardValue">
                                                    <div class="col-xs-2 minusBox">
                                                        <div id="minusYTPercentage" class="minusSign" ng-click="descreaseYTPercentage()" ng-class="{'active':(package.youtripperPercentage > 8)}"></div>
                                                    </div>
                                                    <div class="col-xs-6 newYoutripperPercentage">
                                                        <input type="text" class="normalFont blueInput PriceTextBox" placeholder="00.00"
                                                               value="{{formatPercentage(package.youtripperPercentage)}}" readonly="readonly"/>
                                                    </div>
                                                    <div class="col-xs-2 plusBox">
                                                        <div id="plusYTPercentage" class="plusSign" ng-click="increaseYTPercentage()" ng-class="{'active':(package.youtripperPercentage < 100)}"></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="single-input">    
                                        <div class="multi-childInput">  
                                            <div class="row">
                                                <div class="col-xs-7">
                                                    <a href="" class="linkBtn hrefCheckBox" 
                                                       ng-class="{'active':(isHaveChildrenDiscount)}"  ng-click="isOfferChildrenCount()">
                                                        <fmt:message key="step5.offerDiscount" bundle="${lang}"/>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="single-input" ng-if="isHaveChildrenDiscount">
                                        <div class="multi-childInput"
                                             ng-repeat="x in package.childrenDiscountJson track by $index">
                                            <div class="row">
                                                <div class="col-xs-7">
                                                    <h5 class="mandotory"><fmt:message key="step5.childDiscount.description" bundle="${lang}"/><span>*</span></h5>
                                                </div>
                                                <div class="col-xs-12 priceStandardHeader containTextBox">
                                                    <select ng-model="x.discountType" class="blueInput discount-type">
                                                        <option value="age"><fmt:message key="step5.childDiscount.age" bundle="${lang}"/></option>
                                                        <option value="height"><fmt:message key="step5.childDiscount.height" bundle="${lang}"/></option>
                                                    </select> {{x.discountType === 'height' ? '<fmt:message key="step5.pricePreview.below" bundle="${lang}"/>':'<fmt:message key="step5.pricePreview.under" bundle="${lang}"/>'}} 
                                                    <input type="text" class="normalFont blueInput age-text-box" placeholder="number"
                                                           ng-model="x.condition" ng-class="{'missing':(!showMissingData && x.condition === '')}" numbers-only/>
                                                    <select ng-model="x.ageType" class="blueInput discount-type" ng-if="x.discountType === 'age'">
                                                        <option value="months"><fmt:message key="step4.duration.month" bundle="${lang}"/></option>
                                                        <option value="years"><fmt:message key="step4.duration.year" bundle="${lang}"/></option>
                                                    </select>
                                                    {{x.discountType === 'height' ? 'cm':''}} <fmt:message key="step5.childDiscount.detail" bundle="${lang}"/>
                                                    <select name="" ng-model="x.discountPercent" convert-to-number class="blueInput child-discount-percent">
                                                        <option value="5">5%</option>
                                                        <option value="10">10%</option>
                                                        <option value="15">15%</option>
                                                        <option value="20">20%</option>
                                                        <option value="25">25%</option>
                                                        <option value="30">30%</option>
                                                        <option value="35">35%</option>
                                                        <option value="40">40%</option>
                                                        <option value="45">45%</option>
                                                        <option value="50">50%</option>
                                                        <option value="55">55%</option>
                                                        <option value="60">60%</option>
                                                        <option value="65">65%</option>
                                                        <option value="70">70%</option>
                                                        <option value="75">75%</option>
                                                        <option value="80">85%</option>
                                                        <option value="85">85%</option>
                                                        <option value="90">90%</option>
                                                        <option value="95">95%</option>
                                                    </select>
                                                    <div class="deleteSign remove-children-discount" ng-show="!$first" ng-click="removeChildrenDiscount($index)"></div>
                                                </div>

                                            </div>
                                        </div>
                                        <div class="multi-childInput">
                                            <div class="newPolicy" ng-click="addNewDiscount()"
                                                 ng-class="{'disable-addnew-btn':package.childrenDiscountJson.length === 4}" ><fmt:message key="step5.childDiscount.addNew" bundle="${lang}"/></div>
                                        </div>
                                    </div>
                                </div>

                                <div class='single-section-instructions' >
                                    <p>
                                        † This is the price without any discounts and the price walk-in customers would pay to you. 
                                        <br/><br/>
                                        †† 8% is the mandatory discount to ensure a lower online purchase price than the in shop regular price.
                                        <br/>
                                        Please be reminded that youtripper enforces a strict price matching policy. Our online price must match the lowest price that you are offering elsewhere. 
                                    </p>

                                    <p ng-show="isHaveChildrenDiscount">
                                        Add children discount conditions that will be made available in the booking box on the package page. 
                                        <br/>
                                        The price is calculated from the youtripper online price and not the standard price. You can also provide free admission for children under a certain age.
                                    </p>
                                </div>
                            </div>
                        </div>

                        <div class='single-section-content darkgray-section-content same-content' ng-if="isHaveCancellation">
                            <div class="single-section-container clearfix">
                                <div class='single-section-left'>
                                    <div class="single-input">     
                                        <div class="multi-childInput">  
                                            <div class="row">
                                                <div class="col-xs-7">
                                                    <a href="" class="linkBtn hrefCheckBox" 
                                                       ng-class="{'active':(package.noCancellationPercent !== 0)}"
                                                       ng-click="chooseNoCancellationPrice()">
                                                        <fmt:message key="step5.noCancellation.description" bundle="${lang}"/>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="multi-childInput" ng-if="package.noCancellationPercent > 0">
                                            <div class="row">                                                
                                                <div class="col-xs-7">
                                                    <h5 class="inside-h5"><fmt:message key="step5.noCancellation.detail" bundle="${lang}"/><span>*</span></h5>
                                                </div>

                                                <div class="col-xs-5 priceStandardValue">
                                                    <div class="col-xs-2 minusBox">
                                                        <div id="minusInNoCancellation" 
                                                             ng-click="descreaseNoCancellationPercentage()" 
                                                             class="minusSign" ng-class="{'active':(package.noCancellationPercent > 1)}">

                                                        </div>
                                                    </div>
                                                    <div class="col-xs-6 newYoutripperPercentage">
                                                        <input type="text" class="normalFont blueInput PriceTextBox" placeholder="00.00"
                                                               value="{{viewNoCancellationPrice(package.noCancellationPercent)}}" />
                                                    </div>
                                                    <div class="col-xs-2 plusBox">
                                                        <div id="plusInNoCancellation" class="plusSign" ng-click="increaseNoCancellationPercentage()" ng-class="{'active':(package.noCancellationPercent < 100)}"></div>
                                                        <!--                                                        <div class="SaveNoCancellationPirce">Save</div>-->
                                                    </div>
                                                </div>        
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class='single-section-instructions'  ng-show="package.noCancellationPercent > 0">
                                    <p>
                                        Promote a non-insured package at an even cheaper price while the insured package
                                        will be offered at the normal discount rate. Use this as a competitive advantage.
                                    </p>
                                </div>
                            </div>
                        </div>

                        <!--Standard Tab-->
                        <div class="instruction-alt">
                            <div class="single-section-content">
                                <div class="single-section-container">
                                    <div class="instruction-alt-padding">
                                        <fmt:message key="step5.pricePreview.description" bundle="${lang}"/>
                                    </div>
                                </div>
                            </div>
                        </div>  

                        <div class='single-section-content'>
                            <div class="single-section-container clearfix">
                                <div class='single-section-left' id="price-preview">
                                    <div class="single-input">

                                        <div class="multi-childInput" style="display: table-cell">
                                            <h5 style="float: left"><fmt:message key="step5.pricePreview.online" bundle="${lang}"/>  
                                            </h5>
<!--                                            <div id="" style="float: right; margin-left: 5px" class="contentCirce contentStandard" ng-click="" >
                                                    ?
                                                    <span class="tooltiptext">
                                                        is the mandatory discount to ensure a lower online purchase price than the in shop regular price. 
                                                        Please be reminded that youtripper enforces a strict price matching policy. Our online price must match the lowest price that you are offering elsewhere
                                                    </span> 
                                                </div>-->
                                        </div>

                                        <div class="multi-childInput">
                                            <div class="row">
                                                <div class="col-xs-10 blackText" >
                                                    <span style="float: left">
                                                        <fmt:message key="step5.pricePreview.text1" bundle="${lang}"/>
                                                        <div  id="" style="float: right" class="contentCirceBottom contentStandard" ng-click="" >
                                                            ?
                                                            <span class="tooltiptext">
                                                                <fmt:message key="step5.priceDescription.standardPrice" bundle="${lang}"/>
                                                            </span> 
                                                        </div>
                                                    </span>
                                                </div>
                                                <div class="col-xs-2 price-content">
                                                    <div class="row">
                                                        <div class="col-xs-7">
                                                            <div class="blackText" placeholder="00.00">
                                                                {{package.youtripperPrice| number
                                                                                            : 2}}
                                                            </div>
                                                        </div>
                                                        <div class="col-xs-5">
                                                            <div class="blackText">{{package.priceCurrency}}</div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="multi-childInput">
                                            <div class="row">
                                                <div class="col-xs-10 redText" >
                                                    <span style="float: left">
                                                        <fmt:message key="step5.pricePreview.text3" bundle="${lang}"/>
                                                        <div  id="" style="float: right" class="contentCirceBottom contentStandard" ng-click="" >
                                                            ?
                                                            <span class="tooltiptext">
                                                                <fmt:message key="step5.priceDescription.servicePrice" bundle="${lang}"/>
                                                         </span> 
                                                        </div>
                                                    </span>
                                                </div>
                                                <div class="col-xs-2 price-content">
                                                    <div class="row">
                                                        <div class="col-xs-7">
                                                            <div class="redBox" placeholder="00.00">
                                                                {{package.youtripperPrice - package.youtripperPrice * 5 / 100| number
                                                                                            : 2}}
                                                            </div>
                                                        </div>
                                                        <div class="col-xs-5">
                                                            <div class="redBox">{{package.priceCurrency}}</div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="multi-childInput">
                                            <div class="row">
                                                <div class="col-xs-10">

                                                    <span class=" blueLabel multi-label" style="float: left">
                                                        <fmt:message key="step5.pricePreview.text2" bundle="${lang}"/>
                                                        <div  id="" style="float: right" class="contentCirceBottom contentStandard" ng-click="" >
                                                            ?
                                                            <span class="tooltiptext">
                                                                <fmt:message key="step5.priceDescription.deductPrice" bundle="${lang}"/>
                                                        </span> 
                                                        </div>
                                                    </span>

                                                </div>
                                                <div class="col-xs-2  price-content">
                                                    <div class="row">
                                                        <div class="col-xs-7">
                                                            <div  class="blueLabel multi-label" placeholder="00.00"> 
                                                                {{(package.youtripperPrice
                                                                                            - package.youtripperPrice * (package.ytComission / 100)
                                                                                            ) | number
                                                                                            : 2}}
                                                            </div>
                                                        </div>
                                                        <div class="col-xs-5">
                                                            <div class="blueLabel multi-label">{{package.priceCurrency}}</div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="single-input" ng-if="isHaveCancellation && package.noCancellationPercent > 0">
                                        <div class="multi-childInput">
                                            <h5><fmt:message key="step5.pricePreview.noCancellation" bundle="${lang}"/></h5>
                                        </div>
                                        <div class="multi-childInput">
                                            <div class="row">
                                                <div class="col-xs-10 redText">
                                                    <span style="float: left">
                                                        <fmt:message key="step5.pricePreview.noCancellation.text1" bundle="${lang}"/>
                                                        <div  id="" style="float: right" class="contentCirceBottom contentStandard" ng-click="" >
                                                            ?
                                                            <span class="tooltiptext">
                                                                <fmt:message key="step5.priceDescription.nocancelPrice" bundle="${lang}"/>
                                                         </span> 
                                                        </div>
                                                    </span>
                                                </div>
                                                <div class="col-xs-2  price-content">
                                                    <div class="row">
                                                        <div class="col-xs-7">
                                                            <div class="redBox" placeholder="00.00" >
                                                                {{package.youtripperPrice *
                                                                                            ((100 - package.noCancellationPercent) / 100) | number : 2}} 
                                                            </div>
                                                        </div>
                                                        <div class="col-xs-5">
                                                            <div class="redBox">{{package.priceCurrency}}</div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="multi-childInput">
                                            <div class="row">
                                                <div class="col-xs-10">
                                                    <span class=" blueLabel  multi-label" style="float: left">
                                                        <fmt:message key="step5.pricePreview.noCancellation.text2" bundle="${lang}"/>
                                                        <div  id="" style="float: right" class="contentCirceBottom contentStandard" ng-click="" >
                                                            ?
                                                        <span class="tooltiptext">
                                                            <fmt:message key="step5.priceDescription.payoutNocancelPrice" bundle="${lang}"/>
                                                        </span> 
                                                        </div>
                                                    </span>
                                                </div>
                                                <div class="col-xs-2  price-content">
                                                    <div class="row">
                                                        <div class="col-xs-7">
                                                            <div  class="blueLabel multi-label" placeholder="00.00">
                                                                {{package.youtripperPrice *
                                                                                            ((100 - package.noCancellationPercent) / 100) * ((100 - package.ytComission) / 100) | number : 2}} 
                                                            </div>
                                                        </div>
                                                        <div class="col-xs-5">
                                                            <div class="blueLabel  multi-label">{{package.priceCurrency}}</div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>


                                    <div class="single-input" ng-repeat="x in package.childrenDiscountJson track by $index" 
                                         ng-if="x.discountPercent !== '' && x.condition !== ''">

                                        <div class="multi-childInput">
                                            <h5><fmt:message key="step5.pricePreview.children" bundle="${lang}"/> {{x.discountType === 'height' ? '<fmt:message key="step5.pricePreview.below" bundle="${lang}"/>':'<fmt:message key="step5.pricePreview.under" bundle="${lang}"/>'}}
                                                {{x.condition}} {{x.discountType === 'age' ? x.ageType:'cm'}} <fmt:message key="step5.pricePreview.price" bundle="${lang}"/></h5>
                                        </div>

                                        <div class="multi-childInput">
                                            <div class="row">
                                                <div class="col-xs-10 redText">
                                                    <span style="float: left">
                                                        <fmt:message key="step5.pricePreview.childrenDiscount.text1" bundle="${lang}"/>
                                                        <div  id="" style="float: right" class="contentCirceBottom contentStandard" ng-click="" >
                                                            ?
                                                        <span class="tooltiptext">
                                                            <fmt:message key="step5.priceDescription.promotionPrice" bundle="${lang}"/>
                                                        </span> 
                                                        </div>
                                                    </span>
                                                </div>
                                                <div class="col-xs-2 price-content">
                                                    <div class="row">
                                                        <div class="col-xs-7">
                                                            <div class="redBox" placeholder="00.00">
                                                                {{(package.youtripperPrice * ((100 - x.discountPercent) / 100)) | number : 2}}
                                                            </div>
                                                        </div>
                                                        <div class="col-xs-5">
                                                            <div class="redBox">{{package.priceCurrency}}</div>
                                                        </div>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>

                                        <div class="multi-childInput">
                                            <div class="row">
                                                <div class="col-xs-10">
                                                    <span class=" blueLabel  multi-label" style="float: left">
                                                        <fmt:message key="step5.pricePreview.childrenDiscount.text2" bundle="${lang}"/>
                                                        <div  id="" style="float: right" class="contentCirceBottom contentStandard" ng-click="" >
                                                            ?
                                                        <span class="tooltiptext">
                                                            <fmt:message key="step5.priceDescription.payoutPromotionPrice" bundle="${lang}"/>
                                                        </span> 
                                                        </div>
                                                    </span>
                                                </div>
                                                <div class="col-xs-2  price-content">
                                                    <div class="row">
                                                        <div class="col-xs-7">
                                                            <div  class="blueLabel multi-label" placeholder="00.00">
                                                                {{(package.youtripperPrice * ((100 - x.discountPercent) / 100) * (100 - package.ytComission) / 100) | number : 2}}
                                                            </div>
                                                        </div>
                                                        <div class="col-xs-5">
                                                            <div class="blueLabel  multi-label">{{package.priceCurrency}}</div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>          
                                    <div class="single-input">
                                        <button class="btn-width-orange next-btn" ng-click="openConfirmBox('finish')"><fmt:message key="saveBtn" bundle="${lang}"/></button>                                                                         
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                    <!--END PRICE SECTION-->

                    <div class="certificateBox" id="ConfirmBox">
                        <div class="nextStepContent">
                            <div class="center-informBlock blur-backgroud" ng-show="newPackageProcessing">
                                <div class="small-spinner" ></div>
                            </div>                            
                            <h4><fmt:message key="registration.confirm.title" bundle="${lang}"/></h4>
                            <div class="row">                                                               
                                <div class="col-xs-12 ">
                                    <div style="text-align: center" >
                                        <a href="" ng-click="confirmEdit()" class="btn-width-orange login_gg btnNextStep"><fmt:message key="registration.confirm.fill" bundle="${lang}"/></a>
                                    </div>
                                </div>

                            </div>

                            <div  style="text-align: center"> <fmt:message key="registration.confirm.or" bundle="${lang}"/></div>
                            <div class="row">
                                <div class="col-xs-12 " >
                                    <div style="text-align: center" >
                                        <a href="" ng-click="confirmContinue(nextStep)" class="btn-width-orange btnNextStep"><fmt:message key="registration.confirm.next" bundle="${lang}"/></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="certificateBox" id="reasonBox">
                        <div class="nextStepContent">
                            <div class="center-informBlock blur-backgroud" ng-show="addingEditingReason">
                                <div class="small-spinner" ></div>
                            </div>                            
                            <h4>Edit "Find your action!" and "Describe it!" required a reason:</h4>
                            <textarea class="normalFont blueTextArea" type="text"  maxlength="200"
                                      placeholder="Enter Reason" 
                                      ng-model="reasonModel" value="" ng-class="{'missing':showMissingReason}" ></textarea>
                            <br>
                            <div class="row confirm-clone-btn">                                                               
                                <div class="col-xs-4">
                                    <div style="text-align: center" >
                                        <a href="" ng-click="insertEditReason()" class="btn-width-orange btnNextStep">Submit</a>
                                    </div>
                                </div>
                                <div class="col-xs-4">
                                    <div style="text-align: center" >
                                        <a href="" class="btn-width-orange login_gg btnNextStep" ng-click="closeReasonBox()">Cancel</a>
                                    </div>
                                </div>


                            </div>
                        </div>
                    </div>
                    <div class="certificateBox" id="warningBox">
                        <div class="nextStepContent">
                            <div class="center-informBlock blur-backgroud" ng-show="warningBoxShowing">
                                <div class="small-spinner" ></div>
                            </div>                            
                            <h4>Edit "Find your action!" and "Describe it!" will change your package status to pending approve, do you want continue ?</h4>

                            <br>
                            <div class="row confirm-clone-btn">                                                               
                                <div class="col-xs-4">
                                    <div style="text-align: center" >
                                        <a href="" ng-click="closeWarningBox(); openConfirmBox(nextStep)" class="btn-width-orange btnNextStep">Yes</a>
                                    </div>
                                </div>
                                <div class="col-xs-4">
                                    <div style="text-align: center" >
                                        <a href="" class="btn-width-orange login_gg btnNextStep" ng-click="closeWarningBox()">No</a>
                                    </div>
                                </div>


                            </div>
                        </div>
                    </div>
                </div>
                    <!--Warning to save data popup-->
                    <div class="certificateBox" id="warningSaveBox">
                        <div class="confim-clone-package">                            
                            <h4>It's has been 30 minutes since your last save, do you want save before continue working ?</h4>
                            <div class="row confirm-clone-btn">                                                               
                                <div class="col-xs-4">
                                    <div style="text-align: center" >
                                        <a href="" ng-click="confirmContinue(selectedWizard)" class="btn-width-orange btnNextStep">Save</a>
                                    </div>
                                </div>
                                <div class="col-xs-4">
                                    <div style="text-align: center" >
                                        <a href="" class="btn-width-orange login_gg btnNextStep" ng-click="closeWaringSave()">No</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

            </div>
            <!--END RIGHT CONTENT-->

        </div>
        <!--END CONTENT-->
    </div>
</body>
<script>
    var packageForm = ${requestScope.packageForm};
    var packageEdit = ${requestScope.packageEdit};
    var uploadCoverImageUrl = '<c:url value="/Provider/Package/editCoverImage"/>';
    var uploadAdditionalImagesUrl = '<c:url value="/Provider/Package/editAdditionalImages"/>';
    var deleteAdditionalImageUrl = '<c:url value="/Provider/Package/deleteAdditionalImagePackage"/>';
    var macAddress = '${requestScope.macAddress}';
    var timeNowVar = '${requestScope.timeNow}';</script>

<script src = "https://maps.googleapis.com/maps/api/js?signed_in=true&libraries=places&language=en&key=AIzaSyBxd2qXURVG6IsmGwrti3CzGwCpGNXFFuw&extension=.js" ></script> 

</html>
