package com.graficos;

import javax.swing.*;

/**
 * @author danfe
 */

public class CreandoMarcos {
    public static void main(String[] args) {
        Marco marco1 = new Marco();
        marco1.setVisible(true);
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Marco extends JFrame {
    public Marco() {
        //setSize(500, 300);
        //setLocation(500, 300);
        setBounds(500, 300, 500, 300);
        setTitle("Bienvenidos");
    }
}