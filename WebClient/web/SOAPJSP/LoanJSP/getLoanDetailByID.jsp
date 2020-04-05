<%-- 
    Document   : getLoanDetailByID
    Created on : Mar 30, 2020, 2:38:35 PM
    Author     : TOMMY
--%>

<%@page import="loanservice.MySOAPFault_Exception"%>
<%@page import="login.username"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>getLoanDetailByID</title>
    </head>
    <body>
        <h1>Get Loan Detail By ID</h1>    
        <%if(username.loginUsername.equals(username.initUSername)&& username.isUserusing){%>
        <form action = "getLoanDetailByID.jsp" method = "GET">
            Borrow ID: <input type = "text" name = "borrow_id">
            <br />
            <input type = "submit" value = "Submit" />
        </form>
        
        
        <%-- start web service invocation --%><hr/>
        <%
            try {
                loanservice.LoanService_Service service = new loanservice.LoanService_Service();
                loanservice.LoanService port = service.getLoanServicePort();
                // TODO initialize WS operation arguments here
                java.lang.String borrow_id = request.getParameter("borrow_id");
                int borrowBookId = Integer.parseInt(borrow_id);
                
                // TODO process result here
                java.lang.String result = port.getLoanDetailByID(borrowBookId);
                
                if (borrowBookId > 0){
                    if (result.equals("no book loan")
                            || result.equals("fail to get loan list by ID")) {
                        %><font color="red"><%out.print(result);%></font><%
                    } else {
                        String[] part = result.split(" ");
                        %> <table border="1" width="90%">
                        <tr>
                            <th>Book Name</th>
                            <th>Person Borrow</th>
                            <th>Borrow ID</th>
                            <th>Date Of Borrowing</th>
                            <th>Return Date</th>
                            <th>Return Status</th>
                        </tr>
                        <tr style="text-align:center">
                            <td><%out.print(part[0]);%></td>
                            <td><%out.print(part[1]);%></td>
                            <td><%out.print(part[2]);%></td>
                            <td><%out.print(part[3]);%></td>
                            <td><%out.print(part[4]);%></td>
                            <td>
                                <% if (Integer.parseInt(part[5]) == 0) {
                                        out.print("No");
                                    } else {
                                        out.print("Yes");
                                    }
                                %>
                            </td>
                        </tr> </table><%
                    } 
                }else {
                    result="";
                    out.print(result);
                }
                
                
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
