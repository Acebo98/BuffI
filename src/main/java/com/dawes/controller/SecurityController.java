package com.dawes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * CONTROLADOR PARA LAS VISTAS DE INICIO DE SESIÓN/REGISTRO
 */

@Controller
public class SecurityController {
	
	//Iniciar sesión
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	//Registro
	@GetMapping("/sign-up")
	public String signup() {
		return "sign-up";
	}

	//Nos desconectamos y nos movemos a la página de login
	@GetMapping("/logout")
	public String logout() {
		return "login";
	}
}