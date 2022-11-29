package com.conexionDB;

import java.sql.*;

/**
 * @author danfe
 */

public class ConectaPruebasDB {
    public static void main(String[] args) {
        try {
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
            Statement miStatement = miConexion.createStatement();
            ResultSet miResulSet = miStatement.executeQuery("SELECT * FROM PRODUCTOS");
            while (miResulSet.next()) {
                System.out.println(miResulSet.getString("codArticulo") +" "+ miResulSet.getString("nombreArticulo") +" "+ miResulSet.getDouble("precio"));
            }
            miResulSet.close();
        } catch (Exception e) {
            System.out.println("No se pudo establecer la Conexion con la BD");
            e.printStackTrace();
        }
    }
}
