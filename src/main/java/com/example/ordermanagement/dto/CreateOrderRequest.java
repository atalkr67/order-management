package com.example.ordermanagement.dto;

import jakarta.validation.constraints.*;

public record CreateOrderRequest(

        @NotBlank
        String product,

        @Min(1)
        Integer quantity,

        @Positive
        Double price
) {
}
