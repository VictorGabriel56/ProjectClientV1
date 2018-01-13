<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>New Client</title>
</head>
<body>
	<form action="ClientController?action=save" method="POST" style="border: 2; margin-top: 130px;">
		<h3>Clients Register</h3>
		<fieldset>
			<div>
				<input type="hidden"  readonly="readonly" name="id" value="<c:out value="${client.id}" />" />
			</div>
			<div>
				<label for="name">Name</label> 
				<input type="text"
					name="name" value="<c:out value="${client.name}" />"
					placeholder="Name" />
			</div>
			<br/>
			<div>
				<label for="Email">E-mail</label> 
				<input type="text"
					name="email" value="<c:out value="${client.email}" />"
					placeholder="E-mail" />
			</div>
			
			
			<div>
				<br/>
				<input type="submit" value="Save" />
			</div>
		</fieldset>
	</form>
</body>
</html>