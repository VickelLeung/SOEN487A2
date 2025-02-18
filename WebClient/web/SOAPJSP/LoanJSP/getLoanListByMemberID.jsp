<%-- 
    Document   : getLoanListByMemberID
    Created on : Mar 30, 2020, 2:38:06 PM
    Author     : TOMMY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>getLoanListByMemberID</title>
    </head>
    <body>
        <h1>Get Loan List By Member ID</h1>

        <form action = "getLoanListByMemberID.jsp" method = "GET">
            Member ID: <input type = "text" name = "member_id">
            <br />
            <input type = "submit" value = "Submit" />
        </form>
        
        

        <table border="1" width="90%">
            <tr>
                <th>Book Name</th>
                <th>Person Borrow</th>
                <th>Borrow ID</th>
                <th>Date Of Borrowing</th>
                <th>Return Date</th>
                <th>Return Status</th>
            </tr>     
            
        <%-- start web service invocation --%><hr/>
        <%
            try {
                loanservice.LoanService_Service service = new loanservice.LoanService_Service();
                loanservice.LoanService port = service.getLoanServicePort();
                // TODO initialize WS operation arguments here
                String member_id = request.getParameter("member_id");
                int memberID = Integer.parseInt(member_id);
  
                // TODO process result here
                java.lang.String result = port.getLoanListByMemberID(memberID);
                
                if (memberID > 0){
                    
                    if (result.equals("No loanBook on the list")
                            || result.equals("fail to get loan list by MemberID")) {
                        %><font color="red"><%out.print(result);%></font><%
                            
                    } else {
                        String[] resultSplit = result.split("\n");
                        for (int i = 0; i < resultSplit.length; i++) {
                                String[] part = resultSplit[i].split(" ");
                                %> 
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
                                </tr><%
                        }
                    }

                } else {
                        result="";
                        out.print(result);
                }
   
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
        %>
        <%-- end web service invocation --%><hr/>
         
        </table>
    </body>
</html>
