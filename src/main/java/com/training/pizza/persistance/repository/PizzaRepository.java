package com.training.pizza.persistance.repository;

import com.training.pizza.persistance.entity.PizzaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository {

    /**
     * Get back all available pizzas
     * @return Optional<List>
     */
    Optional<List<PizzaModel>> getAllAvailable();

    /**
     * Get back all available pizzas sorted by price
     * @return Optional<List>
     */
    Optional<List<PizzaModel>> getAllAvailableOrderByPrice();

    /**
     * get back all pizzas
     * @return Optional<List>
     */
    Optional<List<PizzaModel>> getAll();

    /**
     * Get Pizzas for page and determinate elements
     * @param pageable Pageable, with num pages, num rows and Sort with fields and direction
     * @return Page<PizzaModel>
     */
    Page<PizzaModel> getAllPageable(Pageable pageable);

    /**
     * Get Pizza by ID
     * @param idPizza int
     * @return PizzaModel
     */
    Optional<PizzaModel> getById(int idPizza);

    /**
     * Get pizza by name
     * @param pizzaName String
     * @return PizzaModel
     */
    Optional<PizzaModel> getByName(String pizzaName);

    /**
     * Get pizza if contains word in description
     * @param word String
     * @return Optional
     */
    Optional<List<PizzaModel>> getByContainsDescription(String word);

    /**
     * Get pizza if not contains word in description
     * @param word String
     * @return Optional
     */
    Optional<List<PizzaModel>> getByNotContainsDescription(String word);

    /**
     * Get Top 3 Cheapest pizzas based on a price
     * @param basePrice Double
     * @return Optional<List>
     */
    Optional<List<PizzaModel>> getTop3Cheapest(Double basePrice);

    /**
     * Get the cheapest pizza in the database
     * @return Optional<PizzaModel>
     */
    Optional<PizzaModel> getCheapest();

    /**
     * Get true if exist pizza or false if not exist
     * @param idPizza int
     * @return boolean
     */
    boolean existById(int idPizza);

    /**
     * Save or Update information about PizzaModel
     * @param pizza PizzaModel
     * @return PizzaModel
     */
    Optional<PizzaModel> save(PizzaModel pizza);

    /**
     * Delete Pizza By Model
     * @param pizzaModel PizzaModel
     * @return boolean
     */
    boolean delete(PizzaModel pizzaModel);

}
