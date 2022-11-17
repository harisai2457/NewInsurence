<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>


*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Poppins',sans-serif;
}
nav{
  position: fixed;
  background: black;
  width: 100%;
  padding: 10px 0px ;

}
nav .menu{
  max-width: 1250px;
  margin: auto;
  display: flex;
  align-items: center;
  justify-content: space-between;
  
}
.menu .logo a{
  text-decoration: none;
  color:white;
  font-size: 35px;
  font-weight: 600;
}



.menu ul li a{
  text-decoration: none;
  color:white;
  font-size: 18px;
  font-weight: 500;
  padding: 8px 15px;
  border-radius: 5px;
}
.menu ul li a:hover{
  background:white;
  color: black;
}
table {
  font-family: arial, sans-serif;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

th{
	color: black;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
<meta http-equiv="Content-Type" content="ext/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:out value="${sessionScope.user}" />
    <jsp:useBean id="beanDAO" class="com.infinite.ins.PolicyDAO"/>
     
        <table border="2">
        <tr> 
        <th>Policy Id</th>
        <th>Policy Name</th>
        <th>Policy Type</th>
        <th>Premium Amount</th>
        <th>Pay Mode</th>
        <th>Term</th>
        <th>Installment Amount Per Pay Mode</th>
        <th>Matured Amount</th>
        <th>Book the policy</th>
       
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
        <td><a href="booking.jsp">Book</a></td>
        
        </tr>        
        </c:forEach>
       
        </table>
            
   
</body>
</html>