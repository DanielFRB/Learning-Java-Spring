package com.listasenlazadas;

import java.util.Scanner;

/**
 * @author danfe
 */

public class ListasEnlazadasDemo {
    public static Scanner sc = new Scanner(System.in);
    public static ListaEnlazada lista = new ListaEnlazada();
            
    public static void main(String[] args) {
        int opc = 0;
        do {
            System.out.println("Menu de Opciones");
            System.out.println("[1] Ingresar elementos a la lista");
            System.out.println("[2] Mostrar lista");
            System.out.println("[3] Ingrese Elemento Al final");
            System.out.println("[4] Borrar numero del inicio");
            System.out.println("[5] Mayor numero");
            System.out.println("[6] Menor numero");
            System.out.println("[7] Promedio");
            System.out.println("[8] Ordenar Acendente");
            System.out.println("[9] Borrar por Info del nodo");
            System.out.println("[10] Salir");
            System.out.println("Ingrese opcion[1-10]");
            opc = sc.nextInt();
            switch (opc) {
                case 1:
                    double x = 0;
                    System.out.println("Numero de elementos a agregar a la lista");
                    int n = sc.nextInt();
                    for (int j = 0; j < n; j++) {
                        System.out.println("Ingrese un numero: ");
                        x = sc.nextDouble();
                        lista.insertaAlInicio(x);
                    }
                break;
                case 2:
                    System.out.println("Los numeros ingresados son:");
                    lista.mostrar();
                break;
                case 3:
                    double e;
                    System.out.println("Numero de elementos a agregar a la lista");
                    int r = sc.nextInt();
                    for (int i = 0; i < r; i++) {
                        System.out.println("Ingrese un numero: ");
                        e = sc.nextDouble();
                        lista.insertaAlFinal(e);
                    }
                break;
                case 4:
                    System.out.println("Borrando numero al inicio de la lista");
                    lista.borrarPrimero();
                break;
                case 5:
                    lista.mayor();
                break;
                case 6:
                    lista.menor();
                break;
                case 7:
                    System.out.println("Promedio");
                    lista.promedio();
                break;
                case 8:
                    System.out.println("Ordenamiento Ascendente");
                    lista.ordenarAscendente();
                    lista.mostrar();
                break;
                case 9:
                    System.out.println("Ingrese el numero a eliminar");
                    double numero = sc.nextDouble();
                    if (lista.buscarPosicion(numero) != -1) {
                        lista.borrar(numero);
                        System.out.println("Numero eliminado");
                    } else {
                        System.out.println("Nuemro no encontrado");
                    }
                break;
                default:
                    System.out.println("Adios...");
            }
        } while (opc != 10);
    }
}
