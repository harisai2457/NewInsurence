<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


    
   <jsp:useBean id="beanDao" class="com.infinite.ins.CustomerDAO"/>
    <table border="3" align="center">
    <tr>
        <th>Customer Id</th>
        <th>Customer Name</th>
        <th>Customer Designation</th>
        <th>Customer Email</th>
        <th>Customer Address</th>
        <th> Customer Contact</th>
        <th>Update</th>
        <th>Delete</th>
        <th>Search</th>
        
    </tr>
    <c:forEach var="a" items="${beanDao.showCustomer()}">
        <c:set var="id" value="${a.customerName}"></c:set>
        <tr>
            <td>${a.customerId}</td>
            <td>${a.customerName}</td>
            <td>${a.customerDesignation}</td>
            <td>${a.customerEmail}</td>
            <td>${a.customerAddress}</td>
            <td>${a.customerContact}</td>
            <td><a href="UpdateCustomer.jsp?id=${id}">Update</a>
            <td><a href="DeleteCustomer.jsp?id=${id}">Delete</a>
            <td><a href ="Search.jsp?id=${id}">Search</a>
           
        </tr>
    </c:forEach>
    </table>



</body>
</html>