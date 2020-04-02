<%-- 
    Document   : getBookAPI
    Created on : 1-Apr-2020, 1:08:54 AM
    Author     : vickelleung
--%>
<%@page import="api.get_bookAPI"%>
<%@page contentType="text/xml" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            get_bookAPI gb = new get_bookAPI();
            String json = gb.getBook_JSON("2");
            String xml = gb.getBook_XML("2");
            String plain = gb.getBook_TEXT("2");
            
            out.print("<pre>"+xml+"</pre>");
            %>
    </body>
</html>
