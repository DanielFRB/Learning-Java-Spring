package com.jdbc;

import com.jdbc.views.MarcoAplicacion2;
import javax.swing.*;

/**
 * @author danfe
 */

public class AplicacionMVC {
    public static void main(String[] args) {
        JFrame marcoApp = new MarcoAplicacion2();
        marcoApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoApp.setVisible(true);
    }
}
