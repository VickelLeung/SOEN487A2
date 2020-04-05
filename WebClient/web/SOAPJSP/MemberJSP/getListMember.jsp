<%-- 
    Document   : getListMember
    Created on : Mar 27, 2020, 5:20:11 PM
    Author     : HUY
--%>

<%@page import="loanservice.MySOAPFault_Exception"%>
<%@page import="login.username"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Members</title>
    </head>
    <body>
        <h1>Get List Of Members Info</h1>
        <%if(username.loginUsername.equals(username.initUSername)&& username.isUserusing){%>
        <table border="1" width="90%">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Contact</th>
            </tr>
            <%-- start web service invocation --%><hr/>
            <%
                try {
                    loanservice.LoanService_Service service = new loanservice.LoanService_Service();
                    loanservice.LoanService port = service.getLoanServicePort();
                    // TODO process result here
                    java.lang.String result = port.getListMember();
                    String[] part = result.split("\n");
                    for (int i = 0; i < part.length; i++) {
                        String[] partSplit = part[i].split("\\s++");
                        %><tr style="text-align:center"><%
                        for (int j = 1; j < partSplit.length; j++) {  
                        %>  
                            <td><%out.print(partSplit[j]);%></td>
                        <%
                        }%></tr><%
                    }

                } catch(MySOAPFault_Exception e){
                   out.print(e);  

                } catch (Exception ex) {
                        out.println("Exception: " + ex);
                }
                }else{%>
                        <p>Fail to login</p>
                <%}%>
                <%-- end web service invocation --%><hr/>
        </table>
    </body>
</html>
