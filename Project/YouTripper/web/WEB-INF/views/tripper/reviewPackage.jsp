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

        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css?999999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css?999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >

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
        <title>Review Package</title>
    </head>
    <body>
        <div class="pagesearch" ng-app="YouTripper" ng-controller="reviewPackageController" style="background-color: #f2f2f4">
            <%@ include file="../header.jsp" %>

            <div class="container padding-header review-container" style="background-color: white">
                <div class="content">
                    <form method="POST" 
                          action="
                          <c:choose>
                              <c:when test="${empty param.language}">
                                  <c:url value="/Tripper/MakeReview"/>
                              </c:when>
                              <c:otherwise>
                                  <c:url value="/Tripper/MakeReview?language=${param.language}"/>
                              </c:otherwise>
                          </c:choose>" 
                          name="ReviewForm" ng-submit="validateReview($event)">
                        <div class="title"> Leave the review and vote for this package</div>

                        <p ng-show="{{(covenient === 0|| AmenityQuality === 0 || Cleanliness === 0 || Professionlism === 0 || StaffAttitude === 0 || Satisfaction === 0)}}">Please rate completely all the criteria below</p>
                        <input class="hidden" name="rateScore" max="5" ng-model="totalStar" ng-value="{{totalStar}}" >  


                        <div>
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th></th>
                                        <th class="newRatingCriteria">Below Expectation</th>
                                        <th class="newRatingCriteria">Could have been better</th>
                                        <th class="newRatingCriteria">Well done</th>
                                        <th class="newRatingCriteria">Great Experience</th>
                                        <th class="newRatingCriteria">Absolutely Awesome</th>                                       
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Access</td>
                                        <td><div class="tempCheckbox">
                                                <input name="Convenient" ng-model="covenient" type="radio" value="1" convert-to-number />
                                                <span></span>
                                            </div></td>
                                        <td><div class="tempCheckbox">
                                                <input name="Convenient" ng-model="covenient" type="radio" value="2" convert-to-number/>
                                                <span></span>
                                            </div></td>
                                        <td><div class="tempCheckbox">
                                                <input name="Convenient" ng-model="covenient" type="radio" value="3" convert-to-number/>
                                                <span></span>
                                            </div></td>
                                        <td><div class="tempCheckbox">
                                                <input name="Convenient" ng-model="covenient" type="radio" value="4" convert-to-number/>
                                                <span></span>
                                            </div></td>
                                        <td><div class="tempCheckbox">
                                                <input name="Convenient" ng-model="covenient" type="radio" value="5" convert-to-number/>
                                                <span></span>
                                            </div></td>
                                    </tr>  
                                    <tr>
                                        <td>Amenities</td>
                                        <td><div class="tempCheckbox">
                                                <input name="AmenityQuality" ng-model="AmenityQuality" type="radio" value="1" convert-to-number/>
                                                <span></span>
                                            </div></td>
                                        <td><div class="tempCheckbox">
                                                <input name="AmenityQuality" ng-model="AmenityQuality" type="radio" value="2" convert-to-number/>
                                                <span></span>
                                            </div></td>
                                        <td><div class="tempCheckbox">
                                                <input name="AmenityQuality" ng-model="AmenityQuality" type="radio" value="3" convert-to-number/>
                                                <span></span>
                                            </div></td>
                                        <td><div class="tempCheckbox">
                                                <input name="AmenityQuality" ng-model="AmenityQuality" type="radio" value="4" convert-to-number/>
                                                <span></span>
                                            </div></td>
                                        <td><div class="tempCheckbox">
                                                <input name="AmenityQuality" ng-model="AmenityQuality" type="radio" value="5" convert-to-number/>
                                                <span></span>
                                            </div></td>
                                    </tr>
                                    <tr>
                                        <td>Cleanliness</td>
                                        <td><div class="tempCheckbox">
                                                <input name="Cleanliness" ng-model="Cleanliness" type="radio" value="1" convert-to-number/>
                                                <span></span>
                                            </div></td>
                                        <td><div class="tempCheckbox">
                                                <input name="Cleanliness" ng-model="Cleanliness" type="radio" value="2" convert-to-number/>
                                                <span></span>
                                            </div></td>
                                        <td><div class="tempCheckbox">
                                                <input name="Cleanliness" ng-model="Cleanliness" type="radio" value="3" convert-to-number/>
                                                <span></span>
                                            </div></td>
                                        <td><div class="tempCheckbox">
                                                <input name="Cleanliness" ng-model="Cleanliness" type="radio" value="4" convert-to-number/>
                                                <span></span>
                                            </div></td>
                                        <td><div class="tempCheckbox">
                                                <input name="Cleanliness" ng-model="Cleanliness" type="radio" value="5" convert-to-number/>
                                                <span></span>
                                            </div></td>
                                    </tr>
                                    <tr>
                                        <td>Professionalism</td>
                                        <td><div class="tempCheckbox">
                                                <input name="Professionlism" ng-model="Professionlism" type="radio" value="1" convert-to-number/>
                                                <span></span>
                                            </div></td>
                                        <td><div class="tempCheckbox">
                                                <input name="Professionlism" ng-model="Professionlism" type="radio" value="2" convert-to-number/>
                                                <span></span>
                                            </div></td>
                                        <td><div class="tempCheckbox">
                                                <input name="Professionlism" ng-model="Professionlism" type="radio" value="3" convert-to-number/>
                                                <span></span>
                                            </div></td>
                                        <td><div class="tempCheckbox">
                                                <input name="Professionlism" ng-model="Professionlism" type="radio" value="4" convert-to-number/>
                                                <span></span>
                                            </div></td>
                                        <td><div class="tempCheckbox">
                                                <input name="Professionlism" ng-model="Professionlism" type="radio" value="5" convert-to-number/>
                                                <span></span>
                                            </div></td>
                                    </tr>
                                    <tr>
                                        <td>Staff Attitude</td>
                                        <td><div class="tempCheckbox">
                                                <input name="StaffAttitude" ng-model="StaffAttitude" type="radio" value="1" convert-to-number/>
                                                <span></span>
                                            </div></td>
                                        <td><div class="tempCheckbox">
                                                <input name="StaffAttitude" ng-model="StaffAttitude" type="radio" value="2" convert-to-number/>
                                                <span></span>
                                            </div></td>
                                        <td><div class="tempCheckbox">
                                                <input name="StaffAttitude" ng-model="StaffAttitude" type="radio" value="3" convert-to-number/>
                                                <span></span>
                                            </div></td>
                                        <td><div class="tempCheckbox">
                                                <input name="StaffAttitude" ng-model="StaffAttitude" type="radio" value="4" convert-to-number/>
                                                <span></span>
                                            </div></td>
                                        <td><div class="tempCheckbox">
                                                <input name="StaffAttitude" ng-model="StaffAttitude" type="radio" value="5" convert-to-number/>
                                                <span></span>
                                            </div></td>
                                    </tr>
                                    <tr>
                                        <td>Satisfaction</td>
                                        <td><div class="tempCheckbox">
                                                <input name="Satisfaction" ng-model="Satisfaction" type="radio" value="1" convert-to-number/>
                                                <span></span>
                                            </div></td>
                                        <td><div class="tempCheckbox">
                                                <input name="Satisfaction" ng-model="Satisfaction" type="radio" value="2" convert-to-number/>
                                                <span></span>
                                            </div></td>
                                        <td><div class="tempCheckbox">
                                                <input name="Satisfaction" ng-model="Satisfaction" type="radio" value="3" convert-to-number/>
                                                <span></span>
                                            </div></td>
                                        <td><div class="tempCheckbox">
                                                <input name="Satisfaction" ng-model="Satisfaction" type="radio" value="4" convert-to-number/>
                                                <span></span>
                                            </div></td>
                                        <td><div class="tempCheckbox">
                                                <input name="Satisfaction" ng-model="Satisfaction" type="radio" value="5" convert-to-number/>
                                                <span></span>
                                            </div></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>

                        <!--                        <div class="row" style="margin: 0 auto;">
                                                    <div class="ratingAttribute col-lg-6 col-sm-6 col-xs-12 ">
                                                        <input class="ratingAttributeValue" name="Professionlism" type="number" min="0" max="10" id="" value="0">
                                                        <span class="ratingAttributeTitle">Professionalism</span>
                                                    </div>
                                                    <div class="ratingAttribute col-lg-6 col-sm-6 col-xs-12 right">
                                                        <input class="ratingAttributeValue" name="StaffAttitude" type="number" min="0" max="10" id="" value="0">
                                                        <span class="ratingAttributeTitle">Staff Attitude</span>
                                                    </div>
                                                    <div class="ratingAttribute col-lg-6 col-sm-6 col-xs-12">
                                                        <input class="ratingAttributeValue" name="Convenient" type="number" min="0" max="10" id="" value="0">
                                                        <span class="ratingAttributeTitle">Cleanliness</span>
                                                    </div>
                                                    <div class="ratingAttribute col-lg-6 col-sm-6 col-xs-12 right">
                                                        <input class="ratingAttributeValue" name="Satisfaction" type="number" min="0" max="10" id="" value="0">
                                                        <span class="ratingAttributeTitle">Access</span>
                                                    </div>
                                                    <div class="ratingAttribute col-lg-6 col-sm-6 col-xs-12">
                                                        <input class="ratingAttributeValue" name="AmenityQuality" type="number" min="0" max="10" id="" value="0">
                                                        <span class="ratingAttributeTitle">Amenity Quality</span>
                                                    </div>
                                                    <div class="ratingAttribute col-lg-6 col-sm-6 col-xs-12 right">
                                                        <input class="ratingAttributeValue" name="Cleanliness" type="number" min="0" max="10" id="" value="0">
                                                        <span class="ratingAttributeTitle">Satisfaction</span>
                                                    </div>
                                                </div>-->
                        <div class="review">
                            <strong>Write your review for this package</strong><br/>
                            <textarea style="width: 570px; border: 2px solid rgb(120, 201, 221);" name="reviewDetail" class="normalFont" placeholder="Your review for this package"></textarea><br>
                            <input name="packageID" type="hidden" value="${requestScope.packageID}">        
                            <input name="bookingID" type="hidden" value="${requestScope.bookingID}">     
                            <input type="submit" name="submit" value="Send" style="margin: 0 auto;" class="btn btn-save">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <%@ include file="../footer.jsp" %>
        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/main.js?999"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.raty.js"/>"></script>
        <script>

                                                    $("#rateFilter").raty({
                                                        starOff: '<c:url value="/Resources/Theme/image/star-off.png"/>',
                                                        starOn: '<c:url value="/Resources/Theme/image/star-on.png"/>',
                                                        hints: ['bad', 'poor', 'regular', 'good', 'gorgeous'],
                                                        target: '#rateHints',
                                                        targetText: 'Please rate this package'
                                                    });
                                                    $(document).ready(function () {
                                                        toggleHeader.init({
                                                            toggleControl: false
                                                        });
                                                        $('.edit-account').click(function () {
                                                            if ($('.box-account-edit').is(":visible")) {
                                                            } else {
                                                                $('.box-account-edit').show();
                                                                $('.box-account-info').hide();
                                                            }
                                                        });
                                                    });
        </script>
    </body>
</html>
