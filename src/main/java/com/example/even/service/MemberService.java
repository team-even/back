package com.example.even.service;

import com.example.even.domain.Member;
import com.example.even.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    //로그인
    public Member login(Long memberId, String password) {
        return  memberRepository.findById(memberId).filter(member -> member.getPassword().equals(password))
                .orElseThrow(() -> new IllegalStateException("아이디 또는 비밀번호가 올바르지 않습니다."));
    }

    //회원가입
    public Long join(Member member) {
        validateMember(member);
        memberRepository.save(member); //사용자 저장
        return member.getMemberId();

    }
    //회원가입 시 id 중복 확인
    private void validateMember(Member member) {
        memberRepository.findById(member.getMemberId()).ifPresent(m ->{
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        });
    }


}
