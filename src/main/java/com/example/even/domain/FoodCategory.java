package com.example.even.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FoodCategory {
    NORMAL(1),
    LOCAL_FOOD(2);

    private final int code;
}
