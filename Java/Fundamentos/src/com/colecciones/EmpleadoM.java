package com.colecciones;

/**
 * @author danfe
 */

public class EmpleadoM {
    private String nombre;
    private double sueldo;
    
    public EmpleadoM(String n) {
        this.nombre = n;
        this.sueldo = 2000;
    }
    
    @Override
    public String toString() {
        return "[Nombre: "+ nombre +". Sueldo: "+ sueldo +"]";
    }
}
