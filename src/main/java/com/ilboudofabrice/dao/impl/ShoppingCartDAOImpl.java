package com.ilboudofabrice.dao.impl;

import com.ilboudofabrice.dao.ShoppingCartDAO;
import com.ilboudofabrice.domain.Book;
import com.ilboudofabrice.domain.ShoppingCartItem;
import com.ilboudofabrice.util.DataBaseException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by fabrice on 2017-02-12.
 */
public class ShoppingCartDAOImpl implements ShoppingCartDAO{
    private SessionFactory sessionFactory;

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

    public void addItem(Book book) {
        try
        {
            String hql = "from " + ShoppingCartItem.class.getName() + " where bookFK = :bookId";
            Query q = getCurrentSession().createQuery(hql).setParameter("bookId", book.getId());
            ShoppingCartItem object = (ShoppingCartItem) q.uniqueResult();
            if(object == null)
            {
                ShoppingCartItem item = new ShoppingCartItem(book.getId(),1);
                getCurrentSession().save(item);
            }
            else
            {
                object.setQuantity(object.getQuantity() + 1);
                getCurrentSession().update(object);
            }
        }
        catch (DataBaseException e)
        {
            e.printStackTrace();
        }
    }

    public void removeItem(int id) throws DataBaseException {
        String hql = "delete " + ShoppingCartItem.class.getName() + " where id = :id";
        Query q = getCurrentSession().createQuery(hql).setParameter("id", id);
        q.executeUpdate();
    }

    public List<ShoppingCartItem> getItems() throws DataBaseException {
        return getCurrentSession().createQuery("from ShoppingCartItem").list();
    }

    public void updateItemQuantity(int id, int quantity) throws DataBaseException {
        ShoppingCartItem shoppingCartItem = getCurrentSession().find(ShoppingCartItem.class, id);
        if(shoppingCartItem != null)
        {
            shoppingCartItem.setQuantity(quantity);
            getCurrentSession().update(shoppingCartItem);
        }
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
