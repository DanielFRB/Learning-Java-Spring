package com.programaciongenerica.clasespropias;

import java.util.*;

/**
 * @author danfe
 */

public class UsoEmpleados {
    public static void main(String[] args) {
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        listaEmpleados.add(new Empleado("Daniel", 45, 700));
        listaEmpleados.add(new Empleado("Oswaldo", 21, 800));
        listaEmpleados.add(new Empleado("Yaneth", 50, 1700));
        listaEmpleados.add(new Empleado("Danny", 43, 2700));
        listaEmpleados.add(new Empleado("Gabriel", 39, 900));
        
        for (Empleado e : listaEmpleados) {
            System.out.println(e.getDatosEmpleado());
        }
        
        Iterator<Empleado> iterator = listaEmpleados.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getDatosEmpleado());
        }
        
    }
}
