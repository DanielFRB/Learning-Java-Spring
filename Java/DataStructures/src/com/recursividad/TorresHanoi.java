package com.recursividad;

import java.io.*;

/**
 * @author danfe
 */

public class TorresHanoi {
    public static void main(String[] args) throws IOException {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Numero de discos: ");
        int n = Integer.parseInt(entrada.readLine());
        Hanoi('O', 'A', 'D', n);  //1:origen  2:auxiliar 3:destino                                                         
    }

    public static void Hanoi(char origen,  char auxiliar, char destino, int n){
        if (n == 1) {
            n = 1;
            System.out.println("Mover disco "+ n +" desde Torre "+ origen +" hacia Torre "+ destino);
        } else {
            Hanoi(origen, destino, auxiliar, n - 1);
            System.out.println("Mover disco "+ n + " desde Torre "+ origen +" hacia Torre "+ destino);
            Hanoi(auxiliar, origen, destino, n - 1);
        }
    }
}
