package com.jdbc.conexionDB;

import java.sql.*;

/**
 * @author danfe
 */

public class ConsultasPreparadas {
    public static void main(String[] args) {
        try {
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
            String sentenciaSql = "SELECT * FROM PRODUCTOS WHERE seccion=? AND paisDeOrigen=?";
            PreparedStatement sentence = miConexion.prepareStatement(sentenciaSql);
            sentence.setString(1, "DEPORTES");
            sentence.setString(2, "CHINA");
            ResultSet rs = sentence.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("codArticulo") +" "+ rs.getString("seccion") +" "+ rs.getString("nombreArticulo") +" "+ rs.getDouble("precio") +" "+ rs.getString("paisDeOrigen"));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("No se pudo establecer la Conexion con la BD");
            e.printStackTrace();
        }
    }
}
