package dev.otthon.processor.service;

import dev.otthon.processor.entity.Order;
import dev.otthon.processor.entity.OrderItem;
import dev.otthon.processor.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;
    private final ProductService productService;
    private final OrderItemService orderItemService;

    public OrderService(OrderRepository orderRepository, ProductService productService, OrderItemService orderItemService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
        this.orderItemService = orderItemService;
    }

    public void save(Order order) {
        productService.save(order.getItems()); // Save products
        List<OrderItem> orderItems = orderItemService.save(order.getItems()); // Save order items
        orderRepository.save(order); // Save order
        orderItemService.updatedOrderItems(orderItems, order); // Update order items with own order

        logger.info("Order {} has been saved", order.toString());
    }

}
