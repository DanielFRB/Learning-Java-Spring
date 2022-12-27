<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejemplo de Scriptlet JSP</title>
</head>
<body>
	<h1>Ejemplo de Scriptlet JSP</h1>
	<br>
	<%
		for(int i = 0; i < 10; i++) {
			out.println("<br>Este es el mensaje: "+ i);
		}
	%>
</body>
</html>