package com.example.librarymanagement.models.DTO;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {

    private String name;
    private String address;
    private String memberType;
    private String membDate;
    private String expriryDate;

}
