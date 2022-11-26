package com.transacciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author danfe
 */

public class TransaccionProductos {
    public static void main(String[] args) {
        Connection conexionDB4 = null;
        try {
            conexionDB4 = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
            conexionDB4.setAutoCommit(false);
            Statement statement = conexionDB4.createStatement();
            String sentenceSQL1 = "DELETE FROM PRODUCTOS WHERE paisDeOrigen = 'ITALIA'";
            String sentenceSQL2 = "DELETE FROM PRODUCTOS WHERE precio > 300";
            String sentenceSQL3 = "UPDATE PRODUCTOS SET precio = precio*1.15";
            boolean ejecuta = ejecutarTransaccion();
            if (ejecuta) {
                statement.executeUpdate(sentenceSQL1);
                statement.executeUpdate(sentenceSQL2);
                statement.executeUpdate(sentenceSQL3);
                conexionDB4.commit();
                System.out.println("Se Ejecuto la Transaccion correctamente");
            }
        } catch (Exception e) {
            System.out.println("No se Puede Ejecutar la Transaccion");
            try {
                conexionDB4.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conexionDB4.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    static boolean ejecutarTransaccion() {
        String pregunta = JOptionPane.showInputDialog("Desea Ejecutar la Transaccion?");
        return pregunta.equalsIgnoreCase("SI");
    }
}
