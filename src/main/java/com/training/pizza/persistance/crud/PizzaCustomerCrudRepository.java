package com.training.pizza.persistance.crud;

import com.training.pizza.persistance.entity.PizzaCustomerModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PizzaCustomerCrudRepository extends ListCrudRepository<PizzaCustomerModel, String> {

    @Query(value = "SELECT customer FROM PizzaCustomerModel customer WHERE " +
                    "idCustomer like concat('%',:id,'%') AND email like concat('%',:email,'%') AND name like concat('%',:name,'%')")
    Optional<List<PizzaCustomerModel>> findByIdAndEmailAndName(@Param("id") String id, @Param("email") String email, @Param("name") String name);
}
