package com.demo.streamapi.controller;

import com.demo.streamapi.entity.Order;
import com.demo.streamapi.repository.OrderRepository;
import com.demo.streamapi.service.OrderManagement;
import com.demo.streamapi.service.OrderManagementStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderManagement orderManagement;

    @GetMapping("/")
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    @GetMapping("/byCategory")
    public List<Order> getOrdersByProductCategory(@RequestParam String productCategory){
        return orderManagement.getOrdersByProductBelogToCategory(productCategory);
    }
}
