package com.training.pizza.persistance.repository.impl;

import com.training.pizza.persistance.crud.PizzaCustomerCrudRepository;
import com.training.pizza.persistance.entity.PizzaCustomerModel;
import com.training.pizza.persistance.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DefaultCustomerRepository implements CustomerRepository {

    @Autowired
    private PizzaCustomerCrudRepository crudRepository;

    @Override
    public Optional<List<PizzaCustomerModel>> get(String id, String email, String name) {
        return crudRepository.findByIdAndEmailAndName(id, email, name);
    }
}
