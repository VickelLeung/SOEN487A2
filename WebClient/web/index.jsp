<%-- 
    Document   : index
    Created on : Mar 26, 2020, 11:30:49 PM
    Author     : TOMMY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                background-color: pink;
            }
            .button1
            {
                padding: 10px 20px;
                border-radius: 50%;
                background-color: white;
                opacity: 70%;
                color: black;                 
            }
            .mid
            {
                text-align: center;
                border: 2px solid #ffb6c1;
                margin: 2% 5%;
                padding-bottom: 2%;
            }
        </style>
    </head>
    <script>
        function getListMember()
        {
            window.location.href = "http://localhost:8080/WebClient/SOAPJSP/getListMember.jsp";
        }
        function getMember(id)
        {
            //alert(id);
            var x = window.confirm("Are u sure?");
            if (x)
            {
                var url = "http://localhost:8080/WebClient/SOAPJSP/getMember.jsp" + id;
                window.location.href = url;
            } 
        }
        function addMember()
        {
            //alert(id);
            var x = window.confirm("Are u sure?");
            if (x)
            {
                var url = "http://localhost:8080/WebClient/SOAPJSP/addMember.jsp";
                window.location.href = url;
            } 
        }
        function updateMember()
        {
            //alert(id);
            var x = window.confirm("Are u sure?");
            if (x)
            {
                var url = "http://localhost:8080/WebClient/SOAPJSP/updateMember.jsp";
                window.location.href = url;
            } 
        }
        function getMemberIdByName(name)
        {
            //alert(id);
            var x = window.confirm("Are u sure?");
            if (x)
            {
                var url = "http://localhost:8080/WebClient/SOAPJSP/getMemberIdByName.jsp" + name ;
                window.location.href = url;
            } 
        }
        function deleteMember()
        {
            //alert(id);
            var x = window.confirm("Are u sure?");
            if (x)
            {
                var url = "http://localhost:8080/WebClient/SOAPJSP/deleteMember.jsp";
                window.location.href = url;
            } 
        }
        function getLoanListByBookName()
        {
            //alert(id);
            var x = window.confirm("Are u sure?");
            if (x)
            {
                var url = "http://localhost:8080/WebClient/SOAPJSP/getLoanListByBookName.jsp";
                window.location.href = url;
            } 
        }
        function createLoanBook()
        {
            //alert(id);
            var x = window.confirm("Are u sure?");
            if (x)
            {
                var url = "http://localhost:8080/WebClient/SOAPJSP/CreateLoanBook.jsp";
                window.location.href = url;
            } 
        }
        
    </script>


    <body>
        <h1>Hello, this is SOAP Loan Service!</h1>   
        <br />
            <button onclick="getListMember()">Get List of Members</button> 
            <br><br>
            <button onclick="getMember(id)">Get Member by ID</button>
            <br><br>
            <button onclick="addMember()">Add Member</button>
            <br><br>
            <button onclick="updateMember()">Update Member</button>
            <br><br>
            <button onclick="getMemberIdByName(name)">Get Member ID by Name</button>
            <br><br>
            <button onclick="deleteMember()">Delete Member</button>
            <br><br>
            <button onclick="getLoanListByBookName()">Get Loan List by Book Name</button>
            <br><br>
            <button onclick="createLoanBook()">Create Loan Book</button>
            
            
    </body>
</html>
