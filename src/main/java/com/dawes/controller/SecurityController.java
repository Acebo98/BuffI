package com.dawes.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.UsuarioVO;
import com.dawes.servicio.RolServicio;
import com.dawes.servicio.UsuarioServicio;
import com.dawes.utils.Utils;

/*
 * CONTROLADOR PARA LAS VISTAS DE INICIO DE SESIÓN/REGISTRO
 */

@Controller
public class SecurityController {
	
	@Autowired
	private UsuarioServicio us;
	
	@Autowired
	private RolServicio rs;
	
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
	
	//Método para registrarse
	@PostMapping("/registrarse")
	public String registrarse(@RequestParam(value = "email") String email, @RequestParam(value = "username") String username, 
			@RequestParam(value = "password") String password, Model modelo) {
		UsuarioVO nusuario = new UsuarioVO();
		nusuario.setEmail(email);
		nusuario.setNombre(username);
		nusuario.setContrasena(Utils.encriptar(password));
		nusuario.setFcreacion(LocalDate.now());					//Fecha de creación hoy 	
		nusuario.setRol(rs.findByNombre("ROLE_USER").get()); 	//Rol de usuario normal
		us.save(nusuario);
		return "redirect:/buscar-rutinas";
	}
}