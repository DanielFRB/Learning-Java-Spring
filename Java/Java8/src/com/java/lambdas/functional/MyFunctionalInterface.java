package com.java.lambdas.functional;

/**
 * @author danfe
 */

@FunctionalInterface
public interface MyFunctionalInterface {
    void print(String m);
    
    default void m1() {
        System.out.println("Default metodo");
    }
    
    static void m2() {
        System.out.println("Static metodo");
    }
}
