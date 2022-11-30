package com.listasenlazadas;

/**
 * @author danfe
 */

public class NodoLista {
    private double info;
    private NodoLista siguiente;
    
    public NodoLista() {
        this.siguiente = null;
    }
    
    public NodoLista(double x) {
        this.siguiente = null;
        this.info = x;
    }
    
    public NodoLista(double x, NodoLista siguiente) {
        this.info = x;
        this.siguiente = siguiente;
    }

    public double getInfo() {
        return info;
    }

    public void setInfo(double info) {
        this.info = info;
    }

    public NodoLista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLista siguiente) {
        this.siguiente = siguiente;
    }
}
