package com.models;

import java.sql.*;

/**
 * @author danfe
 */

public class EjecutaConsultas {
    private ConexionDB conexion;
    private ResultSet rs;
    private PreparedStatement sendConsultaSeccion, sendConsultaPais, sendConsultaSeccionPais;
    private final String sqlSeccion = "SELECT * FROM PRODUCTOS WHERE seccion=?";
    private final String sqlPais = "SELECT * FROM PRODUCTOS WHERE paisDeOrigen=?";
    private final String sqlSeccionPais = "SELECT * FROM PRODUCTOS WHERE seccion=? AND paisDeOrigen=?";
    
    public EjecutaConsultas() {
        conexion = new ConexionDB();
    }
    
    public ResultSet filtraBBDD(String seccion, String pais) {
        Connection conecta = conexion.conectaDB();
        rs = null;
        try {
            if (!seccion.equals("Todos") && pais.equals("Todos")) {
                sendConsultaSeccion = conecta.prepareStatement(sqlSeccion);
                sendConsultaSeccion.setString(1, seccion);
                rs = sendConsultaSeccion.executeQuery();
            } else if (seccion.equals("Todos") && !pais.equals("Todos")) {
                sendConsultaPais = conecta.prepareStatement(sqlPais);
                sendConsultaPais.setString(1, pais);
                rs = sendConsultaPais.executeQuery();
            } else {
                sendConsultaSeccionPais = conecta.prepareStatement(sqlSeccionPais);
                sendConsultaSeccionPais.setString(1, seccion);
                sendConsultaSeccionPais.setString(2, pais);
                rs = sendConsultaSeccionPais.executeQuery();
            }
        } catch(SQLException e) {
            e.getMessage();
        }
        return rs;
    }
}
