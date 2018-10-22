<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<%@ include file="header.jsp" %>
<%@ page import="com.nissan.training.corejava.project.models.CustomerModel" %>
<%@ page import= "java.util.ArrayList" %>


<% 
	CustomerModel c= (CustomerModel)request.getAttribute("data");
%>
			My Profile 
	     	<form action="customerUpdate" method="post">
				<table class="table">
				<tr>
				<td>Name : </td>
				<td><input type="text" name="name" value="<%= c.getCustName() %>"/></td>
				</tr>
				
				<tr>
				<td>Email : </td>
				<td><input type="email" name="email" value="<%= c.getCustEmail() %>"/></td>
				</tr>
				
				<tr>
				<td>
				
				<td><input type="hidden" name="id" value="<%= c.getId() %>"/></td>
				</tr>
				
				<tr>
				<td>
				DOB : </td>
				<td><input type="text" name="dob" value="<%= c.getCustDob() %>"/></td>
				</tr>
				
				<tr>
				<td>
				Contact Number </td>
				<td><input type="text" name="number" value="<%= c.getCustContactNumber() %>"/></td>
				</tr>
				
				<tr><td>
				
				<input type="submit" value="update profile" class="btn btn-success btn-block"/>
				</td></tr>
			</form>

<%
%>
</body>
</html>