<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
<link rel="stylesheet" href="/DemoApp/style.css" type="text/css">
<title>AdminHomePage</title>
</head>
<body class ="user-body">
<h1>Hello adminUser... <br> Welcome ${name} ! </h1>

<a href="register.jsp" target="_self" class="a-link" >Register New !</a>
<button onclick='show();'  class="btn2">View Users</button>
<a href="login.jsp" class="btn2">Back</a>
<table class = "table" id="tableView" style="display: none;" >
	<tr> 
		<th>UserId</th>
		<th>UserName</th>
		<th>Email</th>
		<th>Password</th>
		<th>Action</th>
	</tr>
	<c:forEach items="${userData}" var="user">		 
			<tr>
			    <td>${user.user_id}</td>
			    <td>${user.username}</td>
			    <td>${user.getEmail()}</td><!-- we can use getters also -->
			    <td>${user.password}</td>
			    <td>
			    	<a class="btn" href="Edit?userId=${user.user_id}" target="_self" id="userId">Edit</a>
			    	<a class="btn" href="Delete?userId=${user.user_id}" target="_self" id="userId">Delete</a>
			    </td>
		  </tr>
	 </c:forEach>
</table>
	 
<script>
/*
 * Script for displaying table from a button click
 */
function show() {
	 //var object = "${userData}";
	 //console.log(object)
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