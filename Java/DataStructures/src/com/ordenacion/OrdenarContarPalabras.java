package com.ordenacion;

import java.util.*;

/**
 * @author danfe
 */

public class OrdenarContarPalabras {
    public static void main (String [] args) {
        List<String> lista = Arrays.asList("Maria", "Juan", "Maria", "Carlos", "Ana", "Maria", "Jose", "Juan", "Ana", "Daniel");
        List<Integer> lista2 = new ArrayList<>();
        lista.sort((n1, n2) -> n1.compareTo(n2));
        int contador = 0;
        String aux = lista.get(0);
        for (int i = 0; i < lista.size(); i++) {
            if (aux.equals(lista.get(i))) {
                contador++;
            } else {
                lista2.add(contador);
                contador = 1;
                aux = lista.get(i);
            }
        }
        lista2.add(contador);
        System.out.print(lista2);
        System.out.print(" ");
        System.out.print(lista);
        System.out.println();
        
        // Implementando Map
        Map<String, Integer> map = new HashMap<>();
        for (String s : lista) {
            map.merge(s, 1, Integer::sum);
        }
        List<String> list2 = new ArrayList<>(map.keySet());
        List<Integer> list3 = new ArrayList<>(map.values());
        System.out.print(list3);
        System.out.print(" ");
        System.out.print(list2);
    }
}
