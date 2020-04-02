<%-- 
    Document   : listall_xml
    Created on : 1-Apr-2020, 10:47:48 PM
    Author     : fokpoonkai
--%>

<%@page import="api.ListAllAPI"%>
<%@page contentType="text/xml" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<!--        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List All by XML</h1>
        <%
            ListAllAPI lt = new ListAllAPI();
            String xml = lt.getJson_XML();
            out.print(xml);
        %>
    </body>
</html>
