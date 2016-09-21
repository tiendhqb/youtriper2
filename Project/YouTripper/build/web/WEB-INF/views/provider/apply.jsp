<%-- 
    Document   : apply
    Created on : Oct 15, 2015, 3:10:02 PM
    Author     : Nick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html id="loginPage" >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=1366">
        <!--        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1">-->
        <!--<script src='https://www.google.com/recaptcha/api.js'></script>-->

        <!-- Bootstrap -->

        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">

        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css?999999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css?999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >

        <%@ include file="../angular.jsp" %>

        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>

        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <title>YouTripper - Thank You</title>
    </head>
    <body style="background-color: #f2f2f4;">
        <div ng-app="YouTripper" class="pagesearch">
            <%@ include file="../header.jsp" %>
            <div id="survey-page">
                <div class="survey-row">
                    <img alt="" src="<c:url value="/Images/Icon/thankyou.svg"/>" />
                    <h2>Thank you for taking your time to post your <br>
                        first complete activity package.</h2>
                    <br>
                    <p>You are now part of Asia’s smartest activity selling platform and can enjoy a free <br>
                        booking engine and other smart business management tools.</p>
                    <br>
                    <p>We would greatly appreciate it if you could take 5 minutes to let us know your experience of filling in the package registration. <br>
                        We are constantly working to make things simpler and easier for you but we need your help.</p>
                </div>
                <div class="survey-row">
                    <ul class="clearfix steps">
                        <li>
                            <div class="step-survey done">
                                1
                            </div>
                        </li>
                        <li>
                            <div class="step-survey active">
                                2
                            </div>
                        </li>
                        <li>
                            <div class="step-survey ">
                                3
                            </div>
                        </li>
                        <li>
                            <div class="step-survey ">
                                4
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="survey-row table-survey" ng-show="false">
                    <p class="question">1. How do you feel about the 5 step process of listing your activities and offerings on youtripper.com?</p>
                    <div class="question-table">
                        <ul>
                            <li class="table-row first-row">
                                <ul class="clearfix table-row-header">
                                    <li class="table-row-step">
                                        &nbsp;
                                    </li>
                                    <li>
                                        <div>
                                            <p>I don’t like it</p>
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <p>Should be better</p>
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <p>It’s ok, it works</p>
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <p>I like it</p>
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <p>I love it</p>
                                        </div>
                                    </li>
                                </ul>
                            </li>
                            <li class="table-row">
                                <ul  class="clearfix">
                                    <li class="table-row-step">
                                        <p>Select your category!</p>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="1">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="2">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="3">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="4">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="5">
                                        </div>
                                    </li>
                                </ul>
                            </li>
                            <li class="table-row">
                                <ul class="clearfix">
                                    <li class="table-row-step">
                                        <p>Step 2: Describe it!</p>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="1">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="2">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="3">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="4">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="5">
                                        </div>
                                    </li>
                                </ul>
                            </li>
                            <li class="table-row">
                                <ul  class="clearfix">
                                    <li class="table-row-step">
                                        <p>Step 3: Upload great photos</p>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="1">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="2">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="3">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="4">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="5">
                                        </div>
                                    </li>
                                </ul>
                            </li>
                            <li class="table-row">
                                <ul  class="clearfix">
                                    <li class="table-row-step">
                                        <p>Step 4: Post your price</p>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="1">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="2">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="3">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="4">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="5">
                                        </div>
                                    </li>
                                </ul>
                            </li>
                            <li class="table-row last-row">
                                <ul  class="clearfix">
                                    <li class="table-row-step">
                                        <p>Step 5: Set up your booking</p>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="1">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="2">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="3">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="4">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="5">
                                        </div>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="survey-row single-choice-survey">
                    <p class="question">1. How do you feel about the 5 step process of listing your activities and offerings on youtripper.com?</p>
                    <ul class="answer">
                        <li><div> <input type="radio" name="result" value="1">a. The steps were clearly presented and I understood the meaning of every requirement.</div></li>
                        <li><div> <input type="radio" name="result" value="1">b. I was able to navigate the different steps but some requirements during the process made me feel confused.</div></li>
                        <li><div> <input type="radio" name="result" value="1">c. The whole process from start to finish was very confusing and made me feel lost.</div></li>
                    </ul>
                </div>

                <div class="addition-question type-input" ng-show="false">
                    <p class="question">Can you list three good things about this package activity registration process?</p>
                    <textarea class="blueTextArea greyFont">
                    </textarea>
                    <input class="nothing-mind" type="radio" name="addition" value="0">Nothing comes to mind
                </div>

                <div class="addition-question type-add-requirement"  ng-show="false">
                    <p class="question">Do you remember which requirement</p>
                    <select class="blueInput">
                        <option value="">Location</option>
                    </select>
                    <button type="submit" class="btn-width-orange" value="Add">Add</button>
                    <div class="each-requirement">
                        <p>1. Location</p>
                        <textarea class="blueTextArea greyFont">
                        </textarea>
                        <input class="nothing-mind" type="radio" name="addition" value="0">Nothing comes to mind
                    </div>
                    <div class="each-requirement">
                        <p>2. Location</p>
                        <textarea class="blueTextArea greyFont">
                        </textarea>
                        <input class="nothing-mind" type="radio" name="addition" value="0">Nothing comes to mind
                    </div>
                    <div class="each-requirement">
                        <p>3. Location</p>
                        <textarea class="blueTextArea greyFont">
                        </textarea>
                        <input class="nothing-mind" type="radio" name="addition" value="0">Nothing comes to mind
                    </div>

                </div>    

                <div class="addition-question type-table-score"  ng-show="true">
                    <p class="question">For the 5 steps of the process can you please indicate the level of confusion</p>
                     <div class="question-table">
                        <ul>
                            <li class="table-row first-row">
                                <ul class="clearfix table-row-header">
                                    <li class="table-row-step">
                                        &nbsp;
                                    </li>
                                    <li>
                                        <div>
                                            <p>I don’t like it</p>
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <p>Should be better</p>
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <p>It’s ok, it works</p>
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <p>I like it</p>
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <p>I love it</p>
                                        </div>
                                    </li>
                                </ul>
                            </li>
                            <li class="table-row">
                                <ul  class="clearfix">
                                    <li class="table-row-step">
                                        <p>Select your category!</p>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="1">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="2">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="3">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="4">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="5">
                                        </div>
                                    </li>
                                </ul>
                            </li>
                            <li class="table-row">
                                <ul class="clearfix">
                                    <li class="table-row-step">
                                        <p>Step 2: Describe it!</p>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="1">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="2">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="3">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="4">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="5">
                                        </div>
                                    </li>
                                </ul>
                            </li>
                            <li class="table-row">
                                <ul  class="clearfix">
                                    <li class="table-row-step">
                                        <p>Step 3: Upload great photos</p>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="1">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="2">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="3">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="4">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="5">
                                        </div>
                                    </li>
                                </ul>
                            </li>
                            <li class="table-row">
                                <ul  class="clearfix">
                                    <li class="table-row-step">
                                        <p>Step 4: Post your price</p>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="1">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="2">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="3">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="4">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="5">
                                        </div>
                                    </li>
                                </ul>
                            </li>
                            <li class="table-row last-row">
                                <ul  class="clearfix">
                                    <li class="table-row-step">
                                        <p>Step 5: Set up your booking</p>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="1">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="2">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="3">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="4">
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <input type="radio" name="score" value="5">
                                        </div>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                     <p class="question">Can you list three good things about this package activity registration process?</p>
                    <textarea class="blueTextArea greyFont">
                    </textarea>
                    <input class="nothing-mind" type="radio" name="addition" value="0">Nothing comes to mind
                </div>    

                <div class="survey-row">
                    <button type="submit" class="btn-width-orange" value="Search">Next Question</button>
                </div>
            </div>
        </div>

        <!--CONTENT-->

        <%--<%@ include file="../footer.jsp" %>--%>
        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js?999"/>"></script>
        <script>
                        var page = '${requestScope.page}';
                        $(document).ready(function () {
                            toggleHeader.init({
                                toggleControl: false
                            });
                        });
        </script>
        <script src="<c:url value="/Resources/Theme/js/youtripper.js?999999999999999999999999999999999999999999999999999999"/>"></script>
    </body>
</html>
