package com.dawes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.RutinaVO;
import com.dawes.modelo.UsuarioVO;
import com.dawes.servicio.RutinaServicio;
import com.dawes.servicio.UsuarioServicio;
import com.dawes.utils.Utils;

/*
 * CONTROLADOR PARA LAS RUTINAS
 */

@Controller
public class RutinasController {
	
	@Autowired
	private RutinaServicio rs;
	
	@Autowired
	private UsuarioServicio us;
	
	//Mostramos las rutinas
	@GetMapping("/buscar-rutinas")
	public String rutinas(Model modelo, @RequestParam(value = "nombre-filtrar", required = false) String nombre, 
			@RequestParam(value = "filtro", required = false) String filtro) {
		List<RutinaVO> rutinas = (List<RutinaVO>) rs.findAll();		//Leemos todas las rutinas
		
		//Filtramos (primero por fecha y después por el nombre)
		if (filtro != null) {
			switch(filtro) {
				case "1": rutinas = (List<RutinaVO>) rs.findAllByOrderByFcreacionDesc();	//Recientes
					break;
				case "2": rutinas = (List<RutinaVO>) rs.findAllByOrderByFcreacionAsc();		//Antiguos
					break;
			}
		}
		if (nombre != null && Utils.isStringFullEmpty(nombre)) {
			rutinas = (List<RutinaVO>) rs.findByNombres(nombre.trim());
		}
		
		modelo.addAttribute("rutinas", rutinas);	
		return "buscar-rutinas";
	}
	
	//Mis rutinas
	@GetMapping("/user/mis-rutinas")
	public String misRutinas(Model modelo) {
		UsuarioVO usuario = us.findByUsername(Utils.getLoggedUser()).get();		//Usuario loggeado
		List<RutinaVO> rutinas = (List<RutinaVO>) rs.findByUsuario(usuario);	//Rutinas del usuario loggeado
		
		modelo.addAttribute("rutinas", rutinas);
		return "user/mis-rutinas";
	}
	
	//Nueva rutina
	@GetMapping("/user/nueva-rutina")
	public String nuevaRutina(Model modelo) {
		return "user/nueva-rutina";
	}
}