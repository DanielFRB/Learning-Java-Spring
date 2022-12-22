package com.dfrb.spring.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author danfe
 */

public class UsoEmpleados {
    public static void main(String[] args) {
        /*Empleados jefe1 = new JefeEmpleado();
        Empleados secretario1 = new SecretarioEmpleado();
        Empleados director1 = new DirectorEmpleado();
        System.out.println(jefe1.getTareas());
        System.out.println(secretario1.getTareas());
        System.out.println(director1.getTareas());*/
        
        // Usando los Beans
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JefeEmpleado jefe = context.getBean("miEmpleado", JefeEmpleado.class);
        System.out.println(jefe.getTareas());
        System.out.println(jefe.getInforme());
        System.out.println("El Correo electronico es: "+ jefe.getEmail());
        System.out.println("Empresa donde Labora: "+ jefe.getNombreEmpresa());
        System.out.println("--------");
        SecretarioEmpleado empleado1 = context.getBean("miSecretarioEmpleado", SecretarioEmpleado.class);
        System.out.println(empleado1.getTareas());
        System.out.println(empleado1.getInforme());
        System.out.println(empleado1.getEmail());
        System.out.println(empleado1.getNombreEmpresa());
        context.close();
    }
}
