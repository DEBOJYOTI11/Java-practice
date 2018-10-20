<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<%
	if(session.getAttribute("name")==null){
		
	}
	else if(session.getAttribute("name") == "admin"){
	%>
		<jsp:forward page="adminpage.jsp" />  
	
	<%
	}
	else{
		
	%>
		<jsp:forward page="userpage.jsp" /> 
	<%
	}

	%>
Log in as 
<a href="login.jsp?type=admin">Admin</a>
<br>
<a href="login.jsp?type=user">User</a>
</body>
</html>