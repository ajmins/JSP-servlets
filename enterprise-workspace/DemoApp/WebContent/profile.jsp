<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/DemoApp/style.css" type="text/css">
<title>Profile</title>
</head>
<body>

	<form action="Update" method="post">
	<h2>Edit Profile</h2>
	<table style="border: 1px solid black">
		<tr>
			<th>Username</th>
			<th>Email</th>
			<th>Password</th>
		</tr>
		<tr>
			<td><input type="text" name="username" value="${username}" readonly></td>
			<td><input type="email" name="email" value="${email}"></td>
			<td><input type="text" name="password" value="${password}"></td>
		</tr>
	</table><br>
		<input type="submit" value="Update" class="btn">
	</form>
<a href="home.jsp" target="_self" style="background-color: white; 
  	color: black; 
  	border: 1px solid #008CBA;
  	text-decoration: none;
  	display: inline-block;
  	margin-top:1%;
  	padding: 10px 16px;">Back</a>


</body>
</html>