package com.training.pizza.domain.services.impl;

import com.training.pizza.domain.dtos.CustomerDTO;
import com.training.pizza.domain.mappers.CustomerMapper;
import com.training.pizza.domain.services.CustomerService;
import com.training.pizza.persistance.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class DefaultCustomerService implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private CustomerMapper mapper;

    @Override
    public CustomerDTO get(String id, String email, String name) {
        var lstCustomerModel = repository.get(id, email, name).orElse(Collections.emptyList());
        if (lstCustomerModel.isEmpty()){
            return null;
        } else {
            return mapper.toCustomerDTO(lstCustomerModel.stream().findFirst().get());
        }
    }
}
