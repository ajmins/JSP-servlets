<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style type="text/css">

.login-body{
	background-color: #E5FDFA ;
	color:#074778  ;
}

</style>
</head>
<body class = login-body>
	<form action="Login" method = get>
		<label>UserName: </label>
		<input type="text" value="" name="username" placeholder="Username" /> <br> <br>
		<label>Password: </label>
		<input type="password" value="" name="password" placeholder="Password" /> <br> <br>
		<input type="submit" value="Login" />
	</form>
</body>
</html>
