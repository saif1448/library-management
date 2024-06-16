package com.example.librarymanagement.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.librarymanagement.models.Publisher;

public interface PublisherRepository extends ReactiveMongoRepository<Publisher, String> {

}
