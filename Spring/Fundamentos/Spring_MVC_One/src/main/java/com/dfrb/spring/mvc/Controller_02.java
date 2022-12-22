package com.dfrb.spring.mvc;

//import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controller_02 {
	@RequestMapping("/showForm")
	public String showForm() {
		return "AlumnosForm";
	}
	
	@RequestMapping("/responseForm")
	public String responseForm() {
		return "RespAlumnosForm";
	}
	
	@RequestMapping("/responseForm02")
	//public String responseForm02(HttpServletRequest request, Model modelo) {
	public String responseForm02(@RequestParam("nombreAlumno") String nombre, Model modelo) {
		nombre += " tu puedes lograrlo";
		modelo.addAttribute("mensaje", nombre);
		return "RespAlumnosForm";
	}
}
