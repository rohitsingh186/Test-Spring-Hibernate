<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<title>Email</title>
		<link rel="stylesheet" type="text/css" href="styles/myStyle.css">
	</head>

	<body>
		<h2>Email</h2>
	
		<table>
	
			<tr>
				<th>ID</th>
				<th>Email</th>
				<th>Employee</th>
				<th>Address</th>
			</tr>
			<c:forEach items="${emailList}" var="email">
				<tr>
					<td>${email.id}</td>
					<td>${email.email}</td>
					<td>${email.employee.name}</td>
					<td>${email.employee.address.city}</td>
				</tr>
			</c:forEach>
		</table>
	
	</body>
</html>
