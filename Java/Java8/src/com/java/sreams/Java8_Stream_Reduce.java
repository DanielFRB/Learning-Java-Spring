package com.java.sreams;

import java.util.*;
import java.util.stream.DoubleStream;

/**
 * @author danfe
 */

public class Java8_Stream_Reduce {
    public static void main(String[] args) {
        String s = "Favor cerrar bien la puerta!";
        String[] split = s.split(" ");
        List<String> listaStr = Arrays.asList(split);
        List<Integer> lista = Arrays.asList(1,2,3,4,5,6);
        
        // reduce suma
        Optional<Integer> suma = lista.stream()
                .reduce((n1, n2) -> n1 + n2);
        System.out.println(suma.get());
        System.out.println("--------");
        
        // reduce multiplica
        Optional<Integer> multiplica = lista.stream()
                .reduce((n1, n2) -> n1 * n2);
        System.out.println(multiplica.get());
        System.out.println("--------");
        
        Optional<String> concatena = listaStr.stream()
                .reduce((s1, s2) -> s1.concat(s2));
        System.out.println(concatena.get());
        System.out.println("--------");
        
        OptionalDouble menorValor = DoubleStream.of(1.5, 2.8, 9.8)
                .reduce((d1, d2) -> Math.min(d1, d2));
        System.out.println(menorValor.getAsDouble());
        System.out.println("========");
        
        // reduce sin Optional
        Integer suma2 = lista.stream()
                .reduce(0, (n1, n2) -> n1 + n2);
        System.out.println(suma2);
        System.out.println("--------");
        
        Integer multiplica2 = lista.stream()
                .reduce(1, (n1, n2) -> n1 * n2);
        System.out.println(multiplica2);
        System.out.println("--------");
        
        String concatena2 = listaStr.stream()
                .reduce("", (s1, s2) -> s1.concat(s2));
        System.out.println(concatena2);
        System.out.println("--------");
        
        double menorValor2 = DoubleStream.of(1.5, 2.8, 9.8)
                .reduce(Double.POSITIVE_INFINITY, (d1, d2) -> Math.min(d1, d2));
        System.out.println(menorValor2);
    }
}
