package com.training.pizza.web;

import com.training.pizza.Constants;
import com.training.pizza.domain.dtos.OrderDTO;
import com.training.pizza.domain.enums.OrderMethod;
import com.training.pizza.domain.services.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterStyle;
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
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@Tag(name = "Order Controller")
@RestController
@RequestMapping("/order")
public class OrderController {
    Logger log = LoggerFactory.getLogger(OrderController.class);

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
            @ApiResponse(responseCode = "404", description = Constants.Order.MSG_NO_ORDERS_FOUND, content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema()))
    })
    public ResponseEntity<List<OrderDTO>> getAll() {
        try {
            List<OrderDTO> lstOrderDTO = orderService.getAll();
            if (lstOrderDTO.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.Order.MSG_NO_ORDERS_FOUND);
            } else {
                return ResponseEntity.ok(lstOrderDTO);
            }
        } catch (Exception e) {
            log.error("Error in service orders/all cause: {}, message: {}, stacktrace: {}",
                    e.getCause(), e.getMessage(), Arrays.toString(e.getStackTrace()));
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, Constants.MSG_INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all/methods")
    @Operation(
            summary = "Get all order methods",
            method = "GET",
            operationId = "getAllOrderMethods"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of all order methods"),
            @ApiResponse(responseCode = "404", description = "No found order methods"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema()))
    })
    public ResponseEntity<List<OrderMethod>> getAllOrderMethods() {
        try {
            List<OrderMethod> allMethods = OrderMethod.getAllMethods();
            return ResponseEntity.ok(allMethods);
        } catch (Exception e) {
            log.error("Error in service orders/all/methods cause: {}, message: {}, stacktrace: {}",
                    e.getCause(), e.getMessage(), Arrays.toString(e.getStackTrace()));
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, Constants.MSG_INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/method")
    @Operation(
            summary = "Get orders by method",
            method = "GET",
            operationId = "getOrdersByMethod"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of orders found"),
            @ApiResponse(responseCode = "404", description = Constants.Order.MSG_NO_ORDERS_FOUND, content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema()))
    })
    public ResponseEntity<List<OrderDTO>> getByMethod(
            @Parameter(description = "List of order methods", schema = @Schema(type = "String", implementation = String.class), style = ParameterStyle.FORM, example = "ON_SITE, DELIVERY")
            @RequestParam List<OrderMethod> lstMethods
    ){
        try {
            var availableMethods = OrderMethod.getAllMethods();
            if (!availableMethods.containsAll(lstMethods)){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unsupported Methods");
            }
            var lstOrderDTO = orderService.getByMethod(lstMethods);
            if (!lstOrderDTO.isEmpty()) {
                return ResponseEntity.ok(lstOrderDTO);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.Order.MSG_NO_ORDERS_FOUND);
            }
        } catch (Exception e) {
            log.error("Error in service orders/method cause: {}, message: {}, stacktrace: {}",
                    e.getCause(), e.getMessage(), Arrays.toString(e.getStackTrace()));
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, Constants.MSG_INTERNAL_SERVER_ERROR);
        }
    }

}
