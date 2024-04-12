package com.training.pizza.domain.mappers;

import com.training.pizza.domain.dtos.CustomerDTO;
import com.training.pizza.persistance.entity.PizzaCustomerModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO toCustomerDTO(PizzaCustomerModel customerModel);

    PizzaCustomerModel toCustomerModel(CustomerDTO customerDTO);

}
