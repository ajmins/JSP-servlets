<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ErrorLists</title>
</head>
<body style="color:red;">
Error
	<!-- Exception Handling jsp page -->
	<%--  <%= exception %> --%> <!-- comment -->
	<!-- to display the error msg we can use exception inside an expression
	but before that we need to tell error.jsp as this is a error handling page
	for that use isErrorPage = "true" in  directive -->
	<%= exception.getMessage() %>
</body>
</html>