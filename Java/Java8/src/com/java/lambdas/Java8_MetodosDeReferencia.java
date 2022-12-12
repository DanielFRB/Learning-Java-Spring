package com.java.lambdas;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author danfe
 */

public class Java8_MetodosDeReferencia {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
    
        list.stream()
            .forEach(System.out::println); // con method reference
    
        list.stream()
            .forEach((n) -> System.out.println(n)); // sin method reference
    
        // métodos estáticos
        list.stream()
            .map((n) -> multipliquePorDos(n))
            .forEach(System.out::println); 
    
        list.stream()
            .map(Java8_MetodosDeReferencia::multipliquePorDos)
            .forEach(System.out::println);     
    
        // construtores
        list.stream()
            .map((n) -> new BigDecimal(n))
            .forEach(System.out::println);
    
        list.stream()
            .map(BigDecimal::new)
            .forEach(System.out::println);
    
        // várias instâncias
        list.stream()
            .map((n) -> n.doubleValue())
            .forEach(System.out::println);
    
        list.stream()
            .map(Integer::doubleValue)
            .forEach(System.out::println);   
    
        // única instância
        BigDecimal dos = new BigDecimal(2);
        list.stream()
            .map(BigDecimal::new)
            .map((b) -> dos.multiply(b))
            .forEach(System.out::println);
    
        list.stream()
            .map(BigDecimal::new)
            .map(dos::multiply)
            .forEach(System.out::println);    
    
    }
  
    private static Integer multipliquePorDos(Integer i) {
        return i * 2;
    }
}
