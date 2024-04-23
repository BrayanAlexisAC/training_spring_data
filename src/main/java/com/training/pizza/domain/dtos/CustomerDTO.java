package com.training.pizza.domain.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CustomerDTO {

    private String idCustomer;

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @Email
    private String email;

    @NotBlank
    private String phoneNumber;

}
