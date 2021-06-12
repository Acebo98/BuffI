package com.dawes.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * CONTROLADOR PARA MAPEAR LAS VISTAS DE LOS ERRORES
 */

@Controller
public class ErrorsController implements ErrorController {

	//Error 404
	@GetMapping("/404")
	public String error404() {
		return "error/404";
	}
	
	//Error 403
	@GetMapping("/403")
	public String error403() {
		return "error/403";
	}
	
	//Errores
	@RequestMapping("/error")
	public String error(HttpServletRequest request) {
	    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	    
	    if (status != null) {
	        Integer statusCode = Integer.valueOf(status.toString());
	    
	        if(statusCode == HttpStatus.NOT_FOUND.value()) {
	            return "error/404";
	        }
	    }
	    return "error";
	}
}