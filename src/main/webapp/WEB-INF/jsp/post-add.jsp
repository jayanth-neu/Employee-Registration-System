<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Add Post Form</title>
</head>
<body style="background-color:aquamarine;">

<h2>Post Company Updates</h2>

<form:form modelAttribute="post" method="post">

<table>

<tr>
    <td>Subject:</td>
    <td><form:input path="subject" size="30" /></td>
</tr>

<tr>
    <td>Content:</td>
    <td><form:textarea path = "content" rows = "10" cols = "30" /></td>
</tr>


<tr>
    <td colspan="2"><input type="submit" value="Add Post" /></td>
</tr>
</table>

</form:form>
<br>
<a href="welcome.htm">Go back to the Welcome page</a>

</body>
</html>