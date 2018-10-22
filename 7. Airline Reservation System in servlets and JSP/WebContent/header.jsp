

<div class="container">
<nav class="navbar nvabar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand active" href="index.jsp">Airline Reservation System </a>
    </div>
    <ul class="nav navbar-nav navbar-right">
    <% if(session.getAttribute("name")!=null ){
    %>
    
    <li><a href="myaccount">My Account</a></li>
    <li><a href="logout">logout</a></li>
    <%
    }
   
    %>
   
      
     
    </ul>
  </div>
</nav>
