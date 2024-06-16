package com.example.librarymanagement.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.librarymanagement.models.BorrowedBy;

public interface BorrowdByRepository extends ReactiveMongoRepository<BorrowedBy, String> {

}
