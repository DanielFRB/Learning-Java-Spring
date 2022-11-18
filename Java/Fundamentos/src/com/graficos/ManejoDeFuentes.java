package com.graficos;

import java.awt.*;
import javax.swing.*;

/**
 * @author danfe
 */

public class ManejoDeFuentes {
    public static void main(String[] args) {
        MarcoConLetras marco = new MarcoConLetras();
    }
}

class MarcoConLetras extends JFrame {
    public MarcoConLetras() {
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Dimension tamanoPantalla = pantalla.getScreenSize();
        int alturaPantalla = tamanoPantalla.height;
        int anchoPantalla = tamanoPantalla.width;
        setBounds(anchoPantalla/4, alturaPantalla/4, anchoPantalla/2, alturaPantalla/2);
        Image icono = pantalla.getImage("src/com/graficos/favicon.png");
        setIconImage(icono);
        setVisible(true);
        setTitle("Manejo de Fuentes de Letras");
        LaminaConLetras lamina = new LaminaConLetras();
        add(lamina);
        lamina.setBackground(SystemColor.window);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class LaminaConLetras extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        Font arial = new Font("Arial", Font.BOLD, 24);
        Color color = new Color(0, 35, 245);
        g2D.setFont(arial);
        g2D.setColor(color);
        g2D.drawString("Daniel Rondon", 100, 50);
    }
}
