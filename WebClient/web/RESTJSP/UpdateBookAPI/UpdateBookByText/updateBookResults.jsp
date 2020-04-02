<%-- 
    Document   : updateBookResults
    Created on : 2-Apr-2020, 3:00:40 PM
    Author     : vickelleung
--%>
<%@page import="api.update_bookAPI"%>
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<% 
    String type = request.getParameter("type");
  
    String id = request.getParameter("id"); 
    String title = request.getParameter("title"); 
    String description = request.getParameter("description"); 
    String author = request.getParameter("author");
    String isbn = request.getParameter("isbn"); 
    String publisher = request.getParameter("publisher");
    
    String results ="";
    update_bookAPI ub = new update_bookAPI();
    
    if(type.equals("json")){
        response.setContentType("text/html");
        results =  ub.getXml_JSON(id+title+description+author+isbn+publisher);

    }
    else if(type.equals("xml")){
        response.setContentType("text/xml");
        results =  ub.getXml_XML(id+title+description+author+isbn+publisher);
    }
    else if(type.equals("text")){
        response.setContentType("text/plain");
        results =  ub.getXml_TEXT(id+title+description+author+isbn+publisher);
    }
    else if(type.equals("html")){
        response.setContentType("text/html");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%= request.getParameter("id") %>
        <%= request.getParameter("title") %>
        <%= request.getParameter("description") %>
        <%= request.getParameter("author") %>
        <%= request.getParameter("isbn") %>
        <%= request.getParameter("publisher") %>
        
        <%=results%>
    </body>
</html>
