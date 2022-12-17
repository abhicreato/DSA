package com.demo.streamapi.controller;

import com.demo.streamapi.entity.Product;
import com.demo.streamapi.repository.OrderRepository;
import com.demo.streamapi.repository.ProductRepository;
import com.demo.streamapi.service.OrderManagementStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderManagementStream orderManagementStream;

    @GetMapping("/")
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    @GetMapping("/")
    public List<Product> getAllProductByCategoryAndPriceGreaterThen(){
        return orderManagementStream.getProductByCategoryAndPriceGreaterThen("", 100.0);
    }
}
