package com.practicas;

import javax.swing.*;

/**
 * @author danfe
 */

public class LaminaBotones extends JPanel {
    private ButtonGroup grupoBtn;
    
    public LaminaBotones(String titulo, String[] opciones) {
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        grupoBtn = new ButtonGroup();
        for (int i = 0; i < opciones.length; i++) {
            JRadioButton radBtn = new JRadioButton(opciones[i]);
            radBtn.setActionCommand(opciones[i]);
            add(radBtn);
            grupoBtn.add(radBtn);
            radBtn.setSelected(i == 0);
        }
    }
    
    public String getSeleccion() {
        return grupoBtn.getSelection().getActionCommand();
    }
}
