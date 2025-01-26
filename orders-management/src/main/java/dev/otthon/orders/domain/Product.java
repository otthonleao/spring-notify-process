package dev.otthon.orders.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private UUID id = UUID.randomUUID();

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private BigDecimal price;

}
