package com.demo.streamapi.service;

import com.demo.streamapi.entity.Order;
import com.demo.streamapi.entity.Product;

import java.util.List;

public interface OrderManagement {

    /*
    Exercise 1 — Obtain a list of products belongs to category “Books” with price > 100
    */
    public List<Product> getProductByCategoryAndPriceGreaterThan(String category, Double price);

    /*
    Exercise 2 — Obtain a list of order with products belong to category
    */
    public List<Order> getOrdersByProductBelogToCategory(String category);


}
