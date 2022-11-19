package com.practicas;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.Date;
import javax.swing.*;

/**
 * @author danfe
 */

public class MarcoDialogos extends JFrame {
    private LaminaBotones laminaTipo, laminaTipoMensaje, laminaMensaje, laminaConfirmar, laminaOpcion, laminaEntrada;
    private String cadenaMensaje = "Mensaje Enviado";
    private Icon iconoMensaje = new ImageIcon("src/bolaAzul.gif");
    private Object objetoMensaje = new Date();
    private Component compMensaje = new LaminaMensaje();
    
    public MarcoDialogos() {
        setTitle("Prueba de Dialogos");
        setBounds(500, 200, 600, 450);
        JPanel laminaCuadricula = new JPanel();
        laminaCuadricula.setLayout(new GridLayout(2,3));
        laminaTipo = new LaminaBotones("Tipo", new String[] {
            "Mensaje", "Confirmar", "Opción", "Entrada"
        });
        laminaTipoMensaje = new LaminaBotones("Tipo de Mensaje", new String[] {
            "ERROR_MESSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE", 
            "QUESTION_MESSAGE", "PLAIN_MESSAGE"
        });
        laminaMensaje = new LaminaBotones("Mensaje", new String[] {
            "Cadena", "Icono", "Componente", "Otros", "Object[]"
        });
        laminaConfirmar = new LaminaBotones("Confirmar", new String[] {
            "DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION"
        });
        laminaOpcion = new LaminaBotones("Opción", new String[] {
            "String[]", "Icon[]", "Object[]"
        });
        laminaEntrada = new LaminaBotones("Entrada", new String[] {
            "Campo de Texto", "Combo"
        });
        
        setLayout(new BorderLayout());
        
        laminaCuadricula.add(laminaTipo);
        laminaCuadricula.add(laminaTipoMensaje);
        laminaCuadricula.add(laminaMensaje);
        laminaCuadricula.add(laminaConfirmar);
        laminaCuadricula.add(laminaOpcion);
        laminaCuadricula.add(laminaEntrada);
        
        JPanel laminaBtn = new JPanel();
        JButton btnShow = new JButton("Mostrar");
        btnShow.addActionListener(new AccionMostrar());
        laminaBtn.add(btnShow);
        
        add(laminaCuadricula, BorderLayout.CENTER);
        add(laminaBtn, BorderLayout.SOUTH);
    }
    
    private class AccionMostrar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (laminaTipo.getSeleccion().equals("Mensaje")) {
                JOptionPane.showMessageDialog(MarcoDialogos.this, getMensaje(), "Titulo", getIconoAndShowConfirmar(laminaTipoMensaje));
            } else if (laminaTipo.getSeleccion().equals("Confirmar")) {
                JOptionPane.showConfirmDialog(MarcoDialogos.this, getMensaje(), "Titulo", getIconoAndShowConfirmar(laminaConfirmar), getIconoAndShowConfirmar(laminaTipoMensaje));
            } else if (laminaTipo.getSeleccion().equals("Opción")) {
                JOptionPane.showOptionDialog(MarcoDialogos.this, getMensaje(), "Titulo", 1, getIconoAndShowConfirmar(laminaTipoMensaje), null, getOpcion(laminaOpcion), null);
            } else if (laminaTipo.getSeleccion().equals("Entrada")) {
                if (laminaEntrada.getSeleccion().equals("Campo de Texto")) {
                    JOptionPane.showInputDialog(MarcoDialogos.this, getMensaje(), "Titulo", getIconoAndShowConfirmar(laminaTipoMensaje));
                } else {
                    JOptionPane.showInputDialog(MarcoDialogos.this, getMensaje(), "Titulo", getIconoAndShowConfirmar(laminaTipoMensaje), null, new String[] {"Amarillo", "Azul", "Rojo"}, "Amarillo");
                }
                
            }
        }
    }
    
    public Object getMensaje() {
        String s = laminaMensaje.getSeleccion();
        if (s.equals("Cadena")) {
            return cadenaMensaje;
        } else if (s.equals("Icono")) {
            return iconoMensaje;
        } else if (s.equals("Componente")) {
            return compMensaje;
        } else if (s.equals("Otros")) {
            return objetoMensaje;
        } else if (s.equals("Object[]")) {
            return new Object[] {cadenaMensaje, iconoMensaje, compMensaje, objetoMensaje};
        } else {
            return null;
        }
    }
    
    public int getIconoAndShowConfirmar(LaminaBotones lamina) {
        String s = lamina.getSeleccion();
        if (s.equals("ERROR_MESSAGE") || s.equals("YES_NO_OPTION")) {
            return 0;
        } else if (s.equals("INFORMATION_MESSAGE") || s.equals("YES_NO_CANCEL_OPTION")) {
            return 1;
        } else if (s.equals("WARNING_MESSAGE") || s.equals("OK_CANCEL_OPTION")) {
            return 2;
        } else if (s.equals("QUESTION_MESSAGE")) {
            return 3;
        } else if (s.equals("PLAIN_MESSAGE") || s.equals("DEFAULT_OPTION")) {
            return -1;
        } else {
            return 0;
        }
    }
    
    public Object[] getOpcion(LaminaBotones lamina) {
        String s = lamina.getSeleccion();
        if (s.equals("String[]")) {
            return new String[] {"Amarillo", "Azul", "Rojo"};
        } else if (s.equals("Icon[]")) {
            return new Object[] {new ImageIcon("src/bolaAmarilla.gif"), new ImageIcon("src/bolaAzul.gif"), new ImageIcon("src/bolaRoja.gif")};
        } else if (s.equals("Object[]")) {
            return new Object[] {cadenaMensaje, iconoMensaje, compMensaje, objetoMensaje};
        } else {
            return null;
        }
    }
}

class LaminaMensaje extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2D = (Graphics2D) g;
        Rectangle2D rectangulo = new Rectangle2D.Double(0, 0, getWidth(), getHeight());
        g2D.setColor(Color.YELLOW);
        g2D.fill(rectangulo);
    }
}
