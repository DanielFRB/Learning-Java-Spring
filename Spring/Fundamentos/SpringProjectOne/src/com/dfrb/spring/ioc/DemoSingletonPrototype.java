package com.dfrb.spring.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author danfe
 */

public class DemoSingletonPrototype {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_1.xml");
        SecretarioEmpleado secretario1 = context.getBean("miSecretarioEmpleado", SecretarioEmpleado.class);
        SecretarioEmpleado secretario2 = context.getBean("miSecretarioEmpleado", SecretarioEmpleado.class);
        System.out.println(secretario1);
        System.out.println(secretario2);
        if (secretario1 == secretario2) {
            System.out.println("Apuntan al mismo objeto.");
        } else {
            System.out.println("Se trata de dos objetos distintos.");
        }
    }
}
