package com.example.springpizzashop.controller;

import com.example.springpizzashop.model.Cart;
import com.example.springpizzashop.model.Client;
import com.example.springpizzashop.model.Order;
import com.example.springpizzashop.model.Pizza;
import com.example.springpizzashop.repository.RepositoryCart;
import com.example.springpizzashop.service.ServiceCart;
import com.example.springpizzashop.service.ServiceClient;
import com.example.springpizzashop.service.ServiceOrder;
import com.example.springpizzashop.service.ServicePizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(value="/api/cart")
public class ControllerCart {

    private ServicePizza servicePizza;
    private ServiceCart serviceCart;
    private ServiceOrder serviceOrder;
    private ServiceClient serviceClient;
    private RepositoryCart repositoryCart;

    @Autowired
    public ControllerCart(ServicePizza servicePizza, ServiceCart serviceCart, ServiceOrder serviceOrder, ServiceClient serviceClient, RepositoryCart repositoryCart) {
        this.servicePizza = servicePizza;
        this.serviceCart = serviceCart;
        this.serviceOrder = serviceOrder;
        this.serviceClient = serviceClient;
        this.repositoryCart = repositoryCart;
    }

    @GetMapping("/allCartsList")
    public List<Cart> getAllCarts(Principal principal){
        Client client=serviceClient.findByName(principal.getName());
        List<Cart> allCartList=client.getCarts();
        serviceClient.findAll();
        return allCartList;
    }

    @PostMapping(value = "/createOrder")
    public Cart addCartToOrder(@RequestBody Cart carts, Principal principal)
    {
        Client client=serviceClient.findByName(principal.getName());
        Order orders=new Order();
        List<Cart> cartList=serviceCart.findAll();

        orders.setCarts(cartList);
        orders.setClient(client);
        orders.setPizzas(carts.getPizzas());
        //Date
        Date dateNow = new Date();
        orders.setDateCreatOrder(dateNow);

        serviceOrder.save(orders);
        serviceClient.save(client);
        // почему через Сервис это не работает?
        repositoryCart.deleteInBatch(cartList);

        return serviceCart.save(carts);
    }



    @DeleteMapping(value = "/deletePizzaInCart/{pizza_id}")
    public void deletePizzaIncart(@PathVariable (value = "pizza_id") Long pizza_id,
                                  Principal principal){

        Client client=serviceClient.findByName(principal.getName());
            Pizza pizza = servicePizza.findById(pizza_id);


        Cart carts=new Cart();

     List<Cart> cartList=serviceCart.findAll();
        cartList.remove(pizza);


        carts.setPizzas(carts.getPizzas());
      //  client.setCrarts(cartList);

    }


}
