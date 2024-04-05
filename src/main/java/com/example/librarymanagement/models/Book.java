package com.example.librarymanagement.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Book {

    @Id
    private int bookId;
    private int pubId;
    private String title;
    private String author;
    private double price;
    private boolean available;

}
