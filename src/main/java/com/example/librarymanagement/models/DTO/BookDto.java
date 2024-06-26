package com.example.librarymanagement.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto {

    private String pubId;
    private String title;
    private String author;
    private Double price;
    private Boolean available;

}
