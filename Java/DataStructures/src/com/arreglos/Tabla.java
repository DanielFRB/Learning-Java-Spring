package com.arreglos;

import java.io.*;

/**
 * @author danfe
 */

public class Tabla {
    public static void main(String[] args) throws Exception {
        int[][] v = new int[3][4];
        leer(v);
        visualizar(v);
    }
    
    private static void leer(int[][] a) throws Exception {
        int i,j;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Entrada de datos de la matriz");
        for (i = 0; i < a.length; i++) {
            System.out.println("Fila: " + i);
            for (j = 0; j < a[i].length; j++) {
                a[i][j]= Integer.parseInt(entrada.readLine());
            }
        }
    }
    
    private static void visualizar(int[][] a) {
        int i,j;
        System.out.println("\n\tMatriz leida");
        for (i = 0; i < a.length; i++) {
            for (j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
