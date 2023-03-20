<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
        <style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover {
  background-color: #111;
}
</style>
    </head>
    <body style="background-color:aquamarine;">
        	<ul>
        	<li>
            <a href="dir.htm">Employee Directory</a>
            </li>
            <li>
            <a href="adddata.htm">Add Employee</a>
            </li>
            <li>
            <a href="updatedata.htm">Update Employee Data</a>
            </li>
            <li>
            <a href="deletedata.htm">Delete Employee Data</a>
            </li>
            <li>
            <a href="addpost.htm">Add Post</a>
            </li>
            <li>
            <a href="viewpost.htm">View Post</a>
            </li>
            <li>
            <a href="deletepost.htm">Delete Post</a>
            </li>
            <li>
            <a href="emplgout.htm">Logout</a>
            </li>
            </ul>
            <br>           
			<b>Welcome ${sessionScope.emplogin.fname}, ${sessionScope.emplogin.lname}</b>
    </body>
</html>
