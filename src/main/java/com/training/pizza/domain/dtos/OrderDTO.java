package com.training.pizza.domain.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {

    private int idOrder;

    private LocalDateTime createdDate;

    private double totalPrice;

    private Character method;

    private String comments;

    private CustomerDTO customer;

    private List<OrderItemDTO> items;

}
