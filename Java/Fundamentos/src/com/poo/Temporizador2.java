package com.poo;

import java.awt.event.*;
import java.util.Date;
import javax.swing.*;
import java.awt.Toolkit;

/**
 * @author danfe
 */

public class Temporizador2 {
    public static void main(String[] args) {
        Reloj reloj = new Reloj(3000, true);
        reloj.arrancar();
        JOptionPane.showMessageDialog(null, "Pulce Aceptar para detener");
        System.exit(0);
    }
}

class Reloj {
    private int intervalo;
    private boolean sonido;
    
    public Reloj(int intervalo, boolean sonido) {
        this.intervalo = intervalo;
        this.sonido = sonido;
    }
    
    public void arrancar() {
        ActionListener evento = new DameLaHora2();
        Timer miTempo = new Timer(intervalo, evento);
        miTempo.start();
    }
    
    private class DameLaHora2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Date ahora = new Date();
            System.out.println("La hora cada 3 segundos: "+ ahora);
            if (sonido) {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
