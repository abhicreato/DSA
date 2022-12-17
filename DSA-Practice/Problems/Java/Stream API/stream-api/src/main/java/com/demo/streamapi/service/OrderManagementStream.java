package com.demo.streamapi.service;

import com.demo.streamapi.entity.Product;
import com.demo.streamapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderManagementStream implements OrderManagement{

    @Autowired
    ProductRepository productRepository;

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
}
