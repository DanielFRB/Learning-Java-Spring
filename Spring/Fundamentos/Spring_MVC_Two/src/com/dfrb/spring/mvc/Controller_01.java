package com.dfrb.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller_01 {
	@RequestMapping
	public String showPagina() {
		return "pagina01";
	}
}
