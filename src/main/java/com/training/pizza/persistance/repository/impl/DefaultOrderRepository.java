package com.training.pizza.persistance.repository.impl;

import com.training.pizza.persistance.crud.PizzaOrderCrudRepository;
import com.training.pizza.persistance.entity.PizzaOrderModel;
import com.training.pizza.persistance.projection.PizzaOrderSummary;
import com.training.pizza.persistance.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Override
    public Optional<List<PizzaOrderModel>> getByMethod(List<String> lstMethod) {
        return crudRepository.findAllByMethodIn(lstMethod);
    }

    @Override
    public Optional<List<PizzaOrderModel>> getCurrentOrders(LocalDateTime date) {
        return crudRepository.findAllByCreatedDateAfter(date);
    }

    @Override
    public Optional<List<PizzaOrderModel>> getOrdersBeforeDate(LocalDate date) {
        return crudRepository.findAllByCreatedDateBefore(date.atTime(0,0));
    }

    @Override
    public Optional<List<PizzaOrderModel>> getOrdersByRange(LocalDate firstDate, LocalDate secondDate) {
        return crudRepository.findAllByCreatedDateBetween(firstDate.atTime(0,0), secondDate.atTime(0,0));
    }

    @Override
    public Optional<PizzaOrderSummary> getSummary(Integer idOrder) {
        return crudRepository.findOrderSummary(idOrder);
    }

}
