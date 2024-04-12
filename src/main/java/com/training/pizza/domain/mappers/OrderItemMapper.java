package com.training.pizza.domain.mappers;

import com.training.pizza.domain.dtos.OrderItemDTO;
import com.training.pizza.persistance.entity.PizzaOrderItemModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PizzaMapper.class})
public interface OrderItemMapper {

    @Mapping(source = "composePK.idPizza", target = "idPizza")
    OrderItemDTO toOrderItemDTO(PizzaOrderItemModel orderItemModel);

    @InheritInverseConfiguration
    List<OrderItemDTO> toLstOrderItemDTO(List<PizzaOrderItemModel> lstOrderItemModel);

    @Mappings({
            @Mapping(target = "composePK", ignore = true),
            @Mapping(target = "order", ignore = true)
    })
    PizzaOrderItemModel toOrderItemModel(OrderItemDTO orderItemDTO);

}
