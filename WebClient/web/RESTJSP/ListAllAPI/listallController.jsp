<%-- 
    Document   : listallController
    Created on : 1-Apr-2020, 10:48:29 PM
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
        function toGetAllListBook(){
            var type = document.getElementById("type").value;
            window.location.href = "http://localhost:8080/WebClient/RESTJSP/ListAllAPI/listall_"+ type+".jsp"; 
        }
    </script>
    <body>
        <h1>Hello World!</h1>
         <select id="type">
            <option value="json">JSON</option>
            <option value="xml">XML</option>
            <option value="text">TEXT</option>
            <option value="html">HTML</option>
        </select>
        <button onclick="toGetAllListBook()">click</button>
    </body>
    </body>
</html>
