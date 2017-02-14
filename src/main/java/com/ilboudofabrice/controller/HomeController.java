package com.ilboudofabrice.controller;

import com.ilboudofabrice.domain.Book;
import com.ilboudofabrice.service.BookService;
import com.ilboudofabrice.service.ShoppingCartService;
import com.ilboudofabrice.util.DataBaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by fabrice on 2017-02-10.
 */
@Controller
public class HomeController {
    @Resource
    private BookService bookService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    @Qualifier(value="bookService")
    public void setBookService(BookService bs){
        this.bookService = bs;
    }

    @RequestMapping(path = "/")
    public String home(ModelMap model){
        List<Book> books;
        try
        {
            books = bookService.getBookStore();
            model.put("books", books);
            model.put("shoppingCartItems", shoppingCartService.getShoppingCartItems().size());
        }
        catch (DataBaseException e)
        {
            e.printStackTrace();
        }

        return "home";
    }

    @RequestMapping(path = "/addBookPage")
    public String getBookPage(){
        return "addBookPage";
    }

    @RequestMapping(path = "/addBook")
    public String addBook(@RequestParam String isbn, String title, String author, String editor, double price, String details){
        bookService.addBook(isbn, title, author, editor, price, details);
        return "addBookPage";
    }

    @RequestMapping(path = "/bookDetails/{id}")
    public String getBooKDetails(ModelMap model, @PathVariable String id){
        try
        {
            Book book = bookService.findBookById(Integer.parseInt(id));
            if(book != null)
            {
                model.put("book", book);
                model.put("shoppingCartItems", shoppingCartService.getShoppingCartItems().size());
            }
        }
        catch (DataBaseException e)
        {
            e.printStackTrace();
        }
        return "bookDetails";
    }
}
