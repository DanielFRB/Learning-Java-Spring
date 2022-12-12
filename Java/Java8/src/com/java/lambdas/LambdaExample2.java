package com.java.lambdas;

/**
 * @author danfe
 */

interface Fig {
    void dibuje();
}

// Implementacion tradicional sin expresiones Lambdas
/* class Rectangulo implements Fig {
    @Override
    public void dibuje() {
        System.out.println("rectangulo metodo dibuje");
    }
} */

public class LambdaExample2 {
    public static void main(String[] args) {
        Fig rectangulo = () -> System.out.println("rectangulo metodo dibuje");
        rectangulo.dibuje();
    }
}
