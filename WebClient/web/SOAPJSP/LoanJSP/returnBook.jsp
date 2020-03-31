<%-- 
    Document   : returnBook
    Created on : Mar 29, 2020, 9:34:06 PM
    Author     : TOMMY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>returnBook</title>
    </head>
    <body>
        <h1>Return Book</h1>
        
        <form action = "returnBook.jsp" method = "GET">
            Book ID: <input type = "text" name = "book_id">
            <br />
            <input type = "submit" value = "Submit" />
        </form>
        
        
        <%-- start web service invocation --%><hr/>
        <%
            try {
                loanservice.LoanService_Service service = new loanservice.LoanService_Service();
                loanservice.LoanService port = service.getLoanServicePort();
                // TODO initialize WS operation arguments here
                String book_id = request.getParameter("book_id");
                int bookID = Integer.parseInt(book_id);
                // TODO process result here
                java.lang.String result = port.returnBook(bookID);
                out.println(result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
        %>
        <%-- end web service invocation --%><hr/>

    </body>
</html>
