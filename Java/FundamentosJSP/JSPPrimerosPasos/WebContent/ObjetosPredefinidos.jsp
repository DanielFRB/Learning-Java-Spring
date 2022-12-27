<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Demo Objetos Predefinidos</title>
</head>
<body>
	<h2>Ejemplo de Objetos Predefinidos</h2>
	<br><br>
	<p>Datos del navegador: <%= request.getHeader("User-Agent") %></p>
	<br>
	<p>Idioma detectado: <%= request.getLocale() %></p>
	
</body>
</html>