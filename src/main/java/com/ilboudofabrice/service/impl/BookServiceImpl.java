package com.ilboudofabrice.service.impl;

import com.ilboudofabrice.dao.impl.BookDAOImpl;
import com.ilboudofabrice.domain.Book;
import com.ilboudofabrice.service.BookService;
import com.ilboudofabrice.util.DataBaseException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fabrice on 2017-02-07.
 */
public class BookServiceImpl implements BookService {
    private BookDAOImpl bookDAO;

    @Transactional
    public void addBook(Book book) throws DataBaseException {
       bookDAO.addBook(book);
    }

    @Transactional
    public void removeBook(int id) throws DataBaseException {
        bookDAO.removeBook(id);
    }

    @Transactional
    public List<Book> getBookStore() throws DataBaseException {
        return bookDAO.getBooks();
    }

    public void addBook(String isbn, String title, String author, String editor, double price, String details) {
        Book book = new Book();
        book.setISBN(isbn);
        book.setTitle(title);
        book.setAuthor(author);
        book.setEditor(editor);
        book.setPrice(price);
        book.setDetails(details);

        try
        {
            bookDAO.addBook(book);
        }
        catch (DataBaseException e)
        {
            e.printStackTrace();
        }
    }


    public void clearBookStore(){
//        bookStore.clear();
    }

    @Transactional
    public Book findBookByISBN(String isbn){
        return bookDAO.getBookByISBN(isbn);
    }

    @Transactional
    public Book findBookById(int id) throws DataBaseException {
        return bookDAO.getBookById(id);
    }

    @Transactional
    public Book findBookByTitle(String title){
       return bookDAO.getBookByTitle(title);
    }

    public void setBookDAO(BookDAOImpl bookDAO) {
        this.bookDAO = bookDAO;
    }
}
