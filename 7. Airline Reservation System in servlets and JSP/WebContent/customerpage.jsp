<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<%@ include file="header.jsp" %>

	<h2>Welcome <%= session.getAttribute("name") %></h2>
	<hr/>
	<ul class="list-group">
	<li class="list-group-item"><a href="showCustomerBookings">See all my Bookings</a></li>
	<li class="list-group-item"><a href="bookFlight?id=<%= session.getAttribute("id") %>"> Book a flight</a></li>
	<li class="list-group-item"><a href="#">Modify a Booking</a></li>
	<li class="list-group-item"><a href="myaccount">Update your account</a></li>
	</ul>



</body>
</html>