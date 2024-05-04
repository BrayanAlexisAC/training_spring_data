package com.training.pizza.domain.services.impl;

import com.training.pizza.domain.dtos.OrderDTO;
import com.training.pizza.domain.dtos.OrderSummaryDTO;
import com.training.pizza.domain.enums.OrderMethod;
import com.training.pizza.domain.mappers.OrderMapper;
import com.training.pizza.domain.services.OrderService;
import com.training.pizza.persistance.entity.PizzaOrderModel;
import com.training.pizza.persistance.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
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

    @Override
    public List<OrderDTO> getCurrentOrders() {
        var date = LocalDateTime.now();
        var lstOrdersModel = orderRepository.getCurrentOrders(date).orElse(Collections.emptyList());
        return mapper.toLstOrderDTO(lstOrdersModel);
    }

    @Override
    public List<OrderDTO> getOldOrders(LocalDate firstDate, LocalDate secondDate) {
        if (!Objects.nonNull(firstDate)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "First Date cannot be null");
        }

        List<PizzaOrderModel> lstOrdersModel;
        if (Objects.nonNull(secondDate)){
            lstOrdersModel = orderRepository.getOrdersByRange(firstDate, secondDate).orElse(Collections.emptyList());
        } else {
            lstOrdersModel = orderRepository.getOrdersBeforeDate(firstDate).orElse(Collections.emptyList());
        }

        return mapper.toLstOrderDTO(lstOrdersModel);
    }

    @Override
    public OrderSummaryDTO getSummary(Integer idOrder) {
        var orderSummary = orderRepository.getSummary(idOrder).orElse(null);
        return mapper.toOrderSummaryDTO(orderSummary);
    }

}
