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
<form method="get" action="booking.jsp">
<center>
CustomerId :
<input type="text" name="customerId" /><br/><br/>
PolicyID :
<input type="text" name="policyID" /><br/><br/>
<input type="submit" value="view" />
</form>
</center>
    
    <c:set var="pid" value="0"/>
    <c:set var="cid" value="0"/>
    <c:if test="${param.customerId!= null && param.policyID!= null}">
    <jsp:useBean id="beanDAO" class="com.infinite.ins.bookingDAO"/>
    <c:set  var="pid" value="${param.policyID }"/>
    <c:set var="cid" value="${param.customerId}"/>
    <c:set var="polId" value="${pid}" scope="session"/>
    <c:set var="cusId" value="${cid}" scope="session"/>
    
    <c:set var="search" value="${beanDAO.searhByPolicyId(pid)}"/>
    <c:out value="Values Stored..."/>
    </c:if>
    <c:out value="${sessionScope.polId}"/>
    <c:out value="${sessionScope.cusId}"/>
    <form  action="booking.jsp">
    Paymode:
    
    <input type="text" name="paymode" value="${search.payMode }"/>
    <input type="submit" value="Booking" />
        
    </form>
    <c:if test="${param.paymode!=null}">
    <c:out value="${sessionScope.polId}"/>
    <c:out value="${sessionScope.cusId}"/>
    
    <jsp:useBean id="booking" class="com.infinite.ins.BookingDetails"/>
    <jsp:setProperty property="policyID" name="booking" value="${sessionScope.polId}"/>
    PJSP ID :
    <jsp:getProperty property="policyID" name="booking"/>
    <jsp:setProperty property="customerId" name="booking" value="${sessionScope.cusId}"/>
    <jsp:getProperty property="customerId" name="booking"/>
    <jsp:setProperty property="payMode" name="booking" value="${param.paymode}"/>
    <jsp:useBean id="bookingDao" class="com.infinite.ins.bookingDAO"/>
    <c:out value="${bookingDao.addBooking(booking)}"/>
    </c:if>



</body>
</html>