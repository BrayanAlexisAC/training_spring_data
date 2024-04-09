package com.training.pizza.domain.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDTO {

    private String idCustomer;

    private String name;

    private String address;

    private String email;

    private String phoneNumber;

}
