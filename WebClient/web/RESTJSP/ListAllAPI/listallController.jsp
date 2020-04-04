<%-- 
    Document   : listallController
    Created on : 1-Apr-2020, 10:48:29 PM
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
      <div style="text-align: center;">
            <h2>List All Books</h2>
        <form action="listAllResults.jsp">       
            <h3>Select an option to display all the list of books</h3>
            <select name="type">
                <option value="json">JSON</option>
                <option value="xml">XML</option>
                <option value="text">TEXT</option>
                <option value="html">HTML</option>
            </select>
            <input type="submit">Submit</input> 
        </form> 
        </div>
    </body>
</html>
