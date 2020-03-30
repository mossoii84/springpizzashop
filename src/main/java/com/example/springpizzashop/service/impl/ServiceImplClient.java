package com.example.springpizzashop.service.impl;


import com.example.springpizzashop.model.Client;
import com.example.springpizzashop.repository.RepositoryClient;
import com.example.springpizzashop.service.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceImplClient implements ServiceClient {

    @Autowired
    private RepositoryClient repositoryClient;

    @Override
    public Client findByName(String name){return repositoryClient.findByName(name);}

    @Override
    public List<Client> findAll() {
        return repositoryClient.findAll();
    }

    @Override
    public Client findById(Long id) {
        return repositoryClient.findById(id).get();
    }

    @Override
    public Client save(Client client) {
        return repositoryClient.save(client);
    }

    @Override
    public void delete(Client client) {
          repositoryClient.delete(client);
    }
}
