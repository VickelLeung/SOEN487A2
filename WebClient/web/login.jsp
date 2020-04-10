<%-- 
    Document   : login
    Created on : 3-Apr-2020, 8:42:03 AM
    Author     : fokpoonkai
--%>

<%@page import="login.username"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="display:flex; flex-direction: column; justify-content: center; align-items:center">
            <h1>Login</h1>
            <form style="display: flex; flex-direction: column;" action="verifyUser.jsp">
                <label>Username<input type="text" name="username"></label>
                <label>Password<input type="text" name="password"></label>
                <input type="submit" value="Submit">
            </form>
        </div>
    </body>  

</html>
