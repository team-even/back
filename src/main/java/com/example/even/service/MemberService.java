package com.example.even.service;

import com.example.even.domain.Member;
import com.example.even.dto.MemberRequestDto.mypage;
import com.example.even.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private  final MemberRepository memberRepository;
    public Member getMypageBymemberId(Long memberId) {
        return memberRepository.findMemberByMemberId(memberId);
    }

//    public Long login() {
//
//    }
//
//    public Long join() {
//
//    }
}
