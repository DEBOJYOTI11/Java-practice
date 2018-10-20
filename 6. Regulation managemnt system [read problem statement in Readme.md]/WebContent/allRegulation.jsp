<%@page import="java.util.ArrayList"%>
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
	ArrayList<RegulationBean> arr = (ArrayList<RegulationBean>)request.getAttribute("data"); 
	
	for(RegulationBean rb :arr){
		%>
		
		<h3><%= rb.getRegulationHeading() %></h3>
		<%= rb.getRegulationBody() %><br/>
		
		<a href="regulationDetail?id=<%= rb.getId() %>">Open Regulation</a><hr/>
		
		
		<% 
	}

%>
</body>
</html>