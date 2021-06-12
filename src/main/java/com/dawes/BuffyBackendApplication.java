package com.dawes;

import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuffyBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuffyBackendApplication.class, args);
		//Persistence.generateSchema("jpa", null);
	}
}