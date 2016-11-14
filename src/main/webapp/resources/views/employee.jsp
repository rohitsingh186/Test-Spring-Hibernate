<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h2>Employee </h2>
<table>
   <c:out value='${msg}'></c:out>
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>BRID</th>
		<th>Address</th>
		<th>Emails</th>
	</tr>
	<c:forEach items="${employeeList}" var="employee">
		<tr>
			<td> ${employee.id} </td>
			<td> ${employee.name} </td>
			<td> ${employee.brid} </td>
			<td> ${employee.address.city} </td>
			<td> ${employee.emails} </td>
		</tr>
	</c:forEach>
</table>

</body>
</html>
