package com.ilboudofabrice.domain;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by fabrice on 2017-02-07.
 */
@Entity
@Table(name = "SHOPPING_CART_ITEM")
@Proxy(lazy = false)
public class ShoppingCartItem implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "bookFK")
    private int bookFK;

    @Column(name = "quantity")
    private int quantity;

//    @Column(name = "totalCost")
    private double totalCost;

    public ShoppingCartItem() {
    }

    public ShoppingCartItem(int bookId, int quantity){
        this.bookFK = bookId;
        this.quantity = quantity;
//        calculateTotalCost();
    }

    public int getId() {
        return id;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public int getBookFK() {
        return bookFK;
    }

    public void setBookFK(int bookFK) {
        this.bookFK = bookFK;
    }
}
