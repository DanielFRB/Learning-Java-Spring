package com.graficos;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 * @author danfe
 */

public class ManejoColores {
    public static void main(String[] args) {
        MarcoConColores marco = new MarcoConColores();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoConColores extends JFrame {
    public MarcoConColores() {
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Dimension tamanoPantalla = pantalla.getScreenSize();
        int alturaPantalla = tamanoPantalla.height;
        int anchoPantalla = tamanoPantalla.width;
        setBounds(anchoPantalla/4, alturaPantalla/4, anchoPantalla/2, alturaPantalla/2);
        Image icono = pantalla.getImage("src/com/graficos/favicon.png");
        setIconImage(icono);
        setVisible(true);
        setTitle("Primer Dibujo dentro del Marco");
        LaminaConColores lamina = new LaminaConColores();
        add(lamina);
        lamina.setBackground(SystemColor.window);
    }
}

class LaminaConColores extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
        g2D.setColor(Color.RED);
        g2D.fill(rectangulo);
        Ellipse2D elipse = new Ellipse2D.Double();
        elipse.setFrame(rectangulo);
        Color color = new Color(70,170,180);
        g2D.setColor(color.brighter());
        g2D.fill(elipse);
    }
}
