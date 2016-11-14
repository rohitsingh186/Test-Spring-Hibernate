<html>
<body>
<h2>Employee </h2>
<table>
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>BRID</th>
		<th>Address</th>
		<th>Emails</th>
	</tr>
	<c:forEach items="${employeeList}" var="employee">
		<tr>
			<td> <c:out value="${employee.id}"> </td>
			<td> <c:out value="${employee.name}"> </td>
			<td> <c:out value="${employee.brid}"> </td>
			<td> <c:out value="${employee.address.city}"> </td>
			<td> <c:out value="${employee.emails}"> </td>
		</tr>
	</c:forEach>
</table>

</body>
</html>
