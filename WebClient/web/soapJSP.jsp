<%-- 
    Document   : soapJSP
    Created on : Mar 26, 2020, 11:30:49 PM
    Author     : HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>soapJSP</title>
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
            window.location.href = "http://localhost:8080/WebClient/SOAPJSP/MemberJSP/getListMember.jsp";
        }
        function getMember(id)
        {
            //alert(id);
            var x = window.confirm("Are u sure?");
            if (x)
            {
                var url = "http://localhost:8080/WebClient/SOAPJSP/MemberJSP/getMember.jsp" + id;
                window.location.href = url;
            } 
        }
        function addMember()
        {
            //alert(id);
            var x = window.confirm("Are u sure?");
            if (x)
            {
                var url = "http://localhost:8080/WebClient/SOAPJSP/MemberJSP/addMember.jsp";
                window.location.href = url;
            } 
        }
        function updateMember()
        {
            //alert(id);
            var x = window.confirm("Are u sure?");
            if (x)
            {
                var url = "http://localhost:8080/WebClient/SOAPJSP/MemberJSP/updateMember.jsp";
                window.location.href = url;
            } 
        }
        function getMemberIdByName(name)
        {
            //alert(name);
            var x = window.confirm("Are u sure?");
            if (x)
            {
                var url = "http://localhost:8080/WebClient/SOAPJSP/MemberJSP/getMemberIdByName.jsp" + name ;
                window.location.href = url;
            } 
        }
        function deleteMember()
        {
            //alert(id);
            var x = window.confirm("Are u sure?");
            if (x)
            {
                var url = "http://localhost:8080/WebClient/SOAPJSP/MemberJSP/deleteMember.jsp";
                window.location.href = url;
            } 
        }
        function getLoanListByBookName()
        {
            //alert(id);
            var x = window.confirm("Are u sure?");
            if (x)
            {
                var url = "http://localhost:8080/WebClient/SOAPJSP/LoanJSP/getLoanListByBookName.jsp";
                window.location.href = url;
            } 
        }
        function createLoanBook()
        {
            //alert(id);
            var x = window.confirm("Are u sure?");
            if (x)
            {
                var url = "http://localhost:8080/WebClient/SOAPJSP/LoanJSP/CreateLoanBook.jsp";
                window.location.href = url;
            } 
        }
        
        function borrowBook()
        {
            //alert(id);
            var x = window.confirm("Are u sure?");
            if (x)
            {
                var url = "http://localhost:8080/WebClient/SOAPJSP/LoanJSP/borrowBook.jsp";
                window.location.href = url;
            } 
        }
        
        function returnBook()
        {
            //alert(id);
            var x = window.confirm("Are u sure?");
            if (x)
            {
                var url = "http://localhost:8080/WebClient/SOAPJSP/LoanJSP/returnBook.jsp";
                window.location.href = url;
            } 
        }
        
        function updateLoan()
        {
            //alert(id);
            var x = window.confirm("Are u sure?");
            if (x)
            {
                var url = "http://localhost:8080/WebClient/SOAPJSP/LoanJSP/updateLoan.jsp";
                window.location.href = url;
            } 
        }
        
        function deleteLoanBook()
        {
            //alert(id);
            var x = window.confirm("Are u sure?");
            if (x)
            {
                var url = "http://localhost:8080/WebClient/SOAPJSP/LoanJSP/deleteLoanBook.jsp";
                window.location.href = url;
            } 
        }
        
        function getLoanListByMemberID(){
            //alert(id);
            var x = window.confirm("Are u sure?");
            if (x)
            {
                var url = "http://localhost:8080/WebClient/SOAPJSP/LoanJSP/getLoanListByMemberID.jsp";
                window.location.href = url;
            } 
        }
        
        function getLoanDetailByID(){
            //alert(id);
            var x = window.confirm("Are u sure?");
            if (x)
            {
                var url = "http://localhost:8080/WebClient/SOAPJSP/LoanJSP/getLoanDetailByID.jsp";
                window.location.href = url;
            } 
        }
        
        
    </script>


    <body>
        <h1>Hello, this is SOAP Loan Service!</h1>   
        <br />
            <button onclick="addMember()">Add Member</button>
            <br><br>
            <button onclick="deleteMember()">Delete Member</button>
            <br><br>
            <button onclick="getListMember()">Get List of Members</button> 
            <br><br>
            <button onclick="getMember(id)">Get Member by ID</button>
            <br><br>
            <button onclick="getMemberIdByName(name)">Get Member ID by Name</button>
            <br><br>
            <button onclick="updateMember()">Update Member</button>
            <br><br>
            
            <button onclick="createLoanBook()">Create Loan Book</button>
            <br><br>
            <button onclick="borrowBook()">Borrow Book</button>
            <br><br>
            <button onclick="deleteLoanBook()">Delete Loan Book</button>
            <br><br>
            <button onclick="getLoanDetailByID()">Get Loan Detail By ID</button>
            <br><br>
            <button onclick="getLoanListByBookName()">Get Loan List by Book Name</button>
            <br><br>
            <button onclick="getLoanListByMemberID()">Get Loan List By MemberID</button>
            <br><br>
            <button onclick="returnBook()">Return Book</button>
            <br><br>
            <button onclick="updateLoan()">Update Loan</button>   
    </body>
</html>
