package com.dawes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * CONTROLADOR PARA MAPEAR LAS VISTAS DE LOS ERRORES
 */

@Controller
public class ErrorController {

	//Error 404
	@GetMapping("/404")
	public String error404() {
		return "error/404";
	}
	
	//Error 403
	@GetMapping("/403")
	public String error403() {
		return "error/403";
	}
}