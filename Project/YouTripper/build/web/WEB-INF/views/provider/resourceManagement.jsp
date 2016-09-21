<%-- 
    Document   : resourceManagement
    Created on : Jun 15, 2016, 11:45:52 AM
    Author     : Long Nguyen
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
        <title>YouTripper - Resource Management</title>
        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>">
        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">

        <link href="<c:url value="/Resources/Theme/css/font-awesome.min.css"/>" rel="stylesheet">

        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
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

            #full-page .pagesearch {
                height: 100%;
            }

            #full-page-container {
                position: absolute;
                top: 65px;
                bottom: 0;
                left: 0;
                right: 0;
            }

            table.full-width {
                width: 100%;
                text-align: center;
            }

            table.resourceManage tr, table.resourceManage td {
                border: solid 1px #ddd;
            }

            table.resourceManage tr:first-of-type, table.resourceManage tr:first-of-type td {
                border-top: 0;
            }

            table.resourceManage .child-tbl td, table.resourceManage .child-tbl tr {
                border: 0;
            }

            table.resourceManage .child-tbl td {
                border-right: solid 1px #ddd;
            }

            table.resourceManage .child-tbl td:last-of-type {
                border: 0;
            }

            table.resourceManage .child-tbl.multi-child tr:last-of-type td, table.resourceManage .child-tbl.multi-child tr:last-of-type {
                border-bottom: 0;
            }

            table.resourceManage .child-tbl.multi-child tr {
                border-left: 0;
                border-right: 0;
                border-bottom: solid 1px #ddd;
            }

            table.resourceManage .child-tbl.multi-child tr > td:first-of-type {
                border-left: 0;
            }

            table.resourceManage .child-tbl.multi-child tr > td:last-of-type {
                border-right: 0;
            }

            table.resourceManage .child-tbl.small-header > tbody > tr > td {
                width: 50%;
            }

            table.resourceManage tr td:first-of-type {
                width: 170px;
            }

            table.resourceManage tr td:nth-of-type(3) {
                width: 190px;
            }

            table.resourceManage tr td:nth-of-type(4) {
                width: 60px;
            }

            #provider-resource-tbl {

            }

            #skills-tbl {
            }

            html, body {
                height: 100%;
            }

            #provider-resource-tbl, #trip-resource-tbl {
                height: 50%;
                position: relative;
            }

            .tbl-header {
                overflow-y: scroll;
                border-top: solid 1px #ddd;
            }

            .tbl-body {
                position: absolute;
                top: 52px;
                left: 0;
                right: 0;
                bottom: 0;
                overflow-y: scroll;
            }

            a.manage-ic {
                font-size: 16px;
                margin: 0 2px;
            }

            a.edit-ic {
                color: #CCE088;
            }

            a.delete-ic {
                color: #FF514E;
                font-size: 18px
            }

            .mng-btn-container {
                width: 160px;
                text-align: center;
                margin: 0 auto;
                padding: 10px 0;
            }

            .tbl-name {
                position: absolute;
                top: 0;
                bottom: 0;
                left: 0;
                width: 30px;
                overflow: hidden;
                text-align: center;
                background-color: #337ab7;
                border-bottom: solid 2px #ddd;
            }

            .tbl-name p {
                writing-mode: vertical-rl;
                position: absolute;
                top: 50%;
                margin-top: -81px;
                line-height: 30px;
                left: 0;
                color: #fff;
                -ms-transform: rotate(180deg); /* IE 9 */
                -webkit-transform: rotate(180deg); /* Chrome, Safari, Opera */
                -moz-transform: rotate(180deg); /* Chrome, Safari, Opera */
                transform: rotate(180deg);
            }

            .tbl-container {
                position: relative;
                height: 100%;
                margin-left: 30px;
            }

            .checked-ic, .skill-pc-edit {
                color: #CCE088;
            }
            .edit-check {
                width: 18px;
                margin: 0 auto;
                display: none;
            }

            a.save-ic {
                display: none;
                color: #337ab7;
            }

            .edit-input {
                display: none;
                margin: 0 auto;
                position: relative;
            }

            .edit-input.capacity-edit-input {
                width: 80px;
            }
            .edit-input.reName-edit-input {
                width: 150px;
            }

            .capacity-edit-input input {
                text-align: center;
            }

            .edit-mode .delete-ic, .edit-mode .edit-ic,  .edit-mode .result-check {
                display: none;  
            }

            .edit-mode .edit-check,.edit-mode .save-ic, .edit-mode .edit-input  {
                display: block;
            }

            #skillPopup .popupContent, #providerResourcePopup .popupContent, #skillEditingPopup .popupContent {
                width: 400px;
            }

            #trippSourcePopup .popupContent {
                width: 500px;
            }

            #trippSourcePopup select.blueInput {
                border: solid 2px #64c7d0;
            }

            a.new-tripSource-link {
                font-size: 12px;
            }

            .time-type-input div {
                width: 50%;
                float: left;
            }

            table.edited-table > tbody > tr {
                height: 50px;
            }

            .edit-time-popup {
                display: none;
                position: absolute;
                width: 300px;
                right: 0;
                background-color: #fff;
                border-radius: 3px;
                padding: 10px;
                -webkit-box-shadow: 0px 0px 5px 0px rgba(0,0,0,0.75);
                -moz-box-shadow: 0px 0px 5px 0px rgba(0,0,0,0.75);
                box-shadow: 0px 0px 5px 0px rgba(0,0,0,0.75);
                margin-top: 2px;
                z-index: 2;
            }

            .edit-time-popup.active {
                display: block;
            }

            .edit-time-popup .edit-title {
                text-align: left;
            }

            .edit-time-popup select {
                border: solid 2px #64c7d0;
            }

            .edit-time-popup input {
                text-align: center;
            }

            #trip-resource-tbl .packageName {
                white-space: nowrap;
                width: 160px;
                overflow: hidden;
                text-overflow: ellipsis;
                margin: 0 auto;
            }
        </style>
    </head>
    <body id="full-page" ng-app="YouTripper" ng-controller="ResourceManagementController">

        <!--SKILL POPUP-->
        <div class="ytPopup" id="skillPopup">
            <div class="tbl-cell noClick">
                <div class="popupContent">
                    <div class="center-informBlock blur-backgroud" ng-show="skillSaving">
                        <div class="small-spinner" ></div>
                    </div>
                    <span class="box-closing" ng-click="toggleSkillBox()"></span>
                    <div class="popupScroll">
                        <h4>Insert new skill / job</h4>
                        <div class="popupRow">
                            <div class="row">
                                <div class="col-xs-12">
                                    <input class="blueInput normalFont" placeholder="Fill your skill or job name" maxlength="20"
                                           ng-model="newSkillName"/>
                                </div>
                            </div>
                        </div>

                        <div class="popupRow">
                            <div class="row">
                                <div class="col-xs-12">
                                    <button class="btn-width-orange" ng-click="saveNewResourceSkill()">Save</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--END SKILL POPUP-->

        <!--SKILL EDITING POPUP-->
        <div class="ytPopup" id="skillEditingPopup">
            <div class="tbl-cell noClick">
                <div class="popupContent">
                    <div class="center-informBlock blur-backgroud" ng-show="skillEditing">
                        <div class="small-spinner" ></div>
                    </div>
                    <span class="box-closing" ng-click="closeSkillEditingPopup()"></span>
                    <div class="popupScroll">
                        <h4>Edit skill / job</h4>
                        <div class="popupRow">
                            <div class="row">
                                <div class="col-xs-12">
                                    <input class="blueInput normalFont" placeholder="Fill your skill or job name" maxlength="20"
                                           ng-model="selectedSkillName"/>
                                </div>
                            </div>
                        </div>

                        <div class="popupRow">
                            <div class="row">
                                <div class="col-xs-6">
                                    <button class="btn-width-orange" ng-click="editSkill(selectedSkillID, selectedSkillName)">Save</button>
                                </div>
                                <div class="col-xs-6">
                                    <button class="btn-width-orange login_gg" ng-click="deleteSkill(selectedSkillID)">Delete</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--END SKILL EDITING POPUP-->

        <!--SKILL POPUP-->
        <div class="ytPopup" id="providerResourcePopup">
            <div class="tbl-cell noClick">
                <div class="popupContent">
                    <div class="center-informBlock blur-backgroud" ng-show="providerResourceSaving">
                        <div class="small-spinner" ></div>
                    </div>
                    <span class="box-closing" ng-click="toggleProviderResourceBox()"></span>
                    <div class="popupScroll">
                        <h4>Insert new resource</h4>

                        <div class="popupRow">
                            <div class="row">
                                <div class="col-xs-12">
                                    <input class="blueInput normalFont" placeholder="Fill your resource name" 
                                           ng-model="newResourceName"/>
                                </div>
                            </div>
                        </div>

                        <div class="popupRow">
                            <div class="row">
                                <div class="col-xs-12">
                                    <input class="blueInput normalFont" placeholder="Fill your resource capacity"  type="number"
                                           ng-model="newResourceCapacity" />
                                </div>
                            </div>
                        </div>

                        <div class="popupRow">
                            <div class="row">
                                <div class="col-xs-12">
                                    <button class="btn-width-orange" ng-click="insertNewProviderResource()">Save</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--END SKILL POPUP-->

        <!--TRIPPSOURCE POPUP-->
        <div class="ytPopup" id="trippSourcePopup">
            <div class="tbl-cell noClick">
                <div class="popupContent">
                    <div class="center-informBlock blur-backgroud" ng-show="trippSourceAssigning">
                        <div class="small-spinner" ></div>
                    </div>
                    <span class="box-closing" ng-click="toggleTrippSourcePopup()"></span>
                    <div class="popupScroll">
                        <h4>Assign new trippsource</h4>

                        <div class="popupRow">
                            <div class="row">
                                <div class="col-xs-12">
                                    <input class="blueInput normalFont" placeholder="Fill number of units" type="number"
                                           ng-model="newNoUnits"/>
                                </div>
                            </div>
                        </div>

                        <!--                        <div class="popupRow">
                                                    <div class="row">
                                                        <div class="col-xs-12">
                                                            How long until the units are ready for booking again? 
                                                        </div>
                                                    </div>
                                                </div>
                        
                                                <div class="popupRow">
                                                    <div class="row">
                                                        <div class="col-xs-6">
                                                            <select class="blueInput normalFont" ng-model="newDurationType" ng-change="setDefaultForTime()">
                                                                <option value="days">Days</option>
                                                                <option value="hours">Hours and minutes</option>
                                                            </select>
                                                        </div>
                                                        <div class="col-xs-6">
                                                            <div class="day-type-input" ng-if="newDurationType === 'days'">
                                                                <input class="blueInput normalFont" placeholder="Days"  type="number"
                                                                       ng-model="$parent.newNoDays" />
                                                            </div>
                                                            <div class="clearfix time-type-input" ng-if="newDurationType === 'hours'">
                                                                <div>
                                                                    <select class="blueInput normalFont" ng-model="$parent.newHours">
                                                                        <option value="">Hours</option>
                                                                        <option value="1">1</option>
                                                                        <option value="2">2</option>
                                                                        <option value="3">3</option>
                                                                        <option value="4">4</option>
                                                                        <option value="5">5</option>
                                                                        <option value="6">6</option>
                                                                        <option value="7">7</option>
                                                                        <option value="8">8</option>
                                                                        <option value="9">9</option>
                                                                        <option value="10">10</option>
                                                                        <option value="11">11</option>
                                                                        <option value="12">12</option>
                                                                        <option value="13">13</option>
                                                                        <option value="14">14</option>
                                                                        <option value="15">15</option>
                                                                        <option value="16">16</option>
                                                                        <option value="17">17</option>
                                                                        <option value="18">18</option>
                                                                        <option value="19">19</option>
                                                                        <option value="20">20</option>
                                                                        <option value="21">21</option>
                                                                        <option value="22">22</option>
                                                                        <option value="23">23</option>
                                                                    </select>
                                                                </div>
                                                                <div>
                                                                    <select class="blueInput normalFont" ng-model="$parent.newMinutes">
                                                                        <option value="">Minutes</option>
                                                                        <option value="5">5</option>
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
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>-->

                        <div class="popupRow">
                            <div class="row">
                                <div class="col-xs-12">
                                    <button class="btn-width-orange" ng-click="assignNewTrippSource()">Save</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--END TRIPPSOURCE POPUP-->
        <div  class="pagesearch">
            <%@ include file="../header.jsp" %>

            <div id="full-page-container">
                <!--PROVIDER RESOURCE-->
                <div id="provider-resource-tbl">
                    <div class="tbl-name">
                        <p>Your resources and skills</p>
                    </div>
                    <div class="tbl-container">
                        <div class="center-informBlock blur-backgroud" ng-show="editing">
                            <div class="small-spinner" ></div>
                        </div>
                        <div class="tbl-header">
                            <table  class="resourceManage full-width">
                                <tr>
                                    <td rowspan="2" class="col-btn bg-info">
                                        <div class="mng-btn-container">
                                            <a href="" ng-click="toggleProviderResourceBox()" class="btn-width-orange">Add more resource</a>
                                        </div>
                                    </td>
                                    <td class="bg-success">
                                        <a href="" ng-click="toggleSkillBox()" class="orange-link"><i class="fa fa-plus-square" aria-hidden="true"></i> Add more skill / job</a>
                                    </td>
                                    <td rowspan="2" class="bg-info">
                                        Capacity
                                    </td>
                                    <td rowspan="2" class="bg-info">
                                        Action
                                    </td>
                                </tr>
                                <tr class=" bg-success">
                                    <td>
                                        <table class="child-tbl full-width skills-tbl">
                                            <tr>
                                                <td ng-repeat="skill in resourceManagementData.resourceSkills"
                                                    ng-init="$last ? calculateWidthOfSkills() : angular.noop()">
                                                    <span>{{skill.name}}</span>
                                                    <a href="" ng-click="openSkillEditingPopup(skill.skillID, skill.name)" class="skill-pc-edit">
                                                        <i class="fa fa-pencil" aria-hidden="true"></i>
                                                    </a>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div class="tbl-body">
                            <div class="tbl-center" ng-if="sizeOfHashMap(providerResources) <= 0">
                                <div class="tbl-cell">
                                    <p style="text-align: center">You have no resources.</p>
                                </div>
                            </div>
                            <table  ng-if="sizeOfHashMap(providerResources) > 0" id="provider-resource-tbl" 
                                    class="resourceManage full-width table-striped edited-table">
                                <tr class="provider-resource-row" ng-repeat="(providerResourceID, providerResource) in providerResources"
                                    providerResourceID="{{providerResourceID}}">
                                    <td>
                                        <span class="result-check">{{providerResource.name}}</span>
                                        <div class="edit-input reName-edit-input">
                                            <input class="normalFont blueInput" ng-model="providerResource.name" placeholder="Resource name"/>
                                        </div>
                                    </td>
                                    <td>
                                        <table class="child-tbl full-width skills-tbl">
                                            <tr>
                                                <td ng-if="providerResource.skillIDs.length > 0 || isEditMode(providerResourceID)" 
                                                    ng-repeat="skill in resourceManagementData.resourceSkills" 
                                                    ng-init="$last ? calculateWidthOfSkills() : angular.noop()">
                                                    <span class="result-check checked-ic" ng-if="checkResourceSkillIsChecked(skill.skillID, providerResource.skillIDs)">
                                                        <i class="fa fa-check" aria-hidden="true"></i>
                                                    </span>
                                                    <div class="edit-check clearfix">
                                                        <div class="tempCheckbox blueInput greenInput">
                                                            <input type="checkbox" checklist-model="providerResource.skillIDs"
                                                                   checklist-value="skill.skillID">
                                                            <span></span>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td ng-if="providerResource.skillIDs.length <= 0 && !isEditMode(providerResourceID)">
                                                    No skills. Please click edit to assign new skill.
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                    <td>
                                        <span class="result-check">{{providerResource.capacity}}</span>
                                        <div class="edit-input capacity-edit-input">
                                            <input class="normalFont blueInput" type="number"
                                                   ng-model="providerResource.capacity" placeholder="Number"/>
                                        </div>
                                    </td>
                                    <td>
                                        <a href="" ng-click="changeProviderResourceToEditMode(providerResourceID)" class="manage-ic edit-ic">
                                            <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                        </a>
                                        <a href="" ng-click="deleteProviderResource(providerResourceID)" class="manage-ic delete-ic">
                                            <i class="fa fa-times" aria-hidden="true"></i>
                                        </a>
                                        <a href="" ng-click="saveProviderResource(providerResourceID)" class="manage-ic save-ic">
                                            <i class="fa fa-floppy-o" aria-hidden="true"></i>
                                        </a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <!--END PROVIDER RESOURCE--> 

                <!--TRIP SOURCE-->
                <div id="trip-resource-tbl">
                    <div class="tbl-name">
                        <p style="margin-top: -50px;">Your packages</p>
                    </div>
                    <div class="tbl-container">
                        <div class="center-informBlock blur-backgroud" ng-show="trippSourceEditing">
                            <div class="small-spinner" ></div>
                        </div>
                        <div class="tbl-header">
                            <table  class="resourceManage full-width">
                                <tr>
                                    <td rowspan="2" class="col-btn bg-info">
                                        <div class="mng-btn-container">
                                            <a href="
                                               <c:choose>
                                                   <c:when test="${empty param.language }">
                                                       <c:url value="/Provider/Package/Registration"/>
                                                   </c:when>
                                                   <c:otherwise>
                                                       <c:url value="/Provider/Package/Registration?language=${param.language}"/>
                                                   </c:otherwise>
                                               </c:choose>" 
                                               class="btn-width-orange">Create new package</a>
                                        </div>
                                    </td>
                                    <td rowspan="2" class="bg-success" >
                                        <table class="child-tbl full-width skills-tbl">
                                            <tr>
                                                <td ng-repeat="skill in resourceManagementData.resourceSkills" ng-init="$last ? calculateWidthOfSkills() : angular.noop()"
                                                    ng-if="resourceManagementData.resourceSkills.length > 0">{{skill.name}}</td>
                                                <td ng-if="resourceManagementData.resourceSkills.length <= 0">No skill / job is created</td>
                                            </tr>
                                        </table>
                                    </td>
                                    <td rowspan="2" class="bg-info">

                                        <table class="child-tbl full-width small-header">
                                            <tr>
                                                <td>No. units</txd>
                                                    <!--<td>Duration</td>-->
                                            </tr>
                                        </table>

                                    </td>
                                    <td rowspan="2" class="bg-info">
                                        Action
                                    </td>
                                </tr>
                                <tr></tr>                  
                            </table>
                        </div>

                        <div class="tbl-body">

                            <div class="tbl-center" ng-if="sizeOfHashMap(trippResources['Primary']) <= 0 && sizeOfHashMap(trippResources['Temporary']) <= 0">
                                <div class="tbl-cell">
                                    <p style="text-align: center">You have no packages.</p>
                                </div>
                            </div>

                            <table  class="resourceManage full-width table-striped" 
                                    ng-if="sizeOfHashMap(trippResources['Primary']) > 0 || sizeOfHashMap(trippResources['Temporary']) > 0">
                                <!--APPROVED PACKAGES-->
                                <tr ng-repeat="(packageID, package) in trippResources['Primary']">
                                    <td>
                                        <p class="packageName">
                                            {{package.packageName}}
                                        </p>
                                        <a href="" ng-click="setTrippSourceDataForPopup(packageID, 'Primary')" class="orange-link new-tripSource-link">
                                            <i class="fa fa-plus-square" aria-hidden="true"></i> TrippSource
                                        </a>
                                    </td>
                                    <td ng-if="sizeOfHashMap(package.trippSources) > 0">
                                        <table class="child-tbl full-width skills-tbl multi-child edited-table">
                                            <tr ng-repeat="(trippSourceID, trippSource) in package.trippSources" class="trippSource-row"
                                                trippSourceID="{{trippSourceID}}">
                                                <td  ng-if="trippSource.skills.length > 0 || isTrippSourceInEdit(trippSourceID)"  
                                                     ng-repeat="skill in resourceManagementData.resourceSkills" 
                                                     ng-init="$last ? calculateWidthOfSkills() : angular.noop()">
                                                    <span class="result-check checked-ic" 
                                                          ng-if="checkResourceSkillIsChecked(skill.skillID, trippSource.skills)">
                                                        <i class="fa fa-check" aria-hidden="true"></i>
                                                    </span>
                                                    <div class="edit-check clearfix">
                                                        <div class="tempCheckbox blueInput greenInput">
                                                            <input type="checkbox" checklist-model="trippSource.skills"
                                                                   checklist-value="skill.skillID">
                                                            <span></span>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td ng-if="trippSource.skills.length <= 0 && !isTrippSourceInEdit(trippSourceID)" 
                                                    colspan="{{resourceManagementData.resourceSkills.length}}">
                                                    Click edit to assign skills.
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                    <td ng-if="sizeOfHashMap(package.trippSources) <= 0" colspan="3">You have not assigned the trippSource for this package.</td>
                                    <td ng-if="sizeOfHashMap(package.trippSources) > 0">
                                        <table class="child-tbl full-width small-header  multi-child edited-table">
                                            <tr ng-repeat="(trippSourceID, trippSource) in package.trippSources" class="trippSource-row"
                                                trippSourceID="{{trippSourceID}}">
                                                <td>
                                                    <span class="result-check">{{trippSource.noUnits}}</span>
                                                    <div class="edit-input">
                                                        <input class="normalFont blueInput" ng-model="trippSource.noUnits" placeholder="Number"/>
                                                    </div>
                                                </td>
                                                <!--                                                <td>
                                                                                                    <span class="result-check"  ng-if="trippSource.days > 0">{{trippSource.days}} D</span>
                                                                                                    <span class="result-check" ng-if="trippSource.hours > 0">{{trippSource.hours}} H</span>
                                                                                                    <span class="result-check" ng-if="trippSource.minutes > 0">{{trippSource.minutes}} M</span>
                                                                                                    <div class="edit-input">
                                                                                                        <a class="blueInput active-time-link" href="" ng-click="">
                                                                                                            <span ng-if="trippSource.days > 0">{{trippSource.days}} D</span>
                                                                                                            <span ng-if="trippSource.hours > 0">{{trippSource.hours}} H</span>
                                                                                                            <span ng-if="trippSource.minutes > 0">{{trippSource.minutes}} M</span>
                                                                                                        </a>
                                                                                                        <div class="edit-time-popup">
                                                                                                            <div class="row">
                                                                                                                <div class="col-xs-4 edit-title">
                                                                                                                    Day
                                                                                                                </div>
                                                                                                                <div class="col-xs-4 edit-title">
                                                                                                                    Hour
                                                                                                                </div>
                                                                                                                <div class="col-xs-4 edit-title">
                                                                                                                    Minute
                                                                                                                </div>
                                                                                                            </div>
                                                                                                            <div class="row">
                                                                                                                <div class="col-xs-4">
                                                                                                                    <input type="number" class="normalFont blueInput"
                                                                                                                           ng-model="trippSource.days" ng-change="changeDayOfTrippSource(trippSource)"/>
                                                                                                                </div>
                                                                                                                <div class="col-xs-4">
                                                                                                                    <select class="blueInput normalFont" ng-model="trippSource.hours"
                                                                                                                            ng-change="changeTimeOfTrippSource(trippSource)" convert-to-number>
                                                                                                                        <option value="0">0</option>
                                                                                                                        <option value="1">1</option>
                                                                                                                        <option value="2">2</option>
                                                                                                                        <option value="3">3</option>
                                                                                                                        <option value="4">4</option>
                                                                                                                        <option value="5">5</option>
                                                                                                                        <option value="6">6</option>
                                                                                                                        <option value="7">7</option>
                                                                                                                        <option value="8">8</option>
                                                                                                                        <option value="9">9</option>
                                                                                                                        <option value="10">10</option>
                                                                                                                        <option value="11">11</option>
                                                                                                                        <option value="12">12</option>
                                                                                                                        <option value="13">13</option>
                                                                                                                        <option value="14">14</option>
                                                                                                                        <option value="15">15</option>
                                                                                                                        <option value="16">16</option>
                                                                                                                        <option value="17">17</option>
                                                                                                                        <option value="18">18</option>
                                                                                                                        <option value="19">19</option>
                                                                                                                        <option value="20">20</option>
                                                                                                                        <option value="21">21</option>
                                                                                                                        <option value="22">22</option>
                                                                                                                        <option value="23">23</option>
                                                                                                                    </select>
                                                                                                                </div>
                                                                                                                <div class="col-xs-4">
                                                                                                                    <select class="blueInput normalFont" ng-model="trippSource.minutes"
                                                                                                                            ng-change="changeTimeOfTrippSource(trippSource)" convert-to-number>
                                                                                                                        <option value="0">0</option>
                                                                                                                        <option value="5">5</option>
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
                                                                                                                </div>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                </td>-->
                                            </tr>
                                        </table>
                                    </td>
                                    <td ng-if="sizeOfHashMap(package.trippSources) > 0">
                                        <table class="child-tbl full-width  multi-child edited-table">
                                            <tr ng-repeat="(trippSourceID, trippSource) in package.trippSources" class="trippSource-row"
                                                trippSourceID="{{trippSourceID}}">
                                                <td>
                                                    <a href="" ng-click="changeTrippSourceToEdit(trippSourceID)" class="manage-ic edit-ic">
                                                        <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                    </a>
                                                    <a href="" ng-click="deleteTrippSource('Primary', packageID, trippSourceID)" class="manage-ic delete-ic">
                                                        <i class="fa fa-times" aria-hidden="true"></i>
                                                    </a>
                                                    <a href="" ng-click="editTrippSource('Primary', packageID, trippSourceID)" class="manage-ic save-ic">
                                                        <i class="fa fa-floppy-o" aria-hidden="true"></i>
                                                    </a>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <!--END APPROVED PACKAGES-->

                                <!--TEMP PACKAGES-->
                                <tr ng-repeat="(packageID, package) in trippResources['Temporary']">
                                    <td>
                                        <p class="packageName">
                                            {{package.packageName}}
                                        </p>
                                        <a href="" ng-click="setTrippSourceDataForPopup(packageID, 'Temporary')" class="orange-link new-tripSource-link">
                                            <i class="fa fa-plus-square" aria-hidden="true"></i> TrippSource
                                        </a>
                                    </td>
                                    <td ng-if="sizeOfHashMap(package.trippSources) > 0">
                                        <table class="child-tbl full-width skills-tbl  multi-child edited-table">
                                            <tr ng-repeat="(trippSourceID, trippSource) in package.trippSources" class="trippSource-row"
                                                trippSourceID="{{trippSourceID}}">
                                                <td  ng-if="trippSource.skills.length > 0 || isTrippSourceInEdit(trippSourceID)"  
                                                     ng-repeat="skill in resourceManagementData.resourceSkills" 
                                                     ng-init="$last ? calculateWidthOfSkills() : angular.noop()">
                                                    <span class="result-check checked-ic" 
                                                          ng-if="checkResourceSkillIsChecked(skill.skillID, trippSource.skills)">
                                                        <i class="fa fa-check" aria-hidden="true"></i>
                                                    </span>
                                                    <div class="edit-check clearfix">
                                                        <div class="tempCheckbox blueInput greenInput">
                                                            <input type="checkbox" checklist-model="trippSource.skills"
                                                                   checklist-value="skill.skillID">
                                                            <span></span>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td ng-if="trippSource.skills.length <= 0 && !isTrippSourceInEdit(trippSourceID)"
                                                    colspan="{{resourceManagementData.resourceSkills.length}}">
                                                    Click edit to assign skills.
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                    <td ng-if="sizeOfHashMap(package.trippSources) <= 0" colspan="3">You have not assigned the trippSource for this package.</td>

                                    <td ng-if="sizeOfHashMap(package.trippSources) > 0">
                                        <table class="child-tbl full-width small-header  multi-child edited-table">
                                            <tr ng-repeat="(trippSourceID, trippSource) in package.trippSources" class="trippSource-row"
                                                trippSourceID="{{trippSourceID}}">
                                                <td>
                                                    <span class="result-check">{{trippSource.noUnits}}</span>
                                                    <div class="edit-input">
                                                        <input class="normalFont blueInput" ng-model="trippSource.noUnits" placeholder="Number"/>
                                                    </div>
                                                </td>
                                                <!--                                                <td>
                                                                                                    <span class="result-check" ng-if="trippSource.days > 0">{{trippSource.days}} D</span>
                                                                                                    <span class="result-check" ng-if="trippSource.hours > 0">{{trippSource.hours}} H</span>
                                                                                                    <span  class="result-check" ng-if="trippSource.minutes > 0">{{trippSource.minutes}} M</span>
                                                                                                    <div class="edit-input">
                                                                                                        <a class="blueInput active-time-link" href="" ng-click="">
                                                                                                            <span ng-if="trippSource.days > 0">{{trippSource.days}} D</span>
                                                                                                            <span ng-if="trippSource.hours > 0">{{trippSource.hours}} H</span>
                                                                                                            <span ng-if="trippSource.minutes > 0">{{trippSource.minutes}} M</span>
                                                                                                        </a>
                                                                                                        <div class="edit-time-popup">
                                                                                                            <div class="row">
                                                                                                                <div class="col-xs-4 edit-title">
                                                                                                                    Day
                                                                                                                </div>
                                                                                                                <div class="col-xs-4 edit-title">
                                                                                                                    Hour
                                                                                                                </div>
                                                                                                                <div class="col-xs-4 edit-title">
                                                                                                                    Minute
                                                                                                                </div>
                                                                                                            </div>
                                                                                                            <div class="row">
                                                                                                                <div class="col-xs-4">
                                                                                                                    <input type="number" class="normalFont blueInput"
                                                                                                                           ng-model="trippSource.days" ng-change="changeDayOfTrippSource(trippSource)"/>
                                                                                                                </div>
                                                                                                                <div class="col-xs-4">
                                                                                                                    <select class="blueInput normalFont" ng-model="trippSource.hours"
                                                                                                                            ng-change="changeTimeOfTrippSource(trippSource)" convert-to-number>
                                                                                                                        <option value="0">0</option>
                                                                                                                        <option value="1">1</option>
                                                                                                                        <option value="2">2</option>
                                                                                                                        <option value="3">3</option>
                                                                                                                        <option value="4">4</option>
                                                                                                                        <option value="5">5</option>
                                                                                                                        <option value="6">6</option>
                                                                                                                        <option value="7">7</option>
                                                                                                                        <option value="8">8</option>
                                                                                                                        <option value="9">9</option>
                                                                                                                        <option value="10">10</option>
                                                                                                                        <option value="11">11</option>
                                                                                                                        <option value="12">12</option>
                                                                                                                        <option value="13">13</option>
                                                                                                                        <option value="14">14</option>
                                                                                                                        <option value="15">15</option>
                                                                                                                        <option value="16">16</option>
                                                                                                                        <option value="17">17</option>
                                                                                                                        <option value="18">18</option>
                                                                                                                        <option value="19">19</option>
                                                                                                                        <option value="20">20</option>
                                                                                                                        <option value="21">21</option>
                                                                                                                        <option value="22">22</option>
                                                                                                                        <option value="23">23</option>
                                                                                                                    </select>
                                                                                                                </div>
                                                                                                                <div class="col-xs-4">
                                                                                                                    <select class="blueInput normalFont" ng-model="trippSource.minutes"
                                                                                                                            ng-change="changeTimeOfTrippSource(trippSource)" convert-to-number>
                                                                                                                        <option value="0">0</option>
                                                                                                                        <option value="5">5</option>
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
                                                                                                                </div>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                </td>-->
                                            </tr>
                                        </table>
                                    </td>
                                    <td ng-if="sizeOfHashMap(package.trippSources) > 0">
                                        <table class="child-tbl full-width  multi-child edited-table">
                                            <tr ng-repeat="(trippSourceID, trippSource) in package.trippSources" class="trippSource-row"
                                                trippSourceID="{{trippSourceID}}">
                                                <td>
                                                    <a href="" ng-click="changeTrippSourceToEdit(trippSourceID)" class="manage-ic edit-ic">
                                                        <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                    </a>
                                                    <a href="" ng-click="deleteTrippSource('Temporary', packageID, trippSourceID)" class="manage-ic delete-ic">
                                                        <i class="fa fa-times" aria-hidden="true"></i>
                                                    </a>
                                                    <a href="" ng-click="editTrippSource('Temporary', packageID, trippSourceID)" class="manage-ic save-ic">
                                                        <i class="fa fa-floppy-o" aria-hidden="true"></i>
                                                    </a>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <!--END TEMP PACKAGES-->
                            </table>
                        </div>
                    </div>
                </div>
                <!--END TRIP SOURCE-->
            </div>
        </div>

    </body>
    <script>
        var resourceManagementData = ${requestScope.resourceManagementData};
    </script>
</html>
