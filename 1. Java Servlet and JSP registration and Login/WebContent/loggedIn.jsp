<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%= session.getAttribute("name") %></title>
</head>
<body>

	<h2 align="center">Welcome back 
	
	<% out.print((String)request.getSession().getAttribute("name")); %></h2>
</body>
</html>