package com.demo.streamapi.repository;

import org.springframework.stereotype.Component;

@Component
abstract public class OrderSQL {

    final public static String GET_RESENT_ORDERS = "SELECT * FROM product_order order by order_Date desc limit :limit";
}
