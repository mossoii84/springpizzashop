package com.example.springpizzashop.repository;

import com.example.springpizzashop.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPizza extends JpaRepository<Pizza,Long> {
}
