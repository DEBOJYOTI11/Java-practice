<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<%@ page import="beans.RegulationBean,java.util.ArrayList"  %>

	<%
		RegulationBean arr = (RegulationBean )request.getAttribute("data"); 
		
		
	%>
	<%= arr.getId() %><br>
	<%= arr.getRegulationHeading() %><br>
	<%= arr.getRegulationBody() %>
	
	
	<form method= "post" action="addfeedback">
	
		Add feedback : <input type="text" name="feedback"/>
		<input type="submit" value="add feedback"/>
		<input type="hidden" name="user_id" value="<%= session.getAttribute("user_id") %>" />;
	</form>
	
</body>
</html>