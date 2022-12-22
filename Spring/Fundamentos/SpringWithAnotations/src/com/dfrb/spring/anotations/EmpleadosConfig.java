package com.dfrb.spring.anotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author danfe
 */

@Configuration
@ComponentScan("com.dfrb.spring.anotations")
@PropertySource("classpath:datosEmpresa.properties")
public class EmpleadosConfig {
	
	@Bean
	public CrearInformeFinanciero informeFinancieroDptoComras() {
		return new InformeFinancieroDptoCompras();
	}
	
	@Bean
	public Empleados directorFinanciero() {
		return new DirectorFinanciero(informeFinancieroDptoComras());
	}

}
