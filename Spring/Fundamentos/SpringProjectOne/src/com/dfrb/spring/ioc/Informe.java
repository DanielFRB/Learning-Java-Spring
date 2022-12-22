package com.dfrb.spring.ioc;


/**
 * @author danfe
 */

public class Informe implements CreacionInformes {
    @Override
    public String getInforme() {
        return "Este es el Informe";
    }
}
