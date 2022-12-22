package com.dfrb.spring.anotations;

import org.springframework.stereotype.Component;

/**
 * @author danfe
 */

@Component
public class InformeFinancieroTrim1 implements CrearInformeFinanciero {
    @Override
    public String getInformeFinanciero() {
        return "Este es un Informe Financiero del Trimestre 1";
    }
}
