<%-- 
    Document   : uploadImage
    Created on : Oct 9, 2015, 2:49:23 PM
    Author     : Nick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=1366">
<!--        <meta name="viewport" content="width=device-width, initial-scale=1">-->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>YouTripper - Create Package</title>

        <!-- Bootstrap -->
        <link href="<c:url value="/Resources/Theme/css/bootstrap-theme.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/Resources/Theme/css/jquery.tag-editor.css"/>" rel="stylesheet">
        <!--<link href="<c:url value="/Resources/Theme/css/jquery.steps.css"/>" rel="stylesheet">-->
        <link href="<c:url value="/Resources/Theme/css/smart_wizard.css"/>" rel="stylesheet" type="text/css">
        <link href="<c:url value="/Resources/Theme/css/pepper-ginder-custom.css"/>" rel="stylesheet">


        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Include all compiled plugins (below), or include individual files as needed -->

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
        <script>

            function uploadFormData(element) {
                $('#result').html('');

                var oMyForm = new FormData();
                var isValid = true;
                for (var i = 0; i < element.files.length; i++) {
                    var filename = element.files[i].name;
                    if (!(/\.(gif|jpg|jpeg|tiff|png)$/i).test(filename)) {
                        isValid = false;
                        break;
                    }
                    oMyForm.append("files[]", element.files[i]);
                }
                if (isValid) {
                    $.ajax({
                        url: "<c:url value="/Package/multipleSave"/>",
                        data: oMyForm,
                        dataType: 'text',
                        processData: false,
                        contentType: false,
                        type: 'POST',
                        beforeSend: function (jqXHR, settings) {
                            $("#gallery").html("<img src='/Images/Icon/loading.gif'/>");
                        },
                        success: function (data) {
                            var newImage = "";
                            if (data !== "false") {
                                for (var i = 0; i <= parseInt(data); i++) {
                                    newImage += "<img class='uploadedImage' style='cursor: pointer; height: 150px; width: 150px' src='/YouTripper/Package/get/" + i + "'/>";
                                }
                                $("#gallery").html(newImage);
                            } else {
                                alert("Wrong input!");
                            }
                        },
                        error: function (response) {
                            alert("Error");
                        }
                    });
                } else {
                    alert("Please select image files!");
                }
            }

            $(document).on('click', 'img.uploadedImage', function () {
//                $(this).remove();   
                var mainElement = $(this);
                var data = $("img.uploadedImage").index($(this));
                $.ajax({
                    url: "<c:url value="/Package/deleteImage"/>",
                    data: data.toString(),
                    dataType: 'text',
                    processData: false,
                    contentType: false,
                    type: 'POST',
                    success: function (data) {
                        alert(data);
                        if (data !== "false") {
                            mainElement.remove();
                        }
                    },
                    error: function (response) {
                        alert("Error");
                    }
                });
            });

            $(document).on('change', '.upload input', function () {
                uploadFormData(this);
            });

//            $(document).ready(function () {
//                $('.upload input').on("change", function () {
//                    alert("aaa");
//                    alert($(this).attr("id"));
////                    uploadFormData(this);
//                });
//            });
        </script>
    </head>
    <style>
        div.upload {
            width: 157px;
            height: 57px;
            background: url(https://lh6.googleusercontent.com/-dqTIJRTqEAQ/UJaofTQm3hI/AAAAAAAABHo/w7ruR1SOIsA/s157/upload.png);
            overflow: hidden;
        }

        div.upload input {
            cursor: pointer;
            display: block !important;
            width: 157px !important;
            height: 57px !important;
            opacity: 0 !important;
            overflow: hidden !important;
        }
    </style>
    <body>
        <i>Uploading File With Ajax</i><br/>
        <div id="gallery">
        </div>
        <div class="upload">
            <input name="files" id="files" type="file" accept="image/*" multiple/><br/>
        </div>
    </body>
</html>
