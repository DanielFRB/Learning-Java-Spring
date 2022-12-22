package com.dfrb.spring.anotations;

public class InformeFinancieroDptoCompras implements CrearInformeFinanciero {

	@Override
	public String getInformeFinanciero() {
		return "Informe Financiero del Departamento de Compras";
	}

}
