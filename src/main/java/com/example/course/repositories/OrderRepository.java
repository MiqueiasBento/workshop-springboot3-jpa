package com.example.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course.entities.Order;

// Realiza operacoes com a entidade Order
public interface OrderRepository extends JpaRepository<Order, Integer>{
	
}
