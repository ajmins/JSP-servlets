<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <!-- to use out tag -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL Demo</title>
</head>
<body>
	
		<!-- Hello World!  -->
		<!-- to print name from the DemoJSTL file we hv two techniques, one is using scriptletsand next is using JSTL tags  -->
		<!-- Using scriptlets -->
		<%-- 
		<%
			String names = request.getAttribute("label").toString();
			//System.out.println(name);
			out.println(names);
		%>
		--%>
		
		<%-- 
		<!-- instead of this we can use JSTL tags -->
		${label} <br>
		<c:out value = "hello ${label}"/>
		<!-- for url import use -->
		<c:import url="https://projects.eclipse.org/projects/ee4j.jstl"></c:import>
		--%>
		<%-- 
		<!-- displaying studnet object -->
		${s} <br> <!-- this will print the hashcode -->
		${s.name} <!-- this will thorw error becz name is not accessed -->
		<!-- we can access member variales of the class using beans or getters/setters -->
		--%>
		
		<!-- to avoid errors use getters and setters -->
	
		<%--
		<c:out value="Name : ${s.name }"/> <br>
		<c:out value="RollNo : ${s.rollno }"/>
		--%>
		
		<!-- list of objects -->
		${students }
		<br><br><br>
		
		<!-- using forloop; 
		items = listname
		var =any name
		 --> 
		<c:forEach items = "${students}" var="s">
		
			${s } <br>
		
		</c:forEach>
		
		<!-- only name -->
				<c:forEach items = "${students}" var="s">
			<br>
			${s.name } &nbsp; &nbsp; ${s.rollno } 
			<br>
		</c:forEach>
		
</body>
</html> 