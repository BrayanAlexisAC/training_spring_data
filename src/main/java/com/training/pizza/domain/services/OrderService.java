package com.training.pizza.domain.services;

import com.training.pizza.domain.dtos.OrderDTO;

import java.util.List;

public interface OrderService {

    /**
     * Get Back All Orders
     * @return List<OrderDTO>
     */
    List<OrderDTO> getAll();

}
