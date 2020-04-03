<%-- 
    Document   : updateBookResults
    Created on : 2-Apr-2020, 3:00:40 PM
    Author     : vickelleung
--%>
<%@page import="api.get_bookAPI"%>
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<%   
    String type = "";
    String results ="wrong operation";
    try{
        type = request.getParameter("type");
        String id = request.getParameter("id"); 
     
        get_bookAPI gb = new get_bookAPI();

        if(type.equals("json")){
            response.setContentType("text/html");
            results =  gb.getBook_JSON(id);
        }
        else if(type.equals("xml")){
            response.setContentType("text/xml");
            results = gb.getBook_XML(id);
        }
        else if(type.equals("text")){
            response.setContentType("text/html");
            results = gb.getBook_TEXT(id);
        }
        else if(type.equals("html")){
            response.setContentType("text/html");
            results = gb.getBook_HTML(id);
        }
    }catch(Exception e){
        results = e.getMessage();
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
