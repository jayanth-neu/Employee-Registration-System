<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Add Employee Form</title>
</head>
<body style="background-color:aquamarine;">

<h2>Register a New Employee</h2>

<form:form modelAttribute="user" method="post">

<table>
<tr>
    <td>Employee Category:</td>
    <td><form:radiobutton path="isadmin" value="true"/>Admin Employee <form:radiobutton path="isadmin" value="false"/>Regular Employee</td>
</tr>

<tr>
    <td>Employee First Name:</td>
    <td><form:input path="fname" size="40" /></td>
</tr>

<tr>
    <td>Employee Last Name:</td>
    <td><form:input path="lname" size="40" /></td>
</tr>

<tr>
    <td>Employee EmailID:</td>
    <td><form:input path="emailid" size="40" /></td>
</tr>

<tr>
    <td>Password:</td>
    <td><form:password path="pwd" size="40" /></td>
</tr>

<tr>
    <td colspan="2"><input type="submit" value="Add Employee" /></td>
</tr>
</table>

</form:form><br>

<a href="welcome.htm">Go back to the Welcome page</a>

</body>
</html>