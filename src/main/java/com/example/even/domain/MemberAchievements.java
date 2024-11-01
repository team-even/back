package com.example.even.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberAchievements {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long member_achievement_id;

    private Long member_id;

    private Integer achievement_id;
}
