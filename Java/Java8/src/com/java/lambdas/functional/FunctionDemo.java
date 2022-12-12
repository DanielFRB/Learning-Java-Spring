package com.java.lambdas.functional;

import java.util.function.Function;

/**
 * @author danfe
 */

// Implementacion tradicional sin expresiones Lambdas
class FuntionImpl implements Function<String, Integer> {
    @Override
    public Integer apply(String s) {
        return s.length();
    }
}

public class FunctionDemo {
    public static void main(String[] args) {
        Function<String, Integer> function = new FuntionImpl();
        System.out.println(function.apply("Daniel"));
        
        System.out.println("-----");
        
        Function<String, Integer> function2 = (String s) -> s.length();
        System.out.println(function2.apply("Daniel"));
    }
}
