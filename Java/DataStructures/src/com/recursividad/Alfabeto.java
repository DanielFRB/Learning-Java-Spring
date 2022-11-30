package com.recursividad;

/**
 * @author danfe
 */

public class Alfabeto {
    public static void main(String[] args) {
        System.out.print("Letras del Alfabeto: ");
        metodoA('Z');
        System.out.println();
    }
    
    private static void metodoA(char c) {
        if (c >= 'A') {
            metodoB(c);
            System.out.print(c);
        }
    }
    
    private static void metodoB(char c) {
        metodoA(--c);
    }
}
