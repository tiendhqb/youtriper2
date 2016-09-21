<%-- 
    Document   : packageForm
    Created on : Sep 28, 2015, 3:06:27 PM
    Author     : Nick
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=1366">
<!--        <meta name="viewport" content="width=device-width, initial-scale=1">-->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>YouTripper - Create Package</title>

        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/jquery.tag-editor.css"/>" rel="stylesheet">


        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/angular.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/checklist-model.js"/>"></script>
        <script>
            var package = angular.module('package', ["checklist-model"]);
            package.controller('PackageController', function ($scope) {
                $scope.minTripper = 1;
                $scope.maxTripper = 1;
                $scope.change = function (number) {
                    if ($scope.categoriesModel.ids.indexOf(number) >= 0) {
                        for (var i = $scope.subCategoriesModel.ids.length - 1; i >= 0; i--) {
                            if ($scope.subCategoriesModel.ids[i].categoryID === number) {
                                $scope.subCategoriesModel.ids.splice(i, 1);
                            }
                        }
                    }
                };
                $scope.missing = {activityMsg: false, informationMsg: false};
                $scope.checkActivity = function () {
                    if ($scope.activitiesModel.ids.length > 0) {
                        $("#form-activity").addClass("hidden");
                        $("#form-information").removeClass("hidden");
                    } else {
                        $scope.missing.activityMsg = true;
                    }
                };
                $scope.checkInformation = function (form) {
                    if ($scope[form].packageName.$valid && $scope[form].durationNumber.$valid
                            && $scope[form].shortDescription.$valid && $scope[form].mainDescription.$valid
                            && $scope[form].maxTripper.$valid && $scope[form].minTripper.$valid
                            && $scope[form].language.$valid && $scope[form].keyword.$valid) {
                        $("#form-information").addClass("hidden");
                        $("#form-extra").removeClass("hidden");
                    } else {
                        $scope.missing.informationMsg = true;
                    }
                };
                $scope.checkExtra = function (form) {
                    $("#form-extra").addClass("hidden");
                    $("#form-location").removeClass("hidden");
                    initMap();
                };
                $scope.checkLocation = function (form) {
                    if ($scope[form].country.$valid && $scope[form].city.$valid
                            && $scope[form].state.$valid && $scope[form].coordinate.$valid) {
                        alert("Okay");
                    } else {
                        $scope.missing.locationMsg = true;
                    }
                };
                $scope.categories = ${requestScope.categories};
                $scope.subCategories = ${requestScope.subCategories};
                $scope.activities = ${requestScope.activities};
                $scope.listAmenities = ${requestScope.listAmenities};
                $scope.categoriesModel = {ids: []};
                $scope.subCategoriesModel = {ids: []};
                $scope.activitiesModel = {ids: []};
                $scope.showSubCategories = function (subCategory) {
                    return $scope.categoriesModel.ids.indexOf(subCategory.categoryID) !== -1;
                };
                $scope.showActivities = function (activitiy) {
                    var check = false;
                    $scope.subCategoriesModel.ids.forEach(function (subC) {
//                        alert(activitiy.subCategoryID === subC.subCategoryID);
                        if (activitiy.subCategoryID === subC.subCategoryID) {
                            check = true;
                        }
                    });
                    return check;
//                    return $scope.subCategoriesModel.ids.indexOf(activitiy.subCategoryID) !== -1;
                };
            });
        </script>
        <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="https://code.jquery.com/ui/1.10.2/jquery-ui.min.js"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.caret.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.tag-editor.js"/>"></script>
        <script>
            $(function () {
                $('#keyword').tagEditor({
                autocomplete: {
                source: function (request, response) {
                    $.ajax({
                        url: "http://localhost:8084/YouTripper/Package/Keywords",
                        dataType: 'json',
                        type: 'POST',
                        data: request.term,
                        contentType: 'application/json',
                        mimeType: 'application/json',
                        success: function (data) {
                            response(data);
                        },
                        error: function (data, status, er) {
                            alert("error: " + data + " status: " + status + " er:" + er);
                        }
                    });
                },
                        minLength: 2
                },
                        delimiter: ',',
                        forceLowercase: false,
                        placeholder: 'Programming languages ...',
                        onChange(field, editor, tags) {
                $("#keyword").val(tags.length ? tags.join(', ') : null);
                angular.element($('#keyword')).triggerHandler('input');
                }
            });
            })
        </script>
        <style>
            #map {
                height: 500px;
                width: 80%;
                margin: 0 auto;
            }
            .controls {
                margin-top: 10px;
                border: 1px solid transparent;
                border-radius: 2px 0 0 2px;
                box-sizing: border-box;
                -moz-box-sizing: border-box;
                height: 32px;
                outline: none;
                box-shadow: 0 2px 6px rgba(0, 0, 0, 0.3);
            }

            #pac-input {
                background-color: #fff;
                font-family: Roboto;
                font-size: 15px;
                font-weight: 300;
                margin-left: 12px;
                padding: 0 11px 0 13px;
                text-overflow: ellipsis;
                width: 300px;
            }

            #pac-input:focus {
                border-color: #4d90fe;
            }

            .pac-container {
                font-family: Roboto;
            }

            #type-selector {
                color: #fff;
                background-color: #4d90fe;
                padding: 5px 11px 0px 11px;
            }

            #type-selector label {
                font-family: Roboto;
                font-size: 13px;
                font-weight: 300;
            }

            .label {
                color: black;
            }
        </style>
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
                var map = new google.maps.Map(document.getElementById('map'), {
                    center: {lat: -33.8688, lng: 151.2195},
                    zoom: 13,
                    draggable: false
                });
                var input = /** @type {!HTMLInputElement} */(
                        document.getElementById('pac-input'));

//                map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

                var autocomplete = new google.maps.places.Autocomplete(input, {types: ['address']});
                autocomplete.bindTo('bounds', map);

                var infowindow = new google.maps.InfoWindow();
                var marker = new google.maps.Marker({
                    map: map,
                    anchorPoint: new google.maps.Point(0, -29)
                });

                marker.setIcon(/** @type {google.maps.Icon} */({
                    size: new google.maps.Size(71, 71),
                    origin: new google.maps.Point(0, 0),
                    anchor: new google.maps.Point(17, 34),
                    scaledSize: new google.maps.Size(35, 35)
                }));

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
                        map.setZoom(17);  // Why 17? Because it looks good.
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
                    document.getElementById(component).disabled = false;
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
                document.getElementById("coordinate").value = marker.getPosition().lat() + "," + marker.getPosition().lng();
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
    <body>
        <div ng-app="package" >
            <form name="packageForm"  ng-controller="PackageController" novalidate >
                <div id="form-activity" class="childForm">
                    <strong>Category</strong> <br/>
                    <ul ng-repeat="category in categories">
                        <li>
                            {{category.name}}, {{category.id}}
                            <input type="checkbox" checklist-model="categoriesModel.ids" checklist-value="category.id" ng-change="change(category.id)">
                        </li>
                    </ul>
                    <br/>
                    <strong>Sub Category</strong> <br/>
                    <ul ng-repeat="subCategory in subCategories| filter:showSubCategories">
                        <li>
                            {{subCategory.name}}, {{subCategory.subCategoryID}}
                            <input type="checkbox" checklist-model="subCategoriesModel.ids" checklist-value="subCategory" ng-model="justAnotherCheckedVar"
                                   ng-attr-ofCat="{{subCategory.categoryID}}">
                        </li>
                    </ul>
                    Result: {{subCategoriesModel.ids}}
                    <br/>
                    <strong>Activities</strong> <br/> <p style="color:red" ng-show="missing.activityMsg">Please select at least an activity</p>
                    <ul ng-repeat="activitiy in activities| filter:showActivities">
                        <li>
                            {{activitiy.name}}
                            <input type="checkbox" checklist-model="activitiesModel.ids" checklist-value="activitiy.activityID">
                        </li>
                    </ul>
                    <br/>
                    REsult: {{activitiesModel.ids}}
                    <br/>
                    <button ng-click="checkActivity()">Next</button>
                    <br/>
                </div>
                <div id="form-information" class="childForm hidden">
                    <strong>Name</strong>
                    <span style="color:red" ng-show="missing.informationMsg && packageForm.packageName.$error.required"> This field must not be blank!</span>
                    <br/>
                    <input type="text" placeholder="Name of package" name="packageName" ng-model="name" required/>
                    <br/>
                    <strong>Duration</strong>
                    <span style="color:red" ng-show="missing.informationMsg && !packageForm.durationNumber.$valid"> This field must be a number higher than 1!</span>
                    <br/>
                    <input type="number" placeholder="Number" name="durationNumber"
                           ng-model="durationNumber"  min="1"  required/>
                    <select name="packageDurationType" ng-model="packageDurationType" ng-init="packageDurationType = 0">
                        <option value="0">Hours</option>
                        <option value="1">Days</option>
                    </select>
                    <br/>
                    <strong>Short Description</strong>
                    <span style="color:red" ng-show="missing.informationMsg && packageForm.shortDescription.$error.required">This field must not be blank!</span>
                    <input type="text" placeholder="Short description (Should between 100 and 160 characters)" 
                           name="shortDescription" ng-model="shortDescription" maxlength="10" required/>
                    <br/>
                    <strong>Description</strong>
                    <span style="color:red" ng-show="missing.informationMsg && packageForm.mainDescription.$error.required">This field must not be blank!</span>
                    <input type="text" placeholder="Description" 
                           name="mainDescription" ng-model="mainDescription" required/>
                    <br/>
                    <strong>How many people can you handle?</strong>
                    <br/>
                    <span style="color:red" ng-show="missing.informationMsg && (!packageForm.minTripper.$valid || !packageForm.maxTripper.$valid)">
                        Min number of trippers must less than max number of trippers
                    </span>
                    <br/>
                    Between <input type="number" placeholder="Min" 
                                   name="minTripper"  min="1" max="{{maxTripper}}" ng-model="minTripper" required/> 
                    and
                    <input type="number" placeholder="Max" 
                           name="maxTripper" min="{{minTripper}}" ng-model="maxTripper" required/>
                    <br/>
                    <strong>Language</strong>
                    <br/>
                    <span style="color:red" ng-show="missing.informationMsg && packageForm.language.$error.required">This field must not be blank!</span>
                    <input type="text" placeholder="English, Vietnamese, Janpanese, ..." 
                           name="language" ng-model="language" maxlength="40" required/>
                    <br/>
                    <strong>Keywords</strong>
                    <br/>
                    <span style="color:red" ng-show="missing.informationMsg && packageForm.keyword.$error.required">This field must not be blank!</span>
                    <textarea name="keyword" ng-model="keyword" id="keyword" style="color: black" required></textarea>
                    <br/>
                    <button ng-click="checkInformation('packageForm')">Next</button>

                </div>
                <div id="form-extra" class="childForm hidden">
                    <strong>Amenities</strong> <br/>
                    <ul ng-repeat="amenities in listAmenities">
                        <li>
                            {{amenities.amenitiesType}}
                            <input type="checkbox" checklist-model="amenitiesModel.ids" checklist-value="amenities.amenitiesID">
                        </li>
                    </ul>
                    <br/>
                    <strong>Included in the price</strong><br/>
                    <input type="text" name="includedPrice"/>
                    <br/>
                    <strong>Included in the price</strong><br/>
                    <input type="text" name="excludedPrice"/>
                    <br/>
                    <button ng-click="checkExtra('packageForm')">Next</button>
                </div>
                <div id="form-location" class="childForm hidden">

                    <table id="address" style="display: none;">
                        <tr>
                            <td class="label">Street address</td>
                            <td class="slimField">
                                <input class="field" id="street_number"
                                       disabled="true"></input>
                            </td>
                            <td class="wideField" colspan="2"><input class="field" id="route"
                                                                     disabled="true"></input>
                            </td>
                        </tr>
                        <tr>
                            <td class="label">City</td> 
                            <td class="wideField" colspan="3">
                                <input name="city" ng-model="city" class="field" id="locality"
                                       disabled="true" required></input>
                            </td>
                        </tr>
                        <tr>
                            <td class="label">State</td>
                            <td class="slimField">
                                <input ng-model="state" class="field" name="state"
                                       id="administrative_area_level_1" disabled="true" required></input>
                            </td>
                            <td class="label">Zip code</td>
                            <td class="wideField"><input class="field" id="postal_code"
                                                         disabled="true"></input>
                            </td>
                        </tr>
                        <tr>
                            <td class="label">Country</td>
                            <td class="wideField" colspan="3">
                                <input ng-model="country" class="field" name="country"
                                       id="country" disabled="true" required></input>
                            </td>
                            <td class="label">Coordinate</td>
                            <td class="wideField">
                                <input class="field" id="coordinate" ng-model="coordinate" name="coordinate"
                                       required></input>
                            </td>
                        </tr>
                    </table>

                    <input id="pac-input" class="controls" type="text"
                           placeholder="Enter a location"><br/>
                    <p style="color:red" ng-show="missing.locationMsg && packageForm.country.$error.required">Lost country</p><br/>
                    <p style="color:red" ng-show="missing.locationMsg && packageForm.city.$error.required">Lost city</p><br/>
                    <p style="color:red" ng-show="missing.locationMsg && packageForm.coordinate.$error.required">Lost coordinate</p><br/>
                    <p style="color:red" ng-show="missing.locationMsg && packageForm.state.$error.required">Lost state</p><br/>

                    <div id="map"></div>


                    <button ng-click="checkLocation('packageForm')">Next</button>
                </div>
            </form>
        </div>
        <!--        <style>
                    #map {
                        display: none;
                    }
                </style>-->

        <script src="https://maps.googleapis.com/maps/api/js?signed_in=true&libraries=places&callback=initMap"
        async defer></script>   
    </body>
</html>
