package com.training.pizza.persistance.crud;

import com.training.pizza.persistance.entity.PizzaOrderModel;
import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PizzaOrderCrudRepository extends ListCrudRepository<PizzaOrderModel, Integer> {

    /**
     * Get Back all orders with methods in the list
     * @param lstMethod List<String>
     * @return Optional<List>
     */
    Optional<List<PizzaOrderModel>> findAllByMethodIn(List<String> lstMethod);

    /**
     * Get Back all orders created today and after
     * @param date LocalDateTime
     * @return Optional<List>
     */
    Optional<List<PizzaOrderModel>> findAllByCreatedDateAfter(LocalDateTime date);

    /**
     * Get Back all orders created before a date
     * @param date LocalDateTime
     * @return Optional<List>
     */
    Optional<List<PizzaOrderModel>> findAllByCreatedDateBefore(LocalDateTime date);

    /**
     * Get Back all orders between two dates
     * @param firstDate LocalDateTime
     * @param secondDate LocalDateTime
     * @return Optional<List>
     */
    Optional<List<PizzaOrderModel>> findAllByCreatedDateBetween(LocalDateTime firstDate, LocalDateTime secondDate);
}
