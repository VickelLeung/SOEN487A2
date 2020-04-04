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
    </head>
    <body>
        <%
        username.isUserusing = false;
        username.initUsername = "";
        %>
        <h1>Logout</h1>
    </body>
</html>
