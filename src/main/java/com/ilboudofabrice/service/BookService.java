package com.ilboudofabrice.service;

import com.ilboudofabrice.domain.Book;
import com.ilboudofabrice.util.DataBaseException;

import java.util.List;

/**
 * Created by fabrice on 2017-02-07.
 */
public interface BookService {
    List<Book> getBookStore() throws DataBaseException;

    void addBook(String isbn, String title, String author, String editor, double price, String details);

    void addBook(Book book) throws DataBaseException;

    void removeBook(int id) throws DataBaseException;

    void clearBookStore();

    Book findBookById(int id) throws DataBaseException;

    Book findBookByISBN(String isbn);

    Book findBookByTitle(String title);

}
