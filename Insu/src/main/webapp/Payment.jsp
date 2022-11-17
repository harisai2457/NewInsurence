<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="beanDao" class="com.infinite.ins.InsuranceDAO"/>
<jsp:useBean id="payment" class="com.infinite.ins.Payment"/>
<form method="get" action="Payment.jsp">

Booking ID:
<input type="text" name="bookingId">
<br/>

<input type="Submit" value="view">
</form>
<c:if test="${param.bookingId != null}">
<c:set var="id" value="${param.bookingId}"/>
<c:set var="search" value="${dao.searchBookId(id)}"/>
<form>
<input type="text" name="policyID" value="${search.policyID}"/>
<input type="text" name="customerId" value="${search.customerId}"/>
<input type="submit" value="paynow">
<c:out value="${beanDao.addPayments(payment) }"/>
</form>
</c:if>


</body>
</html>