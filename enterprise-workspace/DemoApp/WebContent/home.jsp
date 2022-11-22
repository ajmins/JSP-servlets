<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage = "error.jsp"  %>
    <!-- errorPage handles all the errors in this page -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exception Handling</title>
</head>
<body>
<%-- 
<%
//not a good method to inform about the exception
	try{
		int k = 9/0;
	}
	catch(Exception e){
		out.println("Error: "+e.getMessage());
	}

%>
--%>
<%
	int k = 9/0;
%>

</body>
</html>