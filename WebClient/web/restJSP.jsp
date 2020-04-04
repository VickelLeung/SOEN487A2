<%-- 
    Document   : restJSP
    Created on : 3-Apr-2020, 10:24:43 PM
    Author     : vickelleung
--%>

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
            
        </script>
    </head>
    <body style="text-align: center;">
         <h1>Welcome to librario!</h1>
         <h2>You can view all information of books in this application. It is essentially a virtual library.</h1>
         <div>
             <h3>Please select a functionality below</h3>
             <button onclick="getBookURL()">Get book</button>
             <button onclick="getListallURL()">List all</button>
             <button onclick="getAddbookByJSONURL()">Add a book by JSON</button>
             <button onclick="getAddbookByTextURL()">Add a book by text</button>
             <button onclick="getUpdatebookByJSONURL()">Update a book by JSON</button>
             <button onclick="getUpdatebookByTextURL()">Update a book by text</button>
             <button onclick="getDeletebookURL()">Delete book</button>
         </div>
    </body>
</html>
