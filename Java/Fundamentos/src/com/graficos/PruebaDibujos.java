package com.graficos;

import java.awt.*;
import javax.swing.*;

/**
 * @author danfe
 */

public class PruebaDibujos {
    public static void main(String[] args) {
        MarcoConDibujos marco = new MarcoConDibujos();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoConDibujos extends JFrame {
    public MarcoConDibujos() {
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Dimension tamanoPantalla = pantalla.getScreenSize();
        int alturaPantalla = tamanoPantalla.height;
        int anchoPantalla = tamanoPantalla.width;
        setBounds(anchoPantalla/4, alturaPantalla/4, anchoPantalla/2, alturaPantalla/2);
        Image icono = pantalla.getImage("src/com/graficos/favicon.png");
        setIconImage(icono);
        setVisible(true);
        setTitle("Primer Dibujo dentro del Marco");
        LaminaDibujo lamina = new LaminaDibujo();
        add(lamina);
    }
}

class LaminaDibujo extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Hola Mundo", 130, 50);
        g.drawRect(90, 30, 200, 100);
        g.drawLine(90, 30, 290, 130);
        g.drawArc(50, 100, 100, 200, 120, 150);
    }
}
