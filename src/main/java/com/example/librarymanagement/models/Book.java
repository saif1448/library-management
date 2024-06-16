package com.example.librarymanagement.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
@JacksonXmlRootElement(localName = "Book")
public class Book {

    @Id
    // @JsonIgnore
    private String id;
    private String pubId;
    private String title;
    private String author;
    private Double price;
    private Boolean available;

}
