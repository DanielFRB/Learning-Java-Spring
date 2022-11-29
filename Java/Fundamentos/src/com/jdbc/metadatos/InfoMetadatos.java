package com.jdbc.metadatos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author danfe
 */

public class InfoMetadatos {
    public static void main(String[] args) {
        mostrarInfoBD();
        System.out.println("--------");
        mostrarInfoTablasBD();
    }
    
    static void mostrarInfoBD() {
        Connection conexionDB4 = null;
        try {
            conexionDB4 = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
            DatabaseMetaData datosBD = conexionDB4.getMetaData();
            System.out.println("Gestor de BBDD: "+ datosBD.getDatabaseProductName());
            System.out.println("Version del Gestor: "+ datosBD.getDatabaseProductVersion());
            System.out.println("Nombre del Driver: "+ datosBD.getDriverName());
            System.out.println("Version del Driver: "+ datosBD.getDriverVersion());
        } catch (Exception e) {
            System.out.println("No se Puede Conectar con la BD");
            e.printStackTrace();
        } finally {
            try {
                conexionDB4.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    static void mostrarInfoTablasBD() {
        Connection conexionDB4 = null;
        try {
            conexionDB4 = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
            DatabaseMetaData datosBD = conexionDB4.getMetaData();
            System.out.println("Lista de Tablas");
            ResultSet rs = datosBD.getTables(null, null, null, null);
            while (rs.next()) {
                System.out.println(rs.getString("TABLE_NAME"));
            }
            System.out.println("--------");
            System.out.println("Campos de la Tabla Productos");
            rs = datosBD.getColumns(null, null, "productos", null);
            while (rs.next()) {
                System.out.println(rs.getString("COLUMN_NAME"));
            }
        } catch (Exception e) {
            System.out.println("No se Puede Conectar con la BD");
            e.printStackTrace();
        } finally {
            try {
                conexionDB4.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
