<%-- 
    Document   : show_users
    Created on : 8 Jun, 2021, 2:00:48 PM
    Author     : Rishabh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- This is for sql database -->
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    </head>
    <body>
        <h1 class="text-center"><----- All Users Details -----></h1>
        <hr>

        <sql:setDataSource driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/test" user="root" password="1234" var="ds"></sql:setDataSource>

        <sql:query dataSource="${ds}" var="rs">select * from emp;</sql:query>

            <div class="container">
                <table class="table">
                    <tr>
                        <td>User ID</td>
                        <td>Name</td>
                        <td>Age</td>
                    </tr>
                <c:forEach items="${rs.rows}" var="row">
                    <tr>
                        <td><c:out value="${row.id}"></c:out></td>
                        <td><c:out value="${row.name}"></c:out></td>
                        <td><c:out value="${row.age}"></c:out></td>
                        </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
