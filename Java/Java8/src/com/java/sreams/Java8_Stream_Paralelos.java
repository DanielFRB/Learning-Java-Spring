package com.java.sreams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author danfe
 */

public class Java8_Stream_Paralelos {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1, 2, 3, 4);
        
        // forEach vs forEachOrdered
        lista.parallelStream()
                .forEach(System.out::println);
        lista.parallelStream()
                .forEachOrdered(System.out::println);
        
        // findAny
        lista.parallelStream()
                .findAny()
                .ifPresent(System.out::println);
        lista.stream()
                .findAny()
                .ifPresent(System.out::println);
        
        lista.parallelStream()
                .reduce((n1, n2) -> n1 - n2)
                .ifPresent(System.out::println);
        
        Map<Integer, Boolean> colector = lista.parallelStream()
                                                .collect(Collectors.toMap((n) -> n, (n) -> n % 2 == 0));
        System.out.println(colector);
        
        Map<Integer, Boolean> colector1 = lista.parallelStream()
                                                .collect(Collectors.toConcurrentMap((n) -> n, (n) -> n % 2 == 0));
        System.out.println(colector1);
        
        Map<Boolean, List<Integer>> colector2 = lista.parallelStream()
                                                .collect(Collectors.groupingBy((n) -> n % 2 == 0));
        System.out.println(colector2);
        
        Map<Boolean, List<Integer>> colector3 = lista.parallelStream()
                                                .collect(Collectors.groupingByConcurrent((n) -> n % 2 == 0));
        System.out.println(colector3);
    }
}
