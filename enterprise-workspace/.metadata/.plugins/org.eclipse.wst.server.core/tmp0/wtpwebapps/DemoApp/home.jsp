<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/DemoApp/style.css" type="text/css">
<title>HomePage</title>
</head>
<body class ="user-body">
<h1>Hello user... <br> Welcome ${name} ! </h1>
<div>

<form action="Profile" method="post">
	<input type="submit" value="Edit Profile" class=btn2>
</form>
<button onclick='show();'  class="btn2">View My Profile</button>
</div>

<table class = "table" id="tableView" style="display: none;" >
	<tr> 
	<th>UserId</th>
	<th>UserName</th>
	<th>Password</th>
	<th>Email</th>
	</tr>
	
	<tr>
	<td>
	${listUser[0]}
	</td>
	<td>
	${listUser[1]}
	</td>
	<td>
	${listUser[2]}
	</td>
	<td>
	${listUser[3]}
	</td>
	</tr>
	   <!--  <c:out value="${user.user_id} ${user.username} "/><br /> -->
 	 <!-- ${user} -->
		  
	 </table>
<script>
function show() {

	  var x = document.getElementById("tableView");
	  if (x.style.display === "none") {
	    x.style.display = "inline-block";
	  } else {
	    x.style.display = "none";
	  }
	  
	}
</script>

</body>
</html>