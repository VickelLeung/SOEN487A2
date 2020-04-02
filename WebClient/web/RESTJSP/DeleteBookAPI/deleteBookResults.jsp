<%-- 
    Document   : updateBookResults
    Created on : 2-Apr-2020, 3:00:40 PM
    Author     : vickelleung
--%>
<%@page import="api.delete_bookAPI"%>
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<%   
    String type = request.getParameter("type");
  
    String id = request.getParameter("id"); 
    
    String results ="";
    delete_bookAPI db = new delete_bookAPI();
    
    if(type.equals("json")){
        response.setContentType("text/html");
        results =  db.delete_book_JSON(id);
    }
    else if(type.equals("xml")){
        response.setContentType("text/xml");
        results = db.delete_book_XML(id);
    }
    else if(type.equals("text")){
        response.setContentType("text/html");
        results = db.delete_book_TEXT(id);
    }
    else if(type.equals("html")){
        response.setContentType("text/html");
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
                out.print("<div>");
                out.print(results);
                out.print("</div>");
            
            %>
        </div>
    </body>
</html>
