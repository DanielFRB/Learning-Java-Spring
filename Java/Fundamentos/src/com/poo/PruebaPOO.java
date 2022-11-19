package com.poo;

/**
 * @author danfe
 */

public class PruebaPOO {
    public static void main(String[] args){
        Empleados trabajador1 = new Empleados("Daniel");
        Empleados trabajador2 = new Empleados("Gabriel");
        Empleados trabajador3 = new Empleados("Danny");
        trabajador2.setSeccion("Mantenimiento Industrial");
        
        System.out.println(trabajador1.getDatosEmpleados());
        System.out.println(trabajador2.getDatosEmpleados());
        System.out.println(trabajador3.getDatosEmpleados());
        
        System.out.println(Empleados.getIdSiguiente());
    }
}

class Empleados {
    private final String nombre;
    private String seccion;
    private int id;
    private static int idSiguiente = 1;
    
    public Empleados(String n) {
        nombre = n;
        seccion = "Administracion";
        id = idSiguiente;
        idSiguiente++;
    }
    
    public void setSeccion(String s) {
        this.seccion = s;
    }
    
    public String getDatosEmpleados() {
        return "El nombre es: "+ nombre +" la seccion es: "+ seccion +" y el Id es: "+ id;
    }
    
    public static String getIdSiguiente() {
        return "El siguente Id es: "+ idSiguiente;
    }
}
