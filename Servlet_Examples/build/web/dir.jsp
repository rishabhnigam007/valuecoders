<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--<%@page isErrorPage="true"%>--%>
<%@page errorPage="error_page.jsp" %>


<%@ taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            Random Number : 
            <%
                Random r = new Random();
                int n = r.nextInt(10);

            %>
            <%= n%>

        </h1>
        <hr>
        <c:set var="name" value="rishabh nigam"></c:set>
        <c:out value="${name}"></c:out>
        <c:if test="${3<2}">
            <h2>This is true block 3 > 2</h2>
        </c:if>

        <p:out value="${34+56}"></p:out>
        
        <%!
            int n1=24;
            int n2=0;                
        %>
        <%
         int division=n1/n2;
        %>
        <h1>Division = <%= division %> </h1>
    </body>
</html>


<!-- whenever use @taglib attribute must add JSTL library first in library folder -->