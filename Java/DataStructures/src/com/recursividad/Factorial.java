package com.recursividad;

import java.io.*;

/**
 * @author danfe
 */

public class Factorial {
    public static void main(String[] args) throws IOException{
        int n;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("Introduzca un numero 'n': ");
            n = Integer.parseInt(entrada.readLine());
        } while (n < 0);
        System.out.println("\t"+ n +"! = "+ factorial(n));
    }
    
    private static long factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            long result = n * factorial(n - 1);
            return result;
        }
    }
}
