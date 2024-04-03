package com.training.pizza.persistance.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pizza_order")
public class PizzaOrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", nullable = false, unique = true)
    private Integer idOrder;

    @Column(name = "id_customer", nullable = false, unique = true, length = 15)
    private String idCustomer;

    @Column(nullable = false, columnDefinition = "DATETIME2")
    private LocalDateTime createdDate;

    @Column(nullable = false, columnDefinition = "DECIMAL(6,2)")
    private Double totalPrice;

    @Column(nullable = false, columnDefinition = "CHAR(1)")
    private Character method;

    @Column(name = "additional_notes", length = 200)
    private String comments;

}