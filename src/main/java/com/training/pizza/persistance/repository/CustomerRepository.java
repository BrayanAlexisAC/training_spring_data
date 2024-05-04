package com.training.pizza.persistance.repository;

import com.training.pizza.persistance.entity.PizzaCustomerModel;

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

}
