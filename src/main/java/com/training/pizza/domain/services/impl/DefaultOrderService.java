package com.training.pizza.domain.services.impl;

import com.training.pizza.domain.dtos.OrderDTO;
import com.training.pizza.domain.enums.OrderMethod;
import com.training.pizza.domain.mappers.OrderMapper;
import com.training.pizza.domain.services.OrderService;
import com.training.pizza.persistance.entity.PizzaOrderModel;
import com.training.pizza.persistance.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultOrderService implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper mapper;

    @Override
    public List<OrderDTO> getAll() {
        List<PizzaOrderModel> lstOrderModel = orderRepository.getAll().orElse(Collections.emptyList());
        return mapper.toLstOrderDTO(lstOrderModel);
    }

    @Override
    public List<OrderDTO> getByMethod(List<OrderMethod> lstMethods) {
        var lstMethod = Optional.of(lstMethods.stream().map(OrderMethod::getValue).toList());
        var lstOrderModel = orderRepository.getByMethod(lstMethod.orElse(Collections.emptyList())).orElse(Collections.emptyList());
        return mapper.toLstOrderDTO(lstOrderModel);
    }

}
