<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/DemoApp/style.css" type="text/css">
<title>Login</title>

</head>

<body class = login-body>
	<h2>Login</h2>
	<form action="Login" method = post>
		<label>UserName: </label> &nbsp 
		<input type="text" value="" name="username" placeholder="Username" /> <br> <br>
		<label>Password: </label> &nbsp &nbsp
		<input type="password" value="" name="password" placeholder="Password" /> <br> <br>
		<input type="submit" value="Login" class="btn" />
		<a href="index.jsp" class="btn">Back</a>
	</form>
</body>
</html>
