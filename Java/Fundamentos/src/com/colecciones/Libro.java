package com.colecciones;

/**
 * @author danfe
 */

public class Libro {
    private String titulo;
    private String autor;
    private int ISBN;
    
    public Libro(String t, String a, int isbn) {
        this.titulo = t;
        this.autor = a;
        this.ISBN = isbn;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        final Libro l = (Libro) o;
        return this.ISBN == l.ISBN;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.ISBN;
        return hash;
    }
    
    public String getDatosLibro() {
        return "El Titulo es: "+ titulo +". El Autor es: "+ autor +" y el ISBN es: "+ ISBN;
    }
}
