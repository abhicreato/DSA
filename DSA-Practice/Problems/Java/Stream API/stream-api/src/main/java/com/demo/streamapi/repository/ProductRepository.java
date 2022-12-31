package com.demo.streamapi.repository;

import com.demo.streamapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = ProductSQL.GET_PRODUCT_BY_CATEGORY_PRICE_GREATER,nativeQuery = true)
    public List<Product> getProductByCategoryAndPriceGreaterThan(@Param("category") String category, @Param("price") Double priceGreaterThen);
}