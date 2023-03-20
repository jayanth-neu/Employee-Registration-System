<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Remove Employee Form</title>
</head>
<body style="background-color:aquamarine;">

<h2>Remove an Existing Employee</h2>

<form:form modelAttribute="user" method="post">

<table>

<tr>
    <td>Employee EmailID:</td>
    <td><form:input path="emailid" size="30" /></td>
</tr>

<tr>
    <td colspan="2"><input type="submit" value="Remove Employee" /></td>
</tr>
</table>

</form:form><br>

<a href="welcome.htm">Go back to the Welcome page</a>

</body>
</html>