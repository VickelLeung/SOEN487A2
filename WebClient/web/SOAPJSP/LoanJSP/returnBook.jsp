<%-- 
    Document   : returnBook
    Created on : Mar 29, 2020, 9:34:06 PM
    Author     : TOMMY
--%>

<%@page import="loanservice.MySOAPFault_Exception"%>
<%@page import="login.username"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>returnBook</title>
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
        <h1>Return Book</h1>
        <%if(username.loginUsername.equals(username.initUSername)&& username.isUserusing){%>
        <form action = "returnBook.jsp" method = "GET">
            Book ID: <input type = "text" name = "book_id">
            <br />
            <input type = "submit" value = "Submit" />
             &nbsp;
            <input type="button" value="home" onclick="Soaphome()"></input> 
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
