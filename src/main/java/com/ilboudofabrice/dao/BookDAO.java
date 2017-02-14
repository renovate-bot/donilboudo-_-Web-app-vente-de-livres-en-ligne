package com.ilboudofabrice.dao;

import com.ilboudofabrice.domain.Book;
import com.ilboudofabrice.util.DataBaseException;

import java.util.List;

/**
 * Created by fabrice on 2017-02-09.
 */
public interface BookDAO {
    void addBook(Book book) throws DataBaseException;
    List<Book> getBooks() throws DataBaseException;
    Book getBookById(int id) throws DataBaseException;
    Book getBookByISBN(String isbn);
    Book getBookByTitle(String title);
    void removeBook(int id) throws DataBaseException;
    void updateBookPrice(int id, double price);
}
