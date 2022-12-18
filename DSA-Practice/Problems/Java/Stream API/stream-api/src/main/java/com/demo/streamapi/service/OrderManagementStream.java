package com.demo.streamapi.service;

import com.demo.streamapi.entity.Order;
import com.demo.streamapi.entity.Product;
import com.demo.streamapi.repository.OrderRepository;
import com.demo.streamapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderManagementStream implements OrderManagement{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Product> getProductByCategoryAndPriceGreaterThan(String category, Double priceGreaterThen) {

        return productRepository
                .findAll()
                .stream()
                .filter(p-> p.getCategory().equals(category))
                .filter(p-> p.getPrice() > priceGreaterThen)
                .collect(Collectors.toList());

    }

    @Override
    public List<Order> getOrdersByProductBelogToCategory(String category) {
        return orderRepository
                .findAll()
                .stream()
                .filter(o -> o.getProducts().stream().anyMatch(p -> p.getCategory().equalsIgnoreCase(category)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getProjductByCategoryWithDiscount(String category, int discountPercentage) {

        return productRepository.findAll()
                .stream()
                .filter(p->p.getCategory().equalsIgnoreCase(category))
                .map(p-> p.withPrice(p.getPrice() * (0.9)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductsByCustomerOfTierBetweenDays(Integer customerTier, LocalDate startDay, LocalDate endDay) {
        return orderRepository.findAll()
                .stream()
                .filter(o -> o.getCustomer().getTier().equals(customerTier))
                .filter(o -> o.getOrderDate().compareTo(startDay) >=0 && o.getOrderDate().compareTo(endDay) <=0)
                .flatMap(o -> o.getProducts().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> getCheapestProductByCategory(String category) {
        return productRepository.findAll()
                .stream()
                .filter(p->p.getCategory().equalsIgnoreCase(category))
                .min(Comparator.comparing(Product::getPrice));
    }

    @Override
    public List<Order> getRecentOrders(int limit) {
        return orderRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(limit)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductForDay(LocalDate day) {
        return orderRepository.findAll()
                .stream()
                .filter(o->o.getOrderDate().equals(day))
                .peek(System.out::println)
                .flatMap(o->o.getProducts().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public double getOrderSalesAmountByMonth(LocalDate salesMonth) {
        return orderRepository.findAll()
                .stream()
                .filter(o->o.getOrderDate().getMonth().equals(salesMonth.getMonth()))
                .flatMapToDouble(o->o.getProducts().stream().mapToDouble(p->p.getPrice()))
                .sum();
    }

    @Override
    public Double getAvgOrderPaymentByDay(LocalDate salesDay) {
        return orderRepository
                .findAll()
                .stream()
                .filter(o->o.getOrderDate().equals(salesDay))
                .flatMapToDouble(o->o.getProducts().stream().mapToDouble(p->p.getPrice()))
                .average().getAsDouble();
    }
}
