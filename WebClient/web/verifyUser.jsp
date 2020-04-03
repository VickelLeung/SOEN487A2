<%-- 
    Document   : verifyUser
    Created on : 3-Apr-2020, 4:19:11 PM
    Author     : fokpoonkai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String t_username = request.getParameter("username");
    String t_password = request.getParameter("password"); 
    if(t_username != null && t_password != null){
            try {
	loanservice.LoanService_Service service = new loanservice.LoanService_Service();
	loanservice.LoanService port = service.getLoanServicePort();
	 // TODO initialize WS operation arguments here
	java.lang.String name = t_username;
	java.lang.String password = t_password;
	// TODO process result here
	java.lang.String result = port.login(name, password);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    
    }

    %>
    <%-- end web service invocation --%><hr/>
        

            
            
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
