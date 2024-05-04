package com.training.pizza.persistance.projection;

import java.time.LocalDateTime;

/**
 * Interface based on a view
 */
public interface PizzaOrderSummary {
    Integer getIdOrder();
    String getCustomerName();
    LocalDateTime getCreatedDate();
    Double getTotal();
    String getPizzaNames();
}
