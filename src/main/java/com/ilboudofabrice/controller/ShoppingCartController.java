package com.ilboudofabrice.controller;

import com.ilboudofabrice.domain.Book;
import com.ilboudofabrice.dto.ShoppingCartItemDTO;
import com.ilboudofabrice.service.BookService;
import com.ilboudofabrice.service.ShoppingCartService;
import com.ilboudofabrice.util.DataBaseException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by fabrice on 2017-02-07.
 */
@Controller
public class ShoppingCartController {
    @Resource
    private ShoppingCartService shoppingCartService;

    @Qualifier(value="shoppingCartService")
    public void setShoppingCartService(ShoppingCartService service){
        this.shoppingCartService = service;
    }

    @Resource
    private BookService bookService;

    @RequestMapping("/addShoppingCartItem/{id}")
    public String addItemToShoppingCart(ModelMap model, @PathVariable String id){
        try
        {
            Book book = bookService.findBookById(Integer.parseInt(id));
            if(book != null)
            {
                shoppingCartService.addToShoppingCart(book);
                model.put("book", book);
            }
        }
        catch (DataBaseException e)
        {
            e.printStackTrace();
        }
        return "bookDetails";
    }

    @RequestMapping("/shoppingCart")
    public String getShoppingCart(ModelMap model){
        setViewItems(model);
        return "shoppingCart";
    }

    @RequestMapping(path = "/deleteShoppingCartItem/{id}")
    public String deleteShoppingCartItem(ModelMap model, @PathVariable String id){
        shoppingCartService.deleteItem(Integer.parseInt(id));
        setViewItems(model);

        return "shoppingCart";
    }

    @RequestMapping(path = "/updateQuantity/{id}/{newQuantity}")
    public String updateShoppingCartItemQuantity(ModelMap model, @PathVariable String id, @PathVariable String newQuantity){
        try
        {
            shoppingCartService.updateShoppingCartItemQuantity(Integer.parseInt(id), Integer.parseInt(newQuantity));
            setViewItems(model);
        }
        catch (DataBaseException e)
        {
            e.printStackTrace();
        }
        return "shoppingCart";
    }

    private void setViewItems(ModelMap model){
        try
        {
            List<ShoppingCartItemDTO> dtos = shoppingCartService.getShoppingCartItems();
            double totalCost = shoppingCartService.getTotalCost(dtos);

            model.put("items", dtos);
            model.put("totalCost", totalCost);
        }
        catch (DataBaseException e)
        {
            e.printStackTrace();
        }
    }
}
