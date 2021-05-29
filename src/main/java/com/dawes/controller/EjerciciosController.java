package com.dawes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.servicio.EjercicioServicio;
import com.dawes.servicio.RutinaServicio;

@Controller
public class EjerciciosController {
	
	@Autowired
	private RutinaServicio rs;
	
	@Autowired
	private EjercicioServicio es;
	
	//Asignamos los ejercicios a la rutina
	@GetMapping("/user/asignar-ejercicios")
	public String asignarEjercicios(@RequestParam(value = "idrutina") int idrutina, Model modelo) {
		modelo.addAttribute("rutina", rs.findById(idrutina).get());
		return "user/asignar-ejercicios";
	}
}