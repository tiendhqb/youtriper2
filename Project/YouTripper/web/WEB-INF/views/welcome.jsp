<%-- 
    Document   : welcome
    Created on : Oct 29, 2015, 2:36:24 PM
    Author     : DINH KHANG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=1366">
        <title>Welcome Page</title>
        <style>
            div {
                position: relative;
                float:left;
                overflow: hidden;
                background: blue;
                height: 200px;
                width: 200px;
            }
            #element {
                position: relative;
                overflow: hidden;
                background: green;
                height: 200px;
                width: 200px;
            }
        </style>
    </head>
    <body>
        <div id="element">Element resizable</div>
        <div>Block1</div>
        <div>Block2</div>
    </body>
    <script>
        var element = document.getElementById('element');
        var resizer = document.createElement('div');
        resizer.className = 'resizer';
        resizer.style.width = '10px';
        resizer.style.height = '10px';
        resizer.style.background = 'red';
        resizer.style.position = 'absolute';
        resizer.style.right = 0;
        resizer.style.bottom = 0;
        resizer.style.cursor = 'se-resize';
        element.appendChild(resizer);
        resizer.addEventListener('mousedown', initResize, false);

        function initResize(e) {
            window.addEventListener('mousemove', Resize, false);
            window.addEventListener('mouseup', stopResize, false);
        }
        function Resize(e) {
            console.log(e.clientX);
            console.log(element.offsetLeft);
            element.style.width = (e.clientX - element.offsetLeft) + 'px';
            element.style.height = (e.clientY - element.offsetTop) + 'px';
        }
        function stopResize(e) {
            window.removeEventListener('mousemove', Resize, false);
            window.removeEventListener('mouseup', stopResize, false);
        }

    </script>
</html>
