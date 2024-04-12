package com.training.pizza.persistance.crud;

import com.training.pizza.persistance.entity.PizzaOrderModel;
import org.springframework.data.repository.ListCrudRepository;

public interface PizzaOrderCrudRepository extends ListCrudRepository<PizzaOrderModel, Integer> {
    // Method queries
}
