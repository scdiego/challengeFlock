package com.flockit.ejercicio;

import com.flockit.ejercicio.entities.User;
import com.flockit.ejercicio.repositories.LoginRepo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EjercicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioApplication.class, args);
	}

	@Bean
	public CommandLineRunner populateDB(LoginRepo repo) {
		
		return args -> {
			User usuario = new User();
			usuario.setUsername("Ramiel");
			usuario.setPassword("elventrue");	
			repo.save(usuario);
		};
	}

}
