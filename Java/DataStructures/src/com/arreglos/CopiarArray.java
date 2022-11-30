package com.arreglos;

/**
 * @author danfe
 */

public class CopiarArray {
    public static void main(String[] args) {
        final int N = 15;
        final int M = 20;
        double[] v = new double[N], w = new double[M];
        double x = 1.0;
        for (int i = 0; i < N; i++) {
            v[i] = Math.exp((2*x)-1);
        }
        for (int i = 0; i < M; i++) {
            w[i] = (double)i;
        }
        System.out.println("Valores del vector v:");
        for (int i = 0; i < N; i++) {
            System.out.println(v[i]);
        }
        System.out.flush();
        System.arraycopy(v, ((N-1)-10)+1, w, 10, 10);
        System.out.println("Valores del vector w: ");
        for (int i = 0; i < M; i++) {
            System.out.println(w[i]);
        }
        System.out.flush();
    }
}
