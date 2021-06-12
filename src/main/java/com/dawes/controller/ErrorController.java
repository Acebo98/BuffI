package com.dawes.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * CONTROLADOR PARA MAPEAR LAS VISTAS DE LOS ERRORES
 */

@Controller
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
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
	
	//Errores
	@RequestMapping("/error")
	public String error() {
		return "error";
	}
}