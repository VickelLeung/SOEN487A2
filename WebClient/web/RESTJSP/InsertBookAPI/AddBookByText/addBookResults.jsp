<%-- 
    Document   : addBookResults
    Created on : 2-Apr-2020, 4:46:44 PM
    Author     : fokpoonkai
--%>

<%@page import="api.InsertBookAPI"%>
<%
    String type = request.getParameter("type");
  
    String title = request.getParameter("title"); 
    String description = request.getParameter("description"); 
    String author = request.getParameter("author");
    String isbn = request.getParameter("isbn"); 
    String publisher = request.getParameter("publisher");
    
    String query = "title="+title+"&description="+description+"&author="+author+"&isbn="+isbn+"&publisher="+publisher;
    

    String results ="";
    InsertBookAPI ib = new InsertBookAPI();
    if(type.equals("json")){
        response.setContentType("text/html");
        results = ib.addBook_TEXT_JSON(query);
    }
    else if(type.equals("xml")){
        response.setContentType("text/xml");
        results =  ib.addBook_TEXT_XML(query);
    }
    else if(type.equals("text")){
        response.setContentType("text/plain");
        results = ib.addBook_TEXT_TEXT(query);
    }
    else if(type.equals("html")){
        response.setContentType("text/html");
        results = ib.addBook_TEXT_HTML(query);
    }
    
    
    
     //InsertBookAPI() 


%>

<!DOCTYPE html>
<html>
    <head>
<!--        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
        <title>JSP Page</title>
    </head>
    <div style="display:flex; flex-direction: column; text-align: center">
            <h1>Here is the results for add book by <%=type %></h1>
            <%
                out.print(results);
            %>
        </div>
</html>
