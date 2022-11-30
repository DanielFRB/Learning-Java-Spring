package com.arreglos;

import java.io.*;

/**
 * @author danfe
 */

public class ProductoElemArreglo {
    private static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws Exception {
        double[] v;
        int n;
        System.out.println("Número de elementos: ");
        n = Integer.parseInt(entrada.readLine());
        v = new double[n];
        leerArreglo(v);
        System.out.println("El producto de los "+ n +" elementos es igual a: "+ productoArreglo(v));
    }
    
    private static void leerArreglo(double[] a) throws Exception {
        int n = 0;
        System.out.println("Introduzca "+ a.length +" numeros.");
        for (; n < a.length; n++) {
            a[n] = Double.valueOf(entrada.readLine()).doubleValue();
        }
    }
    
    private static double productoArreglo(double[] w) {
        double pd = 1.0;
        int n = w.length - 1;
        while (n > 0) {
            if (w[n] > 0.0) {
                pd *= w[n--];
            } else {
                n--;
            }
        }
        return pd;
    }
}
