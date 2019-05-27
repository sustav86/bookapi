package com.sustav.spring.dao;

import com.sustav.spring.model.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long save(Book book) {
        return 0;
    }

    @Override
    public Book get(long id) {
        return null;
    }

    @Override
    public List<Book> list() {
        return sessionFactory.getCurrentSession().createQuery("from Book", Book.class).list();
    }

    @Override
    public void update(long id, Book book) {

    }

    @Override
    public void delete(long id) {

    }
}
