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
<%@ page import="com.nissan.training.corejava.project.models.FlightModel" %>
<%@ page import= "java.util.ArrayList" %>

<h4>All  available flights</h4>
<table class="table table-striped">

		
	<thead>
	
	<tr>
	<th>ID</th><th>Arrival</th><th>Departure</th><th>Arrival Time</th><th>Departure Time</th><th>Flight Number</th>
	<th>Company Name</th>
	<th>Status</th>
	<th>Number of available seats</th>
	<th>Type</th>
	<th>Cost of a ticket</th>
	</tr></thead>
	<tbody>

<%
	
	ArrayList<FlightModel> arr = (ArrayList<FlightModel>)request.getAttribute("data");
	
	for(FlightModel f : arr){
		%>
		
		<tr>
			<td><%= f.getFlightID() %></td>
			<td><%=  f.getFlightArrival() %></td>
			<td><%=  f.getFlightDeparture() %></td>
			<td><%=  f.getFlightArrivalTime()%></td>
			<td><%= f.getFlightDepartureTime() %></td>
			<td><%=  f.getFlightNumber()%></td>
			<td><%=  f.getFlightCompany() %></td>
			<td><%= f.getFlightStatus() %></td>
			<td><%=  f.getFlightNumberOfSeats() %></td>
			<td><%=  f.getFlightType()%></td>
			<td><%=  f.getFlightCost() %></td>
			<td><a href="dobooking.jsp?flightnumber=<%=f.getFlightNumber() %>">Click to select </a></td>
		</tr>
		<%
		}		
	
%>
</tbody>
</table>

</body>
</html>