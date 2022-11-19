package com.poo;

import java.util.*;

/**
 * @author danfe
 */

public class UsoEmpleado {
    public static void main(String[] args){
        Jefatura jefeRRHH = new Jefatura("Oswaldo Lopez", 2000, 2015, 3, 27);
        jefeRRHH.setIncentivo(550);
        Empleado[] misEmpleados = new Empleado[6];
        misEmpleados[0] = new Empleado("Daniel Rondon", 700, 2010, 8, 14);
        misEmpleados[1] = new Empleado("Gabriel Rondon", 1200, 2016, 5, 20);
        misEmpleados[2] = new Empleado("Danny Rondon", 1400, 2020, 2, 5);
        misEmpleados[3] = new Empleado("Antonio Rondon");
        misEmpleados[4] = jefeRRHH;
        misEmpleados[5] = new Jefatura("Yaneth Machado", 2000, 2005, 5, 12);
        Jefatura jefeFinanzas = (Jefatura) misEmpleados[5];
        jefeFinanzas.setIncentivo(1000);
        
        System.out.println("El Jefe "+ jefeFinanzas.getNombre() +" tiene un bono de: "+ jefeFinanzas.setBonus(500));
        System.out.println(jefeRRHH.tomarDecisiones("Dar cinco dias de vacaciones a los Empleados"));
        System.out.println(misEmpleados[0].getNombre() +" tiene un bonus de: "+ misEmpleados[0].setBonus(200));
         
        for (Empleado e : misEmpleados) {
            e.setSubeSueldo(5);
        }
        
        Arrays.sort(misEmpleados);
        
        for (Empleado e : misEmpleados) {
            System.out.println("Id: "+ e.getId() +", Nombre: "+ e.getNombre() +", Sueldo: "+ e.getSueldo() +", Fecha de Ingreso: "+ e.getFechaContrado());
        }
    }
}

class Empleado implements Comparable, Trabajadores {
    private final String nombre;
    private double sueldo;
    private Date altaContrato;
    private int id;
    private static int idSiguiente = 1;
    
    public Empleado(String n, double s, int a, int m, int d) {
        nombre = n;
        sueldo = s;
        GregorianCalendar calendario = new GregorianCalendar(a, m-1, d);
        altaContrato = calendario.getTime();
        id = idSiguiente;
        idSiguiente++;
    }
    
    public Empleado(String n) {
        this(n, 500, 2002, 6, 5);
    }
    
    public String getNombre() {
        return nombre;
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
    public int compareTo(Object o) {
        Empleado e = (Empleado) o;
        if (this.sueldo < e.sueldo) {
            return -1;
        }
        if (this.sueldo > e.sueldo) {
            return 1;
        }
        return 0;
    }
    
    @Override
    public double setBonus(double b) {
        return Trabajadores.baseBonus + b;
    }
}

class Jefatura extends Empleado implements Jefes {
    private double incentivo;
    
    public Jefatura(String n, double s, int a, int m, int d) {
        super(n, s, a, m, d);
    }
    
    public void setIncentivo(double i) {
        this.incentivo = i;
    }
    
    @Override
    public double getSueldo() {
        double sueldoJefe = super.getSueldo();
        return sueldoJefe + incentivo;
    }
    
    @Override
    public String tomarDecisiones(String d) {
        return "Un miembro de la Direccion ha tomado la decision de: "+ d;
    }
    
    @Override
    public double setBonus(double b) {
        double prima = 200;
        return Trabajadores.baseBonus + b + prima;
    }
}
