package com.example.librarymanagement.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.librarymanagement.models.auth.User;
import java.util.Optional;


public interface UserRepository extends ReactiveMongoRepository<User, String> {

    Optional<User> findByEmail(String email);

}
