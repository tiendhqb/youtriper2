<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Hello WebSocket</title>
        <meta name="viewport" content="width=1366">
        <script src="<c:url value="/Resources/Theme/js/sockjs-0.3.4.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/stomp.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/angular.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/checklist-model.js"/>"></script>


<!--<script src="<c:url value="/Resources/Theme/js/jquery-1.11.1.min.js"/>"></script>-->
        <script src="<c:url value="/Resources/Theme/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.min.js"/>"></script>

        <script src="<c:url value="/Resources/Theme/js/bootstrap.min.js"/>"></script>

        <script src="<c:url value="/Resources/Theme/js/modernizr-2.6.2.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.cookie-1.3.1.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/Resources/Theme/js/jquery.smartWizard.js"/>"></script>
       <!--<script type="text/javascript" src="<c:url value="/Resources/Theme/js/jquery.steps.js"/>"></script>-->

        <script src="<c:url value="/Resources/Theme/js/jquery.caret.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.tag-editor.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery-ui.multidatespicker.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/jquery.simple-color.js"/>"></script>

        <script src="<c:url value="/Resources/Theme/js/ng-file-upload-shim.min.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/ng-file-upload.min.js"/>"></script>
        <script type="text/javascript">
            var app = angular.module('myApp', ["checklist-model", "ngFileUpload"]);
            app.controller('PackageController', function ($scope, $http) {
                $scope.$watch('coverImage', function () {
                    if ($scope.coverImage !== undefined && $scope.coverImage !== null){
                        $scope.uploadCoverImage($scope.coverImage);
                    }
                });
                
                
                $scope.uploadCoverImage = function (coverImage) {
                    var formData = new FormData();
                    formData.append("coverImage", coverImage);
                    $.ajax({
                        url: "<c:url value="/Message/File/upload"/>",
                        type: "POST",
                        dataType: 'text',
                        contentType: false,
                        processData: false,
                        cache: false,
                        data: formData,
                        success: function (response) {
                            if (response !== "false") {
                                console.log("success");
                            } else {
                                alert("Wrong input!");
                            }
                        },
                        error: function (response) {
                            console.log(response);
                        }
                    });
                    alert("after ajax");
                };
            });
        </script>
    </head>
    <body onload="">
        <div  ng-app="myApp" ng-controller="PackageController">
            <noscript><h2 style="color: #ff0000">Seems your browser doesn't support Javascript! Websocket relies on Javascript being enabled. Please enable
                    Javascript and reload this page!</h2></noscript>

            <div ngf-drop ngf-select  ng-model="coverImage" class="drop-box" id="coverImage"
                 ngf-drag-over-class="dragover" ngf-allow-dir="true"
                 accept="*">
                <button id="clickhere">Image</button>
            </div>
             <img src="/Images/Khang/5_Web_0[1].jpg" height="42" width="42">
        </div>
    </body>
</html>
