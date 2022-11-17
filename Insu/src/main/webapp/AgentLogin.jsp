<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  <h2>AgentLogin</h2>
  <form id="login-form">
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
  
</div><!--login-form-wrap-->
<!-- partial -->
  
  <c:if test="${param.username!=null && param.email!=null}">
		<jsp:useBean id="beanAgentLogin" class="com.infinite.ins.AgentLogin"/>
		<jsp:setProperty property="*" name="beanAgentLogin"/>
		<jsp:useBean id="beanDao" class="com.infinite.ins.InsDAO"/>
		<c:set var="user" value="${param.username}"/>
		<c:set var="pwd" value="${param.email}"/>
		<c:set var="count" value="${beanDao.loginCheck(user,pwd)}"/>
		<c:if test="${count==1}">
		<c:set var="user" value="${user}" scope="session" />
					<jsp:forward page="AgentDashboard.jsp"/>
		
		</c:if>
		<c:if test="${count==0}">
			<c:out value="Invalid Credentials..."/>
		</c:if>
	</c:if>
</body>
</html>
