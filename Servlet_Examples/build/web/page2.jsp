<%-- 
    Document   : page2
    Created on : 7 Jun, 2021, 6:39:50 PM
    Author     : Rishabh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background: red;">
        <h1>This is page two</h1>
        
        <%
            //redirection
//            response.sendRedirect("page3.jsp");
            
            // redirect any location
            response.sendRedirect("https://www.google.co.in");
        %>
       
    </body>
</html>
