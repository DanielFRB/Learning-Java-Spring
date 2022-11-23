package com.controllers;

import com.models.*;
import com.views.*;
import java.awt.event.*;

/**
 * @author danfe
 */

public class ControlCargaComboBox extends WindowAdapter {
    CargaComboBox obj = new CargaComboBox();
    private MarcoAplicacion2 marco;
    
    public ControlCargaComboBox(MarcoAplicacion2 marco) {
        this.marco = marco;
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
        obj.ejecutaConsultas();
        try {
            while (obj.rs.next()) {
                marco.secciones.addItem(obj.rs.getString(1));
            }
            while (obj.rs2.next()) {
                marco.paises.addItem(obj.rs2.getString(1));
            }
        } catch (Exception e2) {
            System.out.println("No se pudo establecer la Conexion con la BD");
            e2.printStackTrace();
        }
    }
}
