package dev.otthon.processor.service;

import dev.otthon.processor.entity.Order;
import dev.otthon.processor.entity.OrderItem;
import dev.otthon.processor.repository.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> save(List<OrderItem> items) {
        return orderItemRepository.saveAll(items);
    }

    public void save(OrderItem item) {
        orderItemRepository.save(item);
    }

    public void updatedOrderItems(List<OrderItem> orderItems, Order order) {
        orderItems.forEach(item -> {
            item.setOrder(order); // inform your order in item
            this.save(item);
        });
    }
}
