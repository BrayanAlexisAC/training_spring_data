package com.training.pizza.persistance.repository.impl;

import com.training.pizza.persistance.crud.PizzaOrderCrudRepository;
import com.training.pizza.persistance.entity.PizzaOrderModel;
import com.training.pizza.persistance.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DefaultOrderRepository implements OrderRepository {

    @Autowired
    private PizzaOrderCrudRepository crudRepository;

    @Override
    public Optional<List<PizzaOrderModel>> getAll() {
        return Optional.of(crudRepository.findAll());
    }

}
