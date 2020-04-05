<%-- 
    Document   : deleteLoanBook
    Created on : Mar 30, 2020, 12:44:54 AM
    Author     : TOMMY
--%>

<%@page import="loanservice.MySOAPFault_Exception"%>
<%@page import="login.username"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>deleteLoanBook</title>
    </head>
    <body>
        <h1>Delete Loan Book</h1>
        <%if(username.loginUsername.equals(username.initUSername)&& username.isUserusing){%>
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
