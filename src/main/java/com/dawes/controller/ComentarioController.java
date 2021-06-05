package com.dawes.controller;

import java.time.LocalDate;

import javax.management.modelmbean.ModelMBeanOperationInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.ComentarioVO;
import com.dawes.modelo.UsuarioVO;
import com.dawes.servicio.ComentarioServicio;
import com.dawes.servicio.RutinaServicio;
import com.dawes.servicio.UsuarioServicio;
import com.dawes.utils.Utils;

@Controller
public class ComentarioController {
	
	@Autowired
	private ComentarioServicio cs;
	
	@Autowired
	private UsuarioServicio us;
	
	@Autowired
	private RutinaServicio rs;
	
	//Añadir comentario
	@PostMapping("/user/nuevo-comentario")
	public String nuevoComentario(@RequestParam(value = "idrutina") int idrutina, 
			@RequestParam(value = "cuerpo_mensaje") String cuerpo_mensaje, Model modelo) {
		
		try {
			UsuarioVO usuario = us.findByUsername(Utils.getLoggedUser()).get();		//Obtenemos el usuario loggeado
			
			//Creamos el comentario
			ComentarioVO comentario = new ComentarioVO();
			comentario.setDescripcion(cuerpo_mensaje.trim());
			comentario.setUsuario(usuario);
			comentario.setFcreacion(LocalDate.now());
			comentario.setRutina(rs.findById(idrutina).get());
			cs.save(comentario);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "redirect:/user/detalle-rutina?idrutina=" + idrutina;			//Recargamos la página
	}
}