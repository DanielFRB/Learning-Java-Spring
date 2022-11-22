package com.colecciones;

import java.util.*;
import java.util.function.Consumer;

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
        System.out.println("--------");
        
        personal.remove("145");
        System.out.println(personal);
        personal.put("148", new EmpleadoM("Maritza"));
        System.out.println(personal);
        System.out.println("--------");
        
        for (Map.Entry<String, EmpleadoM> p : personal.entrySet()) {
            System.out.println("Clave: "+ p.getKey() +", Valor: "+ p.getValue());
        }
        System.out.println("--------");
        
        // Usando Iteradores
        for (Iterator<Map.Entry<String, EmpleadoM>> it = personal.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, EmpleadoM> p = it.next();
            System.out.println("Clave: "+ p.getKey() +", Valor: "+ p.getValue());
        }
        System.out.println("--------");
        
        // Usando Operaciones Funcionales con lambdas
        personal.entrySet().forEach(p -> {
            System.out.println("Clave: "+ p.getKey() +", Valor: "+ p.getValue());
        });
        System.out.println("--------");
        
        // Usando clases anonimas internas
        personal.entrySet().forEach(new Consumer<Map.Entry<String, EmpleadoM>>() {
            @Override
            public void accept(Map.Entry<String, EmpleadoM> p) {
                System.out.println("Clave: "+ p.getKey() +", Valor: "+ p.getValue());
            }
        });
    }
}
