<%-- 
    Document   : borrowBook
    Created on : Mar 29, 2020, 5:44:35 PM
    Author     : HUY
--%>

<%@page import="loanservice.MySOAPFault_Exception"%>
<%@page import="login.username"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>borrowBook</title>
    </head>
    
        <h1>Borrow Book</h1>
        <%if(username.loginUsername.equals(username.initUSername)&& username.isUserusing){%>
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
              
                
            } catch(MySOAPFault_Exception e){
                   out.print(e);  
                      
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
        }else{
                 out.println("Fail to login");
                }%>
        <%-- end web service invocation --%><hr/>

    
</html>
