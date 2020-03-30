package com.example.springpizzashop.service;


import com.example.springpizzashop.model.Cart;
import java.util.List;

public interface ServiceCart {
    List<Cart> findAll();
    Cart findById(Long id);
    Cart save(Cart cart);
    void delete(Cart cart);
    void deleteInBatch(Iterable<Cart>  carts);
}
