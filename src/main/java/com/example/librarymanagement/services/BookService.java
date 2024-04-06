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

    public Mono<?> getById(int id) {
        return bookRepository.findById(id);
    }

    public Mono<?> modifyBookById(int id, BookDto bookDto) {
        return bookRepository.findById(id)
                // .switchIfEmpty(Mono.error(new Throwable("Book not found for id: " + id)))
                .flatMap(book -> {
                    if (book != null) {
                        if (bookDto.getPub() != null) {
                            book.setPubId(bookDto.getPub());
                        }
                        if (bookDto.getBook_name() != null) {
                            book.setTitle(bookDto.getBook_name());
                        }
                        if (bookDto.getPrice() != null) {
                            book.setPrice(bookDto.getPrice());
                        }
                        if (bookDto.getPresence() != null) {
                            book.setAvailable(bookDto.getPresence());
                        }
                        if (bookDto.getWriter() != null) {
                            book.setAuthor(bookDto.getWriter());
                        }
                        return bookRepository.save(book);
                    } else {
                        return getById(id);
                    }

                });
    }

    public Mono<?> removeBookById(int id) {

        return bookRepository.deleteById(id);

    }

}
