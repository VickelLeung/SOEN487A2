<%-- 
    Document   : getbookController
    Created on : 1-Apr-2020, 9:39:34 PM
    Author     : fokpoonkai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="text-align: center;">
            <h2>Add Book</h2>
        <form action="addBookResults.jsp">       
            <div style="margin: 2% 10%; display:flex; flex-direction: column;">
                <span>Title: </span><input type="text" name="title" >
                <span>Description: </span><input type="text" name="description">
                <span>Author: </span><input type="text" name="author">
                <span>ISBN: </span><input type="text" name="isbn" >
                <span>Publisher: </span><input type="text" name="publisher">
            </div>
            <select name="type">
                <option value="json">JSON</option>
                <option value="xml">XML</option>
                <option value="text">TEXT</option>
                <option value="html">HTML</option>
            </select>
            <br>
            <input type="submit" value="Addbook">
        </form> 
        </div>
    </body>
</html>
