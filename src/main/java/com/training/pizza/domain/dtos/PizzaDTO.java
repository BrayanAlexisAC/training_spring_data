package com.training.pizza.domain.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PizzaDTO {

    private int idPizza;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private double price;

    private boolean vegetarian;

    private boolean vegan;

    @NotNull
    private boolean available;

    @Null
    private String message;

}
