package com.example.librarymanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.librarymanagement.models.Book;
import com.example.librarymanagement.repositories.BookRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Mono<?> saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Flux<?> getAll() {
        return bookRepository.findAll();
    }

}
