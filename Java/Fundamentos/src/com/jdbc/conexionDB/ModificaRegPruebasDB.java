package com.jdbc.conexionDB;

import java.sql.*;

/**
 * @author danfe
 */

public class ModificaRegPruebasDB {
    public static void main(String[] args) {
        try {
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
            Statement miStatement = miConexion.createStatement();
            String sentenciaSql = "INSERT INTO PRODUCTOS (codArticulo, seccion, nombreArticulo, precio, fecha, importado, paisDeOrigen) VALUES ('ACD030', 'DEPORTES', 'BOTINES PARA BASE BALL', 128.60, '2022-08-01', '1', 'USA')";
            //String sentenciaSql = "UPDATE PRODUCTOS SET PRECIO=PRECIO*2 WHERE codArticulo = 'ACD012'";
            //String sentenciaSql = "DELETE FROM PRODUCTOS WHERE codArticulo = 'ACD017'";
            miStatement.executeUpdate(sentenciaSql);
            System.out.println("Datos Ingresados Correctamente a la tabla PRODUCTOS");
            //System.out.println("Precio del Producto Actualizado");
            //System.out.println("Producto Eliminado");
        } catch (Exception e) {
            System.out.println("No se pudo establecer la Conexion con la BD");
            e.printStackTrace();
        }
    }
}
