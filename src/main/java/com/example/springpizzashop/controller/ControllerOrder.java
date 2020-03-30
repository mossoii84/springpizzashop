package com.example.springpizzashop.controller;

import com.example.springpizzashop.model.Client;
import com.example.springpizzashop.model.Order;
import com.example.springpizzashop.service.ServiceClient;
import com.example.springpizzashop.service.ServiceOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(value="/api/order")
public class ControllerOrder {

    private ServiceOrder serviceOrder;
    private ServiceClient serviceClient;
    @Autowired
    public ControllerOrder(ServiceOrder serviceOrder, ServiceClient serviceClient) {
        this.serviceOrder = serviceOrder;
        this.serviceClient = serviceClient;
    }

    @GetMapping("/allOrder")
    private List<Order> getAllOrders(Principal principal){
        Client client=serviceClient.findByName(principal.getName());
        List<Order> orders=client.getOrders();
        serviceClient.findAll();
        return orders;
    }

    @GetMapping("/getallOrder")
    private List<Order> getAllOrders(){
        List<Order> orders=serviceOrder.fingAll();
        return orders;
    }


}
