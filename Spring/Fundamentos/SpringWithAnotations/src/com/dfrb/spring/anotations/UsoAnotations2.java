package com.dfrb.spring.anotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author danfe
 */

public class UsoAnotations2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EmpleadosConfig.class);
        Empleados empleado = context.getBean("directorFinanciero", Empleados.class);
        System.out.println(empleado.getTareas());
        System.out.println(empleado.getInformes());
        System.out.println("------------");
        DirectorFinanciero director = context.getBean("directorFinanciero", DirectorFinanciero.class);
        System.out.println("Email del Director: "+ director.getEmail());
        System.out.println("Nombre de la Empresa: "+ director.getNombreEmpresa());
        context.close();
    }
}
