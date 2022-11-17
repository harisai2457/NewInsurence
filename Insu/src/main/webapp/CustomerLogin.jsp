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
        <a href="#">Insurance</a>
      </div>
      <ul>
       <li><a href="AgentLogin.jsp">Agent</a></li>
        <li><a href="CustomerLogin.jsp">Customer</a></li>
        
        <li><a href="#">About</a></li>
        <li><a href="#">Contact Us</a></li>
      </ul>
    </div>
  </nav>
<!-- partial:index.partial.html -->
<div id="login-form-wrap">
  <h2>Customer Login</h2>
  <form id="login-form" action="CustomerBookPolicy.jsp">
    <p>
    <input type="text" id="username" name="username" placeholder="Username" required><i class="validation"><span></span><span></span></i>
    </p>
    <p>
    <input type="email" id="email" name="email" placeholder="Email Address" required><i class="validation"><span></span><span></span></i>
    </p>
    <p>
    <input type="submit" id="login" value="Login">
    </p>
  </form>
  <div id="create-account-wrap">
    <p>Not a member? <a href="AddCustomer.jsp">Create Account</a><p>
  </div><!--create-account-wrap-->
</div><!--login-form-wrap-->
<!-- partial -->
  
</body>
</html>
