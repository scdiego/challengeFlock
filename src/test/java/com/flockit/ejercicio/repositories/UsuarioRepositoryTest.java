package com.flockit.ejercicio.repositories;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.flockit.ejercicio.entities.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsuarioRepositoryTest {    

    @Autowired
	LoginRepo usuarioRepository;

	@Test
	void getUsuarioByName() {
		User usuario = usuarioRepository.findByUsername("username");
		assertTrue(usuario.getPassword().equals("password1234"));
	}

	@Test
	void getUsuarioByNameFailed() {
		User usuario = usuarioRepository.findByUsername("username");
		assertFalse(usuario.getPassword().equals("contraseñaErronea"));
	}
	
}
