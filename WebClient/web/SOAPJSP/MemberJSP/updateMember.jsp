<%-- 
    Document   : updateMember
    Created on : Mar 28, 2020, 12:25:08 AM
    Author     : TOMMY
--%>

<%@page import="loanservice.MySOAPFault_Exception"%>
<%@page import="login.username"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Member</title>
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
            
            if(getId.length === 0){
                alert("ERROR: ID cannot be empty");
                return false;
            }
            else if(getName === 0){
                alert("ERROR: Name cannot be empty");
                return false;
            }
            
            return true;
        }
        </script>
    </head>
    <body>
        <h1>Update Member</h1>
        <%if(username.loginUsername.equals(username.initUSername)&& username.isUserusing){%>

            <form action = "updateMember.jsp" onsubmit="return displayErr()" method = "POST">
                <div style="display:flex; flex-direction: column">
                    <h3>In order to change your contact information.<br />You will need to provide your ID and name to change due to security reason<h3>
                    <span>ID:
                        <input type = "text" id="id" name = "member_id">
                    </span>
                    <span>Name:
                        <input type = "text" id="name" name="name" name = "member_name">
                    </span>
                    <span>Contact:
                        <input type = "text" name = "member_contact">
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


                } catch(MySOAPFault_Exception e){
                   out.print(e);      

                } catch (Exception e) {
                    System.out.println("Exception: " + e);
                }
        }else{%>
             <p>Fail to login</p>
                <%}%>
        <%-- end web service invocation --%><hr/>
    
    </body>
</html>
