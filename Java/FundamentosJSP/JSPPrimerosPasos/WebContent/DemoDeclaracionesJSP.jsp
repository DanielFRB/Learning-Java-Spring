<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejemplo de Declaraciones JSP</title>
</head>
<body>
	<h1>Ejemplo de Declaraciones JSP</h1>
	<br>
	<%!
		private int result;
	
		public int suma(int x, int y) {
			return result = x+y;
		}
		
		public int resta(int x, int y) {
			return result = x-y;
		}
		
		public int multiplica(int x, int y) {
			return result = x*y;
		}
	%>
	<p>El resultado de la suma de 45 y 20 es: <b><%=suma(45,20) %></b></p>
	<br>
	<p>El resultado de la resta de 45 y 20 es: <b><%=resta(45,20) %></b></p>
	<br>
	<p>El resultado de la muliplicacion de 4 y 20 es: <b><%=multiplica(4, 20) %></b></p>
	<br>
</body>
</html>