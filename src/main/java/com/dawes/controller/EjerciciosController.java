package com.dawes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.EjercicioVO;
import com.dawes.modelo.RutinaEjercicioVO;
import com.dawes.modelo.RutinaVO;
import com.dawes.servicio.EjercicioServicio;
import com.dawes.servicio.RutinaEjercicioServicio;
import com.dawes.servicio.RutinaServicio;

@Controller
public class EjerciciosController {
	
	@Autowired
	private RutinaServicio rs;
	
	@Autowired
	private EjercicioServicio es;
	
	@Autowired
	private RutinaEjercicioServicio res;
	
	//Asignamos los ejercicios a la rutina
	@GetMapping("/user/asignar-ejercicios")
	public String asignarEjercicios(@RequestParam(value = "idrutina") int idrutina, Model modelo) {
		modelo.addAttribute("rutina", rs.findById(idrutina).get());
		modelo.addAttribute("ejercicios", es.findAll());
		
		return "user/asignar-ejercicios";
	}
	
	//Asignamos un ejercicio a la rutina
	@PostMapping("/user/submit-ejercicio")
	public String submitEjercicio(@RequestParam(value = "idrutina") int idrutina, 
			@RequestParam(value = "nombre-ejercicio") String nombre_ejercicio, 
			@RequestParam(value = "descripcion") String descripcion, Model modelo) {
		
		try {
			RutinaVO rutina = rs.findById(idrutina).get();
			EjercicioVO ejercicio = es.findByNombre(nombre_ejercicio).get();
			
			//Asignación
			RutinaEjercicioVO asignacion = new RutinaEjercicioVO();
			asignacion.setDescripcion(descripcion.trim());
			asignacion.setEjercicio(ejercicio);
			asignacion.setRutina(rutina);
			res.save(asignacion);
			
			return "redirect:/user/modificar-rutina?idrutina=" + idrutina;

		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return "redirect:/user/asignar-ejercicios?idrutina=" + idrutina;
		}		
	}
	
	//Eliminamos la asignación
	@GetMapping("/user/eliminar-asignacion")
	public String eliminarAsignacion(@RequestParam(value = "idrutina") int idrutina, 
			@RequestParam(value = "idrutinaejercicio") int idrutinaejercicio) {	
		res.deleteById(idrutinaejercicio);
		
		return "redirect:/user/modificar-rutina?idrutina=" + idrutina;
	}
}