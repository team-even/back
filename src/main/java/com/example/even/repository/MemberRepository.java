package com.example.even.repository;

import com.example.even.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findMemberByMemberId(@Param("memberId")Long memberId);
}
