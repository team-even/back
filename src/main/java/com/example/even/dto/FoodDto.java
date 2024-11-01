package com.example.even.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class FoodDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FoodInfo {
        private Long foodId;
        private String foodName;
        private Integer price;
        private Float discountRate;
        private String foodImageUrl;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FoodInfoHistory {
        private Long foodId;
        private String foodName;
        private Integer price;
        private String foodImageUrl;
    }
}
