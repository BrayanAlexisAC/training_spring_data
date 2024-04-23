package com.training.pizza.domain.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OrderDTO {

    private int idOrder;

    @NotBlank
    private LocalDateTime createdDate;

    @Positive
    private double totalPrice;

    @NotBlank
    private Character method;

    private String comments;

    private CustomerDTO customer;

    private List<OrderItemDTO> items;

}
