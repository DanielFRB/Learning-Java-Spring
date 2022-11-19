package com.colecciones;

/**
 * @author danfe
 */

class Articulo implements Comparable<Articulo> {
    private int numeroArticulo;
    private String descripcion;
    
    public Articulo(int num, String desc) {
        this.numeroArticulo = num;
        this.descripcion = desc;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    @Override
    public int compareTo(Articulo a) {
        return numeroArticulo - a.numeroArticulo;
    }
}
