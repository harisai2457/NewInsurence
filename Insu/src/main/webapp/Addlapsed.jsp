<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="beanDao" class="com.infinite.ins.InsDAO"/>
<form method="get" action="Addlapsed.jsp">
	<center>
		Enter loanId :
		<input type="text" name ="loanId"/><br/><br/>
		Enter policyId :
		<input type="text" name ="policyId"/><br/><br/>
		Enter lapsedAmount:
		<input type="number" name ="lapsedAmount"/><br/><br/>
		Enter refundAmount :
		<input type="number" name ="refundAmount"/><br/><br/>
		<input type="submit" value ="Insert"/><br/><br/>
	</center>
<c:if test="${param.loanId != null && param.policyId != null}">
	<jsp:useBean id="beanRoom" class="com.infinite.ins.Lapsed" />
	<jsp:setProperty property="*" name="beanRoom"/>
	<c:out value="${beanDao.addLapsed(beanRoom)}"/>
</c:if>
</form>
<form action="Menu.jsp">
	
	<input type="submit" value="Submit"/>
</form>

</body>
</html>