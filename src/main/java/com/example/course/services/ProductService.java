package com.example.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.entities.Product;
import com.example.course.repositories.ProductRepository;

@Service	// Registro como componente de servico do Spring, para o uso do Autowired
public class ProductService {
	
	@Autowired	// Para injecao de dependencia
	private ProductRepository orderRepository;
	
	public List<Product> findAll() {
		return orderRepository.findAll();
	}
	
	public Product findById(Integer id) {
		Optional<Product> obj = orderRepository.findById(id);
		return obj.get();
	}
}
