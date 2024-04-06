package com.training.pizza.domain.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PizzaDTO {

    private int idPizza;

    private String name;

    private String description;

    private double price;

    private boolean vegetarian;

    private boolean vegan;

    private boolean available;

}
