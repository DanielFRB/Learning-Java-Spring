package com.programaciongenerica.clasespropias;

/**
 * @author danfe
 */

public class Pareja<T> {
    private T variable;
    
    public Pareja() {
        variable = null;
    }
    
    public void setVal(T var) {
        this.variable = var;
    }
    
    public static void imprimirTrabajador(Pareja<? extends Empleado> p) {
        Empleado primero = p.getVal();
        System.out.println(primero);
    }
    
    public T getVal() {
        return variable;
    }
}
