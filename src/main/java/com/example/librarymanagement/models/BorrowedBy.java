package com.example.librarymanagement.models;

import java.sql.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class BorrowedBy {

    @Id
    private int memberId;
    private int bookId;
    private Timestamp dueDate;
    private Timestamp returnDate;
    private String issue;
}
