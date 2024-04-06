package com.example.librarymanagement.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto {

    private Integer pub;
    private String book_name;
    private String writer;
    private Double price;
    private Boolean presence;

}
