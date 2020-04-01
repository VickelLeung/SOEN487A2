<%-- 
    Document   : deleteBookAPI
    Created on : 1-Apr-2020, 1:12:33 AM
    Author     : vickelleung
--%>

<%@page import="api.delete_bookAPI"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <%
            delete_bookAPI db = new delete_bookAPI();
            String x = db.delete_book("14");
        %>
    </body>
</html>
