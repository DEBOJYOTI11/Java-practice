
<pre><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>


<script> 
function validate()
{ 

var email = document.form.email.value;
var password = document.form.password.value;


if (email==null || email=="")
{ 
alert("Email can't be blank"); 
return false; 
}


</script> 
</head>
<body>

<% 
	String name =  (String)request.getSession().getAttribute("name");

	if(name!=null){
	%>
	
	<jsp:forward page="loggedIn.jsp"/>
	<% 	
	}
	
%>
<center><h2>Login Form </h2></center>
<form name="form" action="login" method="post" onsubmit="return validate()">
<table align="left">

<tr>
<td><%=(request.getAttribute("errMessage") == null) ? "": request.getAttribute("errMessage")%></td>
</tr>

<tr>
<td>Email</td>
<td><input type="text" name="email" /></td>
</tr>

<tr>
<td>Password</td>
<td><input type="password" name="password" /></td>
</tr>


<tr>
<td></td>
<td><input type="submit" value="Login"></input><input
type="reset" value="Reset"></input></td>
</tr>

</table>
</form>
</body>
</html>