<%-- 
    Document   : updateMember
    Created on : Mar 28, 2020, 12:25:08 AM
    Author     : TOMMY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Member</title>
    </head>
    <body>
        <h1>Update Member</h1>

        <form action = "updateMember.jsp" method = "POST">
            <table>
                <tr><td>ID: </td>
                    <td><input type = "text" name = "member_id"></td>
                <br/></tr>
                <tr><td>Name: </td>
                    <td> <input type = "text" name = "member_name"></td>
                <br/></tr>
                <tr><td>Contact: </td>
                    <td><input type = "text" name = "member_contact"></td>
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
                java.lang.String member_id = request.getParameter("member_id");
                java.lang.String name = request.getParameter("member_name");
                java.lang.String contact = request.getParameter("member_contact");
                int id = Integer.parseInt(member_id);
                java.lang.String result="";
                
//              if ((name != null) && (port.getMemberIdByName(name) == id) ) {
                if ((name != null) && (id > 0)) {
                        if (port.getMemberIdByName(name) == id) {
                            result = port.updateMember(id, name, contact);
                            out.print("You entered member id: " + id);
                            %></br><%
                            out.print("You entered member name: " + name);
                            %></br><% 
                            out.print("\nYou entered the contact: " + contact);
                            %></br></br><%
                            %><font color="blue"><%out.print(result);%></font><%
                        } else {
                            %><font color="red"><%out.print("Either Name or ID is incorrect");%></font><% 
                        }  
                }else{
                    %><font color="red"><%out.print("Invalid Name or ID");%></font><% 
                }   

            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        %>
        <%-- end web service invocation --%><hr/>
    
    </body>
</html>
