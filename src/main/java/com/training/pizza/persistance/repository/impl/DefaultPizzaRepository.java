package com.training.pizza.persistance.repository.impl;

import com.training.pizza.persistance.crud.PizzaCrudRepository;
import com.training.pizza.persistance.entity.PizzaModel;
import com.training.pizza.persistance.repository.PizzaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class DefaultPizzaRepository implements PizzaRepository {
    Logger log = LoggerFactory.getLogger(DefaultPizzaRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PizzaCrudRepository crudRepository;

    @Override
    public Optional<List<PizzaModel>> getAllAvailable() {
        // Jdbc template uses native queries
        String query = "SELECT * FROM pizza WHERE available = 1";
        return Optional.of(jdbcTemplate.query(query, new BeanPropertyRowMapper<>(PizzaModel.class)));
    }

    @Override
    public Optional<List<PizzaModel>> getAllAvailableOrderByPrice() {
        return crudRepository.findAllByAvailableTrueOrderByPrice();
    }

    @Override
    public Optional<List<PizzaModel>> getAll() {
        return Optional.of(crudRepository.findAll());
    }

    @Override
    public Optional<PizzaModel> getById(int idPizza){
        return crudRepository.findById(idPizza);
    }

    @Override
    public Optional<PizzaModel> getByName(String pizzaName) {
        return crudRepository.findByAvailableTrueAndNameIgnoreCase(pizzaName);
    }

    @Override
    public boolean existById(int idPizza) {
        return crudRepository.existsById(idPizza);
    }

    @Override
    public Optional<PizzaModel> save(PizzaModel pizza) {
        return Optional.of(crudRepository.save(pizza));
    }

    @Override
    public boolean delete(PizzaModel pizzaModel) {
        try {
            crudRepository.delete(pizzaModel);
            return true;
        }catch (Exception e){
            log.error("Error to delete pizza with id: {}, cause: {}, stacktrace: {}",
                    pizzaModel.getIdPizza(), e.getCause(), Arrays.toString(e.getStackTrace()));
            return false;
        }
    }
}
