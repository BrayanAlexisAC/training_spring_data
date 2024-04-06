package com.training.pizza.domain.services;

import com.training.pizza.domain.dtos.PizzaDTO;

import java.util.List;

public interface PizzaService {

    /**
     * Get back all available pizzas
     * @return List<PizzaDTO>
     */
    List<PizzaDTO> getAllAvailable();

    /**
     * Get back all pizzas
     * @return List<PizzaDTO>
     */
    List<PizzaDTO> getAll();

}
