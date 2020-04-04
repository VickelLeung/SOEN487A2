<%-- 
    Document   : verifyUser
    Created on : 3-Apr-2020, 4:19:11 PM
    Author     : fokpoonkai
--%>

<%@page import="login.username"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String t_username = request.getParameter("username");
    String t_password = request.getParameter("password"); 
    username.loginUsername = t_username;   
    if(username.isUserusing){
        out.print("someone is using");
    } else {
                if(t_username != null && t_password != null){
                try {

                    loanservice.LoanService_Service service = new loanservice.LoanService_Service();
                    loanservice.LoanService port = service.getLoanServicePort();
                     // TODO initialize WS operation arguments here
                    java.lang.String name = t_username;
                    java.lang.String password = t_password;
                    // TODO process result here
                    java.lang.String result = port.login(name, password);
                    if(result.equals("success_to_login")){
                            out.println("Result = "+result);    
                        if( username.initUSername.equals("")||username.initUSername.equals(username.loginUsername)){
                            username.initUSername  = username.loginUsername;
                            username.isUserusing = true;
                        }else{
                            out.print("the username and password can't be empty");
                        }
                    }else{
                         out.println("Result = "+result);      
                    }
                 

                        } catch (Exception ex) {
                            // TODO handle custom exceptions here
                        }
                }else{
                    out.print("the username and password can't be empty");
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
     <script>
        function goSoap()
        {
            window.location.href = "http://localhost:8080/WebClient/soapJSP.jsp";
        }
         
        function goRest()
        {
            window.location.href = "http://localhost:8080/WebClient/restJSP.jsp";
        } 
        function goLogOut()
        {
            window.location.href = "http://localhost:8080/WebClient/logout.jsp";
        } 
        </script>
    <body>
        <h1>Hello World!</h1>
        <%=username.loginUsername%>
        <%=username.initUSername%>
        <%
            if(username.loginUsername.equals(username.initUSername)&& username.isUserusing){%>
                 <button onclick="goSoap()">Soap</button>
                <button onclick="goRest()">REST</button>
                <button onclick="goLogOut()">Logout</button>
             <%}else{%>
            <p>login false</p>
        <%}%>
    </body>
</html>
