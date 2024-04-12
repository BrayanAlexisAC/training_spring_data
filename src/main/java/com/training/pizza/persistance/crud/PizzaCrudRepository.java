package com.training.pizza.persistance.crud;

import com.training.pizza.persistance.entity.PizzaModel;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface PizzaCrudRepository extends ListCrudRepository<PizzaModel, Integer> {

    /**
     * Get back a list of pizzas available sorted by price
     * @return Optional<List>
     */
    Optional<List<PizzaModel>> findAllByAvailableTrueOrderByPrice();

}
