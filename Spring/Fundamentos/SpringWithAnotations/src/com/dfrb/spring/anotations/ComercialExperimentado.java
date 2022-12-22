package com.dfrb.spring.anotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


/**
 * @author danfe
 */

@Component
public class ComercialExperimentado implements Empleados {
	@Autowired
    @Qualifier("informeFinancieroTrim1")
    private CrearInformeFinanciero informeFinanciero;
    
    @PostConstruct
    public void ejecutaAntesDelBean() {
        System.out.println("Codigo antes del uso del Bean");
    }
    
    @PreDestroy
    public void ejecutaDespuesDelBean() {
        System.out.println("Codigo despues del uso del Bean");
    }
    
    @Override
    public String getTareas() {
        return "Vender productos y seguir vendiendo";
    }

    @Override
    public String getInformes() {
        //return "Informe generado por el Comercial";
        return informeFinanciero.getInformeFinanciero();
    }
}
