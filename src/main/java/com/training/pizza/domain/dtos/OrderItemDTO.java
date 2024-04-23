package com.training.pizza.domain.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OrderItemDTO {

    private int idPizza;

    private int idItem;

    @Positive
    private double quantity;

    @Positive
    private double price;

    private PizzaDTO pizza;

}
