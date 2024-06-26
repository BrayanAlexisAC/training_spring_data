package com.training.pizza.persistance.entity;

import com.training.pizza.persistance.audit.AuditableModel;
import com.training.pizza.persistance.audit.listeners.AuditModelsListener;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pizza_order")
@EntityListeners({AuditingEntityListener.class, AuditModelsListener.class})
@Getter
@Setter
@NoArgsConstructor
public class PizzaOrderModel extends AuditableModel {

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

}
