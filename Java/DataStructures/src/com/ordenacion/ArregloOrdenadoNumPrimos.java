package com.ordenacion;

import java.io.*;
import java.util.*;

/**
 * @author danfe
 */

public class ArregloOrdenadoNumPrimos {
    public static void main(String args[]) throws IOException {
        int[] numeros = {12, 34, 11, 56, 76, 2, 3, 56, 20, 90, 99, 98, 23, 7, 69, 53, 59, 89, 97, 100};
        
        System.out.print("Arreglo de Numeros Original:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(" " + numeros[i]);
        }
        numeros = OrdenaPrimosFirst(ordenAscendente(numeros));
        System.out.print("\nArreglo de Numeros Ordenados Validando Numeros Primos Ordenados:\n");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(" " + numeros[i]);
        }
    }
    
    private static int[] ordenAscendente(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int aux = a[i];
                a[i] = a[min];
                a[min] = aux;
            }
        }
        return a;
    }
    
    private static int[] OrdenaPrimosFirst(int[] a) {
        List<Integer> lista = new ArrayList<Integer>();
        for (int i = 0; i < a.length; i++) {
            if (esPrimo(a[i])) {
                lista.add(a[i]);
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (!esPrimo(a[i])) {
                lista.add(a[i]);
            }
        }
        int[] arrayReturned = new int[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            arrayReturned[i] = lista.get(i);
        }
        return arrayReturned;
    }
    
    private static boolean esPrimo(int num){
        boolean primo = (num != 1);
        int divisor = 2;
        while(primo && (divisor <= Math.sqrt(num))){
            if((num % divisor) == 0){
                primo = false;
            }
            divisor++;
        }
        return primo;
    }
}
