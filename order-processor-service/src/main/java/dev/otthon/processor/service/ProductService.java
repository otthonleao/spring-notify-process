package dev.otthon.processor.service;

import dev.otthon.processor.entity.OrderItem;
import dev.otthon.processor.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(List<OrderItem> orderItems) {
        orderItems.forEach(item -> {
            productRepository.save(item.getProduct());
        });
    }
}
