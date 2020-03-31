<%-- 
    Document   : borrowBook
    Created on : Mar 29, 2020, 5:44:35 PM
    Author     : HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>borrowBook</title>
    </head>
    <body>
        <h1>Borrow Book</h1>
        
        <form action = "borrowBook.jsp" method = "GET">
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
                int bookid = Integer.parseInt(book_id);
                if (bookid > 0){
                      // TODO process result here
                    java.lang.String result = port.borrowBook(bookid);
                    out.println(result);
                } else {
                    out.println("Invalid input of BookID");
                }
              
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
        %>
        <%-- end web service invocation --%><hr/>

    </body>
</html>
