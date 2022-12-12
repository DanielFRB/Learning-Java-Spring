package com.java.sreams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author danfe
 */

public class Java8_Stream_Colect {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1,2,3,4,5,6);
        
        List<Integer> colector = lista.stream()
                .collect(
                    () -> new ArrayList<>(),
                    (l, e) -> l.add(e),
                    (l1, l2) -> l1.addAll(l2));
        System.out.println(lista);
        System.out.println("--------");
        System.out.println(colector);
        System.out.println("--------");
        
        Set<Integer> colector1 = lista.stream()
                .collect(
                    () -> new HashSet<>(),
                    (l, e) -> l.add(e),
                    (l1, l2) -> l1.addAll(l2));
        System.out.println(colector1);
        System.out.println("--------");
        
        Deque<Integer> colector2 = lista.stream()
                .filter((n) -> n % 2 == 0)
                .collect(
                    () -> new ArrayDeque<Integer>(),
                    (l, e) -> l.add(e),
                    (l1, l2) -> l1.addAll(l2));
        System.out.println(colector2);
        System.out.println("--------");
        
        String join = lista.stream()
                .map((n) -> n.toString())
                .collect(Collectors.joining(";"));
        System.out.println(join);
        System.out.println("--------");
        
        Double media = lista.stream()
                .collect(Collectors.averagingInt((n) -> n.intValue()));
        System.out.println(media);
        System.out.println("--------");
        
        Integer suma = lista.stream()
                .collect(Collectors.summingInt((n) -> n.intValue()));
        System.out.println(suma);
        System.out.println("--------");
        
        IntSummaryStatistics stats = lista.stream()
                .collect(Collectors.summarizingInt((n) -> n.intValue()));
        System.out.println("IntSummaryStatistics: ");
        System.out.println(stats.getAverage());
        System.out.println(stats.getCount());
        System.out.println(stats.getMax());
        System.out.println(stats.getMin());
        System.out.println(stats.getSum());
        System.out.println("--------");
        
        Long conteo = lista.stream()
                .collect(Collectors.counting());
        System.out.println(conteo);
        System.out.println("--------");
        
        Map<Integer, List<Integer>> collector3 = lista.stream()
                .collect(Collectors.groupingBy((n) -> n % 3));
        System.out.println(collector3);
        System.out.println("--------");
        
        Map<Boolean, List<Integer>> collector4 = lista.stream()
                .collect(Collectors.partitioningBy((n) -> n % 2 == 0));
        System.out.println(collector4);
        System.out.println("--------");
        
        Map<Integer, Double> toMap = lista.stream()
                .collect(Collectors.toMap((n) -> n, (n) -> Math.pow(n.doubleValue(), 5)));
        System.out.println(toMap);
        System.out.println("--------");
    }
}
