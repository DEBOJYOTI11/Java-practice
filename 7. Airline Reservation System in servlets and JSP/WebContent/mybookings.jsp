<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<%@ include file="header.jsp" %>
<%@ page import="com.nissan.training.corejava.project.models.BookingModel" %>
<%@ page import= "java.util.ArrayList" %>

<h4>My Booked FLights</h4>
<table class="table table-striped">

		
	<thead class="thead-dark">
	
	<tr>
	<th>Booking ID</th><th>Ticket ID</th><th>Booking Date</th><th>Customer Name</th><th>Contact Number</th><th>Flight Number</th>
	<th>Passenger Name</th>
	<th>Passenger Email</th>
	<th>Passenger DOB</th>
	<th>Flight Arrival</th>
	<th>Flight Departure</th>
	
	</tr></thead>
	<tbody>

<%
	
	ArrayList<BookingModel> arr = (ArrayList<BookingModel>)request.getAttribute("data");
	
	for(BookingModel f : arr){
		%>
		

		<tr>
			<td><%= f.getBookingID() %></td>
			<td><%=  f.getTicketID() %></td>
			<td><%=  f.getBookingDate() %></td>
			<td><%=  f.getCustomerName() %></td>
			<td><%= f.getCustomerContactNumber() %></td>
			<td><%=  f.getFlightNumber()%></td>
			<td><%=  f.getPassengerName() %></td>
			<td><%= f.getPassengerEmail() %></td>
			<td><%=  f.getPassengerDOB() %></td>
			<td><%=  f.getFlightArrival()%></td>
			<td><%=  f.getFlightDeparture() %></td>
			<td> <a href="modifyBooking?id=<%=f.getBookingID() %>"><span style="color:red"> X </span>Click to cancel booking </a></td>
		</tr>
		<%
		}		
	
%>
</tbody>
</table>

</body>
</html>