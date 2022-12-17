package com.demo.streamapi.controller;

import com.demo.streamapi.entity.Product;
import com.demo.streamapi.repository.OrderRepository;
import com.demo.streamapi.repository.ProductRepository;
import com.demo.streamapi.service.OrderManagement;
import com.demo.streamapi.service.OrderManagementStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderManagement orderManagement;

    @GetMapping("/")
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    @GetMapping("/{category}")
    public List<Product> getAllProductByCategoryAndPriceGreaterThan(@PathVariable String category, @RequestParam double priceGreaterThan){
        return orderManagement.getProductByCategoryAndPriceGreaterThan(category, priceGreaterThan);
    }
}
