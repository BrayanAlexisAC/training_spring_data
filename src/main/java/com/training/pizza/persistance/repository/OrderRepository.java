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

    /**
     * Get back all orders with methods in list
     * @param lstMethod List<String>
     * @return Optional<List>
     */
    Optional<List<PizzaOrderModel>> getByMethod(List<String> lstMethod);
}
