package com.training.pizza.domain.services.impl;

import com.training.pizza.domain.dtos.PizzaDTO;
import com.training.pizza.domain.mappers.PizzaMapper;
import com.training.pizza.domain.services.PizzaService;
import com.training.pizza.persistance.entity.PizzaModel;
import com.training.pizza.persistance.repository.PizzaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class DefaultPizzaService implements PizzaService {
    Logger log = LoggerFactory.getLogger(DefaultPizzaService.class);

    @Autowired
    private PizzaRepository repository;

    @Autowired
    private PizzaMapper mapper;

    @Override
    public List<PizzaDTO> getAllAvailable() {
        List<PizzaModel> lstPizzasModel = repository.getAllAvailable().orElse(Collections.emptyList());
        return mapper.toLstPizzaDTO(lstPizzasModel);
    }

    @Override
    public List<PizzaDTO> getAllAvailableOrderByPrice() {
        List<PizzaModel> lstPizzasModel = repository.getAllAvailableOrderByPrice().orElse(Collections.emptyList());
        return mapper.toLstPizzaDTO(lstPizzasModel);
    }

    @Override
    public List<PizzaDTO> getAll() {
        List<PizzaModel> lstPizzasModel = repository.getAll().orElse(Collections.emptyList());
        return mapper.toLstPizzaDTO(lstPizzasModel);
    }

    @Override
    public Page<PizzaDTO> getAllPageable(int numPage, int numRows) {
        var pageablePizzaModel = repository.getAllPageable(numPage, numRows);
        return pageablePizzaModel.map(pizzaModel -> mapper.toPizzaDTO(pizzaModel));
    }

    @Override
    public PizzaDTO getById(int idPizza) {
        PizzaModel pizzaModel = repository.getById(idPizza).orElse(null);
        return Objects.nonNull(pizzaModel) ? mapper.toPizzaDTO(pizzaModel) : null;
    }

    @Override
    public PizzaDTO getByName(String pizzaName) {
        PizzaModel pizzaModel = repository.getByName(pizzaName).orElse(null);
        return Objects.nonNull(pizzaModel) ? mapper.toPizzaDTO(pizzaModel) : null;
    }

    @Override
    public List<PizzaDTO> getByDescription(String word, boolean isContains) {
        List<PizzaModel> lstPizzaModel = isContains ?
                repository.getByContainsDescription(word).orElse(null) :
                repository.getByNotContainsDescription(word).orElse(null);
        return mapper.toLstPizzaDTO(lstPizzaModel);
    }

    @Override
    public List<PizzaDTO> getCheapest(Double basePrice) {
        if (Objects.nonNull(basePrice) && basePrice > 0){
            var lstPizzasModel = repository.getTop3Cheapest(basePrice).orElse(Collections.emptyList());
            return mapper.toLstPizzaDTO(lstPizzasModel);
        } else {
            var pizzaModel = repository.getCheapest();
            if(pizzaModel.isPresent()){
                return List.of(mapper.toPizzaDTO(pizzaModel.get()));
            }
        }
        return Collections.emptyList();
    }

    @Override
    public boolean exist(int idPizza) {
        return repository.existById(idPizza);
    }

    @Override
    public PizzaDTO createAndUpdate(PizzaDTO pizzaDTO, boolean exist) {
        PizzaModel pizzaModel = repository.save(mapper.toPizzaModel(pizzaDTO)).orElse(null);
        if (!Objects.nonNull(pizzaModel)) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error to " + (exist ? "updated" : "created") + " pizza");
        }
        pizzaDTO = mapper.toPizzaDTO(pizzaModel);
        pizzaDTO.setMessage(exist ? "updated" : "created");
        return pizzaDTO;
    }

    @Override
    public boolean delete(int idPizza) {
        PizzaModel pizzaModel = repository.getById(idPizza).orElse(null);
        if (!Objects.nonNull(pizzaModel))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pizza with id: " + idPizza + " doesn't exist");
        return repository.delete(pizzaModel);
    }
}
