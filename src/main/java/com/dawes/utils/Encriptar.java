package com.dawes.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encriptar {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.print(encoder.encode("pescador98"));
	}
}