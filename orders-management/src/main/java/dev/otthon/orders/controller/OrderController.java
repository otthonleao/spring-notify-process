package dev.otthon.orders.controller;

import dev.otthon.orders.domain.Order;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Orders", description = "Recurso para realização de pedidos")
@RestController
@RequestMapping("orders")
public class OrderController {

    private final Logger logger = LoggerFactory.getLogger(OrderController.class);


    @PostMapping
    @Operation(summary = "Criar um pedido")
    @ApiResponse(responseCode = "201", description = "Pedido criado com sucesso", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Order.class)))
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {

        logger.info("Pedido recebido: {}", order.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(order);

    }

}
