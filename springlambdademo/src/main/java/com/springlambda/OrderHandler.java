package com.springlambda;

import java.util.List;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.springlambda.model.Order;

public class OrderHandler extends SpringBootRequestHandler<APIGatewayProxyRequestEvent, List<Order>> {

}
