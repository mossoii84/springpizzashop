package com.example.springpizzashop.service;



import com.example.springpizzashop.model.Pizza;
import java.util.List;

public interface ServicePizza {
    List<Pizza> findAll();
    Pizza findById(Long id);
    Pizza save(Pizza pizza);
    void delete(Pizza pizza);
}
