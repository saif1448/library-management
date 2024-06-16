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

import com.example.librarymanagement.models.BorrowedBy;
import com.example.librarymanagement.models.Member;
import com.example.librarymanagement.models.DTO.BorrowdByDto;
import com.example.librarymanagement.models.DTO.MemberDto;
import com.example.librarymanagement.services.BorrowedByService;
import com.example.librarymanagement.services.MemberService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping("/create")
    public Mono<?> createMember(@RequestBody Member member) {
        return memberService.saveMember(member);
    }

    @GetMapping("/get-all")
    public Flux<?> getAllBorrowedBy() {
        return memberService.getAll();
    }

    @GetMapping("/get/{id}")
    public Mono<?> getMemberById(@PathVariable String id) {
        return memberService.getById(id);
    }

    @PutMapping("/update/{id}")
    public Mono<?> updateMemberById(@PathVariable String id, @RequestBody MemberDto memberDto) {
        return memberService.modifyMemberById(id, memberDto);

    }

    @DeleteMapping("/delete/{id}")
    public Mono<?> deleteBorrowedById(@PathVariable String id) {
        return memberService.removeMemberById(id);
    }

}
