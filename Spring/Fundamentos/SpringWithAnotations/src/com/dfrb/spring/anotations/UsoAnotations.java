package com.dfrb.spring.anotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author danfe
 */

public class UsoAnotations {
    public static void main(String[] args) {
        // Leer el XML de configuracion
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // Pedir el bean al contenedor
        Empleados Daniel = context.getBean("comercialExperimentado", Empleados.class);
        // Usar el Bean
        System.out.println(Daniel.getTareas());
        System.out.println(Daniel.getInformes());
        // Cerrar el contexto
        context.close();
    }
}
