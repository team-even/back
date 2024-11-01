package com.example.even.repository;

import com.example.even.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    default Member safeFindById(Long memberId) {
        return findById(memberId)
                .orElseThrow();
    }


    //회원가입 시 id로 사용자 정보 조회
    Optional<Member> findById(Long memberId);
    Optional<Member> findByName(String name);
}
