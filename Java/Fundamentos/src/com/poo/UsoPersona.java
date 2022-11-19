package com.poo;

import java.util.*;

/**
 * @author danfe
 */

public class UsoPersona {
    public static void main(String[] args){
        Persona[] personas = new Persona[2];
        personas[0] = new Empleado2("Juan Conde", 500, 2002, 5, 17);
        personas[1] = new Alumno("Oswaldo Lopez", "Medicina");
        
        for (Persona p : personas) {
            System.out.println(p.getNombre() +", "+ p.getDescripcion());
        }
    }
}

abstract class Persona {
    private final String nombre;
    
    public Persona(String n) {
        this.nombre = n;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public abstract String getDescripcion();
}

class Empleado2 extends Persona {
    private double sueldo;
    private Date altaContrato;
    private int id;
    private static int idSiguiente = 1;
    
    public Empleado2(String n, double s, int a, int m, int d) {
        super(n);
        sueldo = s;
        GregorianCalendar calendario = new GregorianCalendar(a, m-1, d);
        altaContrato = calendario.getTime();
        id = idSiguiente;
        idSiguiente++;
    }
    
    public double getSueldo() {
        return sueldo;
    }
    
    public Date getFechaContrado() {
        return altaContrato;
    }
    
    public int getId() {
        return id;
    }
    
    public void setSubeSueldo(double p) {
        double aumento = sueldo * (p / 100);
        sueldo += aumento;
    }
    
    @Override
    public String getDescripcion() {
        return "Este empleado tiene un Id: "+ id +" con un sueldo: "+ sueldo;
    }
}

class Alumno extends Persona {
    private String carrera;
    
    public Alumno(String n, String c) {
        super(n);
        this.carrera = c;
    }
    
    @Override
    public String getDescripcion() {
        return "Este alumno esta estudiando la carrera de: "+ carrera;
    }   
}
