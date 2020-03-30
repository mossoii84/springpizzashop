package com.example.springpizzashop.repository;

import com.example.springpizzashop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryOrder extends JpaRepository<Order,Long> {
}
