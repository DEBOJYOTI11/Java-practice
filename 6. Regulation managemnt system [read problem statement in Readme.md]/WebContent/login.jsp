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
        if ("admin".equals(request.getParameter("type"))) {
    %>
        	Log in as admin
        	<form action="adminlogin" method="post">
	
				Name : <input type="text" name="name"/>
				Password : <input type="password" name="password"/>
				<input type="submit" value="submit"/>
			</form>
    <%
        }
        else {
    %>
    
    	Log in as user
        <form action="userlogin" method="post">
	
				Email Id : <input type="email" name="email_id" />
				Password : <input type="password" name="password"/>
				<input type="submit" value="submit"/>
			</form>
    <%
        }
    %>


</body>
</html>