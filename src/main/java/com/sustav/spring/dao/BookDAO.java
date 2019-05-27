package com.sustav.spring.dao;

import com.sustav.spring.model.Book;

import java.util.List;

public interface BookDAO {

    long save(Book book);

    Book get(long id);

    List list();

    void update(long id, Book book);

    void delete(long id);
}
