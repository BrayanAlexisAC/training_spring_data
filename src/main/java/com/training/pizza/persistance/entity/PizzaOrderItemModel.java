package com.training.pizza.persistance.entity;

import com.training.pizza.persistance.entity.composePK.PizzaOrderItemPK;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pizza_order_item")
@NoArgsConstructor
public class PizzaOrderItemModel {

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

    public PizzaOrderItemPK getComposePK() {
        return composePK;
    }

    public void setComposePK(PizzaOrderItemPK composePK) {
        this.composePK = composePK;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public PizzaOrderModel getOrder() {
        return order;
    }

    public void setOrder(PizzaOrderModel order) {
        this.order = order;
    }

    public PizzaModel getPizza() {
        return pizza;
    }

    public void setPizza(PizzaModel pizza) {
        this.pizza = pizza;
    }
}
