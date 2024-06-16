package com.example.librarymanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.librarymanagement.models.Book;
import com.example.librarymanagement.models.BorrowedBy;
import com.example.librarymanagement.models.DTO.BookDto;
import com.example.librarymanagement.models.DTO.BorrowdByDto;
import com.example.librarymanagement.services.BorrowedByService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/borrow")
public class BorrwoedByController {

    @Autowired
    BorrowedByService borrowedByService;

    @PostMapping("/create")
    public Mono<?> createBorrowedBy(@RequestBody BorrowedBy borrowedBy) {
        return borrowedByService.saveBorrowedBy(borrowedBy);
    }

    @GetMapping("/get-all")
    public Flux<?> getAllBorrowedBy() {
        return borrowedByService.getAll();
    }

    @GetMapping("/get/{id}")
    public Mono<?> getBorrowedById(@PathVariable String id) {
        return borrowedByService.getById(id);
    }

    @PutMapping("/update/{id}")
    public Mono<?> updateBorrowedById(@PathVariable String id, @RequestBody BorrowdByDto borrowedBytDto) {
        return borrowedByService.modifyBorrowedById(id, borrowedBytDto);

    }

    @DeleteMapping("/delete/{id}")
    public Mono<?> deleteBorrowedById(@PathVariable String id) {
        return borrowedByService.removeBorrowedById(id);
    }

}
