package com.example.even.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@Getter
@Builder
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberId;

    private String name;

    private String phoneNumber;

    private String email;

    private String password;

    // 결제 관련
    private Integer point;

    // 경험치
    private Integer exp;
}
