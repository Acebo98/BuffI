package com.dawes.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.EtiquetaVO;
import com.dawes.modelo.RutinaVO;
import com.dawes.modelo.UsuarioVO;
import com.dawes.servicio.EtiquetaServicio;
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
	
	@Autowired
	private EtiquetaServicio es;
	
	//Mostramos las rutinas
	@GetMapping("/")
	public String rutinas(Model modelo, @RequestParam(value = "nombre-filtrar", required = false) String nombre, 
			@RequestParam(value = "filtro", required = false) String filtro) {
		String user = Utils.getLoggedUser();						//String del usuario registrado
		List<RutinaVO> rutinas = (List<RutinaVO>) rs.findAll();		//Leemos todas las rutinas
		
		modelo.addAttribute("username", user);
		modelo.addAttribute("rutinas", rutinas);	
		return "buscar-rutinas";
	}
	
	//Filtramos las rutinas
	@GetMapping("/buscar-rutinas")
	public String buscarRutinas(Model modelo, @RequestParam(value = "nombre-filtrar", required = false) String nombre, 
			@RequestParam(value = "filtro", required = false) String filtro) {
		String user = Utils.getLoggedUser();						//String del usuario registrado
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
		
		modelo.addAttribute("username", user);
		modelo.addAttribute("rutinas", rutinas);	
		return "buscar-rutinas";
	}
	
	//Mis rutinas
	@GetMapping("/user/mis-rutinas")
	public String misRutinas(Model modelo, @RequestParam(value = "filtro", required = false) String filtro) {
		String user = Utils.getLoggedUser();		//String del usuario registrado
		List<RutinaVO> lectura = List.of();			//Iniciamos la lista
		
		//Filtro
		if (filtro != null) {
			switch(filtro) {
				case "1": lectura = (List<RutinaVO>) rs.findAllByOrderByFcreacionDesc();
					break;
				case "2": lectura = (List<RutinaVO>) rs.findAllByOrderByFcreacionAsc();
					break;
			}
			
			//Filtramos por el nombre
			lectura = lectura.stream().filter(r -> r.getUsuario().getNombre().equals(user)).collect(Collectors.toList());
		}
		else {
			lectura = (List<RutinaVO>) (List<RutinaVO>) rs.findByUsuario(us.findByUsername(user).get());	//Leemos TODAS
		}
		
		modelo.addAttribute("username", user);
		modelo.addAttribute("rutinas", lectura);
		return "user/mis-rutinas";
	}
	
	//Formulario de nueva rutina
	@GetMapping("/user/nueva-rutina")
	public String nuevaRutina(Model modelo) {
		List<EtiquetaVO> etiquetas = (List<EtiquetaVO>) es.findAll();
		
		modelo.addAttribute("etiquetas", etiquetas);
		return "user/nueva-rutina";
	}
	
	//Introducimos la nueva rutina
	@PostMapping("/user/submit-rutina")
	public String insertarRutina(@RequestParam(value = "nombre") String nombre, 
			@RequestParam(value = "etiqueta") String etiqueta, 
			@RequestParam(value = "descripcion") String descripcion, 
			Model modelo) {
		UsuarioVO usuario = us.findByUsername(Utils.getLoggedUser()).get();		//Usuario loggeado
		EtiquetaVO etiquetavo = es.findByNombre(etiqueta).get();					//Etiqueta
		
		//Datos de la nueva rutina
		RutinaVO rutina = new RutinaVO();
		rutina.setNombre(nombre);
		rutina.setDescripcion(descripcion);
		rutina.setEtiqueta(etiquetavo);
		rutina.setFcreacion(LocalDate.now());
		rutina.setUsuario(usuario);
		rs.save(rutina);
		
		return "redirect:/user/mis-rutinas";
	}
	
	//Eliminamos la rutina
	@GetMapping("/user/eliminar-rutina")
	public String eliminarRutina(int idrutina) {
		rs.delete(rs.findById(idrutina).get());
		return "redirect:/user/mis-rutinas";
	}
	
	//Detalla de la rutina
	@GetMapping("/user/detalle-rutina")
	public String detalleRutina(int idrutina, Model modelo) {
		RutinaVO rutina = rs.findById(idrutina).get();
		modelo.addAttribute("rutina", rutina);
		
		return "user/detalle-rutina";
	}
	
	//Modificamos la rutina
	@GetMapping("/user/modificar-rutina")
	public String modificarRutina(int idrutina, Model modelo) {
		RutinaVO rutina = rs.findById(idrutina).get();
		modelo.addAttribute("rutina", rutina);
		modelo.addAttribute("etiquetas", es.findAll());
		
		return "user/modificar-rutina";
	}
	
	@PostMapping("/user/submit-modificar")
	public String submitModificar(@RequestParam(value = "idrutina") int idrutina, @RequestParam(value = "nombre") String nombre, 
			@RequestParam(value = "descripcion", required = false) String descripcion, @RequestParam(value = "etiqueta") String etiqueta) {
		RutinaVO rutina = rs.findById(idrutina).get();						//Rutina
		EtiquetaVO etiquetavo = es.findByNombre(etiqueta).get();			//Etiqueta
		
		//Modificamos
		rutina.setNombre(nombre);
		rutina.setDescripcion(descripcion);
		rutina.setEtiqueta(etiquetavo);
		rs.save(rutina);
		
		return "redirect:/user/modificar-rutina?idrutina=" + idrutina;
	}
}