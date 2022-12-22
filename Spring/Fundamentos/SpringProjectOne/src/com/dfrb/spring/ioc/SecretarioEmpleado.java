package com.dfrb.spring.ioc;

/**
 * @author danfe
 */

public class SecretarioEmpleado implements Empleados {
    private CreacionInformes creacionInforme;
    private String email;
    private String nombreEmpresa;
    
    @Override
    public String getTareas() {
        return "Gestiono la Agenda de los Jefes de la Empresa";
    }
    
    @Override
    public String getInforme() {
        return "Informe del Secretario: "+ creacionInforme.getInforme();
    }

    public void setCreacionInforme(CreacionInformes creacionInforme) {
        this.creacionInforme = creacionInforme;
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
