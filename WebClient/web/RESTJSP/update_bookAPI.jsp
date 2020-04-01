<%-- 
    Document   : update_bookAPI
    Created on : 1-Apr-2020, 1:13:53 AM
    Author     : vickelleung
--%>

<%@page import="api.update_bookAPI"%>
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
            update_bookAPI ub = new update_bookAPI();
            String x = ub.getXml_HTML("title=aaaadddbb&description=aaaabbbb&isbn=aaafdfdfdsab&author=fdfddfdsafdsa&publisher=fdfdfd");
            %>
    </body>
</html>
