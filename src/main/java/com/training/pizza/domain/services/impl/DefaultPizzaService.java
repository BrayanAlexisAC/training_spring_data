package com.training.pizza.domain.services.impl;

import com.training.pizza.domain.dtos.PizzaDTO;
import com.training.pizza.domain.services.PizzaService;
import com.training.pizza.persistance.entity.PizzaModel;
import com.training.pizza.persistance.repository.PizzaRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DefaultPizzaService implements PizzaService {
    Logger log = LoggerFactory.getLogger(DefaultPizzaService.class);

    @Autowired
    private PizzaRepository repository;

    @Override
    public List<PizzaDTO> getAllAvailable() {
        List<PizzaModel> lstPizzasModel = repository.getAllAvailable().orElse(Collections.emptyList());
        return lstPizzasModel.stream().map(pizzaModel -> getMapper().map(pizzaModel, PizzaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<PizzaDTO> getAll() {
        List<PizzaModel> lstPizzasModel = repository.getAll().orElse(Collections.emptyList());
        return lstPizzasModel.stream().map(pizzaModel -> getMapper().map(pizzaModel, PizzaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public PizzaDTO getById(int idPizza) {
        PizzaModel pizzaModel = repository.getById(idPizza).orElse(null);
        return Objects.nonNull(pizzaModel) ? getMapper().map(pizzaModel, PizzaDTO.class) : null;
    }

    private ModelMapper getMapper() {
        return new ModelMapper();
    }
}
