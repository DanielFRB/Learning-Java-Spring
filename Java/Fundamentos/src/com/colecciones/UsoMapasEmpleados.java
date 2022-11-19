package com.colecciones;

import java.util.*;

/**
 * @author danfe
 */

public class UsoMapasEmpleados {
    public static void main(String[] args) {
        HashMap<String, EmpleadoM> personal = new HashMap<>();
        personal.put("145", new EmpleadoM("Daniel"));
        personal.put("146", new EmpleadoM("Yaneth"));
        personal.put("147", new EmpleadoM("Oswaldo"));
        personal.put("148", new EmpleadoM("Barack"));
        System.out.println(personal);
        
        personal.remove("145");
        System.out.println(personal);
        personal.put("148", new EmpleadoM("Maritza"));
        System.out.println(personal);
        
        for (Map.Entry<String, EmpleadoM> p : personal.entrySet()) {
            System.out.println("Clave: "+ p.getKey() +", Valor: "+ p.getValue());
        }
    }
}
