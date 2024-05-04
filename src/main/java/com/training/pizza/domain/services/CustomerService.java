package com.training.pizza.domain.services;

import com.training.pizza.domain.dtos.CustomerDTO;

public interface CustomerService {

    /**
     * Get a Customer by id or email or name or all around
     * @param id String, Customer identifier
     * @param email String, Customer email
     * @param name String, Customer name
     * @return Customer DTO
     */
    CustomerDTO get(String id, String email, String name);

}
