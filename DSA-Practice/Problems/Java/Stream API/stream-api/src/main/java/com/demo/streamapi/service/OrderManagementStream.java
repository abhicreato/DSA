package com.demo.streamapi.service;

import com.demo.streamapi.entity.Product;
import com.demo.streamapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class OrderManagementStream implements OrderManagement{

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getProductByCategoryAndPriceGreaterThen(String category, Double priceGreaterThen) {

        return productRepository
                .findAll()
                .stream()
                .filter(p-> p.getCategory().equals(category) && p.getPrice() > priceGreaterThen)
                .collect(Collectors.toList());

    }
}
