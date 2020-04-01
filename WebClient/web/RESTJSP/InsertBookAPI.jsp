<%-- 
    Document   : InsertBookAPI
    Created on : 31-Mar-2020, 10:47:13 PM
    Author     : fokpoonkai
--%>

<%@page import="api.InsertBookAPI"%>
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
            InsertBookAPI ib = new InsertBookAPI ();
            String x = ib.addBook_TEXT_JSON("title=aaaadddbb&description=aaaabbbb&isbn=aaafdfdfdsab&author=fdfddfdsafdsa&publisher=fdfdfd");
            out.print(x);
        %>
    </body>
</html>
