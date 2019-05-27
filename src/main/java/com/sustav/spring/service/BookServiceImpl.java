package com.sustav.spring.service;

import com.sustav.spring.dao.BookDAO;
import com.sustav.spring.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public long save(Book book) {
        return 0;
    }

    @Override
    public Book get(long id) {
        return null;
    }

    @Override
    @Transactional
    public List list() {
        return bookDAO.list();
    }

    @Override
    public void update(long id, Book book) {

    }

    @Override
    public void delete(long id) {

    }
}
