<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/DemoApp/style.css" type="text/css">
<title>Registration</title>

</head>
<body>

<form action="Register" method="post" class = register-body>
	<h2>Registration</h2>
		<label>UserName: </label> &nbsp
		<input type="text" name="username" placeholder="Username"><br> <br> 
		
		<label>Password: </label> &nbsp &nbsp
		<input type="password" name="password" placeholder="Password"><br> <br> 
		
		<label>Email: </label> &nbsp &nbsp &nbsp &nbsp &nbsp
		<input type="text" name="email" placeholder="E-mail"><br><br> 
		
		<label>Role: </label>
		
		<input type="radio" name="role" value=1> 
		<label for=1>Admin</label> 
		<input type="radio" name="role" value=2> 
		<label for=2>User</label>
		<br><br> 
		<br> 	
		<input type="submit" value="Register" class = "btn">  &nbsp &nbsp
		<input type="reset" value="Reset" class = "btn">
		<a href="index.jsp" class="btn">Back</a>
	</form>
</body>
</html>