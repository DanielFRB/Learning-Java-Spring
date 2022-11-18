package com.primerospasos;

import java.util.Stack;

/**
 * @author danfe
 */

public class StrInvert {
    public static void main(String[] args) {
        //Invertir una cadena de texto usando el metodo reverse
        System.out.println("Invertir Cadenas de Caracteres");
        System.out.println("1ra Forma");
        String cadena = "HolaMundoSinEspacios";
	System.out.println(cadena);
	StringBuilder strb = new StringBuilder(cadena);
	String cadenaInvertida = strb.reverse().toString();
	System.out.println(cadenaInvertida);
        
        //Utilizando un Bucle While y codigo personalizado
        System.out.println("2da Forma");
        String cadena1 = cadena;
        System.out.println(cadena1);
        char[] arregloCaracter = cadena1.toCharArray();
        int inicio = 0;
        int fin = arregloCaracter.length - 1;
        char temporal;
        while (fin > inicio) {
            temporal = arregloCaracter[inicio];
            arregloCaracter[inicio] = arregloCaracter[fin];
            arregloCaracter[fin] = temporal;
            fin--;
            inicio++;
        }
        String cadena1Invertida = new String(arregloCaracter);
        System.out.println(cadena1Invertida);
        
        //Usando un Bucle for y el Metodo append()
        System.out.println("3ra Forma");
        String cadena2 = cadena;
        System.out.println(cadena2);
        StringBuilder cadena2Invertida = new StringBuilder();
        for (int i = (cadena2.length() - 1); i >= 0; i--) {
            cadena2Invertida.append(cadena2.charAt(i));
        }
        System.out.println(cadena2Invertida);
        
        //Usando Recursividad
        System.out.println("4ra Forma");
        String cadena3 = cadena;
        System.out.println(cadena3);
        String cadena3Invertida = funCadenaInvertida(cadena3, cadena3.length() - 1);
        System.out.println(cadena3Invertida);
        
        //Usando la Clase Stack
        System.out.println("5ta Forma");
        String cadena4 = cadena;
        System.out.println(cadena4);
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < cadena4.length(); i++) {
	    stack.push(cadena4.charAt(i));
	}
	StringBuilder cadena4Invertida = new StringBuilder();
	while (!stack.empty()) {
	    cadena4Invertida.append(stack.pop());
	}
	System.out.println(cadena4Invertida);
    }
    
    private static String funCadenaInvertida(String str, int indice) {
        if (indice == 0) {
            return str.charAt(0) + "";
        }
        char letra = str.charAt(indice);
        return letra + funCadenaInvertida(str, indice - 1);
    }
}
