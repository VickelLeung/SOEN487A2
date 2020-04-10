<%-- 
    Document   : updateLoan
    Created on : Mar 29, 2020, 10:10:45 PM
    Author     : TOMMY
--%>

<%@page import="loanservice.MySOAPFault_Exception"%>
<%@page import="login.username"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>updateLoan</title>
                <script>
         //http://localhost:8080/WebClient/soapJSP.jsp
          function Soaphome(){
            //alert(id)
            var url = "http://localhost:8080/WebClient/soapJSP.jsp";
            window.location.href = url;
        }

        function displayErr(){
            var getId = document.getElementById("id").value;
            var getName = document.getElementById("name").value;
           
            var getMemberName = document.getElementById("memberName").value;
            
            console.log(document.getElementById("test"));
            
            if(getId.length === 0){
                alert("ERROR: ID cannot be empty");
                return false;
            }
            else if(getName.length === 0){
                alert("ERROR: Name cannot be empty");
                return false;
            }
            else if(getMemberName.length === 0){
                alert("ERROR: Member name cannot be empty");
                return false;
            }
            
            return true;
        }         
        
        </script>
    </head>
    <body>
        <h1>Update Loan</h1>
        <%if(username.loginUsername.equals(username.initUSername)&& username.isUserusing){%>
        <form action = "updateLoan.jsp" onsubmit="return displayErr()" method = "POST">
            <div style="display:flex; flex-direction: column;">
                <span>Borrow ID*: <input type = "text" id="id" name = "book_id"></span>
                <span>Book Name*: <input type = "text" id="name" name = "book_name"></span>
                <span>Person Borrow ID*: <input type = "text" id="person" name = "person_borrow"></span>
                <span>Date Of Borrowing: <input type = "text" id="borrowDate" name = "date_of_borrowing"></span>
                <span>Return Date: 
                    <input type = "text" name = "return_date">
                </span>
                <span>Return Status*:
                    <select name = "is_return">
                        <option value="1" >yes</option>
                        <option value="0" >no</option>
                    </select>
                </span>
                   
                <span> Member Name*: 
                    <input type = "text" id="memberName" name = "member_name">
                </span>
            </div>
                <input type = "submit" value = "Submit" />
            <input type="button" value="home" onclick="Soaphome()"></input> 
        </form> 
        
        
        <%-- start web service invocation --%><hr/>
        <%
            try {
                loanservice.LoanService_Service service = new loanservice.LoanService_Service();
                loanservice.LoanService port = service.getLoanServicePort();
                // TODO initialize WS operation arguments here
                java.lang.String book_id = request.getParameter("book_id");     //???borrowID
                java.lang.String bookName = request.getParameter("book_name");
                java.lang.String person_borrow = request.getParameter("person_borrow");
                java.lang.String dateOfBorrowing = request.getParameter("date_of_borrowing");
                java.lang.String returnDate = request.getParameter("return_date");
                java.lang.String is_return = request.getParameter("is_return");
                java.lang.String name = request.getParameter("member_name");
                java.lang.String result="";

                int bookId = Integer.parseInt(book_id);
                int personBorrow = Integer.parseInt(person_borrow);
                int isReturn = Integer.parseInt(is_return);
               
                if( (bookName != null) ){
                    if (personBorrow == port.getMemberIdByName(name)){
                        result = port.updateLoan(bookId, bookName, personBorrow, dateOfBorrowing, returnDate, isReturn);
                        out.print("You entered book id: " + bookId);
                        %></br><%
                        out.print("You entered book name: " + bookName);
                        %></br><%
                        out.print("\nYou entered person borrow: " + personBorrow);
                        %></br><%
                        out.print("You entered Date Of Borrowing: " + dateOfBorrowing);
                        %></br><%
                        out.print("You entered Return Date: " + returnDate);
                        %></br><%
                        out.print("You entered Return Status: " + isReturn);
                        %></br><%
                        out.print("\nYou entered the Member Name: " + name);
                        %></br></br><%
                        out.println(result);
                    }
                     
                } else {
                    %><font color="red"><%out.print("Invalid input of BookName, BorrowID, PersonBorrow");%></font> <%
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
