package com.java.lambdas;

import java.util.*;

/**
 * @author danfe
 */

public class Java8_Collections_Nuevos_Metodos {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
    
        // forEach
        lista.forEach(n -> System.out.println(n));
    
        // removeIf
        lista.removeIf(n -> n % 2 == 0);
        lista.forEach(n -> System.out.println(n));
    
        // replaceAll
        lista.replaceAll(n -> n * 2);
        lista.forEach(n -> System.out.println(n));
    
        // Map
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "Esto");
        map.put(1, "es");
        map.put(2, "una");
        map.put(3, "prueba");
    
        // forEach
        map.forEach((k, v) -> System.out.println(k + v));
    
        // compute
        map.compute(1, (k, v) -> v + " ahora");
        map.forEach((k, v) -> System.out.println(k + v));
    
        // merge
        map.merge(4, "!", (v1, v2) -> v1 + v2);
        map.forEach((k, v) -> System.out.println(k + v));
    
        // replaceAll
        map.replaceAll((k, v) -> v + "!");
        map.forEach((k, v) -> System.out.println(k + v));
    }

}
