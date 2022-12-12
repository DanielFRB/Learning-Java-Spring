package com.java.lambdas;

/**
 * @author danfe
 */

interface Sumable {
    int suma(int a, int b);
}

// Implementacion tradicional sin expresiones Lambdas
/* class SumableImpl implements Sumable {
    @Override
    public int suma(int a, int b) {
        return (a + b);
    } 
} */

public class LambdaParametros {
    public static void main(String[] args) {
        Sumable suma = (a, b) -> (a + b);
        int resultado = suma.suma(5, 10);
        System.out.println("La suma de dos numeros es: " + resultado);
        
        System.out.println("--------");
        
        Sumable abc = (int a, int b) -> {
            int r = (a + b);
            return r;
        };
        System.out.println("La suma de dos numeros es: " + abc.suma(10, 20));
    }
}
