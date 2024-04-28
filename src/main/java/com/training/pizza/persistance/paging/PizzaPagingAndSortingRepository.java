package com.training.pizza.persistance.paging;

import com.training.pizza.persistance.entity.PizzaModel;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface PizzaPagingAndSortingRepository extends ListPagingAndSortingRepository<PizzaModel, Integer> {
    // QueryMethods
}
