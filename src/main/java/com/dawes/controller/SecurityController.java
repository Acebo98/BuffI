package com.dawes.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.UsuarioVO;
import com.dawes.servicio.ComentarioServicio;
import com.dawes.servicio.RolServicio;
import com.dawes.servicio.RutinaEjercicioServicio;
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
	
	@Autowired
	private RutinaEjercicioServicio res;
	
	@Autowired
	private ComentarioServicio cs;
	
	//Iniciar sesión
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	//Registro
	@GetMapping("/sign-up")
	public String signup(@RequestParam(value = "error", required = false) String error, Model modelo) {
		modelo.addAttribute("error", error);
		return "sign-up";
	}

	//Nos desconectamos y nos movemos a la página de login
	@GetMapping("/logout")
	public String logout() {
		return "login";
	}
	
	//Método para registrarse
	@PostMapping("/sign-up")
	public String registrarse(@RequestParam(value = "email") String email, @RequestParam(value = "username") String username, 
			@RequestParam(value = "password") String password, Model modelo) {
		try {
			UsuarioVO nusuario = new UsuarioVO();
			nusuario.setEmail(email.trim());
			nusuario.setNombre(username.trim());
			nusuario.setContrasena(Utils.encriptar(password));
			nusuario.setFcreacion(LocalDate.now());					//Fecha de creación hoy 	
			nusuario.setRol(rs.findByNombre("ROLE_USER").get()); 	//Rol de usuario normal
			us.save(nusuario);
			
			return "redirect:/login";
		}
		catch(Exception e) {
			System.out.println(e.getMessage());

			return "redirect:/sign-up?error";
		}
	}
	
	//Página de administración
	@GetMapping("/admin/administracion")
	public String administracion(@RequestParam(value = "fechaantes", required = false) String fechaantes, 
			@RequestParam(value = "fechadespues", required = false) String fechadespues, Model modelo) {
		List<UsuarioVO> usuarios = List.of();
		
		//Filtramos
		if (fechaantes != null && fechadespues != null) {
			usuarios = (List<UsuarioVO>) us.findByFcreacionBetween(LocalDate.parse(fechaantes), LocalDate.parse(fechadespues));
		}
		else {
			usuarios = (List<UsuarioVO>) us.findAll();
		}
		
		modelo.addAttribute("usuarios", usuarios);
		return "admin/administracion";
	}
	
	//El admin eliminar la asignación
	@GetMapping("/admin/eliminar-asignacion")
	public String eliminarAsignacion(@RequestParam(value = "idrutina") int idrutina, 
			@RequestParam(value = "idrutinaejercicio") int idrutinaejercicio) {	
		res.deleteById(idrutinaejercicio);
		
		return "redirect:/user/detalle-rutina?idrutina=" + idrutina;
	}
	
	//El admin elimina un comentario
	@GetMapping("/admin/eliminar-comentario")
	public String eliminarComentario(@RequestParam(value = "idrutina") int idrutina, 
			@RequestParam(value = "idcomentario") int idcomentario) {	
		cs.deleteById(idcomentario);
		
		return "redirect:/user/detalle-rutina?idrutina=" + idrutina;
	}
	
	//El admin ve las rutinas de un usuario
	@GetMapping("/admin/ver-rutinas")
	public String verRutinas(@RequestParam(value = "idusuario") int idusuario, Model modelo) {
		UsuarioVO usuario = us.findById(idusuario).get();		//Sacamos al usuario
		modelo.addAttribute("usuario", usuario);
		
		return "admin/ver-rutinas";
	}
}