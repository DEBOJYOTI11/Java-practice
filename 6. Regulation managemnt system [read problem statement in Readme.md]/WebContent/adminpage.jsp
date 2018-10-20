<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
Add a new regulation 
<form method="post" action="addregulation">

	Heading : <input name="heading" type="text" />
	Regulation : <input type="text" name="regulation" />
	
	<input type="submit" value="add regulation" />
</form>


<hr/>

<a href="showregulation?type=admin">Show all regulation : </a>
</body>
</html>