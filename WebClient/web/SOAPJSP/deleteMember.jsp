<%-- 
    Document   : deleteMember
    Created on : Mar 28, 2020, 4:43:59 PM
    Author     : TOMMY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>deleteMember</title>
    </head>
    <body>
        <h1>Delete Member</h1>  
        
        <form action = "deleteMember.jsp" method = "GET">
            Member ID: <input type = "text" name = "member_id">
            <br />
            <input type = "submit" value = "Submit" />
        </form>
        
        
        <%-- start web service invocation --%><hr/>
        <%
            try {
                loanservice.LoanService_Service service = new loanservice.LoanService_Service();
                loanservice.LoanService port = service.getLoanServicePort();
                // TODO initialize WS operation arguments here
                String id = request.getParameter("member_id");;
                // TODO process result here
                
                java.lang.String result = port.deleteMember(Integer.parseInt(id));
                
               
                %><font color="red"><%out.print(result);%></font><%  
                
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
        %>
        <%-- end web service invocation --%><hr/>

    </body>
</html>
