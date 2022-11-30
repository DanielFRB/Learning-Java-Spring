package com.listasenlazadas;

/**
 * @author danfe
 */

public class ListaEnlazada {
    protected NodoLista primero;
    
    public ListaEnlazada() {
        this.primero = null;
    }

    public NodoLista getPrimero() {
        return primero;
    }

    public void setPrimero(NodoLista primero) {
        this.primero = primero;
    }
    
    public boolean esVacio() {
        return primero == null;
    }
    
    public void insertaAlInicio(double x) {
        NodoLista nodo = new NodoLista(x);
        if (esVacio()) {
            primero = nodo;
        } else {
            nodo.setSiguiente(primero);
            primero = nodo;
        }
    }
    
    public void insertaAlFinal(double x) {
        NodoLista nodo = new NodoLista(x);
        if (esVacio()) {
            primero = nodo;
        } else {
            NodoLista nodoAux = primero;
            while (nodoAux.getSiguiente() != null) {
                nodoAux = nodoAux.getSiguiente();
            }
            nodoAux.setSiguiente(nodo);
        }
    }
    
    public void mostrar() {
        NodoLista nodo = primero;
        while (nodo != null) {
            System.out.println("[" + nodo.getInfo() + "]");
            nodo = nodo.getSiguiente();
        }
    }
    
    public void borrarPrimero() {
        primero = primero.getSiguiente();
    }
    
    public void mayor() {
        NodoLista nodo = primero;
        double mayor = primero.getInfo();
        while (nodo != null) {
            if (nodo.getInfo() > mayor) {
                mayor = nodo.getInfo();
            }
            nodo = nodo.getSiguiente();
        }
        System.out.println("El mayor es: " + mayor);
    }
    
    public void menor() {
        NodoLista nodo = primero;
        double menor = primero.getInfo();
        while (nodo != null) {
            if (nodo.getInfo() < menor) {
                menor = nodo.getInfo();
            }
            nodo = nodo.getSiguiente();
        }
        System.out.println("El menor es: " + menor);
    }
    
    public void promedio() {
        NodoLista nodo = primero;
        double suma = 0;
        int cont = 0;
        while (nodo != null) {
            suma += nodo.getInfo();
            cont++;
            nodo = nodo.getSiguiente();
        }
        double promedio = suma / cont;
        System.out.println("El promedio es: " + promedio);
    }
    
    public int buscarPosicion(double x) {
        NodoLista nodo = primero;
        int pos = -1;
        int cont = -1;
        while (nodo != null) {
            cont++;
            if (nodo.getInfo() == x) {
                pos = cont;
            }
            nodo = nodo.getSiguiente();
        }
        return pos;
    }
    
    public void borrar(double numero) {
        boolean encontrado = false;
        NodoLista nodoActual = primero;
        NodoLista nodoAnterior = null;
        while ((nodoActual != null) && (!encontrado)) {
            encontrado = (nodoActual.getInfo() == numero);
            if (!encontrado) {
                nodoAnterior = nodoActual;
                nodoActual = nodoActual.getSiguiente();
            }
        }
        if (nodoActual != null) {
            if (nodoActual == primero) {
                primero = nodoActual.getSiguiente();
            } else {
                nodoAnterior.setSiguiente(nodoActual.getSiguiente());
            }
        }
    }
    
    public void ordenarAscendente() {
        NodoLista nodo = primero;
        double aux;
        while (nodo != null) {
            NodoLista nodoSig = nodo.getSiguiente();
            while (nodoSig != null) {
                if (nodo.getInfo() > nodoSig.getInfo()) {
                    aux = nodo.getInfo();
                    nodo.setInfo(nodoSig.getInfo());
                    nodoSig.setInfo(aux);
                }
                nodoSig = nodoSig.getSiguiente();
            }
            nodo = nodo.getSiguiente();
        }
    }
}
