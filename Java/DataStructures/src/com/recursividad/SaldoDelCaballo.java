package com.recursividad;

import java.io.*;

/**
 * @author danfe
 */

public class SaldoDelCaballo {
    public static void main(String args[]) throws IOException, Exception{
        int x, y;
        boolean solucion;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Posicion inicial del caballo. ");
            System.out.print(" x = ");
            x = Integer.parseInt(entrada.readLine());
            System.out.print(" y = ");
            y = Integer.parseInt(entrada.readLine());
            Caballo caballoViejo = new Caballo(x, y);
            solucion = caballoViejo.resolverSaltos();
            if (solucion) {
                caballoViejo.escribirEnTablero();
            }
        } catch (Exception e) {
            System.out.println("No se pudo probar el algoritmo, " + e);
        }
    }
}

class Caballo {
    static final int N = 8;
    static final int n = (N + 1);
    private int[][] tablero = new int[n][n];
    private boolean exito;
    private int[][] SALTO = {{2,1}, {1,2}, {-1,2}, {-2,1}, {-2,-1}, {-1,-2}, {1,-2}, {2,-1}};
    private int x0, y0;
    
    public Caballo(int x, int y) throws Exception {
        if ((x < 1) || (x > N) || (y < 1) || (y > N)) {
            throw new Exception("Coordenadas fuera de rango");
        }
        x0 = x;
        y0 = y;
        for (int i = 0; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                tablero[i][j] = 0;
            }
        }
        tablero[x0][y0] = 1;
        exito = false;
        System.out.println("Caballo Viejo Creado");
    }
    
    public boolean resolverSaltos() {
        System.out.println("Comenzando a Resolver");
        saltoCaballo(x0, y0, 2);
        System.out.println("Resuelto");
        return exito;
    }
    
    private void saltoCaballo(int x, int y, int i) {
        int nx, ny;
        int k;
        k = 0;
        do {
            k++;
            nx = x + SALTO[k-1][0];
            ny = y + SALTO[k-1][1];
            if ((nx >= 1) && (nx <= N) && (ny >= 1) && (ny <= N) && (tablero[nx][ny] == 0)) {
                tablero[nx][ny]= i;
                if (i < N*N) {
                    saltoCaballo(nx, ny, i+1);
                    if (!exito) {
                        tablero[nx][ny] = 0;
                    }
                } else {
                    System.out.println("Resuelto");
                    exito = true;
                }
            }
        } while ((k < 8) && !exito);
    }
    
    void escribirEnTablero() {
        System.out.println("Para Imprimir");
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Listo Impreso");
    }
}
