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
         <script>
           function Resthome(){
            //alert(id)
            var url = "http://localhost:8080/WebClient/restJSP.jsp";
            window.location.href = url;
        }
           function displayErr(){
            var getTitle = document.getElementById("title").value;
            var getDescription = document.getElementById("description").value;
            var getAuthor = document.getElementById("author").value;
            var getIsbn = document.getElementById("isbn").value;
            var getpublisher = document.getElementById("publisher").value;
           
            if(getTitle.length === 0){
                alert("Error: title is empty");
                return false;
            }
            else if(getDescription.length === 0){
                 alert("Error: Description is empty");
                 return false;
            } 
            else if(getAuthor.length === 0){
                alert("Error: Author is empty");
                return false;
            }
            else if(getIsbn.length === 0){
                 alert("Error: ISBN is empty");
                 return false;
            }
            else if(getpublisher.length === 0){
                 alert("Error: Publisher is empty");
                return false;
            }
            
            return true;
        } 
       </script>
    </head>
    <body>
          <%if(username.loginUsername.equals(username.initUSername)&& username.isUserusing){%>
            <div style="text-align: center;">
                <h2>Add Book</h2>
          
            <form action="addBookResults.jsp" onsubmit="return displayErr()">       
                <div style="margin: 2% 10%; display:flex; flex-direction: column;">
                    <span>Title: </span><input type="text" id="title" name="title" >
                    <span>Description: </span><input id="description" type="text" name="description">
                    <span>Author: </span><input type="text" id="author" name="author">
                    <span>ISBN: </span><input type="text" id="isbn" name="isbn" >
                    <span>Publisher: </span><input type="text" id="publisher" name="publisher">
                </div>
                <select name="type">
                    <option value="json">JSON</option>
                    <option value="xml">XML</option>
                    <option value="text">TEXT</option>
                    <option value="html">HTML</option>
                </select>
                <br>
                <input type="submit" value="Addbook">
                                      &nbsp;
                <input type="button" value="home" onclick="Resthome()"></input> 
            </form> 
            </div>
         <%}else{%>

                        <p>Fail to login</p>
                <%}%>
    </body>
</html>
