package com.primerospasos;

/**
 * @author danfe
 */

public class StrEqual {
    public static void main(String[] args) {
        String s1 = "hola";
        String s2 = new String("hola");
        String s3 = "hola";
        
        //Comparando con el ==, esta comparación no compara las cadenas, sino si la instancia es la misma
        if (s1 == s2) {
            System.out.println("s1 y s2, Son Iguales");
        } else {
            System.out.println("s1 y s2, No son Iguales");
        }
        
        if (s1 == s3) {
            System.out.println("s1 y s3, Son Iguales");
        } else {
            System.out.println("s1 y s3, No son Iguales");
        }
        
        //Para comparar realmente las cadenas y no si son o no la misma instancia
        s1 = "hola mundo";
        s2 = "hola mundo";
        s3 = new String("hola mundo");
        
        if (s1.equals(s2)) {
            System.out.println("s1 y s2, Son Iguales");
        } else {
            System.out.println("s1 y s2, No son Iguales");
        }
        
        if (s1.equals(s3)) {
            System.out.println("s1 y s3, Son Iguales");
        } else {
            System.out.println("s1 y s3, No son Iguales");
        }
    }
}
