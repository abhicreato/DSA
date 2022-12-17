package com.demo.streamapi.service;

import com.demo.streamapi.entity.Order;
import com.demo.streamapi.entity.Product;

import java.time.LocalDate;
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

    /*
    * Exercise 3 — Obtain a list of product with category = “Toys” and then apply 10% discount
    */
    public List<Product> getProjductByCategoryWithDiscount(String category, int discountPercentage);

    /*
    * Exercise 4 — Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021
    */
    public List<Product> getProductsByCustomerOfTierBetweenDays(Integer CustomerTier, LocalDate startDay, LocalDate endDay);


}
