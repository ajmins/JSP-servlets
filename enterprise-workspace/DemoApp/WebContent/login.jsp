<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/DemoApp/style.css" type="text/css">
<title>Login</title>
<style type="text/css">



</style>
</head>
<body class = login-body>
	<h2>Login</h2>
	<form action="Login" method = get>
		<label>UserName: </label>
		<input type="text" value="" name="username" placeholder="Username" /> <br> <br>
		<label>Password: </label>
		<input type="password" value="" name="password" placeholder="Password" /> <br> <br>
		<input type="submit" value="Login" />
	</form>
</body>
</html>
