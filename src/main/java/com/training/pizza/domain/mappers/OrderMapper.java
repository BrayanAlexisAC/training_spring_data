package com.training.pizza.domain.mappers;

import com.training.pizza.domain.dtos.OrderDTO;
import com.training.pizza.persistance.entity.PizzaOrderModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class, OrderItemMapper.class})
public interface OrderMapper {
    // For some reason sometimes doesn't work if we don't have mappings
    @Mappings({
            @Mapping(source = "idOrder", target = "idOrder"),
            @Mapping(source = "createdDate", target = "createdDate"),
            @Mapping(source = "totalPrice", target = "totalPrice"),
            @Mapping(source = "method", target = "method"),
            @Mapping(source = "comments", target = "comments")
    })
    OrderDTO toOrderDTO(PizzaOrderModel orderModel);

    List<OrderDTO> toLstOrderDTO(List<PizzaOrderModel> lstOrderModel);

}
