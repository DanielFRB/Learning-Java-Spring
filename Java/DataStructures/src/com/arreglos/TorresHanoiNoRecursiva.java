package com.arreglos;

import java.io.*;

/**
 * @author danfe
 */

public class TorresHanoiNoRecursiva {
    public static void main(String args[]) throws IOException{
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Numero de discos: ");
        int numeroDeDiscos = Integer.parseInt(entrada.readLine());
        
        TorresHanoiNoRecursiva toh = new TorresHanoiNoRecursiva();
        Torre tOrigen, tDestino, tAuxiliar;
        tOrigen = toh.crearTorre(numeroDeDiscos);
        tDestino = toh.crearTorre(numeroDeDiscos);
        tAuxiliar = toh.crearTorre(numeroDeDiscos);
        toh.torresIterativas(numeroDeDiscos, tOrigen, tAuxiliar, tDestino);
    }
    
    class Torre {
        int capacidad;
        int tope;
        int[] elementos;
    }
    
    Torre crearTorre(int capacidad) {
        Torre torre = new Torre();
        torre.capacidad = capacidad;
        torre.tope = -1;
        torre.elementos = new int[capacidad];
        return torre;
    }
    
    boolean isFull(Torre t) {
        return (t.tope == t.capacidad - 1);
    }
    
    boolean isEmpty(Torre t) {
        return (t.tope == -1);
    }
    
    void push(Torre t, int disco) {
        if (isFull(t)) {
            return;
        }
        t.elementos[++t.tope] = disco;
    }
    
    int pop(Torre t) {
        if (isEmpty(t)) {
            return Integer.MIN_VALUE;
        }
        return t.elementos[t.tope--];
    }
    
    void mueveDiscosEntreDosTorres(Torre origen, Torre destino, char to, char td) {
        int torre1TopDisco = pop(origen);
        int torre2TopDisco = pop(destino);
        
        if (torre1TopDisco == Integer.MIN_VALUE) {
            push(origen, torre2TopDisco);
            mueveDisco(td, to, torre2TopDisco);
        } else if (torre2TopDisco == Integer.MIN_VALUE) {
            push(destino, torre1TopDisco);
            mueveDisco(to, td, torre1TopDisco);
        } else if (torre1TopDisco > torre2TopDisco) {
            push(origen, torre1TopDisco);
            push(origen, torre2TopDisco);
            mueveDisco(td, to, torre2TopDisco);
        } else {
            push(destino, torre2TopDisco);
            push(destino, torre1TopDisco);
            mueveDisco(to, td, torre1TopDisco);
        }
    }
    
    void mueveDisco(char to, char td, int disco) {
        System.out.println("Mueve el disco "+ disco +" desde Torre: "+ to +" hacia Torre: "+ td);
    }
    
    void torresIterativas(int numeroDiscos, Torre tOrigen, Torre tAuxiliar, Torre tDestino) {
        int i, numeroTotalMovimientos;
        char to = 'O', td = 'D', ta = 'A';
        
        if (numeroDiscos % 2 == 0) {
            char temp = td;
            td = ta;
            ta  = temp;
        }
        numeroTotalMovimientos = (int) (Math.pow(2, numeroDiscos) - 1);
        for (i = numeroDiscos; i >= 1; i--) {
            push(tOrigen, i);
        }
        for(i = 1; i <= numeroTotalMovimientos; i++) {
            if (i % 3 == 1) {
                mueveDiscosEntreDosTorres(tOrigen, tDestino, to, td);
            } else if (i % 3 == 2) {
                mueveDiscosEntreDosTorres(tOrigen, tAuxiliar, to, ta);
            } else if (i % 3 == 0) {
                mueveDiscosEntreDosTorres(tAuxiliar, tDestino, ta, td);
            }
        }
    }
}
