<%-- 
    Document   : BookingEngine
    Created on : Jul 25, 2016, 2:45:51 PM
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
            #booking-engine-container {
                position: relative;
            }

            #booking-left-menu {
                position: absolute;
                left: 0;
                min-height: 600px;
                width: 260px;
                background-color: #3FC1C9;
            }

            #booking-left-menu {	
                padding: 20px;
            }

            #booking-left-menu .left-menu-row {
                margin-bottom: 10px;

            }

            #booking-left-menu .left-menu-row:last-of-type {
                margin-bottom: 0;
            }

            #bkk-time {
                background-color: #fff;
                padding: 0 10px;
                height: 50px;
                border-radius: 5px;
            }

            #bkk-time ul {
                height: 100%;
            }

            #bkk-time ul li {
                float: left;
                height: 100%;
            }

            #bkk-time ul li .time-icon span {
                display: block;
            }

            #bkk-time ul li .time-icon span.text {
                color: #3FC1C9;
                font-size: 11.5px;
                text-align: center;
                line-height: 11.5px;
                margin-top: 5px;
            }

            #bkk-time ul li .time-type {
                width: 70px;
            }

            #bkk-time ul li .time-type span {
                display: block;
                font-size: 11.5px;
                line-height: 13px;
                text-align: center;
                color: #DAE1E8;
            }

            #bkk-time ul li .time-type span.text {
                color: #3FC1C9;
            }

            #bkk-time ul li .time-now {
                width: 105px;
            }

            #bkk-time ul li .time-now h1 {
                font-family: Sailec !important;
                color: #3FC1C9;
                margin: 0;
                font-size: 40px;
                line-height: 50px;
                text-align: center;
                letter-spacing: 2px;
            }

            #bkk-calendar .calendar-header {
                text-align: center;
                font-family: Sailec-Bold;
                color: #fff;
                background-color: #3C3F54;
                line-height: 20px;
                font-size: 12px;
                text-transform: uppercase;
            }

            #bkk-calendar .calendar-common {
                background-color: #DAE1E8;
                padding: 5px 10px;
            }

            #bkk-calendar .calendar-common .calendar-ctrls {
                position: relative;
            }

            #bkk-calendar .calendar-common .calendar-ctrls p {
                text-align: center;
                color: #3C3F54;
            }

            #bkk-calendar .calendar-common .calendar-ctrls a {
                display: block;
                position: absolute;
                top: 50%;
                margin-top: -6px;
            }

            #bkk-calendar .calendar-common .calendar-ctrls .previous-ctrl {
                width: 0;
                height: 0;
                border-style: solid;
                border-width: 6px 8px 6px 0;
                border-color: transparent #3c3f54 transparent transparent;
                left: 30px;
            }

            #bkk-calendar .calendar-common .calendar-ctrls .next-ctrl {
                width: 0;
                height: 0;
                border-style: solid;
                border-width: 6px 0 6px 8px;
                border-color: transparent transparent transparent #3c3f54;
                right: 30px;
            }

            #bkk-calendar .calendar-common .calendar-ctrls .dbPrevious-ctrl {
                width: 0;
                height: 0;
                border-style: solid;
                border-width: 6px 8px 6px 0;
                border-color: transparent #3c3f54 transparent transparent;
            }

            #bkk-calendar .calendar-common .calendar-ctrls .dbPrevious-ctrl:after {
                content: ' ';
                display: block;
                width: 0;
                height: 0;
                border-style: solid;
                border-width: 6px 8px 6px 0;
                border-color: transparent #3c3f54 transparent transparent;
                position: absolute;
                right: -16px;
                top: -6px;
            }

            #bkk-calendar .calendar-common .calendar-ctrls .dbNext-ctrl {
                width: 0;
                height: 0;
                border-style: solid;
                border-width: 6px 0 6px 8px;
                border-color: transparent transparent transparent #3c3f54;
                right: 0;
            }

            #bkk-calendar .calendar-common .calendar-ctrls .dbNext-ctrl:after {
                content: ' ';
                display: block;
                width: 0;
                height: 0;
                border-style: solid;
                border-width: 6px 0 6px 8px;
                border-color: transparent transparent transparent #3c3f54;
                position: absolute;
                left: -16px;
                top: -6px;
            }

            #bkk-calendar .calendar-common .big-date {
                margin: 5px 0;
            }

            #bkk-calendar .calendar-common .big-date ul {
                margin: 0 -5px;
            }

            #bkk-calendar .calendar-common .big-date ul li {
                float: left;
                padding: 0 5px;
                width: 33.333%;

            }

            #bkk-calendar .calendar-common .big-date ul li .date-txt {
                text-align: center;
                line-height: 60px;
                background-color: #F2F2F4;
                border-radius: 5px;
                font-size: 40px;
                color: #DAE1E8;
            }

            #bkk-calendar .calendar-common .big-date ul li:nth-of-type(2) .date-txt {
                background-color: #FFF;
                color: #3FC1C9;
            }

            #bkk-calendar .calendar-body {
                background-color: #fff;
            }

            #bkk-calendar .calendar-body .calendar-days ul li {
                float: left;
                width: 14.286%;
                text-align: center;
                color: #3C3F54;
                letter-spacing: 1px;
            }

            #bkk-calendar .calendar-body .calendar-dates ul li {
                float: left;
                width: 14.286%;
                text-align: center;
                margin-bottom: 2px;
            }

            #bkk-calendar .calendar-body .calendar-dates ul li a {
                color: #3FC1C9;
                display: block;
                border-radius: 50%;
                width: 22px;
                line-height: 22px;
                margin: 0 auto;
                font-size: 12px;
                text-align: center;
            }

            #bkk-calendar .calendar-body .calendar-dates ul li.out-date a {
                color: #DAE1E8;
            }


            #bkk-calendar .calendar-body .calendar-dates ul li a:hover,
            #bkk-calendar .calendar-body .calendar-dates ul li.active a{
                background-color:  #3FC1C9;
                color: #fff;
            }

            #booking-packages-slt select {
                height: 30px;
                line-height: 30px;
                color: #3FC1C9
            }

            #booking-left-menu .tracker-box .box-title {
                font-size: 12px;
                font-family: Sailec-Bold;
                color: #fff;
                background-color: #3C3F54;
                text-align: center;
            }

            #booking-quota-tracker .tracker-box .box-title {
                background-color: #FBB03B;
            }

            #booking-left-menu .tracker-box .box-content {
                padding: 5px 0;
                background-color: #fff;
                position: relative;
            }
            #booking-left-menu .tracker-box .box-content .seperate-line {
                display: block;
                width: 2px;
                background-color: #3FC1C9;
                height: 30px;
                position: absolute;
                left: 50%;
                margin-left: -1px;
                top: 10px;
            }
            #booking-left-menu .tracker-box .box-content ul li {
                float: left;
                width: 50%;
                color: #3FC1C9;
            }

            #booking-left-menu .tracker-box .box-content ul li .number-title {
                text-align: center;
                font-size: 12px;
                line-height: 12px;
            }


            #booking-left-menu .tracker-box .box-content ul li .number-txt {
                font-size: 24px;
                text-align: center;
                line-height: 24px;
                padding-top: 5px;
            }

            #booking-engine-analyze {
                margin-left: 260px;
                padding: 20px;
                background-color: #DAE1E8;
            }

            #engine-ctrs {
                position: relative;
                height: 40px;
                margin-bottom: 10px;
            }

            #engine-ctrs ul {
                display: table;
                margin: auto;
            }

            #engine-ctrs ul li {
                float: left;
                margin-right: 10px;
            }

            #engine-ctrs ul li:last-of-type {
                margin-right: 0;
            }

            #engine-ctrs ul li a {
                display: block;
                font-size: 12px;
                font-family: Sailec-Bold;
                text-align: center;
                width: 100px;
                line-height: 30px;
                background-color: #fff;
                color: #3FC1C9;
                border-radius: 5px;
                border: solid 2px #3FC1C9;
            }

            #engine-ctrs ul li a:hover,#engine-ctrs ul li.active a {
                background-color: #3FC1C9;
                color: #fff;
            }

            #engine-ctrs a.ctrl {
                display: block;
                width: 80px;
                position: absolute;
                top: 0;
                bottom: 0;
                background-color: #3FC1C9;
                border-radius: 5px;
            }

            #engine-ctrs a.previous-ctrl:after {
                content: ' ';
                display: block;
                width: 0;
                height: 0;
                border-style: solid;
                border-width: 8px 16px 8px 0;
                border-color: transparent #ffffff transparent transparent;
                position: absolute;
                top: 50%;
                left: 50%;
                margin-top: -8px;
                margin-left: -10px;
            }

            #engine-ctrs a.next-ctrl {
                right: 0;
            }

            #engine-ctrs a.next-ctrl:after {
                content: ' ';
                display: block;
                width: 0;
                height: 0;
                border-style: solid;
                border-width: 8px 0 8px 16px;
                border-color: transparent transparent transparent #ffffff;
                position: absolute;
                top: 50%;
                left: 50%;
                margin-top: -8px;
                margin-left: -6px;
            }

            #engine-table {
                min-height: 300px;
                background-color: #fff;
                border: solid 2px #3FC1C9;
                overflow-x: auto;
                overflow-y: hidden;
                position: relative;
            }
            #engine-bookings-body ul li {
                height: 25px;
                position: relative;
            }

            #engine-bookings-body  .booking-session {
                position: absolute;
                top: 0;
                left: 0x;
                width: 200px;
                height: 25px;
                background-color: #ED1E79;
                color: #fff;
                font-size: 12px;
                border-radius: 5px;
                overflow: hidden;
            }

            #engine-bookings-body  .booking-session .booking-time {
                width: 40px;
                text-align: center;
                line-height: 25px;
                background-color: #3C3F54;
                float: left;
            }

            #engine-bookings-body .booking-session .package-title {
                margin-left: 50px;
                white-space: nowrap;
                overflow: hidden;
                text-overflow: ellipsis;
            }
        </style>
    </head>
    <body  ng-app="YouTripper">
        <div class="pagesearch" ng-controller="BookingEngineController">
            <!--PACKAGE DETAIL POPUP-->
            
            <!--END PACKAGE DETAIL-->
            
            
            <%@ include file="../header.jsp" %>
            <div id="booking-engine">
                <div id="booking-engine-container">
                    <div id="booking-left-menu">
                        <div class="booking-container">
                            <div class="left-menu-row">
                                <div id="bkk-time">
                                    <ul class="clearfix">
                                        <li>
                                            <div class="tbl-center">
                                                <div class="tbl-cell">
                                                    <div class="time-icon">
                                                        <span class="icon">
                                                            <img src="<c:url value="/Images/Icon/earth.svg"/>"/>
                                                        </span>
                                                        <span class="text">BKK</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="tbl-center">
                                                <div class="tbl-cell">
                                                    <div class="time-type">
                                                        <span class="text">24hrs</span>
                                                        <span>am</span>
                                                        <span>pm</span>
                                                    </div> 
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="time-now">
                                                <h1>{{now.HHmm()}}</h1>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="left-menu-row">
                                <div id="bkk-calendar">
                                    <div class="calendar-header">
                                        {{selectedDate.MonthYear()}}
                                    </div>
                                    <div class="calendar-common">
                                        <div class="calendar-ctrls">
                                            <a class="dbPrevious-ctrl" href="" ng-click="previousMonth()">
                                            </a>
                                            <a class="previous-ctrl" href="" ng-click="previousDate()">
                                            </a>
                                            <p>{{selectedDate.FullDay()}}</p>
                                            <a class="next-ctrl" href="" ng-click="nextDate()">
                                            </a>
                                            <a class="dbNext-ctrl" href="" ng-click="nextMonth()">
                                            </a>
                                        </div>
                                        <div class="big-date">
                                            <ul class="clearfix">
                                                <li class="date">
                                                    <div class="date-txt">
                                                        13
                                                    </div>
                                                </li>
                                                <li class="date">
                                                    <div class="date-txt">
                                                        14
                                                    </div>
                                                </li>
                                                <li class="date">
                                                    <div class="date-txt">
                                                        15
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="calendar-body">
                                        <div class="calendar-days">
                                            <ul class="clearfix">
                                                <li>SU</li>
                                                <li>MO</li>
                                                <li>TU</li>
                                                <li>WE</li>
                                                <li>TH</li>
                                                <li>FR</li>
                                                <li>SA</li>
                                            </ul>
                                        </div>
                                        <div class="calendar-dates">
                                            <ul class="clearfix">
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="left-menu-row">
                                <div id="booking-packages-slt">
                                    <select name="" class="blueInput">
                                        <option value="" selected>All packages</option>
                                        <option value="1">Package A</option>
                                    </select>
                                </div>
                            </div>
                            <div class="left-menu-row">
                                <div id="booking-resource-tracker">
                                    <div class="tracker-box">
                                        <div class="box-title">
                                            Resource Tracker
                                        </div>
                                        <div class="box-content">
                                            <ul class="clearfix">
                                                <li>
                                                    <div class="number-title">
                                                        Booked
                                                    </div>
                                                    <div class="number-txt">
                                                        8
                                                    </div>
                                                </li>
                                                <li>
                                                    <div class="number-title">
                                                        Max. Capacity
                                                    </div>
                                                    <div class="number-txt">
                                                        25
                                                    </div>
                                                </li>
                                            </ul>
                                            <span class="seperate-line"></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="left-menu-row">
                                <div id="booking-quota-tracker">
                                    <div class="tracker-box">
                                        <div class="box-title">
                                            Quota Tracker
                                        </div>
                                        <div class="box-content">
                                            <ul class="clearfix">
                                                <li>
                                                    <div class="number-title">
                                                        Filled
                                                    </div>
                                                    <div class="number-txt">
                                                        8
                                                    </div>
                                                </li>
                                                <li>
                                                    <div class="number-title">
                                                        Max. Serving
                                                    </div>
                                                    <div class="number-txt">
                                                        25
                                                    </div>
                                                </li>
                                            </ul>
                                            <span class="seperate-line"></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div id="booking-engine-analyze">
                        <div id="engine-container">
                            <div id="engine-ctrs">

                                <ul class="clearfix">
                                    <li class="active">
                                        <a href="" ng-click="">Day View</a>
                                    </li>
                                    <li>
                                        <a href="" ng-click="">Week View</a>
                                    </li>
                                    <li>
                                        <a href="" ng-click="">Month View</a>
                                    </li>
                                    <li>
                                        <a href="" ng-click="">Year View</a>
                                    </li>
                                </ul>
                                <a class="previous-ctrl ctrl" href="" ng-click="">

                                </a>
                                <a class="next-ctrl ctrl" href="" ng-click="">

                                </a>
                            </div>
                            <style>
                                #engine-time {
                                    position: relative;
                                    z-index: 3;
                                }
                                #engine-time ul {
                                    white-space: nowrap;
                                }

                                #engine-time > ul > li {
                                    display: inline-block;
                                    width: 115px;
                                    height: 80px;
                                    border-right: solid 2px #DAE1E8;
                                    border-bottom: solid 2px #3FC1C9;
                                    padding: 10px 0;
                                    cursor: pointer;
                                    position: relative;
                                }

                                #engine-time > ul > li:last-of-type {
                                    border-right: 0;
                                }

                                #engine-time > ul > li > span {
                                    display: block;
                                    text-align: center;
                                    color: #3FC1C9;
                                    font-size: 18px;
                                }

                                #engine-time > ul > li > span.plus-icon {
                                    width: 30px;
                                    height: 30px;
                                    border-radius: 50%;
                                    border: solid 2px #DAE1E8;
                                    margin: 0 auto;
                                    position: relative;
                                }

                                #engine-time > ul >  li > span.plus-icon:before,
                                #engine-time > ul >  li > span.plus-icon:after {
                                    content: ' ';
                                    display: block;
                                    position: absolute;
                                    background-color: #DAE1E8;

                                }

                                #engine-time > ul > li > span.plus-icon:before {
                                    width: 4px;
                                    height: 16px;
                                    top: 50%;
                                    margin-top: -8px;
                                    left: 50%;
                                    margin-left: -2px;
                                }

                                #engine-time > ul > li > span.plus-icon:after {
                                    height: 4px;
                                    width: 16px;
                                    top: 50%;
                                    margin-top: -2px;
                                    left: 50%;
                                    margin-left: -8px;
                                }

                                #engine-time > ul > li:hover {
                                    border-bottom: 0;
                                }

                                #engine-time > ul > li:hover > span.plus-icon {
                                    border: solid 2px #3FC1C9;
                                }

                                #engine-time > ul > li:hover > span.plus-icon:after,
                                #engine-time > ul > li:hover > span.plus-icon:before {
                                    background-color: #3FC1C9;
                                }

                                #engine-time > ul > li .engine-time-resource {
                                    position: absolute;
                                    margin-top: 15px;
                                    width: 232px;
                                    border: solid 2px #3FC1C9;
                                    border-top: 0;
                                    cursor: default;
                                    display:none;
                                    background-color: #fff;
                                    left: -2px;
                                }

                                #engine-time > ul > li:hover .engine-time-resource {
                                    display: block;
                                }

                                #engine-time > ul > li  .engine-time-resource > ul > li {
                                    float: left;
                                    width: 50%;
                                    padding: 0 5px;
                                    margin-top: 5px;
                                    margin-bottom: 3px;
                                }

                                #engine-time > ul > li  .engine-time-resource > ul > li#avail-resource {
                                    border-right: solid 1px #DAE1E8;
                                }


                                #engine-time > ul > li  .engine-time-resource > ul > li#avail-quota{
                                    border-left: solid 1px #DAE1E8;
                                }


                                #engine-time > ul > li .engine-time-resource > ul > li#avail-quota .title {
                                    background-color: #FBB03B;
                                }

                                #engine-time > ul > li .engine-time-resource > ul > li .title {
                                    font-size: 10px;
                                    line-height: 15px;
                                    text-align: center;
                                    background-color: #3C3F54;
                                    color: #fff;
                                    margin-bottom: 5px;
                                }

                                #engine-time > ul > li .engine-time-resource > ul > li > ul li {
                                    font-size: 10px;
                                    color: #3FC1C9;
                                    position: relative;
                                    white-space: nowrap;
                                    overflow: hidden;
                                    text-overflow: ellipsis;
                                    padding-right: 20px;
                                    line-height: 20px;
                                }

                                #engine-time > ul > li .engine-time-resource > ul > li > ul li span {
                                    position: absolute;
                                    right: 0;
                                }
                            </style>
                            <div id="engine-table">
                                <div id="engine-time">
                                    <ul class="clearfix">
                                        <li>
                                            <span>08:00</span>
                                            <span class="plus-icon"></span>
                                            <div class="engine-time-resource">
                                                <ul class="clearfix">
                                                    <li id="avail-resource">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A adsfdsa fsa <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A dsfa dsf ads<span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A afds fsdf<span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                    <li  id="avail-quota">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li><li>
                                            <span>08:00</span>
                                            <span class="plus-icon"></span>
                                            <div class="engine-time-resource">
                                                <ul class="clearfix">
                                                    <li id="avail-resource">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A adsfdsa fsa <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A dsfa dsf ads<span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A afds fsdf<span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                    <li  id="avail-quota">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li><li>
                                            <span>08:00</span>
                                            <span class="plus-icon"></span>
                                            <div class="engine-time-resource">
                                                <ul class="clearfix">
                                                    <li id="avail-resource">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A adsfdsa fsa <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A dsfa dsf ads<span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A afds fsdf<span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                    <li  id="avail-quota">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li><li>
                                            <span>08:00</span>
                                            <span class="plus-icon"></span>
                                            <div class="engine-time-resource">
                                                <ul class="clearfix">
                                                    <li id="avail-resource">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A adsfdsa fsa <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A dsfa dsf ads<span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A afds fsdf<span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                    <li  id="avail-quota">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li><li>
                                            <span>08:00</span>
                                            <span class="plus-icon"></span>
                                            <div class="engine-time-resource">
                                                <ul class="clearfix">
                                                    <li id="avail-resource">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A adsfdsa fsa <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A dsfa dsf ads<span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A afds fsdf<span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                    <li  id="avail-quota">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li><li>
                                            <span>08:00</span>
                                            <span class="plus-icon"></span>
                                            <div class="engine-time-resource">
                                                <ul class="clearfix">
                                                    <li id="avail-resource">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A adsfdsa fsa <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A dsfa dsf ads<span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A afds fsdf<span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                    <li  id="avail-quota">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li><li>
                                            <span>08:00</span>
                                            <span class="plus-icon"></span>
                                            <div class="engine-time-resource">
                                                <ul class="clearfix">
                                                    <li id="avail-resource">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A adsfdsa fsa <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A dsfa dsf ads<span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A afds fsdf<span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                    <li  id="avail-quota">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li><li>
                                            <span>08:00</span>
                                            <span class="plus-icon"></span>
                                            <div class="engine-time-resource">
                                                <ul class="clearfix">
                                                    <li id="avail-resource">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A adsfdsa fsa <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A dsfa dsf ads<span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A afds fsdf<span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                    <li  id="avail-quota">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li><li>
                                            <span>08:00</span>
                                            <span class="plus-icon"></span>
                                            <div class="engine-time-resource">
                                                <ul class="clearfix">
                                                    <li id="avail-resource">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A adsfdsa fsa <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A dsfa dsf ads<span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A afds fsdf<span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                    <li  id="avail-quota">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li><li>
                                            <span>08:00</span>
                                            <span class="plus-icon"></span>
                                            <div class="engine-time-resource">
                                                <ul class="clearfix">
                                                    <li id="avail-resource">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A adsfdsa fsa <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A dsfa dsf ads<span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A afds fsdf<span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                    <li  id="avail-quota">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li><li>
                                            <span>08:00</span>
                                            <span class="plus-icon"></span>
                                            <div class="engine-time-resource">
                                                <ul class="clearfix">
                                                    <li id="avail-resource">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A adsfdsa fsa <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A dsfa dsf ads<span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A afds fsdf<span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                    <li  id="avail-quota">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li><li>
                                            <span>08:00</span>
                                            <span class="plus-icon"></span>
                                            <div class="engine-time-resource">
                                                <ul class="clearfix">
                                                    <li id="avail-resource">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A adsfdsa fsa <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A dsfa dsf ads<span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A afds fsdf<span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                    <li  id="avail-quota">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li><li>
                                            <span>08:00</span>
                                            <span class="plus-icon"></span>
                                            <div class="engine-time-resource">
                                                <ul class="clearfix">
                                                    <li id="avail-resource">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A adsfdsa fsa <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A dsfa dsf ads<span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A afds fsdf<span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                    <li  id="avail-quota">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li><li>
                                            <span>08:00</span>
                                            <span class="plus-icon"></span>
                                            <div class="engine-time-resource">
                                                <ul class="clearfix">
                                                    <li id="avail-resource">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A adsfdsa fsa <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A dsfa dsf ads<span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A afds fsdf<span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                    <li  id="avail-quota">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li><li>
                                            <span>08:00</span>
                                            <span class="plus-icon"></span>
                                            <div class="engine-time-resource">
                                                <ul class="clearfix">
                                                    <li id="avail-resource">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A adsfdsa fsa <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A dsfa dsf ads<span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A afds fsdf<span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                    <li  id="avail-quota">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li><li>
                                            <span>08:00</span>
                                            <span class="plus-icon"></span>
                                            <div class="engine-time-resource">
                                                <ul class="clearfix">
                                                    <li id="avail-resource">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A adsfdsa fsa <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A dsfa dsf ads<span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A afds fsdf<span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                    <li  id="avail-quota">
                                                        <div class="title">
                                                            Avail. Resources
                                                        </div>
                                                        <ul>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                            <li>
                                                                Resource A <span>1</span>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li>

                                    </ul>
                                </div>
                                <style>
                                    #engine-table #engine-lines {
                                        position: absolute;
                                        top: 80px;
                                        bottom: 0;
                                        left: 0;
                                    }

                                    #engine-table #engine-lines > ul {
                                        height: 100%;
                                        white-space: nowrap;
                                    }

                                    #engine-table #engine-lines > ul > li {
                                        display: inline-block;
                                        width: 115px;
                                        height: 100%;
                                        border-right: solid 2px #DAE1E8;

                                    }
                                </style>

                                <div id="engine-lines">
                                    <ul>
                                        <li>

                                        </li><li>

                                        </li><li>

                                        </li><li>

                                        </li><li>

                                        </li><li>

                                        </li><li>

                                        </li><li>

                                        </li><li>

                                        </li><li>

                                        </li>
                                    </ul>

                                </div>

                                <div id="engine-bookings-body">
                                    <ul>
                                        <li>
                                            <div class="booking-session">
                                                <div class="booking-time">
                                                    08:00
                                                </div>
                                                <div class="package-title">
                                                    Package Title
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            Package
                                        </li>
                                        <li>
                                            Package
                                        </li>
                                        <li>
                                            Package
                                        </li>
                                        <li>
                                            Package
                                        </li>
                                        <li>
                                            Package
                                        </li>
                                        <li>
                                            Package
                                        </li>
                                        <li>
                                            Package
                                        </li>
                                        <li>
                                            Package
                                        </li>
                                        <li>
                                            Package
                                        </li>
                                        <li>
                                            Package
                                        </li>
                                    </ul>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script>
        var now = '${requestScope.timeNow}';
    </script>
</html>
