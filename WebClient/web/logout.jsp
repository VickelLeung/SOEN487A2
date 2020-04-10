<%-- 
    Document   : logout
    Created on : 3-Apr-2020, 11:50:36 PM
    Author     : fokpoonkai
--%>

<%@page import="login.username"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
         function goLogin(){
               window.location.href = "http://localhost:8080/WebClient/login.jsp";
         }
            
        </script>
    </head>
    <body>
        <%
        username.isUserusing = false;
        username.loginUsername = "";
        username.initUSername = "";
        %>
        <h1>Logout</h1>
        <button onclick="goLogin()">Go back to login</button>
    </body>
</html>
