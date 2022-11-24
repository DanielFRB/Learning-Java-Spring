package com.transacciones;

import java.sql.*;

/**
 * @author danfe
 */

public class InsertaClientePedidos {
    public static void main(String[] args) {
        Connection conexionDB3 = null;
        try {
            conexionDB3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
            conexionDB3.setAutoCommit(false);
            Statement statement = conexionDB3.createStatement();
            String sql1 = "INSERT INTO CLIENTES (CODCLIENTE, EMPRESA, DIRECCION, POBLACION, TELEFONO, RESPONSABLE) VALUES ('CDT-000011', 'LABORATORIO CLINICO CARMONA', 'CARRERA 2, CON CALLE 8', 'GUANARE', '0257-4158962', 'LIC. LUIS CARMONA')";
            statement.executeUpdate(sql1);
            String sql2 = "INSERT INTO PEDIDOS (NUMEROPEDIDO, CODIGOCLIENTE, FECHAPEDIDO) VALUES ('PED-000001', 'CDT-000011', '2022-08-01')";
            statement.executeUpdate(sql2);
            conexionDB3.commit();
            System.out.println("Datos Insertados Correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR EN LA INSERCION DE DATOS");
            try {
                conexionDB3.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
