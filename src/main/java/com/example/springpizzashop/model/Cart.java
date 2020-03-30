package com.example.springpizzashop.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cart")
public class Cart  implements Serializable {
    private static final long serialVersionUID=2L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Client client;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Order order;


    @ManyToMany
    @JoinTable(name="pizza_In_cart",
            joinColumns = @JoinColumn( name="cart_id"),
            inverseJoinColumns = @JoinColumn( name="pizza_id"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Pizza> pizzas=new ArrayList<>();

}
