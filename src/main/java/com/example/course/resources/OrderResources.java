package com.example.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.entities.Order;
import com.example.course.services.OrderService;

@RestController		//Define que esta classe é um controlador REST.
@RequestMapping(value = "/orders")	//Mapeia a URL base "/users" para esse controlador.
public class OrderResources {
	
	@Autowired		// Injecao de dependencia
	private OrderService service;
	
	@GetMapping		// Mapeia requisições GET para o método abaixo.
	public ResponseEntity<List<Order>> findAll() {
		// Método que retorna um objeto User dentro de um ResponseEntity.
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);		// Retorna uma resposta 200 OK com o usuário no corpo.
	}
	
	@GetMapping(value = "/{id}")	// Mapeia o novo caminho de url para o metodo
	public ResponseEntity<Order> findById(@PathVariable Integer id) {	// PathVariable para aceitar o parametro como url
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
