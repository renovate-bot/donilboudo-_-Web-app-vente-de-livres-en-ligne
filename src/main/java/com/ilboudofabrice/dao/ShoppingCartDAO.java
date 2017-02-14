package com.ilboudofabrice.dao;

import com.ilboudofabrice.domain.Book;
import com.ilboudofabrice.domain.ShoppingCartItem;
import com.ilboudofabrice.util.DataBaseException;

import java.util.List;

/**
 * Created by fabrice on 2017-02-12.
 */
public interface ShoppingCartDAO {
    void addItem(Book book);
    void removeItem(int id) throws DataBaseException;
    List<ShoppingCartItem> getItems() throws DataBaseException;
    void updateItemQuantity(int id, int quantity) throws DataBaseException;
}
