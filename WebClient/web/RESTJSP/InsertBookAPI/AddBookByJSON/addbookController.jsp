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
            <h2>ADD Book JSON</h2>      
        <form action="addBookResults.jsp">       
            <div style="display:flex; justify-content: center; align-items: center;">
                <div style="margin: 2% 20%; display:flex; flex-direction: column; text-align: left;">
                    <span>Title: <input type="text" name="title" ></span>
                    <span>Description: <input type="text" name="description"></span>
                    <span>Author: <input type="text" name="author"></span>
                    <span>ISBN:<input type="text" name="isbn" > </span>
                    <span>Publisher:<input type="text" name="publisher"></span>
                </div>
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
         <%}else{%>
           <p>Fail to login</p>
        <%}%>
    </body>
</html>
