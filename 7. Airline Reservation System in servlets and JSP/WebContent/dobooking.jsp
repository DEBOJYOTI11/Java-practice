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


<h4>Passenger Details</h4>
        	
        	<form action="bookFlight" method="post">
        	
        		<input type="hidden" name="flightnumber" value="<%= request.getParameter("flightnumber") %>" />
				
				<table class="table">
				<tr>
				<td>How many tickets : </td>
				<td><input type="text" name="howmany"/></td>
				</tr>
				<tr>
				
				<td>Passenger 1</td>
				</tr>
				<tr>
				
				<td><input type="text" name="p1" placeholder="Passenger Name "/></td>
				<td><input type="text" name="p2" placeholder="Passenger DOB "/></td>
				<td><input type="email" name="p3" placeholder="Passenger EMail "/></td>
				</tr>
				
				<tr>
				<td>Passenger 2
				</td></tr>
			<tr>
		
				<td><input type="text" name="p4" placeholder="Passenger Name "/></td>
				<td><input type="text" name="p5" placeholder="Passenger DOB "/></td>
				<td><input type="email" name="p6" placeholder="Passenger EMail "/></td>
				</tr>
				

				
			<tr><td>Card details</td>
			</tr>
			
			<tr>
			<td> Card number : </td>
			<td><input type="text" name="cardnumber"></td>
			</tr>
			
			<tr>
			<td> Pin number : </td>
			<td><input type="text" name="pin"></td>
			</tr>
			
				
				
				<tr>
				<td>
				
				<input type="submit" value="submit" class="btn btn-success"/>
				</td></tr>
			</form>
</body>
</html>