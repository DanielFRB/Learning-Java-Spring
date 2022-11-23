package com.models;

import java.sql.*;

/**
 * @author danfe
 */

public class ConexionDB {
    private Connection conexionPruebasDB = null;
    
    public ConexionDB() {}
    
    public Connection conectaDB() {
        try {
            conexionPruebasDB = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
        } catch (Exception e) {
            System.out.println("No se pudo establecer la Conexion con la BD");
            e.printStackTrace();
        }
        return conexionPruebasDB;
    }
}
