package com.example.librarymanagement.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.librarymanagement.models.Book;
import com.example.librarymanagement.models.ResponseObject;
import com.example.librarymanagement.models.DTO.BookDto;
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

    public Mono<?> getById(String id) {
        return bookRepository.findById(id);
    }

    public Mono<?> modifyBookById(String id, BookDto bookDto) {
        return bookRepository.findById(id)
                // .switchIfEmpty(Mono.error(new Throwable("Book not found for id: " + id)))
                .flatMap(book -> {
                    if (book != null) {
                        if (bookDto.getPubId() != null) {
                            book.setPubId(bookDto.getPubId());
                        }
                        if (bookDto.getTitle() != null) {
                            book.setTitle(bookDto.getTitle());
                        }
                        if (bookDto.getPrice() != null) {
                            book.setPrice(bookDto.getPrice());
                        }
                        if (bookDto.getAvailable() != null) {
                            book.setAvailable(bookDto.getAvailable());
                        }
                        if (bookDto.getAuthor() != null) {
                            book.setAuthor(bookDto.getAuthor());
                        }
                        return bookRepository.save(book);
                    } else {
                        return getById(id);
                    }

                });
    }

    public Mono<?> removeBookById(String id) {

        return bookRepository.deleteById(id);

    }

}
