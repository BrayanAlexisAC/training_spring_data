package com.training.pizza.web;

import com.training.pizza.Constants;
import com.training.pizza.domain.dtos.CustomerDTO;
import com.training.pizza.domain.services.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Tag(name = "Customer Controller")
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    @Operation(
            summary = "Get customer by ID, email, or name",
            method = "GET",
            operationId = "getCustomer"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer found"),
            @ApiResponse(responseCode = "204", description = "No content"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema))
    })
    public ResponseEntity<CustomerDTO> get(
            @Parameter(description = "Customer ID", example = "123") @RequestParam(required = false, defaultValue = Constants.EMPTY) String id,
            @Parameter(description = "Customer email", example = "example@example.com") @RequestParam(required = false, defaultValue = Constants.EMPTY) String email,
            @Parameter(description = "Customer name", example = "John Doe") @RequestParam(required = false, defaultValue = Constants.EMPTY) String name
    ){
        try {
            if (StringUtils.isEmpty(id) && StringUtils.isEmpty(email) && StringUtils.isEmpty(name)){
                return ResponseEntity.noContent().build();
            } else {
                var customer = customerService.get(id, email, name);
                if (Objects.nonNull(customer)) {
                    return ResponseEntity.ok(customer);
                } else {
                    return ResponseEntity.noContent().build();
                }
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, Constants.MSG_INTERNAL_SERVER_ERROR);
        }
    }

}
