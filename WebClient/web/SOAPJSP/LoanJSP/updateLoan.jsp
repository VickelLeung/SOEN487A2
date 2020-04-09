<%-- 
    Document   : updateLoan
    Created on : Mar 29, 2020, 10:10:45 PM
    Author     : TOMMY
--%>

<%@page import="loanservice.MySOAPFault_Exception"%>
<%@page import="login.username"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>updateLoan</title>
                <script>
         //http://localhost:8080/WebClient/soapJSP.jsp
          function Soaphome(){
            //alert(id)
            var url = "http://localhost:8080/WebClient/soapJSP.jsp";
            window.location.href = url;
        }
        </script>
    </head>
    <body>
        <h1>Update Loan</h1>
        <%if(username.loginUsername.equals(username.initUSername)&& username.isUserusing){%>
        <form action = "updateLoan.jsp" method = "POST">
            <table>
                <tr><td>Borrow ID: </td>
                    <td><input type = "text" name = "book_id"></td>
                <br/></tr>
                <tr><td>Book Name: </td>
                    <td> <input type = "text" name = "book_name"></td>
                <br/></tr>
                <tr><td>Person Borrow: </td>
                    <td><input type = "text" name = "person_borrow"></td>
                <br/></tr>
                <tr><td>Date Of Borrowing: </td>
                    <td><input type = "text" name = "date_of_borrowing"></td>
                <br/></tr>
                <tr><td>Return Date: </td>
                    <td><input type = "text" name = "return_date"></td>
                <br/></tr>
                <tr><td>Return Status (enter 0 or 1): </td>
                    <td><input type = "text" name = "is_return"></td>
                <br/></tr>
                <tr><td>Member Name: </td>
                    <td><input type = "text" name = "member_name"></td>
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
                java.lang.String book_id = request.getParameter("book_id");     //???borrowID
                java.lang.String bookName = request.getParameter("book_name");
                java.lang.String person_borrow = request.getParameter("person_borrow");
                java.lang.String dateOfBorrowing = request.getParameter("date_of_borrowing");
                java.lang.String returnDate = request.getParameter("return_date");
                java.lang.String is_return = request.getParameter("is_return");
                java.lang.String name = request.getParameter("member_name");
                java.lang.String result="";
                
                int bookId = Integer.parseInt(book_id);
                int personBorrow = Integer.parseInt(person_borrow);
                int isReturn = Integer.parseInt(is_return);
               
                if( (bookName != null) ){
                    if (personBorrow == port.getMemberIdByName(name)){
                        result = port.updateLoan(bookId, bookName, personBorrow, dateOfBorrowing, returnDate, isReturn);
                        out.print("You entered book id: " + bookId);
                        %></br><%
                        out.print("You entered book name: " + bookName);
                        %></br><%
                        out.print("\nYou entered person borrow: " + personBorrow);
                        %></br><%
                        out.print("You entered Date Of Borrowing: " + dateOfBorrowing);
                        %></br><%
                        out.print("You entered Return Date: " + returnDate);
                        %></br><%
                        out.print("You entered Return Status: " + isReturn);
                        %></br><%
                        out.print("\nYou entered the Member Name: " + name);
                        %></br></br><%
                        out.println(result);
                    }
                     
                } else {
                    %><font color="red"><%out.print("Invalid input of BookName, BorrowID, PersonBorrow");%></font> <%
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
