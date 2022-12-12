package com.java.lambdas;



import java.util.*;
import java.util.stream.Stream;

/**
 * @author danfe
 */

public class Java8_Builtin_Functional_Interfaces {
    public static void main(String[] args) {
        Stream.generate(() -> new Random().nextInt())
                .limit(5)
                .forEach((e) -> System.out.println(e));
        
        
        List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6);
        lista.stream()
                .filter((e) -> e % 2 == 0)
                .map((e) -> e.doubleValue())
                .reduce((e1, e2) -> e1 + e2)
                .ifPresent(System.out::println);
    }
}
