<%-- 
    Document   : getBook_json
    Created on : 1-Apr-2020, 9:37:41 PM
    Author     : fokpoonkai
--%>

<%@page import="api.get_bookAPI"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Get Book by Json</h1>
    </body>
    <%
        java.lang.String id = request.getParameter("id");
        
        get_bookAPI gb = new get_bookAPI();
        String json = gb.getBook_JSON(id);
        out.print(json);
    %>
</html>
