package com.demo.streamapi.service;

import com.demo.streamapi.entity.Order;
import com.demo.streamapi.entity.Product;
import com.demo.streamapi.repository.OrderRepository;
import com.demo.streamapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderManagementStream implements OrderManagement{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Product> getProductByCategoryAndPriceGreaterThan(String category, Double priceGreaterThen) {

        System.out.println(priceGreaterThen);
        System.out.println(category);

        return productRepository
                .findAll()
                .stream()
                .filter(p-> p.getCategory().equals(category))
                .filter(p-> p.getPrice() > priceGreaterThen)
                .collect(Collectors.toList());

    }

    @Override
    public List<Order> getOrdersByProductBelogToCategory(String category) {
        return orderRepository
                .findAll()
                .stream()
                .filter(o -> o.getProducts().stream().anyMatch(p -> p.getCategory().equalsIgnoreCase(category)))
                .collect(Collectors.toList());
    }
}
