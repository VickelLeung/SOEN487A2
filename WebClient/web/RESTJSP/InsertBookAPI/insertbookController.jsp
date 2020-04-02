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
    <script type="text/javascript">
        function toAddBook(){
            console.log("test");
            var type = document.getElementById("type").value;
            var title = document.getElementById("title").value;
             window.location.href = "http://localhost:8080/WebClient/insertbookAPI/UpdateBookByJSON/updatebook_"+type+".jsp;
    }
    </script>
    <body>
        <div style="text-align: center;">
            <h2>Update Book</h2>
        <div style="margin: 2% 10%; display:flex; flex-direction: column;">
            <span>Title: </span><input type="text" id="a_title" >
            <span>Description: </span><input type="text" id="a_description">
            <span>Author: </span><input type="text" id="a_author" >
            <span>ISBN: </span><input type="text" id="a_isbn" >
            <span>Publisher: </span><input type="text" id="a_publisher" >
        </div>
        <select id="type">
            <option value="json">JSON</option>
            <option value="xml">XML</option>
            <option value="text">TEXT</option>
            <option value="html">HTML</option>
        </select>
        <button onclick="toAddBook()">Add</button>
        </div>
    </body>
</html>
