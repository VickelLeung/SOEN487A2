<%-- 
    Document   : updateBookResults
    Created on : 2-Apr-2020, 3:00:40 PM
    Author     : vickelleung
--%>

<%@page import="org.json.simple.JSONObject"%>
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
    
    JSONObject obj = new JSONObject();
    obj.put("id",id);
    obj.put("title",title);
    obj.put("description",description);
    obj.put("author",author);
    obj.put("isbn",isbn);
    obj.put("publisher",publisher);
    
    String results ="";
    update_bookAPI ub = new update_bookAPI();
    
    if(type.equals("json")){
        response.setContentType("text/html");
        results = ub.getXml_JSON_JSON(obj.toJSONString());
    }
    else if(type.equals("xml")){
        response.setContentType("text/xml");
        results = ub.getXml_JSON_XML(obj.toJSONString());
    }
    else if(type.equals("text")){
        response.setContentType("text/html");
        results = ub.getXml_JSON_TEXT(obj.toJSONString());
    }
    else if(type.equals("html")){
        response.setContentType("text/html");
        results = ub.getXml_JSON_HTML(obj.toJSONString());
    }
    %>
    
<!DOCTYPE html>
<html>
    <head>
        
        <title>JSP Page</title>
    </head>
    <body>
        <div style="display:flex; flex-direction: column; text-align: center">
          <h1>Here is the results for get book by <%=type %></h1>
          <%
              out.print(results);
          %>
        </div>

    </body>
</html>
