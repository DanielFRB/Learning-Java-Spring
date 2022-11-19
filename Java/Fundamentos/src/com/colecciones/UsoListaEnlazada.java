package com.colecciones;

import java.util.*;

/**
 * @author danfe
 */

public class UsoListaEnlazada {
    public static void main(String[] args) {
        LinkedList<String> paises = new LinkedList<>();
        paises.add("España");
        paises.add("Venezuela");
        paises.add("Argentina");
        paises.add("Colombia");
        LinkedList<String> capitales = new LinkedList<>();
        capitales.add("Madrid");
        capitales.add("Caracas");
        capitales.add("Buenos Aires");
        capitales.add("Bogotá");
        
        System.out.println(paises);
        System.out.println(capitales);
        
        ListIterator<String> iterA = paises.listIterator();
        ListIterator<String> iterB = capitales.listIterator();
        
        while (iterB.hasNext()) {
            if (iterA.hasNext()) {
                iterA.next();
            }
            iterA.add(iterB.next());
        }
        System.out.println(paises);
        iterB = capitales.listIterator();
        
        while (iterB.hasNext()) {
            iterB.next();
            if (iterB.hasNext()) {
                iterB.next();
                iterB.remove();
            }
        }
        System.out.println(capitales);
        paises.removeAll(capitales);
        System.out.println(paises);
    }
}
