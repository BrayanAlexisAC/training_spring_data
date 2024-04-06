package com.training.pizza.persistance.crud;

import com.training.pizza.persistance.entity.PizzaModel;
import org.springframework.data.repository.ListCrudRepository;

public interface PizzaCrudRepository extends ListCrudRepository<PizzaModel, Integer> {
    // Method queries
}
