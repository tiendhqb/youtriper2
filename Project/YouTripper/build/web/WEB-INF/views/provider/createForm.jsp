<%-- 
    Document   : packageForm
    Created on : Oct 5, 2015, 6:29:19 PM
    Author     : Nick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>--%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=1366">
        <!--        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1">-->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>YouTripper - Package Creation</title>
        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>">
        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">

<!--<link href="<c:url value="/Resources/Theme/css/jquery.steps.css"/>" rel="stylesheet">-->
        <link href="<c:url value="/Resources/Theme/css/smart_wizard.css"/>" rel="stylesheet" type="text/css">
        <link href="<c:url value="/Resources/Theme/css/jquery.tag-editor.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/pepper-ginder-custom.css"/>" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css?999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css?99999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style-login.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/font-awesome.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripperResponsive.css"/>">
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/clockpicker.css"/>">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Include all compiled plugins (below), or include individual files as needed -->

        <%@ include file="../angular.jsp" %>

<!--<script src="<c:url value="/Resources/Theme/js/jquery-1.11.1.min.js"/>"></script>-->
        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>

        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>

        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>

        <script src="<c:url value="/Resources/Theme/js/jquery.cookie-1.3.1.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/Resources/Theme/js/jquery.smartWizard.js?99999999999999999999"/>"></script>

        <script src="<c:url value="/Resources/Theme/js/jquery.caret.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.tag-editor.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.multidatespicker.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.simple-color.js"/>"></script>


<!--        <script src="<c:url value="/Resources/Theme/js/jquery.ui.widget.js"/>"></script>
    <script src="<c:url value="/Resources/Theme/js/ui.checkbox.js"/>"></script>-->


        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->



        <script>

            var componentForm = {
                street_number: 'short_name',
                route: 'long_name',
                locality: 'long_name',
                administrative_area_level_1: 'short_name',
                country: 'long_name',
                postal_code: 'short_name'
            };
            function initMap() {
                var myLatlng = new google.maps.LatLng(${requestScope.lat},${requestScope.lng});
                var map = new google.maps.Map(document.getElementById('map'), {
                    center: myLatlng,
                    zoom: 17,
                    draggable: true
                });
                var input = (document.getElementById('pac-input'));
                var autocomplete = new google.maps.places.Autocomplete(input, {types: ['address']});
                autocomplete.bindTo('bounds', map);
                var infowindow = new google.maps.InfoWindow();
                var marker = new google.maps.Marker({
                    map: map,
                    position: myLatlng
                            //                anchorPoint: new google.maps.Point(0, -29)
                });
                marker.setIcon(/** @type {google.maps.Icon} */({
                    size: new google.maps.Size(71, 71),
                    origin: new google.maps.Point(0, 0),
                    anchor: new google.maps.Point(17, 34),
                    scaledSize: new google.maps.Size(35, 35)
                }));
                //            maker.setMap(map);

                autocomplete.addListener('place_changed', function () {
                    infowindow.close();
                    var place = autocomplete.getPlace();
                    if (!place.geometry) {
                        window.alert("Autocomplete's returned place contains no geometry");
                        return;
                    }

                    // If the place has a geometry, then present it on a map.
                    if (place.geometry.viewport) {
                        map.fitBounds(place.geometry.viewport);
                    } else {
                        map.setCenter(place.geometry.location);
                        map.setZoom(17); // Why 17? Because it looks good.
                    }
                    fillInforWindow(place, infowindow, map, marker);
                    marker.setPosition(place.geometry.location);
                    fillToForm(place, marker);
                });
                google.maps.event.addListener(map, 'click', function (event) {
                    var location = event.latLng;
                    marker.setPosition(location);
                    document.getElementById("coordinate").value = location.lat() + "," + location.lng();
                });
            }

            function fillToForm(place, marker) {
                for (var component in componentForm) {
                    document.getElementById(component).value = '';
                }
                // Get each component of the address from the place details
                // and fill the corresponding field on the form.
                for (var i = 0; i < place.address_components.length; i++) {
                    var addressType = place.address_components[i].types[0];
                    if (componentForm[addressType]) {
                        var val = place.address_components[i][componentForm[addressType]];
                        document.getElementById(addressType).value = val;
                    }
                }

                document.getElementById("coordinate").value = marker.getPosition().lat().toString() + "," + marker.getPosition().lng().toString();
                angular.element($('#locality')).triggerHandler('input');
                angular.element($('#country')).triggerHandler('input');
                angular.element($('#administrative_area_level_1')).triggerHandler('input');
                angular.element($('#coordinate')).triggerHandler('input');
            }

            function fillInforWindow(place, infowindow, map, marker) {
                var address = '';
                if (place.address_components) {
                    address = [
                        (place.address_components[0] && place.address_components[0].short_name || ''),
                        (place.address_components[1] && place.address_components[1].short_name || ''),
                        (place.address_components[2] && place.address_components[2].short_name || '')
                    ].join(' ');
                }

                infowindow.setContent('<div><strong>' + place.name + '</strong><br>' + address);
                infowindow.open(map, marker);
            }

        </script>
    </head>
    <body class="pagesearch" ng-app="YouTripper" ng-controller="PackageController">
        <%@ include file="../header.jsp" %>
        <!--CONTENT-->
        <div class="padding-header">
            <div id="spinner-block" ng-hide="loaded">
                <div class="youtripper-spinner"></div>
            </div>
            <div class="fixed-steps">
                <div class="container container-package">
                    <a href="" class="selectedStep" ng-click="showSteps()">Step 1. Category</a>
                </div>
            </div>
            <div class="fixed-closing">
                <div class="container container-package">
                    <a href="" ng-click="showSteps()">Close</a>
                </div>
            </div>
            <div id="wizard" ng-cloak ng-show="loaded">
                <!--<div class="test">-->
                <ul class="menu-steps">
                    <li><a href="#Category">Category</a></li>
                    <li><a href="#Description">Description</a></li>
                    <li><a href="#Amenities">Amenities</a></li>
                    <li><a href="#Photos">Photos</a></li>
                    <li><a href="#Location">Location</a></li>
                    <li><a href="#Price">Price</a></li>
                    <li><a href="#Calendar">Calendar</a></li>
                </ul>
                <!--</div>-->
                <div id="Category">
                    <div class="step-container">
                        <form  name="activityForm" novalidate>
                            <h2>Choose Your Category</h2>
                            <div class="row choose-category">
                                <div class="col-md-2 col-sm-4 col-xs-6" ng-repeat="category in formContent.categories">
                                    <div class="round">
                                        <div class="circle-icon">
                                            <input type="checkbox" checklist-model="selectedCategoryIDs" checklist-value="category.id">
                                            <span style="background-image: url({{category.icon}})"></span>
                                        </div>
                                        <p>{{category.name}}</p>
                                    </div>
                                </div>
                            </div>
                            <div class="row row-select subCateRow">
                                <div class="col-lg-4  col-xs-12 ">
                                    <h2>Choose your sub-category</h2>
                                </div>
                                <div class="col-lg-8 col-xs-12 sub-col">
                                    <select>
                                        <option>
                                            {{subCategoriesStr}}
                                        </option>
                                    </select>
                                    <div class="popupBox">
                                        <div class="row category-row" ng-repeat="secondCategory in (availableCategory = (formContent.categories| filter:filterByCategory))">
                                            <div class="headerName">{{secondCategory.name}}</div>
                                            <!--                                            <div>
                                                                                            <div ng-repeat="i in getArrayToRepeatOptions(formContent.subCategories.length)">
                                                                                                {{i}}
                                                                                            </div>
                                                                                        </div>-->
                                            <div class="col-xs-6 col-sm-4 popup-option" ng-repeat="subCategory in formContent.subCategories| filter: {categoryID : secondCategory.id}">
                                                <div class="tempCheckbox">
                                                    <input type="checkbox" checklist-model="selectedSubCategories" checklist-value="subCategory">
                                                    <span></span>
                                                </div>
                                                <p>{{subCategory.name}}</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br/>
                            <div class="row row-select actRow">
                                <div class="col-lg-4 col-xs-12">
                                    <h2>Choose your Activity</h2>
                                    <p style="color:red" ng-show="missing.activityMsg && (package.activites.length <= 0)">Please select at least an activity</p>
                                </div>
                                <div class="col-lg-8 col-xs-12 act-col">
                                    <select><option>{{selectedActStr}}</option></select>
                                    <div class="popupBox">
                                        <div class="row category-row" ng-repeat="secondSubCategory in selectedSubCategories">
                                            <div class="headerName">{{secondSubCategory.name}}</div>
                                            <div class="col-xs-6 col-sm-4 popup-option" ng-repeat="activity in formContent.activities| filter: {subCategoryID : secondSubCategory.subCategoryID}">
                                                <div class="tempCheckbox">
                                                    <input type="checkbox" checklist-model="package.activites" checklist-value="activity">
                                                    <span></span>
                                                </div>
                                                <p>{{activity.name}}</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br/>
                            <div class="row row-select">
                                <div class="col-md-4 col-sm-12">
                                    <h2>Group Type</h2>
                                    <p style="color:red" ng-show="missing.activityMsg && (package.groupTypes.length <= 0)">Please select at least a group type</p>
                                </div>
                                <div class="col-md-8 col-sm-12">
                                    <ul>
                                        <li class="col-xs-6 col-sm-3" ng-repeat="groupType in formContent.groupTypes">
                                            <div class="tempCheckbox">
                                                <input type="checkbox" checklist-model="package.groupTypes" checklist-value="groupType">
                                                <span></span>
                                            </div>
                                            <p>{{groupType.name}}</p>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <br/>
                            <div class="row row-select">
                                <div class="col-md-4 col-sm-12">
                                    <h2>Trip Type</h2>
                                    <p style="color:red" ng-show="missing.activityMsg && (package.tripTypes.length <= 0)">Please select at least an trip type</p>
                                </div>
                                <div class="col-md-8 col-sm-12">
                                    <ul>
                                        <li class="col-xs-6 col-sm-3" ng-repeat="tripType in formContent.tripTypes">
                                            <div class="tempCheckbox">
                                                <input type="checkbox" checklist-model="package.tripTypes" checklist-value="tripType">
                                                <span></span>
                                            </div>
                                            <p>{{tripType.name}}</p>
                                        </li>
                                    </ul>
                                </div>
                            </div>

                        </form>
                    </div>
                </div>
                <div id="Description">
                    <div class="step-container">
                        <form name="descriptionForm" novalidate>
                            <h2>Describle your trip</h2>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis et vestibulum neque, id varius quam. Cum sociis natoque
                                penatibus et magnis dis parturient montes, nascetur ridiculus mus. In hac habitasse platea dictumst.
                            </p>
                            <div class="row">
                                <div class="col-sm-12"> 
                                    <input class="normalFont" type="text" placeholder="Name of trip (Length: 1 ~ 50)" name="packageName" ng-model="package.name" 
                                           maxlength="50" ng-maxlength="50"  required/>
                                </div>
                            </div>
                            <p style="color:red" ng-show="missing.informationMsg && descriptionForm.packageName.$error.required"> This field must not be blank!</p>
                            <h3>Duration</h3>
                            <div class="row">
                                <p style="color:red" ng-show="missing.informationMsg && !descriptionForm.durationNumber.$valid"> This field must be a number higher than 1!</p>
                                <div class="col-md-3 col-sm-5 col-xs-6">
                                    <input class="normalFont round" type="number" placeholder="Number" name="durationNumber"
                                           ng-model="package.duration" min="1"  required/>
                                </div>
                                <div class="col-md-1 col-sm-1 col-xs-1 text-center disXs" style="line-height: 50px;">
                                    <span>type</span>
                                </div>
                                <div class="col-md-3 col-sm-5 col-xs-6">
                                    <select name="packageDurationType" ng-model="package.durationType">
                                        <option value="0">Hours</option>
                                        <option value="1">Days</option>
                                    </select>
                                </div>
                            </div>
                            <h3>Short Description</h3>
                            <p style="color:red" ng-show="missing.informationMsg && descriptionForm.shortDescription.$error.required">This field must not be blank!</p>
                            <textarea class="normalFont" type="text" placeholder="Short description (Should between 100 and 160 characters)" 
                                      name="shortDescription" ng-model="package.googleDescription" maxlength="160" required></textarea>
                            <h3>Main Description</h3>
                            <p style="color:red" ng-show="missing.informationMsg && descriptionForm.mainDescription.$error.required">This field must not be blank!</p>
                            <textarea class="normalFont" type="text" placeholder="Description" 
                                      name="mainDescription" ng-model="package.mainDescription" required></textarea>
                            <h3>How many people can you handle?</h3>
                            <p style="color:red" ng-show="missing.informationMsg">
                                <span ng-show="descriptionForm.minTripper.$error.required || descriptionForm.maxTripper.$error.required">Number of tripper is required!</span>
                                <span ng-show="(package.minTripper > package.maxTripper)">Min tripper must less than max tripper!</span>
                            </p>
                            <div class="row">                            
                                <div class="col-md-3 col-xs-6"> 
                                    <input class="normalFont round" type="number" placeholder="Min Tripper" 
                                           name="minTripper"  min="1"  ng-model="package.minTripper" required/> 
                                </div>
                                <div class="col-md-1 col-sm-1 text-center seperateCol">

                                </div>
                                <div class="col-md-3 col-xs-6">
                                    <input class="normalFont round" type="number" placeholder="Max Tripper" 
                                           name="maxTripper" min="1" ng-model="package.maxTripper" required/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3 col-xs-6 full-xs">
                                    <h3>Departure Time</h3>
                                    <div class="input-group clockpicker" data-autoclose="true" style="    margin-top: -10px;">
                                        <input id="departureTime" name="departureTime" ng-model="package.departureTime" type="text" class="round normalFont" value="">
                                    </div>
                                </div>
                                <div class="col-md-1 col-sm-1 col-xs-12 text-center">

                                </div>
                                <div class="col-md-3 col-xs-6 full-xs">
                                    <h3>Departure Location</h3>
                                    <p style="color:red" ng-show="missing.informationMsg && descriptionForm.departureLocation.$error.required">This field must not be blank!</p>
                                    <input type="text" class="round normalFont"
                                           ng-model="package.departureLocation" type="text" placeholder="Departure Location" name="departureLocation" maxlength="100" required/>
                                </div>
                            </div>
                            <h3>Languages</h3>
                            <div class="row">
                                <div class="col-md-4 col-xs-5 full-xs">
                                    <p style="color:red" ng-show="missing.informationMsg && descriptionForm.language.$error.required">This field must not be blank!</p>
                                    <input class="normalFont round" type="text" placeholder="English, Vietnamese, Janpanese, ..." 
                                           name="language" ng-model="package.language" maxlength="40" required/>
                                </div>
                            </div>
                            <h3>Tags (Keywords)</h3>
                            <p style="color:red" ng-show="missing.informationMsg && descriptionForm.keyword.$error.required">This field must not be blank!</p>
                            <textarea maxlength="50" name="keyword" ng-model="package.keywords" id="keyword" style="color: black" required></textarea>
                        </form>
                    </div>
                </div>
                <div id="Amenities">
                    <div class="step-container">
                        <form  name="amenitiesForm" novalidate>
                            <h2>Choose your Amenities</h2>
                            <p style="color:red" ng-show="missing.extraMsg && (package.listAmenities.length <= 0)">Please select at least an amenities</p>
                            <div class="row choose-category">
                                <div class="col-md-2 col-sm-4 col-xs-6" ng-repeat="amenities in formContent.listAmenities">
                                    <div class="round">
                                        <div class="circle-icon">
                                            <input type="checkbox" checklist-model="package.listAmenities" checklist-value="amenities">
                                            <span style="background-image: url({{amenities.icon}})"></span>
                                        </div>
                                        <p>{{amenities.amenitiesType}}</p>
                                    </div>
                                </div>
                            </div>
                            <h2 style="margin-top: 0px">Included in the price</h2>
                            <textarea class="normalFont" type="text" name="includedPrice"
                                      placeholder="Breakfast, Luch, Dinner, Transportation... (Length: 1 ~ 200)" ng-model="package.included" 
                                      ng-maxlenght="200" maxlength="200"></textarea>
                            <h2>Excluded in the price</h2>
                            <textarea class="normalFont" type="text" name="excludedPrice" placeholder="Breakfast, Luch, Dinner, Transportation... (Length: 1 ~ 200)"
                                      ng-model="package.excluded" ng-maxlenght="200" maxlength="200"></textarea>
                            <h2>Transportation</h2>
                            <p style="color:red" ng-show="missing.extraMsg && (selectedTransportation.length <= 0)">Please select at least an transportation</p>
                            <div class="row">
                                <div class="col-md-2 col-sm-4 col-xs-6 transportation-item" ng-repeat="transportation in formContent.transportations">
                                    <div class="transportationImage" ng-class="{'hidden' : $last, 'transportationImage-active' : (selectedTransportation.indexOf(transportation.transportationID) >= 0)}" style="background-image: url('{{transportation.image}}')" >
                                    </div>
                                    <div class="transportationContent" ng-class="{'hidden' : $last}" >
                                        <div class="tempCheckbox" >
                                            <input type="checkbox" checklist-model="selectedTransportation" checklist-value="transportation.transportationID">
                                            <span></span>
                                        </div>
                                        <p >{{transportation.name}}</p>
                                    </div>
                                </div>
                            </div>
                            <div class="row"> 
                                <div class="col-md-8">
                                    <p style="width: 5%; line-height: 38px; float: left; margin-top: 8px; margin-bottom: 0;"> Or </p>
                                    <input class="normalFont round full-width" placeholder="Others transportation (Length 0 ~ 50)" type="text"
                                           maxlength="50" ng-maxlength="50" style="width: 95%"
                                           name="ohtersContent" ng-model="ohtersContent"/> 
                                </div>
                                <div class="col-md-4">

                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div id="Photos">
                    <div class="step-container">
                        <form  name="photosForm" novalidate>
                            <h2>Upload your cover photo</h2>
                            <div ngf-drop ngf-select ng-model="coverImage" class="upload-large" id="coverImage"
                                 ngf-drag-over-class="dragover" ngf-allow-dir="true"
                                 accept="image/*" style="background: #dfdfdf url({{package.coverImage + '?' + currentTime}}) no-repeat center"
                                 ngf-pattern="'image/*'">
                                <!--<div id="coverShowing">Drop cover image here or click to upload</div>-->
                                <p>This cover photo will represent to your own page</p>
                                <a href="#" class="btn-upload">
                                    Add Photo
                                </a>
                            </div>
                            <!--<div ngf-no-file-drop>File Drag/Drop is not supported for this browser</div>-->
                            <h2>Upload your other photos</h2>
                            <div id="addtionalImages" style="display: table;">
                                <div ng-repeat="image in package.images.images" class="addtionalImage" 
                                     style="background: #ffffff url({{image + '?' + currentTime}}) no-repeat center" >
                                    <a href="" ng-click="deleteAdditionalImage(image)"></a>
                                </div>
                                <div ngf-drop ngf-select ng-model="addingImage" id="addingImage" class="addtionalImage"
                                     ngf-drag-over-class="dragover" ngf-allow-dir="true"
                                     accept="image/*" ngf-multiple="true"
                                     ngf-pattern="'image/*,application/pdf'" style="position: relative">
                                    <!--                                    <div class="square-center">
                                                                            <div class="plus-sign">
                                                                            </div>
                                                                        </div>-->
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div id="Location">
                    <div class="step-container">
                        <h2>Set Your Listing Location</h2>
                        <p>
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis et vestibulum neque, id varius quam. Cum sociis natoque
                            penatibus et magnis dis parturient montes, nascetur ridiculus mus. In hac habitasse platea dictumst.
                        </p>
                        <form name="locationForm" novalidate>
                            <div style="display: none">
                                <strong>City</strong>
                                <input name="city" ng-model="package.city" class="field" id="locality"
                                       disabled="true" required></input><br/>
                                <strong class="label">State</strong>
                                <input ng-model="package.state" class="field" name="state"
                                       id="administrative_area_level_1" disabled="true" required></input><br/>
                                <strong>Country</strong>
                                <input ng-model="package.country" class="field" name="country"
                                       id="country" disabled="true" required></input><br/>
                                <strong>Coordinate</strong>
                                <input class="field" id="coordinate" ng-model="package.coordinates" name="coordinate"
                                       required></input>
                                <input class="field" id="street_number"
                                       disabled="true"></input>
                                <input class="field" id="route"
                                       disabled="true"></input>
                                <input class="field" id="postal_code"
                                       disabled="true"></input>
                            </div>
                            <div class="row">
                                <div class="col-xs-12">
                                    <input id="pac-input" class="controls normalFont" type="text" value="{{location}}"
                                           placeholder="State / City / Country"><br/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-12">
                                    <input class="normalFont" type="text" placeholder="Your Adress" />
                                </div>
                            </div>
                            <p style="color:red" ng-show="missing.locationMsg && locationForm.country.$error.required">Lost country</p>
                            <p style="color:red" ng-show="missing.locationMsg && locationForm.city.$error.required">Lost city</p>
                            <p style="color:red" ng-show="missing.locationMsg && locationForm.coordinate.$error.required">Lost coordinate</p>
                            <p style="color:red" ng-show="missing.locationMsg && locationForm.state.$error.required">Lost state</p>
                            <h2 style="margin-top:50px"> You are on map</h2>
                            <div id="map"></div>
                        </form>
                    </div>
                </div>
                <div id="Price">
                    <div class="step-container">
                        <h2>Pricing</h2>
                        <p class="line">
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis et vestibulum neque, id varius quam. Cum sociis natoque
                            penatibus et magnis dis parturient montes, nascetur ridiculus mus. In hac habitasse platea dictumst.
                        </p>
                        <form  name="priceForm" novalidate>
                            <div class="row">
                                <div class="col-md-6">
                                    <h2 style="margin-top:50px">Ordinary Price (USD/PAX) - Adult</h2>
                                    <p style="color:red" ng-show="missing.ordinaryPriceMsg && !priceForm.ordinaryPriceForAdult.$valid">Your price must be higher than 1!</p>
                                    <input class="round normalFont" type="number" min="1" name="ordinaryPriceForAdult" ng-model="package.ordinaryPriceForAdult" 
                                           placeholder="Type your Ordinary Price" required/>
                                </div>
                                <div class="col-md-6">
                                    <h2 style="margin-top:50px">Ordinary Price (USD/PAX) - Child</h2>
                                    <p style="color:red" ng-show="missing.ordinaryPriceMsg && priceForm.ordinaryPriceForChild.$error.number">Your price must be higher than 0!</p>
                                    <input class="round normalFont" type="number" min="1" name="ordinaryPriceForChild" ng-model="package.ordinaryPriceForChild" placeholder="Type your Ordinary Price"/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <h2 style="margin-top:50px">Youtripper Price (USD/PAX) - Adult</h2>
                                    <h5>{{package.ordinaryPriceForAdult - ((package.ordinaryPriceForAdult * package.youtripperPercentage) / 100) | currency}}</h5>
                                </div>
                                <div class="col-md-6">
                                    <span ng-show="package.ordinaryPriceForChild > 0">
                                        <h2 style="margin-top:50px">Youtripper Price (USD/PAX) - Child</h2>
                                        <h5>{{package.ordinaryPriceForChild - ((package.ordinaryPriceForChild * package.youtripperPercentage) / 100) | currency}}</h5>
                                    </span>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <h2 style="margin-top:50px">You Get (USD/PAX) - Adult</h2>
                                    <h5>{{package.ordinaryPriceForAdult - ((package.ordinaryPriceForAdult * package.youtripperPercentage) / 100) - ((package.ordinaryPriceForAdult * package.profitPercentage) / 100) | currency}}</h5>
                                </div>
                                <div class="col-md-6">
                                    <span ng-show="package.ordinaryPriceForChild > 0">
                                        <h2 style="margin-top:50px">You Get (USD/PAX) - Child</h2>
                                        <h5>{{package.ordinaryPriceForChild - ((package.ordinaryPriceForChild * package.youtripperPercentage) / 100) - ((package.ordinaryPriceForChild * package.profitPercentage) / 100) | currency}}</h5>
                                    </span>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div id="Calendar">
                    <div class="step-container">
                        <form name="calendarForm" novalidate>
                            <div class="row">
                                <div class="col-md-6">
                                    <h2 style="margin-top:50px">Start Date</h2>
                                    <p style="color:red" ng-show="missing.promotion && !calendarForm.from.$valid">This field must not be blank!</p>
                                    <input class="round normalFont" placeholder="Start Date" readonly="readonly"
                                           ng-model="package.startDate" type="text" id="from" name="from" required>
                                </div>
                                <div class="col-md-6">
                                    <h2 style="margin-top:50px">End Date</h2>
                                    <p style="color:red" ng-show="missing.promotion && !calendarForm.to.$valid">This field must not be blank!</p>
                                    <input class="round normalFont" placeholder="End Date" readonly="readonly"
                                           ng-model="package.endDate" type="text" id="to" name="to" required>
                                </div>
                            </div>
                            <h2>Unavailable Day</h2>
                            <div class="row">
                                <ul class="col-xs-12 unavailableDays">                              
                                    <li>
                                        <div class="tempCheckbox">
                                            <input checklist-model="package.unavailableDays" checklist-value="1" type="checkbox" name="unavailableDays" value="1" />
                                            <span></span>
                                        </div>
                                        <p>Monday</p>
                                    </li>
                                    <li>
                                        <div class="tempCheckbox">
                                            <input checklist-model="package.unavailableDays" checklist-value="2" type="checkbox" name="unavailableDays" value="2" />
                                            <span></span>
                                        </div>
                                        <p>Tuesday</p>
                                    </li>
                                    <li>
                                        <div class="tempCheckbox">
                                            <input checklist-model="package.unavailableDays" checklist-value="3" type="checkbox" name="unavailableDays" value="3" />
                                            <span></span>
                                        </div>
                                        <p>Wednesday</p>
                                    </li>
                                    <li>
                                        <div class="tempCheckbox">
                                            <input checklist-model="package.unavailableDays" checklist-value="4" type="checkbox" name="unavailableDays" value="4" />
                                            <span></span>
                                        </div>
                                        <p>Thursday</p>
                                    </li>
                                    <li>
                                        <div class="tempCheckbox">
                                            <input checklist-model="package.unavailableDays" checklist-value="5" type="checkbox" name="unavailableDays" value="5" />
                                            <span></span>
                                        </div>
                                        <p>Friday</p>
                                    </li>
                                    <li>
                                        <div class="tempCheckbox">
                                            <input checklist-model="package.unavailableDays" checklist-value="6" type="checkbox" name="unavailableDays" value="6" />
                                            <span></span>
                                        </div>
                                        <p>Saturday</p>
                                    </li>
                                    <li>
                                        <div class="tempCheckbox">
                                            <input checklist-model="package.unavailableDays" checklist-value="0" type="checkbox" name="unavailableDays" value="0" />
                                            <span></span>
                                        </div>
                                        <p>Sunday</p>
                                    </li>
                                </ul>
                            </div>
                            <div class="header">
                                <h2>Or Customize your Calendar</h2>
                                <a id="add-promotion" class="boxer addingPromotionButton" href="#full-year" style="color:black">Add Promotion</a>
                            </div>
                            <div id="promotion-form" style="display: none;">
                                <div class="promotion-content container">
                                    <div class="promotion-elements">
                                        <!--<strong>Color</strong> <input ng-model="promotionColor" name="promotionColor" id="promotionColor" value='#cc3333'/><br/>-->
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <h2>Set your adult price</h2>
                                                <input ng-model="promotionPrice" class="round normalFont"
                                                       type="text" name="promotionPrice" id="promotionPrice" placeholder="Adult price"/><br/>
                                            </div>
                                            <div class="col-sm-6">
                                                <h2>Set your child price</h2>
                                                <input ng-model="promotionSecondPrice" class="round normalFont"
                                                       type="text" name="promotionSecondPrice" id="promotionSecondPrice" placeholder="Child price"/><br/>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-12">
                                                <h2>Select promotion dates:</h2>
                                                <div id="promotion-calendar" class="box" ></div>
                                            </div>
                                        </div>
                                        <div class="row control-bar">
                                            <a class="preview" href="#full-year" id="cancel-promotion">Cancel</a>
                                            <a class="save" href="#full-year" id="apply-promotion">Apply</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="preview-calendar">
                                    <div id="protect"></div>
                                    <div id="full-year" class="box" ></div>
                                </div>
                            </div>
                            <ul class="promotions">
                                <li class="edit-promotion" ng-repeat="promotion in package.promotionJson">
                                    Adult Price: {{promotion.priceAdult| currency}}
                                    <span ng-show="(promotion.priceChild > 0)"> - Child Price: {{promotion.priceChild| currency}}</span>
                                    <a ng-click="editPromotion($index);" ofPromotion="0" href="#full-year" style="background-color: {{promotion.color}}">Edit</a>
                                </li>
                            </ul>
                            <!--<button ng-click="finishToPreview()">Finish</button>-->
                        </form>
                    </div>
                </div>
                <div class="control-bar row">
                    <a href="#" class="preview">Preview</a>
                    <button id="nextStep" class="save" ng-click="moveFoward()">Next</button>
                    <a id="finish" style="display: none" class="save" ng-click="finishToPreview()"
                       href="#full-year" id="apply-promotion">Finish</a>
                </div>
            </div>
        </div>
        <%@ include file="../footer.jsp" %>
        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.plugin.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/wow.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/clockpicker.js"/>"></script>
        <script>
                                $('.clockpicker').clockpicker({
                                    placement: 'bottom',
                                    align: 'right'
                                });
                                var packageForm = ${requestScope.packageForm};
                                var temporaryPackage = ${requestScope.temporaryPackage};
                                var saveActivitiesUrl = '<c:url value="/Provider/Package/saveActivities"/>';
                                var saveDescriptionUrl = '<c:url value="/Provider/Package/saveDescription"/>';
                                var saveExtraUrl = '<c:url value="/Provider/Package/saveExtra"/>';
                                var savePhotosUrl = '<c:url value="/Provider/Package/savePhotos"/>';
                                var saveLocationUrl = '<c:url value="/Provider/Package/saveLocation"/>';
                                var saveOrdinaryPriceUrl = '<c:url value="/Provider/Package/saveOrdinaryPrice"/>';
                                var savePromotionsUrl = '<c:url value="/Provider/Package/savePromotions"/>';
                                var uploadCoverImageUrl = '<c:url value="/Provider/Package/uploadCoverImage"/>';
                                var uploadAdditionalImagesUrl = '<c:url value="/Provider/Package/uploadAdditionalImages"/>';
                                var deleteAdditionalImageUrl = '<c:url value="/Provider/Package/deleteAdditionalImage"/>';
                                var keywordsUrl = '<c:url value="/Provider/Package/Keywords"/>';
            <c:choose>
                <c:when test="${empty param.language}">
                    var previewUrl = '<c:url value="/Provider/Package/PreView"/>';
                </c:when>
                <c:otherwise>
                    var previewUrl = '<c:url value="/Provider/Package/PreView?language=${param.language}"/>';
                </c:otherwise>
            </c:choose>
                                
                                $(document).ready(function () {
                                    toggleHeader.init({
                                    toggleControl: false
                                    });
                                    });</script>
    </body>

    <script src="https://maps.googleapis.com/maps/api/js?signed_in=true&libraries=places&&language=en&callback=initMap"
    async defer></script> 
</html>
