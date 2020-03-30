package com.example.springpizzashop.service;


import com.example.springpizzashop.model.Order;
import java.util.List;

public interface ServiceOrder {
    List<Order> fingAll();
    Order findById(Long id);
    Order save(Order order);
    void delete(Order order);
}
