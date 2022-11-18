package com.graficos;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * @author danfe
 */

public class ProcesadorTexto {
    public static void main(String[] args) {
        MenuProcesador miMarco = new MenuProcesador();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MenuProcesador extends JFrame {
    public MenuProcesador() {
        setBounds(500, 300, 550, 400);
        LaminaProcesador miLamina = new LaminaProcesador();
        add(miLamina);
        setTitle("Procesador de Texto");
        setVisible(true);
    }
}

class LaminaProcesador extends JPanel {
    JTextPane miPanel;
    JMenu menuFuente, menuEstilo, menuSize;
    Font letras;
    
    public LaminaProcesador() {
        setLayout(new BorderLayout());
        JPanel laminaMenu = new JPanel();
        JMenuBar miMenu = new JMenuBar();
        //-----------------------------------------
        menuFuente = new JMenu("Fuente");
        menuEstilo = new JMenu("Estilo");
        menuSize = new JMenu("Tamaño");
        //-----------------------------------------
        miMenu.add(menuFuente);
        miMenu.add(menuEstilo);
        miMenu.add(menuSize);
        //-----------------------------------------
        configuraMenu("Arial", "fuente", "Arial", 9, 10);
        configuraMenu("Times New Roman", "fuente", "Times New Roman", 9, 10);
        configuraMenu("Verdana", "fuente", "Verdana", 9, 10);
        //-----------------------------------------
        configuraMenu("Negrita", "estilo", "", Font.BOLD, 1);
        configuraMenu("Cursiva", "estilo", "", Font.ITALIC, 1);
        //-----------------------------------------
        configuraMenu("12", "size", "", 9, 12);
        configuraMenu("16", "size", "", 9, 16);
        configuraMenu("20", "size", "", 9, 20);
        configuraMenu("24", "size", "", 9, 24);
        //-----------------------------------------
        laminaMenu.add(miMenu);
        add(laminaMenu, BorderLayout.NORTH);
        miPanel = new JTextPane();
        add(miPanel, BorderLayout.CENTER);
    }
    
    public final void configuraMenu(String rotulo, String menu, String tipoLetra, int estilos, int size) {
        JMenuItem itemMenu = new JMenuItem(rotulo);
        if ("fuente".equals(menu)) {
            menuFuente.add(itemMenu);
        } else if ("estilo".equals(menu)) {
            menuEstilo.add(itemMenu);
        } else if ("size".equals(menu)) {
            menuSize.add(itemMenu);
        }
        itemMenu.addActionListener(new GestionaEventos(rotulo, tipoLetra, estilos, size));
    }
    
    private class GestionaEventos implements ActionListener {
        String tipoTexto, menu;
        int estiloLetra, sizeLetra;

        public GestionaEventos(String menu, String tipoTexto, int estiloLetra, int sizeLetra) {
            this.tipoTexto = tipoTexto;
            this.menu = menu;
            this.estiloLetra = estiloLetra;
            this.sizeLetra = sizeLetra;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            letras = miPanel.getFont();
            if ("Arial".equals(menu) || "Times New Roman".equals(menu) || "Verdana".equals(menu)) {
                estiloLetra = letras.getStyle();
                sizeLetra = letras.getSize();
            } else if ("Negrita".equals(menu) || "Cursiva".equals(menu)) {
                if (letras.getStyle() == 1 || letras.getStyle() == 2) {
                    estiloLetra = 3;
                }
                tipoTexto = letras.getFontName();
                sizeLetra = letras.getSize();
            } else if ("12".equals(menu) || "16".equals(menu) || "20".equals(menu) || "24".equals(menu)) {
                estiloLetra = letras.getStyle();
                tipoTexto = letras.getFontName();
            }
            miPanel.setFont(new Font(tipoTexto, estiloLetra, sizeLetra));
            System.out.println("Tipo: "+ tipoTexto +" Estilo: "+ estiloLetra +" Tamaño: "+ sizeLetra);
        }
    }
}
