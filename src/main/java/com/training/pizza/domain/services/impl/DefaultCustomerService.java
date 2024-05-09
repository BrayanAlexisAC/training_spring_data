package com.training.pizza.domain.services.impl;

import com.training.pizza.domain.dtos.CustomerDTO;
import com.training.pizza.domain.mappers.CustomerMapper;
import com.training.pizza.domain.services.CustomerService;
import com.training.pizza.persistance.repository.CustomerRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.Objects;

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

    @Override
    public boolean update(CustomerDTO customerDTO) {
        Objects.requireNonNull(customerDTO, "customerDTO cannot be null");
        if (StringUtils.isBlank(customerDTO.getIdCustomer())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "idCustomer cannot be empty");
        }

        var customerModel = repository.get(customerDTO.getIdCustomer()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer does not exist"));
        var newInformationDTO = mapper.toCustomerDTO(customerModel);

        if (StringUtils.isNotBlank(customerDTO.getName())) newInformationDTO.setName(customerDTO.getName());
        if (StringUtils.isNotBlank(customerDTO.getAddress())) newInformationDTO.setAddress(customerDTO.getAddress());
        if (StringUtils.isNotBlank(customerDTO.getName())) newInformationDTO.setEmail(customerDTO.getEmail());
        if (StringUtils.isNotBlank(customerDTO.getName())) newInformationDTO.setPhoneNumber(customerDTO.getPhoneNumber());

        var updated = repository.update(mapper.toCustomerModel(newInformationDTO)).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error to update information, try later"));
        if (!updated) throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Customer not found");
        return Boolean.TRUE;
    }
}
