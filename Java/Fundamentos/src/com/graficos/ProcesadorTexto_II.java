package com.graficos;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.*;
import javax.swing.text.StyledEditorKit;

/**
 * @author danfe
 */

public class ProcesadorTexto_II {
    public static void main(String[] args) {
        MenuProcesador_II miMarco = new MenuProcesador_II();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MenuProcesador_II extends JFrame {
    public MenuProcesador_II() {
        setBounds(500, 300, 550, 400);
        LaminaProcesador_II miLamina = new LaminaProcesador_II();
        add(miLamina);
        setTitle("Procesador de Texto II");
        setVisible(true);
    }
}

class LaminaProcesador_II extends JPanel {
    JTextPane miPanel;
    JMenu menuFuente, menuEstilo, menuSize;
    Font letras;
    
    public LaminaProcesador_II() {
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
        configuraMenu_II("Arial", "fuente", "Arial", 9, 10);
        configuraMenu_II("Times New Roman", "fuente", "Times New Roman", 9, 10);
        configuraMenu_II("Verdana", "fuente", "Verdana", 9, 10);
        //-----------------------------------------
        configuraMenu_II("Negrita", "estilo", "", Font.BOLD, 1);
        configuraMenu_II("Cursiva", "estilo", "", Font.ITALIC, 1);
        //-----------------------------------------
        configuraMenu_II("12", "size", "", 9, 12);
        configuraMenu_II("16", "size", "", 9, 16);
        configuraMenu_II("20", "size", "", 9, 20);
        configuraMenu_II("24", "size", "", 9, 24);
        //-----------------------------------------
        laminaMenu.add(miMenu);
        add(laminaMenu, BorderLayout.NORTH);
        miPanel = new JTextPane();
        add(miPanel, BorderLayout.CENTER);
    }
    
    public final void configuraMenu_II(String rotulo, String menu, String tipoLetra, int estilos, int size) {
        JMenuItem itemMenu = new JMenuItem(rotulo);
        if ("fuente".equals(menu)) {
            menuFuente.add(itemMenu);
            if (tipoLetra == "Arial") {
                itemMenu.addActionListener(new StyledEditorKit.FontFamilyAction(menu, "Arial"));
            } else if (tipoLetra == "Times New Roman") {
                itemMenu.addActionListener(new StyledEditorKit.FontFamilyAction(menu, "Times New Roman"));
            } else if (tipoLetra == "Verdana") {
                itemMenu.addActionListener(new StyledEditorKit.FontFamilyAction(menu, "Verdana"));
            }
        } else if ("estilo".equals(menu)) {
            menuEstilo.add(itemMenu);
            if (estilos == Font.BOLD) {
                itemMenu.addActionListener(new StyledEditorKit.BoldAction());
            } else if (estilos == Font.ITALIC) {
                itemMenu.addActionListener(new StyledEditorKit.ItalicAction());
            }
        } else if ("size".equals(menu)) {
            menuSize.add(itemMenu);
            itemMenu.addActionListener(new StyledEditorKit.FontSizeAction(menu, size));
        }
    }
}
