<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<%@ include file="header.jsp" %>


	<%

	if(session.getAttribute("id")==null){
			
	}
	else if(session.getAttribute("name").equals("admin")){
	
	%>
		 <jsp:forward page="adminpage.jsp" />  
	<%
	}
	else{
	%>
		 <jsp:forward page="customerpage.jsp" />  
	<%
	}
	%>



<div class="thumbnail">
      <a href="">
        <img src="https://banner2.kisspng.com/20180418/xew/kisspng-airplane-logo-travel-elements-5ad8028aa6d2e6.5517491115241058666833.jpg"
        
         alt="Lights" style="width:200px;height:200px">
        <div class="caption">
          <p align="center">Welcome to Airline Management system</p>
        </div>
      </a>
    </div>
    
<ul class="list-group">
  <li class="list-group-item"><a href="adminRegister.jsp">Register as a Admin</a></li>
  <li class="list-group-item"><a href="customerRegister.jsp">Register as Customer</a></li>
  <li class="list-group-item"><a href="adminLogin.jsp">Login as Admin</a></li>
  <li class="list-group-item"><a href="customerLogin.jsp">Login as Customer</a></li>
</ul>

</body>
</html>