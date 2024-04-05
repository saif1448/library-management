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
public class Member {

    @Id
    private int memberId;
    private String name;
    private String address;
    private String memberType;
    private Timestamp membDate;
    private Timestamp expriryDate;
}
