<%-- 
    Document   : newjspCreateLoanBook
    Created on : Mar 28, 2020, 9:49:07 PM
    Author     : TOMMY
--%>

<%@page import="loanservice.MySOAPFault_Exception"%>
<%@page import="login.username"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CreateLoanBook</title>
       <script>
        function Soaphome(){
            //alert(id)
            var url = "http://localhost:8080/WebClient/soapJSP.jsp";
            window.location.href = url;
            }
        
        function displayErr(){
            var getId = document.getElementById("id").value;
            var getName = document.getElementById("name").value;
            var getPerson = document.getElementById("person").value;
            var getBorrowDate = document.getElementById("borrowDate").value;
            var getReturnDate = document.getElementById("returnDate").value;
            var getMemberDate = document.getElementById("memberDate").value;
            
            if(getId.length === 0){
                alert("ERROR: ID cannot be empty");
                return false;
            }
            else if(getName.length === 0){
                alert("ERROR: Name cannot be empty");
                return false;
            }
            else if(getPerson.length === 0){
                alert("ERROR: Person borrow cannot be empty");
                return false;
            }
            else if(getBorrowDate.length === 0){
                alert("ERROR: Borrow date cannot be empty");
                return false;
            }
            else if(getReturnDate.length === 0){
                alert("ERROR: Return date cannot be empty");
                return false;
            }
            else if(getMemberDate.length === 0){
                alert("ERROR: Member date cannot be empty");
                return false;
            }
            
            return true;
        }            
       </script>
    </head>
    <body>
        <h1>Create LoanBook</h1>
        <%if(username.loginUsername.equals(username.initUSername)&& username.isUserusing){%>
        <!--this method will ADD book into the loan database-->
        <form action = "CreateLoanBook.jsp" onsubmit="return displayErr()" method = "POST">
            <table>
                <tr><td>Borrow ID: </td>
                    <td> <input type = "text" id="id" name = "borrow_id"></td>
                <br/></tr>
                <tr><td>Book Name: </td>
                    <td><input type = "text" id="name" name = "book_name"></td>
                <br/></tr>
                <tr><td>Person Borrow [Member ID]: </td>
                    <td><input type = "text" id="person" name = "person_borrow"></td>
                <br/></tr>
                <tr><td>Borrow Date: </td>
                    <td><input type = "text" id="borrowDate" name = "borrow_date"></td>
                <br/></tr>
                <tr><td>Return Date: </td>
                    <td><input type = "text" id="returnDate" name = "return_date"></td>
                <br/></tr>
                <tr><td>Member Name: </td>
                    <td><input type = "text" id="memberDate" name = "member_name"></td>
                <br/></tr>
                <tr><td><input type = "submit" value = "Submit" /></td>
                <br/></tr>
            </table>
                                       &nbsp;
            <input type="button" value="home" onclick="Soaphome()"></input> 
        </form> 
        
        
        <%-- start web service invocation --%><hr/>
        <%
            try {
                loanservice.LoanService_Service service = new loanservice.LoanService_Service();
                loanservice.LoanService port = service.getLoanServicePort();
                // TODO initialize WS operation arguments here
                java.lang.String borrow_id = request.getParameter("borrow_id");
                java.lang.String bookName = request.getParameter("book_name");
                java.lang.String person_borrow = request.getParameter("person_borrow");
                java.lang.String borrowDate = request.getParameter("borrow_date");
                java.lang.String returnDate = request.getParameter("return_date");
                java.lang.String name = request.getParameter("member_name");
                int borrowID = Integer.parseInt(borrow_id);
                int personBorrow = Integer.parseInt(person_borrow);
                
                if (bookName != null || borrowID>0 || personBorrow>0){
                    //check if personBorrow exists in the Member database
                    if (personBorrow == port.getMemberIdByName(name)){
                        // TODO process result here
                        java.lang.String result = port.createLoanBook(borrowID, bookName, personBorrow, borrowDate, returnDate);
                        out.print("You entered borrowID: " + borrowID);
                        %></br><%
                        out.print("\nYou entered the Book Name: " + bookName);
                        %></br><%
                        out.print("\nYou entered the Person Borrow by ID: " + personBorrow);
                        %></br><%
                        out.print("\nYou entered the Borrow Date: " + borrowDate);
                        %></br><%
                        out.print("\nYou entered the Return Date: " + returnDate);
                        %></br><%
                        out.print("\nYou entered the Member Name: " + name);
                        %></br></br><%    

                        %><font color="red"><%out.print(result);%></font> <%
                    } else {
                        %><font color="red"><%out.print("The provided PersonBorrow is NOT a member in our Member database");%></font> <%
               
                    }
                } else {
                    out.print("Invalid input of BookName, BorrowID, PersonBorrow");
                } 

            
            } catch(MySOAPFault_Exception e){
                   out.print(e);  
                         
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
        }else{%>
                            <p>Fail to login</p>
                <%}%>
        <%-- end web service invocation --%><hr/>

    </body>
</html>
