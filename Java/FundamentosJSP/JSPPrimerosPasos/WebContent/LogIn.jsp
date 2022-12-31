<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Please Log In</title>
</head>
<body>
	<%@ page import="java.sql.*" %>
	<%
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conexionDB = null;
		try {
			conexionDB = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp", "root", "");
			String selectSQL = "SELECT * FROM USUARIOS WHERE usuario=? AND clave=?";
			PreparedStatement sentence = conexionDB.prepareStatement(selectSQL);
			sentence.setString(1, usuario);
			sentence.setString(2, clave);
			ResultSet result = sentence.executeQuery();
			
			if (result.absolute(1)) {
				out.println("Usuario Autorizado");
			} else {
				out.println("Usuario NO autorizado");
			}
			
			result.close();
		} catch(Exception e) {
			out.println("ERROR AL CONSULTAR EL USUARIO");
		} finally {
			try {
				conexionDB.close();
			} catch (Exception e) {
				out.println("No se pudo cerrar la conexion a la BBDD");
			}
		}
		
	%>
</body>
</html>