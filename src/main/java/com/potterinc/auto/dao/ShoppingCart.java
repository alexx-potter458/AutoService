package com.potterinc.auto.dao;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "price")
    private  int price;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cart_id")
    private Set<ShoppingItem> shoppingItemSet;

    public ShoppingCart() {
        shoppingItemSet = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Set<ShoppingItem> getShoppingItemSet() {
        return shoppingItemSet;
    }

    public void setShoppingItemSet(Set<ShoppingItem> shoppingItemSet) {
        this.shoppingItemSet = shoppingItemSet;
    }
}
