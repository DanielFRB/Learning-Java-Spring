package com.programaciongenerica.clasespropias;

/**
 * @author danfe
 */

public class UsoPareja {
    public static void main(String[] args) {
        Pareja<String> uno = new Pareja<>();
        uno.setVal("Daniel");
        System.out.println(uno.getVal());
        Persona person1 = new Persona("Yaneth");
        Pareja<Persona> dos = new Pareja<>();
        dos.setVal(person1);
        System.out.println(dos.getVal());
    }
}

class Persona {
    public Persona(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return nombre;
    }
    
    private String nombre;
}
