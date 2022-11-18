package com.primerospasos;

import java.util.Scanner;

/**
 * @author danfe
 */

public class Palindromo {
    public static void main(String[] args) {
        System.out.println("1er Palindromo: Solo reconoce palabras simples");
        System.out.println("Ingrese la palabra a evaluar:");
        Scanner scanner = new Scanner(System.in);
        String palabra = scanner.nextLine();
        char[] c = palabra.toCharArray();
        char[] v = new char[c.length];
        int n = 0;
        for (int i = c.length; i > 0; i--) {
            v[n] = c[i-1];
            n++;
        }
        String v2 = new String(v);
        if (palabra.equalsIgnoreCase(v2)) {
            System.out.println("Es Palindromo");
        } else {
            System.out.println("No es Palindromo");
        }
        System.out.println("2do Palindromo: Reconoce frases simples");
        System.out.println("Ingrese la frase a evaluar:");
        Scanner sc = new Scanner(System.in);
        String frase = sc.nextLine();
        if (esPalindromo(eliminarAcentos(compactarFrase(frase)))) {
            System.out.println("La frase SI es Palindroma");
        } else {
            System.out.println("La frase NO es Palindroma");
        }
        System.out.println("3er Palindromo: Usando recursividad");
        if (checkPalindromo(eliminarAcentos(compactarFrase(frase)))) {
           System.out.println("La frase SI es Palindroma");
        } else {
            System.out.println("La frase NO es Palindroma");
        }
    }
    
    private static String compactarFrase(String f) {
        f = f.toLowerCase();
        String fc = "";
        for (int i = 0; i < f.length(); i++) {
            if (!(f.substring(i, i+1).equals(" ") 
                    || f.substring(i, i+1).equals(",") 
                    || f.substring(i, i+1).equals(".") 
                    || f.substring(i, i+1).equals("Â¿")
                    || f.substring(i, i+1).equals("?")
                    || f.substring(i, i+1).equals("Â¡")
                    || f.substring(i, i+1).equals("!"))) {
                fc += f.substring(i, i+1);// frase compactada sin espacios o caracteres especiales
            }
        }
        return fc;
    }
    
    private static String eliminarAcentos(String f) {
        final String ORIGINAL = "ÁáÉéÍíÓóÚúÑñÜü";
        final String REEMPLAZO = "AaEeIiOoUuNnUu";
        char[] array = f.toCharArray();
        for (int i = 0; i < array.length; i++) {
            int pos = ORIGINAL.indexOf(array[i]);
            if (pos > -1) {
                array[i] = REEMPLAZO.charAt(pos);
            }
        }
        return new String(array);
    }
    
    private static boolean esPalindromo(String f) {
        for (int i = 0, j = f.length()-1; i <= j; i++, j--) {
            if (f.charAt(i) != f.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean checkPalindromo(String f) {
        if(f.length() == 0 || f.length() == 1) {
            return true; 
        }
        if(f.charAt(0) == f.charAt(f.length()-1)) {
            return checkPalindromo(f.substring(1, f.length()-1));
        }
        return false;
    }
}
