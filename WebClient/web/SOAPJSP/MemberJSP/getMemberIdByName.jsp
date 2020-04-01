<%-- 
    Document   : getMemberIdByName
    Created on : Mar 28, 2020, 3:06:35 PM
    Author     : TOMMY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>getMemberIdByName</title>
    </head>
    <body>
        <h1>Get Member ID by Name</h1>    
        
        <form action = "getMemberIdByName.jsp" method = "GET">
            Name: <input type = "text" name = "member_name">
            <br />
            <input type = "submit" value = "Submit" />
        </form>
        
        
        <%-- start web service invocation --%><hr/>
        <%
            try {
                loanservice.LoanService_Service service = new loanservice.LoanService_Service();
                loanservice.LoanService port = service.getLoanServicePort();
                // TODO initialize WS operation arguments here
                java.lang.String name = request.getParameter("member_name");
                // TODO process result here
                if (name != null) {
                    int result = port.getMemberIdByName(name);
                    if (result == -1) {
                        %><font color="red"><%out.print("there is no ID exist in our database from your provided name");%></font><%    
                    }
                    else {
                        %><font color="red"><%out.print(result);%></font><%    
                    }
                }
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
        %>
        <%-- end web service invocation --%><hr/>

    </body>
</html>
