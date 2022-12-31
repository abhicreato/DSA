package com.demo.streamapi.repository;

import com.demo.streamapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = OrderSQL.GET_RESENT_ORDERS,nativeQuery = true)
    public List<Order> getRecentOrderWithLimit(@Param("limit")int limit);

    @Query(value = OrderSQL.GET_ORDER_BY_PRODUCT_CATEGORY,nativeQuery = true)
    public List<Order> getOrderByProductCategory(@Param("category") String category);


}