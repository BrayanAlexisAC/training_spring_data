package com.training.pizza.persistance.crud;

import com.training.pizza.persistance.entity.PizzaOrderModel;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface PizzaOrderCrudRepository extends ListCrudRepository<PizzaOrderModel, Integer> {

    /**
     * Get Back all orders with methods in the list
     * @param lstMethod List<String>
     * @return Optional<List>
     */
    Optional<List<PizzaOrderModel>> findAllByMethodIn(List<String> lstMethod);

}
