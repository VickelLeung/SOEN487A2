<%-- 
    Document   : deleteMember
    Created on : Mar 28, 2020, 4:43:59 PM
    Author     : TOMMY
--%>

<%@page import="login.username"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>deleteMember</title>
    </head>
    <body>
        <h1>Delete Member</h1>  
        <%if(username.loginUsername.equals(username.initUSername)&& username.isUserusing){%>
        <form action = "deleteMember.jsp" method = "GET">
            Member ID: <input type = "text" name = "member_id">
            <br />
            Member Name: <input type = "text" name = "member_name">
            <br />
            <input type = "submit" value = "Submit" />
        </form>
        
        
        <%-- start web service invocation --%><hr/>
        <%
            try {
                loanservice.LoanService_Service service = new loanservice.LoanService_Service();
                loanservice.LoanService port = service.getLoanServicePort();
                // TODO initialize WS operation arguments here
                String member_id = request.getParameter("member_id");
                String name = request.getParameter("member_name");
                int id = Integer.parseInt(member_id);
                // TODO process result here
                java.lang.String result="";
               
                if (port.getMemberIdByName(name) == id){
                    result = port.deleteMember(id);
                    %><font color="blue"><%out.print(result);%></font><%  
                } else {
                    %><font color="red"><%out.print("fail to delete member");%></font><%  
                }
                
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
        }else{ %>
        <p>Fail to login</p>
        <%}%>
        <%-- end web service invocation --%><hr/>

    </body>
</html>
