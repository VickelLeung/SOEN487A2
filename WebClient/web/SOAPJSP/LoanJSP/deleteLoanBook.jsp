<%-- 
    Document   : deleteLoanBook
    Created on : Mar 30, 2020, 12:44:54 AM
    Author     : TOMMY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>deleteLoanBook</title>
    </head>
    <body>
        <h1>Delete Loan Book</h1>
        
        <form action = "deleteLoanBook.jsp" method = "GET">
            Member ID: <input type = "text" name = "borrow_BookId">
            <br />
            <input type = "submit" value = "Submit" />
        </form>

        <%-- start web service invocation --%><hr/>
        <%
            try {
                loanservice.LoanService_Service service = new loanservice.LoanService_Service();
                loanservice.LoanService port = service.getLoanServicePort();
                // TODO initialize WS operation arguments here
                String borrow_BookId = request.getParameter("borrow_BookId");
                int borrowBookId = Integer.parseInt(borrow_BookId);
                // TODO process result here
                java.lang.String result = port.deleteLoanBook(borrowBookId);
                out.println(result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
        %>
        <%-- end web service invocation --%><hr/>

    </body>
</html>
