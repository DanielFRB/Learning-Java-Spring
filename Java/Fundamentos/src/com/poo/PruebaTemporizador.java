package com.poo;

import java.awt.event.*;
import java.util.Date;
import javax.swing.*;


/**
 * @author danfe
 */

public class PruebaTemporizador {
    public static void main(String[] args) {
        DameLaHora accion = new DameLaHora();
        Timer temporizador = new Timer(3000, accion);
        temporizador.start();
        JOptionPane.showMessageDialog(null, "Pulce Aceptar para detener");
        System.exit(0);
    }
}

class DameLaHora implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Date ahora = new Date();
        System.out.println("La hora cada 3 segundos: "+ ahora);
    }
}
