package com.springlambda.repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.springlambda.model.Order;

@Repository
public class OrderRepository {

	
	public List<Order> buildOrders()
	{
		return Stream.of(
				new Order(1, "Mobile", 2000, 1),
				new Order(2, "TV", 9000, 3),
				new Order(3, "Camera", 5000, 5),
				new Order(4, "Dress", 7000, 2),
				new Order(5, "Laptop", 4000, 6)).collect(Collectors.toList());
		
		
	}
	
}
