package dev.otthon.notification.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.otthon.notification.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private UUID id = UUID.randomUUID();

    @JsonProperty("client")
    private String client;

    @JsonProperty("items")
    private List<OrderItem> items = new ArrayList<>();

    @JsonProperty("total")
    private BigDecimal total;

    @JsonProperty("emailNotification")
    private String emailNotification;

    @JsonProperty("status")
    private Status status = Status.PROCESSING;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime = LocalDateTime.now();

}
