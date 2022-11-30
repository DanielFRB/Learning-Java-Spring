package com.ordenacion;

/**
 * @author danfe
 */

public class OrdenacionPorInsercion {
    public static void main(String[] args) {
        int[] arregloInt = {32, 45, 12, 10, 4, 56, 9, 5, 99, 2};
        ordInsercion(arregloInt);
        for (int a : arregloInt) {
            System.out.println(a);
        }
    }
    
    public static void ordInsercion(int[] arreglo) {
        int aux, i, j;
        for (i = 1; i < arreglo.length; i++) {
            j = i;
            aux = arreglo[i];
            while (j > 0 && aux < arreglo[j-1]) {
                arreglo[j] = arreglo[j-1];
                j--;
            }
            arreglo[j] = aux;
        }
    }
}
