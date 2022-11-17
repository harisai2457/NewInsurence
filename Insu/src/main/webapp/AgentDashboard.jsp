<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>HTML5 Login Form with validation Example</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="./Style.css">

</head>
<body>

  <nav>
    <div class="menu">
      <div class="logo">
        <a href="#">AgentDashboard</a>
      </div>
      <ul>
       <li><a href="ShowPolicy.jsp">PolicyDetails</a></li>
        <li><a href="CustomerLogin.jsp">CustomerDetails</a></li>
        
        <li><a href="#">BookingDetails</a></li>
        <li><a href="#">PaymentDetails</a></li>
      </ul>
    </div>
  </nav>
  Welcome to  : 
<b>
<c:out value="${sessionScope.user}" />

  
</body>
</html>
