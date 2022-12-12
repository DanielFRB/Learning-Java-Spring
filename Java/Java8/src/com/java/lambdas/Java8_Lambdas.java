package com.java.lambdas;

import java.util.stream.*;

/**
 * @author danfe
 */

public class Java8_Lambdas {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Hola Mundo!");
    
        // Sin llaves
        IntStream.range(0, 5)
            .filter((int n) -> n % 2 == 0)
            .reduce((n1, n2) -> n1 + n2)
            .ifPresent(System.out::println);
      
        // Con llaves
        IntStream.range(0, 5)
            .filter((int n) -> {
                System.out.println("Se inscreva no canal!");
                return n % 2 == 0;
            })
            .forEach(System.out::println);
    }
}
