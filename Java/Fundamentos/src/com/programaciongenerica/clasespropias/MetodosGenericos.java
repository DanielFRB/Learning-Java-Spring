package com.programaciongenerica.clasespropias;

/**
 * @author danfe
 */

public class MetodosGenericos {
    public static void main(String[] args) {
        String[] nombres = {"Daniel", "Yaneth", "Oswaldo", "Barack"};
        Integer[] numeros = {12, 34, 10, 20, 45, 4, 2, 79, 90, 11};
        System.out.println(MisMatrices.getMenor(nombres));
        System.out.println(MisMatrices.getMayor(numeros));
        System.out.println(MisMatrices.getElementos(nombres));
    }
}

class MisMatrices {
    public static <T extends Comparable> T getMenor(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        T elemMenor = a[0];
        for (int i = 1; i < a.length; i++) {
            if (elemMenor.compareTo(a[i]) > 0) {
                elemMenor = a[i];
            }
        }
        return elemMenor;
    }
    
    public static <T extends Comparable> T getMayor(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        T elemMayor = a[0];
        for (int i = 1; i < a.length; i++) {
            if (elemMayor.compareTo(a[i]) < 0) {
                elemMayor = a[i];
            }
        }
        return elemMayor;
    }
    
    public static <T> String getElementos(T[] a) {
        return "El array tiene: " + a.length + " elementos";
    }
}
