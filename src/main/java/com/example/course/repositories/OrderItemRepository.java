package com.example.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course.entities.OrderItem;
import com.example.course.entities.pk.OrderItemPK;

// Realiza operacoes com a entidade OrderItem
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{
	
}
