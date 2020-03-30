package com.example.springpizzashop.repository;


import com.example.springpizzashop.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCart extends JpaRepository<Cart,Long> {
   void deleteInBatch(Iterable<Cart> carts);
}
