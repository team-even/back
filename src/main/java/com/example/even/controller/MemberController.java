package com.example.even.controller;

import com.example.even.domain.Member;
import com.example.even.dto.MemberRequestDto;
import com.example.even.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    // mypage member 불러오기
    @GetMapping("{/memberId}")
    public MemberRequestDto.mypage getMypageBymemberId(@PathVariable(name = "memberId") Long memberId ){
        Member member = memberService.getMypageBymemberId(memberId);
        return MemberRequestDto.mypage.builder()
                .name(member.getName())
                .email(member.getEmail())
                .phoneNumber(member.getPhoneNumber())
                .point(member.getPoint())
                .exp(member.getExp())
                .build();
    }

}
