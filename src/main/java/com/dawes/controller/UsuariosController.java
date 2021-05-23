package com.dawes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dawes.modelo.UsuarioVO;
import com.dawes.servicio.UsuarioServicio;
import com.dawes.utils.Utils;

/*
 * CONTROLADOR PARA LAS TAREAS DE USUARIO 
 */

@Controller
public class UsuariosController {
	
	@Autowired
	private UsuarioServicio us;
	
	//Mostramos el perfil con los datos de usuario
	@GetMapping("/user/mi-perfil")
	public String miPerfil(Model modelo) {
		UsuarioVO usuario = us.findByUsername(Utils.getLoggedUser()).get();		//Obtenemos el usuario loggeado
		modelo.addAttribute("usuario", usuario);
		
		return "user/perfil";
	}
	
	//Modificamos el perfil
	
}