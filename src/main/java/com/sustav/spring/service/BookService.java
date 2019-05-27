package com.sustav.spring.service;

import com.sustav.spring.model.Book;

import java.util.List;

public interface BookService {

    long save(Book book);

    Book get(long id);

    List list();

    void update(long id, Book book);

    void delete(long id);
}
