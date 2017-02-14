package com.ilboudofabrice.service.impl;

import com.ilboudofabrice.dao.impl.BookDAOImpl;
import com.ilboudofabrice.dao.impl.ShoppingCartDAOImpl;
import com.ilboudofabrice.domain.Book;
import com.ilboudofabrice.domain.ShoppingCartItem;
import com.ilboudofabrice.dto.ShoppingCartItemDTO;
import com.ilboudofabrice.service.ShoppingCartService;
import com.ilboudofabrice.util.DataBaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabrice on 2017-02-07.
 */
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private ShoppingCartDAOImpl shoppingCartDAO;

    @Autowired
    private BookDAOImpl bookDAO;

    @Transactional
    public List<ShoppingCartItemDTO> getShoppingCartItems() throws DataBaseException {
        return toDTO(shoppingCartDAO.getItems());
    }

    @Transactional
    public void addToShoppingCart(Book item) {
        shoppingCartDAO.addItem(item);
    }

    public double getTotalCost(List<ShoppingCartItemDTO> dtos) {
        double totalCost = 0;
        for(ShoppingCartItemDTO dto : dtos)
        {
            totalCost = totalCost + (dto.getBook().getPrice() * dto.getQuantity());
        }
        return totalCost;
    }

    @Transactional
    public void deleteItem(int id) {
        try
        {
            shoppingCartDAO.removeItem(id);
        }
        catch (DataBaseException e)
        {
            e.printStackTrace();
        }
    }

    @Transactional
    public void updateShoppingCartItemQuantity(int id, int quantity) throws DataBaseException {
        shoppingCartDAO.updateItemQuantity(id, quantity);
    }

    private List<ShoppingCartItemDTO> toDTO(List<ShoppingCartItem> items) throws DataBaseException {
        List<ShoppingCartItemDTO> dtos = new ArrayList<ShoppingCartItemDTO>();
        for(ShoppingCartItem item : items)
        {
            ShoppingCartItemDTO dto = new ShoppingCartItemDTO();
            dto.setId(item.getId());

            Book book = bookDAO.getBookById(item.getBookFK());
            dto.setBook(book);

            dto.setQuantity(item.getQuantity());
            dtos.add(dto);
        }
        return dtos;
    }

    public void setShoppingCartDAO(ShoppingCartDAOImpl shoppingCartDAO) {
        this.shoppingCartDAO = shoppingCartDAO;
    }

}
