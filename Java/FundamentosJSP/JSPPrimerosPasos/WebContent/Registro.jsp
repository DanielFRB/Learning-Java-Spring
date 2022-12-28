<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro de Clietes</title>
</head>
<body>
	<h2>Clientes Registrados</h2>
	<br>
	<jsp:include page="Fecha.jsp"></jsp:include>
	<br>
	<p>Cliente Resistrado:</p>
	<br>
	<p>Nombre: <%= request.getParameter("nombre") %> </p>
	<br>
	<p>Apellido: <%= request.getParameter("apellido") %> </p>
	<br>
	<p>Email: <%= request.getParameter("email") %> </p>
</body>
</html>