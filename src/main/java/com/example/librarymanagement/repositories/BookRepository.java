package com.example.librarymanagement.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.librarymanagement.models.Book;

@Repository
public interface BookRepository extends ReactiveMongoRepository<Book, Integer> {

}
