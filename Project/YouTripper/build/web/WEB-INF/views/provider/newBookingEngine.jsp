<%-- 
    Document   : bookingEngine
    Created on : Mar 18, 2016, 3:44:10 PM
    Author     : Nick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=1366">
        <!--        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1">-->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>YouTripper - Booking Engine</title>
        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>">
        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">

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

        <script src="<c:url value="/Resources/Theme/js/jquery.fs.boxer.js"/>"></script>

        <script src="<c:url value="/Resources/Theme/js/jquery.cookie-1.3.1.js"/>"></script>

        <script src="<c:url value="/Resources/Theme/js/jquery.caret.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.tag-editor.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.simple-color.js"/>"></script>

        <script src="<c:url value="/Resources/Theme/js/jquery.inputmask.bundle.min.js"/>"></script>

        <!--SOCKET-->
        <script src="<c:url value="/Resources/Theme/js/sockjs-0.3.4.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/stomp.js"/>"></script>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

        <style>
            html,body,.bookingEngineContainer, #bookingEngineTable, #tableScroll, #tablePadding {
                height: 100%;
            }

            #tableScroll {
                overflow-y: auto;
                overflow-x: hidden;
                position: relative;
            }

            #tableScroll.noScroll {
                overflow: hidden;
            }

            .ui-datepicker-multi-2 .ui-datepicker-group {
                width: auto;
            }

            .ui-datepicker.ui-datepicker-multi .ui-datepicker-header {
                height: auto;
            }

            .ui-datepicker.ui-datepicker-multi tbody td span, .ui-datepicker.ui-datepicker-multi tbody td a {
                line-height: inherit;
            }
        </style>
    </head>
    <body ng-app="YouTripper" ng-controller="NewBookingEngine" >
        <div style="position: fixed; top: 0; bottom: 0; left: 0; right: 0; background: #fff; z-index: 99999" ng-show="loading">
            <div class="youtripper-spinner" ></div>
        </div>

        <div ng-cloak ng-hide="loading" class="bookingEngineContainer pagesearch">
            <%@ include file="../header.jsp" %>
            <div class='bookingQuickCalendar'>
                <div class="calendar-ctrs">
                    <div class="row">
                        <div class="col-xs-6">
                            <div class="calendar-ctr">
                                <a href="" class="orange-link" ng-click="previousMonthOfCalendar()">Prev</a>
                            </div>
                        </div>
                        <div class="col-xs-6">
                            <div class="calendar-ctr">
                                <a href="" class="orange-link" ng-click="nextMonthOfCalendar()">Next</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="datepicker"></div>
                <div ng-switch on="viewSale">
                    <div ng-switch-when="true">
                        <ng-include onload="initCalendarForSale()" src="'<c:url value="/Provider/SalesLeft"/>'"></ng-include>
                    </div>
                </div>
            </div>

            <div class="ytPopup hasLabel" id="offlineBookingBox">
                <div class="tbl-cell noClick">
                    <div class="popupContent">

                        <div class="center-informBlock blur-backgroud" ng-show="savingProcess">
                            <div class="small-spinner" ></div>
                        </div>

                        <span class="box-closing" ng-click="toggleAddingBox()"></span>
                        <div class="popupStep" ng-show="informationStep">
                            <h4>Fill your booking informaion</h4>

                            <div class="popupRow">
                                <div class="row">
                                    <div class="col-xs-12">

                                        <div class="multi-popupRow label-row">
                                            <div class="row">
                                                <div class="col-xs-12">
                                                    <span>Duration*</span>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="multi-popupRow">
                                            <div class="row">
                                                <div class="col-xs-6">
                                                    <select class="blueInput" ng-model="offlineDurationType" ng-change="durationTypeChanged()"
                                                            ng-class="{'hasError' : addingBookingErrorMsgs['durationType']}">
                                                        <option value="">Duration Type</option>
                                                        <option value="days">Day</option>
                                                        <option value="hours">Hour and Minute</option>
                                                    </select>
                                                </div>

                                                <div class="col-xs-6">
                                                    <div class="day-input" ng-show="offlineDurationType === 'days'">
                                                        <input class="normalFont blueInput" ng-class="{'hasError' : addingBookingErrorMsgs['days']}"
                                                               placeholder="Number of days"
                                                               type="text" ng-model="offlineDays" numbers-only/>
                                                    </div>

                                                    <div class="hour-input clearfix" ng-show="offlineDurationType === 'hours'">
                                                        <div>
                                                            <select class="blueInput"  ng-class="{'hasError' : addingBookingErrorMsgs['hours']}"
                                                                    convert-to-number ng-model="offlineHours">
                                                                <option value="0">Hours</option>
                                                                <option value="1">1 hour</option>
                                                                <option value="2">2 hours</option>
                                                                <option value="3">3 hours</option>
                                                                <option value="4">4 hours</option>
                                                                <option value="5">5 hours</option>
                                                                <option value="6">6 hours</option>
                                                                <option value="7">7 hours</option>
                                                                <option value="8">8 hours</option>
                                                                <option value="9">9 hours</option>
                                                                <option value="10">10 hours</option>
                                                                <option value="11">11 hours</option>
                                                                <option value="12">12 hours</option>
                                                                <option value="13">13 hours</option>
                                                                <option value="14">14 hours</option>
                                                                <option value="15">15 hours</option>
                                                                <option value="16">16 hours</option>
                                                                <option value="17">17 hours</option>
                                                                <option value="18">18 hours</option>
                                                                <option value="19">19 hours</option>
                                                                <option value="20">20 hours</option>
                                                                <option value="21">21 hours</option>
                                                                <option value="22">22 hours</option>
                                                                <option value="23">23 hours</option>
                                                            </select>
                                                        </div>

                                                        <div>
                                                            <select class="blueInput"  ng-class="{'hasError' : addingBookingErrorMsgs['minutes']}"
                                                                    convert-to-number  ng-model="offlineMinutes">
                                                                <option value="0">Minutes</option>
                                                                <option value="5">5 minutes</option>
                                                                <option value="10">10 minutes</option>
                                                                <option value="15">15 minutes</option>
                                                                <option value="20">20 minutes</option>
                                                                <option value="25">25 minutes</option>
                                                                <option value="30">30 minutes</option>
                                                                <option value="35">35 minutes</option>
                                                                <option value="40">40 minutes</option>
                                                                <option value="45">45 minutes</option>
                                                                <option value="50">50 minutes</option>
                                                                <option value="55">55 minutes</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>


                                    </div>
                                </div>
                            </div>


                            <div class="popupRow">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <div class="multi-popupRow label-row">
                                            <div class="row">
                                                <div class="col-xs-6">
                                                    Package Date*
                                                </div>
                                                <div class="col-xs-6" ng-show="offlineDurationType !== 'days'">
                                                    Package Time*
                                                </div>
                                            </div>
                                        </div>

                                        <div class="multi-popupRow">
                                            <div class="row">
                                                <div class="col-xs-6">
                                                    <input type="text" placeholder="Date" class="normalFont blueInput dateMaskInput"
                                                           ng-class="{'hasError' : addingBookingErrorMsgs['packageDate']}"
                                                           id="package-date-input"  ng-model="packageDate"/>
                                                </div>
                                                <div class="col-xs-6" ng-show="offlineDurationType !== 'days'">
                                                    <input type="text" placeholder="Time" class="normalFont blueInput" maxlength="5" id="package-time-input"
                                                           ng-class="{'hasError' : addingBookingErrorMsgs['packageTime']}"
                                                           ng-model="packageTime" ng-keydown="checkTimeRegex($event)"
                                                           ng-click="checkTimePosition()"/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="popupRow">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <div class="multi-popupRow label-row">
                                            <div class="row">
                                                <div class="col-xs-6">
                                                    Customer Name*
                                                </div>
                                                <div class="col-xs-6">
                                                    Customer Phone*
                                                </div>
                                            </div>
                                        </div>

                                        <div class="multi-popupRow">
                                            <div class="row">
                                                <div class="col-xs-6">
                                                    <input type="text" name="" value="" class="normalFont blueInput"
                                                           ng-class="{'hasError' : addingBookingErrorMsgs['customerName']}"
                                                           ng-model="customerName" maxlength="10" id="packageNameInput"
                                                           placeholder="Name"/>
                                                </div>
                                                <div class="col-xs-6">
                                                    <input type="text" name="" value="" class="normalFont blueInput" 
                                                           ng-class="{'hasError' : addingBookingErrorMsgs['customerPhone']}"
                                                           ng-model="customerPhone" maxlength="20" id="packagePhoneInput"
                                                           placeholder="Phone"/>
                                                </div>
                                            </div>
                                        </div>


                                    </div>
                                </div>
                            </div>


                            <div class="popupRow">
                                <div class="row">
                                    <div class="col-xs-12">

                                        <div class="multi-popupRow label-row">
                                            <div class="row">
                                                <div class="col-xs-12">
                                                    Customer Email
                                                </div>
                                            </div>
                                        </div>
                                        <div class="multi-popupRow">
                                            <div class="row">
                                                <div class="col-xs-12">
                                                    <input type="text" name="" value="" class="normalFont blueInput"  placeholder="Email"
                                                           ng-model="customerEmail" maxlength="150" />
                                                </div>
                                            </div>
                                        </div>



                                    </div>
                                </div>
                            </div>

                            <!--                        <div class="popupRow">
                                                        <div class="row">
                                                            <div class="col-xs-12">
                            
                                                                <input type="text" name="" value="" class="normalFont blueInput"  ng-model="resourceNote" maxlength="15"
                                                                       placeholder="Resource Note"/>
                            
                                                            </div>
                                                        </div>
                                                    </div>-->
                            <div class="popupRow btn-row">
                                <div class="row">
                                    <div class="col-xs-12">

                                        <a href="" ng-click="nextToTrippSource()" class="btn-width-orange">Next to TrippSoucre</a>

                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="popupStep" ng-show="!informationStep">
                            <h4>Assign TrippSource</h4>

                            <div class="popupRow">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <div class="resource-selection">
                                            <div class="multi-popupRow" ng-repeat="resource in trippSources">
                                                <div class="row">
                                                    <div class="col-xs-12">

                                                        <div class="single-resource">
                                                            <div class="resource-name single-resource-row">
                                                                <div class="tempCheckbox blueInput">
                                                                    <input type="checkbox"  ng-model="resource.selected"
                                                                           ng-change="detectWhenCheckedResourcechange($index)" ng-true-value="true" ng-false-value="false">
                                                                    <span></span>
                                                                    <!--                                                        <input type="checkbox" checklist-value="skill.skillID" 
                                                                                                                                   checklist-model="providerResource.skillIDs">-->
                                                                </div>
                                                                <p>{{resource.name}}</p>
                                                            </div>
<!--                                                            <div class="resource-duration  single-resource-row" ng-show="resource.selected">
                                                                <div class="row">
                                                                    <div class="col-xs-6">
                                                                        <select class="blueInput" ng-class="{'hasError' : resource['durationTypeError']}"
                                                                                ng-model="resource.durationType" ng-change="detectWhenResourceDurationTypeChange($index)">
                                                                            <option value="">Duration Type</option>
                                                                            <option value="days">Day</option>
                                                                            <option value="hours">Hour and Minute</option>
                                                                        </select>
                                                                    </div>

                                                                    <div class="col-xs-6">
                                                                        <div class="day-input" ng-show="resource.durationType === 'days'">
                                                                            <input class="normalFont blueInput" placeholder="Number of days"
                                                                                   ng-class="{'hasError' : resource['daysError']}"
                                                                                   type="text" ng-model="resource.days" numbers-only/>
                                                                        </div>

                                                                        <div class="hour-input clearfix" ng-show="resource.durationType === 'hours'">
                                                                            <div>
                                                                                <select class="blueInput" convert-to-number 
                                                                                        ng-class="{'hasError' : resource['hoursError']}"
                                                                                        ng-model="resource.hours">
                                                                                    <option value="0">Hours</option>
                                                                                    <option value="1">1 hours</option>
                                                                                    <option value="2">2 hours</option>
                                                                                    <option value="3">3 hours</option>
                                                                                    <option value="4">4 hours</option>
                                                                                    <option value="5">5 hours</option>
                                                                                    <option value="6">6 hours</option>
                                                                                    <option value="7">7 hours</option>
                                                                                    <option value="8">8 hours</option>
                                                                                    <option value="9">9 hours</option>
                                                                                    <option value="10">10 hours</option>
                                                                                    <option value="11">11 hours</option>
                                                                                    <option value="12">12 hours</option>
                                                                                    <option value="13">13 hours</option>
                                                                                    <option value="14">14 hours</option>
                                                                                    <option value="15">15 hours</option>
                                                                                    <option value="16">16 hours</option>
                                                                                    <option value="17">17 hours</option>
                                                                                    <option value="18">18 hours</option>
                                                                                    <option value="19">19 hours</option>
                                                                                    <option value="20">20 hours</option>
                                                                                    <option value="21">21 hours</option>
                                                                                    <option value="22">22 hours</option>
                                                                                    <option value="23">23 hours</option>
                                                                                </select>
                                                                            </div>

                                                                            <div>
                                                                                <select class="blueInput" convert-to-number
                                                                                        ng-class="{'hasError' : resource['miutesError']}"
                                                                                        ng-model="resource.minutes">
                                                                                    <option value="0">Minutes</option>
                                                                                    <option value="5">5 minutes</option>
                                                                                    <option value="10">10 minutes</option>
                                                                                    <option value="15">15 minutes</option>
                                                                                    <option value="20">20 minutes</option>
                                                                                    <option value="25">25 minutes</option>
                                                                                    <option value="30">30 minutes</option>
                                                                                    <option value="35">35 minutes</option>
                                                                                    <option value="40">40 minutes</option>
                                                                                    <option value="45">45 minutes</option>
                                                                                    <option value="50">50 minutes</option>
                                                                                    <option value="55">55 minutes</option>
                                                                                </select>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>-->
                                                            <div class="resource-units  single-resource-row"  ng-show="resource.selected">
                                                                <input class="normalFont blueInput" placeholder="Number of units" type="text"
                                                                       ng-class="{'hasError' : resource['unitsError']}"
                                                                       ng-model="resource.noUnits"  numbers-only/>
                                                            </div>
                                                        </div>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="popupRow btn-row">
                                <div class="row">
                                    <div class="col-xs-6">
                                        <a href="" ng-click="backToInformation()" class="btn-width-orange login_gg">Back</a>
                                    </div>
                                    <div class="col-xs-6">
                                        <a href="" ng-click="addOfflineBooking()" class="btn-width-orange">Add</a>
                                    </div>
                                </div>
                            </div>
                        </div>


                    </div>
                </div>
            </div>


            <div class="ytPopup" id="addingBookingBox">
                <div class="tbl-cell noClick">
                    <div class="popupContent">

                        <div class="center-informBlock blur-backgroud" ng-show="addingProcessing">
                            <div class="small-spinner" ></div>
                        </div>
                        <span class="box-closing" ng-click="toggleAddingBox()"></span>
                        <h4>Adding your booking</h4>

                        <div class="popupRow" ng-show="isParticularPackage">
                            <div class="row">
                                <div class="col-xs-12" >

                                    <strong>Package Name:</strong> {{addingPackageName}}

                                </div>
                            </div>
                        </div>

                        <div class="popupRow">
                            <div class="row">
                                <div class="col-xs-12">

                                    <div class="row">
                                        <div class="col-xs-6" id="timeInput">
                                            <select ng-show="listOfAvailableTimes.length > 0" name="" class="blueInput normalFont" ng-model="tripTime" ng-change="detectAddingChange()">
                                                <option value="">Select time</option>
                                                <option ng-repeat="time in listOfAvailableTimes" ng-value="time">{{time}}</option>
                                            </select>
                                            <span ng-hide="listOfAvailableTimes.length > 0" style="line-height: 40px">
                                                Date: {{selectedDate.MMddyyyy()}}
                                            </span>
                                        </div>
                                        <div class="col-xs-6"  ng-show="!isParticularPackage" id="packageIDInput">
                                            <select name="addingPackageID" class="blueInput normalFont" ng-model="addingPackageID"  ng-change="detectAddingChange()" convert-to-number>
                                                <option value="0">Choose your package</option>
                                                <option ng-repeat="package in availablePackages" value="{{package.id}}">{{package.packageName}}</option>
                                            </select>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>

                        <div class="popupRow">
                            <div class="row">
                                <div class="col-xs-12">

                                    <input type="text" name="" value="" class="normalFont blueInput"  ng-model="noChosenPackages" numbers-only id="noPackagesInput"
                                           placeholder="Number of packages"/>

                                </div>
                            </div>
                        </div>

                        <div class="popupRow">
                            <div class="row">
                                <div class="col-xs-12">

                                    <input type="text" name="" value="" class="normalFont blueInput"  ng-model="customerName" maxlength="10" id="packageNameInput"
                                           placeholder="Name"/>

                                </div>
                            </div>
                        </div>

                        <div class="popupRow">
                            <div class="row">
                                <div class="col-xs-12">

                                    <input type="text" name="" value="" class="normalFont blueInput"  ng-model="customerPhone" maxlength="20" id="packagePhoneInput"
                                           placeholder="Phone"/>

                                </div>
                            </div>
                        </div>

                        <div class="popupRow">
                            <div class="row">
                                <div class="col-xs-12">

                                    <input type="text" name="" value="" class="normalFont blueInput"  ng-model="customerEmail" maxlength="100" 
                                           placeholder="Email"/>

                                </div>
                            </div>
                        </div>

                        <div class="popupRow">
                            <div class="row">
                                <div class="col-xs-12">

                                    <input type="text" name="" value="" class="normalFont blueInput"  ng-model="resourceNote" maxlength="15"
                                           placeholder="Resource Note"/>

                                </div>
                            </div>
                        </div>

                        <div class="popupRow">
                            <div class="row">
                                <div class="col-xs-12">

                                    <a href="" ng-click="addEngineBooking()" class="btn-width-orange">Add</a>

                                </div>
                            </div>
                        </div>

                    </div>

                </div>
            </div>

            <div class="ytPopup" id="newOfflineBox">
                <div class="tbl-cell noClick">
                    <div class="popupContent">
                        <div class="center-informBlock blur-backgroud" ng-show="newPackageProcessing">
                            <div class="small-spinner" ></div>
                        </div>
                        <span class="box-closing" ng-click="toggleNewOfflineBox()"></span>
                        <h4>Adding new offline package</h4>
                        <div class="popupScroll">

                            <div class="popupRow">
                                <div class="row">
                                    <div class="col-xs-12">

                                        <input type="text" name="" value="" class="normalFont blueInput"  ng-model="newPackageName" maxlength="50"
                                               id="newPkgNameInput"  placeholder="Package offline name"/>

                                    </div>
                                </div>
                            </div>

                            <div class="popupRow">
                                <div class="row">
                                    <div class='col-xs-12'>
                                        <div class='row'>
                                            <div class='col-xs-6'>
                                                <select class="blueInput normalFont" ng-model="newPackageResource" convert-to-number id="newReIDInput">
                                                    <option value="0">Choose your resource</option>
                                                    <option ng-repeat="resource in dataJson.data.resources" value="{{resource.resourceID}}">{{resource.name}}</option>
                                                </select>
                                            </div>
                                            <div class='col-xs-6'>
                                                <input type="text" name="" value="" class="normalFont blueInput"  ng-model="newPackageMinimumResource" numbers-only
                                                       id="noMinReInput"   placeholder="Minimum resource"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="popupRow">
                                <div class="row">
                                    <div class='col-xs-12'>
                                        <div class='row'>
                                            <div class='col-xs-6'>
                                                <select class="blueInput normalFont" ng-model="newPackageDurationType"  id="newPackageDuTypeInput">
                                                    <option value="">Duration type</option>
                                                    <option value="minutes">Minute</option>
                                                    <option value="days">Day</option>
                                                    <option value="hours">Hour</option>
                                                </select>
                                            </div>
                                            <div class='col-xs-6'>
                                                <input type="text" name="" value="" class="normalFont blueInput"  ng-model="newPackageDuration" numbers-only 
                                                       id="newDurationInput"
                                                       placeholder="Duration"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="popupRow">
                                <div class="row">
                                    <div class="col-xs-12">

                                        <a href="" ng-click="addNewOfflinePackage()" class="btn-width-orange">Add</a>

                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

            <div id="bookingEngineContent" class="">
                <div class="bookingEngineContainer">
                    <!--<a class="href-orange" href="" ng-click="viewSaleFunc()">{{viewSaleFlag}}</a>-->
                    <div id="bookingEngineCtrs">
                        <div id="bookingTypeView">
                            <ul class="clearfix">
                                <li class="radio-col">
                                    <input type="radio" name="groupTypes" ng-model="viewType" value="day" ng-change="viewChange()">
                                    <a href="" ng-click="">Day View</a>
                                </li>
                                <li class="radio-col">
                                    <input type="radio" name="groupTypes" ng-model="viewType" value="week" ng-change="viewChange()">
                                    <a href="" ng-click="">Week View</a>
                                </li>
                                <li class="radio-col">
                                    <input type="radio" name="groupTypes" ng-model="viewType" value="month" ng-change="viewChange()">
                                    <a href="" ng-click="">Month View</a>
                                </li>
                                <li class="radio-col">
                                    <input type="radio" name="groupTypes" ng-model="viewType" value="year" ng-change="viewChange()">
                                    <a href="" ng-click="">Year View</a>
                                </li>
                                <li>
                                    <a href="" class="orange-link" id="newOfflineLink" ng-click="newBookingBox()">New Booking</a>
                                </li>
                            </ul>
                        </div>
                        <div id="viewTypeCtrs">
                            <div class="packageCtr">
                                <div class="packagesDdl">
                                    <div class="dpackageDdlSelect" ng-click="showDDlMenu()">
                                        <span class="ddlPackageDot" style="background-color: rgb({{ddpSelectedPackage.color}})"></span> <span>{{ddpSelectedPackage.packageName}}</span>
                                    </div>
                                    <div class="packageDdlMenu">
                                        <ul>
                                            <li>
                                                <a href="" ng-click="changeSelectedPackage(0)">
                                                    All packages
                                                </a>
                                            </li>
                                            <li ng-repeat="package in dataJson.data.onlinePackages">
                                                <a href="" ng-click="changeSelectedPackage(package.packageID)">
                                                    <span class="ddlPackageDot" style="background-color: rgb({{package.color}})"></span> {{package.packageName}}
                                                </a>
                                            </li>
                                            <!--                                            <li ng-repeat="package in dataJson.data.offlinePackages">
                                                                                            <a href="" ng-click="changeSelectedPackage(-package.packageID)">
                                                                                                <span class="ddlPackageDot" style="background-color: rgb({{package.color}})"></span> {{package.packageName}}
                                                                                            </a>
                                                                                        </li>-->
                                            <li>
                                                <a href="" ng-click="changeSelectedPackage(-1)">
                                                    <span class="ddlPackageDot" style="background-color: #364f6b"></span> Offline booking
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="viewTimeCtr">
                                    <div ng-show="viewType === 'day'">
                                        <span class="viewTimeTxt" id="dayViewTime">{{selectedDate.getDate()}} {{month_of_year[selectedDate.getMonth()]}},{{selectedDate.getFullYear()}}</span>
                                        <a href="" class="orange-link" ng-click="previousDate()">< Previous</a>
                                        <a href="" class="orange-link" ng-click="nextDate()">Next ></a>
                                    </div>
                                    <div ng-show="viewType === 'month'">
                                        <span class="viewTimeTxt" id="monthTime">{{month_of_year[selectedDate.getMonth()]}}, {{selectedDate.getFullYear()}}</span>
                                        <a href="" class="orange-link" ng-click="previousMonth()">< Previous</a>
                                        <a href="" class="orange-link" ng-click="nextMonth()">Next ></a> 
                                    </div>
                                    <div ng-show="viewType === 'week'">
                                        <span class="viewTimeTxt">
                                            {{month_of_year[fromWeekDate.getMonth()]}} {{fromWeekDate.getDate()}}, {{fromWeekDate.getFullYear()}} - 
                                            {{month_of_year[toWeekDate.getMonth()]}} {{toWeekDate.getDate()}}, {{toWeekDate.getFullYear()}} 
                                        </span>
                                        <a href="" class="orange-link" ng-click="previousWeek()">< Previous</a>
                                        <a href="" class="orange-link" ng-click="nextWeek()">Next ></a> 
                                    </div>
                                    <div ng-show="viewType === 'year'">
                                        <span class="viewTimeTxt">{{selectedDate.getFullYear()}}</span>
                                        <a href="" class="orange-link" ng-click="previousYear()">< Previous</a>
                                        <a href="" class="orange-link" ng-click="nextYear()">Next ></a> 
                                    </div>
                                </div>
                            </div>

                            <!--                            <div id="nowResourcesLeftBox">
                                                            <div id="nowResourcesLeftTable">
                                                                <div>
                                                                    <div ng-repeat="(resourceID, resource) in nowResourcesLeft" ng-if="nowResourceIndex === $index">
                                                                        <div>{{resource.name}}</div>
                                                                        <div>No. resources: {{resource.noPeople}}</div>
                                                                    </div>
                                                                </div>
                                                                <div class="noewResourcesCtr">
                                                                    <div>
                                                                        <a href="" ng-click="upNowResource()">Up</a>
                                                                    </div>
                                                                    <div>
                                                                        <a href="" ng-click="downNowResource()">Down</a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>-->
                        </div>
                    </div>
                    <div id="tablePadding">
                        <div id="tableScroll" ng-class="{
                                'noScroll'
                                : viewChanging}">
                            <div class="center-informBlock blur-backgroud" ng-show="viewChanging" ng-style="{
                                    'top' : spinnerTop + 'px'}">
                                <div class="small-spinner" ></div>
                            </div>
                            <div ng-show="viewType === 'day'" class="viewContent" id="dayViewContent">
                                <style>
                                    .remainingResourceBox .center-informBlock {
                                        opacity: 0;
                                    }

                                    .remainingResourceBox.loading .center-informBlock {
                                        opacity: 1;
                                    }

                                    .remainingResourceBox .resourceInfo {
                                        display: inherit;
                                    }

                                    .remainingResourceBox.loading .resourceInfo {
                                        display: none;
                                    }
                                </style>
                                <div class="remainingResourceBox">
                                    <div class="center-informBlock">
                                        <div class="small-spinner" ></div>
                                    </div>
                                    <div class="resourceInfo" ng-repeat="(resourceID, remainingResource) in remainingResources">
                                        {{remainingResource.name}} : {{remainingResource.noPeople}} 
                                    </div>
                                </div>
                                <table class="table dayTable active">
                                    <tbody>
                                    </tbody>
                                </table>
                                <div id="nowTimeLine">

                                </div>
                            </div>
                            <div ng-show="viewType === 'month'" class="viewContent">
                                <table class="monthTable active">
                                    <thead>
                                        <tr>
                                            <th>Sunday</th>
                                            <th>Monday</th>
                                            <th>Tuesday</th>
                                            <th>Wednesday</th>
                                            <th>Thursday</th>
                                            <th>Friday</th>
                                            <th>Saturday</th>
                                        </tr>
                                    </thead>    
                                    <tbody>
                                    </tbody>
                                </table>
                            </div>
                            <div ng-show="viewType === 'week'" class="viewContent">                  
                                <div class="weekTableCover active">
                                    <div class="weekTableHeader">
                                        <table class="weekTable">
                                            <thead>
                                                <tr>
                                                    <th>Sunday</th>
                                                    <th>Monday</th>
                                                    <th>Tuesday</th>
                                                    <th>Wednesday</th>
                                                    <th>Thursday</th>
                                                    <th>Friday</th>
                                                    <th>Saturday</th>
                                                </tr>
                                            </thead>    
                                            <tbody>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="weekBodyCover">
                                        <table class="weekBookings" id="weekBookings">
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div ng-show="viewType === 'year'" class="viewContent">                     
                                <table class="yearTable">
                                    <tr>
                                        <td ng-click='moveToMonthView(0)'>
                                            <div class="yearDetail">
                                                <div class="monthName">
                                                    January
                                                </div>
                                                <div ng-if='noYearPackageBookings["0/" + selectedDate.getFullYear()][selectedPackageID]' class="yearDetailBookings">
                                                    No bookings: <span>{{noYearPackageBookings["0/" + selectedDate.getFullYear()][selectedPackageID]}}</span>
                                                </div>
                                            </div>
                                        </td>
                                        <td ng-click='moveToMonthView(1)'>
                                            <div class="yearDetail">
                                                <div class="monthName">
                                                    February
                                                </div>
                                                <div ng-if='noYearPackageBookings["1/" + selectedDate.getFullYear()][selectedPackageID]' class="yearDetailBookings">
                                                    No bookings: <span>{{noYearPackageBookings["1/" + selectedDate.getFullYear()][selectedPackageID]}}</span>
                                                </div>
                                            </div>
                                        </td>
                                        <td  ng-click='moveToMonthView(2)'>
                                            <div class="yearDetail">
                                                <div class="monthName">
                                                    March
                                                </div>
                                                <div ng-if='noYearPackageBookings["2/" + selectedDate.getFullYear()][selectedPackageID]' class="yearDetailBookings">
                                                    No bookings: <span>{{noYearPackageBookings["2/" + selectedDate.getFullYear()][selectedPackageID]}}</span>
                                                </div>
                                            </div>
                                        </td>
                                        <td ng-click='moveToMonthView(3)'>
                                            <div class="yearDetail">
                                                <div class="monthName">
                                                    April
                                                </div>
                                                <div ng-if='noYearPackageBookings["3/" + selectedDate.getFullYear()][selectedPackageID]' class="yearDetailBookings">
                                                    No bookings: <span>{{noYearPackageBookings["3/" + selectedDate.getFullYear()][selectedPackageID]}}</span>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td  ng-click='moveToMonthView(4)'>
                                            <div class="yearDetail">
                                                <div class="monthName">
                                                    May
                                                </div>
                                                <div ng-if='noYearPackageBookings["4/" + selectedDate.getFullYear()][selectedPackageID]' class="yearDetailBookings">
                                                    No bookings: <span>{{noYearPackageBookings["4/" + selectedDate.getFullYear()][selectedPackageID]}}</span>
                                                </div>
                                            </div>
                                        </td>
                                        <td ng-click='moveToMonthView(5)'>
                                            <div class="yearDetail">
                                                <div class="monthName">
                                                    June
                                                </div>
                                                <div ng-if='noYearPackageBookings["5/" + selectedDate.getFullYear()][selectedPackageID]' class="yearDetailBookings">
                                                    No bookings: <span>{{noYearPackageBookings["5/" + selectedDate.getFullYear()][selectedPackageID]}}</span>
                                                </div>
                                            </div>
                                        </td>
                                        <td ng-click='moveToMonthView(6)'>
                                            <div class="yearDetail">
                                                <div class="monthName">
                                                    July
                                                </div>
                                                <div ng-if='noYearPackageBookings["6/" + selectedDate.getFullYear()][selectedPackageID]' class="yearDetailBookings">
                                                    No bookings: <span>{{noYearPackageBookings["6/" + selectedDate.getFullYear()][selectedPackageID]}}</span>
                                                </div>
                                            </div>
                                        </td>
                                        <td ng-click='moveToMonthView(7)'>
                                            <div class="yearDetail">
                                                <div class="monthName">
                                                    August
                                                </div>
                                                <div ng-if='noYearPackageBookings["7/" + selectedDate.getFullYear()][selectedPackageID]' class="yearDetailBookings">
                                                    No bookings: <span>{{noYearPackageBookings["7/" + selectedDate.getFullYear()][selectedPackageID]}}</span>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td ng-click='moveToMonthView(8)'>
                                            <div class="yearDetail">
                                                <div class="monthName">
                                                    September
                                                </div>
                                                <div ng-if='noYearPackageBookings["8/" + selectedDate.getFullYear()][selectedPackageID]' class="yearDetailBookings">
                                                    No bookings: <span>{{noYearPackageBookings["8/" + selectedDate.getFullYear()][selectedPackageID]}}</span>
                                                </div>
                                            </div>
                                        </td>
                                        <td ng-click='moveToMonthView(9)'>
                                            <div class="yearDetail">
                                                <div class="monthName">
                                                    October
                                                </div>
                                                <div ng-if='noYearPackageBookings["9/" + selectedDate.getFullYear()][selectedPackageID]' class="yearDetailBookings">
                                                    No bookings: <span>{{noYearPackageBookings["9/" + selectedDate.getFullYear()][selectedPackageID]}}</span>
                                                </div>
                                            </div>
                                        </td>
                                        <td ng-click='moveToMonthView(10)'>
                                            <div class="yearDetail">
                                                <div class="monthName">
                                                    November
                                                </div>
                                                <div ng-if='noYearPackageBookings["10/" + selectedDate.getFullYear()][selectedPackageID]' class="yearDetailBookings">
                                                    No bookings: <span>{{noYearPackageBookings["10/" + selectedDate.getFullYear()][selectedPackageID]}}</span>
                                                </div>
                                            </div>
                                        </td>
                                        <td ng-click='moveToMonthView(11)'>
                                            <div class="yearDetail">
                                                <div class="monthName">
                                                    December
                                                </div>
                                                <div ng-if='noYearPackageBookings["11/" + selectedDate.getFullYear()][selectedPackageID]' class="yearDetailBookings">
                                                    No bookings: <span>{{noYearPackageBookings["11/" + selectedDate.getFullYear()][selectedPackageID]}}</span>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div ng-switch on="viewSale">
                        <div ng-switch-when="true">
                            <ng-include src="'<c:url value="/Provider/Sales"/>'"></ng-include>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </body>
    <script>
        var dataJson = ${requestScope.bookingData};
        var providerID = ${sessionScope.account.id};
        var updateSaleURL = '<c:url value="/Provider/updateSale"/>';
        var packages = '${requestScope.packages}';
        var sales = "";
        var timeNowVar = '${requestScope.timeNow}'
    </script>
</html>
