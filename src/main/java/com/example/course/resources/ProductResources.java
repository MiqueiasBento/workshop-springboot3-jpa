package com.example.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.entities.Product;
import com.example.course.services.ProductService;

@RestController		//Define que esta classe é um controlador REST.
@RequestMapping(value = "/products")	//Mapeia a URL base "/prodcuct" para esse controlador.
public class ProductResources {
	
	@Autowired		// Injecao de dependencia
	private ProductService service;
	
	@GetMapping		// Mapeia requisições GET para o método abaixo.
	public ResponseEntity<List<Product>> findAll() {
		// Método que retorna um objeto Product dentro de um ResponseEntity.
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);		// Retorna uma resposta 200 OK com o usuário no corpo.
	}
	
	@GetMapping(value = "/{id}")	// Mapeia o novo caminho de url para o metodo
	public ResponseEntity<Product> findById(@PathVariable Integer id) {	// PathVariable para aceitar o parametro como url
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
