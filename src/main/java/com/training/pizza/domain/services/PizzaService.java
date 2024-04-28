package com.training.pizza.domain.services;

import com.training.pizza.domain.dtos.PizzaDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PizzaService {

    /**
     * Get back all available pizzas
     * @return List<PizzaDTO>
     */
    List<PizzaDTO> getAllAvailable();

    /**
     * Get back all available pizzas sorted by price
     * @return Optional<List>
     */
    List<PizzaDTO> getAllAvailableOrderByPrice();

    /**
     * Get back all pizzas
     * @return List<PizzaDTO>
     */
    List<PizzaDTO> getAll();

    /**
     * Get Pizza List pageable for page num and num rows
     * @param numPage int
     * @param numRows int
     * @return Page<PizzaDTO>
     */
    Page<PizzaDTO> getAllPageable(int numPage, int numRows);

    /**
     * Get back a pizza by ID
     * @param idPizza int
     * @return PizzaDTO
     */
    PizzaDTO getById(int idPizza);

    /**
     * Get pizza by name
     * @param pizzaName String
     * @return PizzaDTO
     */
    PizzaDTO getByName(String pizzaName);

    /**
     * Get a list of pizzas by description
     * @param word String
     * @param isContains boolean
     * @return List<PizzaDTO>
     */
    List<PizzaDTO> getByDescription(String word, boolean isContains);

    /**
     * Get a List of cheapest pizzas
     * @param basePrice Double
     * @return List<PizzaDTO>
     */
    List<PizzaDTO> getCheapest(Double basePrice);

    /**
     * Get true if exist pizza with ID or false if not exist
     * @param idPizza int
     * @return boolean
     */
    boolean exist(int idPizza);

    /**
     * Save or Update information about pizza
     * @param pizza PizzaDTO
     * @param exist boolean
     * @return PizzaDTO
     */
    PizzaDTO createAndUpdate(PizzaDTO pizza, boolean exist);

    /**
     * Delete Pizza By Id
     * @param idPizza int
     * @return boolean
     */
    boolean delete(int idPizza);

}
