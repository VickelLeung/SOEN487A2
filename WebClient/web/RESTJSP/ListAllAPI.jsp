<%-- 
    Document   : ListAllAPI
    Created on : 31-Mar-2020, 10:32:57 PM
    Author     : fokpoonkai
--%>

<%@page import="api.ListAllAPI"%>
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
            
            ListAllAPI lt = new   ListAllAPI();
            String y = lt.getJson_JSON();
            String x = lt.getJson_TEXT();
            out.print(y);
            out.print(x);
        %>
    </body>
</html>
