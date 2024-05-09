package com.training.pizza.persistance.paging;

import com.training.pizza.persistance.entity.PizzaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface PizzaPagingAndSortingRepository extends ListPagingAndSortingRepository<PizzaModel, Integer> {
    /**
     * Find only available pizzas pageable
     * @param pageable Pageable, with parameters to get pages, rows and sort
     * @return Page<PizzaModel>
     */
    Page<PizzaModel> findByAvailableTrue(Pageable pageable);
}
