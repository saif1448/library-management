package com.example.librarymanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.librarymanagement.models.Book;
import com.example.librarymanagement.models.DTO.BookDto;
import com.example.librarymanagement.services.BookService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/create")
    public Mono<?> createBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping("/get-all")
    public Flux<?> getAllBook() {
        return bookService.getAll();
    }

    @GetMapping("/get/{id}")
    public Mono<?> getBookById(@PathVariable int id) {
        return bookService.getById(id);
    }

    @PutMapping("/update/{id}")
    public Mono<?> updateBookById(@PathVariable int id, @RequestBody BookDto bookDto){
        return bookService.modifyBookById(id, bookDto);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<?> deleteBookById(@PathVariable int id){
        return bookService.removeBookById(id);
    }

}
