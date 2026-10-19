package com.example.ordermanagement.dto;

public record OrderResponse(
        Long id,
        String product,
        Integer quantity,
        Double price
) {
}