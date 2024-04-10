package com.training.pizza.domain.mappers;

import com.training.pizza.domain.dtos.PizzaDTO;
import com.training.pizza.persistance.entity.PizzaModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PizzaMapper {

    @Mapping(target = "message", ignore = true)
    PizzaDTO toPizzaDTO(PizzaModel pizzaModel);

    List<PizzaDTO> toLstPizzaDTO(List<PizzaModel> lstPizzaModel);

    PizzaModel toPizzaModel(PizzaDTO pizzaDTO);
}
