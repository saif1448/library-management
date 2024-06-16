package com.example.librarymanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.librarymanagement.models.Member;
import com.example.librarymanagement.models.DTO.MemberDto;
import com.example.librarymanagement.repositories.MemberRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public Mono<?> saveMember(Member member) {
        return memberRepository.save(member);
    }

    public Flux<?> getAll() {
        return memberRepository.findAll();
    }

    public Mono<?> getById(String id) {
        return memberRepository.findById(id);
    }

    public Mono<?> modifyMemberById(String id, MemberDto memberDto) {
        return memberRepository.findById(id)
                // .switchIfEmpty(Mono.error(new Throwable("Book not found for id: " + id)))
                .flatMap(member -> {
                    if (member != null) {
                        if (memberDto.getName() != null) {
                            member.setName(memberDto.getName());
                        }
                        if (memberDto.getMemberType() != null) {
                            member.setMemberType(memberDto.getMemberType());
                        }
                        if (memberDto.getMembDate() != null) {
                            member.setMembDate(memberDto.getMembDate());
                        }
                        if (memberDto.getExpriryDate() != null) {
                            member.setExpriryDate(memberDto.getExpriryDate());
                        }
                        if (memberDto.getAddress() != null) {
                            member.setAddress(memberDto.getAddress());
                        }
                        return memberRepository.save(member);
                    } else {
                        return getById(id);
                    }

                });
    }

    public Mono<?> removeMemberById(String id) {

        return memberRepository.deleteById(id);

    }

}
