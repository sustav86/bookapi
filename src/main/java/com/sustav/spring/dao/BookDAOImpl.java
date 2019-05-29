package com.sustav.spring.dao;

import com.sustav.spring.model.Book;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long save(Book book) {
        sessionFactory.getCurrentSession().save(book);

        return book.getId();
    }

    @Override
    public Book get(long id) {
//        Book book = sessionFactory.getCurrentSession().createQuery("from book b where b.id = :id", Book.class).setParameter("id", id).getSingleResult();
//        Query<Book> query = sessionFactory.getCurrentSession().createQuery("from book b where b.id = :id", Book.class);
//        query.setParameter("id", id);
//        Book book = query.getResultList().stream().findFirst().orElse(null);

        return sessionFactory.getCurrentSession().get(Book.class, id, LockMode.OPTIMISTIC);
    }

    @Override
    public List<Book> list() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Book> from_book = currentSession.createQuery("from book", Book.class);

        return from_book.list();
    }

    @Override
    public void update(long id, Book book) {

    }

    @Override
    public void delete(long id) {

    }
}
