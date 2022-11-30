package com.recursividad;

import java.util.Arrays;

/**
 * @author danfe
 */

public class BusquedaBinaria {
    public static void main(String[] args) {
        int[] arregloInt = {32, 45, 12, 10, 4, 56, 9, 5, 99, 2};
        int[] arregloInt2 = {88, 49, 15, 21, 40, 56, 26, 5, 99, 2};
        int numeroABuscar = 56, position;
        ordInsercion(arregloInt);
        for (int i : arregloInt) {
            System.out.print(i + ",");
        }
        buscarNumero(arregloInt, numeroABuscar);
        
        // Utilizando los Metodos de la Clase Arrays;
        Arrays.sort(arregloInt2);
        for (int i : arregloInt2) {
            System.out.print(i + ",");
        }
        position = Arrays.binarySearch(arregloInt2, numeroABuscar);
        if (position > 0) {
            System.out.println(" El numero: " + numeroABuscar + ", SI se encuentra en la posicion: " + position);
        } else {
            System.out.println(" El numero: " + numeroABuscar + ", NO se encuentra en el Arreglo");
        }
    }
    
    public static void buscarNumero(int[] arreglo, int clave) {
        int resultado = 0;
        int inferior = 0;
        int superior = arreglo.length - 1;
        resultado = busquedaBR(arreglo, clave, inferior, superior);
        if (resultado != 0) {
            System.out.println(" El numero: " + clave + ", SI se encuentra en la posicion: " + resultado);
        } else {
            System.out.println(" El numero: " + clave + ", NO se encuentra en el Arreglo");
        }
    }
    
    public static int busquedaBR(int[] arreglo, int clave, int primero, int ultimo) {
        int centro;
        if (primero > ultimo) {
            return -1;
        } else {
            centro = (primero + ultimo) / 2;
            if (arreglo[centro] ==  clave) {
                return centro;
            } else if (arreglo[centro] <  clave) {
                return busquedaBR(arreglo, clave, centro+1, ultimo);
            } else {
                return busquedaBR(arreglo, clave, primero, centro-1);
            }
        }
    }
    
    public static void ordInsercion(int[] arreglo) {
        int i, j;
        int aux;
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
