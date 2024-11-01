package com.example.even.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StoreCategory {
    NORMAL("", 1),
    HAS_LOCAL_FOOD("부산 로컬 음식", 2),
    TRADITIONAL_STORE("전통 시장", 3);

    private final String toString;
    private final int code;
}
