package dev.otthon.processor.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import dev.otthon.processor.entity.enums.Status;
import jakarta.persistence.*;
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
@Entity
@Table(name = "orders")
public class Order {

    @Id
    private UUID id = UUID.randomUUID();

    @JsonProperty("client")
    private String client;

    @JsonProperty("items")
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @Column(name = "order_item")
    private List<OrderItem> items = new ArrayList<>();

    @JsonProperty("total")
    private BigDecimal total;

    @JsonProperty("emailNotification")
    @Column(name = "email_notification")
    private String emailNotification;

    @JsonProperty("status")
    @Enumerated(EnumType.STRING)
    private Status status = Status.PROCESSING;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "date_time")
    private LocalDateTime dateTime = LocalDateTime.now();

    public List<OrderItem> getItems() {
        return items;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client='" + client + '\'' +
                ", items=" + items +
                ", total=" + total +
                ", emailNotification='" + emailNotification + '\'' +
                ", status=" + status +
                ", dateTime=" + dateTime +
                '}';
    }
}
