package com.example.springpizzashop.service.impl;


import com.example.springpizzashop.model.Pizza;
import com.example.springpizzashop.repository.RepositoryPizza;
import com.example.springpizzashop.service.ServicePizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceImplPizza implements ServicePizza {

    @Autowired
    private RepositoryPizza repositoryPizza;

    @Override
    public List<Pizza> findAll() {
        return repositoryPizza.findAll();
    }

    @Override
    public Pizza findById(Long id) {
        return repositoryPizza.findById(id).get();
    }

    @Override
    public Pizza save(Pizza pizza) {
        return repositoryPizza.save(pizza);
    }

    @Override
    public void delete(Pizza pizza) {
     repositoryPizza.delete(pizza);
    }
}
