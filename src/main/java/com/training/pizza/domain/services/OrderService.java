package com.training.pizza.domain.services;

import com.training.pizza.domain.dtos.OrderDTO;
import com.training.pizza.domain.enums.OrderMethod;

import java.time.LocalDate;
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

    /**
     * Get Back all current orders
     * @return List<OrderDTO>
     */
    List<OrderDTO> getCurrentOrders();

    /**
     * Get Back old orders based on two dates, if secondDate is null, get all orders before firstDate
     * @param firstDate LocalDate
     * @param secondDate LocalDate
     * @return List<OrderDTO>
     */
    List<OrderDTO> getOldOrders(LocalDate firstDate, LocalDate secondDate);
}
