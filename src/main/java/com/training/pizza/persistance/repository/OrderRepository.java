package com.training.pizza.persistance.repository;

import com.training.pizza.persistance.entity.PizzaOrderModel;
import com.training.pizza.persistance.projection.PizzaOrderSummary;

import java.time.LocalDate;
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

    /**
     * Get back all orders before a date
     * @param date LocalDate
     * @return Optional<List>
     */
    Optional<List<PizzaOrderModel>> getOrdersBeforeDate(LocalDate date);

    /**
     * Get Back all orders between two dates
     * @param firstDate LocalDate
     * @param secondDate LocalDate
     * @return Optional<LIst>
     */
    Optional<List<PizzaOrderModel>> getOrdersByRange(LocalDate firstDate, LocalDate secondDate);

    /**
     * Get an order summary
     * @param idOrder Integer, order identifier
     * @return Optional<PizzaOrderSummary>
     */
    Optional<PizzaOrderSummary> getSummary(Integer idOrder);
}
