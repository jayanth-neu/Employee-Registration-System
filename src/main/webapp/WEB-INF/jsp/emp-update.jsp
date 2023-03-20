<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
<body style="background-color:aquamarine;"> 
<form action="updatedata.htm" method="POST"> 

<table>
	<tr>
		<td>Existing EmailID:</td>
		<td><input type="text" name="emailid"/></td>
	</tr>
	
	<tr>
		<td>Update EmailID?</td> 
		<td><input type="radio" name="emailid_update" value="Yes">Yes <input type="radio" name="emailid_update" value="No" checked>No</td>
	</tr>

	<tr>
		<td>New EmailID:</td> 
		<td><input type="text" name="new_emailid"/></td>
	</tr>

	<tr>
		<td>Upgrade Admin Access?</td> 
		<td><input type="radio" name="isadmin_update" value="Yes">Yes <input type="radio" name="isadmin_update" value="No" checked>No</td>
	</tr>

	<tr>
		<td>New Employee Type:</td> 
		<td><input type="radio" name="new_isadmin" value="Admin">Admin <input type="radio" name="new_isadmin" value="Employee" checked>Employee</td>
	</tr>

	<tr>
		<td>Update First Name?</td> 
		<td><input type="radio" name="fname_update" value="Yes">Yes <input type="radio" name="fname_update" value="No" checked>No</td>
	</tr>

	<tr>
		<td>New First Name:</td> 
		<td><input type="text" name="new_fname"/></td>
	</tr>

	<tr>
		<td>Update Last Name?</td>  
		<td><input type="radio" name="lname_update" value="Yes">Yes <input type="radio" name="lname_update" value="No" checked>No</td> 
	</tr>

<tr>
	<td>New Last Name:</td>
	<td><input type="text" name="new_lname"/></td>
</tr>

<tr>
	<td>Update Password?</td> 
	<td><input type="radio" name="password_update" value="Yes">Yes <input type="radio" name="password_update" value="No" checked>No</td>
</tr>

<tr>
	<td>New Password:</td> 
	<td><input type="password" name="new_password"/></td>
</tr>

</table>
<input type="submit" value="Update Employee"/><br/>
<a href="welcome.htm">Go back to the welcome page</a>
</form>
</body> 
</html>