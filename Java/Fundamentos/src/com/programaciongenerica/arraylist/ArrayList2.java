package com.programaciongenerica.arraylist;

/**
 * @author danfe
 */

public class ArrayList2 {
    private Object[] datosElemento;
    private int i = 0;
    
    public ArrayList2(int z) {
        datosElemento = new Object[z];
    }
    
    public Object get(int i) {
        return datosElemento[i];
    }
    
    public void add(Object o) {
        datosElemento[i] = o;
        i++;
    }
}
