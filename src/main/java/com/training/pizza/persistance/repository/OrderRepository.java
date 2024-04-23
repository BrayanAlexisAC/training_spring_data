package com.training.pizza.persistance.repository;

import com.training.pizza.persistance.entity.PizzaOrderModel;

import java.time.LocalDateTime;
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

    /**
     * Get back all current orders
     * @param date LocalDateTime
     * @return Optional<List>
     */
    Optional<List<PizzaOrderModel>> getCurrentOrders(LocalDateTime date);
}
