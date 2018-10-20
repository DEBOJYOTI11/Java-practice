<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	Welcome  ${request.getAttribute("user_name") } <br>
	Welcome <%= session.getAttribute("name") %><br>
	Welcome <% request.getAttribute("user_name"); %>
	
	<a href="showregulation?type=user">Show all regulation : </a>
</body>
</html>