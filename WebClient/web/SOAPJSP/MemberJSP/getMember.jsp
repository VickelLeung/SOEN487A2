<%-- 
    Document   : getMember
    Created on : Mar 27, 2020, 8:58:10 PM
    Author     : HUY
--%>

<%@page import="login.username"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>getMemberByID</title>
    </head>
    <body>
        <h1>Get Member Info</h1>
        <%if(username.loginUsername.equals(username.initUSername)&& username.isUserusing){%>
        <form action = "getMember.jsp" method = "GET">
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
                String id = request.getParameter("member_id");
                // TODO process result here
                java.lang.String result = port.getMember(Integer.parseInt(id));
                
                if ( result.equals("no member") ) {
                    out.print(result);
                } else {
                    String[] part = result.split("\\s+");
                %>  
                    <table border="1" width="90%">
                    <tr>
                        <th>Name</th>
                        <th>Contact</th>
                    </tr>
                    <tr style="text-align:center">
                        <td><%out.print(part[0]);%></td>
                        <td><%out.print(part[1]);%></td>
                    </tr>
                <%}%>
        <%
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
}else{%>
                          <p>Fail to login</p>
                <%}%>
    <%-- end web service invocation --%><hr/>
</table>
</body>
</html>
