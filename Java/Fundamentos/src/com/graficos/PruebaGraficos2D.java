package com.graficos;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 * @author danfe
 */

public class PruebaGraficos2D {
    public static void main(String[] args) {
        MarcoConDibujos2D marco = new MarcoConDibujos2D();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoConDibujos2D extends JFrame {
    public MarcoConDibujos2D() {
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Dimension tamanoPantalla = pantalla.getScreenSize();
        int alturaPantalla = tamanoPantalla.height;
        int anchoPantalla = tamanoPantalla.width;
        setBounds(anchoPantalla/4, alturaPantalla/4, anchoPantalla/2, alturaPantalla/2);
        Image icono = pantalla.getImage("src/com/graficos/favicon.png");
        setIconImage(icono);
        setVisible(true);
        setTitle("Dibujando Graficos 2D");
        LaminaConDibujo2D lamina = new LaminaConDibujo2D();
        add(lamina);
    }
}

class LaminaConDibujo2D extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
        g2D.draw(rectangulo);
        Ellipse2D elipse = new Ellipse2D.Double();
        elipse.setFrame(rectangulo);
        g2D.draw(elipse);
        g2D.draw(new Line2D.Double(100, 100, 300, 250));
        double centroX = rectangulo.getCenterX();
        double centroY = rectangulo.getCenterY();
        double radio = 125;
        Ellipse2D circulo = new Ellipse2D.Double();
        circulo.setFrameFromCenter(centroX, centroY, centroX+radio, centroY+radio);
        g2D.draw(circulo);
    }
}
