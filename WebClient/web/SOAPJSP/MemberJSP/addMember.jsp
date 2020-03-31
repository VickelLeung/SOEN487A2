<%-- 
    Document   : addMember
    Created on : Mar 27, 2020, 10:18:34 PM
    Author     : TOMMY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Member</title>
    </head>
    <body>
        <h1>Add Member</h1>   
        
        <form action = "addMember.jsp" method = "POST">
            <table>
                <tr><td>Name: </td>
                    <td> <input type = "text" name = "member_name"></td>
                <br/></tr>
                <tr><td>Contact: </td>
                    <td><input type = "text" name = "member_contact"></td>
                <br/></tr>
                <tr><td>Password: </td>
                    <td><input type = "password" name = "member_password"></td>
                <br/></tr>
                <tr><td><input type = "submit" value = "Submit" /></td>
                <br/></tr>
            </table>
        </form> 
       
     
        
        <%-- start web service invocation --%><hr/>
        <%
            try {
                loanservice.LoanService_Service service = new loanservice.LoanService_Service();
                loanservice.LoanService port = service.getLoanServicePort();
                // TODO initialize WS operation arguments here
                java.lang.String name = request.getParameter("member_name");
                java.lang.String contact = request.getParameter("member_contact");
                java.lang.String password = request.getParameter("member_password");
                java.lang.String result="";
                
                if (name!=null && password!=null){
                    result = port.addMember(name, contact, password);
                    out.print("You entered member name: " + name);
                    %></br><%
                    out.print("\nYou entered the contact: " + contact);
                    %></br></br><%
                    %><font color="red"><%out.print(result);%></font><%
                }  
                
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
        %>
        <%-- end web service invocation --%><hr/>
    
    </body>
</html>
