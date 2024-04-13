package com.training.pizza.persistance.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pizza_order")
public class PizzaOrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", nullable = false, unique = true)
    private Integer idOrder;

    @Column(name = "id_customer", nullable = false, length = 15)
    private String idCustomer;

    @Column(nullable = false, columnDefinition = "DATETIME2")
    private LocalDateTime createdDate;

    @Column(nullable = false, columnDefinition = "DECIMAL(6,2)")
    private Double totalPrice;

    @Column(nullable = false, columnDefinition = "CHAR(1)")
    private Character method;

    @Column(name = "additional_notes", length = 200)
    private String comments;

    @ManyToOne
    @JoinColumn(name = "id_customer", referencedColumnName = "id_customer", insertable = false, updatable = false)
    private PizzaCustomerModel customer;

    @OneToMany(mappedBy = "order")
    private List<PizzaOrderItemModel> items;

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Character getMethod() {
        return method;
    }

    public void setMethod(Character method) {
        this.method = method;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public PizzaCustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(PizzaCustomerModel customer) {
        this.customer = customer;
    }

    public List<PizzaOrderItemModel> getItems() {
        return items;
    }

    public void setItems(List<PizzaOrderItemModel> items) {
        this.items = items;
    }
}
