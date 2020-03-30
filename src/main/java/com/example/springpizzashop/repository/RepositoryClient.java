package com.example.springpizzashop.repository;


import com.example.springpizzashop.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryClient extends JpaRepository<Client,Long> {
    Client findByName(String name);
}
