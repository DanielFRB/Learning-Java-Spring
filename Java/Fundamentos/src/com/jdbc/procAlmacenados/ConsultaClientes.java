package com.procAlmacenado;

import java.sql.*;

/**
 * @author danfe
 */

public class ConsultaClientes {
    public static void main(String[] args) {
        try {
            Connection conexionDB = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
            CallableStatement statement = conexionDB.prepareCall("{call MUESTRA_CLIENTES_GNRE}");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1) +", "+ rs.getString(2) +", "+ rs.getString(3));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("No se pudo conectar con la BD");
            e.printStackTrace();
        }
    }
}
