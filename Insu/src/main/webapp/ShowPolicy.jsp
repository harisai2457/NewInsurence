<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}
td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}
tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
<meta http-equiv="Content-Type" content="ext/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
        <jsp:useBean id="beanDAO" class="com.infinite.ins.PolicyDAO"/>
        <table border="5">
        <tr> 
        <th>Policy Id</th>
        <th>Policy Name</th>
        <th>Policy Type</th>
        <th>Premium Amount</th>
        <th>Pay Mode</th>
        <th>Term</th>
        <th>Installment Amount Per Pay Mode</th>
        <th>Matured Amount</th>
        <th>Update</th>
        <th>Delete</th>
        </tr>
        <c:forEach var="pol" items="${beanDAO.showPolicy()}">
        <tr>
        <td>${pol.policyId }</td>
        <td>${pol.policyName}</td>
        <td>${pol.policyType}</td> 
        <td>${pol.premiumAmount}</td> 
        <td>${pol.payMode}</td> 
        <td>${pol.term}</td> 
        <td>${pol.installmentAmountPerPayMode}</td> 
        <td>${pol.maturedAmount}</td> 
        <td>
        	<a href="UpdatePolicy.jsp">Update Policy</a>
        </td>
        <td>
        	<a href="DeletePolicy.jsp">Delete Policy</a>
        </td>
        </tr>        
        </c:forEach>
       
        </table>
        
    
</body>
</html>