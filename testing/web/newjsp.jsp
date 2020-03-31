<%-- 
    Document   : newjsp
    Created on : Mar 31, 2020, 11:46:53 AM
    Author     : TOMMY
--%>

<%@page import="api.NewJerseyClient"%>
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
            NewJerseyClient nc = new NewJerseyClient();
            String x = nc.getJson_TEXT();
            out.print(x);
        %>
    </body>
</html>
