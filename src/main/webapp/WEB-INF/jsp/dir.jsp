<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-color:aquamarine;">
        <table border="2">
            <tr>
                <td><b>EMAIL ID</b></td>
                <td><b>FIRST NAME</b></td>
                <td><b>LAST NAME</b></td>
                <td><b>ADMIN</b></td>
            </tr>
            <c:forEach var="emp" items="${EmpList}">
                <tr>
                	<td>${emp.emailid}</td>
                    <td>${emp.fname}</td>
                    <td>${emp.lname}</td>                
                    <td>${emp.isadmin}</td>                
                </tr>
            </c:forEach>
        </table><br>
        <a href="welcome.htm">Go back to the Welcome page</a>
    </body>
</html>