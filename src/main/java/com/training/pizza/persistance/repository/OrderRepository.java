package com.training.pizza.persistance.repository;

import com.training.pizza.persistance.entity.PizzaOrderModel;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    /**
     * Get Back All orders
     * @return Optional<List>
     */
    Optional<List<PizzaOrderModel>> getAll();

}
