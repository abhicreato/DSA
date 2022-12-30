package com.demo.streamapi.repository;

import org.springframework.stereotype.Component;

@Component
abstract public class OrderSQL {

    final public static String GET_RESENT_ORDERS = "SELECT * FROM product_order order by order_Date desc limit :limit";

    final public static String GET_ORDER_BY_PRODUCT_CATEGORY = "select r.product_id,r.order_id,o.customer_id,o.delivery_date,o.order_date,o.status,\n" +
            "p.name,p.price,p.category from \n" +
            "product_order o,\n" +
            "order_product_relationship r,\n" +
            "product p\n" +
            "where o.order_id = r.order_id\n" +
            "and r.product_id = p.product_id\n" +
            "and p.category = :category";
}