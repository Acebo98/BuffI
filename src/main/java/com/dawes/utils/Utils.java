package com.dawes.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Utils {
	
	//Leemos una imagen y la pasamos a bits
	public static byte[] readImage(String ruta) throws IOException {
		File f = new File(ruta);
		InputStream is = new FileInputStream(f);
		byte[] buffer = null;
		try {		
			buffer = new byte[(int) f.length()];
			is.read(buffer);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			is.close();
		}
		return buffer;
	}
	
	//Encriptar
	public static String encriptar(String contraseña) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(contraseña);
	}
	
	//Validamos que una String no sea completamente vacia
	public static boolean isStringFullEmpty(String string) {
		return !string.isBlank() && !string.isEmpty();
	}
	
	//Obtenemos el usuario registrado
	public static String getLoggedUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}
}