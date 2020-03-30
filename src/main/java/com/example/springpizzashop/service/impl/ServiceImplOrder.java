package com.example.springpizzashop.service.impl;


import com.example.springpizzashop.model.Order;
import com.example.springpizzashop.repository.RepositoryOrder;
import com.example.springpizzashop.service.ServiceOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImplOrder  implements ServiceOrder {
       @Autowired
       private RepositoryOrder repositoryOrder;

    @Override
    public List<Order> fingAll() {
        return repositoryOrder.findAll();
    }

    @Override
    public Order findById(Long id) {
        return repositoryOrder.findById(id).get();
    }

    @Override
    public Order save(Order order) {
        return repositoryOrder.save(order);
    }

    @Override
    public void delete(Order order) {
        repositoryOrder.delete(order);
    }
}
