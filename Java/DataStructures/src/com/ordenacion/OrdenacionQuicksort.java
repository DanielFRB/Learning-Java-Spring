package com.ordenacion;

/**
 * @author danfe
 */

public class OrdenacionQuicksort {
    public static void main(String[] args) {
        int[] arregloInt = {32, 45, 12, 10, 4, 56, 9, 5, 99, 2};
        ordQuicksort(arregloInt);
        for (int a : arregloInt) {
            System.out.println(a);
        }
    }
    
    public static void ordQuicksort(int[] arreglo) {
        quicksort(arreglo, 0, arreglo.length-1);
    }
    
    private static void quicksort(int[] arreglo, int primero, int ultimo) {
        int i, j, central, pivote;
        central = (primero + ultimo) / 2;
        pivote = arreglo[central];
        i = primero;
        j = ultimo;
        do {
            while (arreglo[i] < pivote) i++;
            while (arreglo[j] > pivote) j--;
            if (i <= j) {
                intercambiar(arreglo, i, j);
                i++;
                j--;
            }
        } while (i <= j);
        if (primero < j) {
            quicksort(arreglo, primero, j);
        }
        if (i < ultimo) {
            quicksort(arreglo, i, ultimo);
        }
    }
    
    public static void intercambiar(int[] arreglo, int a, int b) {
        int aux = arreglo[a];
        arreglo[a] = arreglo[b];
        arreglo[b] = aux;
    }
}
