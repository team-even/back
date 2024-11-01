package com.example.even.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderCategory {
    DONE("조리 완료",1),
    PROCESSING("조리중",2);

    private final String name;
    private final int code;
}
