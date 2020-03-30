package com.example.springpizzashop.service.impl;


import com.example.springpizzashop.model.Cart;
import com.example.springpizzashop.repository.RepositoryCart;
import com.example.springpizzashop.service.ServiceCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceImplCart implements ServiceCart {
    @Autowired
    private RepositoryCart repositoryCart;
    @Autowired
    private ServiceCart serviceCart;

    @Override
    public List<Cart> findAll() {
        return repositoryCart.findAll();
    }

    @Override
    public Cart findById(Long id) {
        return repositoryCart.findById(id).get();
    }

    @Override
    public Cart save(Cart cart) {
        return repositoryCart.save(cart);
    }

    @Override
    public void delete(Cart cart) {
      repositoryCart.delete(cart);
    }

    @Override
    public void deleteInBatch(Iterable<Cart> carts) {
        serviceCart.deleteInBatch(carts);
    }
}
