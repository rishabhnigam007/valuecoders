<%-- 
    Document   : index
    Created on : 8 Jun, 2021, 12:51:20 PM
    Author     : Rishabh
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Example</title>
    </head>
    <body>
        <h1>This is JSTL Example</h1>
        <!-- 1. out tag : This is used for print -->
        <!-- 2. set tag : This is used for set the value to variable -->
        <c:set var="i" value="-223" scope="application"></c:set>
        <h1><c:out value="${i}"></c:out></h1>

            <!-- 3. remove tag : for removing variable -->
        <%--
        <c:remove var="i"></c:remove> 
        <h1><c:out value="${i}">This is default value</c:out></h1>
        --%>

        <hr> <!-- this is used for horizontal line-->

        <!-- 4. if tag : for condition applying here variable is remove so no output comes-->
        <c:if test="${i>23}">
            <h1>Yes i is greater than 23.</h1>
        </c:if>

        <!-- 5. choose,when,otherwise: java switch  -->
        <c:choose >
            <c:when test="${i>0}">
                <h1>This is my case first</h1>
                <h2>Number is positive</h2>
            </c:when>

            <c:when test="${i<0}">
                <h1>This is my second case</h1>
                <h2>Number is negative number</h2>

            </c:when>

            <c:otherwise>
                <h1>Default case... otherwise</h1>
                <h1>The number is positive</h1>
            </c:otherwise>
        </c:choose>

        <!-- 6. For-Each tag : For repeating and traversing  -->
        <c:forEach var="j" begin="1" end="10">
            <h1>Value of j is : <c:out value="${j}"></c:out></h1>
        </c:forEach>


        <!-- 7. Re-direct tag : this is alternative of sendRedirect() method -->
        <!-- 8. Param tag : for using parameter and value -->
        <!-- this will redirect to google search -->
        
        <%--
        <c:url var="myurl" value="https://www.google.com/search">
            <c:param name="q" value="javatpoint"></c:param>
        </c:url>
        <h1><c:out value="${myurl}"></c:out></h1>
        <c:redirect url="${myurl}"></c:redirect>
        --%>
        
    </body>
</html>


<%-- link for study : https://www.youtube.com/watch?v=ZnPRkgi8wXE&list=PL0zysOflRCel5BSXoslpfDawe8FyyOSZb&index=43 --%>

<%-- web.xml file is used for clean url or our desire url --%>