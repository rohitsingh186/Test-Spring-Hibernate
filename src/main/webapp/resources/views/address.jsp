<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<title>Address</title>
		<link rel="stylesheet" type="text/css" href="styles/myStyle.css">
	</head>

	<body>
		<h2>Address</h2>
	
		<table>
	
			<tr>
				<th>ID</th>
				<th>Address</th>
				<th>Employee</th>
			</tr>
			<c:forEach items="${addressList}" var="address">
				<tr>
					<td>${address.id}</td>
					<td>${address.city}</td>
					<td>${address.employee.name}</td>
				</tr>
			</c:forEach>
		</table>
	
	</body>
</html>
