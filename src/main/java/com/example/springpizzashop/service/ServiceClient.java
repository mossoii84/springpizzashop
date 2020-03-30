package com.example.springpizzashop.service;


import com.example.springpizzashop.model.Client;
import java.util.List;

public interface ServiceClient {
    List<Client> findAll();
    Client findByName(String name);
    Client findById(Long id);
    Client save(Client client);
    void delete(Client client);
}
