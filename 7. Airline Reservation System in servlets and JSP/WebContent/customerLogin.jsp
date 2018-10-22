<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<%@ include file="header.jsp" %>

	<h4>Customer Login</h4>
        	
        	<form action="customerLogin" method="post">
				<table class="table">
				<tr>
				<td>Email : </td>
				<td><input type="email" name="mail"/></td>
				</tr>
				
				<tr>
				<td>
				Password : </td>
				<td><input type="password" name="pass"/></td>
				</tr>
				<tr><td>
				
				<input type="submit" value="submit" class="btn btn-success"/>
				</td></tr>
			</form>
</body>
</html>