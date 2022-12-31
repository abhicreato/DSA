package com.demo.streamapi.repository;

import org.springframework.stereotype.Component;

@Component
abstract public class ProductSQL {

    final public static String GET_PRODUCT_BY_CATEGORY_PRICE_GREATER = "SELECT * FROM product where category = :category and price > :price";
}
