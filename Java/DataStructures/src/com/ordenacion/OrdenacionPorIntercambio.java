package com.ordenacion;

/**
 * @author danfe
 */

public class OrdenacionPorIntercambio {
    public static void main(String[] args) {
        int[] arregloInt = {32, 45, 12, 10, 4, 56, 9, 5, 99, 2};
        ordIntercambio(arregloInt);
        for (int a : arregloInt) {
            System.out.println(a);
        }
    }
    
    public static void intercambiar(int[] arreglo, int a, int b) {
        int aux = arreglo[a];
        arreglo[a] = arreglo[b];
        arreglo[b] = aux;
    }
    
    public static void ordIntercambio(int[] arreglo) {
        int i, j;
        for (i = 0; i < arreglo.length - 1; i++) {
            for (j = i+1; j < arreglo.length; j++) {
                if (arreglo[i] > arreglo[j]) { // mayor para ordenamiento ascendente. menor para desdendente
                    intercambiar(arreglo, i, j);
                }
            }
        }
    }
}
