<%-- 
    Document   : login
    Created on : 3-Apr-2020, 8:42:03 AM
    Author     : fokpoonkai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="verifyUser.jsp">
            <label>Username</label><input type="text" name="username"><br>
            <label>Password</label><input type="text" name="password">
            <input type="submit" value="Submit">
        </form>

    </body>  

</html>
