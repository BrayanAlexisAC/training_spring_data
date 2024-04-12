package com.training.pizza.web;

import com.training.pizza.CustomExceptions;
import com.training.pizza.domain.dtos.OrderDTO;
import com.training.pizza.domain.services.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Order Controller")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    @Operation(
            summary = "Get all orders",
            method = "GET",
            operationId = "getAllOrders"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of all orders"),
            @ApiResponse(responseCode = "404", description = "No orders found", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema()))
    })
    public ResponseEntity<List<OrderDTO>> getAll() {
        try {
            List<OrderDTO> lstOrderDTO = orderService.getAll();
            if (lstOrderDTO.isEmpty()) {
                throw new CustomExceptions(HttpStatus.NOT_FOUND, "No orders found");
            } else {
                return ResponseEntity.ok(lstOrderDTO);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
