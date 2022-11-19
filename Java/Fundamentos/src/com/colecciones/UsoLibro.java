package com.colecciones;

/**
 * @author danfe
 */

public class UsoLibro {
    public static void main(String[] args) {
        Libro libro1 = new Libro("Programacion Java", "Daniel Rondon", 789987);
        Libro libro2 = new Libro("Programacion Java", "Daniel Rondon", 789982);
        
        if (libro1.equals(libro2)) {
            System.out.println("Si es el Mismo Libro");
            System.out.println(libro1.hashCode());
            System.out.println(libro2.hashCode());
        } else {
            System.out.println("No es el Mismo Libro");
            System.out.println(libro1.hashCode());
            System.out.println(libro2.hashCode());
        }
    }
}
