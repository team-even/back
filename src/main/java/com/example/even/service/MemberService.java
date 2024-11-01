package com.example.even.service;

import com.example.even.domain.Member;
import com.example.even.dto.MemberRequestDto;
import com.example.even.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    //로그인
    public Long login(MemberRequestDto.Login loginDto) throws Exception {
        Member member = memberRepository.findByEmail(loginDto.getEmail());

        if (member.getPassword().equals(loginDto.getPassword())) {
            return member.getMemberId();
        } else {
            throw new Exception("로그인 실패, 이메일 혹은 비밀번호가 틀립니다.");
        }

//        return  memberRepository.findById(memberId).filter(member -> member.getPassword().equals(password))
//                .orElseThrow(() -> new IllegalStateException("아이디 또는 비밀번호가 올바르지 않습니다."));
    }

    //회원가입
    public Long join(MemberRequestDto.Join joinDto) {
        Member member = Member.builder()
                .email(joinDto.getEmail())
                .password(joinDto.getPassword())
                .phoneNumber(joinDto.getPhoneNumber())
                .name(joinDto.getNickname())
                .build();

        memberRepository.save(member); //사용자 저장
        return member.getMemberId();
    }

    //회원가입 시 id 중복 확인
    private void validateMember(Member member) {
        memberRepository.findById(member.getMemberId()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        });
    }

    //회원 별 주문 수
    public int getOrderCount(Long memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        if(member.isPresent()) {
            Member member1 = member.get();
            return member1.getOrders().size(); //주문 목록의 크기 반환
        }
        return 0;
    }
}
