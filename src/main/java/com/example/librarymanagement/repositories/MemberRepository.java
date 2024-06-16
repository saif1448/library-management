package com.example.librarymanagement.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.librarymanagement.models.Member;

public interface MemberRepository extends ReactiveMongoRepository<Member, String> {

}
