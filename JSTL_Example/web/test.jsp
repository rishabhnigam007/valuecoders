<%-- 
    Document   : test
    Created on : 8 Jun, 2021, 12:57:37 PM
    Author     : Rishabh
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>This is test page</h1>
        <hr>
        <h1><c:out value="${i}">This is default value</c:out></h1>
        
    </body>
</html>

<%-- This is for testing varaible scope --%>