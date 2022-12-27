<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dfrb.java.jsp.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Llamadas a Metodos Java</title>
</head>
<body>
	<h1>Ejemplo de Llamadas a Metodos de una clase Java</h1>
	<br>
	<p>El resultado de la suma de 45 y 20 es: <b><%= Calculos.suma(45, 20) %></b></p>
	<br>
	<p>El resultado de la resta de 45 y 20 es: <b><%= Calculos.resta(45,20) %></b></p>
	<br>
	<p>El resultado de la muliplicacion de 4 y 20 es: <b><%= Calculos.multiplica(4, 20) %></b></p>
	<br>
</body>
</html>