package com.sustav.spring.controller;

import com.sustav.spring.model.Book;
import com.sustav.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(path = "/api/book")
    public ResponseEntity<List<Book>> list() {
        List<Book> list = bookService.list();

        return ResponseEntity.ok().body(list);
    }
}
