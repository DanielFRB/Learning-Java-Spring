package com.sockets;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;

/**
 * @author danfe
 */

public class Cliente {
    public static void main(String[] args) {
        MarcoCliente cliente = new MarcoCliente();
        cliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoCliente extends JFrame {
    public MarcoCliente() {
        setBounds(300, 200, 240, 350);
        LaminaMarcoCliente lmc = new LaminaMarcoCliente();
        add(lmc);
        setVisible(true);
        addWindowListener(new EnvioOnline());
    }
}

class EnvioOnline extends WindowAdapter {
    @Override
    public void windowOpened(WindowEvent we) {
        try {
            Socket toServer = new Socket("192.168.0.200", 9090);
            PaqueteDeEnvio pdeIp = new PaqueteDeEnvio();
            pdeIp.setMensaje("Online");
            ObjectOutputStream packToServer = new ObjectOutputStream(toServer.getOutputStream());
            packToServer.writeObject(pdeIp);
            toServer.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}

class LaminaMarcoCliente extends JPanel implements Runnable {
    private JTextArea campoChat;
    private JTextField campoTexto;
    private JLabel nick;
    private JComboBox ip;
    private JButton btn;
    
    public LaminaMarcoCliente() {
        String usuario = JOptionPane.showInputDialog("Ingrese su Nick: ");
        JLabel nNick = new JLabel("Nick: ");
        add(nNick);
        nick = new JLabel();
        nick.setText(usuario);
        add(nick);
        JLabel tex = new JLabel("Online: ");
        add(tex);
        ip = new JComboBox();
        add(ip);
        campoChat = new JTextArea(10,20);
        add(campoChat);
        campoTexto = new JTextField(20);
        add(campoTexto);
        btn = new JButton("Enviar");
        EnviaTexto event = new EnviaTexto();
        btn.addActionListener(event);
        add(btn);
        Thread serverClientAlwaysListen = new Thread(this);
        serverClientAlwaysListen.start();
    }
    
    private class EnviaTexto implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            campoChat.append(campoTexto.getText()+ "\n");
            try {
                Socket toServer = new Socket("192.168.0.200", 9090);
                PaqueteDeEnvio pde = new PaqueteDeEnvio();
                pde.setNick(nick.getText());
                pde.setIp(ip.getSelectedItem().toString());
                pde.setMensaje(campoTexto.getText());
                ObjectOutputStream packToServer = new ObjectOutputStream(toServer.getOutputStream());
                packToServer.writeObject(pde);
                packToServer.close();
                toServer.close();
            } catch (UnknownHostException uhe) {
                uhe.printStackTrace();
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }
    }
    
    @Override
    public void run() {
        try {
            ServerSocket clientServer = new ServerSocket(9999);
            Socket cliente;
            PaqueteDeEnvio pqtRecivido;
            while (true) {
                cliente = clientServer.accept();
                ObjectInputStream streamFromClient = new ObjectInputStream(cliente.getInputStream());
                pqtRecivido = (PaqueteDeEnvio) streamFromClient.readObject();
                if (!pqtRecivido.getMensaje().equals("Online")) {
                    campoChat.append(pqtRecivido.getNick() +": "+ pqtRecivido.getMensaje() +"\n");
                } else {
                    ArrayList<String> menuIPs = new ArrayList<>();
                    menuIPs = pqtRecivido.getListaIPs();
                    ip.removeAllItems();
                    for (String s : menuIPs) {
                        ip.addItem(s);
                    }
                }
            }
        } catch (IOException ioe) {
            ioe.getMessage();
        } catch (ClassNotFoundException cnfe) {
           cnfe.getMessage();
        }
    }
}

class PaqueteDeEnvio implements Serializable {
    private String mensaje, nick, ip;
    private ArrayList<String> listaIPs;
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public ArrayList<String> getListaIPs() {
        return listaIPs;
    }

    public void setListaIPs(ArrayList<String> listaIPs) {
        this.listaIPs = listaIPs;
    }
}
