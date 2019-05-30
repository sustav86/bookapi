package com.sustav.spring.controller;

import com.sustav.spring.model.Book;
import com.sustav.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(path = "/book")
    public ResponseEntity<List<Book>> list() {
        List<Book> list = bookService.list();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(path = "/book/{id}")
    public ResponseEntity<Book> list(@PathVariable Long id) {
        Book book = bookService.get(id);

        return ResponseEntity.ok().body(book);
    }

    @PostMapping(path = "/book")
    public ResponseEntity<Book> save(@RequestBody Book book) {
        bookService.save(book);

        return ResponseEntity.ok().body(book);
    }

    @PutMapping(path = "/book/{id}")
    public ResponseEntity<Book> update(@PathVariable long id, @RequestBody Book book) {
        bookService.update(id, book);

        return ResponseEntity.ok().body(book);
    }

    @DeleteMapping(path = "/book/{id}")
    public ResponseEntity<?> save(@PathVariable long id) {
        bookService.delete(id);

        return ResponseEntity.ok().body("Delete book with id: " + id);
    }
}
