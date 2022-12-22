package com.dfrb.spring.ioc;

/**
 * @author danfe
 */

public class JefeEmpleado implements Empleados {
    private CreacionInformes creacionInforme;
    
    private String email;
    private String nombreEmpresa;

    public JefeEmpleado(CreacionInformes creacionInforme) {
        this.creacionInforme = creacionInforme;
    }
    
    @Override
    public String getTareas() {
        return "Gestiono a mis empleados";
    }
    
    @Override
    public String getInforme() {
        return "Informe creado por el Jefe de seccion con arreglos: "+ creacionInforme.getInforme();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
}

