package dev.otthon.processor.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    private UUID id = UUID.randomUUID();

    @ManyToOne
    @JsonProperty("product")
    private Product product;

    @JsonProperty("quantity")
    private Integer quantity;

    @ManyToOne
    @JsonProperty("order")
    private Order order;

}
