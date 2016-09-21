<%-- 
    Document   : providerCertificate
    Created on : May 9, 2016, 3:37:52 PM
    Author     : Tien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="background-provider">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=1366">
        <!--        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1">-->
        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/jquery.fs.boxer.css"/>" rel="stylesheet">


        <%@ include file="../angular.jsp" %>

        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/style.css?999999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripper.css?999999999"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/responsive.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/animate.min.css"/>" >
        <link rel="stylesheet" href="<c:url value="/Resources/Theme/css/youtripperResponsive.css"/>" >

        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.fs.boxer.js"/>"></script>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <link rel="icon" href="<c:url value="/Images/Icon/favicon.png"/>" >
        <title>Youtripper - Provider Certificates</title>
    </head>
    <body>
        <div ng-app="YouTripper" ng-controller="ProviderCertificates" class="pagesearch bg-grey" >
            <%@ include file="../header.jsp" %>
            <%@ include file="providerMenubar.jsp" %>
            <div id="spinner-block" ng-hide="loaded">
                <div class="youtripper-spinner"></div>
            </div>

            <div class="site-container">
                <div class="affix-content">
                    <div class=""  ng-cloak ng-show="loaded" ng-controller="FixedComparisonController">
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane active" id="step3">
                                <div class="tab-bucket tab-bucket-fix">
                                    <h2>Your Certificate ({{certificates.length}})</h2>

                                    <input class="btn-width-orange" id="createButton" ng-click="activeCertificateUploadBox()" type="submit" value="Add New Certificate">

                                    <div>${requestScope.message}</div>
                                    <div class="row package">
                                        <div class="col-lg-4 col-sm-6 col-xs-12 package-box" ng-repeat="certificate in certificates" init-boxer>

                                            <div class="category-item-block">
                                                <!--<div class="item-image" style="background-image: url('{{package.coverImage}}')" balance-square>-->
                                                <div class="item-image"  balance-square>
                                                    <a data-toggle="modal" data-target="#myModal2" ng-click="changeName3(certificate.name, certificate.certificateID, certificate.image)" target="_self">


                                                        <div class="upload-certificateImageMain"> 
                                                            <!--                                                    <div class="item-image3"    style="border-top-left-radius:5px;border-top-right-radius:5px; background-image: url('{{certificate.image}}')" >
                                                                                                                </div>-->
                                                            <img ng-src="{{certificate.image}}?{{currentTime}}" />
                                                        </div>
                                                    </a>
                                                </div>
                                                <div class="item-detail2">
                                                    {{certificate.name}}
                                                </div>

                                            </div>
                                            <div  style="margin: 15px 0;">
<!--                                                <a href="<c:url value="/Provider/Package/Edition"/>/{{package.packageID}}" target="_self">
                                                    <span></span>
                                                    Delete this certificate
                                                </a>-->
                                                <div class="certificate-delete-tool">
                                                    <a href="<c:url value="/Provider/DeleteCertificate/"/>{{certificate.certificateID}}" target="_self">
                                                        <span class ="centerImageDelete"></span>
                                                        Delete this certificate
                                                    </a>
                                                </div>
                                                <div class="certificate-edit-tool">
                                                    <a ng-click="changeName2(certificate.name, certificate.certificateID, certificate.image)" target="_self">
                                                        <span  class ="centerImageEdit" ></span>
                                                        Edit this certificate 
                                                        </br>
                                                    </a>
                                                </div>
            <!--                                        <a href="<c:url value="/Provider/Package/Deletion"/>/{{package.packageID}}" target="_self">
                                                        <span></span>
                                                        Delete
                                                    </a>-->
                                                <div ng-show="certificate.isApproved === true" > 
                                                    <div class="certificateApproved">

                                                        <span  class ="centerImageEdit" ></span>
                                                        certificate is approved
                                                        </br>
                                                    </div>

                                                </div>
                                                <div ng-show="certificate.isApproved === false" >
                                                    <div class="certificatenotApproved">

                                                        <span  class ="centerImageEdit" ></span>
                                                        certificate is not approved
                                                        </br>

                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Modal -->
                                            <div class="modal fade" id="myModal" role="dialog">
                                                <div class="modal-dialog">

                                                    <!-- Modal content-->
                                                    <div class="modal-content">

                                                        <div class="modal-body">
                                                            <%--main contain --%>

                                                            <div class="tab-content" >

                                                                <h4 class="modal-title " id="certificateInfomation">Certificate Information</h4>
                                                                <div class="row " >
                                                                    <div class="upload-certificateImage col-md-6 col-xs-6">
                                                                        <img ngf-drop ngf-select  ng-change="CertificateUploadImage($index, {{certificateIDInit}})" ng-model="certificateImage2[$index]" style="cursor: pointer"
                                                                             ngf-drag-over-class="dragover" ngf-allow-dir="true"
                                                                             accept="image/*"
                                                                             ngf-pattern="'image/*'" alt="" ng-src="{{certificateImage3}}?{{currentTime}}" />
                                                                    </div>
                                                                    <div class="col-md-6 col-xs-6">
                                                                        <p id="blueText" ngf-drop ngf-select ng-change="CertificateUploadImage($index, {{certificateIDInit}})" ng-model="certificateImage2[$index]" style="cursor: pointer"
                                                                           ngf-drag-over-class="dragover" ngf-allow-dir="true"
                                                                           accept="image/*"
                                                                           ngf-pattern="'image/*'">Upload Certificate Picture</p>
                                                                    </div>

                                                                </div>


                                                                <div >
                                                                    <form class="form-horizontal profileCertificate-edit-box" ng-submit="validateForm($event)" name="certificateForm" action="<c:url value="/Provider/UpdateCertificateInformation"/>" method="POST">

                                                                        <div class="form-group provider-edit-form ">
                                                                            <div id="certificateName" class="col-sm-4 col-md-4 col-lg-4 ">
                                                                                Certificate name
                                                                            </div>
                                                                            <div class=" col-sm-7 col-md-7 col-lg-7">
                                                                                <input type="text" ng-model="certificateNameInit"  name="Name"
                                                                                       class="normalFont input-property small-input" placeholder="Your certificate name"/>
                                                                                <span style="color: red" ng-show="!certificateNameInit.length">Please enter certificate name</span>
                                                                            </div>
                                                                            <div class=" col-sm-8 col-md-8 col-lg-8">
                                                                                <input type="hidden" ng-model="certificateIDInit"  value="{{certificateIDInit}}" name="CertificateID"/>
                                                                            </div>
                                                                            <!--<div class="col-md-4">-->
                                                                        </div>


                                                                        <div class="form-group provider-edit-form">

                                                                            <div>
                                                                                <button type="submit" class="btn btn-save Tiencenter">Save</button>
                                                                            </div>

                                                                        </div>

                                                                    </form>

                                                                </div>







                                                            </div>
                                                            <!--                                                            <div class="modal-footer">
                                                                                                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                                                                                        </div>-->
                                                            <!--                                                        -->
                                                        </div>

                                                    </div>
                                                </div>
                                                <!-- End modal -->

                                            </div>

                                            <!--new modal-->
                                            <!-- Modal -->
                                            <!--                                            <div class="modal fade" id="myModal2" role="dialog">
                                                                                            <div class="modal-dialog">
                                            
                                                                                                 Modal content
                                                                                                <div class="">
                                            
                                                                                                    <div class="modal-body">
                                            <%--main contain --%>

                                            <div id ="bigCertificateImage" >
                                                <div >
                                                    <div style="width: 130%" class="certificateContent">
                                                        <span class="box-closing" ng-click="closeModal()"></span>
                                                        <img ngf-pattern="'image/*'" alt="" ng-src="{{certificateImage3}}?{{currentTime}}" />
                                                    </div>
                                                </div>
                                            </div>

                                        </div>

                                    </div>
                                </div>
                            </div> -->
                                            <!-- End modal -->

                                        </div>


                                    </div>

                                    <!--Big image POPUP-->
                                    <div id="bigCertificateImage" class="certificateBox">
                                        <div class="certificateContent">
                                            <span class="box-closing" ng-click="activeBigImageBox()"></span>

                                            <div class="row">
                                                <div class="col-xs-12">
                                                    <img ngf-pattern="'image/*'" alt="" ng-src="{{certificateImage3}}?{{currentTime}}" />
                                                </div>
                                            </div>

                                        </div>

                                    </div>
                                    <!--END big image POPUP-->

                                    <!--ADD POPUP-->
                                    <div id="certificateAddBox" class="certificateBox">
                                        <div class="certificateContent">
                                            <span class="box-closing" ng-click="activeCertificateUploadBox()"></span>
                                            <h4>Upload your certificate</h4>
                                            <div class="popupRow">
                                                <div class="row">
                                                    <div class="col-xs-12">
                                                        <input type="text" name="" value="" class="normalFont blueInput2"  ng-model="$parent.certificateImage"
                                                               placeholder="Certificate name" maxlength="20" ng-maxlength="20"/>
                                                        <span style="color: red" ng-show="$parent.showError && !$parent.certificateImage.length">Please enter certificate name</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="popupRow">
                                                <div class="row">
                                                    <div class="col-xs-12">
                                                        <div class="upload-large2 certificateUploadBox">
                                                            <a href="#" class="btn-upload"
                                                               ng-model="$parent.certificateImageFile" 
                                                               ngf-allow-dir="true" accept="image/*" ngf-pattern="'image/*'" ngf-select>
                                                                Add Photo
                                                            </a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="popupRow">
                                                <div class="row">
                                                    <div class="col-xs-12">

                                                        <div style="text-align: center">
                                                            <a href="#" class="btn-width-orange login_gg"
                                                               ng-model="$parent.certificateImageFile" 
                                                               ngf-allow-dir="true" accept="image/*" ngf-pattern="'image/*'" ngf-select >Browse your image</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="popupRow">
                                                <div class="row">
                                                    <div class="col-xs-12">

                                                        <div style="text-align: center">

                                                            <a href="" ng-click="saveCertificate()" class="btn-width-orange">Add</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-xs-12">

                                            </div>
                                        </div>
                                    </div>
                                    <!--END ADD POPUP-->

                                    <!--Edit POPUP-->
                                    <div id="certificateEditBox" class="certificateBox">
                                        <div class="certificateContent">
                                            <span class="box-closing" ng-click="reload()"></span>
                                            <h4>Certificate Information</h4>
                                            <form class="" ng-submit="validateForm($event)" name="certificateForm" 
                                                  action="
                                                  <c:choose>
                                                      <c:when test="${empty param.language}">
                                                          <c:url value="/Provider/UpdateCertificateInformation"/>
                                                      </c:when>
                                                      <c:otherwise>
                                                          <c:url value="/Provider/UpdateCertificateInformation?language=${param.language}"/>
                                                      </c:otherwise>
                                                  </c:choose>" 
                                                  method="POST">
                                                <div class="popupRow">
                                                    <div class="row">
                                                        <div class="col-xs-12">
                                                            <input type="text" ng-change="closeButtonClick()" ng-model="certificateNameInit"  name="Name"
                                                                   class="normalFont blueInput2" placeholder="Your certificate name"/>
                                                            <span style="color: red" ng-show="!certificateNameInit.length">Please enter certificate name</span>
                                                            <input type="hidden" ng-model="certificateIDInit"  value="{{certificateIDInit}}" name="CertificateID"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="popupRow">
                                                    <div class="row">
                                                        <div class="col-xs-12">
                                                            <div class="upload-large2 certificateUploadBox">
                                                                <img ngf-drop ngf-select  ng-change="CertificateUploadImage($index, {{certificateIDInit}})" ng-model="certificateImage2[$index]" style="cursor: pointer"
                                                                     ngf-drag-over-class="dragover" ngf-allow-dir="true"
                                                                     accept="image/*"
                                                                     ngf-pattern="'image/*'" alt="" ng-src="{{certificateImage3}}?{{currentTime}}" />
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="popupRow">
                                                    <div class="row">
                                                        <div class="col-xs-12">

                                                            <div style="text-align: center">

                                                                <a class="btn-width-orange login_gg" ngf-drop ngf-select ng-change="CertificateUploadImage($index, {{certificateIDInit}})" ng-model="certificateImage2[$index]" style="cursor: pointer"
                                                                   ngf-drag-over-class="dragover" ngf-allow-dir="true"
                                                                   accept="image/*"
                                                                   ngf-pattern="'image/*'" >Upload Certificate Picture</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="popupRow">
                                                    <div class="row">
                                                        <div class="col-xs-12">

                                                            <div style="text-align: center">
                                                                <button type="submit" class="btn-width-orange">Save</button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="row">
                                            <div class="col-xs-12">

                                            </div>
                                        </div>
                                    </div>
                                    <!--END EDIT POPUP-->

                                </div>


                            </div>

                        </div>

                    </div>

                    <%@ include file="../comparisonList.jsp" %>
                </div>
            </div>
        </div>
    </div>
    <%--<%@ include file="../footer.jsp" %>--%>
    <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
    <script src="<c:url value="/Resources/Theme/js/notify.js"/>"></script>
    <script src="<c:url value="/Resources/Theme/js/script.min.js?999999999999999999999999999"/>"></script>
    <script src="<c:url value="/Resources/Theme/js/main.js?999"/>"></script>
    <script>

                                                                    var certificates = ${requestScope.certificates};
                                                                    var page = '${requestScope.page}';
                                                                    //var temporaryPackage = ${requestScope.temporaryPackage};
                                                                    var userID = ${sessionScope.account.id};
                                                                    var uploadUrl = '<c:url value="/Provider/UploadUpdateCertificateImage"/>';
                                                                    $(document).ready(function () {
                                                                    toggleHeader.init({
                                                                    toggleControl: false
                                                                    });
                                                                    });
    </script>
</body>
</html>
