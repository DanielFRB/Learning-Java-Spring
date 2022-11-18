package com.graficos;

import java.awt.*;
import javax.swing.*;

/**
 * @author danfe
 */

public class EscribiendoMarco {
    public static void main(String[] args) {
        MarcoConTexto marco = new MarcoConTexto();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoConTexto extends JFrame {
    public MarcoConTexto() {
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Dimension tamanoPantalla = pantalla.getScreenSize();
        int alturaPantalla = tamanoPantalla.height;
        int anchoPantalla = tamanoPantalla.width;
        setBounds(anchoPantalla/4, alturaPantalla/4, anchoPantalla/2, alturaPantalla/2);
        Image icono = pantalla.getImage("src/com/graficos/favicon.png");
        setIconImage(icono);
        setVisible(true);
        setTitle("Primer Texto en Marco");
        Lamina lamina = new Lamina();
        add(lamina);
    }
}

class Lamina extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Hola Mundo", 100, 50);
    }
}
