<%-- 
    Document   : error_page
    Created on : 7 Jun, 2021, 5:11:03 PM
    Author     : Rishabh
--%>
<%@page isErrorPage="true" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sorry !! Something went wrong..</title>
    </head>
    <body>
        <div style="padding: 20px;color: blue;background: #e2e2e2;">
            <h1>Sorry !! Something went wrong..</h1>
            <br>    
            
<!--            For print error name-->
            <p><%= exception %></p>
            
        </div>
    </body>
</html>
