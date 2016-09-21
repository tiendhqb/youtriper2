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
        <title>YouTripper - Package Creation </title>
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
    <body class="pagesearch"  ng-app="YouTripper" ng-controller="PackageRegistrationController">
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
                                    <a href="" ng-click="openConfirmBox('price')"
                                       ng-class="{'done': (wizards.price && selectedWizard !== 'price'), 'selected': (selectedWizard === 'price')}">
                                        <fmt:message key="navBar.step5" bundle="${lang}"/><br/>
                                    </a>
                                </li>
                                <li>
                                    <a href=""  ng-click="openConfirmBox('booking')"
                                       ng-class="{'done': (wizards.booking && selectedWizard !== 'booking'), 'selected': (selectedWizard === 'booking')}">
                                        <fmt:message key="navBar.step4" bundle="${lang}"/><br/>
                                    </a>
                                </li>

                                <li>
                                    <form method="POST" action="<c:url value="/Provider/PreView"/>">
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
                    <div id="Category" class="content" ng-switch-when="category" ng-init="initCategory()">
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
                                                        <select class="blueInput subcateDropdown category-input" ng-model="selectSubCategory.id" name="subCategoryID" convert-to-number
                                                                ng-change="selectSubCategoryActivity(categoryData.categoryID, selectSubCategory.id)">     
                                                            <option value="0" selected> 
                                                                Choose a subcategory 
                                                            </option> 
                                                            <option ng-selected="{{subCategoryData.subCategoryID === selectSubCategory.id}}" ng-repeat="(subCategoryID, subCategoryData) in categoryData.subCategories"
                                                                    value="{{subCategoryData.subCategoryID}}">
                                                                {{subCategoryData.name}}
                                                            </option>
                                                        </select>
                                                        <div ng-show="selectSubCategory.isNotListed && categoryData.categoryID === selectedCategoryID">
                                                            <input text="" class="normalFont blueInput category-input" placeholder="Content (1 ~ 25)" maxlength="25" ng-maxlength="25"
                                                                   ng-model="selectSubCategory.content" />                                                           
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
                                                <div class="col-xs-3 radio-col suitabilityItem" ng-repeat="classifier in package.temporarySuitabiltyClassifiers">
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
                                            <h5 class="mandotory">
                                                <fmt:message key="step1.colorCode.description" bundle="${lang}"/>
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
                        <div class="tab-headers grey-section-content">
                            <ul class="clearfix">
                                <li ng-repeat="languageDescription in package.languageDescriptionList" 
                                    ng-class="{'active' : languageDescription.languageID === selectedLanguageDescription.languageID,
                                                'hideBorder' : package.languageDescriptionList[$index + 1].languageID === selectedLanguageDescription.languageID}">
                                    <span class="deleteLanguage" ng-class="{'active' :(languageDescription.languageID === selectedLanguageDescription.languageID
                                                && selectedLanguageDescription.languageID !== 40
                                                && selectedLanguageDescription.languageID !== paramLanguageID)}" ng-click="removeLanguage(selectedLanguageDescription.languageID)" ></span>
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

                                                   ng-model="selectedLanguageDescription.packageName" ng-class="{'missing':((!showMissingData && (checkisUndefined(selectedLanguageDescription.packageName))) ||
                                                               (!showMissingData && (checkMinName(selectedLanguageDescription.packageName, 10))))}" />
                                        </div>
                                        <div class="single-input">
                                            <h5 class="mandotory">
                                                <fmt:message key="step2.packDescription.description" bundle="${lang}"/>
                                                <span>*</span></h5>
                                            <span ng-show="errorList[selectedLanguageDescription.languageID].packageDesc.header === '1' && isShowError" style="color: red">  <br/> Package description header is required</span>  
                                            <span ng-show="errorList[selectedLanguageDescription.languageID].packageDesc.header === '2' && isShowError" style="color: red">  <br/> Package description header can not more than 
                                                50 characters</span>  

                                            <div ng-repeat="singleDescription in selectedLanguageDescription.description" class="multi-childInput advancedInput">
                                                <input type="text" maxlength="50" placeholder="<fmt:message key="step2.packDescription.title.placeholder" bundle="${lang}"/>" class="blueInput normalFont" 
                                                       ng-model="singleDescription.header" ng-class="{'headerMissing':(!showMissingData && (angular.isUndefined(singleDescription.header) ||
                                                                           singleDescription.header.length < 10))}"/>
                                                <span ng-show="errorList[selectedLanguageDescription.languageID].packageDesc.desc === '1' && isShowError" style="color: red">  <br/> Package description is required</span>  
                                                <span ng-show="errorList[selectedLanguageDescription.languageID].packageDesc.desc === '2' && isShowError" style="color: red">  <br/> Package description can not more than 1000
                                                    characters</span>  

                                                <textarea class="normalFont blueTextArea" type="text"  maxlength="1000"
                                                          placeholder="<fmt:message key="step2.packDescription.body.placehoder" bundle="${lang}"/>" 
                                                          ng-model="singleDescription.description" ng-class="{'descriptionMissing':(!showMissingData && (angular.isUndefined(singleDescription.description)
                                                                              || singleDescription.description.length < 200))}"></textarea>
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
                                                                            <span class="blueLabel multi-label">Amenities - {{amenitiesClassifier.amenitiesName}}</span>
                                                                            <textarea class="normalFont blueTextArea" type="text"  maxlength="500"
                                                                                      placeholder=" <fmt:message key="step2.amenities.placeholder1" bundle="${lang}"/> {{amenitiesClassifier.amenitiesName}} <fmt:message key="step2.amenities.placeholder2" bundle="${lang}"/>" 
                                                                                      ng-model="amenitiesClassifier.description" ng-class="{'missing':(((!showMissingData && (checkisUndefined(amenitiesClassifier.description)))) || (!showMissingData && (checkMinName(amenitiesClassifier.description, 100))))}"></textarea>
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

                                        <!--                                        <div id="list-location">
                                                                                    <div class="location-list" ng-class="{'pickupTypeLocation' : locationType.locationType === 'pickup',
                                                                                                'departureTypeLocation' : locationType.locationType === 'departure'}" ng-repeat="locationType in locationTypes">
                                                                                        <p>{{locationType.title}}<span ng-if="locationType.locationType === 'action'" style="color:red;">  (*)</span></p>
                                                                                        <div class="location-content row" ng-repeat="advancedAddress in selectedLanguageDescription.advancedAddress[locationType.locationType]">
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
                                                                                        <button class="btn btn-add-location" ng-click="addLocation(locationType.locationType)">{{locationType.text}}</button>
                                                                                    </div>
                                                                                </div>-->
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
                                                    <button style="margin-bottom:10px;" class="btn btn-width-blue" ng-click="editLocation($index, 'action')">Edit</button>
                                                    <button class="btn-width-orange" ng-click="deleteLocation($index, 'action')">Delete</button>
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
                                                    <button style="margin-bottom:10px;" class="btn btn-width-blue" ng-click="editLocation($index, 'departure')">Edit</button>
                                                    <button class="btn-width-orange" ng-click="deleteLocation($index, 'departure')">Delete</button>
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
                                                    <button style="margin-bottom:10px;" class="btn btn-width-blue" ng-click="editLocation($index, 'pickup')">Edit</button>
                                                    <button class="btn-width-orange" ng-click="deleteLocation($index, 'pickup')">Delete</button>
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

                        <div class="instruction-alt">
                            <div class="single-section-content">
                                <div class="single-section-container">
                                    <div class="instruction-alt-padding">
                                        Search optmization and languages
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!--TAGS AND LANGUAGE-->
                        <div class='single-section-content'>
                            <div class="single-section-container clearfix">
                                <div class='single-section-left'>
                                    <div class="single-input">
                                        <h5 class="mandotory">
                                            <fmt:message key="step2.tag.description" bundle="${lang}"/>
                                            <span>*</span></h5>
                                        <tags-input id="tagList" ng-model="selectedLanguageDescription.keywords" max-length="20" max-tags="9"
                                                    add-on-comma="false"   placeholder="<fmt:message key="step2.tag.placeholder" bundle="${lang}"/>">
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
                                                    add-on-comma="false"  placeholder="<fmt:message key="step2.language.placeholder" bundle="${lang}"/>">
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
                                                <img  src="{{package.coverImage}}" class="packageCoverImage" ng-show="package.coverImage !== null
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
                                                            <input ng-model="image.caption" placeholder="Write something for this photo ..." class="blueInput normalFont" type="text"/>
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
                        <div class="tab-headers"  id="duration-header">
                            <ul class="clearfix">
                                <li class="hourType" ng-class="{'active': package.durationType === 'hourly',
                                            'hideBorder' : package.durationType === 'daily'}">
                                    <a href="" ng-click="changeDurationType('hourly')">
                                        Hours
                                    </a>
                                    <div class="booking-icons" ng-click="changeDurationType('hourly')">
                                    </div>
                                </li>                         
                                <li class="dayType"  ng-class="{'active': package.durationType === 'daily',
                                            'hideBorder' : package.durationType === 'monthly'}">
                                    <a href=""  ng-click="changeDurationType('daily')">
                                        Days
                                    </a>
                                    <div class="booking-icons"  ng-click="changeDurationType('daily')">
                                    </div>
                                </li>                         
                                <li class="monthType"  ng-class="{'active': package.durationType === 'monthly'}">
                                    <a href="" ng-click="changeDurationType('monthly')">
                                        Weeks & Months
                                    </a>
                                    <div class="booking-icons"  ng-click="changeDurationType('monthly')">
                                    </div>
                                </li>                         
                            </ul>
                        </div>
                        <div class="tab-content">
                            <!--HOURLY CONTENT-->
                            <div id="openTab-content" data-ng-init="initCalendar()" ng-if="package.durationType === 'hourly'">
                                <!--Package Duration-->
                                <div class='single-section-content'>
                                    <div class="single-section-container clearfix">
                                        <div class='single-section-left'>
                                            <div class="single-input">
                                                <h5 class="mandotory">
                                                    <fmt:message key="step4.duration.description" bundle="${lang}"/>
                                                    <span>*</span></h5>
                                                <div class="multi-input-row">
                                                    <ul class="clearfix">
                                                        <li>
                                                            <select name="" class="blueInput normalFont normal-input" ng-model="package.durationHour" convert-to-number
                                                                    ng-class="{'missing':(!showMissingData && (package.durationMinute === null || package.durationMinute === 0)
                                                                                                && (package.durationHour === null || package.durationHour === 0))}">
                                                                <option value="0"><fmt:message key="step4.duration.hour" bundle="${lang}"/></option>
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
                                                        </li>
                                                        <li>
                                                            <select name="" class="blueInput normalFont normal-input" ng-model="package.durationMinute" convert-to-number 
                                                                    ng-class="{'missing':(!showMissingData && (package.durationMinute === null || package.durationMinute === 0)
                                                                                                && (package.durationHour === null || package.durationHour === 0))}">
                                                                <option value="0"><fmt:message key="step4.duration.minute" bundle="${lang}"/></option>
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
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="single-input">
                                                <h5>
                                                    Do you need any recovery time in between booking slots?
                                                </h5>
                                                <div class="multi-input-row">
                                                    <ul class="clearfix">
                                                        <li>
                                                            <select name="" class="blueInput" ng-model="package.restingtimeHour" convert-to-number>
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
                                                        </li> 
                                                        <li>
                                                            <select name="" class="blueInput" ng-model="package.restingtimeMinute" convert-to-number >
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
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>         
                                            <div class="single-input">
                                                <h5 class="mandotory">
                                                    <fmt:message key="step4.minimumTime.description" bundle="${lang}"/>
                                                </h5>

                                                <div class="multi-input-row">
                                                    <ul class="clearfix">
                                                        <li>
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
                                                        </li> 
                                                        <li>
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
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>     
                                        </div>
                                        <div class='single-section-instructions'>
                                            <p>                                                
                                                <fmt:message key="step4.packageTime.howto" bundle="${lang}"/>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                                <!--End Package Duration-->
                                <div class="instruction-alt">
                                    <div class="single-section-content">
                                        <div class="single-section-container">
                                            <div class="instruction-alt-padding mandatory">
                                                <fmt:message key="step4.packageTime.descriptionBookingTime" bundle="${lang}"/><span>*</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- Booking Time -->
                                <div class='single-section-content' ng-if="tempDurationType === 'hours&minutes'">
                                    <div class="single-section-container clearfix">
                                        <div class='single-section-left' ng-class="{'hasPopup' : popupServingShowing || popupServingShowingEdit}">
                                            <div class="single-input">
                                                <div class="multi-childInput">
                                                    <h5 class="mandotory"><fmt:message key="step4.serviceTime.description" bundle="${lang}"/><span>*</span></h5>    
                                                    <select name="" class="blueInput normalFont" ng-model="package.servingPeriodID"
                                                            ng-class="{'missing':(!showMissingData && package.servingPeriodID === null)}"
                                                            ng-options="period.id as period.name for (periodID, period) in providerServingPeriods">
                                                    </select>
                                                </div>
                                                <div id="serving-info" class="multi-childInput"  ng-show="!popupServingShowing && !popupServingShowingEdit && package.servingPeriodID > 0">
                                                    <ul class="row">
                                                        <li class="col-xs-6">
                                                            <p class="title">Operating name</p>
                                                            <p>{{providerServingPeriods[package.servingPeriodID].name}}</p>
                                                        </li>
                                                        <li class="col-xs-2" style="text-align: center">
                                                            <p class="title">Start time</p>
                                                            <p>{{providerServingPeriods[package.servingPeriodID].startOperationTime}}</p>
                                                        </li>
                                                        <li class="col-xs-2" style="text-align: center">
                                                            <p class="title">End time</p>
                                                            <p>{{providerServingPeriods[package.servingPeriodID].endOperationTime}}</p>
                                                        </li>
                                                        <li class="col-xs-2">
                                                            <a href="" class="btn-width-orange btn-width-blue" ng-click="editSelectedResource()">
                                                                Edit
                                                            </a>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <div class="multi-childInput" ng-if="!popupServingShowing && !popupServingShowingEdit">
                                                    <div class="row">
                                                        <div class="col-xs-4">
                                                            <button class="btn-width-orange login_gg" ng-click="openServingPopup()">
                                                                <fmt:message key="step4.serviceTime.option2" bundle="${lang}"/>
                                                            </button>
                                                        </div>
                                                    </div>
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

                                <!-- Serving time popup-->
                                <div id="blurBg" ng-if="popupServingShowing || popupServingShowingEdit"></div>
                                <div class="single-section-content popupSection darkgray-section-content" id="servingPopup"
                                     ng-show="popupServingShowing || popupServingShowingEdit">
                                    <div class="popupSectionContent">
                                        <div class="center-informBlock blur-backgroud" ng-show="addingProcessing">
                                            <div class="small-spinner" ></div>
                                        </div>
                                        <div class="single-section-container clearfix">
                                            <div class='single-section-left'>

                                                <div class="single-input" ng-show="popupServingShowing">
                                                    <div class="serving-form">
                                                        <ul class="clearfix">
                                                            <li class="serving-name">
                                                                <input type="text" class="blueInput normalFont borderDarkBlueInput" ng-model="newServing.name" ng-class="{'missing':(showMissingServingPeriod && (newServing.name === undefined || newServing.name === ''))}"
                                                                       placeholder="Give your serving period a name (max. 50 Characters)"/>
                                                            </li>
                                                            <li class="serving-date">
                                                                <input type="text" readonly ng-click="openTimeClock('openTime')" class="clock-input blueInput normalFont center-text-input"
                                                                       ng-class="{'missing':(wrongTimeServingPeriod)}"   placeholder="Start time" ng-model="newServing.startTime"/>
                                                            </li>
                                                            <li class="serving-date">
                                                                <input type="text" ng-click="openTimeClock('closeTime')" readonly class="clock-input blueInput normalFont center-text-input"
                                                                       ng-class="{'missing':(wrongTimeServingPeriod)}"  placeholder="Closing time" ng-model="newServing.endTime"/>
                                                            </li>
                                                        </ul>
                                                        <div class="popover clockpicker-popover bottom clockpicker-align-right " id ="provider-signup-clock">
                                                            <div class="clearfix">
                                                                <div class="provider-clock-input">
                                                                    <p>Hour</p>

                                                                </div>
                                                                <div class="provider-clock-input-separate">
                                                                    &nbsp;
                                                                </div>
                                                                <div class="provider-clock-input">
                                                                    <p>Minute</p>

                                                                </div>
                                                            </div>
                                                            <div class="clearfix">
                                                                <div class="provider-clock-input">
                                                                    <select ng-model="package.servingPickerHour" class="blueInput normalFont" ng-change="choosenHour()">
                                                                        <option disabled value="" selected>HH</option>
                                                                        <option value="{{hour}}" ng-repeat="hour in hourArray" >
                                                                            {{hour}}
                                                                        </option>
                                                                    </select>
                                                                </div>
                                                                <div class="provider-clock-input-separate">
                                                                    <p>:</p>
                                                                </div>
                                                                <div class="provider-clock-input">

                                                                    <select ng-model="package.servingPickMinute" id="minute-provider-signup" class="blueInput normalFont" ng-change="choosenMinute()">
                                                                        <option disabled value="" selected>mm</option>
                                                                        <option value="{{minute}}" ng-repeat="minute in minuteArray" ng-selected="providerPickMinute === minute">
                                                                            {{minute}}
                                                                        </option>
                                                                    </select>

                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="popupCtrs clearfix">
                                                        <a href="" class="closeBtn" ng-click="closeServingPopup()">X</a>
                                                        <a href="" class="saveBtn" ng-click="insertNewServing()">Save this new TripSource™</a>
                                                    </div>
                                                </div>
                                                <div class="single-input" ng-show="popupServingShowingEdit">
                                                    <div class="serving-form">
                                                        <ul class="clearfix">
                                                            <li class="serving-name">
                                                                <input type="text" class="blueInput normalFont" ng-model="editResource.name"  
                                                                       ng-class="{'missing':(showMissingServingPeriod &&
                                                                                                   (editSelectedResourceTimeTempName === undefined || editSelectedResourceTimeTempName === ''))}"
                                                                       placeholder="Give your serving period a name (max. 50 Characters)"/>
                                                            </li>
                                                            <li class="serving-date">
                                                                <input type="text" readonly ng-click="openTimeClockEdit('openTime')"
                                                                       class="clock-input blueInput normalFont center-text-input"
                                                                       ng-class="{'missing':(wrongTimeServingPeriod)}" placeholder="Start time" 
                                                                       ng-model="editResource.startTime"/>
                                                            </li>
                                                            <li class="serving-date">
                                                                <input type="text" ng-click="openTimeClockEdit('closeTime')" readonly 
                                                                       class="clock-input blueInput normalFont center-text-input"
                                                                       ng-class="{'missing':(wrongTimeServingPeriod)}"  placeholder="Closing time" ng-model="editResource.endTime"/>
                                                            </li>
                                                        </ul>
                                                        <div class="popover clockpicker-popover bottom clockpicker-align-right " id ="provider-signup-clock">
                                                            <div class="clearfix">
                                                                <div class="provider-clock-input">
                                                                    <p>Hour</p>

                                                                </div>
                                                                <div class="provider-clock-input-separate">
                                                                    &nbsp;
                                                                </div>
                                                                <div class="provider-clock-input">
                                                                    <p>Minute</p>

                                                                </div>
                                                            </div>
                                                            <div class="clearfix">
                                                                <div class="provider-clock-input">
                                                                    <select ng-model="package.servingPickerHour" class="blueInput normalFont" ng-change="choosenHourEdit()">
                                                                        <option disabled value="" selected>HH</option>
                                                                        <option value="{{hour}}" ng-repeat="hour in hourArray" >
                                                                            {{hour}}
                                                                        </option>
                                                                    </select>
                                                                </div>
                                                                <div class="provider-clock-input-separate">
                                                                    <p>:</p>
                                                                </div>
                                                                <div class="provider-clock-input">

                                                                    <select ng-model="package.servingPickMinute" id="minute-provider-signup" class="blueInput normalFont" ng-change="choosenMinuteEdit()">
                                                                        <option disabled value="" selected>mm</option>
                                                                        <option value="{{minute}}" ng-repeat="minute in minuteArray">
                                                                            {{minute}}
                                                                        </option>
                                                                    </select>

                                                                </div>
                                                            </div>
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
                                <!-- End serving popup -->
                                <div class="single-section-content same-content">
                                    <div class="single-section-container clearfix">
                                        <div class='single-section-left'>
                                            <div class="single-input">
                                                <div class="multi-childInput">
                                                    <h5 class="mandotory">
                                                        In which intervals do you offer bookable time slots to customers?
                                                        <span>*</span>
                                                    </h5>

                                                    <div class="selection-row">
                                                        <ul class="clearfix">
                                                            <li class="selection">
                                                                <a href="" class="linkBtn hrefCheckBox" ng-click="showChangeScheduleBox(true)"
                                                                   ng-class="{'active': package.isFreeBooking}">Choose minute slots</a>
                                                            </li>
                                                            <li class="text">
                                                                Or
                                                            </li>
                                                            <li class="selection">
                                                                <a href="" class="linkBtn hrefCheckBox" ng-click="showChangeScheduleBox(false)"
                                                                   ng-class="{'active': !package.isFreeBooking,'disabled': (package.durationHour === 0)}">Set up schedule</a>

                                                            </li>
                                                        </ul>
                                                    </div>

                                                </div>                                          
                                            </div>
                                            <div class="single-input" ng-if="package.isFreeBooking">
                                                <div class='multi-childInput'>
                                                    <div class='row'>
                                                        <div class="col-xs-12" ng-if="package.isFreeBooking">
                                                            <div class="filter-row row">
                                                                <div class="col-xs-2 radio-col">
                                                                    <input type="radio" name="" value="10" ng-model="package.freeInterval"/>
                                                                    <a href="" ng-click=""><fmt:message key="step4.frequency.10min" bundle="${lang}"/></a>
                                                                </div>
                                                                <div class="col-xs-2 radio-col">
                                                                    <input type="radio" name="" value="15"  ng-model="package.freeInterval"/>
                                                                    <a href="" ng-click=""><fmt:message key="step4.frequency.15min" bundle="${lang}"/></a>
                                                                </div>
                                                                <div class="col-xs-2 radio-col">
                                                                    <input type="radio" name="" value="30"  ng-model="package.freeInterval"/>
                                                                    <a href="" ng-click=""><fmt:message key="step4.frequency.30min" bundle="${lang}"/></a>
                                                                </div>
                                                                <div class="col-xs-6 radio-col">
                                                                    <input type="radio" name="" value="-1"  ng-model="package.freeInterval"/>
                                                                    <a href="" ng-click="">Package duration + Resting time</a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class='multi-childInput'>
                                                    <h5 class="mandotory">How many bookings can you accept from youtripper.com?<span>*</span></h5>
                                                    <div class="normal-input">
                                                        <div class="input-with-backSub">
                                                            <input class="blueInput normalFont center-text-input" placeholder="<fmt:message key="step4.maximumPack.number" bundle="${lang}"/>"
                                                                   ng-model="package.maxQuota"  ng-class="{'hasError' : (!showMissingData && (isNaN(package.maxQuota) || package.maxQuota <= 0))}"
                                                                   numbers-only/>
                                                            <span class="backSub">
                                                                per day
                                                            </span>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class='multi-childInput'>
                                                    <h5 class="mandotory">
                                                        What is the serving limit within one package duration? 
                                                        <span>*</span>
                                                    </h5>
                                                    <div class="normal-input">
                                                        <div class="input-with-backSub">
                                                            <input class="blueInput normalFont center-text-input" placeholder="<fmt:message key="step4.maximumPack.number" bundle="${lang}"/>"
                                                                   ng-model="package.noLimit"  ng-class="{'hasError' : (!showMissingData && (isNaN(package.noLimit) || package.noLimit <= 0))}"
                                                                   numbers-only range-min="1"/>
                                                            <span class="backSub">
                                                                packages per (hours) (minutes)
                                                            </span>
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>

                                        </div>
                                        <div class='single-section-instructions' ng-show="package.isFreeBooking">
                                            <p>
                                                <span class="title">Allow customers to choose their slot</span><br/>
                                                Customers can freely choose bookings based on 10, 15 or 30 minute intervals in your serving period. 
                                                The Number of bookings are limited by the maximum capacity of your resources or your quota. 
                                                This is most suited to providers with personalized services or flexible resource units such as Spas. 
                                                <br>
                                                <br>
                                                <span class="title">  Package duration + resting time as booking interval</span><br/>
                                                If you have a limited number of resources you can choose this option to spread out bookings more effectively throughout the day. 
                                            </p>
                                        </div>
                                    </div>
                                </div>

                                <!--TIME SCHEDULE-->
                                <div class="single-section-content same-content" ng-if="!package.isFreeBooking" data-ng-init="initTimeScheduleTable(false)">
                                    <div class="single-section-container clearfix">
                                        <div class="single-section-middle">
                                            <div class="single-input">
                                                <div class="multi-childInput">
                                                    <h5 class="mandotory">
                                                        In which intervals do you offer bookable time slots to customers?
                                                        <span>*</span>
                                                    </h5>
                                                    <p>
                                                        Click  on the <span class="grey-plus-btn inline-btn"></span> to add a time slot in that hour. You can add minute values if necessary but duration is automatically calculated.
                                                        <br/>
                                                        You must assign a maximum booking quota from youtripper.com, dedicated to each slot.
                                                    </p>
                                                </div>

                                                <div class="multi-childInput">
                                                    <div id="time-schedule-tb">
                                                        <div class="tb-container">
                                                            <ul  class="time-col">
                                                            </ul>
                                                            <ul class="time-header clearfix">

                                                            </ul>

                                                            <div class="time-slot-form" id="time-addingSchedule-form">
                                                                <ul class="inputs clearfix">
                                                                    <li class="time-text">
                                                                        {{addingForm.hours}} : 
                                                                    </li>
                                                                    <li class="time-select">
                                                                        <select name="" class="blueInput" ng-model="addingForm.minutes" convert-to-number>
                                                                            <option value="0">00</option>
                                                                            <option value="5">05</option>
                                                                            <option value="10">10</option>
                                                                            <option value="15">15</option>
                                                                            <option value="20">20</option>
                                                                            <option value="25">25</option>
                                                                            <option value="30">30</option>
                                                                            <option value="35">35</option>
                                                                            <option value="40">40</option>
                                                                            <option value="45">45</option>
                                                                            <option value="50">50</option>
                                                                            <option value="55">55</option>
                                                                        </select>
                                                                    </li>
                                                                    <li class="quota">
                                                                        <input type="number" class="blueInput center-text-input" placeholder="Enter Quota"
                                                                               ng-model="addingForm.quota"/>
                                                                    </li>
                                                                </ul>
                                                                <ul class="ctrls clearfix">
                                                                    <li style="width: 100%">
                                                                        <a href="" ng-click="addNewSpecificTimeSlot()" class="btn-width-orange btn-width-blue">Save</a>
                                                                    </li>
                                                                </ul>
                                                                <a href="" ng-click="closeAddingForm()" class="close-btn">
                                                                </a>
                                                            </div>

                                                            <ul class="specific-slots">
                                                            </ul>

                                                            <div class="time-slot-form" id="time-editSchedule-form">
                                                                <ul class="inputs clearfix">
                                                                    <li class="time-text">
                                                                        {{editingForm.hours}} : 
                                                                    </li>
                                                                    <li class="time-select">
                                                                        <select name="" class="blueInput" ng-model="editingForm.minutes" convert-to-number>
                                                                            <option value="0">00</option>
                                                                            <option value="5">05</option>
                                                                            <option value="10">10</option>
                                                                            <option value="15">15</option>
                                                                            <option value="20">20</option>
                                                                            <option value="25">25</option>
                                                                            <option value="30">30</option>
                                                                            <option value="35">35</option>
                                                                            <option value="40">40</option>
                                                                            <option value="45">45</option>
                                                                            <option value="50">50</option>
                                                                            <option value="55">55</option>
                                                                        </select>
                                                                    </li>
                                                                    <li class="quota">
                                                                        <input type="number" class="blueInput center-text-input" placeholder="Enter Quota"
                                                                               ng-model="editingForm.quota"/>
                                                                    </li>
                                                                </ul>
                                                                <ul class="ctrls clearfix">
                                                                    <li>
                                                                        <a href="" ng-click="deleteSpecificSlot(editingForm.slotIndex)" class="btn-width-orange">Delete</a>
                                                                    </li>
                                                                    <li>
                                                                        <a href="" ng-click="editSpecificSlot(editingForm.slotIndex)" class="btn-width-orange btn-width-blue">Save</a>
                                                                    </li>
                                                                </ul>
                                                                <a href="" ng-click="closeTimeEditingForm()" class="close-btn">
                                                                </a>
                                                            </div>
                                                        </div>

                                                        <a href="" ng-click="prvTimeCol()" class="tb-ctrl prv-ctrl"></a>
                                                        <a href="" ng-click="nxtTimeCol()" class="tb-ctrl nxt-ctrl"></a>
                                                    </div>
                                                </div>

                                                <div class="multi-childInput">
                                                    <div class="remind-text" style="padding-left: 30px">
                                                        Total Quota per day: <span class="remind-no">{{package.tempSpecificTimeSlots.length}}</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--END TIME SCHEDULE-->


                                <!-- End Booking Time -->
                                <div class="instruction-alt hasAltLink mandatory">
                                    <div class="single-section-content">
                                        <div class="single-section-container">
                                            <div class="instruction-alt-padding">
                                                Running Schedule - Set up package availability.<span>*</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- Package availability Time -->
                                <div class='single-section-content'>
                                    <div class="single-section-container clearfix">
                                        <div class="single-section-middle">
                                            <div class="single-input">
                                                <div class="multi-childInput">
                                                    <h5 class="mandotory">Starting from the <span>red date</span> click on a date below to choose the first day to serve your activity. <span>*</span></h5>
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
                                                <div class="multi-childInput">
                                                    <p>Your package will be available on: <span style="color: #4CBDC9">{{package.startDate}}</span></p>
                                                </div>
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
                                                        <input type="checkbox" name="" ng-model="package.isExceptSunday" 
                                                               ng-true-value="true" ng-false-value="false" ng-change="isNonDaysChanged()"/>
                                                        <a href="" ng-click=""><fmt:message key="step4.except.sunday" bundle="${lang}"/></a>
                                                    </div>
                                                    <div class="col-xs-2 radio-col">
                                                        <input type="checkbox" name="" ng-model="package.isExceptMonday" 
                                                               ng-true-value="true" ng-false-value="false" />
                                                        <a href="" ng-click=""><fmt:message key="step4.except.mon" bundle="${lang}"/></a>
                                                    </div>
                                                    <div class="col-xs-2 radio-col">
                                                        <input type="checkbox" name="" ng-model="package.isExceptTuesday" 
                                                               ng-true-value="true" ng-false-value="false" />
                                                        <a href="" ng-click=""><fmt:message key="step4.except.tue" bundle="${lang}"/></a>
                                                    </div>
                                                    <div class="col-xs-2 radio-col">
                                                        <input type="checkbox" name="" ng-model="package.isExceptWednesday" 
                                                               ng-true-value="true" ng-false-value="false"/>
                                                        <a href="" ng-click=""><fmt:message key="step4.except.wed" bundle="${lang}"/></a>
                                                    </div>
                                                    <div class="col-xs-2 radio-col">
                                                        <input type="checkbox" name="" ng-model="package.isExceptThursday" 
                                                               ng-true-value="true" ng-false-value="false" />
                                                        <a href="" ng-click=""><fmt:message key="step4.except.thu" bundle="${lang}"/></a>
                                                    </div>
                                                    <div class="col-xs-2 radio-col">
                                                        <input type="checkbox" name="" ng-model="package.isExceptFriday" 
                                                               ng-true-value="true" ng-false-value="false" />
                                                        <a href="" ng-click=""><fmt:message key="step4.except.fri" bundle="${lang}"/></a>
                                                    </div>
                                                    <div class="col-xs-2 radio-col">
                                                        <input type="checkbox" name="" ng-model="package.isExceptSaturday" 
                                                               ng-true-value="true" ng-false-value="false" />
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
                                <!-- End Package availability Time -->
                            </div>
                            <!--END HOURLY CONTENT-->

                            <!--DAILY CONTENT-->
                            <div id="dailyTab-content" ng-if="package.durationType === 'daily'">

                                <!--DURATION TIME-->
                                <div class='single-section-content durationSection'>
                                    <div class="single-section-container clearfix">
                                        <div class='single-section-left'>
                                            <div class="single-input">
                                                <h5 class="mandotory">
                                                    <fmt:message key="step4.duration.description" bundle="${lang}"/>
                                                    <span>*</span>
                                                </h5>
                                                <div class="normal-input">
                                                    <div class="input-with-backSub">
                                                        <select name="" class="blueInput normalFont" ng-model="package.durationDay" convert-to-number 
                                                                ng-class="{'missing':(!showMissingData && (package.durationDay === null || package.durationDay === 0))}">
                                                            <option value="0" disabled>Select</option>
                                                            <option value="1">1 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                            <option value="2">2 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                            <option value="3">3 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                            <option value="4">4 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                            <option value="5">5 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                            <option value="6">6 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                            <option value="7">7 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                        </select>
                                                        <span class="backSub">
                                                            Day(s)
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="single-input">
                                                <h5 class="mandotory">
                                                    <fmt:message key="step4.minimumTime.description" bundle="${lang}"/>
                                                    <span>*</span>
                                                </h5> 
                                                <div class="normal-input">
                                                    <div class="input-with-backSub">
                                                        <select name="" class="blueInput normalFont" ng-model="package.readyBookingDays" convert-to-number>
                                                            <option value="0" disabled>Select</option>
                                                            <option value="1">1 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                            <option value="2">2 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                            <option value="3">3 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                            <option value="4">4 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                            <option value="5">5 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                            <option value="6">6 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                            <option value="7">7 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                        </select>
                                                        <span class="backSub">
                                                            Day(s)
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--END DURATION TIME-->

                                <!--BOOKING ENGINE-->
                                <div class="instruction-alt hasAltLink">
                                    <div class="single-section-content">
                                        <div class="single-section-container">
                                            <!--                                        <div class="instruction-alt-padding">
                                                                                        Discover the power of your TripSource™
                                                                                    </div>-->
                                            <div class="instruction-alt-padding mandatory">
                                                Booking Engine -  Set up your booking time and quota.<span>*</span>
                                            </div>
                                            <!--                                        <a href="" ng-click="toogleResourceInstruction()">
                                                                                        Find out more
                                                                                    </a>-->
                                        </div>
                                    </div>
                                </div>

                                <div class='single-section-content'>
                                    <div class="single-section-container clearfix">
                                        <div class='single-section-left'>
                                            <div class="single-input">
                                                <h5 class="mandotory">Select the first day to serve your activity.
                                                    Choose starting from the <span>red date</span>.<span>*</span>
                                                </h5>
                                                <div class="label-input clearfix">
                                                    <div class="label">
                                                        Your package will be available on:
                                                    </div>
                                                    <div class="input normalInput">
                                                        <input type="text" class="blueInput normalFont center-text-input"  readonly="readonly"
                                                               ng-model="package.startDate" ng-click="showSmallAvailableCalendar($event, - 1, 'startDate')" placeholder="Start Date"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="single-input">
                                                <h5 class="mandotory">This activity runs and is available for booking:<span>*</span>
                                                </h5>
                                                <div class="selection-row">
                                                    <ul class="clearfix">
                                                        <li class="selection">
                                                            <a href="" class="linkBtn hrefCheckBox" ng-click="isWorkingEveryday()"
                                                               ng-class="{'active' : package.isWorkingEveryday}">Everyday</a>
                                                        </li>
                                                        <li class="text">
                                                            Or
                                                        </li>
                                                        <li class="selection">
                                                            <a href=""  class="linkBtn hrefCheckBox" ng-click="isMonthlyDays()"
                                                               ng-class="{'active' : package.isMonthlyDays}">Schedule</a>
                                                        </li>
                                                        <li class="text">
                                                            Or
                                                        </li>
                                                        <li class="selection">
                                                            <a href=""  class="linkBtn hrefCheckBox" ng-click="isSpecificSlots()"
                                                               ng-class="{'active' : package.isSpecificSlots}">Custom dates</a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>


                                        <div class="single-section-instructions" style="margin-top: 30px;">
                                            <p>
                                                You can customize your monthly schedule with sequential availability.
                                                <br/><br/>
                                                You can check your package operation on the calendar. Active days are outlined in orange.
                                            </p>
                                        </div>

                                    </div>
                                </div>

                                <!--EVERY DAY-->
                                <div class="single-section-content same-content" ng-if="package.isWorkingEveryday">
                                    <div class="single-section-container clearfix">
                                        <div class="single-section-left">


                                            <div class="single-input">
                                                <div class="multi-childInput">
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
                                                <div class="multi-childInput">
                                                    <h5 class="mandotory">How many bookings can you accept from youtripper.com?<span>*</span></h5>
                                                    <div class="normal-input">
                                                        <div class="input-with-backSub">
                                                            <input class="blueInput normalFont center-text-input" placeholder="<fmt:message key="step4.maximumPack.number" bundle="${lang}"/>"
                                                                   ng-model="package.maxQuota"  ng-class="{'hasError' : (!showMissingData && (isNaN(package.maxQuota) || package.maxQuota <= 0))}"
                                                                   numbers-only/>
                                                            <span class="backSub">
                                                                per day
                                                            </span>
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--END EVERYDAY-->

                                <!--SCHEDULE SLOTS-->
                                <div class="single-section-content same-content" ng-if="package.isMonthlyDays" data-ng-init="initCustomisedWeekSlot(false)">
                                    <div class="single-section-container clearfix">
                                        <div class="single-section-middle">
                                            <div class="single-input">
                                                <div class="multi-childInput">
                                                    <h5 class="mandotory">How many booking slots do you want to create per month?<span>*</span></h5>
                                                    <p>
                                                        Click on the <span class="grey-plus-btn inline-btn"></span> to add a time slot in that week. You can define the booking day but duration is automatically calculated.
                                                        <br/>
                                                        You must assign a maximum booking quota from youtripper.com, dedicated to each slot.
                                                    </p>
                                                </div>
                                                <div class="multi-childInput">
                                                    <div id="schedule-table">
                                                        <div class="bg">
                                                            <ul class="clearfix">
                                                                <li class="week">
                                                                    <ul class="clearfix">
                                                                        <li class="day">

                                                                        </li>
                                                                        <li class="day">

                                                                        </li>
                                                                        <li class="day">

                                                                        </li>
                                                                        <li class="day">

                                                                        </li>
                                                                        <li class="day">

                                                                        </li>
                                                                        <li class="day">

                                                                        </li>
                                                                        <li class="day">

                                                                        </li>
                                                                    </ul>
                                                                </li>
                                                                <li class="week">
                                                                    <ul class="clearfix">
                                                                        <li class="day">

                                                                        </li>
                                                                        <li class="day">

                                                                        </li>
                                                                        <li class="day">

                                                                        </li>
                                                                        <li class="day">

                                                                        </li>
                                                                        <li class="day">

                                                                        </li>
                                                                        <li class="day">

                                                                        </li>
                                                                        <li class="day">

                                                                        </li>
                                                                    </ul>
                                                                </li>
                                                                <li class="week">
                                                                    <ul class="clearfix">
                                                                        <li class="day">

                                                                        </li>
                                                                        <li class="day">

                                                                        </li>
                                                                        <li class="day">

                                                                        </li>
                                                                        <li class="day">

                                                                        </li>
                                                                        <li class="day">

                                                                        </li>
                                                                        <li class="day">

                                                                        </li>
                                                                        <li class="day">

                                                                        </li>
                                                                    </ul>
                                                                </li>
                                                                <li class="week">
                                                                    <ul class="clearfix">
                                                                        <li class="day">

                                                                        </li>
                                                                        <li class="day">

                                                                        </li>
                                                                        <li class="day">

                                                                        </li>
                                                                        <li class="day">

                                                                        </li>
                                                                        <li class="day">

                                                                        </li>
                                                                        <li class="day">

                                                                        </li>
                                                                        <li class="day">

                                                                        </li>
                                                                    </ul>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                        <div class="week-header">
                                                            <ul class="clearfix">
                                                                <li>
                                                                    WEEK 1 <span class="grey-plus-btn inline-btn" ng-click="openAddingWeekForm(1)"></span>
                                                                </li>
                                                                <li>
                                                                    WEEK 2 <span class="grey-plus-btn inline-btn"  ng-click="openAddingWeekForm(2)"></span>
                                                                </li>
                                                                <li>
                                                                    WEEK 3 <span class="grey-plus-btn inline-btn" ng-click="openAddingWeekForm(3)"></span>
                                                                </li>
                                                                <li>
                                                                    WEEK 4 <span class="grey-plus-btn inline-btn" ng-click="openAddingWeekForm(4)"></span>
                                                                </li>
                                                            </ul>
                                                            <div class="monthSchedule-form" id="adding-week-form">
                                                                <ul class="inputs clearfix">
                                                                    <li>
                                                                        <select name="" class="blueInput" ng-model="addingWeekForm.dayNo" convert-to-number>
                                                                            <option value="0">Sunday</option>
                                                                            <option value="1">Monday</option>
                                                                            <option value="2">Tuesday</option>
                                                                            <option value="3">Wednesday</option>
                                                                            <option value="4">Thursday</option>
                                                                            <option value="5">Friday</option>
                                                                            <option value="6">Saturday</option>
                                                                        </select>    
                                                                    </li>
                                                                    <li>
                                                                        <input type="number" class="blueInput center-text-input" placeholder="Enter Quota"
                                                                               ng-model="addingWeekForm.maxQuota"/>
                                                                    </li>
                                                                </ul>
                                                                <ul class="ctrs clearfix">
                                                                    <!--                                                                    <li>
                                                                                                                                            <a href="" class="btn-width-orange" ng-click="">Cancel</a>
                                                                                                                                        </li>-->
                                                                    <li>
                                                                        <a href="" class="btn-width-orange btn-width-blue" ng-click="saveNewWeekSlot()">Save</a>
                                                                    </li>
                                                                </ul>
                                                                <a href="" class="close-btn" ng-click="closeAddingWeekForm()"></a>
                                                            </div>
                                                        </div>
                                                        <div class="day-header clearfix">
                                                            <ul class="clearfix">
                                                                <li>
                                                                    Sun
                                                                </li>
                                                                <li>
                                                                    Mon
                                                                </li>
                                                                <li>
                                                                    Tue
                                                                </li>
                                                                <li>
                                                                    Wed
                                                                </li>
                                                                <li>
                                                                    Thu
                                                                </li>
                                                                <li>
                                                                    Fri
                                                                </li>
                                                                <li>
                                                                    Sat
                                                                </li>
                                                            </ul>
                                                            <ul class="clearfix">
                                                                <li>
                                                                    Sun
                                                                </li>
                                                                <li>
                                                                    Mon
                                                                </li>
                                                                <li>
                                                                    Tue
                                                                </li>
                                                                <li>
                                                                    Wed
                                                                </li>
                                                                <li>
                                                                    Thu
                                                                </li>
                                                                <li>
                                                                    Fri
                                                                </li>
                                                                <li>
                                                                    Sat
                                                                </li>
                                                            </ul>

                                                            <ul class="clearfix">
                                                                <li>
                                                                    Sun
                                                                </li>
                                                                <li>
                                                                    Mon
                                                                </li>
                                                                <li>
                                                                    Tue
                                                                </li>
                                                                <li>
                                                                    Wed
                                                                </li>
                                                                <li>
                                                                    Thu
                                                                </li>
                                                                <li>
                                                                    Fri
                                                                </li>
                                                                <li>
                                                                    Sat
                                                                </li>
                                                            </ul>
                                                            <ul class="clearfix">
                                                                <li>
                                                                    Sun
                                                                </li>
                                                                <li>
                                                                    Mon
                                                                </li>
                                                                <li>
                                                                    Tue
                                                                </li>
                                                                <li>
                                                                    Wed
                                                                </li>
                                                                <li>
                                                                    Thu
                                                                </li>
                                                                <li>
                                                                    Fri
                                                                </li>
                                                                <li>
                                                                    Sat
                                                                </li>                                                        
                                                            </ul>
                                                        </div>
                                                        <div class="specific-slots-container">
                                                            <div class="specific-slots">

                                                            </div>
                                                            <div class="monthSchedule-form" id="editing-week-form">
                                                                <ul class="inputs clearfix">
                                                                    <li>
                                                                        <select name="" class="blueInput" ng-model="editingWeekForm.dayNo" convert-to-number>
                                                                            <option value="0">Sunday</option>
                                                                            <option value="1">Monday</option>
                                                                            <option value="2">Tuesday</option>
                                                                            <option value="3">Wednesday</option>
                                                                            <option value="4">Thursday</option>
                                                                            <option value="5">Friday</option>
                                                                            <option value="6">Saturday</option>
                                                                        </select>    
                                                                    </li>
                                                                    <li>
                                                                        <input type="number" class="blueInput center-text-input" placeholder="Enter Quota"
                                                                               ng-model="editingWeekForm.maxQuota"/>
                                                                    </li>
                                                                </ul>
                                                                <ul class="ctrs clearfix">
                                                                    <li>
                                                                        <a href="" class="btn-width-orange" ng-click="deleteWeekSlot(editingWeekForm.slotIndex)">Delete</a>
                                                                    </li>
                                                                    <li>
                                                                        <a href="" class="btn-width-orange btn-width-blue" ng-click="editWeekSlot(editingWeekForm.slotIndex)">Save</a>
                                                                    </li>
                                                                </ul>
                                                                <a href="" class="close-btn" ng-click="closeEditingWeekForm()"></a>
                                                            </div>

                                                            <!--                                                                <div class="slot-row">
                                                                                                                                <a class="single-slot" href="">
                                                                                                                                    Quota<br/>
                                                                                                                                    02
                                                                                                                                </a>
                                                                                                                            </div>
                                                                                                                            <div class="slot-row">
                                                                                                                                <a class="single-slot" href="">
                                                                                                                                    Quota<br/>
                                                                                                                                    02
                                                                                                                                </a>
                                                                                                                            </div>
                                                                                                                            <div class="slot-row">
                                                                                                                                <a class="single-slot" href="">
                                                                                                                                    Quota<br/>
                                                                                                                                    02
                                                                                                                                </a>
                                                                                                                            </div>
                                                                                                                            <div class="slot-row">
                                                                                                                                <a class="single-slot" href="">
                                                                                                                                    Quota<br/>
                                                                                                                                    02
                                                                                                                                </a>
                                                                                                                            </div>-->

                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="multi-childInput">
                                                    <div class="remind-text">
                                                        Total Quota per month: <span class="remind-no">{{package.tempCustomiseWeekSlots.length}}</span>
                                                    </div>
                                                </div>

                                                <div class="multi-childInput">
                                                    <h5>
                                                        Repeat this schedule except on the following months:
                                                    </h5>
                                                    <div class="filter-row row">
                                                        <div class="col-xs-1 radio-col">
                                                            <input type="checkbox" name="dasfdsf" ng-model="package.isExceptOnJan"
                                                                   ng-true-value="true" ng-false-value="false"/>
                                                            <a href="" ng-click="">January</a>
                                                        </div>
                                                        <div class="col-xs-1 radio-col">
                                                            <input type="checkbox" name="dasfdsf" ng-model="package.isExceptOnFeb"
                                                                   ng-true-value="true" ng-false-value="false"/>
                                                            <a href="" ng-click="">February</a>
                                                        </div>
                                                        <div class="col-xs-1 radio-col">
                                                            <input type="checkbox" name="dasfdsf" ng-model="package.isExceptOnMar"
                                                                   ng-true-value="true" ng-false-value="false"/>
                                                            <a href="" ng-click="">March</a>
                                                        </div>
                                                        <div class="col-xs-1 radio-col">
                                                            <input type="checkbox" name="dasfdsf" ng-model="package.isExceptOnApr"
                                                                   ng-true-value="true" ng-false-value="false"/>
                                                            <a href="" ng-click="">April</a>
                                                        </div>
                                                        <div class="col-xs-1 radio-col">
                                                            <input type="checkbox" name="dasfdsf" ng-model="package.isExceptOnMay"
                                                                   ng-true-value="true" ng-false-value="false"/>
                                                            <a href="" ng-click="">May</a>
                                                        </div>
                                                        <div class="col-xs-1 radio-col">
                                                            <input type="checkbox" name="dasfdsf" ng-model="package.isExceptOnJun"
                                                                   ng-true-value="true" ng-false-value="false"/>
                                                            <a href="" ng-click="">June</a>
                                                        </div>
                                                        <div class="col-xs-1 radio-col">
                                                            <input type="checkbox" name="dasfdsf" ng-model="package.isExceptOnJul"
                                                                   ng-true-value="true" ng-false-value="false"/>
                                                            <a href="" ng-click="">July</a>
                                                        </div>
                                                        <div class="col-xs-1 radio-col">
                                                            <input type="checkbox" name="dasfdsf" ng-model="package.isExceptOnAug"
                                                                   ng-true-value="true" ng-false-value="false"/>
                                                            <a href="" ng-click="">August</a>
                                                        </div>
                                                        <div class="col-xs-1 radio-col">
                                                            <input type="checkbox" name="dasfdsf" ng-model="package.isExceptOnSep"
                                                                   ng-true-value="true" ng-false-value="false"/>
                                                            <a href="" ng-click="">September</a>
                                                        </div>
                                                        <div class="col-xs-1 radio-col">
                                                            <input type="checkbox" name="dasfdsf" ng-model="package.isExceptOnOct"
                                                                   ng-true-value="true" ng-false-value="false"/>
                                                            <a href="" ng-click="">October</a>
                                                        </div>
                                                        <div class="col-xs-1 radio-col">
                                                            <input type="checkbox" name="dasfdsf" ng-model="package.isExceptOnNov"
                                                                   ng-true-value="true" ng-false-value="false"/>
                                                            <a href="" ng-click="">November</a>
                                                        </div>
                                                        <div class="col-xs-1 radio-col">
                                                            <input type="checkbox" name="dasfdsf" ng-model="package.isExceptOnDec"
                                                                   ng-true-value="true" ng-false-value="false"/>
                                                            <a href="" ng-click="">December</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--END SCHEDULE-->

                                <!--SPECIFIC SLOTS-->
                                <div class="single-section-content same-content" ng-if="package.isSpecificSlots">
                                    <div class="single-section-container clearfix">
                                        <div class="single-section-left">
                                            <h5>Enter any date within 12 months on which you want your customers to book this package.</h5>
                                            <div class="single-input">
                                                <p>
                                                    Start from your first day and enter your quota number per slot. 
                                                    <br/>
                                                    Our team will send you renewal reminders every 6 months.
                                                </p>
                                            </div>

                                            <div class="single-input">
                                                <div class="multi-childInput">
                                                    <div class="label-input arranged">
                                                        <div class="row">
                                                            <div class="col-xs-8">
                                                                <div class="label">
                                                                    <h5 class="mandatory">How many booking slots do you want to create?<span>*</span></h5>
                                                                </div>
                                                            </div>
                                                            <div class="col-xs-4">
                                                                <div class="input normalInput">
                                                                    <div class="inputAutoNumber">
                                                                        <a href="" class="minusBtn" ng-class="{'active' :(package.tempSpecificDateSlots.length > 1)}" ng-click="descreaseDateSlot()" ></a>
                                                                        <input disabled type="text" class="blueInput normalFont" 
                                                                               value="{{package.tempSpecificDateSlots.length}} Slot(s)" placeholder="No. Slots"/>
                                                                        <a href="" class="plusBtn active" ng-click="increaseDateSlot()"/></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="multi-childInput" ng-if="package.tempSpecificDateSlots.length > 1">
                                                    <div class="row">
                                                        <div class="col-xs-4">
                                                            <a href="" class="linkBtn hrefCheckBox" ng-class="{'active':isUsingSameQuota === true}" 
                                                               ng-click="isUsingSameQuota === false ? setUsingSameQuota(true):setUsingSameQuota(false)">Use the same Quota</a>
                                                        </div>
                                                        <div class="input normalInput col-xs-3" ng-if="isUsingSameQuota">
                                                            <input type="text" class="blueInput normalFont center-text-input"
                                                                   ng-model="sameQuota.value" placeholder="Enter Quota"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="multi-childInput">
                                                    <div class="slots-row">
                                                        <ul class="clearfix">
                                                            <li ng-repeat=" x in package.tempSpecificDateSlots">
                                                                <div class="specific-slot">
                                                                    <div class="slot-date">
                                                                        <span class="no-slot">{{$index + 1}}</span>
                                                                        <a href="" ng-click="showSmallAvailableCalendar($event, $index, 'dateSlot')">{{x.dateStr === "" ? "Enter date":x.dateStr}}</a>
                                                                        <span class="close-btn" ng-click="package.tempSpecificDateSlots.splice($index, 1)">
                                                                        </span>
                                                                    </div>
                                                                    <div class="slot-quota" ng-class="{'disabled':isUsingSameQuota === true}">
                                                                        <input class="" type="text" ng-model="x.maxQuota"  placeholder="Enter Quota" 
                                                                               numbers-only  range-min="1"/>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--END SPECIFIC SLOTS-->

                                <div id="availableCalendar">
                                    <div class="smallCalendar">
                                        <div class="calendarYearMonth">
                                            <a href="" class="backCalendar" ng-click="backSmallAvailableMonth()"></a>
                                            <h4>{{MONTHS_OF_YEAR[inputDate.getMonth()]}} {{inputDate.getFullYear()}}</h4>
                                            <a href="" class="nextCalendar" ng-click="nexSmalltAvailableMonth()"></a>
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
                                <!--SAVE BUTTON-->
                                <div class="single-section-content same-content">
                                    <div class="single-section-container clearfix">
                                        <div class="single-section-left">
                                            <div class="single-input">
                                                <button class="btn-width-orange next-btn" ng-click="openConfirmBox('finish')"><fmt:message key="saveBtn" bundle="${lang}"/></button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--END SAVE BUTTON-->

                                <!--END BOOKING ENGINE-->

                            </div>
                            <!--END DAILY CONTENT-->

                            <!--MONTHLY CONTENT-->
                            <div id="groupTab-content" ng-if="package.durationType === 'monthly'">


                                <!--DURATION TIME-->
                                <div class='single-section-content durationSection'>
                                    <div class="single-section-container clearfix">
                                        <div class='single-section-left'>
                                            <div class="single-input">
                                                <h5 class="mandotory">
                                                    <fmt:message key="step4.duration.description" bundle="${lang}"/>
                                                    <span>*</span>
                                                </h5>
                                                <div class="normal-input">
                                                    <div class="input-with-backSub">
                                                        <select name="" class="blueInput normalFont" ng-model="package.durationWeek" convert-to-number 
                                                                ng-class="{'missing':(!showMissingData && (package.durationWeek === null || package.durationWeek === 0))}">
                                                            <option value="0" disabled>Select</option>
                                                            <option value="1">1 <fmt:message key="step4.duration.week" bundle="${lang}"/></option>
                                                            <option value="2">2 <fmt:message key="step4.duration.week" bundle="${lang}"/></option>
                                                            <option value="3">3 <fmt:message key="step4.duration.week" bundle="${lang}"/></option>
                                                            <option value="4">4 <fmt:message key="step4.duration.week" bundle="${lang}"/></option>
                                                            <option value="5">5 <fmt:message key="step4.duration.week" bundle="${lang}"/></option>
                                                            <option value="6">6 <fmt:message key="step4.duration.week" bundle="${lang}"/></option>
                                                            <option value="7">7 <fmt:message key="step4.duration.week" bundle="${lang}"/></option>
                                                        </select>
                                                        <span class="backSub">
                                                            Week(s)
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="single-input">
                                                <h5 class="mandotory">
                                                    <fmt:message key="step4.minimumTime.description" bundle="${lang}"/>
                                                    <span>*</span>
                                                </h5> 
                                                <div class="multi-input-row">
                                                    <ul class="clearfix">
                                                        <li ng-if="tempReadyBookingType === 'day'">
                                                            <select name="" class="blueInput normalFont" ng-model="package.readyBookingDays" convert-to-number>
                                                                <option value="0" disabled>Select</option>
                                                                <option value="1">1 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="2">2 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="3">3 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="4">4 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="5">5 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="6">6 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="7">7 <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                            </select>
                                                        </li>
                                                        <li ng-if="tempReadyBookingType === 'week'">
                                                            <select name="" class="blueInput normalFont" ng-model="package.readyBookingWeeks" convert-to-number>
                                                                <option value="0" disabled>Select</option>
                                                                <option value="1">1 <fmt:message key="step4.duration.week" bundle="${lang}"/></option>
                                                                <option value="2">2 <fmt:message key="step4.duration.week" bundle="${lang}"/></option>
                                                                <option value="3">3 <fmt:message key="step4.duration.week" bundle="${lang}"/></option>
                                                                <option value="4">4 <fmt:message key="step4.duration.week" bundle="${lang}"/></option>
                                                            </select>
                                                        </li>
                                                        <li ng-if="tempReadyBookingType === 'month'">
                                                            <select name="" class="blueInput normalFont" ng-model="package.readyBookingMonths" convert-to-number>
                                                                <option value="0" disabled>Select</option>
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
                                                        </li>
                                                        <li>
                                                            <select name="" class="blueInput normalFont" ng-model="tempReadyBookingType">
                                                                <option value="0" disabled>Select</option>
                                                                <option value="day"> <fmt:message key="step4.duration.day" bundle="${lang}"/></option>
                                                                <option value="week"> <fmt:message key="step4.duration.week" bundle="${lang}"/></option>
                                                                <option value="month"> <fmt:message key="step4.duration.month" bundle="${lang}"/></option>
                                                            </select>
                                                        </li>
                                                    </ul>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--END DURATION TIME-->

                                <!--BOOKING ENGINE-->
                                <div class="instruction-alt hasAltLink">
                                    <div class="single-section-content">
                                        <div class="single-section-container">
                                            <!--                                        <div class="instruction-alt-padding">
                                                                                        Discover the power of your TripSource™
                                                                                    </div>-->
                                            <div class="instruction-alt-padding mandatory">
                                                Booking Engine -  Set up your booking time and quota.<span>*</span>
                                            </div>
                                            <!--                                        <a href="" ng-click="toogleResourceInstruction()">
                                                                                        Find out more
                                                                                    </a>-->
                                        </div>
                                    </div>
                                </div>

                                <div class='single-section-content'>
                                    <div class="single-section-container clearfix">
                                        <div class='single-section-left'>
                                            <div class="single-input">
                                                <h5 class="mandotory">Select the first day to serve your activity.
                                                    Choose starting from the <span>red date</span>.<span>*</span>
                                                </h5>
                                                <div class="label-input clearfix">
                                                    <div class="label">
                                                        Your package will be available on:
                                                    </div>
                                                    <div class="input normalInput">
                                                        <input type="text" class="blueInput normalFont center-text-input"  readonly="readonly"
                                                               ng-model="package.startDate" ng-click="showSmallAvailableCalendar($event, - 1, 'startDate')" placeholder="Start Date"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="single-input">
                                                <h5 class="mandotory">This activity runs and is available for booking:<span>*</span>
                                                </h5>
                                                <div class="selection-row">
                                                    <ul class="clearfix">
                                                        <li class="selection">
                                                            <a href="" class="linkBtn hrefCheckBox" ng-click="isWorkingEveryday()"
                                                               ng-class="{'active' : package.isWorkingEveryday}">Everyday</a>
                                                        </li>
                                                        <li class="text">
                                                            Or
                                                        </li>
                                                        <li class="selection">
                                                            <a href=""  class="linkBtn hrefCheckBox" ng-click="isSpecificSlots()"
                                                               ng-class="{'active' : package.isSpecificSlots}">Custom dates</a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>


                                        <div class="single-section-instructions" style="margin-top: 30px;">
                                            <p>
                                                You can customize your monthly schedule with sequential availability.
                                                <br/><br/>
                                                You can check your package operation on the calendar. Active days are outlined in orange.
                                            </p>
                                        </div>

                                    </div>
                                </div>

                                <!--EVERY DAY-->
                                <div class="single-section-content same-content" ng-if="package.isWorkingEveryday">
                                    <div class="single-section-container clearfix">
                                        <div class="single-section-left">


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
                                                <h5 class="mandotory">How many bookings can you accept from youtripper.com?<span>*</span></h5>
                                                <div class="normal-input">
                                                    <div class="input-with-backSub">
                                                        <input class="blueInput normalFont center-text-input" placeholder="<fmt:message key="step4.maximumPack.number" bundle="${lang}"/>"
                                                               ng-model="package.maxQuota"  ng-class="{'hasError' : (!showMissingData && (isNaN(package.maxQuota) || package.maxQuota <= 0))}"
                                                               numbers-only/>
                                                        <span class="backSub">
                                                            per day
                                                        </span>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--END EVERYDAY-->

                                <!--SCHEDULE SLOTS-->
                                <div class="single-section-content same-content" ng-if="package.isMonthlyDays">
                                    <div class="single-section-container clearfix">
                                        <div class="single-section-middle">
                                            <h5 class="mandotory">How many booking slots do you want to create per month?<span>*</span></h5>
                                            <div class="single-input" id="schedule-explain">
                                                <p>
                                                    Click on the <span class="plusBtn"></span> to add a time slot in that week. You can define the booking day but duration is automatically calculated.
                                                    <br/>
                                                    You must assign a maximum booking quota from youtripper.com, dedicated to each slot.
                                                </p>
                                            </div>

                                            <div class="single-input">
                                                <div id="schedule-table">
                                                    <div class="bg">
                                                        <ul class="clearfix">
                                                            <li class="week">
                                                                <ul class="clearfix">
                                                                    <li class="day">

                                                                    </li>
                                                                    <li class="day">

                                                                    </li>
                                                                    <li class="day">

                                                                    </li>
                                                                    <li class="day">

                                                                    </li>
                                                                    <li class="day">

                                                                    </li>
                                                                    <li class="day">

                                                                    </li>
                                                                    <li class="day">

                                                                    </li>
                                                                </ul>
                                                            </li>
                                                            <li class="week">
                                                                <ul class="clearfix">
                                                                    <li class="day">

                                                                    </li>
                                                                    <li class="day">

                                                                    </li>
                                                                    <li class="day">

                                                                    </li>
                                                                    <li class="day">

                                                                    </li>
                                                                    <li class="day">

                                                                    </li>
                                                                    <li class="day">

                                                                    </li>
                                                                    <li class="day">

                                                                    </li>
                                                                </ul>
                                                            </li>
                                                            <li class="week">
                                                                <ul class="clearfix">
                                                                    <li class="day">

                                                                    </li>
                                                                    <li class="day">

                                                                    </li>
                                                                    <li class="day">

                                                                    </li>
                                                                    <li class="day">

                                                                    </li>
                                                                    <li class="day">

                                                                    </li>
                                                                    <li class="day">

                                                                    </li>
                                                                    <li class="day">

                                                                    </li>
                                                                </ul>
                                                            </li>
                                                            <li class="week">
                                                                <ul class="clearfix">
                                                                    <li class="day">

                                                                    </li>
                                                                    <li class="day">

                                                                    </li>
                                                                    <li class="day">

                                                                    </li>
                                                                    <li class="day">

                                                                    </li>
                                                                    <li class="day">

                                                                    </li>
                                                                    <li class="day">

                                                                    </li>
                                                                    <li class="day">

                                                                    </li>
                                                                </ul>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                    <div class="week-header">
                                                        <ul class="clearfix">
                                                            <li>
                                                                WEEK 1 <span class="plusBtn"></span>
                                                            </li>
                                                            <li>
                                                                WEEK 2 <span class="plusBtn"></span>
                                                            </li>
                                                            <li>
                                                                WEEK 3 <span class="plusBtn"></span>
                                                            </li>
                                                            <li>
                                                                WEEK 4 <span class="plusBtn"></span>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                    <div class="day-header clearfix">
                                                        <ul class="clearfix">
                                                            <li>
                                                                Sun
                                                            </li>
                                                            <li>
                                                                Mon
                                                            </li>
                                                            <li>
                                                                Tue
                                                            </li>
                                                            <li>
                                                                Wed
                                                            </li>
                                                            <li>
                                                                Thu
                                                            </li>
                                                            <li>
                                                                Fri
                                                            </li>
                                                            <li>
                                                                Sat
                                                            </li>
                                                        </ul>
                                                        <ul class="clearfix">
                                                            <li>
                                                                Sun
                                                            </li>
                                                            <li>
                                                                Mon
                                                            </li>
                                                            <li>
                                                                Tue
                                                            </li>
                                                            <li>
                                                                Wed
                                                            </li>
                                                            <li>
                                                                Thu
                                                            </li>
                                                            <li>
                                                                Fri
                                                            </li>
                                                            <li>
                                                                Sat
                                                            </li>
                                                        </ul>

                                                        <ul class="clearfix">
                                                            <li>
                                                                Sun
                                                            </li>
                                                            <li>
                                                                Mon
                                                            </li>
                                                            <li>
                                                                Tue
                                                            </li>
                                                            <li>
                                                                Wed
                                                            </li>
                                                            <li>
                                                                Thu
                                                            </li>
                                                            <li>
                                                                Fri
                                                            </li>
                                                            <li>
                                                                Sat
                                                            </li>
                                                        </ul>
                                                        <ul class="clearfix">
                                                            <li>
                                                                Sun
                                                            </li>
                                                            <li>
                                                                Mon
                                                            </li>
                                                            <li>
                                                                Tue
                                                            </li>
                                                            <li>
                                                                Wed
                                                            </li>
                                                            <li>
                                                                Thu
                                                            </li>
                                                            <li>
                                                                Fri
                                                            </li>
                                                            <li>
                                                                Sat
                                                            </li>                                                        
                                                        </ul>
                                                    </div>
                                                    <div class="specific-slots-container">
                                                        <div class="slot-row">
                                                            <a class="single-slot" href="">
                                                                Quota<br/>
                                                                02
                                                            </a>
                                                        </div>
                                                        <div class="slot-row">
                                                            <a class="single-slot" href="">
                                                                Quota<br/>
                                                                02
                                                            </a>
                                                        </div>
                                                        <div class="slot-row">
                                                            <a class="single-slot" href="">
                                                                Quota<br/>
                                                                02
                                                            </a>
                                                        </div>
                                                        <div class="slot-row">
                                                            <a class="single-slot" href="">
                                                                Quota<br/>
                                                                02
                                                            </a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--END SCHEDULE-->

                                <!--SPECIFIC SLOTS-->
                                <div class="single-section-content same-content" ng-if="package.isSpecificSlots">
                                    <div class="single-section-container clearfix">
                                        <div class="single-section-left">
                                            <h5>Enter any date within 12 months on which you want your customers to book this package.</h5>
                                            <div class="single-input">
                                                <p>
                                                    Start from your first day and enter your quota number per slot. 
                                                    <br/>
                                                    Our team will send you renewal reminders every 6 months.
                                                </p>
                                            </div>

                                            <div class="single-input">
                                                <div class="multi-childInput">
                                                    <div class="label-input arranged">
                                                        <div class="row">
                                                            <div class="col-xs-8">
                                                                <div class="label">
                                                                    <h5 class="mandatory">How many booking slots do you want to create?<span>*</span></h5>
                                                                </div>
                                                            </div>
                                                            <div class="col-xs-4">
                                                                <div class="input normalInput">
                                                                    <div class="inputAutoNumber">
                                                                        <a href="" class="minusBtn" ng-class="{'active' :(package.tempSpecificDateSlots.length > 1)}" ng-click="descreaseDateSlot()" ></a>
                                                                        <input disabled type="text" class="blueInput normalFont" 
                                                                               value="{{package.tempSpecificDateSlots.length}} Slot(s)" placeholder="No. Slots"/>
                                                                        <a href="" class="plusBtn active" ng-click="increaseDateSlot()"/></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="multi-childInput" ng-if="package.tempSpecificDateSlots.length > 1">
                                                    <div class="row">
                                                        <div class="col-xs-4">
                                                            <a href="" class="linkBtn hrefCheckBox" ng-class="{'active':isUsingSameQuota === true}" 
                                                               ng-click="isUsingSameQuota === false ? setUsingSameQuota(true):setUsingSameQuota(false)">Use the same Quota</a>
                                                        </div>
                                                        <div class="input normalInput col-xs-3" ng-if="isUsingSameQuota">
                                                            <input type="text" class="blueInput normalFont center-text-input"
                                                                   ng-model="sameQuota.value" placeholder="Enter Quota"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="multi-childInput">
                                                    <div class="slots-row">
                                                        <ul class="clearfix">
                                                            <li ng-repeat=" x in package.tempSpecificDateSlots">
                                                                <div class="specific-slot">
                                                                    <div class="slot-date">
                                                                        <span class="no-slot">{{$index + 1}}</span>
                                                                        <a href="" ng-click="showSmallAvailableCalendar($event, $index, 'dateSlot')">{{x.dateStr === "" ? "Enter date":x.dateStr}}</a>
                                                                        <span class="close-btn" ng-click="package.tempSpecificDateSlots.splice($index, 1)">
                                                                        </span>
                                                                    </div>
                                                                    <div class="slot-quota" ng-class="{'disabled':isUsingSameQuota === true}">
                                                                        <input class="" type="text" ng-model="x.maxQuota"  placeholder="Enter Quota" 
                                                                               numbers-only  range-min="1"/>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--END SPECIFIC SLOTS-->

                                <div id="availableCalendar">
                                    <div class="smallCalendar">
                                        <div class="calendarYearMonth">
                                            <a href="" class="backCalendar" ng-click="backSmallAvailableMonth()"></a>
                                            <h4>{{MONTHS_OF_YEAR[inputDate.getMonth()]}} {{inputDate.getFullYear()}}</h4>
                                            <a href="" class="nextCalendar" ng-click="nexSmalltAvailableMonth()"></a>
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
                                <!--SAVE BUTTON-->
                                <div class="single-section-content same-content">
                                    <div class="single-section-container clearfix">
                                        <div class="single-section-left">
                                            <div class="single-input">
                                                <button class="btn-width-orange next-btn" ng-click="openConfirmBox('finish')"><fmt:message key="saveBtn" bundle="${lang}"/></button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--END SAVE BUTTON-->

                                <!--END BOOKING ENGINE-->

                            </div>
                            <!--END MONTHLY CONTENT-->

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
                    <div id="Pricing" class="content" ng-switch-when="price">

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
                                            <div class="input-sentences">
                                                <ul class="clearfix">
                                                    <li>
                                                        <p><fmt:message key="step5.cancellation.condition.detail1" bundle="${lang}"/></p>
                                                    </li>
                                                    <li>
                                                        <input type="text" class="normalFont blueInput" placeholder="Enter days"
                                                               ng-model="x.duration" ng-class="{'missing':!showMissingData
                                                                                           && (x.duration === null || x.duration === '')}" numbers-only/>
                                                    </li>
                                                    <li>
                                                        <p>
                                                            <fmt:message key="step5.cancellation.condition.detail2" bundle="${lang}"/>
                                                        </p>
                                                    </li>
                                                    <li>
                                                        <div class="priceStandardHeader">
                                                            <select class="blueInput" name="" ng-model="x.percent" convert-to-number>
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

                                                        </div>
                                                    </li>
                                                    <li>
                                                        <p>
                                                            <fmt:message key="step5.cancellation.condition.detail3" bundle="${lang}"/>
                                                        </p>
                                                    </li>
                                                    <li>
                                                        <div class="plusBox">
                                                            <div class="deleteSign" ng-show="!$first" ng-click="removeCancellationPolicy($index)"></div>
                                                        </div>
                                                    </li>
                                                </ul>
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
                        <div class='single-section-content'>
                            <div class="single-section-container clearfix">
                                <div class='single-section-left'>
                                    <div class="single-input">

                                        <div class="label-input clearfix">
                                            <div class="label">
                                                <h5 class="mandotory">
                                                    <fmt:message key="step5.discount&price.currency" bundle="${lang}"/><span>*</span>
                                                </h5>
                                            </div>
                                            <div class="input">
                                                <select ng-model="package.priceCurrency" class="blueInput currency">
                                                    <option value="THB">THB</option>
                                                    <option value="USD">USD</option>
                                                </select>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                                <div class='single-section-instructions'>
                                    <p>
                                        Your payout will be paid in this currency.  It is also used as the standard unit for your online prices. In order to avoid conversion fees select your county’s currency unit.
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class='single-section-content grey-section-content'>
                            <div class="single-section-container clearfix">
                                <div class='single-section-left'>
                                    <div class="single-input">
                                        <h5 class="mandotory"><fmt:message key="step4.packageTypeSelect" bundle="${lang}"/><span>*</span></h5>      
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-headers grey-section-content hasIcon">
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
                                                <div class="multi-childInput">
                                                    <div class="label-input arranged">
                                                        <div class="row">
                                                            <div class="col-xs-9">
                                                                <div class="label">
                                                                    <h5>
                                                                        <fmt:message key="step4.packageType1.selectQuantity" bundle="${lang}"/>  one person.
                                                                    </h5> 
                                                                </div>
                                                            </div>
                                                            <!--                                                            <div class="col-xs-3">
                                                                                                                            <div class="input normalInput">
                                                                                                                                <input type="text" class="normalFont blueInput center-text-input" value="1" placeholder="00.00"
                                                                                                                                       readonly />
                                                                                                                            </div>
                                                                                                                        </div>-->
                                                        </div>
                                                    </div>
                                                </div>

                                            </div>

                                            <div class="single-input">
                                                <div class="label-input arranged">
                                                    <div class="row">
                                                        <div class="col-xs-9">
                                                            <div class="label">
                                                                <h5>Do you want to set up a minimum?</h5>
                                                            </div>
                                                        </div>
                                                        <div class="col-xs-3">
                                                            <div class="input normalInput">
                                                                <div class="inputAutoNumber">
                                                                    <a href="" class="minusBtn" ng-class="{'active' :(package.minTripper > 1)}" ng-click="descreasePublicMinimum()"></a>
                                                                    <input disabled type="text" class="blueInput normalFont" ng-class="{'missing':(!showMissingData && package.minTripper === null || package.minTripper === 0)}" value="{{package.minTripper}} Persons"
                                                                           placeholder="No. Person"/>
                                                                    <a href="" class="plusBtn active" ng-click="increasePublicMinimum()"/></a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="single-input">

                                                <div class="label-input arranged">
                                                    <div class="row">
                                                        <div class="col-xs-9">
                                                            <div class="label">
                                                                <h5 class="mandotory">
                                                                    <fmt:message key="step5.discount&price.youtripperPrice" bundle="${lang}"/>
                                                                    <span>*</span>
                                                                </h5>
                                                            </div>
                                                        </div>
                                                        <div class="col-xs-3">
                                                            <div class="input normalInput">
                                                                <div class="input-with-backSub">
                                                                    <input ng-class="{'missing':(!showMissingData && (package.youtripperPrice === '' ||
                                                                                                package.youtripperPrice === 0))}" type="text" 
                                                                           class="normalFont blueInput center-text-input" placeholder="00.00"
                                                                           ng-model="package.youtripperPrice" numbers-only />
                                                                    <span class="backSub">
                                                                        /Person
                                                                    </span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

                                                </div>                                                
                                            </div>

                                            <!--Free Discount-->
                                            <div class="single-input"> 
                                                <h5>Do you offer free admission?</h5>
                                                <input type="text" class="normalFont blueInput" ng-model="package.freeCondition"
                                                       placeholder="Write down your conditions for free admission" />
                                            </div>
                                        </div>
                                        <div class='single-section-instructions' style="margin-top: 170px;">
                                            <p>
                                                This is the online selling price shown on our youtripper website. It includes 7% VAT and will be promoted on your package site and package thumbnails for customers to see and compare.
                                                <br/><br/>
                                                We recommend to discount this price by at least 5% off your usual walk-in price. This price is used as a base for promotional discounts calculations.
                                            </p>
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
                                                <div class="label-input arranged">
                                                    <div class="row">
                                                        <div class="col-xs-9">
                                                            <div class="label">
                                                                <h5 class="mandotory">
                                                                    Enter the maximum number of persons served by this package.
                                                                    <span>*</span>
                                                                </h5>
                                                            </div>

                                                        </div>
                                                        <div class="col-xs-3">
                                                            <div class="input normalInput">
                                                                <div class="inputAutoNumber">
                                                                    <a href="" class="minusBtn" ng-class="{ 'active' : (package.maxTripper > 1)}"
                                                                       ng-click="descreaseMaximumPrivate('package.maxTripper')"></a>
                                                                    <input disabled id="maxTripperInput" type="text" 
                                                                           class="blueInput normalFont active" ng-class="{'missing':(!showMissingData && package.packageType === 'Personal' && package.maxTripper === null)}" value="{{package.maxTripper}} Persons"
                                                                           placeholder="Max number"/>
                                                                    <a href="" class="plusBtn active" 
                                                                       ng-click="increaseMaximumPrivate('package.maxTripper')"/></a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="single-input">
                                                <div class="multi-childInput">      
                                                    <div class="label-input arranged">
                                                        <div class="row">
                                                            <div class="col-xs-9">
                                                                <div class="label">
                                                                    <h5 class="mandotory">
                                                                        <fmt:message key="step5.discount&price.youtripperPrice" bundle="${lang}"/>
                                                                        <span>*</span>
                                                                    </h5>
                                                                </div>
                                                            </div>
                                                            <div class="col-xs-3">
                                                                <div class="input normalInput">
                                                                    <div class="input-with-backSub">
                                                                        <input ng-class="{'missing':(!showMissingData && (package.youtripperPrice === '' ||
                                                                                                    package.youtripperPrice === 0))}" 
                                                                               type="text" class="normalFont blueInput center-text-input" placeholder="00.00"
                                                                               ng-model="package.youtripperPrice" numbers-only />
                                                                        <span class="backSub">
                                                                            /Package
                                                                        </span>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                            <!--Free Discount-->
                                            <div class="single-input"> 
                                                <h5>Do you offer free admission?</h5>
                                                <input type="text" class="normalFont blueInput" ng-model="package.freeCondition"
                                                       placeholder="Write down your conditions for free admission" />
                                            </div>
                                        </div>
                                        <div class='single-section-instructions hasHeader' style="margin-top: 105px;">
                                            <p>
                                                This is the online selling price shown on our youtripper website. It includes 7% VAT and will be promoted on your package site and package thumbnails for customers to see and compare.
                                                <br/><br/>
                                                We recommend to discount this price by at least 5% off your usual walk-in price. This price is used as a base for promotional discounts calculations.
                                            </p>
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
                                                <div class="label-input arranged">
                                                    <div class="row">
                                                        <div class="col-xs-9">
                                                            <div class="label">
                                                                <h5 class="mandotory">
                                                                    Enter the minimum number of persons required by this package.<span>*</span>
                                                                </h5>
                                                            </div>                                                        
                                                        </div>
                                                        <div class="col-xs-3">
                                                            <div class="input normalInput">
                                                                <div class="inputAutoNumber">
                                                                    <a href="" class="minusBtn" ng-class="{'active' :(package.minTripper > 5)}" ng-click="descreaseMinimumGroup('package.minTripper')"></a>
                                                                    <input type="text" class="blueInput normalFont" value="{{package.minTripper}} Persons"
                                                                           placeholder="Minimum is 5" />
                                                                    <a href="" class="plusBtn active" ng-click="increaseMinimumGroup('package.minTripper')"/></a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="single-input">
                                                <div class="label-input arranged">
                                                    <div class="row">
                                                        <div class="col-xs-9">
                                                            <div class="label">
                                                                <h5 class="mandotory">
                                                                    Enter the limit of persons who  can be served by this package.<span>*</span>
                                                                </h5>
                                                            </div>
                                                        </div>
                                                        <div class="col-xs-3">
                                                            <div class="input normalInput">
                                                                <div class="inputAutoNumber">
                                                                    <a href="" class="minusBtn" ng-class="{'active' :(package.maxTripper > 5)}" ng-click="descreaseMaximumGroup('package.maxTripper')"></a>
                                                                    <input id="maxTripperInput" disabled type="text" class="blueInput normalFont" value="{{package.maxTripper}} Persons" ng-class="{'missing':(!showMissingData && package.packageType === 'Group' && package.maxTripper === null)}"
                                                                           placeholder="Max number"/>
                                                                    <a href="" class="plusBtn active" ng-click="increaseMaximumGroup('package.maxTripper')"/></a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>       
                                                </div>
                                            </div>
                                            <div class="single-input">
                                                <div class="multi-childInput">     
                                                    <div class="label-input arranged">
                                                        <div class="row">
                                                            <div class="col-xs-9">
                                                                <div class="label">
                                                                    <h5 class="mandotory">
                                                                        <fmt:message key="step5.discount&price.youtripperPrice" bundle="${lang}"/>
                                                                        <span>*</span>
                                                                    </h5>
                                                                </div>
                                                            </div>
                                                            <div class="col-xs-3">
                                                                <div class="input normalInput">
                                                                    <div class="input-with-backSub">
                                                                        <input ng-class="{'missing':(!showMissingData && (package.youtripperPrice === '' ||
                                                                                                    package.youtripperPrice === 0))}" 
                                                                               type="text" class="normalFont blueInput center-text-input" placeholder="00.00"
                                                                               ng-model="package.youtripperPrice" numbers-only />
                                                                        <span class="backSub">/Person</span>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <!--Free Discount-->
                                            <div class="single-input"> 
                                                <h5>Do you offer free admission?</h5>
                                                <input id="packagePriceInput" type="text" class="normalFont blueInput" ng-model="package.freeCondition"
                                                       placeholder="Write down your conditions for free admission" />
                                            </div>
                                        </div>

                                        <div class='single-section-instructions hasHeader' style="margin-top: 145px;">
                                            <p>
                                                This is the online selling price shown on our youtripper website. It includes 7% VAT and will be promoted on your package site and package thumbnails for customers to see and compare.
                                                <br/><br/>
                                                We recommend to discount this price by at least 5% off your usual walk-in price. This price is used as a base for promotional discounts calculations.
                                            </p>
                                        </div>
                                    </div>
                                </div>
                                <!--END MIN TRIPPER AND MAX TRIPPER-->

                            </div>
                        </div>

                        <div class='single-section-content same-content' ng-if="package.packageType !== 'Personal'">
                            <div class="single-section-container clearfix">
                                <div class='single-section-left'>
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
                                    <div class="single-input same-content" 
                                         ng-if="isHaveChildrenDiscount">
                                        <h5 class="mandotory"><fmt:message key="step5.childDiscount.description" bundle="${lang}"/><span>*</span></h5>
                                        <div class="multi-childInput"
                                             ng-repeat="x in package.childrenDiscountJson track by $index">
                                            <div class="input-sentences">
                                                <ul class="clearfix">
                                                    <li>
                                                        <select ng-model="x.discountType" class="blueInput">
                                                            <option value="age"><fmt:message key="step5.childDiscount.age" bundle="${lang}"/></option>
                                                            <option value="height"><fmt:message key="step5.childDiscount.height" bundle="${lang}"/></option>
                                                        </select>
                                                    </li>
                                                    <li>
                                                        <p> 
                                                            {{x.discountType === 'height' ? 
'<fmt:message key="step5.pricePreview.below" bundle="${lang}"/>' : 
        '<fmt:message key="step5.pricePreview.under" bundle="${lang}"/>'}} 
                                                        </p>
                                                    </li>
                                                    <li>
                                                        <input type="text" class="normalFont blueInput" placeholder="Number"
                                                               ng-model="x.condition" ng-class="{'missing':(!showMissingData && x.condition === '')}" numbers-only/>
                                                    </li>
                                                    <li ng-if="x.discountType === 'age'">
                                                        <select ng-model="x.ageType" class="blueInput discount-type">
                                                            <option value="months"><fmt:message key="step4.duration.month" bundle="${lang}"/></option>
                                                            <option value="years"><fmt:message key="step4.duration.year" bundle="${lang}"/></option>
                                                        </select>
                                                    </li>           
                                                    <li ng-show="x.discountType === 'height'">
                                                        <p>cm</p>
                                                    </li>
                                                </ul>
                                                <ul class="clearfix">
                                                    <li>
                                                        <p>
                                                            <fmt:message key="step5.childDiscount.detail" bundle="${lang}"/>
                                                        </p>
                                                    </li>
                                                    <li>
                                                        <select name="" ng-model="x.discountPercent" convert-to-number class="blueInput">
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
                                                    </li>
                                                    <li>
                                                        <div class="deleteSign remove-children-discount" 
                                                             ng-show="!$first" ng-click="removeChildrenDiscount($index)"></div>
                                                    </li>
                                                </ul>
                                            </div>

                                        </div>
                                        <div class="multi-childInput">
                                            <div class="newPolicy" ng-click="addNewDiscount()"
                                                 ng-class="{'disable-addnew-btn':package.childrenDiscountJson.length === 4}" ><fmt:message key="step5.childDiscount.addNew" bundle="${lang}"/></div>
                                        </div>
                                    </div>
                                </div>
                                <div class='single-section-instructions'>
                                    <p>
                                        Add children discount conditions that will be made available in the booking box on the package page. 
                                        <br/>
                                        The price is calculated from the youtripper online price and not the standard price. You can also provide free admission for children under a certain age.
                                    </p>
                                </div>
                            </div>
                        </div>

                        <div class='single-section-content same-content' ng-if="isHaveCancellation">
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
                                            <div class="label-input">
                                                <div class="row">                                                
                                                    <div class="col-xs-9">
                                                        <div class="label">
                                                            <h5 class="mandotory">
                                                                <fmt:message key="step5.noCancellation.detail" bundle="${lang}"/><span>*</span>
                                                            </h5>
                                                        </div>
                                                    </div>

                                                    <div class="col-xs-3">
                                                        <div class="input normalInput">
                                                            <div class="inputAutoNumber">
                                                                <a href="" class="minusBtn"
                                                                   ng-class="{'active' :(package.noCancellationPercent > 1)}" 
                                                                   ng-click="descreaseNoCancellationPercentage()"></a>
                                                                <input disabled type="text" class="normalFont blueInput"
                                                                       value="{{viewNoCancellationPrice(package.noCancellationPercent)}}" />
                                                                <a href="" class="plusBtn" ng-click="increaseNoCancellationPercentage()"
                                                                   ng-class="{'active':(package.noCancellationPercent < 100)}"/></a>
                                                            </div>
                                                        </div>
                                                    </div>        
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class='single-section-instructions'>
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
                                        <h5>
                                            <fmt:message key="step5.pricePreview.online" bundle="${lang}"/>  
                                        </h5>
                                        <div class="multi-childInput">
                                            <div class="row">
                                                <div class="col-xs-8" >
                                                    <fmt:message key="step5.pricePreview.text1" bundle="${lang}"/>
                                                </div>
                                                <div class="col-xs-4 price-content">
                                                    <div class="row">
                                                        <div class="col-xs-8">
                                                            {{package.youtripperPrice| number: 2}}
                                                        </div>
                                                        <div class="col-xs-4">
                                                            {{package.priceCurrency}}
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="multi-childInput servicePrice-preview-row">
                                            <div class="row">
                                                <div class="col-xs-8" >
                                                    <fmt:message key="step5.pricePreview.text3" bundle="${lang}"/>
                                                </div>
                                                <div class="col-xs-4 price-content">
                                                    <div class="row">
                                                        <div class="col-xs-8">
                                                            {{getStandardPriceWithSC() | number: 2}}
                                                        </div>
                                                        <div class="col-xs-4">
                                                            {{package.priceCurrency}}
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="multi-childInput payoutPrice-preview-row">
                                            <div class="row">
                                                <div class="col-xs-8">
                                                    <fmt:message key="step5.pricePreview.text2" bundle="${lang}"/>
                                                </div>
                                                <div class="col-xs-4  price-content">
                                                    <div class="row">
                                                        <div class="col-xs-8">
                                                            {{getStandardPriceOfPayout() | number: 2}}
                                                        </div>
                                                        <div class="col-xs-4">
                                                            {{package.priceCurrency}}
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
                                                <div class="col-xs-8" >
                                                    <fmt:message key="step5.pricePreview.text1" bundle="${lang}"/>
                                                </div>
                                                <div class="col-xs-4 price-content">
                                                    <div class="row">
                                                        <div class="col-xs-8">
                                                            {{getNoCancellationPrice() | number : 2}} 
                                                        </div>
                                                        <div class="col-xs-4">
                                                            {{package.priceCurrency}}
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="multi-childInput servicePrice-preview-row">
                                            <div class="row">
                                                <div class="col-xs-8">
                                                    <fmt:message key="step5.pricePreview.noCancellation.text3" bundle="${lang}"/>
                                                </div>
                                                <div class="col-xs-4 price-content">
                                                    <div class="row">
                                                        <div class="col-xs-8">
                                                            {{calculateCancellationPriceWithSC() | number:2}}
                                                        </div>
                                                        <div class="col-xs-4">
                                                            {{package.priceCurrency}}
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="multi-childInput payoutPrice-preview-row">
                                            <div class="row">
                                                <div class="col-xs-8">
                                                    <fmt:message key="step5.pricePreview.noCancellation.text2" bundle="${lang}"/>
                                                </div>
                                                <div class="col-xs-4 price-content">
                                                    <div class="row">
                                                        <div class="col-xs-8">
                                                            {{calculatePayoutOfNoCancellation() | number : 2}} 
                                                        </div>
                                                        <div class="col-xs-4">
                                                            {{package.priceCurrency}}
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
                                                <div class="col-xs-8" >
                                                    <fmt:message key="step5.pricePreview.childrenDiscount.text1" bundle="${lang}"/>
                                                </div>
                                                <div class="col-xs-4 price-content">
                                                    <div class="row">
                                                        <div class="col-xs-8">
                                                            {{getChildrenDiscountPrice(x.discountPercent) | number: 2}}
                                                        </div>
                                                        <div class="col-xs-4">
                                                            {{package.priceCurrency}}
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="multi-childInput servicePrice-preview-row">
                                            <div class="row">
                                                <div class="col-xs-8">
                                                    <fmt:message key="step5.pricePreview.childrenDiscount.text3" bundle="${lang}"/>
                                                </div>
                                                <div class="col-xs-4 price-content">
                                                    <div class="row">
                                                        <div class="col-xs-8">

                                                            {{getChildrenDiscountPriceWithSC(x.discountPercent) | number : 2}}

                                                        </div>
                                                        <div class="col-xs-4">
                                                            {{package.priceCurrency}}
                                                        </div>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>

                                        <div class="multi-childInput payoutPrice-preview-row">
                                            <div class="row">
                                                <div class="col-xs-8">
                                                    <fmt:message key="step5.pricePreview.childrenDiscount.text2" bundle="${lang}"/>
                                                </div>
                                                <div class="col-xs-4  price-content">
                                                    <div class="row">
                                                        <div class="col-xs-8">
                                                            {{getChildrenDiscountPriceOfPayout(x.discountPercent) | number : 2}}
                                                        </div>
                                                        <div class="col-xs-4">
                                                            {{package.priceCurrency}}
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
                                <div class="col-xs-6">
                                    <div style="text-align: center" >
                                        <a href="" ng-click="confirmEdit()" class="btn-width-orange login_gg btnNextStep"><fmt:message key="registration.confirm.fill" bundle="${lang}"/></a>
                                    </div>
                                </div>
                                <div class="col-xs-6" >
                                    <div style="text-align: center" >
                                        <a href="" ng-click="confirmContinue(nextStep)" class="btn-width-orange btnNextStep"><fmt:message key="registration.confirm.next" bundle="${lang}"/></a>
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
                                <div class="col-xs-6">
                                    <div>
                                        <a href="" ng-click="confirmContinue(selectedWizard)" class="btn-width-orange btnNextStep">Save</a>
                                    </div>
                                </div>
                                <div class="col-xs-6">
                                    <div>
                                        <a href="" class="btn-width-orange login_gg btnNextStep" ng-click="closeWaringSave()">No</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!--Warning to save data in booking-->
                    <div class="certificateBox" id="bookingSaveBox">
                        <div class="confim-clone-package">                            
                            <h4>Change type of package will delete your current data,do you want continue ?</h4>
                            <div class="row confirm-clone-btn">                                                               
                                <div class="col-xs-6">
                                    <div>
                                        <a href="" ng-click="changePackageTypeInBooking(selectedWizard)" class="btn-width-orange btnNextStep">Yes</a>
                                    </div>
                                </div>
                                <div class="col-xs-6">
                                    <div>
                                        <a href="" class="btn-width-orange login_gg btnNextStep" ng-click="closeBookingSave()">No</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!--Warning when set up schedule and choose duration less than 1 hour-->
                    <div class="certificateBox" id="lowDurationBox">
                        <div class="confim-clone-package">                            
                            <h4>Choose Duration less than 1 hour will disable "Set up schedule", do you want continue ?</h4>
                            <div class="row confirm-clone-btn">                                                               
                                <div class="col-xs-6">
                                    <div>
                                        <a href="" ng-click="selectLowDurationHour()" class="btn-width-orange btnNextStep">Yes</a>
                                    </div>
                                </div>
                                <div class="col-xs-6">
                                    <div>
                                        <a href="" class="btn-width-orange login_gg btnNextStep" ng-click="closelowDurationBox()">No</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!--Warning when switch between 'minutes slot' and 'set up schedule'-->
                    <div class="certificateBox" id="changeScheduleBox">
                        <div class="confim-clone-package">                            
                            <h4>switch between "minutes slots" and "set up schedule", do you want continue ?</h4>
                            <div class="row confirm-clone-btn">                                                               
                                <div class="col-xs-6">
                                    <div>
                                        <a href="" ng-click="setIsFreeBooking()" class="btn-width-orange btnNextStep">Yes</a>
                                    </div>
                                </div>
                                <div class="col-xs-6">
                                    <div>
                                        <a href="" class="btn-width-orange login_gg btnNextStep" ng-click="closeChangeScheduleBox()">No</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!--Warning when add duplicate time slot-->
                    <div class="certificateBox" id="duplicateTimeSlotBox">
                        <div class="confim-clone-package">                            
                            <h4>This time slot already exist, please choose another time slot !!!</h4>
                            <div class="row confirm-clone-btn">                                                               
                                <div class="centerPopupBtn">
                                    <a href="" ng-click="closeDuplicateTimeSlot()" class="btn-width-orange btnNextStep">Yes</a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!--Warning when switch between 'minutes slot' and 'set up schedule'-->
                    <div class="certificateBox" id="changeServingBox">
                        <div class="confim-clone-package">                            
                            <h4>Change your serving time will effect your "set up schedule", do you want continue ?</h4>
                            <div class="row confirm-clone-btn">                                                               
                                <div class="col-xs-6">
                                    <div>
                                        <a href="" ng-click="setChangeServingPeriodID()" class="btn-width-orange btnNextStep">Yes</a>
                                    </div>
                                </div>
                                <div class="col-xs-6">
                                    <div>
                                        <a href="" class="btn-width-orange login_gg btnNextStep" ng-click="closeServingBox()">No</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!--Warning when set up schedule without select duration -->
                    <div class="certificateBox" id="selectDurationBox">
                        <div class="confim-clone-package">                            
                            <h4>Please select duration of your package before set up schedule !!!</h4>
                            <div class="row confirm-clone-btn">                                                               
                                <div class="centerPopupBtn">
                                    <a href="" ng-click="closeSelectDurationBox()" class="btn-width-orange btnNextStep">OK</a>
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
                        var temporaryPackage = ${requestScope.temporaryPackage}; var uploadCoverImageUrl = '<c:url value="/Provider/Package/uploadCoverImage"/>';
                        var uploadAdditionalImagesUrl = '<c:url value="/Provider/Package/uploadAdditionalImages"/>';
                        var deleteAdditionalImageUrl = '<c:url value="/Provider/Package/deleteAdditionalImage"/>';
                        var macAddress = '${requestScope.macAddress}';
                        var timeNowVar = '${requestScope.timeNow}'; var paramLanguage = '';
        <c:if test="${not empty param.language}">
                        paramLanguage = '${param.language}';
        </c:if>
    </script>

    <!-- Begin Inspectlet Embed Code -->
    <script type="text/javascript" id="inspectletjs">
                        window.__insp = window.__insp || []; __insp.push(['wid', 558868705]);
                        (function() {
                        function ldinsp(){if (typeof window.__inspld != "undefined") return; window.__inspld = 1; var insp = document.createElement('script'); insp.type = 'text/javascript'; insp.async = true; insp.id = "inspsync"; insp.src = ('https:' == document.location.protocol ? 'https' : 'http') + '://cdn.inspectlet.com/inspectlet.js'; var x = document.getElementsByTagName('script')[0]; x.parentNode.insertBefore(insp, x); };
                        setTimeout(ldinsp, 500); document.readyState != "complete" ? (window.attachEvent ? window.attachEvent('onload', ldinsp) : window.addEventListener('load', ldinsp, false)) : ldinsp(); })();</script>
    <!-- End Inspectlet Embed Code -->

    <script src = "https://maps.googleapis.com/maps/api/js?signed_in=true&libraries=places&language=en&key=AIzaSyBxd2qXURVG6IsmGwrti3CzGwCpGNXFFuw&extension=.js" ></script> 

</html>
