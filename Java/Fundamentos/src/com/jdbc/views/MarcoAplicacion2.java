package com.views;

import com.controllers.*;
import java.awt.*;
import javax.swing.*;

/**
 * @author danfe
 */

public class MarcoAplicacion2 extends JFrame {
    public JComboBox secciones;
    public JComboBox paises;
    public JTextArea resultado;
    
    public MarcoAplicacion2() {
        setTitle("Consulta BBDD");
        setBounds(500, 300, 700, 450);
        setLayout(new BorderLayout());
        JPanel menus = new JPanel();
        menus.setLayout(new FlowLayout());
        secciones = new JComboBox();
        secciones.setEditable(false);
        secciones.addItem("Todos");
        paises = new JComboBox();
        paises.setEditable(false);
        paises.addItem("Todos");
        resultado = new JTextArea(4, 50);
        resultado.setEditable(false);
        add(resultado);
        menus.add(secciones);
        menus.add(paises);
        add(menus, BorderLayout.NORTH);
        add(resultado, BorderLayout.CENTER);
        JButton btnConsulta = new JButton("Consultar");
        add(btnConsulta, BorderLayout.SOUTH);
        btnConsulta.addActionListener(new ControlBotonConsultar(this));
        addWindowListener(new ControlCargaComboBox(this));
    }
}
