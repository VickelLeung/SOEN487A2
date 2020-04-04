<%-- 
    Document   : addBookResults
    Created on : 2-Apr-2020, 4:46:44 PM
    Author     : fokpoonkai
--%>

<%@page import="org.json.simple.JSONObject"%>
<%@page import="api.InsertBookAPI"%>
<%
    String type = request.getParameter("type");
  
    String title = request.getParameter("title"); 
    String description = request.getParameter("description"); 
    String author = request.getParameter("author");
    String isbn = request.getParameter("isbn"); 
    String publisher = request.getParameter("publisher");
    JSONObject obj = new JSONObject();  
    obj.put("title", title);
    obj.put("description", description);
    obj.put("author", author);
    obj.put("isbn", isbn);
    obj.put("publisher", publisher);
    
    
    String results ="";
    InsertBookAPI ib = new InsertBookAPI();
    if(type.equals("json")){
        response.setContentType("text/html");
        results = ib.addBook_JSON_JSON(obj.toJSONString());
    }
    else if(type.equals("xml")){
        response.setContentType("text/xml");
        results =  ib.addBook_JSON_XML(obj.toJSONString());
    }
    else if(type.equals("text")){
        response.setContentType("text/plain");
        results = ib.addBook_JSON_TEXT(obj.toJSONString());
    }
    else if(type.equals("html")){
        response.setContentType(obj.toString());
        results = ib.addBook_JSON_HTML(obj.toString());
    }
    
    
    
     //InsertBookAPI() 


%>

<!DOCTYPE html>
<html>
    <head>
<!--        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>   
        <%=results%>
    </body>
</html>
