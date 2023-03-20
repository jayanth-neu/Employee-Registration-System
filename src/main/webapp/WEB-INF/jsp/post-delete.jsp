<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Remove Post Form</title>
</head>
<body style="background-color:aquamarine;">

<h2>Remove an Existing Post</h2>

<form:form modelAttribute="post" method="post">

<table>

<tr>
    <td>PostID:</td>
    <td><form:input path="id" size="30" /></td>
</tr>

<tr>
    <td colspan="2"><input type="submit" value="Remove Post" /></td>
</tr>
</table>

</form:form>
<br>
<a href="welcome.htm">Go back to the Welcome page</a>

</body>
</html>