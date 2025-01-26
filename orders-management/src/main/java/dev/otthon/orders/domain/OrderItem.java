package dev.otthon.orders.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    private UUID id = UUID.randomUUID();

    @JsonProperty("product")
    private Product product;

    @JsonProperty("quantity")
    private Integer quantity;

}
