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

    /**
     * Get true if exist pizza or false if not exist
     * @param idPizza int
     * @return boolean
     */
    boolean existById(int idPizza);

    /**
     * Save or Update information about PizzaModel
     * @param pizza PizzaModel
     * @return PizzaModel
     */
    Optional<PizzaModel> save(PizzaModel pizza);
}
