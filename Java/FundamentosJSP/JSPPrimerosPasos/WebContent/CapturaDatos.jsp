<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro Exitoso</title>
</head>
<body>
	<%@ page import="java.sql.*" %>
	<%
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");
		String pais = request.getParameter("pais");
		String tecnologias = request.getParameter("tecnologias");
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp", "root", "");
			Statement estado = conexion.createStatement();
			String insertSQL = "INSERT INTO usuarios (nombre, apellido, usuario, clave, pais, tecnologia) VALUES ('"+ nombre +"', '"+ apellido +"', '"+ usuario +"', '"+ clave +"', '"+ pais +"', '"+ tecnologias +"')";
			estado.executeUpdate(insertSQL);
			out.println("Registrado con exito");
		} catch(Exception e) {
			out.println("ERROR EN LA INSERCION DE DATOS");
		} finally {
			try {
				conexion.close();
			} catch (Exception e) {
				out.println("No se pudo cerrar la conexion a la BBDD");
			}
		}
	%>
</body>
</html>