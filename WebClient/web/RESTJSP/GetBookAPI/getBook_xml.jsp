<%-- 
    Document   : getBook_xml
    Created on : 1-Apr-2020, 9:37:58 PM
    Author     : fokpoonkai
--%>

<%@page import="api.get_bookAPI"%>
<%@page contentType="text/xml" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<!--        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Get Book by XML</h1>
       <%
        java.lang.String id = request.getParameter("id");
        
        get_bookAPI gb = new get_bookAPI();
        String xml = gb.getBook_XML(id);
        out.print(xml);
    %>
    </body>
</html>
