<%-- 
    Document   : fun
    Created on : 8 Jun, 2021, 1:44:00 PM
    Author     : Rishabh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Fun Page</h1>
        <hr>
        <c:set var="name" value="Rishabh Nigam"></c:set>
        <h1>Name is :<c:out value="${name}"></c:out></h1>
        <hr>
        <h1>Length is :<c:out value="${fn:length(name)}"></c:out></h1>
        <hr>
        <h1>LowerCase is :<c:out value="${fn:toLowerCase(name)}"></c:out></h1>
        <hr>
        <h1>UpperCase is :<c:out value="${fn:toUpperCase(name)}"></c:out></h1>
        <hr>
        <h1>Contains Nigam :<c:out value="${fn:contains(name,'Nigam')}"></c:out></h1>
        <hr>
    </body>
</html>
