package com.ilboudofabrice.service;

import com.ilboudofabrice.domain.Book;
import com.ilboudofabrice.dto.ShoppingCartItemDTO;
import com.ilboudofabrice.util.DataBaseException;

import java.util.List;

/**
 * Created by fabrice on 2017-02-07.
 */
public interface ShoppingCartService {
    List<ShoppingCartItemDTO> getShoppingCartItems() throws DataBaseException;
    void addToShoppingCart(Book book);
    double getTotalCost(List<ShoppingCartItemDTO> dtos);
    void deleteItem(int id);
    void updateShoppingCartItemQuantity(int id, int quantity) throws DataBaseException;
}
