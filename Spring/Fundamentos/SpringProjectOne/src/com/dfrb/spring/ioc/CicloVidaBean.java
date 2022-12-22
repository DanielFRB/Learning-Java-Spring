package com.dfrb.spring.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author danfe
 */

public class CicloVidaBean {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_2.xml");
        Empleados Daniel = context.getBean("miEmpleado", Empleados.class);
        System.out.println(Daniel.getInforme());
        context.close();
    }
}
