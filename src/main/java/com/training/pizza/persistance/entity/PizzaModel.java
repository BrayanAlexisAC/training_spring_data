package com.training.pizza.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PIZZA")
@Getter
@Setter
@NoArgsConstructor
public class PizzaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pizza", nullable = false, unique = true)
    private Integer idPizza;

    @Column(nullable = false, unique = true, length = 30)
    private String name;

    @Column(nullable = false, length = 150)
    private String description;

    @Column(nullable = false, columnDefinition = "DECIMAL(5,2)")
    private Double price;

    @Column(nullable = false, columnDefinition = "BIT")
    private Boolean vegetarian;

    @Column(nullable = false, columnDefinition = "BIT")
    private Boolean vegan;

    @Column(nullable = false, columnDefinition = "BIT")
    private Boolean available;
}
