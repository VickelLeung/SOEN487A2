<%-- 
    Document   : results
    Created on : 1-Apr-2020, 10:48:51 PM
    Author     : vickelleung
--%>

<%@page import="api.ListAllAPI"%>
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<!DOCTYPE html>
<%   
    String type = request.getParameter("type");
  
    String id = request.getParameter("id"); 
    
    String results ="";
    ListAllAPI la = new ListAllAPI();
    
    if(type.equals("json")){
        response.setContentType("text/html");
        results = la.getJson_JSON();
    }
    else if(type.equals("xml")){
        response.setContentType("text/xml");
        results = la.getJson_XML();
    }
    else if(type.equals("text")){
        response.setContentType("text/html");
        results = la.getJson_TEXT();
    }
    else if(type.equals("html")){
        response.setContentType("text/html");
    }
%>
<html>
    <head>
        
        <title>JSP Page</title>
    </head>
    <body>
        <div style="text-align: center">
        <h1>List all books by <%= type %></h1>
        <%=results%>
        </div>
    </body>
</html>
