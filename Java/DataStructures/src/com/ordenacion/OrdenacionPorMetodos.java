package com.ordenacion;

import java.util.Arrays;

/**
 * @author danfe
 */

public class OrdenacionPorMetodos {
    public static void main(String[] args) {
        int[] arregloInt = {32, 45, 12, 10, 4, 56, 9, 5, 99, 2};
        Arrays.sort(arregloInt);
        for (int a : arregloInt) {
            System.out.println(a);
        }
    }
}
