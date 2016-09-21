<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta name="viewport" content="width=1366">
        <title>Hello WebSocket</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="<c:url value="/Resources/Theme/js/sockjs-0.3.4.js"/>"></script>
        <script src="<c:url value="/Resources/Theme/js/stomp.js"/>"></script>
        <script type="text/javascript">
            $("#uploadbutton").on("click", function () {
                var formData = new FormData($('#uploadForm')[0]);
                $.ajax({
                    url: "/Message/File/upload",
                    type: "POST",
                    dataType: 'text',
                    contentType: false,
                    processData: false,
                    cache: false,
                    data: formData,
                    success: function (response) {
                        alert("success");
                    },
                    error: function () {
                        alert(response);
                    }
                });
        </script>
    </head>
    <body onload="disconnect()">
        <noscript><h2 style="color: #ff0000">Seems your browser doesn't support Javascript! Websocket relies on Javascript being enabled. Please enable
                Javascript and reload this page!</h2></noscript>
        <div>
            <form id="uploadForm">
                <input type="file" name="myimage" id="imageid" accept=".png" />
                <button id="uploadbutton" value="Upload">
            </form>
        </div>
    </body>
</html>
