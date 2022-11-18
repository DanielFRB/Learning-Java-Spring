package com.graficos;

import java.awt.*;
import javax.swing.*;

/**
 * @author danfe
 */

public class CreandoMarcos2 {
    public static void main(String[] args) {
        MarcoCentrado marco = new MarcoCentrado();
        marco.setVisible(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoCentrado extends JFrame {
    public MarcoCentrado() {
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Dimension tamanoPantalla = pantalla.getScreenSize();
        int alturaPantalla = tamanoPantalla.height;
        int anchoPantalla = tamanoPantalla.width;
        setSize(anchoPantalla/2, alturaPantalla/2);
        setLocation(anchoPantalla/4, alturaPantalla/4);
        setTitle("Ventana Centrada");
        Image icono = pantalla.getImage("src/com/graficos/favicon.png");
        setIconImage(icono);
    }
}
