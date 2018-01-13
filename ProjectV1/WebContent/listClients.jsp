<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registered Customers</title>
</head>
<body>
	<div align="center" style="margin-top: 150px;">
		<h4>
			Registered Customers
		</h4>
		
		${msg}
		<table border="1" >
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Email</th>
					<th colspan="2">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${clients}" var="clients">
					<tr>
						<td><c:out value="${clients.id}" /></td>
						<td><c:out value="${clients.name}" /></td>
						<td><c:out value="${clients.email}" /></td>
						
						<td><a href="ClientController?action=edit&id=<c:out value='${clients.id}'/>">Edit</a></td>
						<td><a href="ClientController?action=delete&id=<c:out value='${clients.id}' />">Remove</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p>
			<a href="ClientController?action=new">New Client</a>
		</p>
	</div>
</body>
</html>
