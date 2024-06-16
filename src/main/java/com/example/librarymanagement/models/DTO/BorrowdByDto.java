package com.example.librarymanagement.models.DTO;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BorrowdByDto {

    private String id;
    private String memberId;
    private String bookId;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dueDate;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate returnDate;
    private String issue;
}
