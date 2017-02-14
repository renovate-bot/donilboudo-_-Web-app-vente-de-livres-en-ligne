package com.ilboudofabrice.dao.impl;

import com.ilboudofabrice.dao.BookDAO;
import com.ilboudofabrice.domain.Book;
import com.ilboudofabrice.util.DataBaseException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fabrice on 2017-02-09.
 */

@Repository
public class BookDAOImpl implements BookDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    private Session getCurrentSession() throws DataBaseException {
        Session session;
        try
        {
            session = sessionFactory.getCurrentSession();
        }
        catch (HibernateException e)
        {
            session = sessionFactory.openSession();
        }

        return session;
    }

    public void addBook(Book book) throws DataBaseException {
        getCurrentSession().save(book);
    }

    public List<Book> getBooks() throws DataBaseException {
        return getCurrentSession().createQuery("from Book").list();
    }

    public Book getBookById(int id) throws DataBaseException {
       return getCurrentSession().load(Book.class, id);
    }

    public Book getBookByISBN(String isbn) {
        return null;
    }

    public Book getBookByTitle(String title) {
        return null;
    }

    public void removeBook(int id) throws DataBaseException {
        Book p = getCurrentSession().load(Book.class, id);
        if(null != p)
        {
            getCurrentSession().delete(p);
        }
    }

    public void updateBookPrice(int id, double price) {

    }
}
