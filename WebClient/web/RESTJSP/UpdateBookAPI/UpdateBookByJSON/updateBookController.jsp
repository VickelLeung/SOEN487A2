<%-- 
    Document   : getbookController
    Created on : 1-Apr-2020, 9:39:34 PM
    Author     : fokpoonkai
--%>

<%@page import="login.username"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%if(username.loginUsername.equals(username.initUSername)&& username.isUserusing){%>
        <div style="text-align: center;">
            <h2>Update Book Text</h2>
        <form action="updateBookResults.jsp">       
            <div style="margin: 2% 10%; display:flex; flex-direction: column;">
                <span>ID: </span><input type="text" name="id" >
                <span>Title: </span><input type="text" name="title" >
                <span>Description: </span><input type="text" name="description">
                <span>Author: </span><input type="text" name="author">
                <span>Publisher: </span><input type="text" name="publisher">
            </div>
            <select name="type">
                <option value="json">JSON</option>
                <option value="xml">XML</option>
                <option value="text">TEXT</option>
                <option value="html">HTML</option>
            </select>
            <input type="submit">Submit</input> 
        </form> 
        </div>
         <%}else{%>
            <p>Fail to login</p>
        <%}%>
    </body>
</html>
