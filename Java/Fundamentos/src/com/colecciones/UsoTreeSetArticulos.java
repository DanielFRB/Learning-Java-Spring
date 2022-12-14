package com.colecciones;

import java.util.*;

/**
 * @author danfe
 */

public class UsoTreeSetArticulos {
    public static void main(String[] args) {
        // Utiliza el metodo compareTo interno debido a que la clase String implementa Compable
        TreeSet<String> personas = new TreeSet<>();
        personas.add("Daniel");
        personas.add("Yaneth");
        personas.add("Oswaldo");
        personas.add("Barack");
        personas.add("Adelina");
        
        for (String p : personas) {
            System.out.println(p);
        }
        System.out.println("--------");
        
        Articulo primero = new Articulo(1, "Primer Articulo");
        Articulo segundo = new Articulo(20, "Segundo Articulo");
        Articulo tercero = new Articulo(3, "Tercer Articulo");
        
        TreeSet<Articulo> listaArticulos = new TreeSet<>();
        listaArticulos.add(primero);
        listaArticulos.add(segundo);
        listaArticulos.add(tercero);
        
        for (Articulo a : listaArticulos) {
            System.out.println(a.getDescripcion());
        }
        System.out.println("--------");
        
        // Usando clases anonimas internas
        TreeSet<Articulo> listaArticulos2 = new TreeSet<>(new Comparator<Articulo>() {
            @Override
            public int compare(Articulo a1, Articulo a2) {
                return a1.getDescripcion().compareTo(a2.getDescripcion());
            }
        });
        listaArticulos2.add(primero);
        listaArticulos2.add(segundo);
        listaArticulos2.add(tercero);
        
        for (Articulo a : listaArticulos2) {
            System.out.println(a.getDescripcion());
        }
        System.out.println("--------");
        
        // Usando expresiones lambdas
        TreeSet<Articulo> listaArticulos3 = new TreeSet<>((a1, a2) -> a1.getDescripcion().compareTo(a2.getDescripcion()));
        listaArticulos3.add(primero);
        listaArticulos3.add(segundo);
        listaArticulos3.add(tercero);
        
        for (Articulo a : listaArticulos3) {
            System.out.println(a.getDescripcion());
        }
    }
}
