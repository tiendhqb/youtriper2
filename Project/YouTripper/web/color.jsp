<%-- 
    Document   : color
    Created on : Oct 8, 2015, 4:15:28 PM
    Author     : Nick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--        <meta name="viewport" content="width=device-width, initial-scale=1">-->
<meta name="viewport" content="width=1366">
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
            $(document).ready(function () {
                $('.simple_color_callback').simpleColor({
                    livePreview: true,
                    onSelect: function (hex, element) {
                        alert("You selected #" + hex + " for input #" + element.attr('class'));
                        return false;
                    }
                });
            });
        </script>
    </head>
    <body>
        <h1> Hello World! </h1>
        <input class='simple_color_callback' value='#cc3333'/>
    </body>
</html>
