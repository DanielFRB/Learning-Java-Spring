package com.primerospasos;

/**
 * @author danfe
 */

public class OperacionesBasicas {
    public static void main(String[] args) {
        int a = 20;
        int b = 7;
        int suma = a + b;
        int resta = a - b;
        int multiplicar = a * b;
        double divideMal = a / b;
        double divideBien = (double)a / (double)b; // Casting a las variables a y b
        System.out.println("El valor de (a) es: " + a);
        System.out.println("El valor de (b) es: " + b);
        System.out.println("La suma de a y b es: " + suma);
        System.out.println("La resta de a y b es: " + resta);
        System.out.println("La multiplicacion de a y b es: " + multiplicar);
        System.out.println("La division de a y b es: " + divideMal);
        System.out.println("La division anterior es erronea...");
        //Ambos lados de la igualdad deben ser del mismo tipo de dato, para lograrlo se hace un casting a las variables a y b
        System.out.println("La division correcta es: " + divideBien);
    }
}
