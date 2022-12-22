package com.dfrb.spring.anotations;

import org.springframework.beans.factory.annotation.Value;

public class DirectorFinanciero implements Empleados {
	private CrearInformeFinanciero informeFinanciero;
	
	@Value("${email}")
	private String email;
	
	@Value("${nombreEmpresa}")
	private String nombreEmpresa;
	
	public DirectorFinanciero(CrearInformeFinanciero informeFinanciero) {
		this.informeFinanciero = informeFinanciero;
	}
	
	public String getEmail() {
		return email;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	@Override
	public String getTareas() {
		return "Gestion Financiera de la Empresa";
	}

	@Override
	public String getInformes() {
		return informeFinanciero.getInformeFinanciero();
	}
}
