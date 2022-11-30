package com.recursividad;

import java.util.*;

/**
 * @author danfe
 */

public class TrianguloPascal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese un número: ");
        int nfilas  = input.nextInt();
        for(int i = 0; i < nfilas; i++) {
            int number = 1;
            System.out.format("%"+ (nfilas - i) * 2 +"s","");
            for(int j = 0; j <= i; j++) {
                System.out.format("%4d", number);
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
        
        int[] a = new int[1];
        for (int i = 1; i <= nfilas; i++) {
            int[] x = new int[i];
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == (i - 1)) {
                    x[j] = 1;
                } else {
                    x[j] = a[j] + a[j - 1];
                }
                System.out.print(x[j] + " ");
            }
            a = x;
            System.out.println();
        }
        mostrar(nfilas);
    }
    
    public static void mostrar(int num) {
        for(int a = 0; a < num; a++) {
            for(int b = 0; b <= a; b++) {
                System.out.print(pascalTriangle(a, b) + " ");
            }
            System.out.println();
        }
    }
    
    public static int pascalTriangle(int a, int b) {
        if(b == 0 || b == a) {
            return 1;
        } else {
            return pascalTriangle(a - 1, b - 1) + pascalTriangle(a - 1, b);
        }
    }
}
