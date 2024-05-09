package com.training.pizza.persistance.repository.impl;

import com.training.pizza.persistance.crud.PizzaCustomerCrudRepository;
import com.training.pizza.persistance.entity.PizzaCustomerModel;
import com.training.pizza.persistance.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DefaultCustomerRepository implements CustomerRepository {

    @Autowired
    Environment environment;

    @Autowired
    private PizzaCustomerCrudRepository crudRepository;

    @Override
    public Optional<List<PizzaCustomerModel>> get(String id, String email, String name) {
        return crudRepository.findByIdAndEmailAndName(id, email, name);
    }

    @Override
    public Optional<PizzaCustomerModel> get(String id) {
        return crudRepository.findById(id);
    }

    @Override
    public Optional<Boolean> update(PizzaCustomerModel customerModel) {
        var value = crudRepository.update(customerModel).orElse(0);
        Boolean simulatedError = environment.getProperty("customer.repository.simulated.error", Boolean.class, Boolean.FALSE);
        if (simulatedError)
            throw new RuntimeException("Error after updated data");
        return Optional.of(value > 0 ? Boolean.TRUE : Boolean.FALSE);
    }
}
