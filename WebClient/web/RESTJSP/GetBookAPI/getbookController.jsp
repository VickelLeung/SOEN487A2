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
            </script>
    </head>
    <body>
         <%if(username.loginUsername.equals(username.initUSername)&& username.isUserusing){%> 
        <div style="text-align: center;">
            <h2>Get Book</h2> 
          
            <div style="margin: 2% 10%; display:flex; flex-direction: rows; justify-content: center; align-items: center;">
                <form action="getBookResults.jsp">       

                        <span>Please enter an ID to get a book: <input type="text" name="id" ></span>

                    <select name="type">
                        <option value="json">JSON</option>
                        <option value="xml">XML</option>
                        <option value="text">TEXT</option>
                        <option value="html">HTML</option>
                    </select>
                    <input type="submit"/> 
                     &nbsp;
                    <input type="button" value="home" onclick="Resthome()"></input> 
                </form> 
            </div>
        </div>
        <%}else{%>

                   <p>Fail to login</p>
           <%}%>
    </body>
</html>
