package com.example.librarymanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.librarymanagement.models.BorrowedBy;
import com.example.librarymanagement.models.DTO.BorrowdByDto;
import com.example.librarymanagement.repositories.BorrowdByRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BorrowedByService {

    @Autowired
    BorrowdByRepository borrowdByRepository;

    public Mono<?> saveBorrowedBy(BorrowedBy borrowedBy) {
        return borrowdByRepository.save(borrowedBy);
    }

    public Flux<?> getAll() {
        return borrowdByRepository.findAll();
    }

    public Mono<?> getById(String id) {
        return borrowdByRepository.findById(id);
    }

    public Mono<?> modifyBorrowedById(String id, BorrowdByDto borrowedDto) {
        return borrowdByRepository.findById(id)
                // .switchIfEmpty(Mono.error(new Throwable("Book not found for id: " + id)))
                .flatMap(borrow -> {
                    if (borrow != null) {
                        if (borrowedDto.getMemberId() != null) {
                            borrow.setMemberId(borrowedDto.getMemberId());
                        }
                        if (borrowedDto.getBookId() != null) {
                            borrow.setBookId(borrowedDto.getBookId());
                        }
                        if (borrowedDto.getDueDate() != null) {
                            borrow.setDueDate(borrowedDto.getDueDate());
                        }
                        if (borrowedDto.getReturnDate() != null) {
                            borrow.setReturnDate(borrowedDto.getReturnDate());
                        }
                        if (borrowedDto.getIssue() != null) {
                            borrow.setIssue(borrowedDto.getIssue());
                        }
                        return borrowdByRepository.save(borrow);
                    } else {
                        return getById(id);
                    }

                });
    }

    public Mono<?> removeBorrowedById(String id) {

        return borrowdByRepository.deleteById(id);

    }

}
