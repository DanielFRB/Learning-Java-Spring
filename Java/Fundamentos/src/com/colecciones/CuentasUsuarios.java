package com.colecciones;

import java.util.*;

/**
 * @author danfe
 */

public class CuentasUsuarios {
    public static void main(String[] args) {
        Cliente clt1 = new Cliente("Daniel Rondon", "987654", 2000);
        Cliente clt2 = new Cliente("Oswaldo Lopez", "321654", 4000);
        Cliente clt3 = new Cliente("Yaneth Machado", "951357", 5000);
        Cliente clt4 = new Cliente("Barack Obama", "951951", 15000);
        Cliente clt5 = new Cliente("Daniel Rondon", "987654", 2000);
        Cliente clt6 = new Cliente("Daniel Rondon", "987654", 2000);
        
        Set<Cliente> listaClientes = new HashSet<>();
        listaClientes.add(clt1);
        listaClientes.add(clt2);
        listaClientes.add(clt3);
        listaClientes.add(clt4);
        listaClientes.add(clt5);
        listaClientes.add(clt6);
        
        for (Cliente c : listaClientes) {
            System.out.println(c.getNombre() +" "+ c.getCuenta() +" "+ c.getSaldo());
        }
        
        Iterator<Cliente> it1 = listaClientes.iterator();
        while (it1.hasNext()) {
            String nombreCliente = it1.next().getNombre();
            if (nombreCliente.equals("Daniel Rondon")) {
                it1.remove();
            }
        }
        
        Iterator<Cliente> it2 = listaClientes.iterator();
        while (it2.hasNext()) {
            String nombreCliente = it2.next().getNombre();
            System.out.println(nombreCliente);
        }
    }
}
