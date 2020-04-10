<%-- 
    Document   : restJSP
    Created on : 3-Apr-2020, 10:24:43 PM
    Author     : vickelleung
--%>

<%@page import="login.username"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
        
        function getBookURL()
        {
                var url = "http://localhost:8080/WebClient/RESTJSP/GetBookAPI/getbookController.jsp";
                window.location.href = url;
        }
        
        function getAddbookByJSONURL()
        {
                var url = "http://localhost:8080/WebClient/RESTJSP/InsertBookAPI/AddBookByJSON/addbookController.jsp";
                window.location.href = url;
        }
        
        function getAddbookByTextURL()
        {
            var url = "http://localhost:8080/WebClient/RESTJSP/InsertBookAPI/AddBookByText/addbookController.jsp";
            window.location.href = url;
        }
        
        function getDeletebookURL()
        {
                var url = "http://localhost:8080/WebClient/RESTJSP/DeleteBookAPI/deletebookController.jsp";
                window.location.href = url;
        }
        
        function getListallURL(){
                var url = "http://localhost:8080/WebClient/RESTJSP/ListAllAPI/listallController.jsp";
                window.location.href = url;
        }
        
        function getUpdatebookByJSONURL(){
                var url = "http://localhost:8080/WebClient/RESTJSP/UpdateBookAPI/UpdateBookByJSON/updateBookController.jsp";
                window.location.href = url;
        }
        
        function getUpdatebookByTextURL(){
                var url = "http://localhost:8080/WebClient/RESTJSP/UpdateBookAPI/UpdateBookByText/updatebookController.jsp";
                window.location.href = url;
        }
        
        function goHomepage(arg){
            window.alert(arg);
           var parma =  arg.split('&');
           var username = parma[0];
           var password = parma[1];
            var url = "http://localhost:8080/WebClient/verifyUser.jsp?username="+username+"&password="+password;
            window.location.href = url;
        }
            
        </script>
    </head>
    <body style="text-align: center;"> 
 
    <%if(username.loginUsername.equals(username.initUSername)&& username.isUserusing){%>

          <img style="height: 40vh; width:100vw; object-fit: scale-down;"src="images/backgroundImg.jpg" alt="banner"/>
     
        
         <h1>Welcome to Book of pandemic-Corona-20!</h1>
         <h2>You can view all information of books in this application. It is essentially a virtual library.</h1>
         <button style="height: 6em; width: 8em; margin: 0 0.5%;" onclick="goHomepage(''<%=username.loginUsername%>&<%=username.password%>'')">Go to homepage</button>
         
         
         <div style="border:1px solid gray; margin: 0 10%; padding: 1%;">
             <h3>Please select a functionality below</h3>
             <div style="display:flex; flex-direction: row; justify-content: center; align-items:center;">
             <button style="height: 6em; width: 8em; margin: 0 0.5%;" onclick="getBookURL()">Get book</button>
             <button style="height: 6em; width: 8em; margin: 0 0.5%;" onclick="getListallURL()">List all</button>
             <button style="height: 6em; width: 8em; margin: 0 0.5%;" onclick="getAddbookByJSONURL()">Add a book by JSON</button>
             <button style="height: 6em; width: 8em; margin: 0 0.5%;" onclick="getAddbookByTextURL()">Add a book by text</button>
             <button style="height: 6em; width: 8em; margin: 0 0.5%;" onclick="getUpdatebookByJSONURL()">Update a book by JSON</button>
             <button style="height: 6em; width: 8em; margin: 0 0.5%;" onclick="getUpdatebookByTextURL()">Update a book by text</button>
             <button style="height: 6em; width: 8em; margin: 0 0.5%;" onclick="getDeletebookURL()">Delete book</button>
             </div>
         </div>
          <%}else{%>

        <p>Fail to login</p>
<%}%>
    </body>
</html>
