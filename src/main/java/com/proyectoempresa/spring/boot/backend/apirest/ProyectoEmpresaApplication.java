package com.proyectoempresa.spring.boot.backend.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ProyectoEmpresaApplication implements CommandLineRunner {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoEmpresaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		String pass = "12345";
		for(int i = 0; i < 4; i++) {
			String passwordBcrypt = passwordEncoder.encode(pass);
			System.out.println(passwordBcrypt);
		}
		
	}

}
