package com.recursividad;

import java.io.*;


/**
 * @author danfe
 */

public class SumaNumNatural {
    public static void main(String[] args) throws IOException {
        System.out.println("Ingrese un numero 'n': ");
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(entrada.readLine());
        System.out.println("Suma Recursiva es igual a: "+ sumaRecursiva(n));
        System.out.println("Suma Iterativa es igual a: "+ sumaIterativa(n));
    }
    
    private static int sumaRecursiva(int n) {
        if (n <= 9) {
            return n;
        } else {
            return sumaRecursiva(n / 10) + n % 10;
        }
    }
    
    private static int sumaIterativa(int n) {
        int suma = 0;
        while (n > 9) {
            suma += n % 10;
            n /= 10;
        }
        return (suma + n);
    }
}
