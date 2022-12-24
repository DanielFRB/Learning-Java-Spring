<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario de Registro</title>
</head>
<body>
	<form:form action="registeredForm" modelAttribute="alumno"></form:form>
		Nombre: <form:input path="nombre" />
		<br><br>
		Apellido: <form:input path="apellido" />
		<br><br>
		Email: <form:input path="email" />
		<br><br>
		<input type="submit" value="Registrar" />
</body>
</html>