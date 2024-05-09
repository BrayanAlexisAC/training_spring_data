package com.training.pizza.persistance.entity;

import com.training.pizza.persistance.audit.AuditableModel;
import com.training.pizza.persistance.audit.listeners.AuditModelsListener;
import com.training.pizza.persistance.entity.composePK.PizzaOrderItemPK;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "pizza_order_item")
@EntityListeners({AuditingEntityListener.class, AuditModelsListener.class})
@Getter
@Setter
@NoArgsConstructor
public class PizzaOrderItemModel extends AuditableModel {

    @EmbeddedId
    private PizzaOrderItemPK composePK;

    @Column(name = "id_item", nullable = false)
    private Integer idItem;

    @Column(nullable = false, columnDefinition = "DECIMAL(2,1)")
    private Double quantity;

    @Column(nullable = false, columnDefinition = "DECIMAL(5,2)")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "id_order", referencedColumnName = "id_order", insertable = false, updatable = false)
    private PizzaOrderModel order;

    @OneToOne
    @JoinColumn(name = "id_pizza", referencedColumnName = "id_pizza", insertable = false, updatable = false)
    private PizzaModel pizza;

}
