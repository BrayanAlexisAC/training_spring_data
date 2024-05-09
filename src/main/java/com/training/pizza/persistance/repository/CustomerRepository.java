package com.training.pizza.persistance.repository;

import com.training.pizza.persistance.entity.PizzaCustomerModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    /**
     * Get a Customer's List by id or email or name or all around
     * @param id String, Customer identifier
     * @param email String, Customer email
     * @param name String, Customer name
     * @return Customer Model
     */
    Optional<List<PizzaCustomerModel>> get(String id, String email, String name);

    /**
     * Get Customer by Identifier
     * @param id String, Customer identifier
     * @return PizzaCustomerModel, Customer entity
     */
    Optional<PizzaCustomerModel> get(String id);

    /**
     * Update Customer information
     * @param customerModel CustomerModel, Entity to update all information, make sure to get current information before
     * @return Optional<Boolean>, true = updated, false = no updated
     */
    @Transactional
    Optional<Boolean> update(PizzaCustomerModel customerModel);
}
