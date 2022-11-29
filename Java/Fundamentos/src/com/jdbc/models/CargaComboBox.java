package com.jdbc.models;

import java.sql.*;

/**
 * @author danfe
 */

public class CargaComboBox {
    public ConexionDB miConexion;
    public ResultSet rs, rs2;
    Productos miProducto;
    
    public CargaComboBox() {
        miConexion = new ConexionDB();
    }
    
    public ResultSet ejecutaConsultas() {
        Connection accesoDB = miConexion.conectaDB();
        try {
            Statement secciones = accesoDB.createStatement();
            Statement paises = accesoDB.createStatement();
            rs = secciones.executeQuery("SELECT DISTINCTROW seccion FROM PRODUCTOS");
            rs2 = paises.executeQuery("SELECT DISTINCTROW paisDeOrigen FROM PRODUCTOS");
            miProducto = new Productos();
            miProducto.setSeccion(rs.getString(1));
            miProducto.setPaisDeOrigen(rs2.getString(1));
            rs.close();
            rs2.close();
            accesoDB.close();
        } catch (SQLException e) {
            System.out.println("No se pudo ejecutar la Consulta");
        }
        return null;
    }
}
