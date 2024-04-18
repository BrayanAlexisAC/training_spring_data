package com.training.pizza.domain.services;

import com.training.pizza.domain.dtos.OrderDTO;
import com.training.pizza.domain.enums.OrderMethod;

import java.util.List;

public interface OrderService {

    /**
     * Get Back All Orders
     * @return List<OrderDTO>
     */
    List<OrderDTO> getAll();

    /**
     * Get Back all orders with methods in list
     * @param lstMethods List<OrderMethod>
     * @return LIst<OrderDTO>
     */
    List<OrderDTO> getByMethod(List<OrderMethod> lstMethods);
}
