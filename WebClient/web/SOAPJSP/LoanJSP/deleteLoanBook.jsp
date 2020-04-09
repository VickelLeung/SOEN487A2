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
                <script>
         //http://localhost:8080/WebClient/soapJSP.jsp
          function Soaphome(){
            //alert(id)
            var url = "http://localhost:8080/WebClient/soapJSP.jsp";
            window.location.href = url;
        }
        function displayErr(){
            var getId = document.getElementById("id").value;
            
            if(getId.length === 0){
                alert("ERROR: ID cannot be empty");
                return false;
            }
            
            return true;
        }
        
        </script>
    </head>
    <body>
        <h1>Delete Loan Book</h1>
        <%if(username.loginUsername.equals(username.initUSername)&& username.isUserusing){%>
        <form action = "deleteLoanBook.jsp" onsubmit="return displayErr()" method = "GET">
            Member ID: <input type = "text" id="id" name = "borrow_BookId">
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
