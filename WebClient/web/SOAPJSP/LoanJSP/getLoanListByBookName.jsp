<%-- 
    Document   : getLoanListByBookName
    Created on : Mar 28, 2020, 5:39:41 PM
    Author     : HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>getLoanListByBookName</title>
    </head>
    <body>
        <h1>Get Loan List by Book Name</h1>
        
        <form action = "getLoanListByBookName.jsp" method = "GET">
            Book Name: <input type = "text" name = "book_name">
            <br />
            <input type = "submit" value = "Submit" />
        </form>
        
        
        <%-- start web service invocation --%><hr/>
        <%
            try {
                loanservice.LoanService_Service service = new loanservice.LoanService_Service();
                loanservice.LoanService port = service.getLoanServicePort();
                // TODO initialize WS operation arguments here
                java.lang.String bookName = request.getParameter("book_name");;
                // TODO process result here
                java.lang.String result = port.getLoanListByBookName(bookName);
                
                if (bookName != null){
                    if (result.equals("No loanBook on the list")
                            || result.equals("fail to get loan list by book name")) {
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

            }catch (Exception ex) {
                out.print("Exception: " + ex);
            }
        %>
        <%-- end web service invocation --%><hr/>

    </body>
</html>
