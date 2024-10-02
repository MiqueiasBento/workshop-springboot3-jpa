package com.example.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.entities.Category;
import com.example.course.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResources {

	@Autowired		// Injecao de dependencia
	private CategoryService service;
	
	@GetMapping		// Mapeia requisições GET para o método abaixo.
	public ResponseEntity<List<Category>> findAll() {
		// Método que retorna um objeto User dentro de um ResponseEntity.
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);		// Retorna uma resposta 200 OK com o usuário no corpo.
	}
	
	@GetMapping(value = "/{id}")	// Mapeia o novo caminho de url para o metodo
	public ResponseEntity<Category> findById(@PathVariable Integer id) {	// PathVariable para aceitar o parametro como url
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}