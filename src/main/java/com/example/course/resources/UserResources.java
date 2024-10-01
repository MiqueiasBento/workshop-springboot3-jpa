package com.example.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.entities.User;

@RestController		//Define que esta classe é um controlador REST.
@RequestMapping(value = "/users")	//Mapeia a URL base "/users" para esse controlador.
public class UserResources {

	@GetMapping		// Mapeia requisições GET para o método abaixo.
	public ResponseEntity<User> findAll() {
		// Método que retorna um objeto User dentro de um ResponseEntity.

		User u = new User(1, "Maria", "maria@gmail.com", "9999-9999", "12345");
		return ResponseEntity.ok().body(u);		// Retorna uma resposta 200 OK com o usuário no corpo.
	}
}
