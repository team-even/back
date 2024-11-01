package com.example.even.repository;

import com.example.even.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    default Member safeFindById(Long memberId) {
        return findById(memberId)
                .orElseThrow();
    }
}
