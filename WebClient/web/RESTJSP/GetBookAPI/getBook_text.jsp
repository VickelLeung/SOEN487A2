<%-- 
    Document   : getBook_text
    Created on : 1-Apr-2020, 9:38:14 PM
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
        <h1>Get book by Text</h1>
        <%
        java.lang.String id = request.getParameter("id");        
        get_bookAPI gb = new get_bookAPI();
        String text = gb.getBook_TEXT(id);
        out.print(text);
    %>
    </body>
</html>
