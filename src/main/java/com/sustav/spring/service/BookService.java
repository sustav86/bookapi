package com.sustav.spring.service;

import com.sustav.spring.model.Book;

import java.util.List;

public interface BookService {

    Long save(Book book);

    Book get(long id);

    List list();

    void update(long id, Book book);

    void delete(long id);
}
