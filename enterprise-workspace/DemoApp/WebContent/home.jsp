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
<table class = "table" id="tableView" style="display: inline-block;" >
	<tr> 
	<th>UserId</th>
	<th>UserName</th>
	<th>Password</th>
	<th>Email</th>
	
	
	<c:forEach items="${listUsers}" var="user" varStatus="loop">
	   <!--  <c:out value="${user.user_id} ${user.username} "/><br /> -->
 	 ${user}
		  
	 </c:forEach>
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