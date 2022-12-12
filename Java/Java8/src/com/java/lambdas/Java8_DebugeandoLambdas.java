package com.java.lambdas;

import java.util.*;

/**
 * @author danfe
 */

public class Java8_DebugeandoLambdas {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1, 2, 5, 8, 9);
    
        lista.stream()
            .peek(n -> System.out.println(n + "Esto es una Prueba"))
            .filter(n -> n % 2 == 0)
            .peek(n -> System.out.println(n + "Prueba"))
            .forEach(System.out::println);
    
    }

}
