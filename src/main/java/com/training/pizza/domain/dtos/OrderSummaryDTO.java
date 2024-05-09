package com.training.pizza.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class OrderSummaryDTO {
    @Positive
    private int idOrder;
    @NotBlank
    private String customerName;
    @NotBlank
    private LocalDateTime createdDate;
    @Positive
    private double total;
    @NotBlank
    private String pizzaNames;
}
