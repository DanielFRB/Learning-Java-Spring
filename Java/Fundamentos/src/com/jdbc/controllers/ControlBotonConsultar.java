package com.jdbc.controllers;

import com.jdbc.models.*;
import com.jdbc.views.*;
import java.awt.event.*;
import java.sql.*;

/**
 * @author danfe
 */

public class ControlBotonConsultar implements ActionListener {
    EjecutaConsultas obj = new EjecutaConsultas();
    private MarcoAplicacion2 marco;
    private ResultSet resultadoConsulta;
    
    public ControlBotonConsultar(MarcoAplicacion2 marco) {
        this.marco = marco;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String selectSeccion = marco.secciones.getSelectedItem().toString();
        String selectPais = marco.paises.getSelectedItem().toString();
        resultadoConsulta = obj.filtraBBDD(selectSeccion, selectPais);
        try {
            marco.resultado.setText("");
            while(resultadoConsulta.next()) {
                marco.resultado.append(resultadoConsulta.getString(1));
                marco.resultado.append(", ");
                marco.resultado.append(resultadoConsulta.getString(2));
                marco.resultado.append(", ");
                marco.resultado.append(resultadoConsulta.getString(3));
                marco.resultado.append(", ");
                marco.resultado.append(resultadoConsulta.getString(4));
                marco.resultado.append(", ");
                marco.resultado.append(resultadoConsulta.getString(5));
                marco.resultado.append(", ");
                marco.resultado.append(resultadoConsulta.getString(6));
                marco.resultado.append(", ");
                marco.resultado.append(resultadoConsulta.getString(7));
                marco.resultado.append("\n");
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
