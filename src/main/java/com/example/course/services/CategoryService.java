package com.example.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.entities.Category;
import com.example.course.repositories.CategoryRepository;

@Service	// Registro como componente de servico do Spring, para o uso do Autowired
public class CategoryService {
	
	@Autowired	// Para injecao de dependencia
	private CategoryRepository repository;
	
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category findById(Integer id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}
