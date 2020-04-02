<%-- 
    Document   : getbookController
    Created on : 1-Apr-2020, 9:39:34 PM
    Author     : fokpoonkai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <script type="text/javascript">
        function toGetBook(){
            var type = document.getElementById("type").value;
            var id = document.getElementById("id").value;
             window.location.href = "http://localhost:8080/WebClient/RESTJSP/GetBookAPI/getBook_"+ type+".jsp?id="+id; 
        }
    </script>
    <body>
        <h1>Hello World!</h1>
        <input type="text" id="id" value="2">
        <select id="type">
            <option value="json">JSON</option>
            <option value="xml">XML</option>
            <option value="text">TEXT</option>
            <option value="html">HTML</option>
        </select>
        <button onclick="toGetBook()">click</button>
    </body>
</html>
