package com.springlambda.controllers;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.springlambda.model.Order;
import com.springlambda.repository.OrderRepository;

@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

	@Bean
	public Supplier<List<Order>> orders() {
		return () -> orderRepository.buildOrders();
	}

	@Bean
	public Function<APIGatewayProxyRequestEvent, List<Order>> findOrderByName() {

		return (requestEvent) -> orderRepository.buildOrders().stream()
				.filter(order -> order.getName().equals(requestEvent.getQueryStringParameters().get("orderName")))
				.collect(Collectors.toList());
	}

}
