package com.procAlmacenado;

import java.sql.*;
import javax.swing.*;

/**
 * @author danfe
 */

public class ActualizaProducto {
    public static void main(String[] args) {
        double nPrecio = Double.parseDouble(JOptionPane.showInputDialog("Introduce el Precio: "));
        String nArticulo = JOptionPane.showInputDialog("Introduce el Nombre del Articulo: ");
        try {
            Connection conexionDB2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
            CallableStatement statement2 = conexionDB2.prepareCall("{call ACTUALIZA_PROD(?, ?)}");
            statement2.setDouble(1, nPrecio);
            statement2.setString(2, nArticulo);
            statement2.execute();
            System.out.println("Articulo actualizado.");
        } catch (Exception e) {
            System.out.println("No se pudo conectar con la BD");
            e.printStackTrace();
        }
    }
}
