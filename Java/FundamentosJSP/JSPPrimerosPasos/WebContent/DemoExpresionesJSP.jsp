<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejemplo de las Expresiones JSP</title>
</head>
<body>
	<h1>Ejemplo de Expresiones JSP</h1>
	<p>Convirtiendo a Mayusculas: <%= new String("daniel").toUpperCase() %></p>
	<br>
	<p>La suma de 20 y 45 es: <b><%= 45+20 %></b></p>
	<br>
	<p>¿25 es mayor que 46?: <%= 25>46 %></p>
</body>
</html>