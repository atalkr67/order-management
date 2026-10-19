package com.example.ordermanagement.service;

import com.example.ordermanagement.dto.CreateOrderRequest;
import com.example.ordermanagement.dto.OrderResponse;
import com.example.ordermanagement.entity.Order;
import com.example.ordermanagement.exception.ResourceNotFoundException;
import com.example.ordermanagement.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderResponse createOrder(CreateOrderRequest request){
        Order order = new Order(
                request.product(),
                request.quantity(),
                request.price()
        );

        Order saveOrder = orderRepository.save(order);

        return new OrderResponse(
                saveOrder.getId(),
                saveOrder.getProduct(),
                saveOrder.getQuantity(),
                saveOrder.getPrice()
        );
    }

    public OrderResponse getOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() ->
                            new ResourceNotFoundException(
                                    "Order not found: " + id
                            )
                        );

        return new OrderResponse(
                order.getId(),
                order.getProduct(),
                order.getQuantity(),
                order.getPrice()
        );
    }
}
