package com.example.even.dto;

import com.example.even.dto.FoodDto.FoodInfoHistory;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class OrderDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Setter
    public static class OrderRequest {
        private Long memberId;
        private Long storeId;
        private List<FoodInfo> FoodInfo;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderHistory {
        private Long orderId;
        private String orderCategory;
        private List<FoodInfoHistory> foodInfoHistoryList;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Setter
    public static class FoodInfo {
        private Long foodId;
        private Integer quantity;
    }
}
