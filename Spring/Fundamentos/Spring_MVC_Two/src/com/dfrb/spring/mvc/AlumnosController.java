package com.dfrb.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alumnos")
public class AlumnosController {
	@RequestMapping("/signIn")
	public String signIn(Model model) {
		Alumnos alumno = new Alumnos();
		model.addAttribute("alumno", alumno);
		return "signInForm";
	}
	
	@RequestMapping("/registeredForm")
	public String registeredForm(@ModelAttribute("alumno") Alumnos alumno) {
		return "registeredForm";
	}
}
