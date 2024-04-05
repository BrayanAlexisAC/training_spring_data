package com.training.pizza.persistance.entity.composePK;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class PizzaOrderItemPK implements Serializable {

    @Column(name = "id_order", nullable = false)
    private Integer idOrder;

    @Column(name = "id_pizza", nullable = false)
    private Integer idPizza;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PizzaOrderItemPK that)) return false;
        return Objects.equals(idOrder, that.idOrder) && Objects.equals(idPizza, that.idPizza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrder, idPizza);
    }
}
