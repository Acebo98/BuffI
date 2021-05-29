package com.dawes.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		modelo.addAttribute("username", usuario.getNombre());
		modelo.addAttribute("usuario", usuario);
		
		return "user/perfil";
	}
	
	//Modificamos el perfil
	@PostMapping("/user/modificar-perfil")
	public String modificarPerfil(@RequestParam(value = "email", required = false) String email, 
			@RequestParam(value = "fnacimiento", required = false) String fnacimiento, 
			@RequestParam(value = "localidad", required = false) String localidad,
			@RequestParam(value = "idusuario", required = false) String idusuario, Model modelo) {
		UsuarioVO usuario = us.findByIdusuario(Integer.parseInt(idusuario)).get();
		usuario.setEmail(email);
		if (Utils.isStringFullEmpty(fnacimiento) == true) {		//Miramos si el usuario ha querido introducir fecha...
			usuario.setFnacimiento(LocalDate.parse(fnacimiento));
			usuario.setFnacimientostring(fnacimiento);
		}
		else {
			usuario.setFnacimiento(null);
			usuario.setFnacimientostring("");
		}
		usuario.setLocalidad(localidad);
		us.save(usuario);		//Modificamos
		
		return "redirect:/user/mi-perfil";
	}	
}