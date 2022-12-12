package com.java.optional;

import java.util.Optional;

/**
 * @author danfe
 */

public class Java8_Optional {
    public static void main(String[] args) {
        // String s = "Nuevo String";
        String s = "1";
        convierteEnNumero(s).ifPresent((n) -> System.out.println(n));
    }
    
    public static Optional<Integer> convierteEnNumero(String numStr) {
        try {
            Integer integer = Integer.valueOf(numStr);
            return Optional.of(integer);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
