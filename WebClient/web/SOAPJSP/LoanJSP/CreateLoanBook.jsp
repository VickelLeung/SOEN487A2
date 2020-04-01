<%-- 
    Document   : newjspCreateLoanBook
    Created on : Mar 28, 2020, 9:49:07 PM
    Author     : TOMMY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CreateLoanBook</title>
    </head>
    <body>
        <h1>Create LoanBook</h1>
        
        <!--this method will ADD book into the loan database-->
        <form action = "CreateLoanBook.jsp" method = "POST">
            <table>
                <tr><td>Borrow ID: </td>
                    <td> <input type = "text" name = "borrow_id"></td>
                <br/></tr>
                <tr><td>Book Name: </td>
                    <td><input type = "text" name = "book_name"></td>
                <br/></tr>
                <tr><td>Person Borrow: </td>
                    <td><input type = "text" name = "person_borrow"></td>
                <br/></tr>
                <tr><td>Borrow Date: </td>
                    <td><input type = "text" name = "borrow_date"></td>
                <br/></tr>
                <tr><td>Return Date: </td>
                    <td><input type = "text" name = "return_date"></td>
                <br/></tr>
                <tr><td>Member Name: </td>
                    <td><input type = "text" name = "member_name"></td>
                <br/></tr>
                <tr><td><input type = "submit" value = "Submit" /></td>
                <br/></tr>
            </table>
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
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
        %>
        <%-- end web service invocation --%><hr/>

    </body>
</html>
