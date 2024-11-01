package com.example.even.repository;

import com.example.even.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {


    default Member safeFindById(Long memberId) throws Exception {
        return findById(memberId)
                .orElseThrow(() -> new Exception("존재하지 않는 사용자입니다."));
    }

    Member findByEmail(String email);

    //회원가입 시 id로 사용자 정보 조회
    Optional<Member> findById(Long memberId);

    Optional<Member> findByName(String name);
}
