package com.example.even.domain;

import java.util.Arrays;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StoreType {
    ALL("", 0),
    NORMAL("", 1),
    HAS_LOCAL_FOOD("로컬 음식 보유", 2),
    TRADITIONAL_STORE("전통 시장", 3),
    VEGAN("비건", 4);

    private final String name;
    private final int code;
}
