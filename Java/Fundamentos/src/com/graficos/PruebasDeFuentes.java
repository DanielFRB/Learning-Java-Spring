package com.graficos;

import java.awt.GraphicsEnvironment;
import javax.swing.JOptionPane;

/**
 * @author danfe
 */

public class PruebasDeFuentes {
    public static void main(String[] args) {
        String fuente = JOptionPane.showInputDialog("Introduzca la Fuente");
        boolean fuenteInstalada = false;
        String[] fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String f : fuentes) {
            if (f.equalsIgnoreCase(fuente)) {
                fuenteInstalada = true;
            }
        }
        
        if (fuenteInstalada) {
            System.out.println("Fuente Instalada: "+ fuente);
        } else {
            System.out.println("Fuente NO Instalada: "+ fuente);
        }
    }
}
