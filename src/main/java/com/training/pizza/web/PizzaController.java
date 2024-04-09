package com.training.pizza.web;

import com.training.pizza.CustomExceptions;
import com.training.pizza.domain.dtos.PizzaDTO;
import com.training.pizza.domain.services.PizzaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Tag(name = "Pizza Controller")
@RestController
@RequestMapping("/pizza")
public class PizzaController {
    Logger log = LoggerFactory.getLogger(PizzaController.class);

    @Autowired
    PizzaService pizzaService;

    @ExceptionHandler(CustomExceptions.class) // This annotation works like global Exception for all endpoint in this controller
    @GetMapping("/all")
    @Operation(
            summary = "Get all pizzas",
            method = "GET",
            operationId = "getAllPizzas"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of all pizzas"),
            @ApiResponse(responseCode = "404", description = "No pizzas found", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema()))
    })
    public ResponseEntity<List<PizzaDTO>> getAll(
            @Parameter(description = "Flag to retrieve only available pizzas", example = "false") @RequestParam(defaultValue = "false") boolean onlyAvailable
    ){
        List<PizzaDTO> lstPizzas = onlyAvailable ? pizzaService.getAllAvailable() : pizzaService.getAll();
        if (lstPizzas.isEmpty()){
            throw new CustomExceptions(HttpStatus.NOT_FOUND, "No pizzas found");
        } else {
            return ResponseEntity.ok(lstPizzas);
        }
    }

    @GetMapping("/{idPizza}")
    @Operation(
            summary = "Get pizza by ID",
            method = "GET",
            operationId = "getPizzaById"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pizza found"),
            @ApiResponse(responseCode = "404", description = "Pizza not found", content = @Content(schema = @Schema)),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema()))
    })
    public ResponseEntity<PizzaDTO> getById(
            @Parameter(description = "Pizza Identifier", example = "5") @PathVariable("idPizza") int idPizza
    ){
        PizzaDTO pizza = pizzaService.getById(idPizza);
        if (Objects.nonNull(pizza)){
            return ResponseEntity.ok(pizza);
        } else {
            throw new CustomExceptions(HttpStatus.NOT_FOUND, "Pizza not found");
        }
    }

    @PostMapping("/add")
    @Operation(
            summary = "Create a pizza",
            method = "POST",
            operationId = "createPizza"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pizza created successfully"),
            @ApiResponse(responseCode = "409", description = "Conflict - Pizza already exists", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema()))
    })
    public ResponseEntity<PizzaDTO> save(
            @Parameter(description = "Create a pizza") @RequestBody PizzaDTO pizza
    ) {
        if (pizza.getIdPizza() > 0) {
            boolean pizzaExist = pizzaService.exist(pizza.getIdPizza());
            if (pizzaExist){
                return new ResponseEntity<>(pizzaService.createAndUpdate(pizza, true), HttpStatus.CREATED);
            } else {
                throw new CustomExceptions(HttpStatus.CONFLICT, "Pizza not exist");
            }
        } else {
            return new ResponseEntity<>(pizzaService.createAndUpdate(pizza, false), HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/delete/{idPizza}")
    @Operation(
            summary = "Delete a pizza",
            method = "DELETE",
            operationId = "deletePizza"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pizza deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Pizza not found", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema()))
    })
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID of the pizza to delete", required = true) @PathVariable(value = "idPizza") int idPizza
    ){
        boolean isDeleted = pizzaService.delete(idPizza);
        return isDeleted ? ResponseEntity.ok(null) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
