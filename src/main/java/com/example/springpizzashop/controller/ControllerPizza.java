package com.example.springpizzashop.controller;

import com.example.springpizzashop.model.Cart;
import com.example.springpizzashop.model.Client;
import com.example.springpizzashop.model.Pizza;
import com.example.springpizzashop.model.PizzaDTO;
import com.example.springpizzashop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(value="/api/pizza")
public class ControllerPizza {

    private ServicePizza servicePizza;
    private ServiceCart serviceCart;
    private ServiceOrder serviceOrder;
    private ServiceClient serviceClient;
    private FileStorage fileStorage;
    @Autowired
    public ControllerPizza(ServicePizza servicePizza, ServiceCart serviceCart, ServiceOrder serviceOrder, ServiceClient serviceClient,
                          FileStorage fileStorage) {
        this.servicePizza = servicePizza;
        this.serviceCart = serviceCart;
        this.serviceOrder = serviceOrder;
        this.serviceClient = serviceClient;
        this.fileStorage = fileStorage;
    }

    @GetMapping("/allPizzaList")
    public List<Pizza> getAllPizzaList(){
        return servicePizza.findAll();
    }

    @GetMapping("/addPizzaInCart/{pizza_id}")
    public Pizza addPizzaInCart(@PathVariable (value = "pizza_id") Long pizza_id, Principal principal){
        Client client=serviceClient.findByName(principal.getName());
        Cart carts;
        List<Cart> cartInPrincipal=client.getCarts();
        if(cartInPrincipal.size()!=0){
            carts=cartInPrincipal.get(cartInPrincipal.size()-1);
        }else {
            carts=new Cart();
        }
        Pizza pizza=servicePizza.findById(pizza_id);
        carts.setClient(client);
        carts.getPizzas().add(pizza);
        Cart savePizzaInCart=serviceCart.save(carts);
        client.getCarts().add(savePizzaInCart);
        serviceClient.save(client);
        return pizza;
    }


     //MultipartFile// Creat Pizza
    @PostMapping("/files/pizzaList")
    public Pizza savePizzaImage(@ModelAttribute PizzaDTO pizzaDTO) {
        String path = "http://localhost:8080/api/pizza/files/";//создаем путь по которому достаем наше фото
        fileStorage.store(pizzaDTO.getFile());
        Pizza pizza = new Pizza();
        pizza.setName(pizzaDTO.getName());
        pizza.setSize(pizzaDTO.getSize());
        pizza.setPrice(pizzaDTO.getPrice());
    pizza.setImage(pizzaDTO.getFile().getOriginalFilename());
    return servicePizza.save(pizza);
    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource resource = fileStorage.getFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; personfilename=\"" + resource.getFilename() + "\"")
                .body(resource); }


}
