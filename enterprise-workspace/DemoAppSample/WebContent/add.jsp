<!-- directive : for importing packages -->
<%@page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@include file="header.jsp" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP test</title>
</head>
<body bgcolor = "green">
		<!-- declaration: outside service method -->
		<%!
			int coef = 10;
			//we can import packages using directives (see the top)
			Scanner scanner = new Scanner(System.in);
			
		%>

		<!-- scriptlet : inside service method -->
		<% 
		int i = Integer.parseInt(request.getParameter("num1")); 
		int j = Integer.parseInt(request.getParameter("num2"));
		
		int k = i + j;
		
		out.println("Output: "+k);
		out.println("\n"); //won't work
		%>	
		<br/>
		<!-- Expression: to print directly, without using out.println -->
		My favourite Number: <%= coef %>
		
</body>
</html>