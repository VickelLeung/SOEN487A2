<%-- 
    Document   : soapJSP
    Created on : Mar 26, 2020, 11:30:49 PM
    Author     : HUY
--%>

<%@page import="login.username"%>
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

                var url = "http://localhost:8080/WebClient/SOAPJSP/MemberJSP/getMember.jsp" + id;
                window.location.href = url;

        }
        function addMember()
        {

                var url = "http://localhost:8080/WebClient/SOAPJSP/MemberJSP/addMember.jsp";
                window.location.href = url;

        }
        function updateMember()
        {

                var url = "http://localhost:8080/WebClient/SOAPJSP/MemberJSP/updateMember.jsp";
                window.location.href = url;

        }
        function getMemberIdByName(name)
        {
                var url = "http://localhost:8080/WebClient/SOAPJSP/MemberJSP/getMemberIdByName.jsp" + name ;
                window.location.href = url;

        }
        function deleteMember()
        {
                var url = "http://localhost:8080/WebClient/SOAPJSP/MemberJSP/deleteMember.jsp";
                window.location.href = url;
        }
        
        function getLoanListByBookName()
        {

                var url = "http://localhost:8080/WebClient/SOAPJSP/LoanJSP/getLoanListByBookName.jsp";
                window.location.href = url;
        }
        function createLoanBook()
        {

                var url = "http://localhost:8080/WebClient/SOAPJSP/LoanJSP/CreateLoanBook.jsp";
                window.location.href = url;
        }
        
        function borrowBook()
        {
                var url = "http://localhost:8080/WebClient/SOAPJSP/LoanJSP/borrowBook.jsp";
                window.location.href = url;

        }
        
        function returnBook()
        {
            //alert(id);
                var url = "http://localhost:8080/WebClient/SOAPJSP/LoanJSP/returnBook.jsp";
                window.location.href = url;
        }
        
        function updateLoan()
        {
                var url = "http://localhost:8080/WebClient/SOAPJSP/LoanJSP/updateLoan.jsp";
                window.location.href = url;

        }
        
        function deleteLoanBook()
        {

                var url = "http://localhost:8080/WebClient/SOAPJSP/LoanJSP/deleteLoanBook.jsp";
                window.location.href = url;
        }
        
        function getLoanListByMemberID(){
 
                var url = "http://localhost:8080/WebClient/SOAPJSP/LoanJSP/getLoanListByMemberID.jsp";
                window.location.href = url;

        }
        
        function getLoanDetailByID(){
            //alert(id);

            var url = "http://localhost:8080/WebClient/SOAPJSP/LoanJSP/getLoanDetailByID.jsp";
            window.location.href = url;
        }
        
        function GoHome(arg){
           var parma =  arg.split('&');
           var username = parma[0];
           var password = parma[1];
            var url = "http://localhost:8080/WebClient/verifyUser.jsp?username="+username+"&password="+password;
            window.location.href = url;
        }
    </script>

    <body>
        <%if(username.loginUsername.equals(username.initUSername)&& username.isUserusing){%>
        <h1>Hello, this is SOAP Loan Service!</h1> 
        
        <div style="text-align: center;">
            <button style="height:4em; width: 10em;" onclick="GoHome('<%=username.loginUsername%>&<%=username.password%>')">Go to Homepage</button>
        </div>
        <div style="margin: 2% 6%; padding: 1.5%; background:rgba(0,0,0,0.5); border:1px solid black; display: flex; flex-direction: row">
            <button style=" margin:0 0.5%;" onclick="addMember()">Add Member</button>
           
            <button style=" margin:0 0.5%;" onclick="deleteMember()">Delete Member</button>
            <button style=" margin:0 0.5%;" onclick="getListMember()">Get List of Members</button> 
            <button style=" margin:0 0.5%;" onclick="getMember(id)">Get Member by ID</button>
            <button style=" margin:0 0.5%;" onclick="getMemberIdByName(name)">Get Member ID by Name</button>
            <button style=" margin:0 0.5%;" onclick="updateMember()">Update Member</button>
            
            <button style=" margin:0 0.5%;" onclick="createLoanBook()">Create Loan Book</button>
            <button style=" margin:0 0.5%;" onclick="borrowBook()">Borrow Book</button>
            <button style=" margin:0 0.5%;" onclick="deleteLoanBook()">Delete Loan Book</button>
            <button style=" margin:0 0.5%;" onclick="getLoanDetailByID()">Get Loan Detail By ID</button>
            <button style=" margin:0 0.5%;" onclick="getLoanListByBookName()">Get Loan List by Book Name</button>
            <button style=" margin:0 0.5%;" onclick="getLoanListByMemberID()">Get Loan List By MemberID</button>
            <button style=" margin:0 0.5%;" onclick="returnBook()">Return Book</button>
            <button style=" margin:0 0.5%;" onclick="updateLoan()">Update Loan</button> 
        </div>
             <%}else{%>

        <p>Fail to login</p>
<%}%>
    </body>
</html>
