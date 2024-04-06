package com.training.pizza.web;

import com.training.pizza.domain.dtos.PizzaDTO;
import com.training.pizza.domain.services.PizzaService;
import com.training.pizza.persistance.entity.PizzaModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Tag(name = "Pizza Controller")
@RestController
@RequestMapping("/pizza")
public class PizzaController {

    @Autowired
    PizzaService pizzaService;

    @GetMapping("/all")
    @Operation(
            summary = "Get all pizzas",
            method = "GET",
            operationId = "getAllPizzas"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of all pizzas"),
            @ApiResponse(responseCode = "404", description = "No pizzas found", content = @Content(schema = @Schema()))
    })
    public ResponseEntity<List<PizzaDTO>> getAll(
            @Parameter(description = "Flag to retrieve only available pizzas", example = "false") @RequestParam(defaultValue = "false") boolean onlyAvailable
    ){
        List<PizzaDTO> lstPizzas = onlyAvailable ? pizzaService.getAllAvailable() : pizzaService.getAll();
        return new ResponseEntity<>(lstPizzas, lstPizzas.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.ACCEPTED);
    }

    @GetMapping("/{idPizza}")
    @Operation(
            summary = "Get pizza by ID",
            method = "GET",
            operationId = "getPizzaById"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pizza found"),
            @ApiResponse(responseCode = "404", description = "Pizza not found", content = @Content(schema = @Schema))
    })
    public ResponseEntity<PizzaDTO> getById(
            @Parameter(description = "Pizza Identifier", example = "5") @PathVariable("idPizza") int idPizza
    ){
        PizzaDTO pizza = pizzaService.getById(idPizza);
        return Objects.nonNull(pizza) ? new ResponseEntity<>(pizza, HttpStatus.ACCEPTED) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
