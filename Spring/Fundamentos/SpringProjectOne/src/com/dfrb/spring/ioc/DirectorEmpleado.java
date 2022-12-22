package com.dfrb.spring.ioc;

/**
 * @author danfe
 */

public class DirectorEmpleado implements Empleados {
    private CreacionInformes creacionInforme;
    
    public DirectorEmpleado(CreacionInformes creacionInforme) {
        this.creacionInforme = creacionInforme;
    }

    @Override
    public String getTareas() {
        return "Gestiono la plantilla de la Empresa";
    }

    @Override
    public String getInforme() {
        return "Informe creado por el Director: "+ creacionInforme.getInforme();
    }
    
    public void init() {
        System.out.println("Metodo Init, dentro van las tareas que se ejecutan antes de usar el bean");
    }
    
    public void destroy() {
        System.out.println("Metodo Destroy, dentro van las tareas que se ejecutan despues de usar el bean");
    }
}
