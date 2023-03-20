<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-color:aquamarine;">
        <table border="1" >
            <tr>
            	<td><b>POST ID</b></td>
            	<td><b>SENDER</b></td>
                <td><b>SUBJECT</b></td>
                <td><b>CONTENT</b></td>
            </tr>
            <c:forEach var="p" items="${Posts}">
                <tr>
                	<td>${p.id}</td>
                	<td>${p.senderid.emailid}</td>
                    <td>${p.subject}</td>
                    <td>${p.content}</td>                                
                </tr>
            </c:forEach>
        </table><br>
        <a href="welcome.htm">Go back to the Welcome page</a>
    </body>
</html>