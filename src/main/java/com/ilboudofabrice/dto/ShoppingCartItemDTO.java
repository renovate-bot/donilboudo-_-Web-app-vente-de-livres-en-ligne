package com.ilboudofabrice.dto;

import com.ilboudofabrice.domain.Book;

/**
 * Created by fabrice on 2017-02-12.
 */
public class ShoppingCartItemDTO {
    private int id;
    private Book book;
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
