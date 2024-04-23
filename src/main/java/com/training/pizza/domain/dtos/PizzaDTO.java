package com.training.pizza.domain.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PizzaDTO {

    private int idPizza;

    @NotBlank(message = "Name cannot be null or empty")
    private String name;

    private String description;

    @Positive(message = "Price cannot be null or negative")
    private double price;

    private boolean vegetarian;

    private boolean vegan;

    @NotNull(message = "Available cannot be null or empty")
    private boolean available;

    @Null(message = "Please don't use message is exclusive for information")
    private String message;

}
