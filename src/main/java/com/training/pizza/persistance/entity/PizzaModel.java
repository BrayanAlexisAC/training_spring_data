package com.training.pizza.persistance.entity;

import com.training.pizza.persistance.audit.AuditableModel;
import com.training.pizza.persistance.audit.listeners.AuditModelsListener;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "PIZZA")
@EntityListeners({AuditingEntityListener.class, AuditModelsListener.class})
@Getter
@Setter
@NoArgsConstructor
public class PizzaModel extends AuditableModel {

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
