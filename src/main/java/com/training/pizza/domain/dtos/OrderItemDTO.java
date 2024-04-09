package com.training.pizza.domain.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderItemDTO {

    private int idPizza;

    private int idItem;

    private double quantity;

    private double price;

    private PizzaDTO pizza;

}
