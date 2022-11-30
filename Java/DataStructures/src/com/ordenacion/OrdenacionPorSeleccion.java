package com.ordenacion;

/**
 * @author danfe
 */

public class OrdenacionPorSeleccion {
    public static void main(String[] args) {
        int[] arregloInt = {32, 45, 12, 10, 4, 56, 9, 5, 99, 2};
        ordSeleccion(arregloInt);
        for (int a : arregloInt) {
            System.out.println(a);
        }
    }
    
    public static void ordSeleccion(int[] arreglo) {
        int indMenor, i, j, n;
        n = arreglo.length;
        for (i = 0; i < n-1; i++) {
            indMenor = i;
            for (j = i+1; j < n; j++) {
                if (arreglo[j] < arreglo[indMenor]) {
                    indMenor = j;
                }
                if (i != indMenor) {
                    intercambiar(arreglo, i, indMenor);
                }
            }
        }
    }
    
    public static void intercambiar(int[] arreglo, int a, int b) {
        int aux = arreglo[a];
        arreglo[a] = arreglo[b];
        arreglo[b] = aux;
    }
}
