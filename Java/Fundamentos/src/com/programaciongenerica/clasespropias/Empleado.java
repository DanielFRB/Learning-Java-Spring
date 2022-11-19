package com.programaciongenerica.clasespropias;

/**
 * @author danfe
 */

public class Empleado {
    private String nombre;
    private int edad;
    private double salario;
    
    public Empleado(String n, int e, double s) {
        this.nombre = n;
        this.edad = e;
        this.salario = s;
    }
    
    public String getDatosEmpleado() {
        return "El Empleado se llama: "+ nombre +" . Tiene: "+ edad +" años y un Salario de: "+ salario;
    }
}
