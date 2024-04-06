package com.training.pizza.persistance.repository;

import com.training.pizza.persistance.entity.PizzaModel;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository {

    /**
     * Get back all available pizzas
     * @return Optional<List>
     */
    Optional<List<PizzaModel>> getAllAvailable();

    /**
     * get back all pizzas
     * @return Optional<List>
     */
    Optional<List<PizzaModel>> getAll();

    /**
     * Get Pizza by ID
     * @param idPizza int
     * @return PizzaModel
     */
    Optional<PizzaModel> getById(int idPizza);
}
